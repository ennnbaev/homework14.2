package com.company;

public class ManyThreads implements Runnable{
    String []mass=new String[20000000];
    int min,max;
    public ManyThreads(int min , int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public void run() {
        for (int i=min;i<max;i++){
            Main.inputMass(mass,i);
        }
    }

}
