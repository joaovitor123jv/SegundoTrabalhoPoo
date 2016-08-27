package trabalho;

import java.util.Date;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class Documento
{
	private Produto produto;
	private float quantidade;
	private Date dataTransacao;

	public Date getDataTransacao()
	{
		return this.dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao){ this.dataTransacao = dataTransacao;}
	public float getQuantidade()
	{
		return this.quantidade;
	}

	public void setQuantidade(float quantidade)
	{
		this.quantidade = quantidade;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Documento)) return false;
		if(obj == this) return true;
		Documento doc;
		doc = (Documento) obj;
		if(doc.produto.equals(this.produto)) return true;
		return false;
	}
}
