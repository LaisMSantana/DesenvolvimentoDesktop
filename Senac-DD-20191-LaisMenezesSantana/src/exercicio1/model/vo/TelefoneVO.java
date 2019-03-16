package exercicio1.model.vo;

public class TelefoneVO {
	private int ddd;
	private int numero;

	public TelefoneVO(int ddd, int numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public TelefoneVO() {
		super();
	}
	
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	

}
