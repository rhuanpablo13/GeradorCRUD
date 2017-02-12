package projeto.crud.database.connection;

import java.sql.Connection;


/**
 * Classe Singleton para conexões,
 * o atributo connection recebe uma conexão vinda
 * de uma das classes concretas de conexão... (HSQLBD, MYSQL, ORACLE etc...)
 * @author RHUAN
 *
 */
public class ConnectionSingleton{

	private static ConnectionSingleton instance = new ConnectionSingleton();
	private Connection connection;

	private ConnectionSingleton() {

	}

	public static ConnectionSingleton getInstance(){
		return instance;
	}


	public Connection getConnection(){
		return connection;
	}

	public void setConnection(Connection connection){
		this.connection = connection;
	}

}
