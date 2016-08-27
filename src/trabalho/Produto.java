package trabalho;
import java.io.IOException;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class Produto
{
	private int id;
	private String descricao;
	private float estoque;
	private UnidadeMedida unidadeMedida;

	public Produto()
	{
		this.id = 0;
		this.descricao = "";
		this.estoque = 0;
		this.unidadeMedida = null;
	}

	public Produto(int id, String descricao, UnidadeMedida unidadeMedida, float estoque)
	{
		this.id = id;
		this.descricao = descricao;
		this.estoque = estoque;
		this.unidadeMedida = unidadeMedida;
	}


	//GETTERS
	public int getId() { return this.id; }
	public String getDescricao() { return this.descricao; }
	public UnidadeMedida getUnidadeMedida(){ return this.unidadeMedida;}
	public float getEstoque(){return this.estoque;}


	public String getDados(int onde)throws IOException
	{
		int inicio;
		int fim;
		int id;
		UnidadeMedida unidadeMedida;
		float estoque;
		String linha;
		String resultado;

		Arquivo arquivo = new Arquivo("Produtos.txt");

		linha = arquivo.leLinha(onde);
		inicio = linha.indexOf("ID:") + 4;
		fim = linha.indexOf("Estoque")-1;
		resultado = linha.substring(inicio, fim);
		id = Integer.parseInt(resultado);
		this.id = id;
		
		inicio = fim + 10;
		fim = linha.indexOf("Unidade", inicio)-1;
		resultado = linha.substring(inicio, fim);
		this.estoque = Float.parseFloat(resultado);

		inicio = linha.indexOf("Medida", inicio) +8;
		fim = linha.indexOf("Descrição", inicio) -1;
		resultado = linha.substring(inicio, fim);
		System.out.println("\""+resultado+"\"");
		if(resultado.equals("m"))
		{
			this.unidadeMedida = UnidadeMedida.m;
		}
		else if(resultado.equals("kg"))
			this.unidadeMedida = UnidadeMedida.kg;
		else if(resultado.equals("un"))
			this.unidadeMedida = UnidadeMedida.un;

		inicio = fim + 10;
		resultado = linha.substring(inicio);
		this.descricao = resultado;

		arquivo.fechar();
		return toString();

	}


	//SETTERS
	public void setEstoque(float estoque){this.estoque=estoque;}
	public void setUnidadeMedida(UnidadeMedida unidadeMedida){ this.unidadeMedida= unidadeMedida;}
	public void setId(int id) { this.id = id; }


	private boolean idUnico(Arquivo arquivo)throws IOException
	{
		int inicio;
		int fim;
		int id;
		int numeroLinha;
		String linha;
		String resultado;
		linha = arquivo.leLinha();
		while(linha != "")
		{
			inicio = linha.indexOf("ID:") + 4;
			fim = linha.indexOf("Estoque")-1;
			resultado = linha.substring(inicio, fim);
			id = Integer.parseInt(resultado);
			if(id == this.id)
			{
				return false;
			}
			linha = arquivo.leLinha();
		}
		return true;
	}

	public boolean salvar()throws IOException
	{
		Arquivo arquivo = new Arquivo("Produtos.txt");
		if(idUnico(arquivo))
		{
			arquivo.escreve(this.toString());
			arquivo.salvar();
			arquivo.fechar();
			return true;
		}
		else
		{
			arquivo.fechar();
			return false;
		}
	}


	@Override
		public int hashCode()
		{
			return this.getId();
		}

	@Override
		public boolean equals(Object obj)
		{
			if(!(obj instanceof Produto))
				return false;
			if(obj == this)
				return true;

			Produto produto = (Produto) obj;
			return ((produto.getId() == this.getId()) && (produto.getDescricao() == this.getDescricao() ));
		}

	@Override
		public String toString()
		{
			return "Produto: ID: "+getId()+" Estoque: "+getEstoque()+" Unidade de Medida: "+getUnidadeMedida()+" Descrição:"+getDescricao();
		}

		public static void main(String[] args)
		{
			Produto produto = new Produto(18281, "teste", UnidadeMedida.m, 400);
			System.out.println(produto);
		}
}
