package com.vpomo.virtualships.model;

import java.util.Random;

import static com.vpomo.virtualships.model.Square.MAX_SIZE_SQUARE;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public class Ship {

    private int coordinateX;
    private int coordinateY;
    private String color;
    private String typeShip;
    private Square square;


    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTypeShip(String typeShip) {
        this.typeShip = typeShip;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public String getColor() {
        return color;
    }

    public String getTypeShip() {
        return typeShip;
    }

    public Ship(String typeShip, Square square){
        this.typeShip = typeShip;
        Random rand = new Random();
        this.coordinateX = rand.nextInt(MAX_SIZE_SQUARE);
        this.coordinateY = rand.nextInt(MAX_SIZE_SQUARE);
        this.square = square;
        switch (typeShip) {
            case "typeA":
                this.color = "#FFFFFF";
                break;
            case "typeD":
                this.color = "#FFFFFF";
                break;
            case "typeP":
                this.color = "#FFFFFF";
                break;
            default:
                break;
        }
        square.setColorCell(coordinateX, coordinateY, color);
        square.setNumberTimesCell(coordinateX, coordinateY, 5);
    }

    @Override
    public String toString(){
        return "Ships{" + "typeShip=" + typeShip + ", color=" + color + '}';
    }
}
