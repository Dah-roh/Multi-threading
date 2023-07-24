package org.example.Threads;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock extends Thread{

    private Future<String> oPayTransactionResponse = new CompletableFuture<>();
    private final String lock1 = new String();
    private final String lock2 = new String();

    private final ReentrantLock reentrantLock =  new ReentrantLock();
    private int threadNo;

    public int getThreadNo() {
        return threadNo;
    }

    public void setThreadNo(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        Thread thread =  new Thread(()-> {






//            reentrantLock.lock();
            synchronized (lock1) {
                System.out.println("Accessing users Opay account...");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Transfer to user's Opay account successful...");
                }
//                reentrantLock.unlock();
            }
        });

        Thread thread2 =  new Thread(
                ()-> {





            synchronized (lock2) {
                System.out.println("Verifying User's KYC...." +
                        "Verifying User's NIN information...");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                   if(oPayTransactionResponse.isDone()){
                       try {
                           oPayTransactionResponse.get();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       } catch (ExecutionException e) {
                           throw new RuntimeException(e);
                       }
                   }
                    System.out.println("Transfer to user's Opay successful...." +
                            "But user's NIN field in profile still needs updating... ");
                }
            }
        }
        );
        thread.start();
        thread2.start();
        }
    }
