
public class Ponto extends Time{
	private  Time entrada;
	private Time saida;
	private String nome;
	

	public Ponto(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		if(this.entrada == null) return this.nome + " não bateu o ponto";
		else if (this.saida == null) return this.nome + " entro às " + this.entrada;
		else return this.nome + " entrou às " + this.entrada + " e saiu às " + this.saida + " e permaneceu " 
				+ (this.entrada.subTime(saida)).getHours() + " horas" + ((this.entrada.subTime(saida)).getSeconds() > 0 ? ", " : " e ")
				+ (this.entrada.subTime(saida)).getMinutes() + " minutos"
				+ ((this.entrada.subTime(saida)).getSeconds() > 0 ? (this.entrada.subTime(saida)).getSeconds() + " e segundos" : "");
	}
	public void bater(int h, int m, int s) {
		if(this.saida != null) throw new IllegalStateException("Entrada e saída já foram batidas e o ponto está fechado");
		else if(this.entrada == null) this.entrada = new Time(h,m,s);
		else this.saida = new Time(h,m,s);
	}
}

