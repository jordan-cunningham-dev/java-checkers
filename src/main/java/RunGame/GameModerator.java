package RunGame;

import GameSetup.CheckerBoard;
import GameSetup.CheckerPiece;
import GameSetup.GameSession;
import Graphics.BoardGraphic;
import Movement.Coordinates;

public class GameModerator {

    public static boolean validateMove(Coordinates startCoordinates, Coordinates endCoordinates){

        System.out.println("Inside validateMove");

        GameSession gameSession = GameStart.getGameSession();

        CheckerBoard checkerBoard = gameSession.getCheckerBoard();

        // User is trying to move to a space that has a piece in it already
        if(checkerBoard.getBoardSquare(endCoordinates.getxCoordinate(), endCoordinates.getyCoordinate()).getPiece() != null) {
            GameStart.getGameSession().setErrorMessage("That space has a piece in it already");
            BoardGraphic.checkersInterface.repaint();
            return false;
        }

        // User is attempting to move vertically or horizontally
        if(Math.abs(startCoordinates.getxCoordinate() - endCoordinates.getxCoordinate()) == 0 ||
                Math.abs(startCoordinates.getyCoordinate() - endCoordinates.getyCoordinate()) == 0){
            GameStart.getGameSession().setErrorMessage("Pieces may only move diagonally");
            BoardGraphic.checkersInterface.repaint();
            return false;
        }

        // User is attempting to move non-diagonally
        if(Math.abs(startCoordinates.getxCoordinate() - endCoordinates.getxCoordinate()) - Math.abs(startCoordinates.getyCoordinate() - endCoordinates.getyCoordinate()) != 0){
//            System.out.println(Math.abs(startCoordinates.getxCoordinate() - endCoordinates.getxCoordinate()));
//            System.out.println(Math.abs(startCoordinates.getyCoordinate() - endCoordinates.getyCoordinate()));
            GameStart.getGameSession().setErrorMessage("That movement is not allowed");
            BoardGraphic.checkersInterface.repaint();
            return false;
        }

        if(Math.abs(startCoordinates.getxCoordinate() - endCoordinates.getxCoordinate()) > 2 || Math.abs(startCoordinates.getyCoordinate() - endCoordinates.getyCoordinate()) > 2){

            GameStart.getGameSession().setErrorMessage("That movement is not allowed");
            BoardGraphic.checkersInterface.repaint();
            return false;

        }

        performMove(startCoordinates, endCoordinates);

        return true;


    }

