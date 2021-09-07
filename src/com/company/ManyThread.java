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
            if(i%5==0&&i%3==0){
                mass[i]="FizzBuzz";
            }
            else if(i%3==0){
                mass[i]="Fizz";
            }
            else if(i%5==0){
                mass[i]="Buzz";
            }
            else{
                mass[i]=String.valueOf(i);
            }
        }

    }

}
