package projeto.crud.gerador;

import java.util.ArrayList;
import java.util.List;

import projeto.crud.constantes.Const;
import projeto.crud.io.IOArquivos;
import projeto.crud.io.IOExcel;

public abstract class Gerador {


	//dados carregados do arquivo padrão
    protected String classeArquivo;


	//métodos abstratos
	public abstract String getClasseBuilded();
	protected abstract void buildClass();

	/**
	 * Método responsável por substituir uma string por outra
	 * @param dados
	 * @param marcacao
	 * @param substituito
	 */
	protected void trocaCampo(String marcacao, String substituito) {
		classeArquivo = classeArquivo.replace(marcacao, substituito);
	}



	/**
	 * Métdo responsável por montar um método get
	 * @param campo
	 * @return String
	 */
	protected String getGettersAtributos(String campo){
		String get = "get";
		get += passarPrimeiroCaracterParaMaiusculo(campo);
		get += "()";
		return get;
	}

	/**
	 * Métdo responsável por montar um método set
	 * @param campo
	 * @return String
	 */
	protected String getSettersAtributos(String campo){
		String set = "set";
		set += passarPrimeiroCaracterParaMaiusculo(campo);
		return set;
	}


	/**
	 * Método responsável por substituir a marcação de #CLASSE
	 * @param Nomeclasse
	 * @param classeArquivo
	 */
	protected void setClasse(String classeMarcacao, String classeSubstituto) {
		trocaCampo(classeMarcacao, passarPrimeiroCaracterParaMaiusculo(classeSubstituto));
		trocaCampo(Const.SUBSTITUIR_ARQ_CLASS, passarPrimeiroCaracterParaMaiusculo(getNomeClasse()));
	}


	/**
	 * Recupera o nome da tabela do arquivo xls
	 * @return String
	 */
	protected String getNomeClasse(){
		String classe = IOExcel.lerCelula(Const.TABELA, 1);
		return classe.toLowerCase();
	}



	/**
	 * Substitui a tag #CABECALHO do arquivo
	 * @param cabecalhoMarcacao
	 * @param cabecalhoSubstituto
	 */
	protected void setCabecalho(String cabecalhoMarcacao, String cabecalhoSubstituto){
		trocaCampo(cabecalhoMarcacao, cabecalhoSubstituto);
	}



	/**
	 * Substitui a tag #PACOTE  do arquivo
	 * @param caminhoPacoteMarcacao
	 * @param caminhoPacoteSubstituto
	 */
	protected void setPacote(String caminhoPacoteMarcacao, String caminhoPacoteSubstituto){
		trocaCampo(caminhoPacoteMarcacao, caminhoPacoteSubstituto);
	}


	/**
	 * Recupera todas as linhas de uma determinada coluna
	 * @param coluna
	 * @return
	 */
	protected List<String> getColuna(int coluna) {
		int linha = Const.INICIO_LINHA; // posi��o inicial onde os dados est�o
										// gravados
		List<String> dados = new ArrayList<String>();
		boolean flag = false;
		do {
			String dado = IOExcel.lerCelula(coluna, linha);
			if (!dado.isEmpty()) {
				dados.add(dado);
				linha++;
			} else {
				flag = true;
			}
		} while (flag == false);
		return dados;
	}


	/**
	 * Retorna uma string recebida por parametro, com a primeira
	 * letra em maiusculo
	 *
	 * @param atributo
	 * @return String
	 */
	protected String passarPrimeiroCaracterParaMaiusculo(String atributo) {
		String primeiroChar = atributo.substring(0, 1);
		primeiroChar = primeiroChar.toUpperCase();
		String atrNovo = atributo.replaceFirst(atributo.substring(0, 1), primeiroChar);
		return atrNovo;
	}


	/**
	 * Método responsável por carregar um arquivo do
	 * projeto para a memória
	 *
	 * @param nomeArquivo
	 * @param diretorio
	 * @return
	 */
	protected String carregarArquivo(String nomeArquivo, String diretorio) {
		String arq = IOArquivos.lerArquivo(nomeArquivo, diretorio);
		if (!arq.isEmpty()) {
			return arq;
		} else {
			System.out.println("ERRO AO RECUPERAR ARQUIVO...");
			return null;
		}
	}

	/**
	 * Retorna uma string com o tipo de dado correspondente
	 * de um BD em Java
	 * @param tipo
	 * @return String
	 */
	protected String parseTipo(String tipo) {

		/**COLOCAR OUTROS TIPOS DE DADOS ACEITOS...*/
		switch (tipo) {
		case "VARCHAR":
			return "String";

		case "INT":
			return "int";

		case "DECIMAL":
			return "double";
		}
		return null;
	}
}
