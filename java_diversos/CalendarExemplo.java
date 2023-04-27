package java_diversos;

import java.util.Calendar;

public class CalendarExemplo 
{
	private final static int daysAhead = 5;
	private final static int daysAlert = 7;
	
	public static void main(String[] args) 
	{
		Calendar calAtual = Calendar.getInstance();
		System.out.println("hoje = " + calAtual.getTime().toString());
		
		Calendar calEvent = Calendar.getInstance();	
		calEvent.add(Calendar.DAY_OF_YEAR, daysAhead);		// data de hoje mais X dias
		System.out.println("even = " + calEvent.getTime().toString());
		
		Calendar calAlert = (Calendar) calEvent.clone();
		calAlert.add(Calendar.DAY_OF_YEAR, -daysAlert);		// X dias para o evento
		System.out.println("aler = " + calAlert.getTime().toString());
		
		long miliAtual = calAtual.getTimeInMillis(); // pode ser usado para mensurar tempo de execucao
		long miliEvent = calEvent.getTimeInMillis();
		System.out.println(miliAtual);
		System.out.println(miliEvent);
		System.out.println(miliEvent - miliAtual);
		
		if( calAtual.after(calAlert) && calAtual.before(calEvent))
		{
			System.out.println("ALERTA! Evento pr�ximo!");
		}
		
		
		
		

	}

}
