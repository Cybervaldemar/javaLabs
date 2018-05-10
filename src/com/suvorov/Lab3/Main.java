package com.suvorov.Lab3;

import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args)
    {
        FileInputStream output = null;
        Properties properties = new Properties();
        try {
            output = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            System.out.print("File not found");
            return;
        }
        try {
            properties.load(output);
        } catch (IOException e) {
            System.out.print("Could not read properties.");
            return;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Print property name: ");
                String input = bufferedReader.readLine();
                if (input == null || input.length() == 0) {
                    break;
                }
                if (properties.containsKey(input)) {
                    System.out.printf("%s => %s\n", input, properties.getProperty(input));
                } else {
                    System.out.printf("There's no such key '%s'\n", input);
                }
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.print("Could not read properties.");
        }
    }
}
