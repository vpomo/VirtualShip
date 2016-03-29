package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;
import com.vpomo.virtualships.model.Square;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pomogalov on 29.03.2016.
 */
public class ThreadShip implements Runnable {
    private String name;
    private Square square;
    private Thread thread;
    private Flag flag;
    private Ship ship;

    @Autowired
    protected ShipService shipService;

    ThreadShip (String threadName, String typeShip, Flag flag, Square square) {
        this.name = threadName;
        this.square = square;
        this.flag = flag;
        ship = new Ship(typeShip, square);
        thread = new Thread(this, name);
        thread.start();
    }

    public void run(){
        try {
            synchronized (square) {
                while (! flag.stopMoving) {
                    shipService.nextMove(ship);
                    thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + "interrupted");
        }
        System.out.println("Thread " + name + "stopped");
    }

    synchronized void threadStop() {
        flag.stopMoving = true;
    }

}
