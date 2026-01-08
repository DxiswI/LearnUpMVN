package org.example;

public class Game {
    // Статическое поле для хранения состояния светофора
    private static boolean isGreenLight = true;

    // Метод для установки состояния светофора
    public static void setGreenLight(boolean greenLight) {
        isGreenLight = greenLight;
    }

    // Главный метод: проверяет, выбыл ли игрок с данной скоростью
    public static boolean isPlayerOut(int speed) {
        // Если свет зеленый - никто не выбывает (возвращаем false)
        // Если свет красный - выбывают те, у кого скорость != 0 (возвращаем true)
        return !isGreenLight && speed != 0;
    }
    // Метод 1: подсчитывает количество выбывающих игроков
    public static int countEliminatedPlayers(int[] speeds) {
        int count = 0; // Счетчик начинается с 0

        for (int i = 0; i < speeds.length; i++) {
            if (isPlayerOut(speeds[i])) {
                count++; // Увеличиваем счетчик на 1
            }
        }

        return count; // Возвращаем результат
    }

    // Метод 2: возвращает массив скоростей выбывающих игроков
    public static int[] getEliminatedSpeeds(int[] speeds) {
        // 1. Узнаем сколько будет выбывающих (используем метод 1)
        int count = countEliminatedPlayers(speeds);

        // 2. Создаем массив такого размера
        int[] eliminated = new int[count];

        // 3. Заполняем массив
        int index = 0;
        for (int i = 0; i < speeds.length; i++) {
            if (isPlayerOut(speeds[i])) {
                eliminated[index] = speeds[i];
                index++;
            }
        }

        // 4. Возвращаем массив
        return eliminated;
    }

    // Метод 3: возвращает массив скоростей НЕ выбывающих игроков
    public static int[] getSurvivedSpeeds(int[] speeds) {
        // 1. Считаем сколько НЕ выбывает
        int count = 0;
        for (int i = 0; i < speeds.length; i++) {
            if (!isPlayerOut(speeds[i])) {
                count++;
            }
        }

        // 2. Создаем массив такого размера
        int[] survived = new int[count];

        // 3. Заполняем массив
        int index = 0;
        for (int i = 0; i < speeds.length; i++) {
            if (!isPlayerOut(speeds[i])) {
                survived[index] = speeds[i];
                index++;
            }
        }

        // 4. Возвращаем массив
        return survived;
    }
}
