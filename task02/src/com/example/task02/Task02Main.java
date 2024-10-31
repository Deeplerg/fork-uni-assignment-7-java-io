package com.example.task02;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class Task02Main {
    public static void main(String[] args) throws IOException {
        // чтобы протестировать свое решение, вам нужно:
        // - направить файл input.test в стандартный ввод программы (в настройках запуска программы в IDE или в консоли)
        // - направить стандартный вывод программы в файл output.test
        // - запустить программу
        // - и сравнить получившийся файл output.test с expected.test

        // type input.test | java  -cp ..\..\..\..\build\classes Task02Main.java > output.test
        // fc output.test expected.test

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        // (this should really be a class)
        final byte carriageReturnByte = (byte)'\r';
        final byte lineFeedByte = (byte)'\n';

        int currentByte;
        int previousByte = -1;

        while((currentByte = inputStream.read()) != -1) {
            if(currentByte == carriageReturnByte) {
                if(previousByte == carriageReturnByte) {
                    outputStream.write(carriageReturnByte);
                }

                previousByte = currentByte;
                continue;
            }

            if(previousByte == carriageReturnByte) {
                if(currentByte == lineFeedByte) {
                    outputStream.write(lineFeedByte);
                } else {
                    outputStream.write(carriageReturnByte);
                    outputStream.write(currentByte);
                }
            } else {
                outputStream.write(currentByte);
            }

            previousByte = currentByte;
        }

        if(previousByte == carriageReturnByte)
            outputStream.write(previousByte);

        outputStream.flush();
    }
}
