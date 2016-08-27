package trabalho;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class Arquivo 
{
	String endereco;
	PrintWriter saida;
	BufferedReader entrada;

	public Arquivo(String endereco)throws IOException
	{
		this.endereco = endereco;
		File arquivo = new File(endereco);

		if(!arquivo.exists())
			arquivo.createNewFile();

		this.entrada = new BufferedReader(new FileReader(endereco));
		this.saida = new PrintWriter(new BufferedWriter(new FileWriter(endereco, true)));
	}

	public String leLinha() throws IOException 
	{
		String linha = entrada.readLine();
		if(linha == null) return "";
		return linha;
	}
	
	public String leLinha(int numeroLinha)throws IOException
	{
		entrada.close();
		this.entrada = new BufferedReader(new FileReader(endereco));
		String linha = null;
		int i;
		for(i=0; i<numeroLinha; i++)
		{
			linha = entrada.readLine();
		}
		return linha;
	}

	public void escreve(String texto) throws IOException 
	{
		if(saida == null) 
			this.saida = new PrintWriter(new BufferedWriter(new FileWriter(endereco, true)));
		saida.print(texto+"\n");
		//saida.close();
	}

	public void salvar()throws IOException
	{
		saida.close();
		this.saida = new PrintWriter(new BufferedWriter(new FileWriter(endereco, true)));
	}
	public void fechar()throws IOException
	{
		saida.close();
		entrada.close();
	}
}
