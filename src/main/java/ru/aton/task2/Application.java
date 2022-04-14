package ru.aton.task2;

import java.util.List;
import java.util.concurrent.*;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String[]> queue = new LinkedBlockingQueue<>(5);

        List<Callable<Object>> taskList =
                List.of(new Producer(queue), new Sonny(queue), new Cher(queue));

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.invokeAll(taskList);
        executorService.shutdown();
    }
}
