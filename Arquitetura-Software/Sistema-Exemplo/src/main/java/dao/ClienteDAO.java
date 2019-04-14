package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;
import dto.PaisDTO;

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
	
	public List<ClienteDTO> getCliente() {
		try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) { 
			String sql = "SELECT * FROM cliente";
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery(sql); 
			
			List<ClienteDTO> clientes = new ArrayList<>();
			ClienteDTO c = ClienteDTO.builder().build();
			
			while(r.next()) {
				c.setId(r.getInt(1));
				c.setNome(r.getString(2));
				c.setTelefone(r.getString(3));
				c.setIdade(r.getInt(4));
				c.setLimiteCredito(r.getDouble(5));
				c.setPais(PaisDTO.builder().id(r.getInt(6)).build());
				
				clientes.add(c);
				c = ClienteDTO.builder().build();
			}
			
			return clientes;
		} catch (SQLException ex) {
		    ex.printStackTrace();
		    return null;
		}
	}
	
	public boolean delete(int id) {		
		try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {
			
			String sql = "DELETE FROM cliente WHERE id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			int deleted = st.executeUpdate();
			return deleted > 0 ? true : false; 
		} catch (SQLException ex) {
		    ex.printStackTrace();
		    return false;
		}		
	}
	
	public boolean updateCliente(ClienteDTO updateCliente) {
		try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {
			String sql = "UPDATE cliente SET nome=?, telefone=?, idade=?, limiteCredito=?, id_pais =? WHERE id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, updateCliente.getNome());
			st.setString(2, updateCliente.getTelefone());
			st.setInt(3, updateCliente.getIdade());
			st.setDouble(4, updateCliente.getLimiteCredito());
			st.setInt(5, updateCliente.getPais().getId());
			st.setInt(6, updateCliente.getId());
			
			int update = st.executeUpdate();
			return update > 0 ? true : false; 
		} catch (SQLException ex) {
		    ex.printStackTrace();
		    return false;
		}		
	}
}
