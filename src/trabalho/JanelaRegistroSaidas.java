package trabalho;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

import java.io.IOException; 

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class JanelaRegistroSaidas extends JFrame// implements ActionListener
{
	private JLabel lbFornecidoPor, lbProduto, lbQuantidade;
	private JComboBox cbFornecidoPor, cbProduto;
	private JTextField tfQuantidade;
	private JButton btSalvar, btCancelar;
	private JTable tbProdutos;
	private JPanel pnDados, pnItens;

	public JanelaRegistroSaidas()
	{
		super("Registro de Saídas");
		this.setSize(800,600);


		pnDados = new JPanel();
		pnItens = new JPanel();

		this.add(pnDados, BorderLayout.NORTH);
		this.add(pnItens, BorderLayout.CENTER);

		pnDados.setLayout(new GridLayout(4, 2));
		pnItens.setLayout(new BorderLayout());

		lbFornecidoPor = new JLabel("Fornecido por");
		lbQuantidade = new JLabel("Quantidade");
		lbProduto = new JLabel("Produto");
		tfQuantidade = new JTextField("Quantidade do que?");

		btSalvar = new JButton("Salvar");
		btCancelar = new JButton("Cancelar");

		cbProduto = new JComboBox();
		cbProduto.addItem("Teste 1");
		cbProduto.addItem("Teste 4");
		cbProduto.addItem("Teste 5");

		cbFornecidoPor = new JComboBox();
		cbFornecidoPor.addItem("Teste 2");
		cbFornecidoPor.addItem("Teste 5");

		pnDados.add(lbFornecidoPor); pnDados.add(cbFornecidoPor);
		pnDados.add(lbProduto); pnDados.add(cbProduto);
		pnDados.add(lbQuantidade); pnDados.add(tfQuantidade);
		pnDados.add(btCancelar); pnDados.add(btSalvar);

		String[] tipoDeDados = {"Data", "Produto", "Fornecedor", "Quantidade"};

		Object[][] dados=
		{
			{
				"20/6/2016", "Carrinho de mão", "Zé da esquina", "42"
			},
			{
				"30/1/2011", "Torneira de Camiseta", "Doido do shopping", "99"
			},
			{
				"2/08/2016", "Caldeirão Furado", "Harry Potter", "1"
			}
		};

		tbProdutos = new JTable(dados, tipoDeDados);
		pnItens.add(tbProdutos.getTableHeader(), BorderLayout.NORTH);
		pnItens.add(tbProdutos, BorderLayout.CENTER);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
