package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Square;
import org.springframework.stereotype.Service;

import static com.vpomo.virtualships.service.ControlValues.MAX_NUMBER_SHIPS;

/**
 * Created by Pomogalov on 25.03.2016.
 */
@Service
public class DispatchingServiceImpl implements DispatchingService {
    public static volatile Square square;
    private ControlValues controlValues;

    public void startMovingShips(int numberShipTypeA, int numberShipTypeD, int numberShipTypeP) throws InterruptedException {
        this.controlValues = new ControlValues();
        String threadName = "";

        if (controlValues == null) {
            this.controlValues = new ControlValues();
        }

        if (square == null) {
            this.square = new Square();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < MAX_NUMBER_SHIPS; j++){
                if (controlValues.arrayThreadShip[i][j] != null) {
                    controlValues.arrayThreadShip[i][j] = null;
                    System.out.println("==========!!!!!!=" + i + j);
                }
            }
        }

        //this.square = square;
        if ((numberShipTypeA > 0) & (numberShipTypeA < MAX_NUMBER_SHIPS) ) {
           for (int n = numberShipTypeA; n > 0; n--) {
               threadName = "typeA-№" + n;
               new ThreadShip(threadName, "typeA", this.controlValues, square, 0, n);
           }
        }
        if ((numberShipTypeD > 0) & (numberShipTypeD < MAX_NUMBER_SHIPS)) {
            for (int n = numberShipTypeD; n > 0; n--) {
                threadName = "typeD-№" + n;
                new ThreadShip(threadName, "typeD", this.controlValues, square, 1, n);
            }
        }
        if ((numberShipTypeP > 0) & (numberShipTypeP < MAX_NUMBER_SHIPS)) {
            for (int n = numberShipTypeP; n > 0; n--) {
                threadName = "typeP-№" + n;
                new ThreadShip(threadName, "typeP", this.controlValues, square, 2, n);
            }
        }

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrrupted");
        }

        controlValues.stopMoving = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < MAX_NUMBER_SHIPS; j++){
                if (controlValues.arrayThreadShip[i][j] != null) {
                    controlValues.arrayThreadShip[i][j].join();
                    System.out.println("!!!!!!=" + i + j);
                }
            }
        }


        synchronized (square) {
            System.out.println("Square = " + square.toString());
        }

    }

    public void stopMovingShip() {

    }
}
