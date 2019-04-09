
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

}
