package com.suvorov.Lab2;

public class Main {
    public static void main(String[] args)
    {
        Product[] products = {
                new Book(),
                new Picture(),
                new Toy(),
                new Toy(),
                new Shoe(),
                new Book()
        };
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s\n", i, products[i].whoAmI());
        }
        System.out.print("\n================================\n");
        for (int i = 0; i < products.length; i++) {
            if (products[i] instanceof Present) {
                System.out.printf("%d. %s\t-> %b\n",
                    i,
                    products[i].whoAmI(),
                    ((Present)products[i]).itCanBePresented()
                );
            }
        }
    }
}
