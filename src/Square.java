public class Square {
    private int r;
    private int c;
    private int type;
    boolean working;
    boolean explored;
    boolean solved;

    public Square (int r, int c, int type) {
        this.r = r;
        this.c = c;
        this.type = type;
    }

    public int getRow() {
        return r;
    }

    public int getColumn() {
        return c;
    }

    public int getType() {
        return type;
    }

    public void reset () {
        working = false;
        explored = false;
        solved = false;
    }

    public String toString() {
        String toReturn;
        switch (this.type) {
            case 0:
                toReturn = "_";
                break;
            case 1:
                toReturn = "#";
                break;
            case 2:
                toReturn = "S";
                break;
            case 3:
                toReturn = "E";
                break;
            default:
                return "error";
        }

        if (working) {
            toReturn = "o";
        } else if (explored) {
            toReturn = ".";
        } else if (solved) {
            toReturn = "x";
        }

        return toReturn;
    }

}
