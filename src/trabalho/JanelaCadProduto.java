package trabalho;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JComboBox;


import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.IOException;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class JanelaCadProduto extends JFrame implements ActionListener
{
	private JButton btAnterior, btNovo, btCancelar, btSalvar, btProximo;
	private JLabel lbDescricao, lbUnidadeMedida, lbEstoqueInicial, lbId;
	private JTextField tfDescricao, tfEstoqueInicial, tfId;
	private JComboBox cbUnidadeMedida;
	private JPanel pnBotoes, pnDados;
	private int numeroLinha;

	public JanelaCadProduto()
	{
		numeroLinha = 1;
		this.setLayout(new BorderLayout());

		pnBotoes = new JPanel();
		pnDados = new JPanel();

		this.add(pnDados, BorderLayout.CENTER);
		this.add(pnBotoes, BorderLayout.SOUTH);
		
		pnDados.setLayout(new GridLayout(4, 2));
		pnBotoes.setLayout(new GridLayout(1, 5));

		lbId = new JLabel("ID");
		lbDescricao = new JLabel("Descricao"); lbUnidadeMedida = new JLabel("Unidade de Medida");
		lbEstoqueInicial = new JLabel("Estoque Inicial");

		tfId = new JTextField(50);
		tfDescricao = new JTextField(50);
		tfEstoqueInicial = new JTextField(50);

		String[] strUnidadeMedida = {"m", "Kg", "un"};
		cbUnidadeMedida = new JComboBox(strUnidadeMedida);
		cbUnidadeMedida.setSelectedIndex(0);

		btAnterior = new JButton("Anterior");
		btProximo = new JButton("Proximo");
		btSalvar = new JButton("Salvar");
		btCancelar = new JButton("Cancelar");
		btNovo = new JButton("Novo");

		pnDados.add(lbId); pnDados.add(tfId);
		pnDados.add(lbDescricao); pnDados.add(tfDescricao);
		pnDados.add(lbUnidadeMedida); pnDados.add(cbUnidadeMedida);
		pnDados.add(lbEstoqueInicial); pnDados.add(tfEstoqueInicial);

		pnBotoes.add(btAnterior);
		pnBotoes.add(btNovo);
		pnBotoes.add(btCancelar);
		pnBotoes.add(btSalvar);
		pnBotoes.add(btProximo);

		btAnterior.addActionListener(this);
		btNovo.addActionListener(this);
		btCancelar.addActionListener(this);
		btSalvar.addActionListener(this);
		btProximo.addActionListener(this);

		btSalvar.setEnabled(false);
		btCancelar.setEnabled(false);

		this.setSize(500,200);
		this.setTitle("Cadastro Produto");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btAnterior)
		{
			btSalvar.setEnabled(false);
			btCancelar.setEnabled(false);
			try
			{
				Arquivo arquivo = new Arquivo("Produtos.txt");
				if(this.numeroLinha == 1)
				{
					while(arquivo.leLinha() !="")
					{
						numeroLinha++;
					}
				}
				else
				{
					numeroLinha--;
				}
				Produto produto = new Produto();
				produto.getDados(numeroLinha);
				tfId.setText(Integer.toString(produto.getId()));
				tfDescricao.setText(produto.getDescricao());
				if(produto.getUnidadeMedida() == UnidadeMedida.m)
					cbUnidadeMedida.setSelectedIndex(0);
				else if(produto.getUnidadeMedida() == UnidadeMedida.kg)
					cbUnidadeMedida.setSelectedIndex(1);
				else if(produto.getUnidadeMedida() == UnidadeMedida.un)
					cbUnidadeMedida.setSelectedIndex(2);
				tfEstoqueInicial.setText(Float.toString(produto.getEstoque()));
				
			}
			catch(IOException j)
			{
				System.out.println(j.getStackTrace());
			}
		}
		else if(e.getSource() == btProximo)
		{
			btSalvar.setEnabled(false);
			btCancelar.setEnabled(false);
			try
			{
				Arquivo arquivo = new Arquivo("Produtos.txt");
				int numeroLinha = 1;
				while(arquivo.leLinha() !="")
				{
					numeroLinha++;
				}
				if(this.numeroLinha == numeroLinha)
				{
					this.numeroLinha = 0;
				}
				else
				{
					this.numeroLinha++;
				}
				Produto produto = new Produto();
				produto.getDados(this.numeroLinha);
				tfId.setText(Integer.toString(produto.getId()));
				tfDescricao.setText(produto.getDescricao());
				if(produto.getUnidadeMedida() == UnidadeMedida.m)
					cbUnidadeMedida.setSelectedItem("m");
				else if(produto.getUnidadeMedida() == UnidadeMedida.kg)
					cbUnidadeMedida.setSelectedItem("Kg");
				else if(produto.getUnidadeMedida()== UnidadeMedida.un)
				{
					cbUnidadeMedida.setSelectedItem("un");
				}
				tfEstoqueInicial.setText(Float.toString(produto.getEstoque()));
				
			}
			catch(IOException j)
			{
				System.out.println(j.getStackTrace());
			}
		}
		else if(e.getSource() == btNovo)
		{
			this.btSalvar.setEnabled(true);
			this.btCancelar.setEnabled(true);
			tfId.setText("");
			tfDescricao.setText("");
			cbUnidadeMedida.setSelectedIndex(0);
			tfEstoqueInicial.setText("");
		}
		else if(e.getSource() == btSalvar)
		{
			int id = Integer.parseInt(tfId.getText());
			String descricao = tfDescricao.getText();
			UnidadeMedida unidadeMedida;
			String aux = (String) cbUnidadeMedida.getSelectedItem();//Converte pra String o resultado do ComboBox
			if(aux == "m")
				unidadeMedida = UnidadeMedida.m;
			else if(aux == "kg")
				unidadeMedida = UnidadeMedida.kg;
			else unidadeMedida = UnidadeMedida.un;
			float estoqueInicial = Float.parseFloat(tfEstoqueInicial.getText());

			Produto produto = new Produto(id, descricao, unidadeMedida, estoqueInicial);
			try
			{
				if(produto.salvar())
					JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso");
				else
					JOptionPane.showMessageDialog(null, "Produto não pode ser cadastrado, conflito de ID");
			}
			catch(IOException j)
			{
				System.out.println(j.getStackTrace());
			}
			btSalvar.setEnabled(false);
			btCancelar.setEnabled(false);
		}
	}
}
