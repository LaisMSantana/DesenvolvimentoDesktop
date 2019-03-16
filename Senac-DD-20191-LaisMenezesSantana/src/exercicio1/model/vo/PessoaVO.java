package exercicio1.model.vo;

public abstract class PessoaVO {
	private String nome;
	private int cpf;
	private TelefoneVO[] telefone;
	private EnderecoVO endereco;
	
	public PessoaVO(String nome, int cpf, TelefoneVO[] telefone, EnderecoVO endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public PessoaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public TelefoneVO[] getTelefone() {
		return telefone;
	}
	public void setTelefone(TelefoneVO[] telefone) {
		this.telefone = telefone;
	}
	public EnderecoVO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}
	
	
}