    // perform the validated move
    private static void performMove(Coordinates startCoordinates, Coordinates endCoordinates){

        System.out.println("Inside performMove");

        GameSession gameSession = GameStart.getGameSession();

        // User is moving one square only...
        if((Math.abs(startCoordinates.getxCoordinate() - endCoordinates.getxCoordinate())) == 1){

            // Update piece position
            gameSession.getCheckerBoard().getBoardSquare(endCoordinates.getxCoordinate(), endCoordinates.getyCoordinate()).setPiece(gameSession.getCheckerBoard().getBoardSquare(startCoordinates.getxCoordinate(), startCoordinates.getyCoordinate()).getPiece());
            gameSession.getCheckerBoard().getBoardSquare(startCoordinates.getxCoordinate(), startCoordinates.getyCoordinate()).setPiece(null);

            // Update piece coordinates
            gameSession.getCheckerBoard().getBoardSquare(endCoordinates.getxCoordinate(), endCoordinates.getyCoordinate()).getPiece().setxCoordinate(endCoordinates.getxCoordinate());
            gameSession.getCheckerBoard().getBoardSquare(endCoordinates.getxCoordinate(), endCoordinates.getyCoordinate()).getPiece().setyCoordinate(endCoordinates.getyCoordinate());
            gameSession.setCurrentSelected(null);
            gameSession.setErrorMessage("");
            gameSession.switchTeam();

        }
        // User is moving more than one square, indicating an attempted piece take
        else{

            if(validatePieceTake(startCoordinates, endCoordinates)){

                Coordinates pieceTakeCoordinates = getPieceTakeCoordinates(startCoordinates, endCoordinates);

                // Update piece position
                gameSession.getCheckerBoard().getBoardSquare(endCoordinates.getxCoordinate(), endCoordinates.getyCoordinate()).setPiece(gameSession.getCheckerBoard().getBoardSquare(startCoordinates.getxCoordinate(), startCoordinates.getyCoordinate()).getPiece());
                gameSession.getCheckerBoard().getBoardSquare(startCoordinates.getxCoordinate(), startCoordinates.getyCoordinate()).setPiece(null);

                // Update piece coordinates
                gameSession.getCheckerBoard().getBoardSquare(endCoordinates.getxCoordinate(), endCoordinates.getyCoordinate()).getPiece().setxCoordinate(endCoordinates.getxCoordinate());
                gameSession.getCheckerBoard().getBoardSquare(endCoordinates.getxCoordinate(), endCoordinates.getyCoordinate()).getPiece().setyCoordinate(endCoordinates.getyCoordinate());

                // Update taken piece
                gameSession.getCheckerBoard().getBoardSquare(pieceTakeCoordinates.getxCoordinate(), pieceTakeCoordinates.getyCoordinate()).setPiece(null);

                if(gameSession.getCurrentTeam() == CheckerPiece.Team.TEAM_ONE) {
                    gameSession.setTeamTwoPieces(gameSession.getTeamTwoPieces() - 1);
                }
                else {
                    gameSession.setTeamOnePieces(gameSession.getTeamOnePieces() - 1);
                }

                gameSession.setCurrentSelected(null);
                gameSession.setErrorMessage("");
                gameSession.switchTeam();

            }
            else{

                gameSession.setErrorMessage("There's no piece to take");
                BoardGraphic.checkersInterface.repaint();

            }



        }

        GameStart.setGameSession(gameSession);
        BoardGraphic.checkersInterface.repaint();


    }

    // get piece that was clicked && select it if it's the user's piece
    public static void checkClicked(int xCoordinate, int yCoordinate){

        System.out.println("Inside checkClicked");

        // they clicked inside the checkerboard
        if(xCoordinate > 50 && xCoordinate < 450 && yCoordinate > 50 && yCoordinate < 475){

            System.out.println("User clicked inside board");

            Coordinates squareCoordinates = checkClickedPieceCoordinates(xCoordinate, yCoordinate);

            CheckerPiece selectedPiece = GameStart.getGameSession().getCheckerBoard().getBoardSquare(squareCoordinates.getxCoordinate(), squareCoordinates.getyCoordinate()).getPiece();

            System.out.println("Selected piece: " + selectedPiece);

            if(selectedPiece != null) {
                System.out.println("Selected piece team: " + selectedPiece.getTeam());
                System.out.println("Game session current team: " + GameStart.getGameSession().getCurrentTeam());
            }

            if(selectedPiece != null && selectedPiece.getTeam() == GameStart.getGameSession().getCurrentTeam()){

                System.out.println("Piece selected...");

                GameStart.getGameSession().setCurrentSelected(selectedPiece);
                BoardGraphic.checkersInterface.repaint();

            }
            else if(selectedPiece == null && GameStart.getGameSession().getCurrentSelected() != null){

                System.out.println("User is attempting to bust a move...");

                    validateMove(new Coordinates(GameStart.getGameSession().getCurrentSelected().getxCoordinate(), GameStart.getGameSession().getCurrentSelected().getyCoordinate()), new Coordinates(squareCoordinates.getxCoordinate(), squareCoordinates.getyCoordinate()));

            }

        }
        else if(GameStart.getGameSession().getCurrentSelected() != null){

            System.out.println("Setting selected to null...");

            GameStart.getGameSession().setCurrentSelected(null);

            BoardGraphic.checkersInterface.repaint();

        }

    }

