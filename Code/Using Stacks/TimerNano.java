package com.company;

import static java.lang.System.nanoTime;

public class TimerNano {
    public long startTime;
    public long endTime;

	/*public Timer(){
		startTime = 0;
		endTime = 0;
	}*/

    public void start(){
        startTime = nanoTime();
    }

    public void stop(){
        endTime = nanoTime();
    }

    public double getTime(){
        return (double) (endTime - startTime) / 1000000;
    }
}