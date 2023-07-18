package org.example.Threads;


import java.util.concurrent.atomic.AtomicInteger;

//CRON JOBS: These unit processes that are tasked to carry out a behaviour/logic after a set period
//or to repeat a task at set intervals. Cron job basically help us with Scheduling.
public class Multithreading extends Thread{
    static AtomicInteger totalValue = new AtomicInteger(0);

    private int threadNo;

    public int getThreadNo() {
        return threadNo;
    }

    public void setThreadNo(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
        totalValue.getAndAdd(1);
        totalValue.set(totalValue.get());
    }
    }
    public static void main(String[] args) {


        Multithreading multithreading = new Multithreading();
        Multithreading multithreading1 = new Multithreading();
        MultiThreading3 multiThreading3 = new MultiThreading3();
        multithreading.setThreadNo(1);
        multithreading1.setThreadNo(2);
        DeadLock deadLock =  new DeadLock();
        deadLock.setThreadNo(4);

        multithreading.start();
        multithreading1.start();
        multiThreading3.addNumber();
        deadLock.start();


    }

}
