package com.vpomo.virtualships.model;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public class Square {
    public static final int MAX_SIZE_SQUARE = 64;
    private CellSquare[][]  cellSquare;

    public Square() {
        String colorCell = "..";
        int numberTimesToChangeColor = 0;
        this.cellSquare = new CellSquare[MAX_SIZE_SQUARE][MAX_SIZE_SQUARE];

        for (int i = 0; i < MAX_SIZE_SQUARE; i++) {
            for (int j = 0; j < MAX_SIZE_SQUARE; j ++) {
                this.cellSquare[i][j] = new CellSquare(i,j);
                this.cellSquare[i][j].setColor(colorCell);
                this.cellSquare[i][j].setNumberTimesToChangeColor(numberTimesToChangeColor);
            }
        }
    }

    public void setColorCell(int coordinateX, int coordinateY, String color) {
        this.cellSquare[coordinateX][coordinateY].setColor(color);
    }

    public String getColorCell(int coordinateX, int coordinateY) {
        return cellSquare[coordinateX][coordinateY].getColor();
    }

    public void setNumberTimesCell(int coordinateX, int coordinateY, int numberTimesToChangeColor) {
        this.cellSquare[coordinateX][coordinateY].setNumberTimesToChangeColor(numberTimesToChangeColor);
    }

    public int getNumberTimesCell(int coordinateX, int coordinateY) {
        return cellSquare[coordinateX][coordinateY].getNumberTimesToChangeColor();
    }

    @Override
    public String toString(){
        String returnString;
        returnString = "";

        for (int i = 0; i < MAX_SIZE_SQUARE; i++) {
            for (int j = 0; j < MAX_SIZE_SQUARE; j++) {
                returnString = returnString + "=" + getColorCell(i, j) + " ";
            }
        }

        return returnString;
    }


}
