package com.solvd.construction_company.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);

        //Simple thread
        Thread t1 = new ThreadExample();
        t1.start();

        //Runnable example
        RunnableExample runnable = new RunnableExample();
        Thread t2 = new Thread(runnable);
        t2.start();

        //Thread pool
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        logger.info("Finished all threads");

        //Deadlock
        ThreadDemo1 threadOne = new ThreadDemo1();
        ThreadDemo2 threadTwo = new ThreadDemo2();
        threadOne.start();
        threadTwo.start();

    }
}
