package com.vpomo.virtualships.service;

/**
 * Created by Pomogalov on 31.03.2016.
 */
public class ControlValues {
    public static final int MAX_NUMBER_SHIPS = 5;
    public static final int MAX_SIZE_SQUARE = 64;


    public static volatile boolean stopMoving = false;
    public static volatile boolean setValue = true;

    public static volatile Thread arrayThreadShip[][] = new Thread[3][MAX_NUMBER_SHIPS];
}
