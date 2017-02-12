package projeto.crud.gerador.model;

import java.util.ArrayList;
import java.util.List;

import projeto.crud.constantes.Const;
import projeto.crud.gerador.Gerador;
import projeto.crud.io.IOExcel;


/**
 * Classe que possui métodos importantes para os geradores de classes,
 * estes métodos são usados pelas classes concretas que geram as classses
 * bean, conexão, view, etc...
 * @author Rhuan
 *
 */
public abstract class GeradorBean extends Gerador{

	//tipos dos atributos
	protected List<String> tipo;

	//atributos da classe
	protected List<String> atributos;


	/**
	 * Método responsável por montar os setters da classe
	 * @return String
	 */
	protected void setSetters() {
		String set = "";
		String atributo;
		String type;
		for (int i = 0; i < atributos.size(); i++) {
			set += "\tpublic void ";
			type = parseTipo(tipo.get(i)) + " "; /* public void type */
			atributo = passarPrimeiroCaracterParaMaiusculo(
					atributos.get(i));/* public void type atributo */
			set += "set" + atributo + "(" + type + " " + atributo
					+ ")";/* public void type atributo set */
			set += "{\n" + "\t\tthis." + atributos.get(i);
			set += " = " + atributo + ";";
			set += "\n\t}";
			set += "\n";
		}
		trocaCampo(Const.SUBSTITUIR_ARQ_SETTERS, set);
	}



	/**
	 * Método responsável por montar os getters da classe
	 * @return String
	 */
	protected void setGetters() {
		String get = "";
		String atributo;
		for (int i = 0; i < atributos.size(); i++) {
			get += "\tpublic ";
			atributo = passarPrimeiroCaracterParaMaiusculo(atributos.get(i));
			get += parseTipo(tipo.get(i)) + " ";
			get += "get" + atributo;
			get += "{\n" + "\t\treturn " + atributos.get(i) + ";";
			get += "\n\t}";
			get += "\n";
		}
		trocaCampo(Const.SUBSTITUIR_ARQ_GETTERS, get);
	}



	/**
	 * Método responsável por montar os atributos de uma classe
	 * @return String
	 */
	protected void setAtributos() {
		String campo = "";
		for (int i = 0; i < atributos.size(); i++) {
			campo += "\tprivate ";
			campo += parseTipo(tipo.get(i)) + " ";
			campo += (atributos.get(i) + ";");
			campo += "\n";
		}
		trocaCampo(Const.SUBSTITUIR_ARQ_BEAN_ATRIBUTOS, campo);
	}



	/**
	 * Método responsável por carregar as linhas de uma
	 * coluna do arquivo xls
	 *
	 * @param coluna
	 * @return List<String>
	 */
	protected List<String> getColunaArquivoXLS(int coluna) {
		int linha = Const.INICIO_LINHA;
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







}
