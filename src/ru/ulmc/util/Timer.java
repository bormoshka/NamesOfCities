package ru.ulmc.util;

/**
 * Created by 45 on 16.10.2016.
 */
public class Timer {
    private long startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        long nano = System.nanoTime() - startTime;
        System.out.println("Обработка заняла: " + nano + " наносекунд (" + nano/1000/1000 +" мс)");
    }
}
