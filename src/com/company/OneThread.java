package com.company;

public class OneThread implements Runnable{
    String []mass=new String[20000000];
    @Override
    public void run() {
for (int i=0;i< mass.length;i++){
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
