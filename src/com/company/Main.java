package com.company;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {
		LocalDateTime start=LocalDateTime.now();
	Thread result=new Thread(new OneThread());
	result.start();
	result.join();
		LocalDateTime end=LocalDateTime.now();
		Duration duration=Duration.between(start,end);
		System.out.println(duration.toMillis());

		LocalDateTime start2=LocalDateTime.now();
		int begin=0;
		Thread thread = null;
		for (int i=0;i<4;i++){
			thread=new Thread(new ManyThread(begin,begin+=5000000));
			thread.start();
		}
		thread.join();
		LocalDateTime en2=LocalDateTime.now();
		Duration duration2=Duration.between(start2,en2);
		System.out.println(duration2.toMillis());

    }
    static void inputMass(String[]mass,int i){
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
