package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("this is main method Let me create New Thread");
        Thread runnableThread = new Thread(new RunnableThread());
        runnableThread.start();
        Thread extendsThread = new Thread(new ExtendsThread());
        extendsThread.start();
        ExecutorService executors = Executors.newFixedThreadPool(2);
        Runnable thread3 = () -> {
            System.out.println("Runnable Thread 3 is running");
        };
        Runnable thread4 = () -> {
            System.out.println("Runnable Thread 4 is running");
        };
        executors.execute(thread4);
        executors.execute(thread3);
        while (!executors.isTerminated()) {
            executors.shutdown();
        }
        futureTaskExample();
    }
    
   private static void futureTaskExample() throws Exception
    {
        Callable callable = () -> {
            System.out.println(
                "In Callable , threadName -> " + Thread.currentThread().getName());
            return 1;
        };
        Runnable runnable = () -> {
            System.out.println(
                "In Runnable , threadName -> " + Thread.currentThread().getName());
        };
        FutureTask futureTask = new FutureTask(callable);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println(executorService.submit(futureTask).get());
        executorService.submit(callable);
        executorService.execute(runnable);
        // callable.call();
        // runnable.run();
        while (!executorService.isTerminated()) {
            executorService.shutdown();
        }
        while (true) {
            if (futureTask.isDone()) {
                System.out.println("FT completed");
                return;
            }
            else {
                System.out.print("FT value   = ");
                System.out.println(futureTask.get());
            }
        }
    }

}
