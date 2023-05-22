import java.util.Objects;

/**
 * @version 5/18/23
 * @author 26roederer
 *Class for the position of the tiles
 */
public class Position {
    private int row,col;

    /**
     * public object position
     * @param row row the tile is in
     * @param col column the tile is in
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * returns the row as an int
     * @return the row
     */
    public int getRow() {
        return row;
    }
    /**
     * returns the column as an int
     * @return the column
     */
    public int getCol() {
        return col;
    }

    /**
     * set the position of the row
     * @param row row of the piece
     */
    public void setRow(int row) {
        this.row = row;
    }
    /**
     * set the position of the row
     * @param col colum of the piece
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * checks if the object is at the position
     * @param other
     * @return true if the object matches the position and false otherwise
     */
    public boolean equals(Object other) {
        if (other instanceof Position){
            Position temp=(Position)other;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }

}
