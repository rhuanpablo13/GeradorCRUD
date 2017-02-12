package projeto.crud.model;

import java.sql.Connection;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import projeto.crud.database.interfaces.IBanco;

public abstract class Banco implements IBanco{

	/**Propriedades de conexão de um banco*/
	private static StringProperty usuario  = new SimpleStringProperty();
	private static StringProperty senha    = new SimpleStringProperty();
	private static StringProperty host     = new SimpleStringProperty();
	private static StringProperty banco    = new SimpleStringProperty();
	private static StringProperty porta    = new SimpleStringProperty();


	public Banco() {

	}


	@Override
	public abstract Connection getConnection();

	@Override
	public abstract void closeConnection();


	//GETTERS E SETTERS
	public static String getUsuario() {
		return usuario.get();
	}

	public static void setUsuario(String usuario) {
		Banco.usuario.set(usuario);
	}

	public StringProperty usuario() {
        return usuario;
    }


	public static String getSenha() {
		return senha.get();
	}

	public static void setSenha(String senha) {
		Banco.senha.set(senha);
	}

	public StringProperty senha() {
        return senha;
    }


	public static String getHost() {
		return host.get();
	}

	public static void setHost(String host) {
		Banco.host.set(host);
	}

	public StringProperty host() {
        return host;
    }


	public static String getBanco() {
		return banco.get();
	}

	public static void setBanco(String banco) {
		Banco.banco.set(banco);
	}

	public StringProperty banco() {
        return banco;
    }



	public static String getPorta() {
		return porta.get();
	}

	public static void setPorta(String porta) {
		Banco.porta.set(porta);
	}

	public StringProperty porta() {
        return porta;
    }

}
