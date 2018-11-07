package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PesquisarProdutos implements ActionListener {

	private JButton btnPesquisar;
	private JTextField txtNome = new JTextField(50);

	public PesquisarProdutos() {

		JFrame janela = new JFrame("Pesquisa de Produtos");
		JPanel painelPesquisa = new JPanel(new GridLayout(1, 3));
		JPanel painelTabela = new JPanel(new FlowLayout());
		JLabel lblNome = new JLabel("Nome:");
		btnPesquisar = new JButton("Pesquisar");
		JTable tblPesquisa = new JTable(8, 4);

		painelPesquisa.add(lblNome);
		painelPesquisa.add(txtNome);
		painelPesquisa.add(btnPesquisar);
		btnPesquisar.addActionListener(this);

		// adicionado ao painelTabela

		painelTabela.add(tblPesquisa);

		janela.getContentPane().add(painelPesquisa, BorderLayout.NORTH);
		janela.getContentPane().add(painelTabela, BorderLayout.SOUTH);
		janela.setVisible(true);
		janela.setSize(430, 150);
		janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Pesquisar".equals(e.getActionCommand()))
			;
		System.out.println("PESQUISANDO NO BANQUINHO TELA DE PESQUISA DE PRODUTOS");
	}

}
