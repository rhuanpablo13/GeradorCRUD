package projeto.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Teste{
	private Connection connection;

    public Teste(Connection connection) {
        this.connection = connection;
    }

    public Teste() {
		// TODO Auto-generated constructor stub
	}

    public int getIdCrm(){
    	return 0;
    }
    public String getNome(){
    	return "";
    }
    public String getEspecializacao(){
    	return "";
    }


    public void adicionar(Teste medico){

    	String insert = "INSERT INTO medico(idMedico, Nome, Especializacao) values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(insert);
			ps.setLong   (1, medico.getIdCrm());
			ps.setString (2, medico.getNome());
			ps.setString (3, medico.getEspecializacao());
			int returnPs = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Teste findForId (int id) {

		//String select = "SELECT * FROM medico WHERE idMedico = ?";
    	String select = "#SELECT_FINDFORID_JDBC_MYSQL";
		PreparedStatement ps;
		Teste medicoBean = new Teste();
		try {
			ps = connection.prepareStatement(select);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				medicoBean = new Teste();
				medicoBean.setIdCrm(rs.getInt("idMedico"));
				medicoBean.setNome(rs.getString("nome"));
				medicoBean.setEspecializacao(rs.getString("especializacao"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return medicoBean;
	}


	public Teste findForString (String str) {

		//String select = "SELECT * FROM medico WHERE idMedico = ?";
		String select = "#SELECT_FINDFORSTRING_JDBC_MYSQL";
		PreparedStatement ps;
		Teste medicoBean = new Teste();
		try {
			ps = connection.prepareStatement(select);
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				medicoBean = new Teste();
				medicoBean.setIdCrm(rs.getInt("idMedico"));
				medicoBean.setNome(rs.getString("nome"));
				medicoBean.setEspecializacao(rs.getString("especializacao"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicoBean;
	}



	public void setIdCrm(int i){

	}
	public void setNome(String i){

	}
	public void setEspecializacao(String i){

	}
//
//



	public List<Teste> listar(){

		//String select = "SELECT * FROM medico";
		String select = "#SELECT_LISTAR_JDBC_MYSQL";
		PreparedStatement stmt;
		List<Teste> medicos = new ArrayList<Teste>();
		try {
			stmt = this.connection.prepareStatement(select);
			ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
			    Teste medicoBean = new Teste();
			    medicoBean.setIdCrm(rs.getInt("idMedico"));
				medicoBean.setNome(rs.getString("Nome"));
				medicoBean.setEspecializacao(rs.getString("Especializacao"));
			    medicos.add(medicoBean);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicos;
	}
//
//
	public void atualizar (Teste medico){

		//String update = "UPDATE medico SET Nome = ?, Especializacao = ? WHERE idMedico = ?";
		String update = "#UPDATE_ATUALIZAR_JDBC_MYSQL";
		PreparedStatement ps;
		try {
			ps = this.connection.prepareStatement(update);
			ps.setLong   (3, medico.getIdCrm());
			ps.setString (1, medico.getNome());
			ps.setString (2, medico.getEspecializacao());

			int returnAlter = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//
//
	public void excluir(Teste medico){

		//String delete = "DELETE FROM medico WHERE idMedico=?";
		String delete = "#DELETE_EXCLUIR_JDBC_MYSQL";
		PreparedStatement ps;
		try {
			ps = this.connection.prepareStatement(delete);
			ps.setLong(1, medico.getIdCrm());

			int returnDelete = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
