package exercicio2.model.vo;

public class NivelVO {
	private int id;
	private String descricao;
	private boolean flagAtiva;
	public NivelVO(int id, String descricao, boolean flagAtiva) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.flagAtiva = flagAtiva;
	}
	public NivelVO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFlagAtiva() {
		return flagAtiva;
	}
	public void setFlagAtiva(boolean flagAtiva) {
		this.flagAtiva = flagAtiva;
	}
	
	

}
