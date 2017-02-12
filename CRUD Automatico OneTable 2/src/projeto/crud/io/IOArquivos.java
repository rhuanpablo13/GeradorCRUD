package projeto.crud.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IOArquivos {

	/**
	 * Cria um arquivo em grava em um diretório
	 * @param texto
	 * @param nomeArquivo
	 * @param caminho onde vai gravar o arquivo
	 */
	public static void gravarArquivo(String texto, String nomeArquivo, String caminho){
		try {

			File file = new File(caminho +File.separatorChar+ nomeArquivo);
			PrintWriter pw = new PrintWriter(file);
			pw.println(texto);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERRO AO GRAVAR ARQUIVO: " + nomeArquivo);
		}
	}


	/**
	 *
	 * @param nomeArquivo
	 * @param caminho
	 * @return String
	 * @throws IOException
	 */
	public static String lerArquivo(String nomeArquivo, String caminho){

		String texto = "";
		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(caminho + nomeArquivo));
			while(br.ready()){
				   texto += br.readLine() + "\n";
			}
			br.close();
		} catch (IOException e) {
				e.printStackTrace();
				System.out.println("ERRO AO LER ARQUIVO: " + nomeArquivo);
		}
		return texto;
	}

}
