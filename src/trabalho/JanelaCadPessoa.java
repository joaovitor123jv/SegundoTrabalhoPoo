package trabalho;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
public class JanelaCadPessoa extends JFrame implements ActionListener
{
	private JButton btAnterior, btNovo, btCancelar, btSalvar, btProximo;
	private JLabel lbNome, lbCPF, lbCNPJ, lbTipoPessoa;
	private JTextField tfNome, tfCPF, tfCNPJ;
	private JComboBox cbTipoPessoa;
	private JPanel pnBotoes, pnDados;
	private int numeroLinha;

	public JanelaCadPessoa()
	{
		this.numeroLinha = 1;
		this.setLayout(new BorderLayout());

		pnBotoes = new JPanel();
		pnDados = new JPanel();

		this.add(pnDados, BorderLayout.CENTER);
		this.add(pnBotoes, BorderLayout.SOUTH);
		
		pnDados.setLayout(new GridLayout(4, 2));
		pnBotoes.setLayout(new GridLayout(1, 5));

		lbTipoPessoa = new JLabel("Tipo de Pessoa");
		lbNome = new JLabel("Nome");
		lbCPF = new JLabel("CPF");
		lbCNPJ = new JLabel("CNPJ");

		String[] strTipoPessoa = {"Pessoa Física", "Pessoa Jurídica"};
		cbTipoPessoa = new JComboBox(strTipoPessoa);
		cbTipoPessoa.setSelectedIndex(0);

		tfNome = new JTextField(50);
		tfCPF = new JTextField(50);
		tfCNPJ = new JTextField(50);

		btAnterior = new JButton("Anterior");
		btProximo = new JButton("Proximo");
		btSalvar = new JButton("Salvar");
		btCancelar = new JButton("Cancelar");
		btNovo = new JButton("Novo");

		pnDados.add(lbTipoPessoa); pnDados.add(cbTipoPessoa);
		pnDados.add(lbNome); pnDados.add(tfNome);
		pnDados.add(lbCPF); pnDados.add(tfCPF);
		pnDados.add(lbCNPJ); pnDados.add(tfCNPJ);

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
		this.setTitle("Cadastro Pessoa");
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
				Arquivo arquivo = new Arquivo("Pessoas.txt");
				int numeroLinha = 1;
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
				
				Pessoa pessoa = new Pessoa();

				if(pessoa.getTipoPessoa(this.numeroLinha)== "Pessoa Física")
				{
					PessoaFisica pessoaFisica = new PessoaFisica();
					pessoaFisica.getDados(this.numeroLinha);
					cbTipoPessoa.setSelectedItem(0);
					tfNome.setText(pessoaFisica.getNome());
					tfCPF.setText(pessoaFisica.getCPF());
				}
				else if(pessoa.getTipoPessoa(this.numeroLinha) == "PessoaJuridica")
				{
					PessoaJuridica pessoaJuridica = new PessoaJuridica();
					pessoaJuridica.getDados(this.numeroLinha);
					cbTipoPessoa.setSelectedItem(1);
					tfCNPJ.setText(pessoaJuridica.getCNPJ());
					tfNome.setText(pessoaJuridica.getNome());
				}

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
				Arquivo arquivo = new Arquivo("Pessoas.txt");
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
// 				this.numeroLinha++;
				Pessoa pessoa = new Pessoa();
				System.out.println("\""+pessoa.getTipoPessoa(this.numeroLinha)+"\"");

				if(pessoa.getTipoPessoa(this.numeroLinha).equals("Pessoa Física"))
				{
					System.out.println("ENTROU");
					PessoaFisica pessoaFisica = new PessoaFisica();
					pessoaFisica.getDados(this.numeroLinha);
					cbTipoPessoa.setSelectedItem(0);
					tfNome.setText(pessoaFisica.getNome());
					tfCPF.setText(pessoaFisica.getCPF());
					System.out.println(pessoaFisica);
				}
				else if(pessoa.getTipoPessoa(this.numeroLinha).equals("Pessoa Juridica"))
				{
					PessoaJuridica pessoaJuridica = new PessoaJuridica();
					pessoaJuridica.getDados(this.numeroLinha);
					cbTipoPessoa.setSelectedItem(1);
					tfCNPJ.setText(pessoaJuridica.getCNPJ());
					tfNome.setText(pessoaJuridica.getNome());
					System.out.println(pessoaJuridica);
				}

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
			tfNome.setText("");
			tfCPF.setText("");
			cbTipoPessoa.setSelectedIndex(0);
			tfCNPJ.setText("");
		}



		else if(e.getSource() == btSalvar)
		{
			String nome = tfNome.getText();
			String CPF = tfCPF.getText();
			String CNPJ = tfCNPJ.getText();
			String tipoPessoa = (String) cbTipoPessoa.getSelectedItem();
 			int id = 1;
			try
			{
				Arquivo arquivo = new Arquivo("Pessoas.txt");
				String leitura = arquivo.leLinha();
				if(leitura=="")
				{
					id = 1;
				}
				else
				{
					leitura = arquivo.leLinha();
					while(leitura!="" && leitura!=null)
					{
						id++;
						leitura = arquivo.leLinha();
					}
					id++;
				}
				arquivo.fechar();
			}
			catch(IOException ex)
			{
				System.out.println(ex.getStackTrace());
			}

			if(tipoPessoa == "Pessoa Física")
			{
				PessoaFisica pessoa = new PessoaFisica(CPF, id, nome);
				try
				{
					Arquivo arquivo = new Arquivo("Pessoas.txt");
					arquivo.leLinha(id);
					arquivo.escreve(pessoa.toString());
					arquivo.salvar();
				}
				catch(IOException ex)
				{
					System.out.println(ex.getStackTrace());
				}
			}
			else
			{
				PessoaJuridica pessoa = new PessoaJuridica(CNPJ, id, nome);
				try
				{
					Arquivo arquivo = new Arquivo("Pessoas.txt");
					arquivo.leLinha(id);
					arquivo.escreve(pessoa.toString());
					arquivo.salvar();
				}
				catch(IOException ex)
				{
					System.out.println(ex.getStackTrace());
				}
			}
			JOptionPane.showMessageDialog(null,"Pessoa cadastrada com sucesso");
		}
	}
}
