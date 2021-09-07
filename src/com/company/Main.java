package com.company;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {
		LocalDateTime start=LocalDateTime.now();
	Runnable one=new OneThread();
	Thread result=new Thread(one);
	result.start();
	result.join();
		LocalDateTime end=LocalDateTime.now();
		Duration duration=Duration.between(start,end);
		System.out.println(duration.toMillis());


		LocalDateTime start2=LocalDateTime.now();
		Runnable one1=new ManyThread(0,5000000);
		Runnable one2=new ManyThread(5000000,10000000);
		Runnable one3=new ManyThread(10000000,15000000);
		Runnable one4=new ManyThread(15000000,20000000);
		Thread result1=new Thread(one1);
		Thread result2=new Thread(one2);
		Thread result3=new Thread(one3);
		Thread result4=new Thread(one4);
		result1.start();
		result2.start();
		result3.start();
		result4.start();
		result1.join();
		result2.join();
		result3.join();
		result4.join();
		LocalDateTime en2=LocalDateTime.now();
		Duration duration2=Duration.between(start2,en2);
		System.out.println(duration2.toMillis());

    }
}
