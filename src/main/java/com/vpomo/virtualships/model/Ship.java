package com.vpomo.virtualships.model;

import java.util.Random;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public class Ship {

    private int coordinateX;
    private int coordinateY;
    private String color;
    private String kind;
    public static final int MAX_SIZE_SQUARE = 256;

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public String getKind() {
        return kind;
    }

    public Ship(String kind){
        this.kind = kind;
        Random rand = new Random();
        this.coordinateX = rand.nextInt(MAX_SIZE_SQUARE);
        this.coordinateY = rand.nextInt(MAX_SIZE_SQUARE);
    }

    @Override
    public String toString(){
        return "Ships{" + "kind=" + kind + ", color=" + color + '}';
    }
}
