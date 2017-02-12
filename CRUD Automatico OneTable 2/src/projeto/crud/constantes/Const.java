package projeto.crud.constantes;

import java.io.File;

import projeto.crud.utils.DiretorioUtils;

public class Const {



	//***********	CONSTANTES RELATIVAS AO ARQUIVO XLS	***************

	//POSIÇÃO DOS CAMPOS DA TABELA DENTRO DO ARQUIVO EXCEL
	public static final int TABELA  		= 0;
	public static final int CAMPOS  		= 4;
	public static final int TIPO  			= 6;
	public static final int SIZE  			= 7;
	public static final int NULL    		= 8;
	public static final int PK  			= 9;

	//POSIÇÃO DA LINHA ONDE OS DADOS COMEÇAM A SER GRAVADOS
	public static final int INICIO_LINHA	= 1;

	//NOME DO ARQUIVO XLS
	public static final String ARQ_XLS 		= "banco.xls";
	public static final String FIM_TABELA   = "FIM_TAB";

	//IDENTIFICADORES TXT DOS CAMPOS
	public static final String _TABELA  	= "TABELA";
	public static final String _CAMPOS  	= "CAMPOS";
	public static final String _SIZE  	    = "SIZE";
	public static final String _NULL  	    = "NULL";
	public static final String _TYPE  	    = "TYPE";
	public static final String _PRIMARY  	= "PRIMARY";




	//***********	CONSTANTES RELATIVAS AOS BANCOS	***************

	//SELECT DA TELA DE LOGIN DO BANCO
	public static final String _ORACLE  	= "Oracle";
	public static final String _MYSQL  	    = "Mysql";
	public static final String _SQLSERVER  	= "Sql Server";
	public static final String _HSQLDB  	= "HSQLDB";


	//MENSAGENS DE ERRO DOS MÉTODOS DA CLASSE METADATA
	public static final String ERRO_EM  	= "ERRO EM: ";
	public static final String NA_TABELA  	= " NA TABELA: ";


	//SUB PATHS DOS ARQUIVOS E PASTAS
	private static final String PACOTE_PROJETO_ROOT_1 		   = "gerador";
	private static final String PACOTE_PROJETO_ROOT_2 		   = "automatico";
	private static final String PACOTE_PROJETO_ROOT_3 		   = "crud";
	private static final String PACOTE_PROJETO_ROOT_MODEL 	   = "model";
	private static final String PACOTE_PROJETO_ROOT_VIEW 	   = "view";
	private static final String PACOTE_PROJETO_ROOT_CONTROL    = "controller";
	private static final String PACOTE_PROJETO_ROOT_CONNECTION = "connection";


	public static final String PACOTE_CLASS = "bin";
	public static final String PACOTE_JAVA   = "src";

	/******** CAMINHOS DOS ARQUIVOS .JAVA **********/
	//caminho... pastadoprojeto\src\gerador\automatico\crud\model\ .java
	public static final String PACOTE_CAMINHO_JAVA_MODEL = PACOTE_JAVA + File.separatorChar +
													  PACOTE_PROJETO_ROOT_1 + File.separatorChar +
													  PACOTE_PROJETO_ROOT_2 + File.separatorChar +
													  PACOTE_PROJETO_ROOT_3 + File.separatorChar +
													  PACOTE_PROJETO_ROOT_MODEL + File.separatorChar ;

	//caminho... pastadoprojeto\src\gerador\automatico\crud\view\ .java
	public static final String PACOTE_CAMINHO_JAVA_VIEW  = PACOTE_JAVA + File.separatorChar +
			  										  PACOTE_PROJETO_ROOT_1 + File.separatorChar +
			  										  PACOTE_PROJETO_ROOT_2 + File.separatorChar +
			  										  PACOTE_PROJETO_ROOT_3 + File.separatorChar +
			  										  PACOTE_PROJETO_ROOT_VIEW + File.separatorChar ;

	//caminho... pastadoprojeto\src\gerador\automatico\crud\controller .java
	public static final String PACOTE_CAMINHO_JAVA_CONTROLLER  = PACOTE_JAVA + File.separatorChar +
			  									      		PACOTE_PROJETO_ROOT_1 + File.separatorChar +
			  									      		PACOTE_PROJETO_ROOT_2 + File.separatorChar +
			  									      		PACOTE_PROJETO_ROOT_3 + File.separatorChar +
			  									      		PACOTE_PROJETO_ROOT_CONTROL + File.separatorChar ;

