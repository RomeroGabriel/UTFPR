package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ClienteDTO;

public class ClienteDAO {
	
	//Construtor da classe que cria a tabela já
	public ClienteDAO() {
		try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {
            conn.createStatement().executeUpdate(
            "CREATE TABLE cliente (" +
						"id int NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT id_cliente_pk PRIMARY KEY," +
						"nome varchar(255)," +
						"telefone varchar(30)," + 
						"idade int," + 
                        "limiteCredito double," +
                        "id_pais int)");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public boolean save(ClienteDTO cliente) {
		try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) { 
			String sql = "INSERT INTO cliente (nome, telefone, idade, limiteCredito, id_pais) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getTelefone());
			st.setInt(3, cliente.getIdade());
			st.setDouble(4, cliente.getLimiteCredito());
			st.setInt(5, cliente.getPais().getId());
			
			int result = st.executeUpdate();
			return result > 0 ? true : false;
		} catch (SQLException ex) {
		    ex.printStackTrace();
		    return false;
		}		
	}
	
	public boolean delete(int id) {
		return false;
	}
	
	public ClienteDTO getCliente(int id) {
		return null;
	}
	
	public boolean updateCliente(ClienteDTO id) {
		return false;
	}
}
