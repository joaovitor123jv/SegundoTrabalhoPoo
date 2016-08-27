package trabalho;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class DocumentoEntrada extends Documento
{
	Pessoa fornecedor;
	public DocumentoEntrada(Pessoa fornecedor)
	{
		this.fornecedor=fornecedor;
	}
	public DocumentoEntrada()
	{
		fornecedor = new Pessoa();
	}

	public Pessoa getFornecedor()
	{
		return this.fornecedor;
	}

	public void setFornecedor(Pessoa fornecedor)
	{
		this.fornecedor = fornecedor;
	}
//Set quantidade já existe em "Documento"
}
