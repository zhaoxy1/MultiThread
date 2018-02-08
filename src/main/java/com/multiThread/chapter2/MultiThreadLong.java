package com.multiThread.chapter2;

public class MultiThreadLong {
    private volatile static long i = 0;
    public static class PlusTask extends Thread{
        @Override
        public void run(){
            for(int k = 0;k<10000;k++){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++){
            threads[i] = new PlusTask();
            threads[i].start();
        }
        for(int i=0;i<10;i++){
            threads[i].join();
        }
        System.out.println(i);
    }
}
