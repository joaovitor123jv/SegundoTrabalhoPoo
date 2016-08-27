package trabalho;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
	*
	*@author JoãoVitorAntoniassiSegantin
	*
*/
public class Janela extends JFrame implements ActionListener
{
	private JMenuItem cadastroProduto, cadastroPessoa, movimentoEntrada, movimentoSaida, sair;
	private JDesktopPane areaDeTrabalho;

	Janela()
	{
		super("Almoxarifado");

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);


		Container barraMenus = new Container();
		barraMenus.setLayout(null);

		JMenu menuCadastros = new JMenu("Cadastros");
		menuCadastros.setMnemonic('C');

		cadastroProduto = new JMenuItem("Produto  CTRL+R");
		cadastroProduto.setMnemonic('R');
		cadastroPessoa = new JMenuItem("Pessoa   CTRL+P");
		cadastroPessoa.setMnemonic('P');

		menuCadastros.add(cadastroProduto);
		menuCadastros.add(cadastroPessoa);

		JMenu menuMovimento = new JMenu("Movimento");
		menuMovimento.setMnemonic('M');

		movimentoEntrada = new JMenuItem("Entrada   CTRL+E");
		movimentoEntrada.setMnemonic('E');
		movimentoSaida = new JMenuItem("Saida   CTRL+S");
		movimentoSaida.setMnemonic('S');

		menuMovimento.add(movimentoEntrada);
		menuMovimento.add(movimentoSaida);

		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');

		sair = new JMenuItem("Sair");
		
		menuArquivo.add(sair);

		
		JMenuBar barra= new JMenuBar();
		this.setJMenuBar(barra);
		barra.add(menuArquivo);
		barra.add(menuCadastros);
		barra.add(menuMovimento);
		barra.add(barraMenus);

//COLOCAR OUVINTE PROS OUTROS NEGOCIOS
		sair.addActionListener(this);
		cadastroPessoa.addActionListener(this);
		cadastroProduto.addActionListener(this);
		movimentoSaida.addActionListener(this);
		movimentoEntrada.addActionListener(this);


		this.setDefaultCloseOperation(3);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		areaDeTrabalho = new JDesktopPane();
		areaDeTrabalho.setBackground(new Color(192,204,224));

		Container total = new Container();
		total = getContentPane();
		total.setLayout(new BorderLayout());

		total.add("Center", areaDeTrabalho);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == sair)
		{
			System.exit(0);
		}
		else if(e.getSource() == cadastroPessoa)
		{
			new JanelaCadPessoa();
		}
		else if(e.getSource() == cadastroProduto)
		{
			new JanelaCadProduto();
		}
		else if(e.getSource() == movimentoEntrada)
		{
			new JanelaRegistroEntradas();
		}
		else if(e.getSource() == movimentoSaida)
		{
			new JanelaRegistroSaidas();
		}
	}
}
