package GameSetup;

public class CheckerBoard {

    // board is an array of BoardSquares
    private BoardSquare[][] boardSquares;

    CheckerBoard(){

        // generate new board
        boardSquares = new BoardSquare[8][8];

    }

    // get a particular square from the board
    public BoardSquare getBoardSquare(int xCoordinate, int yCoordinate){

        if(xCoordinate > 7 || yCoordinate > 7 || xCoordinate < 0 || yCoordinate < 0)
            return null;

        return boardSquares[xCoordinate][yCoordinate];

    }

    // set piece on a board square
    public void setBoardSquare(int xCoordinate, int yCoordinate, CheckerPiece piece){

        boardSquares[xCoordinate][yCoordinate] = new BoardSquare();

        boardSquares[xCoordinate][yCoordinate].setPiece(piece);

        boardSquares[xCoordinate][yCoordinate].setxCoordinate(xCoordinate);

        boardSquares[xCoordinate][yCoordinate].setyCoordinate(yCoordinate);

    }

    public BoardSquare[][] getBoardSquares() {
        return boardSquares;
    }

    public void setBoardSquares(BoardSquare[][] boardSquares) {
        this.boardSquares = boardSquares;
    }

}
