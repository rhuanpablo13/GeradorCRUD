package projeto.crud.database;

import projeto.crud.constantes.Const;
import projeto.crud.database.connection.ConnectionSingleton;

/**
 * Classe que retorna a conexão selecionada pelo usuário!
 * A conexão é setada n atributo connection da classe ConnectionSingleton
 * @author RHUAN
 *
 */
public class SelectDatabaseConnection {


	public static void getDatabase(String databaseSelected){
		ConnectionSingleton singleton = ConnectionSingleton.getInstance();

		switch (databaseSelected)
		{
			case Const._ORACLE:
				Oracle oracle = new Oracle();
				singleton.setConnection(oracle.getConnection());
				break;
			case Const._MYSQL:
				Mysql mysql = new Mysql();
				singleton.setConnection(mysql.getConnection());
				break;
			case Const._HSQLDB:
				HSQLDB hsqldb = new HSQLDB();
				singleton.setConnection(hsqldb.getConnection());
				break;
		}
	}
}
