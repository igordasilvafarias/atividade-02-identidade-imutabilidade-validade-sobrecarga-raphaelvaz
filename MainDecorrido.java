
public class MainDecorrido {

	public static void main(String[] args) {
		// construtores
		TimeSpan ts1 = new TimeSpan(7, 3, 45, 35);
		System.out.println(ts1.getDays() == 7);
		System.out.println(ts1.getHours() == 3);
		System.out.println(ts1.getMinutes() == 45);
		System.out.println(ts1.getSeconds() == 35);
		
		ts1 = new TimeSpan(8, 12, 9);
		System.out.println(ts1.getDays() == 0);
		System.out.println(ts1.getHours() == 8);
		System.out.println(ts1.getMinutes() == 12);
		System.out.println(ts1.getSeconds() == 9);
		ts1 = new TimeSpan(4, 18, 110); // entradas adaptáveis
		System.out.println(ts1.getDays() == 0);
		System.out.println(ts1.getHours() == 4);
		System.out.println(ts1.getMinutes() == 19);
		System.out.println(ts1.getSeconds() == 50);
		
		ts1 = new TimeSpan(4, 68, 110); // entradas adaptáveis
		System.out.println(ts1.getDays() == 0);
		System.out.println(ts1.getHours() == 5);
		System.out.println(ts1.getMinutes() == 9);
		System.out.println(ts1.getSeconds() == 50);
		// até aqui 0.1
		
		// validade e exceções
		try {
		  ts1 = new TimeSpan(-1, 4, 68, 110);
		  // se essa linha for impressa uma exceção não foi lançada
		  // falhando no caso de teste
		  System.out.println(false);
		} catch (IllegalArgumentException e) {
		  System.out.println(true); // se for impresso a exceção foi lançada! ok!
		  System.out.println(e.getMessage()); // Can't be negative
		}
		
		try {
		  ts1 = new TimeSpan(1, -4, 68, 110); System.out.println(false);
		} catch (IllegalArgumentException e) {
		  System.out.println(true);
		}
		try {
		  ts1 = new TimeSpan(1, 4, -68, 110); System.out.println(false);
		} catch (IllegalArgumentException e) {
		  System.out.println(true);
		}
		try {
		  ts1 = new TimeSpan(1, 4, 68, -110); System.out.println(false);
		} catch (IllegalArgumentException e) {
		  System.out.println(true);
		}
		
		try {
		  ts1 = new TimeSpan(0, 0, 0, 0); System.out.println(false);
		} catch (IllegalArgumentException e) {
		  System.out.println(e.getMessage()); // Can't be zero
		  System.out.println(true);
		}
		
		// até aqui 0.2
		// toString
		System.out.println(ts1); // deve imprimir 5 hours, 9 minutes e 50 seconds
		
		System.out.println(ts1.toString().equals("5 hours, 9 minutes e 50 seconds"));
		TimeSpan ts2 = new TimeSpan(1, 12, 45, 1);
		System.out.println(ts2.toString().equals("1 day, 12 hours, 45 minutes e 1 second"));
		TimeSpan ts3 = new TimeSpan(0, 0, 0, 15);
		System.out.println(ts3.toString().equals("15 seconds"));
		ts3 = new TimeSpan(0, 1, 0, 0);
		System.out.println(ts3.toString().equals("1 hour"));
		ts3 = new TimeSpan(0, 0, 25, 0);
		System.out.println(ts3.toString().equals("25 minutes"));
		// toString em português
		
		System.out.println(ts1.toString("pt").equals("5 horas, 9 minutos e 50 segundos"));
		System.out.println(ts2.toString("pt")); //1 dia, 12 horas, 45 minutos e 1 segundo
		System.out.println(ts2.toString("pt").equals("1 dia, 12 horas, 45 minutos e 1 segundo"));
		System.out.println(ts3.toString("pt").equals("25 minutos"));
		// até aqui 0.3
		
		// equals, greaterThan, lessThan (igual, maior que, menor que)
		TimeSpan ts4 = new TimeSpan(1, 12, 45, 1);
		System.out.println(ts2.equals(ts4) == true);
		System.out.println(ts4.equals(ts2) == true);
		System.out.println(ts4.equals(ts3) == false);
		
		System.out.println(ts4.greaterThan(ts3) == true);
		
		System.out.println(ts4.lessThan(ts3) == false);
		System.out.println(ts3.lessThan(ts2) == true);
		System.out.println(ts4.lessThan(ts2) == false);
		System.out.println(ts4.greaterThan(ts2) == false);
		// até aqui 0.4
	}

}