	//caminho... pastadoprojeto\src\gerador\automatico\crud\connection .java
    public static final String PACOTE_CAMINHO_JAVA_CONNECTION  = PACOTE_JAVA + File.separatorChar +
				  									      	PACOTE_PROJETO_ROOT_1 + File.separatorChar +
				  									      	PACOTE_PROJETO_ROOT_2 + File.separatorChar +
				  									      	PACOTE_PROJETO_ROOT_3 + File.separatorChar +
				  									      	PACOTE_PROJETO_ROOT_CONNECTION + File.separatorChar ;


    /******** CAMINHOS DOS ARQUIVOS .JAVA **********/
    //caminho... pastadoprojeto\src\gerador\automatico\crud\model\ .java
  	public static final String PACOTE_CAMINHO_CLASS_MODEL = PACOTE_CLASS + File.separatorChar +
  													  PACOTE_PROJETO_ROOT_1 + File.separatorChar +
  													  PACOTE_PROJETO_ROOT_2 + File.separatorChar +
  													  PACOTE_PROJETO_ROOT_3 + File.separatorChar +
  													  PACOTE_PROJETO_ROOT_MODEL + File.separatorChar ;

  	//caminho... pastadoprojeto\src\gerador\automatico\crud\view\ .java
  	public static final String PACOTE_CAMINHO_CLASS_VIEW  = PACOTE_CLASS + File.separatorChar +
  			  										  PACOTE_PROJETO_ROOT_1 + File.separatorChar +
  			  										  PACOTE_PROJETO_ROOT_2 + File.separatorChar +
  			  										  PACOTE_PROJETO_ROOT_3 + File.separatorChar +
  			  										  PACOTE_PROJETO_ROOT_VIEW + File.separatorChar ;

  	//caminho... pastadoprojeto\src\gerador\automatico\crud\controller .java
  	public static final String PACOTE_CAMINHO_CLASS_CONTROLLER  = PACOTE_CLASS + File.separatorChar +
  			  									      		PACOTE_PROJETO_ROOT_1 + File.separatorChar +
  			  									      		PACOTE_PROJETO_ROOT_2 + File.separatorChar +
  			  									      		PACOTE_PROJETO_ROOT_3 + File.separatorChar +
  			  									      		PACOTE_PROJETO_ROOT_CONTROL + File.separatorChar ;

  	//caminho... pastadoprojeto\src\gerador\automatico\crud\connection .java
    public static final String PACOTE_CAMINHO_CLASS_CONNECTION  = PACOTE_CLASS + File.separatorChar +
  				  									      	PACOTE_PROJETO_ROOT_1 + File.separatorChar +
  				  									      	PACOTE_PROJETO_ROOT_2 + File.separatorChar +
  				  									      	PACOTE_PROJETO_ROOT_3 + File.separatorChar +
  				  									      	PACOTE_PROJETO_ROOT_CONNECTION + File.separatorChar ;


    public static final String PATH_PROJETO = DiretorioUtils.getRootDirectory() +
											  File.separatorChar;







    //********  CONSTANTES RELATIVAS AS PASTAS E ARQUIVOS DE PADR�OES  **************


	//PASTAS ROOT DOS PADR�OES
	private static final String PASTA_PADROES = "padroes";
	//*******************************************************************************


	//******** ARQUIVOS RELACIONADOS AOS BEANS (MODEL)
	public static final String ARQUIVO_BEAN_JPA    = "padrao_bean_jpa.txt";
	public static final String ARQUIVO_BEAN_PADRAO = "padrao_bean.txt";


	//DIRETORIOS RELACIONADOS BEAN (MODEL)
	private static final String PASTA_PADRAO_BEAN = "padrao bean";
	public static final String DIR_PADRAO_BEAN = DiretorioUtils.getRootDirectory() +
												 File.separatorChar + PASTA_PADROES +
												 File.separatorChar + PASTA_PADRAO_BEAN +
												 File.separatorChar;

	//******* ARQUIVOS RELACIONADOS CONNECTION
	public static final String ARQUIVO_CONN_JPA    = "padrao_conn_factory_jpa.txt";
	public static final String ARQUIVO_CONN_HSQLDB = "padrao_conn_jdbc_hsqldb.txt";
	public static final String ARQUIVO_CONN_ORACLE = "padrao_conn_jdbc_oracle.txt";
	public static final String ARQUIVO_CONN_MYSQL  = "padrao_conn_jdbc_mysql.txt";


	//DIRETORIOS RELACIONADOS AOS CONNECTIONS
	private static final String PASTA_PADRAO_CONEXAO = "padrao conexao";
	public static final String DIR_PADRAO_CONEXAO = DiretorioUtils.getRootDirectory() +
													 File.separatorChar + PASTA_PADROES +
													 File.separatorChar + PASTA_PADRAO_CONEXAO +
													 File.separatorChar;






