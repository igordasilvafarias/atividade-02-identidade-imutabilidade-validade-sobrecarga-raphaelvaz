
public class Time {
	private final int seconds;
	Time(){
		this.seconds = 0;
	}
	Time(int h, int m){
		this(h,m,0);
	}
	Time(int h, int m, int s){
		//NOT OK
		while (h < -24) h+=24;
		int seconds = (h < 0 ? (24+h)*3600 : h*3600) + (m < 0 ? (60+m)*60 : m*60) + (s < 0 ? (60+s) : s);
		while(seconds > 86400) seconds -= 86400;
		this.seconds = seconds;
	}
  //Para implementar Ponto
  //--------------------
	Time subTime(Time t) {
		if(this.seconds < t.seconds) return new Time(0,0,t.seconds - this.seconds);
		return new Time(0,0,(86400 + t.seconds) - this.seconds);
	}
	//--------------------
	int getSeconds() {
		if(this.seconds > 3600) return this.seconds%60%60%60;
		else if(this.seconds > 60) return this.seconds%60;
		else return this.seconds;
	}
	int getMinutes() {
		if(this.seconds > 3600) return this.seconds%3600/60;
		else return this.seconds/60;
	}
	int getHours() {
		return this.seconds/60/60;
	}
	Time plus(Time t) {
		return new Time(0,0,this.seconds + t.seconds); 
	}
	Time minus(Time t) {
		//NOT OK
		if(t.seconds > this.seconds) return new Time(0,0,this.seconds - t.seconds + 86400);
		return new Time(0,0,this.seconds - t.seconds); 
	}
	Time plusHours(int h) {
		return new Time(0,0,this.seconds+3600*h);
	}
	Time plusMinutes(int m) {
		return new Time(0,0,this.seconds+60*m);
	}
	Time plusSeconds(int s) {
		return new Time(0,0,this.seconds+s);
	}
	Time minusHours(int h) {
		return this.plusHours(-h);
	}
	Time minusMinutes(int m) {
		return this.plusMinutes(-m);
	}
	Time minusSeconds(int s) {
		return this.plusSeconds(-s);
	}
	boolean isMidDay(){
		if(this.seconds == 43200) return true;
		return false;
	}
	boolean isMidNight(){
		if(this.seconds == 0) return true;
		return false;
	}
	Time shift() {
		return new Time(0,0,this.seconds + 43200);
	}
	Time tick() {
		return new Time(0,0,this.seconds + 1);
	}
	@Override
	public String toString() {
		return (getHours() < 10 ? "0" : "") + getHours() + ":"
			+ (getMinutes() < 10 ? "0" : "") + getMinutes() + ":" 
			+ (getSeconds() < 10 ? "0" : "") + getSeconds();
	}
	public boolean equals(Time t) {
		return this.seconds == t.seconds;
	}
}
