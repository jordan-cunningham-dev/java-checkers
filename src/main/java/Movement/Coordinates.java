package Movement;

// convenient class for storing locations of various objects
public class Coordinates {

    public Coordinates(){}

    public Coordinates(int xCoordinate, int yCoordinate){

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    private int xCoordinate;
    private int yCoordinate;

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

    @Override
    public String toString() {
        return "Coordinates{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