	//******* ARQUIVOS RELACIONADOS DAOS
	public static final String ARQUIVO_DAO_JPA     = "padrao_dao_jpa.txt";
	public static final String ARQUIVO_DAO_MYSQL   = "padrao_dao_jdbc_mysql.txt";

	//DIRETORIOS RELACIONADOS AOS DAOS
	private static final String PASTA_PADRAO_DAO = "padrao dao";
	public static final String DIR_PADRAO_DAO   = DiretorioUtils.getRootDirectory() +
													 File.separatorChar + PASTA_PADROES +
													 File.separatorChar + PASTA_PADRAO_DAO +
													 File.separatorChar;




	//******* ARQUIVOS RELACIONADOS INTERFACES DAO
	public static final String ARQUIVO_DAO_INTERFACE     = "padrao_dao_interface.txt";


	//DIRETORIOS RELACIONADOS AOS INTERFACES DAO
	private static final String PASTA_PADRAO_INTERFACE = "padrao interface";
	public static final String DIR_PADRAO_INTERFACE   = DiretorioUtils.getRootDirectory() +
													     File.separatorChar + PASTA_PADROES +
													     File.separatorChar + PASTA_PADRAO_INTERFACE +
													     File.separatorChar;


	//******** ARQUIVOS RELACIONADOS AOS VIEWS
	public static final String ARQUIVO_VIEW_CONSOLE    = "padrao_view_console.txt";

	//DIRETORIOS RELACIONADOS AOS INTERFACES DAO
	private static final String PASTA_PADRAO_VIEW = "padrao view";
	public static final String DIR_PADRAO_VIEW    = DiretorioUtils.getRootDirectory() +
														     File.separatorChar + PASTA_PADROES +
														     File.separatorChar + PASTA_PADRAO_VIEW +
														     File.separatorChar;


	//**********CONSTANTES DE BUSCA DOS ARQUVOS TXT**************//
	public static final String SUBSTITUIR_ARQ_PARAMETRO = "#PARAMETRO";
	public static final String SUBSTITUIR_ARQ_GETTERS   = "#GETTERS";
	public static final String SUBSTITUIR_ARQ_SETTERS   = "#SETTERS";
	public static final String SUBSTITUIR_ARQ_CLASS     = "#CLASS";

	//************CONSTANTES GETTERS E SETTERS**************//


	//**********CONSTANTES DOS ARQUIVOS BEANS**************//
	public static final String SUBSTITUIR_ARQ_BEAN_ATRIBUTOS = "#ATRIBUTOS";
	public static final String SUBSTITUIR_ARQ_BEAN_JPA_ID    = "#ID";
	public static final String SUBSTITUIR_ARQ_BEAN_CABECALHO = "#CABECALHO_BEAN";
	public static final String SUBSTITUIR_PACOTE_BEAN        = "#PACOTE_BEAN";
	//gerador\automatico\crud\bean
	public static final String SUBSTITUTO_PACOTE_BEAN        = "gerador.automatico.crud.model";




	//**********CONSTANTES DOS ARQUIVOS DE CONEXÃO**************//
	public static final String SUBSTITUIR_ARQ_CONN_LOCALHOST   = "#LOCALHOST";
	public static final String SUBSTITUIR_ARQ_CONN_PORTA       = "#PORTA";
	public static final String SUBSTITUIR_ARQ_CONN_BANCO       = "#BANCO";
	public static final String SUBSTITUIR_ARQ_CONN_USUARIO     = "#USUARIO";
	public static final String SUBSTITUIR_ARQ_CONN_SENHA       = "#SENHA";
	public static final String SUBSTITUIR_ARQ_CONN_CABECALHO   = "#CABECALHO_CONN";
	public static final String SUBSTITUIR_PACOTE_CONN          = "#PACOTE_CONN";
	//gerador\automatico\crud\connection
    public static final String SUBSTITUTO_PACOTE_CONN          = "gerador.automatico.crud.connection";


	//**********CONSTANTES DOS ARQUIVOS DA DAO**************//
    public static final String SUBSTITUIR_ARQ_DAO_CLASSDAO         = "#CLASS";
	public static final String SUBSTITUIR_ARQ_DAO_CLASSES_IMPORTS  = "#IMPORTS_CLASS";
    public static final String SUBSTITUIR_ARQ_DAO_CABECALHO        = "#CABECALHO_DAO";
	public static final String SUBSTITUIR_ARQ_DAO_TIPO_ID_FINDFORID= "#TIPO_ID_FINDFORID";
	public static final String SUBSTITUIR_ARQ_DAO_PS_SET_TIPO_BUSCA_POR_ID   = "#PS_SET_TIPO_BUSCA_POR_ID";
    public static final String SUBSTITUIR_PACOTE_DAO               = "#PACOTE_DAO";
    public static final String SUBSTITUIR_PACOTE_DAO_INTERFACE     = "#PACOTE_INTERFACE_DAO";
    public static final String SUBSTITUIR_PACOTE_CONNECTION_SINGLETON = "#PACOTE_CONNECTION_SINGLETON";


