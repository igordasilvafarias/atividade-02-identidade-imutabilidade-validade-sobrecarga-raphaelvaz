import java.io.IOException;

public class CoordMain {

	public static void main(String[] args) throws IOException {
		// construtores:
		Coord c1 = new Coord();
		System.out.println(c1.getLat() == 0.0);
		System.out.println(c1.getLong() == 0.0);
		
		Coord c2 = new Coord(50.0, 134.0);
		System.out.println(c2.getLat() == 50.0);
		System.out.println(c2.getLong() == 134.0);
		
		Coord c3 = new Coord(-90.0, -180.0);
		System.out.println(c3.getLat() == -90.0);
		System.out.println(c3.getLong() == -180.0);
		
		// estas coordenadas são inválidas e devem lançar exceção
		// faça serem rejeitadas e depois comente-as para não parar o programa
		//Coord e1 = new Coord(-91.0, 0.0);
		//Coord e2 = new Coord(100.0, 0.0);
		//Coord e3 = new Coord(10.0, -182.0);
		//Coord e4 = new Coord(10.0, 200.0);
		//Coord e5 = new Coord(-95.0, -200.0);
		
		// imutabilidade: as linhas a seguir devem causar erro de compilação
		// verifique se está de acordo e depois comente-as
		//Coord c4 = new Coord();
		//c4.getLat() = 30.0;  // não deve permitir reatribuição
		//c4.getLong() = 80.0; // não deve permitir reatribuição
		
		// operações/comandos:
		Coord in = new Coord(30.0, 50.0);
		Coord out = in.moveNorth(5.0); // deslocamento
		System.out.println(in.getLat() == 30.0); // deve ser imutável
		System.out.println(out.getLat() == 35.0);
		out.moveNorth(5.0); // sem reatribuição sem alteração
		System.out.println(out.getLat() == 35.0);
		out = out.moveNorth(5.0); // reatribuindo
		System.out.println(out.getLat() == 40.0);
		
		out = out.moveSouth(60.0);
		System.out.println(out.getLat() == -20.0);
		
		out = out.moveSouth(30.0);
		System.out.println(out.getLat() == -50.0);
		out = out.moveSouth(-10.0);
		System.out.println(out.getLat() == -40.0);
		out = out.moveNorth(-10.0);
		System.out.println(out.getLat() == -50.0);
		System.out.println(out.getLong() == 50.0);
		
		out = out.moveEast(50.0);
		System.out.println(out.getLong() == 100.0);
		out = out.moveWest(180.0);
		System.out.println(out.getLong() == -80.0);
		out = out.moveWest(-10.0);
		System.out.println(out.getLong() == -70.0);
		out = out.moveEast(-10.0);
		System.out.println(out.getLong() == -80.0);
		// até aqui 0.2
		
		// consultas:
		Coord q = new Coord();
		System.out.println(q.getLat() == 0);
		System.out.println(q.getLong() == 0);
		System.out.println(q.isEquatorLine() == true);
		System.out.println(q.isMeridianLine() == true);
		
		q = q.moveNorth(10.0);
		System.out.println(q.getLat() == 10);
		
		System.out.println(q.isEquatorLine() == false);
		q = q.moveEast(10.0);
		System.out.println(q.isMeridianLine() == false);
		q = q.moveEast(170.0);
		
		System.out.println(q.getLong() == 180.0);
		System.out.println(q.isMeridianLine() == true);
		q = q.moveWest(200.0);
		System.out.println(q.getLong() == -20.0);
		System.out.println(q.isMeridianLine() == false);
		
		q = q.moveWest(160.0);
		System.out.println(q.getLong() == -180.0);
		System.out.println(q.isMeridianLine() == true);
		
		Coord r = new Coord(30.0, 70.0);
		System.out.println(r.getLat() == 30.0);
		System.out.println(r.getLong() == 70.0);
		System.out.println(r.isNorth() == true);
		System.out.println(r.isSouth() == false);
		System.out.println(r.isOrient() == true);
		System.out.println(r.isOcident() == false);
		r = r.moveWest(140.0).moveSouth(60.0);
		System.out.println(r.getLat() == -30.0);
		System.out.println(r.getLong() == -70.0);
		System.out.println(r.isNorth() == false);
		System.out.println(r.isSouth() == true);
		System.out.println(r.isOrient() == false);
		System.out.println(r.isOcident() == true);
		
		// toString:
		System.out.println(c1.toString().equals("0.0°, 0.0°"));
		System.out.println(c2.toString().equals("50.0°, 134.0°"));
		
		System.out.println(c3.toString().equals("-90.0°, -180.0°"));
		System.out.println(out.toString().equals("-50.0°, -80.0°"));
		System.out.println(q.toString().equals("10.0°, -180.0°"));
		
		System.out.println(r); // -30.0°, -70.0°
		System.out.println(r.toString().equals("-30.0°, -70.0°"));
		
		Coord t = new Coord(-32.0714021, -52.1425059);
		// https://www.google.com.br/maps/@-32.0714021,-52.1425059,13z?hl=pt-BR
		System.out.println(t);; // -32.0714021°, -52.1425059°
		System.out.println(t.toString().equals("-32.0714021°, -52.1425059°"));
		
		// equals:
		System.out.println(t.equals(r) == false);
		Coord y = new Coord(-32.0714021, -52.1425059);
		System.out.println(t.equals(y) == true);
		System.out.println(y.equals(t) == true);
		System.out.println(y.equals(y) == true);
		System.out.println(y.equals(r) == false);
		
		// desafio: escrever método que retorna link para Google Maps!
		Coord a = new Coord(37.402473, -122.3212843);
		String url = a.getGoogleMapsURL();
		System.out.println(url.equals("https://www.google.com.br/maps/@37.402473,-122.3212843,10z?hl=pt-BR"));
		// descomente para ver se funciona (não testei)
		Runtime.getRuntime().exec("google-chrome " + url);
		// tente outro navegador, no windows tente "start " + url
	
	}

}
