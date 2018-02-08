package com.multiThread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    private int lock;
    public IntLock(int i){
        this.lock = i;
    }
    @Override
    public void run() {
            try {
                if(lock==1){
                    lock1.lockInterruptibly();
                    Thread.sleep(500);
                    lock2.lockInterruptibly();
                }
                else{
                    lock2.lockInterruptibly();
                    Thread.sleep(500);
                    lock1.lockInterruptibly();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if(lock1.isHeldByCurrentThread()){
                    lock1.unlock();
                }
                if(lock2.isHeldByCurrentThread()){
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getId()+":�߳��˳�");
            }
    }

    public static void main(String[] args) {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t2.interrupt();
    }
}
