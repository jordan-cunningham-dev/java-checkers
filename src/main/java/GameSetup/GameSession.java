package GameSetup;

public class GameSession {

    private CheckerBoard checkerBoard;
    private static CheckerPiece.Team currentTeam;
    private int teamOnePieces;
    private int teamTwoPieces;
    private CheckerPiece currentSelected;
    private String errorMessage;

    public GameSession(){

        // create new board instance
        checkerBoard = new CheckerBoard();

        // set current team
        currentTeam = CheckerPiece.Team.TEAM_ONE;

        //give players pieces
        teamOnePieces = 12;
        teamTwoPieces = 12;

        // Initialize the error message
        errorMessage = "";

        //intialize all board squares to null
        for(int i = 0; i < checkerBoard.getBoardSquares().length; i++){

            for(int j = 0; j < checkerBoard.getBoardSquares()[0].length; j++){


                checkerBoard.setBoardSquare(i, j, null);

            }

        }

        // generate all pieces for both teams and place them on the board
        checkerBoard.setBoardSquare(0, 5, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 0, 5));
        checkerBoard.setBoardSquare(0, 7, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 0, 7));
        checkerBoard.setBoardSquare(1, 6, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 1, 6));
        checkerBoard.setBoardSquare(2, 5, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 2, 5));
        checkerBoard.setBoardSquare(2, 7, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 2, 7));
        checkerBoard.setBoardSquare(3, 6, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 3, 6));
        checkerBoard.setBoardSquare(4, 5, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 4, 5));
        checkerBoard.setBoardSquare(4, 7, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 4, 7));
        checkerBoard.setBoardSquare(5, 6, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 5, 6));
        checkerBoard.setBoardSquare(6, 5, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 6, 5));
        checkerBoard.setBoardSquare(6, 7, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 6, 7));
        checkerBoard.setBoardSquare(7, 6, new CheckerPiece(CheckerPiece.Team.TEAM_ONE, 7, 6));

        checkerBoard.setBoardSquare(0, 1, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 0, 1));
        checkerBoard.setBoardSquare(1, 0, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 1, 0));
        checkerBoard.setBoardSquare(1, 2, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 1, 2));
        checkerBoard.setBoardSquare(2, 1, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 2, 1));
        checkerBoard.setBoardSquare(3, 0, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 3, 0));
        checkerBoard.setBoardSquare(3, 2, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 3, 2));
        checkerBoard.setBoardSquare(4, 1, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 4, 1));
        checkerBoard.setBoardSquare(5, 0, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 5, 0));
        checkerBoard.setBoardSquare(5, 2, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 5, 2));
        checkerBoard.setBoardSquare(6, 1, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 6, 1));
        checkerBoard.setBoardSquare(7, 0, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 7, 0));
        checkerBoard.setBoardSquare(7, 2, new CheckerPiece(CheckerPiece.Team.TEAM_TWO, 7, 2));


    }

    // single getter...no need for setter
    public CheckerBoard getCheckerBoard(){

        return checkerBoard;

    }

    public CheckerPiece.Team getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(CheckerPiece.Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    public static void switchTeam(){

        if(currentTeam == CheckerPiece.Team.TEAM_ONE)
            currentTeam = CheckerPiece.Team.TEAM_TWO;
        else
            currentTeam = CheckerPiece.Team.TEAM_ONE;

    }

    public int getTeamOnePieces() {
        return teamOnePieces;
    }

    public void setTeamOnePieces(int teamOnePieces) {
        this.teamOnePieces = teamOnePieces;
    }

    public int getTeamTwoPieces() {
        return teamTwoPieces;
    }

    public void setTeamTwoPieces(int teamTwoPieces) {
        this.teamTwoPieces = teamTwoPieces;
    }

    public CheckerPiece getCurrentSelected() {
        return currentSelected;
    }

    public void setCurrentSelected(CheckerPiece currentSelected) {
        this.currentSelected = currentSelected;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
