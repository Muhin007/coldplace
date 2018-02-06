package com.github.muhin007.coldplace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class CityFile {

    public static void main(String[] args) {
        String data = "Проверка";

        writeUsingOutputStream(data);
    }

    private static void writeUsingOutputStream(String data) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("C:\\Dev\\Projects\\coldplace\\maven\\src\\" +
                    "main\\java\\com\\github\\muhin007\\coldplace\\City.txt"));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}