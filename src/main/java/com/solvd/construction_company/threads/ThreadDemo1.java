package com.solvd.construction_company.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDemo1 extends Thread {
    public void run() {
        Logger logger = LogManager.getLogger(ThreadDemo1.class);

        synchronized (DeadLock.Lock1) {
            logger.info("ThreadDemo1 is holding LOCK 1...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("ThreadDemo1 is waiting for Lock 2...");
            synchronized (DeadLock.Lock2) {
                logger.info("ThreadDemo1  is holding Lock 1 and Lock 2...");
            }
        }
    }
}
