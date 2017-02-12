package projeto.crud.gerador.view;

import projeto.crud.constantes.Const;

public class ViewConsole extends GeradorView{


	@Override
	protected void buildClass() {
		// TODO Auto-generated method stub
		setClasse(Const.SUBSTITUIR_ARQ_CLASS, passarPrimeiroCaracterParaMaiusculo(getNomeClasse()));
		setCabecalho(Const.SUBSTITUIR_ARQ_VIEW_CONSOLE_CABECALHO, getCabecalho());
		setPacote(Const.SUBSTITUIR_PACOTE_VIEW_CONSOLE, Const.SUBSTITUTO_PACOTE_VIEW_CONSOLE);
		setImportPacoteBean(Const.SUBSTITUIR_IMPORT_VIEW_CONSOLE_PACOTE_BEAN, Const.SUBSTITUTO_IMPORT_VIEW_CONSOLE_PACOTE_BEAN);
		setImportPacoteDAO(Const.SUBSTITUIR_IMPORT_VIEW_CONSOLE_PACOTE_DAO, Const.SUBSTITUTO_IMPORT_VIEW_CONSOLE_PACOTE_DAO);
		setParametroMetodos(Const.SUBSTITUIR_ARQ_PARAMETRO, getNomeClasse());
		setClassDAO(Const.SUBSTITUIR_ARQ_DAO_CLASSDAO, getNomeClasse());
		substituirRecebeDadosUsuario();
	}

	@Override
	public String getClasseBuilded() {
		// TODO Auto-generated method stub
		return classeArquivo;
	}

	private String getCabecalho(){
		return "/** Classe view gerada por Gerador Automático 1.0 */";
	}

}
