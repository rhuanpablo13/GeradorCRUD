package projeto.crud.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projeto.crud.model.Banco;

class Oracle extends Banco{

	private Connection connection = null;

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			connection = DriverManager.getConnection("jdbc:oracle:thin:@" + getHost() + ":" + getPorta() + ":" + getBanco(), getUsuario(), getSenha());
		    System.out.println("CONECTADO COM ORACLE...");
		    return connection;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERRO AO CONECTAR COM ORACLE!");
		}
		return connection;
	}



	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			connection.close();
			System.out.println("DESCONECTADO DO BANCO ORACLE!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO AO DESCONECTAR DO BANCO ORACLE!");
		}
	}

}
