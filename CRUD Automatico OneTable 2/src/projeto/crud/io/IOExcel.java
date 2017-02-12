package projeto.crud.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import projeto.crud.constantes.Const;


/**
 * Classe responsável por gravar dados em um arquivo xls
 * @author RHUAN
 *
 */
public class IOExcel{


	/**
	 * Método para ler uma célula do excel
	 * @param linha
	 * @param coluna
	 * @return uma celula lida, se não retorna null
	 */
	public static String lerCelula(int coluna, int linha) {

		String sCell = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(Const.ARQ_XLS));
			Sheet sheet = workbook.getSheet(0);
			Cell cell = sheet.getCell(coluna, linha);
   	        sCell = cell.getContents();
			workbook.close();
			return sCell;
		} catch (BiffException | IOException e) {
			e.printStackTrace();
			System.out.println("ERRO AO LER ARQUIVO!");
		}
		return null;
	}


	/**
	 * Método para ler uma coluna do excel
	 * @param linha
	 * @param coluna
	 * @return uma coluna lida, se não retorna null
	 */
	public static List<String> lerColuna(int coluna, int linha) {

		List<String> Listacoluna = new ArrayList<>();
		try {
			Workbook workbook = Workbook.getWorkbook(new File(Const.ARQ_XLS));
			Sheet sheet = workbook.getSheet(0);
			Cell cell;
			boolean flag = false;
			do{
				cell = sheet.getCell(coluna, linha);
				if(!cell.getContents().isEmpty()){
				   Listacoluna.add(cell.getContents());
				}else{ flag = true;}
				linha++;
			}while(flag == false);
			workbook.close();
			return Listacoluna;
		} catch (BiffException | IOException e) {
			e.printStackTrace();
			System.out.println("ERRO AO LER ARQUIVO!");
		}
		return null;
	}


    /**
     * Método para gravar um dado em uma célula excel
     * @param dados
     * @param linha
     * @param coluna
     */
	public static void gravarCelula(String dados, int linha, int coluna){

			try {
			    Label label;
			    WritableWorkbook work = getCreatedWritableWorbook();
			    if(work != null){
			       WritableSheet sheet = work.getSheet(0);
			       label = new Label(coluna, linha, dados);
			       sheet.addCell(label);
				   work.write();
				   work.close();
			    }else{ System.out.println("Erro! WritableWorkbook não criada!");  }
			}
			catch (IOException e) {e.printStackTrace();}
			catch (WriteException e2) {e2.printStackTrace();}
	}


	/**
	 * @return Retorna um Writable já criado, se não retorna null
	  */
	private static WritableWorkbook getCreatedWritableWorbook(){
		try {
			Workbook workbook = Workbook.getWorkbook(new File(Const.ARQ_XLS));
			WritableWorkbook copy = Workbook.createWorkbook(new File(Const.ARQ_XLS), workbook);
			return copy;
		} catch (BiffException | IOException e) {e.printStackTrace();}
		return null;
	}


	/**
	 * Método para criar um arquivo excel
	 */
	public static void criarArquivo(){
		try {
			WritableWorkbook write = Workbook.createWorkbook(new File(Const.ARQ_XLS));
			@SuppressWarnings("unused")
			Sheet sheet = write.createSheet("Folha1", 0);
			write.write();
			write.close();
	    } catch (IOException | WriteException e) {e.printStackTrace();}
	}


    /**
     * Método para recuperar a quantidade de linhas gravadas no arquivo
     * @return Quantidade de linhas de um arquivo Excel
    */
	public static int getRows(){
		int linhas = 0;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(Const.ARQ_XLS));
			Sheet sheet = workbook.getSheet(0);
			linhas = sheet.getRows();
		} catch (BiffException | IOException e) {e.printStackTrace();}
		return linhas;
	}
}









