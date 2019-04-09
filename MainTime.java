
public class MainTime {

	public static void main(String[] args) {
		Time t1 = new Time();
		// representação string, padrão 00:00:00
		System.out.println(t1.toString().equals("00:00:00"));
		Time t2 = new Time(1, 40, 5);
		System.out.println(t2.toString().equals("01:40:05"));
		Time t3 = t1.plus(t2);
		System.out.println(t3.toString().equals("01:40:05"));
		System.out.println(t3.getHours() == 1);
		System.out.println(t3.getMinutes() == 40);
		System.out.println(t3.getSeconds() == 5);
		// deve ser imutável
		System.out.println(t1.getHours() == 0);
		System.out.println(t1.getMinutes() == 0);
		System.out.println(t1.getSeconds() == 0);
		// plus (mais) e equals
		Time t4 = t3.plus(t2);
		System.out.println(t4.toString().equals("03:20:10"));
		System.out.println(t4.equals(new Time(3, 20, 10)));
		Time t5 = t2.plusHours(1);
		System.out.println(t5.equals(new Time(2, 40, 5)));
		Time t6 = t4.plusHours(23);
		System.out.println(t6.equals(new Time(2, 20, 10)));
		Time t7 = t6.plusMinutes(10);
		System.out.println(t7.equals(new Time(2, 30, 10)));
		Time t8 = t7.plusSeconds(80);
		System.out.println(t8.equals(new Time(2, 31, 30)));
		// até aqui 0.2

		// métodos consulta
		Time t9 = new Time().plusHours(19).plusMinutes(23).plusSeconds(18);
		System.out.println(t9.toString().equals("19:23:18"));
		Time t10 = t9.plusHours(-1).plusMinutes(-1).plusSeconds(-1);
		System.out.println(t10.toString().equals("18:22:17"));
		Time t11 = t10.minusHours(2).minusMinutes(2).minusSeconds(2);
		System.out.println(t11.toString().equals("16:20:15"));
		Time t12 = t11.minusHours(-5);
		System.out.println(t12.toString().equals("21:20:15"));
		Time t13 = t11.minus(t12);
		System.out.println(t13.toString().equals("19:00:00"));
		System.out.println(t13.isMidDay() == false);
		Time t14 = t13.minus(t13);
		System.out.println(t14.toString().equals("00:00:00"));
		System.out.println(t14.isMidDay() == false); // é meio-dia?
		System.out.println(t14.isMidNight() == true); // é meia-noite?
		System.out.println(t14.plusHours(12).isMidDay() == true);
		Time t15 = new Time(3, 40);
		System.out.println(t15.toString().equals("03:40:00"));
		Time t16 = t15.shift(); // inverte turno
		System.out.println(t16.toString().equals("15:40:00"));
		Time t17 = t16.shift();
		System.out.println(t17.toString().equals("03:40:00"));
		Time t18 = t17.tick();
		System.out.println(t18.toString().equals("03:40:01"));
		Time t19 = t18.tick().tick().tick(); // cada tick um segundo
		System.out.println(t19.toString().equals("03:40:04"));
		Time t20 = t19.plusHours(50).plusMinutes(50).minusSeconds(50).tick().shift();
		System.out.println(t20.toString().equals("18:29:15"));
		// até aqui 0.4

		// situações especiais
		Time esp = new Time(-1, 40, 5); // 24 - 1
		System.out.println(esp); // 23:40:05
		System.out.println(esp.toString().equals("23:40:05"));
		esp = new Time(12, -15, -5); // 60 - 15, 60 - 5
		System.out.println(esp.toString().equals("12:45:55"));
		esp = new Time(25, 70, 70);
		System.out.println(esp.toString().equals("02:11:10"));
		esp = new Time(-28, 10, 20); // 24 - 28 = -4, 24 - 4
		System.out.println(esp.toString().equals("20:10:20"));
		// até aqui 0.5

	}

}
