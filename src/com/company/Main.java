package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Засекаю время и запускаю один поток
        LocalDateTime start = LocalDateTime.now();
        Thread oneT = new Thread(new OneThread());
        oneT.start();
        oneT.join();
        LocalDateTime end = LocalDateTime.now();
        Duration durationOneThread = Duration.between(start, end);
        System.out.println(durationOneThread.toMillis());
        //Засекаю время и запускаю 4 потока
        int amountThread = 4;
        LocalDateTime start2 = LocalDateTime.now();
        List<Thread> thread = new ArrayList<>();
        int begin = 0;
        int iterator = 5000000;
        for (int i = 0; i < amountThread; i++) {
            thread.add(new Thread(new ManyThreads(begin, begin += iterator)));
            thread.get(i).start();
        }
        for (int i = 0; i < amountThread; i++) {
            thread.get(i).join();
        }
        LocalDateTime end2 = LocalDateTime.now();
        Duration durationManyThreads = Duration.between(start2, end2);
        System.out.println(durationManyThreads.toMillis());
        long result = durationOneThread.toMillis() - durationManyThreads.toMillis();
        System.out.println("4 потока выполнят это задание на " + result + " миллисекунд быстрее");
    }

    static void inputMass(String[] mass, int i) {
        if (i % 5 == 0 && i % 3 == 0) {
            mass[i] = "FizzBuzz";
        } else if (i % 3 == 0) {
            mass[i] = "Fizz";
        } else if (i % 5 == 0) {
            mass[i] = "Buzz";
        } else {
            mass[i] = String.valueOf(i);
        }
    }
}
