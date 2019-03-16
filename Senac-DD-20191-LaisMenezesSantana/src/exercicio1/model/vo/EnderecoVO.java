package exercicio1.model.vo;

public class EnderecoVO {
	
	private String rua;
	private int cep;
	private String estado;
	private String cidade;
	
	public EnderecoVO(String rua, int cep, String estado, String cidade) {
		super();
		this.rua = rua;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
	}
	
	public EnderecoVO() {
		super();
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


}
