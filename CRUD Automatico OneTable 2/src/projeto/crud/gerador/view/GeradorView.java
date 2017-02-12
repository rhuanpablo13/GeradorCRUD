package projeto.crud.gerador.view;

import java.util.List;

import projeto.crud.constantes.Const;
import projeto.crud.gerador.Gerador;

public abstract class GeradorView extends Gerador{

	public GeradorView() {
		// TODO Auto-generated constructor stub
		classeArquivo = carregarArquivo(Const.ARQUIVO_VIEW_CONSOLE, Const.DIR_PADRAO_VIEW);
		buildClass();
	}



	protected void substituirRecebeDadosUsuario(){
		List<String> campos = getColuna(Const.CAMPOS);
		List<String> tipos  = getColuna(Const.TIPO);
		String system = "";
		String scanner = "";
		String juntos = "";
		for (int i = 0; i < campos.size(); i++) {
			system = "System.out.println(\"" + passarPrimeiroCaracterParaMaiusculo(campos.get(i)) + ":\" )";
			scanner = getNomeClasse() + "." + getSettersAtributos(campos.get(i)) + "(new Scanner(System.in)." +
			           parseTipo(tipos.get(i)) + ");";
			juntos += system + "\n\t\t" +
			          scanner + "\n\t\t";
		}
		trocaCampo(Const.SUBSTITUIR_ARQ_VIEW_CONSOLE_RECEBE_DADOS_USUARIO, juntos);
	}

	protected void setParametroMetodos(String parametrosMarcacao, String parametrosubstituto){
		trocaCampo(parametrosMarcacao, parametrosubstituto);
		trocaCampo(Const.SUBSTITUIR_ARQ_PARAMETRO, getNomeClasse());
	}

	protected void setClassDAO(String daoMarcacao, String daoSubstituto){
		passarPrimeiroCaracterParaMaiusculo(daoSubstituto);
		trocaCampo(daoMarcacao, daoSubstituto);
	}

	protected void setImportPacoteBean(String caminhoPacoteMarcacao, String caminhoPacoteSubstituto){
		trocaCampo(caminhoPacoteMarcacao, caminhoPacoteSubstituto);
	}

	protected void setImportPacoteDAO(String importPacoteDAOMarcacao, String importPacoteDAOSubstituto){
		trocaCampo(importPacoteDAOMarcacao, importPacoteDAOSubstituto);
	}




	@Override
	protected String parseTipo(String tipo) {
		// TODO Auto-generated method stub

		switch (tipo) {
		case "VARCHAR":
			return "nextLine()";

		case "INT":
			return "nextInt()";

		case "DECIMAL":
			return "nextDouble()";
		}
		return null;
	}

}
