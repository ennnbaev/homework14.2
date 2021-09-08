package com.company;

public class ManyThread implements Runnable{
    String []mass=new String[20000000];
    int min,max;
    public ManyThread(int min ,int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public void run() {
        for (int i=min;i< max;i++){
            Main.inputMass(mass,i);
        }
    }

}
