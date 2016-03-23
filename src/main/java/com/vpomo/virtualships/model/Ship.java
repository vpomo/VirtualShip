package com.vpomo.virtualships.model;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public class Ship {

    private int coordinateX;
    private int coordinateY;
    private String color;
    private String kind;

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
    }

    @Override
    public String toString(){
        return "Ships{" + "kind=" + kind + ", color=" + color + '}';
    }
}
