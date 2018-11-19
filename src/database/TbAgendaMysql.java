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


package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import agenda.Agenda;

public class TbAgendaMysql {
	
	private static Connection conn= null;	
	private String m_url = "jdbc:mysql://127.0.0.1:3306/";
	private String m_dbname = "db_agenda";
	private String m_username = "root";
	private String m_password = "";
	private Agenda m_agenda;
	
	public TbAgendaMysql(Agenda agenda) {
		super();
		m_agenda = agenda;
		
		try {
		    conn =  DriverManager.getConnection(m_url + m_dbname + "?user=" + m_username + "&password=" + m_password 
		    		   + "&useLegacyDatetimeCode=false&serverTimezone=America/New_York");
		    
		    if (conn != null)  System.out.println("Connection to MySQL created with sucess!");
		    else System.out.println("Connection to MySQL Error!");


		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());	
		}
	}
	
	public boolean InsertData() {
		
		int id = getLastID();
		String query = "INSERT INTO tb_agenda (id, ag_nome, ag_endereco, ag_telefone, ag_email) VALUES (?, ?, ?, ?,?);";
		
        
		try {
            PreparedStatement insertStatement = conn.prepareStatement(query);
            insertStatement.setInt(1, id);
            insertStatement.setString(2, this.m_agenda.getNome());
            insertStatement.setString(3, this.m_agenda.getEndereco());
            insertStatement.setString(4, this.m_agenda.getTelefone());
            insertStatement.setString(5, this.m_agenda.getEmail());
            insertStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }		
		
		
		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	/*
	 * 
	 * Esta função gera ids válidos para salvar as informações da agenda no banco de dados.
	 * 
	 */
	
	public int getLastID() {
		int resultado = 1;
		final String query = "SELECT * FROM tb_agenda;";
       
        try {
            PreparedStatement selectStatement = conn.prepareStatement(query);
            //selectStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
            	resultado++;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
	}

}
