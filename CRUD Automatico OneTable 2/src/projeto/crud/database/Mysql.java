package projeto.crud.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projeto.crud.model.Banco;

class Mysql extends Banco{

	private Connection connection = null;

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try{
			 Class.forName("com.mysql.jdbc.Driver");
		     connection = DriverManager.getConnection("jdbc:mysql://" + getHost() + ":" + getPorta() + "/" + getBanco(), getUsuario(), getSenha());
		     System.out.println("CONECTADO COM O BANCO MYSQL...");
		     return connection;
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("ERRO AO CONECTAR COM MYSQL");
		}
		return connection;
	}


	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			connection.close();
			System.out.println("DESCONECTADO DO MYSQL!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO AO DESCONECTAR DO MYSQL!");
		}
	}


}
