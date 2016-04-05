package com.vpomo.virtualships.model;

import java.util.ArrayList;

import static com.vpomo.virtualships.service.ControlValues.MAX_SIZE_SQUARE;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public class Square {
    private CellSquare[][]  cellSquare;
    public ArrayList<CellSquare> queueDrivers = new ArrayList<>();


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

    public ArrayList<CellSquare> getRowSquare(int row) {
        ArrayList<CellSquare> rowSquare = new ArrayList<CellSquare>(MAX_SIZE_SQUARE);
        rowSquare.clear();
        rowSquare.trimToSize();

        for (int i = 0; i < MAX_SIZE_SQUARE; i++) {
            rowSquare.add(this.cellSquare[row][i]);
        }

        return rowSquare;
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
