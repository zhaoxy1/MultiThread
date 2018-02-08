package com.multiThread.chapter2;

public class NoVisibility {
    private volatile static boolean ready;
    private static int number;
    private static class ReaderThread extends  Thread{
        public void run(){
            while(!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
        Thread.sleep(10000);
    }
}
