package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тест всех методов ===");

        // Тестовые данные
        int[] speeds = {5, 0, 2, 10, 3, 0};

        System.out.println("Все скорости: " + Arrays.toString(speeds));
        System.out.println("Длина массива: " + speeds.length + " игроков");

        // Тест 1: Красный свет
        System.out.println("\n1. Красный свет:");
        Game.setGreenLight(false);

        System.out.println("   Выбыло: " + Game.countEliminatedPlayers(speeds));
        System.out.println("   Выбывшие скорости: " + Arrays.toString(Game.getEliminatedSpeeds(speeds)));
        System.out.println("   Оставшиеся скорости: " + Arrays.toString(Game.getSurvivedSpeeds(speeds)));

        // Тест 2: Зеленый свет
        System.out.println("\n2. Зеленый свет:");
        Game.setGreenLight(true);

        System.out.println("   Выбыло: " + Game.countEliminatedPlayers(speeds));
        System.out.println("   Выбывшие скорости: " + Arrays.toString(Game.getEliminatedSpeeds(speeds)));
        System.out.println("   Оставшиеся скорости: " + Arrays.toString(Game.getSurvivedSpeeds(speeds)));
    }
}