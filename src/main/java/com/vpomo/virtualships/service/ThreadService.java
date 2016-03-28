package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;

/**
 * Created by Pomogalov on 25.03.2016.
 */
public class ThreadService implements Runnable {
    private String name;
    private Ship ship;
    private Thread thread;
    private boolean suspendFlag;

    ThreadService (String threadName, Ship ship) {
        this.name = threadName;
        this.ship = ship;
        this.suspendFlag = false;
        thread = new Thread(this, name);
        thread.start();
    }

    public void run(){
        try {
            synchronized (suspendFlag) {
                while (!suspendFlag) {
                    //wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + "interrupted");
        }
        System.out.println("Thread " + name + "stopped");
    }

    synchronized void threadStop() {
        suspendFlag = true;
    }


}
