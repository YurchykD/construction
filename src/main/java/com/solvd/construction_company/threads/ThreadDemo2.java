package com.solvd.construction_company.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDemo2 extends Thread{
    public void run() {
        Logger logger = LogManager.getLogger(ThreadDemo2.class);

        synchronized (DeadLock.Lock2) {
            logger.info("ThreadDemo2 is holding LOCK 2...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("ThreadDemo2 is waiting for Lock 1...");
            synchronized (DeadLock.Lock1) {
                logger.info("ThreadDemo2  is holding Lock 1 and Lock 2...");
            }
        }
    }
}
