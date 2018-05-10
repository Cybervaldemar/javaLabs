package com.suvorov.Lab1;
import java.lang.System;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            throw new RuntimeException("Usage: <> a b h");
        }
        int a, b, h;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            h = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Arguments must be integer");
        }
        if (a >= b) {
            throw new RuntimeException("'a' argument should be less than 'b'");
        }
        System.out.print("x\t|\tf(x)\n");
        System.out.print("----|--------------\n");
        for (int i = a; i <= b; i += h) {
            System.out.printf("%d\t|\t%f\n", i, Main.func1(i));
        }
    }

    private static double func1(int x)
    {
        return Math.tan(2 * x) - 3;
    }
}
