package com.example.task04;

import java.io.IOException;

public class Task04Main {
    public static void main(String[] args) throws IOException {
        // чтобы протестировать свое решение, вам нужно:
        // - направить файл input.test в стандартный ввод программы (в настройках запуска программы в IDE или в консоли)
        // - запустить программу
        // - проверить, что получилось 351.731900

        // type input.test | java -cp ..\..\..\..\build\classes Task04Main.java

        String input = new String(System.in.readAllBytes());
        var split = input.split("[ \t\r\n]+");

        double sum = 0;
        for(var element : split) {
            try {
                sum += Double.parseDouble(element);
            } catch(NumberFormatException ignored) {
            }
        }

        String formattedSum = String.format("%.6f", sum);
        System.out.println(formattedSum);
    }
}
