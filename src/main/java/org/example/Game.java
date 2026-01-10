package org.example;

public class Game {
    // Статическое поле для хранения состояния светофора
    private static boolean isGreenLight = true;

    // Новое поле: максимальная незаметная скорость
    private static int maxSpeed = 0; // По умолчанию 0

    // Метод для установки maxSpeed
    public static void setMaxSpeed(int speed) {
        maxSpeed = speed;
    }

    // Метод для получения maxSpeed (опционально, для тестов)
    public static int getMaxSpeed() {
        return maxSpeed;
    }

    // Метод для установки состояния светофора
    public static void setGreenLight(boolean greenLight) {
        isGreenLight = greenLight;
    }

    // Главный метод: проверяет, выбыл ли игрок с данной скоростью
    public static boolean isPlayerOut(int speed) {
        if (isGreenLight) {
            return false; // При зелёном свете никто не выбывает
        } else {
            // Игрок выбывает если его скорость > maxSpeed
            return speed > maxSpeed;
        }
    }

    // Метод 1: подсчитывает количество выбывающих игроков
    public static int countEliminatedPlayers(int[] speeds) {
        int count = 0;
        for (int i = 0; i < speeds.length; i++) {
            if (isPlayerOut(speeds[i])) {
                count++;
            }
        }
        return count;
    }

    // Метод 2: возвращает массив скоростей выбывающих игроков
    public static int[] getEliminatedSpeeds(int[] speeds) {
        int count = countEliminatedPlayers(speeds);
        int[] eliminated = new int[count];
        int index = 0;
        for (int i = 0; i < speeds.length; i++) {
            if (isPlayerOut(speeds[i])) {
                eliminated[index] = speeds[i];
                index++;
            }
        }
        return eliminated;
    }

    // Метод 3: возвращает массив скоростей НЕ выбывающих игроков
    public static int[] getSurvivedSpeeds(int[] speeds) {
        int count = 0;
        for (int i = 0; i < speeds.length; i++) {
            if (!isPlayerOut(speeds[i])) {
                count++;
            }
        }
        int[] survived = new int[count];
        int index = 0;
        for (int i = 0; i < speeds.length; i++) {
            if (!isPlayerOut(speeds[i])) {
                survived[index] = speeds[i];
                index++;
            }
        }
        return survived;
    }
}