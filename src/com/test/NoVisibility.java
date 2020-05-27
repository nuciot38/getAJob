package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    static volatile Integer count = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
//        new ReaderThread().start();
//        ExecutorService executorService = Executors.newFixedThreadPool(6);
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        number = 42;
//        ready = true;

        int corePoolSize = 6;
        int maximumPoolSize = 6;
        ThreadFactory threadFactory = new NameThreadFactory();
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 60L, TimeUnit.MINUTES, workQueue, threadFactory, handler);
        threadPoolExecutor.prestartAllCoreThreads();
        int step = 1000;
        for (int i = 0; i < maximumPoolSize; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    int threadId = Integer.valueOf(Thread.currentThread().getName());
                    System.out.println("threadId = " + threadId);
                    for (int i = threadId * step; i < (threadId + 1) * step; i++) {
                        synchronized (count) {
                            count++;
                        }
                    }
                }
            });
        }

//        while (threadPoolExecutor.getCompletedTaskCount() < maximumPoolSize) {
//            continue;
//        }
        System.out.println(count);
        System.out.println("已完成");
        threadPoolExecutor.shutdown();

    }

    static class NameThreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, String.valueOf(mThreadNum.getAndIncrement()));
//            System.out.println(t.getName() + "has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }

    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                Thread.sleep(3000); //让任务执行慢点
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
