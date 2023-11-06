public class Squares {
    //change
    private int r;
    private int c;
    private int type;
    boolean working;
    boolean explored;
    boolean solved;
    Squares previous;

    public Squares (int r, int c, int type) {
        this.r = r;
        this.c = c;
        this.type = type;
        this.previous = null;
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

    public boolean explored() {
        return explored;
    }

    public boolean working() {
        return this.working;
    }

    public boolean solved() {
        return solved;
    }

    public void startWorking() {
        working = true;
    }

    public void explore() {
        explored = true;
    }

    public void setSolved() {
        solved = true;
    }

    public Squares getPrev() {
        return this.previous;
    }

    public void setPrev(Squares other) {
        this.previous = other;
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