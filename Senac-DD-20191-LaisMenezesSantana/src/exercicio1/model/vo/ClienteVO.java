package exercicio1.model.vo;

public class ClienteVO  extends PessoaVO{

	private int idCLiente;

	public ClienteVO(String nome, int cpf, TelefoneVO[] telefone, EnderecoVO endereco, int idCLiente) {
		super(nome, cpf, telefone, endereco);
		this.idCLiente = idCLiente;
	}

	public int getidCLiente() {
		return idCLiente;
	}

	public void setidCLiente(int idCLiente) {
		this.idCLiente = idCLiente;
	}
	
	
	
	

}
