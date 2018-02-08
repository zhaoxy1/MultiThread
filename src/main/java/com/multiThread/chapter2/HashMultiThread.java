package com.multiThread.chapter2;

import java.util.HashMap;
import java.util.Map;

public class HashMultiThread {
    private static Map<String,String> map = new HashMap<>();
    public static class AddThread implements Runnable{
        private int start = 0;
        public AddThread(int start){
            this.start = start;
        }
        @Override
        public void run() {
            for(int i = 0;i<10000000;i+=2){
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread  t1 = new Thread(new HashMultiThread.AddThread(0));
        Thread  t2 = new Thread(new HashMultiThread.AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
