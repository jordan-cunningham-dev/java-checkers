package Graphics;

import GameSetup.CheckerBoard;
import GameSetup.CheckerPiece;
import GameSetup.GameSession;
import RunGame.GameStart;

import java.awt.*;
import javax.swing.JPanel;

public class BadGraphics extends JPanel{

    public void paint(Graphics graphics){

        drawBoard(graphics);
        drawText(graphics);
        drawPieces(graphics);

    }

    private void drawBoard(Graphics graphics){

        // draw outside lines
        graphics.drawLine(50,50,50,450);
        graphics.drawLine(450,50,450,450);
        graphics.drawLine(50,50,450,50);
        graphics.drawLine(50,450,450,450);

        // horizontal lines
        graphics.drawLine(50,100,450,100);
        graphics.drawLine(50,150,450,150);
        graphics.drawLine(50,200,450,200);
        graphics.drawLine(50,250,450,250);
        graphics.drawLine(50,300,450,300);
        graphics.drawLine(50,350,450,350);
        graphics.drawLine(50,400,450,400);

        // vertical lines
        graphics.drawLine(100,50,100,450);
        graphics.drawLine(150,50,150,450);
        graphics.drawLine(200,50,200,450);
        graphics.drawLine(250,50,250,450);
        graphics.drawLine(300,50,300,450);
        graphics.drawLine(350,50,350,450);
        graphics.drawLine(400,50,400,450);

        // draw dark squares
        graphics.setColor(Color.GRAY);
        graphics.fillRect(100, 50, 50, 50);
        graphics.fillRect(200, 50, 50, 50);
        graphics.fillRect(300, 50, 50, 50);
        graphics.fillRect(400, 50, 50, 50);

        graphics.fillRect(50, 100, 50, 50);
        graphics.fillRect(150, 100, 50, 50);
        graphics.fillRect(250, 100, 50, 50);
        graphics.fillRect(350, 100, 50, 50);

        graphics.fillRect(100, 150, 50, 50);
        graphics.fillRect(200, 150, 50, 50);
        graphics.fillRect(300, 150, 50, 50);
        graphics.fillRect(400, 150, 50, 50);

        graphics.fillRect(50, 200, 50, 50);
        graphics.fillRect(150, 200, 50, 50);
        graphics.fillRect(250, 200, 50, 50);
        graphics.fillRect(350, 200, 50, 50);

        graphics.fillRect(100, 250, 50, 50);
        graphics.fillRect(200, 250, 50, 50);
        graphics.fillRect(300, 250, 50, 50);
        graphics.fillRect(400, 250, 50, 50);

        graphics.fillRect(50, 300, 50, 50);
        graphics.fillRect(150, 300, 50, 50);
        graphics.fillRect(250, 300, 50, 50);
        graphics.fillRect(350, 300, 50, 50);

        graphics.fillRect(100, 350, 50, 50);
        graphics.fillRect(200, 350, 50, 50);
        graphics.fillRect(300, 350, 50, 50);
        graphics.fillRect(400, 350, 50, 50);

        graphics.fillRect(50, 400, 50, 50);
        graphics.fillRect(150, 400, 50, 50);
        graphics.fillRect(250, 400, 50, 50);
        graphics.fillRect(350, 400, 50, 50);

    }

    private void drawText(Graphics graphics){

        // draw text
        graphics.drawChars("A".toCharArray(), 0, 1, 30, 80);
        graphics.drawChars("B".toCharArray(), 0, 1, 30, 130);
        graphics.drawChars("C".toCharArray(), 0, 1, 30, 180);
        graphics.drawChars("D".toCharArray(), 0, 1, 30, 230);
        graphics.drawChars("E".toCharArray(), 0, 1, 30, 280);
        graphics.drawChars("F".toCharArray(), 0, 1, 30, 330);
        graphics.drawChars("G".toCharArray(), 0, 1, 30, 380);
        graphics.drawChars("H".toCharArray(), 0, 1, 30, 430);

        graphics.drawChars("1".toCharArray(), 0, 1, 70, 40);
        graphics.drawChars("2".toCharArray(), 0, 1, 120, 40);
        graphics.drawChars("3".toCharArray(), 0, 1, 170, 40);
        graphics.drawChars("4".toCharArray(), 0, 1, 220, 40);
        graphics.drawChars("5".toCharArray(), 0, 1, 270, 40);
        graphics.drawChars("6".toCharArray(), 0, 1, 320, 40);
        graphics.drawChars("7".toCharArray(), 0, 1, 370, 40);
        graphics.drawChars("8".toCharArray(), 0, 1, 420, 40);

        // team text
        graphics.setFont(new Font("ComicSans", Font.PLAIN, 24));
        graphics.setColor(Color.BLUE);
        graphics.drawString("Team Two", 500, 125);
        graphics.drawString(new Integer(GameStart.getGameSession().getTeamTwoPieces()).toString(), 545, 155);
        graphics.setColor(Color.RED);
        graphics.drawString("Team One", 500, 375);
        graphics.drawString(new Integer(GameStart.getGameSession().getTeamOnePieces()).toString(), 545, 405);

        // error text
        graphics.setFont(new Font("ComicSans", Font.PLAIN, 14));
        graphics.setColor(Color.RED);
        graphics.drawString(GameStart.getGameSession().getErrorMessage(), 25, 500);

    }

    private void drawPieces(Graphics graphics){

        GameSession gameSession = GameStart.getGameSession();
        CheckerBoard checkerBoard = gameSession.getCheckerBoard();

        // draw pieces
        //TODO: optimize...don't need to check every space every redraw
        //TODO: or maybe you do...dansgame
        for(int i = 0; i < checkerBoard.getBoardSquares().length; i++){

            for(int j = 0; j < checkerBoard.getBoardSquares()[0].length; j++){

                if(checkerBoard.getBoardSquare(i, j) != null && checkerBoard.getBoardSquare(i, j).getPiece() != null){

                    if(checkerBoard.getBoardSquare(i, j).getPiece().getTeam() == CheckerPiece.Team.TEAM_ONE)
                        graphics.setColor(Color.RED);
                    else
                        graphics.setColor(Color.BLACK);

                    graphics.fillOval((i+1) * 50 + 2, (j+1) * 50 + 2, 45, 45);

                }

                if(checkerBoard.getBoardSquare(i, j).getPiece() != null && gameSession.getCurrentSelected() != null && checkerBoard.getBoardSquare(i, j).getPiece().equals(gameSession.getCurrentSelected())){

                    graphics.setColor(Color.GREEN);
                    graphics.fillOval((i+1) * 50 + 2, (j+1) * 50 + 2, 45, 45);

                }

            }

        }

    }

}
