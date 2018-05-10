package com.suvorov.Lab2;

public class Toy implements Present {

    @Override
    public Boolean itCanBePresented() {
        return true;
    }

    @Override
    public String whoAmI() {
        return "I am the Toy";
    }
}
