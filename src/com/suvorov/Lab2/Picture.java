package com.suvorov.Lab2;

public class Picture implements Present {
    @Override
    public Boolean itCanBePresented() {
        return false;
    }

    @Override
    public String whoAmI() {
        return "I am the Picture";
    }
}
