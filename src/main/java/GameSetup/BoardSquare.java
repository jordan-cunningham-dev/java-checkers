package GameSetup;

public class BoardSquare {

    // current piece on the square (if any)
    CheckerPiece piece;

    // location of the square on the board
    int xCoordinate;
    int yCoordinate;

    BoardSquare(){}

    // standard getters and setters
    public CheckerPiece getPiece() { return piece; }

    public void setPiece(CheckerPiece piece) {
        this.piece = piece;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

}
