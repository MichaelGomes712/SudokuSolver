import java.util.Scanner;
import java.lang.*;
public class Timer{
	public long startTime;
	public long endTime;
	
	/*public Timer(){
		startTime = 0;
		endTime = 0;
	}*/	

	public void start(){
		startTime = System.currentTimeMillis();
	}

	public void stop(){
		endTime = System.currentTimeMillis();
	}

	public long getTime(){
		long diff = endTime - startTime;
		return diff;
	}
}
