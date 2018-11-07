package boundary;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal implements ActionListener {

	private JButton btnAddProd;
	private JButton btnPesqProd;

	public MenuPrincipal() {
		JFrame janela = new JFrame("CadPro");
		JPanel painel = new JPanel(new GridLayout(3, 0));
		JLabel lblBemVindo = new JLabel("                               Bem vindo!");
		btnAddProd = new JButton("Adicionar Produtos");
		btnPesqProd = new JButton("Pesquisar Produtos");

		painel.add(lblBemVindo);
		painel.add(btnAddProd);
		painel.add(btnPesqProd);
		btnAddProd.addActionListener(this);
		btnPesqProd.addActionListener(this);

		janela.setContentPane(painel);
		janela.setVisible(true);
		janela.setSize(270, 170);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Adicionar Produtos".equals(e.getActionCommand())) {
			CadastrarProdutos cad = new CadastrarProdutos();
		} else if ("Pesquisar Produtos".equals(e.getActionCommand())) {
			PesquisarProdutos pesq = new PesquisarProdutos();

		}

	}
}
