package com.solvd.construction_company.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableExample implements Runnable{
        public void run(){
            Logger logger = LogManager.getLogger(RunnableExample.class);

            logger.info("Thread is running for Runnable Implementation");
        }
    }
