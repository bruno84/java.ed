package java_diversos;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadExemplo 
{
	private final static long FREQ_MILISEC = 1000*1; 
	
	public static void main(String[] args) 
	{
		Calendar calendarStart = Calendar.getInstance();
		
		TimerTask timerTask = new MyTimerTask();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, calendarStart.getTime(), FREQ_MILISEC); // chama run()
	}

}


class MyTimerTask extends TimerTask 
{
	private static int count = 1;
	
	@Override
	public void run() 
	{
		System.out.println("EXECUTANDO pela " + count + " vez");	
		count++;
	}
}




