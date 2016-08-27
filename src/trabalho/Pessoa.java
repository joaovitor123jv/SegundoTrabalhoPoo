package trabalho;
import java.io.IOException;


/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class Pessoa
{
	private int id;
	private String nome;

	public Pessoa()
	{
		id = 0;
		nome = "";
	}

	public Pessoa(int id, String nome)
	{
		this.id = id;
		this.nome = nome;
	}

	public int getId()
	{
		return this.id;
	}

	public String getNome()
	{
		return this.nome;
	}

	public void setId(int id)
	{
		this.id =id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getTipoPessoa(int linha)throws IOException
	{
		String tipoPessoa;
		Arquivo arquivo = new Arquivo("Pessoas.txt");
		tipoPessoa = arquivo.leLinha(linha);
		arquivo.fechar();
		return	tipoPessoa.substring(0, tipoPessoa.indexOf(":"));
	}

	public int getId(int linha)throws IOException
	{
		Arquivo arquivo = new Arquivo("Pessoas.txt");
		String leitura = arquivo.leLinha(linha);
		this.id = Integer.parseInt(leitura.substring(leitura.indexOf(("ID:"+4)), leitura.indexOf(",", leitura.indexOf("ID:"+4))));
		arquivo.fechar();
		return this.id;
	}

	public boolean salvar()throws IOException
	{
		Arquivo arquivo = new Arquivo("Pessoas.txt");
		arquivo.escreve(toString());
		System.out.println(toString());
		arquivo.fechar();
		return true;
	}

	@Override
	public String toString()
	{
		return "Pessoa:  Nome=\""+getNome()+"\"  id=\""+getId()+"\"";
	}
}
