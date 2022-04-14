package ru.aton.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Потребитель Cher.
 * Считывает элемент(массив строк) из очереди, у которого первая строка равна "Cher" или "Sonny, Cher".
 */
public class Cher implements Callable<Object> {

    private final BlockingQueue<String[]> queue;

    public Cher(BlockingQueue<String[]> queue) {
        this.queue = queue;
    }

    @Override
    public Object call() {
        final String threadName = "Cher";
        Thread.currentThread().setName(threadName);
        try {
            while (true) {
                if (!queue.isEmpty()) {
                    String[] str = queue.peek();
                    if (str != null && (str[0].equals("Cher") || str[0].equals("Sonny, Cher"))) {
                        System.out.println(threadName + ": " + str[1]);
                        queue.remove(str);
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
