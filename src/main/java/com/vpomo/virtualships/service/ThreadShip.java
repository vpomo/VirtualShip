package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;
import com.vpomo.virtualships.model.Square;

/**
 * Created by Pomogalov on 29.03.2016.
 */
public class ThreadShip implements Runnable {
    private String name;
    private Square square;
    private Thread thread;
    private ControlValues controlValues;
    private Ship ship;
    private ShipServiceImpl shipService;

//    @Autowired
//    public ThreadShip(ShipService shipService) {
//        this.shipService = shipService;
//    }


    public ThreadShip (String threadName, String typeShip, ControlValues controlValues, Square square, int numberTypeShip, int numberThread) {
        this.name = threadName;
        this.square = square;
        this.controlValues = controlValues;
        this.ship = new Ship(typeShip, square);
        this.shipService = new ShipServiceImpl();

        thread = new Thread(this, name);
        controlValues.arrayThreadShip[numberTypeShip][numberThread] = thread;
        thread.start();
        System.out.println("Thread " + name + " starting ...");
    }

    @Override
    public void run(){
        try {
            synchronized (square) {
                while (! controlValues.stopMoving) {
                    if (this.ship != null) {
                        //System.out.println("Thread " + name + "  nextMove");
                        shipService.nextMove(ship, square);
                    }
                    thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + "interrupted");
        }
        System.out.println("Thread " + name + " stopped");
    }

}
