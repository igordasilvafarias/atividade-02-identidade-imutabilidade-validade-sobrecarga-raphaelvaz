
public class MainPonto {

	public static void main(String[] args) {
		// Spock é um Funcionário
		// Ponto representa uma presença do funcionário
		// Ponto é mutável
		
		Ponto ponto = new Ponto("Spock");
		// toString
		
		System.out.println(ponto); // Spock não bateu ponto
		
		// Spock bateu ponto às 7:50:15
		ponto.bater(7, 50, 15);
		System.out.println(ponto); // Spock entrou às 7:50:15
		ponto.bater(12, 2, 10);
		System.out.println(ponto); // Spock entrou às 7:50:15 e saiu às 12:02:10 e permaneceu 4 horas, 2 minutos e 10 segundos
		System.out.println(ponto.toString().equals("Spock entrou às 7:50:15 e saiu às 12:02:10 e permaneceu 4 horas, 2 minutos e 10 segundos"));
		
		Ponto ponto2 = new Ponto("Kirk");
		ponto2.bater(14, 0, 0);
		System.out.println(ponto2); // Kirk entrou às 14:00:00
		ponto2.bater(3, 10, 0);
		System.out.println(ponto2); // Kirk entrou às 14:00:00 e saiu às 03:10:00 e permaneceu 13 horas e 10 minutos
		System.out.println(ponto2.toString().equals("Kirk entrou às 14:00:00 e saiu às 03:10:00 e permaneceu 13 horas e 10 minutos"));
		
		// não deve ser possível bater o ponto fechado
		try {
		  ponto2.bater(4, 15, 8);
		  System.out.println(false); // falhou
		} catch (IllegalStateException e) {
		  System.out.println(e.getMessage()); // Entrada e saída já foram batidas e o ponto está fechado
		  System.out.println(true); // ok
		}
	}

}
