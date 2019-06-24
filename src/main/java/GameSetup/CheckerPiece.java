package GameSetup;

public class CheckerPiece {

    // potential team values
    public enum Team {

        TEAM_ONE,
        TEAM_TWO;

    }

    // team the piece belongs to
    Team team;
    // piece coordinates on the checker board
    int xCoordinate;
    int yCoordinate;

    // constructor to initialize the piece
    CheckerPiece(Team team, int xCoordinate, int yCoordinate){


        this.team = team;

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    // standard getters and setters
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
