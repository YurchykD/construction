package com.solvd.construction_company.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadExample extends Thread{
    @Override
    public void run() {
        Logger logger = LogManager.getLogger(ThreadExample.class);

        logger.info("Hello, World!");
    }
}