	//gerador\automatico\crud\bean\connection
    public static final String SUBSTITUTO_PACOTE_DAO      = "gerador.automatico.crud.dao";
    public static final String SUBSTITUTO_PACOTE_DAO_INTERFACE   = "gerador.automatico.crud.interface.DAOInterface";
    public static final String SUBSTITUTO_PACOTE_CONNECTION_SINGLETON  = "gerador.automatico.crud.connection.ConnectionSingleton";
    public static final String SUBSTITUTO_ARQ_DAO_CLASSES_IMPORTS      = "gerador.automatico.crud.model.*";




	//JDBC MYSQL
	public static final String INSERT_ADICIONAR_JDBC_MYSQL     		= "#INSERT_ADICIONAR_JDBC_MYSQL";
	public static final String PREPARED_STATEMENT_INSERT_PARAMETROS = "#PREPARED_STATEMENT_INSERT_PARAMETROS";

	public static final String SELECT_FINDFORID_JDBC_MYSQL     			   = "#SELECT_FINDFORID_JDBC_MYSQL";
	public static final String PREPARED_STATEMENT_FINDFORID_PARAMETROS     = "#PREPARED_STATEMENT_FINDFORID_PARAMETROS";

	public static final String SELECT_FINDFORSTRING_JDBC_MYSQL     		   = "#INSERT_ADICIONAR_JDBC_MYSQL";
	public static final String PREPARED_STATEMENT_FINDFORSTRING_PARAMETROS = "#PREPARED_STATEMENT_FINDFORSTRING_PARAMETROS";

	public static final String SELECT_LISTAR_JDBC_MYSQL     			   = "#SELECT_LISTAR_JDBC_MYSQL";
	public static final String PREPARED_STATEMENT_LIST_PARAMETROS     	   = "#PREPARED_STATEMENT_LIST_PARAMETROS";

	public static final String UPDATE_ATUALIZAR_JDBC_MYSQL     			   = "#UPDATE_ATUALIZAR_JDBC_MYSQL";
	public static final String PREPARED_STATEMENT_ATUALIZAR_PARAMETROS     = "#PREPARED_STATEMENT_ATUALIZAR_PARAMETROS";

	public static final String DELETE_EXCLUIR_JDBC_MYSQL     			   = "#DELETE_EXCLUIR_JDBC_MYSQL";
	public static final String PREPARED_STATEMENT_EXCLUIR_PARAMETROS       = "#PREPARED_STATEMENT_EXCLUIR_PARAMETROS";

	//**********CONSTANTES DOS ARQUIVOS DA VIEW CONSOLE**************//
	public static final String SUBSTITUIR_PACOTE_VIEW_CONSOLE       			 = "#PACOTE_VIEW_CONSOLE";
	public static final String SUBSTITUTO_PACOTE_VIEW_CONSOLE       			 = "gerador.automatico.crud.view";

	public static final String SUBSTITUIR_IMPORT_VIEW_CONSOLE_PACOTE_DAO         = "#IMPORT_PACOTE_DAO";
	public static final String SUBSTITUTO_IMPORT_VIEW_CONSOLE_PACOTE_DAO         = "gerador.automatico.crud.dao.*";

	public static final String SUBSTITUIR_IMPORT_VIEW_CONSOLE_PACOTE_BEAN        = "#IMPORT_PACOTE_BEAN";
	public static final String SUBSTITUTO_IMPORT_VIEW_CONSOLE_PACOTE_BEAN        = "gerador.automatico.crud.bean.*";

	public static final String SUBSTITUIR_ARQ_VIEW_CONSOLE_CLASS_DAO             = "#CLASSDAO";
	public static final String SUBSTITUIR_ARQ_VIEW_CONSOLE_RECEBE_DADOS_USUARIO  = "#RECEBE_DADOS_USUARIO";
	public static final String SUBSTITUIR_ARQ_VIEW_CONSOLE_CABECALHO             = "#CABECALHO_VIEW_CONSOLE";

	public static final String PATH_DIRETORIO      = System.getProperty("user.home") + "/Desktop";

}


