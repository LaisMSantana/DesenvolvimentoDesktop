package exercicio2.model.vo;

public class UsuarioVO {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private NivelVO nivel;
	private boolean flagAtiva;

	public UsuarioVO(int id, String nome, String email, String senha, NivelVO nivel, boolean flagAtiva) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
		this.flagAtiva = flagAtiva;
	}
	public UsuarioVO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public NivelVO getNivel() {
		return nivel;
	}
	public void setNivel(NivelVO nivel) {
		this.nivel = nivel;
	}
	public boolean isFlagAtiva() {
		return flagAtiva;
	}
	public void setFlagAtiva(boolean flagAtiva) {
		this.flagAtiva = flagAtiva;
	}
	public String toString() {
		return "Usuario [IdUsuario=" + getId() + ", Nome=" + getNome()
				+ ", Email=" + getEmail() + ", senha=" + getSenha() + ", nivel="+ getNivel() +"]";
	}
	
	

}
