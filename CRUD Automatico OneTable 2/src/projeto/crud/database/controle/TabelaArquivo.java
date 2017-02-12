package projeto.crud.database.controle;

import java.sql.Connection;
import java.util.List;

import projeto.crud.constantes.Const;
import projeto.crud.io.IOExcel;



/**
 * Classe resposável por gravar os dados da tabela em um arquivo Excel
 * @author RHUAN
 *
 */
public class TabelaArquivo {

	private MetadadosTable metaTable;
	private String tabela;

	public TabelaArquivo(String nomeTabela, Connection connection) {
		this.metaTable = new MetadadosTable(nomeTabela, connection);
		this.tabela = nomeTabela;
	}


	/**
	 * Tabela Campos Tipo Size Null Pk FK Imported From In table Exported For In
	 * table
	 */
	public void gravarTabelaEmArquivo() {
		int linha = Const.INICIO_LINHA;
		IOExcel.criarArquivo();
		setCabecalho();
		gravarNomeTabela  (linha);
		gravarCampos      (linha);
		gravarTipos       (linha);
		gravarTamanho     (linha);
		gravarIsNull      (linha);
		gravarPrimaryKey  (linha);
		gravar(Const.FIM_TABELA, IOExcel.getRows(), 0); //grava marcador para o final da nomeTabela

	}





	/**
	 * Método que grava um dado em um arquivo xls
	 * @param dado
	 * @param linha
	 * @param coluna
	 */
	private <T> void gravar(T dado, int linha, int coluna) {
		if (dado.getClass().getTypeName().contains("String")) {
			IOExcel.gravarCelula(dado.toString(), linha, coluna);
		} else if (dado.getClass().getTypeName().contains("Integer")) {
			IOExcel.gravarCelula(Integer.toString((int) dado), linha, coluna);
		} else {
			System.out.println("ERRO! TIPO DE DADO DESCONHECIDO! - " + TabelaArquivo.class);
		}
	}







	/**
	 * Grava o nome de uma nomeTabela no arquivo excel
	 * @param nomeTabela
	 * @param linha
	 */
	private void gravarNomeTabela(int linha) {
		IOExcel.gravarCelula(tabela, linha, Const.TABELA);
	}



	/**
	 * Grava as primary keys da nomeTabela
	 * @param nomeTabela
	 * @param linha
	 */
	private void gravarPrimaryKey(int linha) {
		List<String> pks = metaTable.getPrimaryKey();
		if (pks != null) {
			for (String pk : pks) {
				gravar(pk, linha, Const.PK);
				linha++;
			}
		}
	}



    /**
     * Grava a coluna campos
     * @param nomeTabela
     * @param linha
     */
	private void gravarCampos(int linha) {
		List<String> campos = metaTable.getNomeColunas();
		for (String campo : campos) {
			gravar(campo, linha, Const.CAMPOS);
			linha++;
		}
	}

	/**
	 * Grava a coluna tipos
	 * @param nomeTabela
	 * @param linha
	 */
	private void gravarTipos(int linha) {
		List<String> tipos = metaTable.getType();
		for (String tipo : tipos) {
			gravar(tipo, linha, Const.TIPO);
			linha++;
		}

	}

	/**
	 * Grava a coluna tamanho
	 * @param nomeTabela
	 * @param linha
	 */
	private void gravarTamanho(int linha) {
		List<String> tamanhos = metaTable.getSize();
		for (String tamanho : tamanhos) {
			gravar(tamanho, linha, Const.SIZE);
			linha++;
		}
	}

	/**
	 * Grava a coluna Null
	 * @param nomeTabela
	 * @param linha
	 */
	private void gravarIsNull(int linha) {
		List<String> isNull = metaTable.isNull();
		for (String isnull : isNull) {
			gravar(isnull, linha, Const.NULL);
			linha++;
		}
	}



	/**
	 * Método para gravar o cabeçalho do arquivo
	 */
	private void setCabecalho() {
		IOExcel.gravarCelula("TABELA", 0, Const.TABELA);
		IOExcel.gravarCelula("CAMPOS", 0, Const.CAMPOS);
		IOExcel.gravarCelula("TIPO",   0, Const.TIPO);
		IOExcel.gravarCelula("SIZE",   0, Const.SIZE);
		IOExcel.gravarCelula("NULL",   0, Const.NULL);
		IOExcel.gravarCelula("PK",     0, Const.PK);
	}

}
