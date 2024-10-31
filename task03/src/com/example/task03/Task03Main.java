package com.example.task03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Task03Main {
    public static void main(String[] args) throws IOException {
        //здесь вы можете вручную протестировать ваше решение, вызывая реализуемый метод и смотря результат
        // например вот так:

        /*
        System.out.println(readAsString(new FileInputStream("task03/src/com/example/task03/input.test"), Charset.forName("KOI8-R")));
        */
    }

    public static String readAsString(InputStream inputStream, Charset charset)
            throws IOException, IllegalArgumentException {
        GuardAgainstNull(inputStream, "inputStream");
        GuardAgainstNull(charset, "charset");

        var bytes = inputStream.readAllBytes();
        return new String(bytes, charset);
    }

    private static void GuardAgainstNull(Object value, String parameterName) throws IllegalArgumentException {
        if(value == null)
            throw new IllegalArgumentException(parameterName + " must not be null.");
    }
}
