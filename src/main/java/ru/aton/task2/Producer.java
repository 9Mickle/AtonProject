package ru.aton.task2;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Поставщик строк в общую очередь.
 */
public class Producer implements Callable<Object> {

    /**
     * Счетчик.
     * Необходим для контроля потребителей.
     * Каждый раз, когда потребитель получает общую строку, отмеченную как "Sonny, Cher",
     * потребитель увеличивает или обнуляет счетчик.
     */
    private static int counter = 0;

    /**
     * Флаг завершения работы поставщика.
     */
    private static boolean done = false;
    private final BlockingQueue<String[]> queue;

    public Producer(BlockingQueue<String[]> queue) {
        this.queue = queue;
    }

    @Override
    public Object call() {

        String[][] lyrics = {
                {"Cher", "They say we're young and we don't know \nWe won't find out until we grow"},
                {"Sonny", "Well I don't know if all that's true \n'Cause you got me, and baby I got you"},
                {"Sonny", "Babe"},
                {"Sonny, Cher", "I got you babe \nI got you babe"},
                {"Cher", "They say our love won't pay the rent \nBefore it's earned, our money's all been spent"},
                {"Sonny", "I guess that's so, we don't have a pot \nBut at least I'm sure of all the things we got"},
                {"Sonny", "Babe"},
                {"Sonny, Cher", "I got you babe \nI got you babe"},
                {"Sonny", "I got flowers in the spring \nI got you to wear my ring"},
                {"Cher", "And when I'm sad, you're a clown \nAnd if I get scared, you're always around"},
                {"Cher", "So let them say your hair's too long \n'Cause I don't care, with you I can't go wrong"},
                {"Sonny", "Then put your little hand in mine \nThere ain't no hill or mountain we can't climb"},
                {"Sonny", "Babe"},
                {"Sonny, Cher", "I got you babe \nI got you babe"},
                {"Sonny", "I got you to hold my hand"},
                {"Cher", "I got you to understand"},
                {"Sonny", "I got you to walk with me"},
                {"Cher", "I got you to talk with me"},
                {"Sonny", "I got you to kiss goodnight"},
                {"Cher", "I got you to hold me tight"},
                {"Sonny", "I got you, I won't let go"},
                {"Cher", "I got you to love me so"},
                {"Sonny, Cher", "I got you babe \nI got you babe \nI got you babe \nI got you babe \nI got you babe"}
        };

        Arrays.stream(lyrics)
                .forEach(elem -> {
                    try {
                        queue.put(elem);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        done = true;
        return null;
    }

    /**
     * Метод проверки общей строки.
     * Если в очереди встретилась общая строка ("Sonny, Cher"), то происходит проверка счетчика:
     * если счетчик < 2, значит эта строка либо не появлялась в очереди совсем либо её уже обработал один из потребителей,
     * увеличиваем счетчик и не удаляем эту строку из очереди.
     * Иначе если счетчик >= 2 значит эту строку обработали оба потребителя, зануляем счетчик и удаляем строку из очереди.
     *
     * @param queue      очеред.
     * @param str        элемент из очереди.
     * @param threadName имя потока.
     */
    public static void checkCommonLine(BlockingQueue<String[]> queue, String[] str, String threadName) {
        if (str[0].equals("Sonny, Cher")) {
            int count = getCounter();
            if (count < 2) {
                System.out.println(threadName + ": " + str[1]);
                count++;
                setCounter(count);
            } else {
                queue.remove(str);
                setCounter(0);
            }
        }
    }

    public static boolean isDone() {
        return done;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Producer.counter = counter;
    }
}
