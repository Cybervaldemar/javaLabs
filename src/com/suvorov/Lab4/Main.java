package com.suvorov.Lab4;

import java.io.*;
import java.util.Properties;
import java.util.HashMap;
import com.suvorov.Lab4.MyPropertyreader;

public class Main {
    public static void main(String[] args)
    {
        MyPropertyreader mpr = new MyPropertyreader("config.properties");
        HashMap<String,String> props = mpr.load();

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Print property name or Press crtl+d to stop: ");
                String input = bufferedReader.readLine();
                if (input == null || input.length() == 0) {
                    break;
                }
                if (props.containsKey(input)) {
                    System.out.printf("%s => %s\n", input, props.get(input));
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