    // figure out which square/piece was actually clicked
    private static Coordinates checkClickedPieceCoordinates(int xCoordinate, int yCoordinate){

        System.out.println("Inside checkClickedPieceCoordinates");

        Coordinates clickedSquareCoordinates = new Coordinates();

        if(xCoordinate > 50 && xCoordinate < 100) {
            clickedSquareCoordinates.setxCoordinate(0);
        }
        else if(xCoordinate > 100 && xCoordinate < 150) {
            clickedSquareCoordinates.setxCoordinate(1);
        }
        else if(xCoordinate > 150 && xCoordinate < 200) {
            clickedSquareCoordinates.setxCoordinate(2);
        }
        else if(xCoordinate > 200 && xCoordinate < 250) {
            clickedSquareCoordinates.setxCoordinate(3);
        }
        else if(xCoordinate > 250 && xCoordinate < 300) {
            clickedSquareCoordinates.setxCoordinate(4);
        }
        else if(xCoordinate > 300 && xCoordinate < 350) {
            clickedSquareCoordinates.setxCoordinate(5);
        }
        else if(xCoordinate > 350 && xCoordinate < 400) {
            clickedSquareCoordinates.setxCoordinate(6);
        }
        else if(xCoordinate > 400 && xCoordinate < 450) {
            clickedSquareCoordinates.setxCoordinate(7);
        }

        if(yCoordinate > 75 && yCoordinate < 125) {
            clickedSquareCoordinates.setyCoordinate(0);
        }
        else if(yCoordinate > 125 && yCoordinate < 175) {
            clickedSquareCoordinates.setyCoordinate(1);
        }
        else if(yCoordinate > 175 && yCoordinate < 225) {
            clickedSquareCoordinates.setyCoordinate(2);
        }
        else if(yCoordinate > 225 && yCoordinate < 275) {
            clickedSquareCoordinates.setyCoordinate(3);
        }
        else if(yCoordinate > 275 && yCoordinate < 325) {
            clickedSquareCoordinates.setyCoordinate(4);
        }
        else if(yCoordinate > 325 && yCoordinate < 375) {
            clickedSquareCoordinates.setyCoordinate(5);
        }
        else if(yCoordinate > 375 && yCoordinate < 425) {
            clickedSquareCoordinates.setyCoordinate(6);
        }
        else if(yCoordinate > 425 && yCoordinate < 475) {
            clickedSquareCoordinates.setyCoordinate(7);
        }

        return clickedSquareCoordinates;

    }

    // validates an attempted piece take
    private static boolean validatePieceTake(Coordinates startCoordinates, Coordinates endCoordinates){

        GameSession gameSession = GameStart.getGameSession();

        Coordinates pieceToBeTakenCoordinates = getPieceTakeCoordinates(startCoordinates, endCoordinates);

        CheckerPiece pieceToBeTaken = gameSession.getCheckerBoard().getBoardSquare(pieceToBeTakenCoordinates.getxCoordinate(), pieceToBeTakenCoordinates.getyCoordinate()).getPiece();

        boolean isValidPieceTake = false;

        if(pieceToBeTaken != null && pieceToBeTaken.getTeam() != gameSession.getCurrentTeam())
            isValidPieceTake = true;


        return isValidPieceTake;

    }

    // returns the coordinates of the piece to be taken
    private static Coordinates getPieceTakeCoordinates(Coordinates startCoordinates, Coordinates endCoordinates){

        Coordinates pieceToBeTakenCoordinates = new Coordinates();

        if((endCoordinates.getxCoordinate() - startCoordinates.getxCoordinate()) > 0)
            pieceToBeTakenCoordinates.setxCoordinate(endCoordinates.getxCoordinate() - 1);
        else
            pieceToBeTakenCoordinates.setxCoordinate(endCoordinates.getxCoordinate() + 1);

        if((endCoordinates.getyCoordinate() - startCoordinates.getyCoordinate()) > 0)
            pieceToBeTakenCoordinates.setyCoordinate(endCoordinates.getyCoordinate() - 1);
        else
            pieceToBeTakenCoordinates.setyCoordinate(endCoordinates.getyCoordinate() + 1);

        return pieceToBeTakenCoordinates;

    }

}
