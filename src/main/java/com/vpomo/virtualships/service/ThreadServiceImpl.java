package com.vpomo.virtualships.service;

/**
 * Created by Pomogalov on 25.03.2016.
 */
public class ThreadServiceImpl implements ThreadService {
    Thread thread;

    ThreadServiceImpl(String nameThread) {
        thread = new Thread(this, nameThread);
        thread.start();
    }

    public void run() {

    }
}
