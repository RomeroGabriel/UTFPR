package dao;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
