
public class TimeSpan {
	
	private final int days;
	private final int hours;
	private final int minutes;
	private final int seconds;

	public TimeSpan(int d, int h, int m, int s) {
		if(d < 0 || h < 0 || m < 0 || s < 0) throw new IllegalArgumentException("Can't be negative !");
		if(d == 0 && h == 0 && m == 0 && s == 0) throw new IllegalArgumentException("Can't be zero !");
		while (s > 60) {
			s-=60;
			m+=1;
		}
		while (m > 60) {
			m-=60;
			h+=1;
		}
		while (h > 24) {
			h-=25;
			d+=1;
		}
		this.seconds = s;
		this.minutes = m;
		this.hours = h;
		this.days = d;
	}

	public TimeSpan(int h, int m, int s) {
		this(0,h,m,s);
	}

	public int getDays() {
		
		return this.days;
	}

	public int getHours() {
		// TODO Auto-generated method stub
		return this.hours;
	}

	public int getMinutes() {
		// TODO Auto-generated method stub
		return this.minutes;
	}

	public int getSeconds() {
		// TODO Auto-generated method stub
		return this.seconds;
	}
	public boolean greaterThan(TimeSpan t) {
		if(this.equals(t)) return false;
		else if(this.getDays() > t.getDays()) return true;
		else if (this.getHours() > t.getHours() && this.getDays() == t.getDays()) return true;
		else if (this.getMinutes() > t.getMinutes() && this.getHours() == t.getHours()) return true;
		else if (this.getSeconds() > t.getSeconds() && this.getMinutes() == t.getMinutes()) return true;
		return false;
	}
	
	public boolean lessThan(TimeSpan t) {
			if(this.equals(t)) return false;
			return !this.greaterThan(t);
	}
	@Override
	
	public String toString() {
		String frase ="";
		if(getDays() == 1) frase += getDays() + " day";
		else if(getDays() > 1) frase += getDays() + " days";
		
		if(getDays() > 0 && getHours() > 0) frase += ", ";
		
		if(getHours() == 1) frase += getHours() + " hour";
		else if(getHours() > 1) frase += getHours() + " hours";
		
		if(getHours() > 0 && getMinutes() > 0) frase += ", ";
		
		if(getMinutes() == 1) frase += getMinutes() + " minute";
		else if(getMinutes() > 1) frase += getMinutes() + " minutes";
		
		if(getMinutes() > 0 && getSeconds() > 0) frase += " e ";
		
		if(getSeconds() == 1) frase += getSeconds() + " second";
		else if(getSeconds() > 1) frase += getSeconds() + " seconds";
		return frase;
	}
	
	public boolean equals(TimeSpan outro) {
		if(this.getDays() == outro.getDays() && this.getHours() == outro.getHours() && this.getMinutes() == outro.getMinutes() && this.getSeconds() == outro.getSeconds()) return true;
		return false;
	}
	
	public String toString(String string) {
		if(string == "pt") {
			String frase ="";
			if(getDays() == 1) frase += getDays() + " dia";
			else if(getDays() > 1) frase += getDays() + " dias";
			
			if(getDays() > 0 && getHours() > 0) frase += ", ";
			
			if(getHours() == 1) frase += getHours() + " hora";
			else if(getHours() > 1) frase += getHours() + " horas";
			
			if(getHours() > 0 && getMinutes() > 0) frase += ", ";
			
			if(getMinutes() == 1) frase += getMinutes() + " minuto";
			else if(getMinutes() > 1) frase += getMinutes() + " minutos";
			
			if(getMinutes() > 0 && getSeconds() > 0) frase += " e ";
			
			if(getSeconds() == 1) frase += getSeconds() + " segundo";
			else if(getSeconds() > 1) frase += getSeconds() + " segundos";
			return frase;
		}
		else throw new IllegalArgumentException("Language not found");
	}	
}
