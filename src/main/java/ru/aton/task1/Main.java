package ru.aton.task1;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int size = 18_760_327;
        HashMap<String, String> phoneNameMap = new HashMap<>();

        String phone = "89181112233";
        String name = "Zaks Mikhail Aaaaaaa";

        for (int i = 0; i < size; i++) {
            phoneNameMap.put(randomString(11), name);
            phoneNameMap.put(phone, name);
        }

        System.out.println("Элемент из мапы: " + phoneNameMap.get(phone));
        System.out.println("Размер мапы: " + phoneNameMap.size() + "\n");
        System.out.println("Кол-во использованной памяти: " + ManagementFactory
                .getMemoryMXBean()
                .getHeapMemoryUsage()
                .getUsed() / Math.pow(1024, 3));
    }

    /**
     * Генератор случайных строк заданного размера.
     *
     * @param size размер случайной строки.
     * @return сгенерированная строка.
     */
    private static String randomString(int size) {
        String symbols = "0123456789";
        return new Random().ints(size, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
