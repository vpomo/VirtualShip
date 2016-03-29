package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Square;
import org.springframework.stereotype.Service;

/**
 * Created by Pomogalov on 25.03.2016.
 */
@Service
public class DispatchingServiceImpl implements DispatchingService {
    private Square square;
    private Flag flag;

    public void startMovingShips(int numberShipTypeA, int numberShipTypeD, int numberShipTypeP) throws InterruptedException {
        flag = new Flag();
        String threadName = "";
        System.out.println("Один");

        if (square == null) {
            square = new Square();
        }
        System.out.println("Два");
        if (numberShipTypeA > 0) {
           for (int n = numberShipTypeA; n > 0; n--) {
               threadName = "typeA-" + n;
               System.out.println(threadName);
               //new ThreadShip(threadName, "typeA", flag, square);
           }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrrupted");
        }
        flag.stopMoving = true;
    }

    public void stopMovingShip() {

    }
}
