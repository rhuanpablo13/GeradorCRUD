package projeto.crud.database.interfaces;

import java.sql.Connection;

public interface IBanco {
	public Connection getConnection();
	public void closeConnection();
}
