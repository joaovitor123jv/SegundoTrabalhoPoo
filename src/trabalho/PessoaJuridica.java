package trabalho;
import java.io.IOException;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class PessoaJuridica extends Pessoa
{
	private String CNPJ;
	public PessoaJuridica(String CNPJ, int id, String nome)
	{
		super(id, nome);
		this.CNPJ = CNPJ;
	}

	public PessoaJuridica()
	{
		super();
		CNPJ = "";
	}

	public String getCNPJ()
	{
		return this.CNPJ;
	}

	public void setCNPJ(String CNPJ)
	{
		this.CNPJ = CNPJ;
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
		fim = linha.indexOf(", CNPJ:", fim);
		resultado = linha.substring(inicio, fim);
		id = Integer.parseInt(resultado);
		setId(id);
		

		inicio = linha.indexOf("CNPJ: ") + 5;
		resultado = linha.substring(inicio);
		this.CNPJ = resultado;

		arquivo.fechar();
		return true;
	}

	@Override
	public String toString()
	{
		return "Pessoa Jurídica:  Nome: "+super.getNome()+", ID: "+super.getId()+",   CNPJ: "+getCNPJ();
	}
}
