package ru.aton.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Потребитель Sonny.
 * Считывает элемент(массив строк) из очереди, у которого первая строка равна "Sonny" или "Sonny, Cher".
 */
public class Sonny implements Callable<Object> {

    private final BlockingQueue<String[]> queue;

    public Sonny(BlockingQueue<String[]> queue) {
        this.queue = queue;
    }

    @Override
    public Object call() {
        final String threadName = "Sony";
        Thread.currentThread().setName(threadName);
        try {
            while (true) {
                if (!queue.isEmpty()) {
                    String[] str = queue.peek();
                    if (str != null) {
                        if (str[0].equals("Sonny")) {
                            System.out.println(threadName + ": " + str[1]);
                            queue.remove(str);
                        } else {
                            Producer.checkCommonLine(queue, str, threadName);
                        }
                    }
                } else {
                    //Условие остановки цикла.
                    if (Producer.isDone()) {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
