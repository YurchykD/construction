package com.solvd.construction_company.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkerThread implements Runnable{

    Logger logger = LogManager.getLogger(WorkerThread.class);
    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        logger.info(" Start. Command = " +command);
        processCommand();
        logger.info(" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
