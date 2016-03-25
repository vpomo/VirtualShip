package com.vpomo.virtualships.service;

/**
 * Created by Pomogalov on 25.03.2016.
 */
public class DispatchingServiceImpl implements DispatchingService {
    public void startMovingShips(int numberShipTypeA, int numberShipTypeD, int numberShipTypeP) {
        try {
            if (numberShipTypeA > 0) {
                for (int n = numberShipTypeA; n > 0; n--) {

                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread  for ship typeA interrupted");
        }

    }

    public void stopMovingShip() {

    }
}
