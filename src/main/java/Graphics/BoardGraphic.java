package Graphics;

import GameSetup.GameSession;
import RunGame.GameModerator;
import RunGame.GameStart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardGraphic {

    public static JFrame checkersInterface;

    public BoardGraphic(BadGraphics badGraphics){

        GameSession gameSession = GameStart.getGameSession();

        // Literally stole this straight from the internet
        checkersInterface = new JFrame();

        checkersInterface.setSize(700, 600);

        setupMouseListener();

        checkersInterface.getContentPane().add(badGraphics);

        checkersInterface.setVisible(true);

        checkersInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        checkersInterface.setResizable(true);

    }

    private void setupMouseListener(){

        checkersInterface.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println("Mouse clicked");
                GameModerator.checkClicked(e.getX(), e.getY());

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}
