package agenda;

import database.TbAgendaMysql;

public class Agenda {
	private String Nome;
	private String Endereco;
	private String Telefone;
	private String Email;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Agenda(String nome, String endereco, String telefone, String email) {
		super();
		Nome = nome;
		Endereco = endereco;
		Telefone = telefone;
		Email = email;
	}
	
	public boolean Save() {
		
		TbAgendaMysql tbagenda = new TbAgendaMysql(this);
		return tbagenda.InsertData();
	}


}
