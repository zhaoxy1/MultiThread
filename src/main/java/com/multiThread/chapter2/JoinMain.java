package com.multiThread.chapter2;

public class JoinMain {
    public volatile static int i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run(){
            for(i = 0; i<10000000;i++){}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
//        Thread.sleep(10);
        at.join();
        System.out.println(i);
    }
}
