package RunGame;

import GameSetup.GameSession;
import Graphics.BadGraphics;
import Graphics.BoardGraphic;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class GameStart {

    private static GameSession gameSession;

    public static void main(String[] args){


        gameSetup();
        playGame();


    }

    // sets up game (board, pieces, players...)
    private static void gameSetup(){

        gameSession = new GameSession();

    }

    // plays game through GameSession api
    private static void playGame(){

        BoardGraphic boardGraphic = new BoardGraphic(new BadGraphics());

    }

    public static GameSession getGameSession() {
        return gameSession;
    }

    public static void setGameSession(GameSession gameSession) {
        GameStart.gameSession = gameSession;
    }

}
