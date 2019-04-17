
public class Coord {
	
	private final double latitude;
	private final double longitude;
	
	Coord(){
		this.longitude = 0;
		this.latitude = 0;
	}

	public Coord(double latitude, double longitude) {
		if(latitude < -90.0 || latitude > 90.0 && longitude < -180.0 || longitude > 180.0) throw new IllegalArgumentException("Latitude e Longitude Invalida !");
		else if(longitude < -180.0 || longitude > 180.0) throw new IllegalArgumentException("Longitude Invalida !");
		else if(latitude < -90.0 || latitude > 90.0) throw new IllegalArgumentException("Latitude invalida !");
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLong() {
		return longitude;
	}

	public double getLat() {
		return latitude;
	}

	public Coord moveNorth(double latitude) {
		
		return new Coord(this.latitude + latitude,this.longitude);
	}

	public Coord moveSouth(double latitude) {
		return new Coord(this.latitude - latitude,this.longitude);
	}

	public Coord moveEast(double longitude) {
		return new Coord(this.latitude,this.longitude + longitude);
	}

	public Coord moveWest(double longitude) {
		return new Coord(this.latitude,this.longitude - longitude);
	}

	public boolean isEquatorLine() {
		if(this.latitude == 0 || this.latitude == 90.0 || this.latitude == -90.0) return true;
		return false;
	}

	public boolean isMeridianLine() {
		if(this.longitude == 0 || this.longitude == 180.0 || this.longitude == -180.0) return true;
		return false;
	}

	public boolean isNorth() {
		if(this.latitude > 0) return true;
		return false;
	}

	public boolean isSouth() {
		return !isNorth();
	}

	public boolean isOrient() {
		if(this.longitude > 0) return true;
		return false;
	}

	public boolean isOcident() {
		return !isOrient();
	}
	@Override
	public String toString() {
		return this.latitude + "°, " + this.longitude + "°";
	}
	public boolean equals(Coord c) {
		return this.latitude == c.latitude && this.longitude == c.longitude;
	}
	public String getGoogleMapsURL() {
		return "https://www.google.com.br/maps/@" + this.latitude + "," + this.longitude + ",10z?hl=pt-BR";
	}
	
}
	