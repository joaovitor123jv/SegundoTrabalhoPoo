package trabalho;

import java.io.IOException;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class PessoaFisica extends Pessoa
{
	private String CPF;
	public PessoaFisica(String CPF, int id, String nome)
	{
		super(id, nome);
		this.CPF = CPF;
	}

	public PessoaFisica()
	{
		super();
		CPF = "";
	}

	public String getCPF()
	{
		return this.CPF;
	}

	public void setCPF(String CPF)
	{
		this.CPF = CPF;
	}

	public boolean getDados(int onde)throws IOException
	{
		int inicio;
		int fim;
		int id;
		String linha;
		String resultado;

		Arquivo arquivo = new Arquivo("Pessoas.txt");

		linha = arquivo.leLinha(onde);


		inicio = linha.indexOf("Nome:") +6;
		fim = linha.indexOf(", ID:");
		resultado = linha.substring(inicio, fim);
		setNome(resultado);

		inicio = linha.indexOf("ID:", inicio) + 4;
		fim = linha.indexOf(", CPF:", fim);
		resultado = linha.substring(inicio, fim);
		id = Integer.parseInt(resultado);
		setId(id);
		

		inicio = linha.indexOf("CPF: ") + 5;
		resultado = linha.substring(inicio);
		this.CPF = resultado;

		arquivo.fechar();
		return true;
	}

	@Override
	public String toString()
	{
		return "Pessoa Física:  Nome: "+super.getNome()+", ID: "+super.getId()+", CPF: "+getCPF();
	}
}
