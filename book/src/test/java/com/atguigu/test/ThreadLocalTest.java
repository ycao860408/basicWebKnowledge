package com.atguigu.test;

import java.util.Random;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<Double> threadLocal2 = new ThreadLocal<>();
    private static Random random = new Random();

    public static class Task implements Runnable {
        @Override
        public void run() {
            int curInteger = random.nextInt(100);
            double curDouble = random.nextDouble();

            String name = Thread.currentThread().getName();
            System.out.println("At the beginning of the "+ name +", the value is ["+ curInteger+"]");
            System.out.println("At the beginning of the "+ name +", the value is ["+ curDouble+"]");
            threadLocal1.set(curInteger);
            threadLocal2.set(curDouble);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Integer integer = threadLocal1.get();
            Double aDouble = threadLocal2.get();
            System.out.println("At the end of " + name + ", the value is [" + integer + "]");
            System.out.println("At the end of " + name + ", the value is [" + aDouble + "]");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}
