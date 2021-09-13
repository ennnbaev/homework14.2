package com.company;

public class OneThread implements Runnable {
    String[] mass = new String[20000000];

    @Override
    public void run() {
        for (int i = 0; i < mass.length; i++) {
            Main.inputMass(mass, i);
        }
    }

}
