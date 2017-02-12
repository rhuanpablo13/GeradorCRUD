package projeto.crud.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projeto.crud.model.Banco;

class HSQLDB extends Banco {

	private Connection connection = null;


	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:"+getHost()+":/"+getPorta()+"/" + getBanco(), getUsuario(), getSenha());
            System.out.println("CONECTADO COM HSQLDB...");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERRO AO CONECTAR COM HSQLDB");
        }
		return connection;
	}



	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
            connection.close();
            System.out.println("DESCONECTADO DO HSQLDB...");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ERRO AO DESCONECTAR DO HSQLDB!");
        }
	}

}
