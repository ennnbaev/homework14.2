package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	//Засекаю время и запускаю один поток
    	LocalDateTime start=LocalDateTime.now();
	Thread result=new Thread(new OneThread());
	result.start();
	result.join();
		LocalDateTime end=LocalDateTime.now();
		Duration durationOneThread=Duration.between(start,end);
		System.out.println(durationOneThread.toMillis());
       //Засекаю время и запускаю 4 потока
		LocalDateTime start2=LocalDateTime.now();
		List<Thread>thread=new ArrayList<>();
		int begin=0;
		for (int i=0;i<4;i++){
			thread.add(new Thread(new ManyThreads(begin,begin+=5000000)));
			thread.get(i).start();
		}
        for (int i=0;i<4;i++){
	     thread.get(i).join();

        }
		LocalDateTime end2=LocalDateTime.now();
		Duration durationManyThreads=Duration.between(start2,end2);
		System.out.println(durationManyThreads.toMillis());

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
