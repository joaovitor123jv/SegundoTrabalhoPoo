package trabalho;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class DocumentoSaida extends Documento
{
	Pessoa receptador;

	public Pessoa getReceptador()
	{
		return this.receptador;
	}

	public void setReceptador(Pessoa receptador)
	{
		this.receptador = receptador;
	}
//Set quantidade já existe em "Documento"
}
