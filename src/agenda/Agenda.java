/*
Copyright (C) 2018  <josejanailton@gmail.com>

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, 

USA.
*/



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
