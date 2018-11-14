package com.laundrovalley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class LaundroValleyApplication {
	public static void main(String args[]) {
		SpringApplication.run(LaundroValleyApplication.class, args);
		
		/*
		final long timeInterval = 1000;
		  Runnable runnable = new Runnable() {
		  public void run() {
		    while (true) {
		      // ------- code for task to run
		    	System.out.println("Timer task!!!!!");
		      // ------- ends here
		      try {
		    	  
		       Thread.sleep(timeInterval);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		      }
		    }
		  };
		  Thread thread = new Thread(runnable);
		  thread.start();
		*/
		
	}

}
