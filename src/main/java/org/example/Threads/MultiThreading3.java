package org.example.Threads;

public class MultiThreading3{

    public void addNumber() {
        Runnable runnable = ()->{
            for (int i = 0; i < 100; i++) {
                Multithreading.totalValue.getAndAdd(1);
                Multithreading.totalValue.set(Multithreading.totalValue.get());
                System.out.println("Thread number "+3+"="+Multithreading.totalValue.get());
            }

            System.out.println("Total value = "+Multithreading.totalValue.get());
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
