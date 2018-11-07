package boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controle.ControleProdutos;
import entidade.Produtos;

public class CadastrarProdutos implements ActionListener {
	private JTextField txtNome = new JTextField(40);
	private JTextField txtCodigo = new JTextField(40);
	private JTextField txtValor = new JTextField(40);
	private JTextField txtGrupo = new JTextField(40);
	private JButton btnAdicionar;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JButton btnPesquisar;
	String[] grupos = { "Papel de Parede", "Rodapés", "Pisos Vinilicos" };
	ControleProdutos controle = new ControleProdutos();
	private JComboBox cmbGrupo;

	public CadastrarProdutos() {

		// declaração do JFrame dos paineis e dos labels
		JFrame janela = new JFrame("Cadastro de Produtos");
		JPanel painelCad = new JPanel(new GridLayout(4, 2));
		JPanel painelBotoes = new JPanel(new GridLayout(1, 4));
		JLabel lblNomeProd = new JLabel("Nome:");
		JLabel lblCodProd = new JLabel("Codigo:");
		JLabel lblValorProd = new JLabel("Valor:");
		JLabel lblGrupoProd = new JLabel("Grupo:");
		cmbGrupo = new JComboBox(grupos);
		btnAdicionar = new JButton("Adicionar");
		btnAtualizar = new JButton("Atualizar");
		btnDeletar = new JButton("Excluir");
		btnPesquisar = new JButton("Pesquisar");

		// Inserção no Painel "painelCad" dos Labels e Text Field para depois
		// ser inserido em um BorderLayout

		painelCad.add(lblNomeProd);
		painelCad.add(txtNome);
		painelCad.add(lblCodProd);
		painelCad.add(txtCodigo);
		painelCad.add(lblValorProd);
		painelCad.add(txtValor);
		painelCad.add(lblGrupoProd);
		painelCad.add(cmbGrupo);

		// Inserção no Painel "painelBotoes" dos Botoes

		painelBotoes.add(btnAdicionar);
		painelBotoes.add(btnPesquisar);
		painelBotoes.add(btnDeletar);
		painelBotoes.add(btnAtualizar);

		// Inserindo Açoes aos Botões

		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnAtualizar.addActionListener(this);

		janela.getContentPane().add(painelCad, BorderLayout.NORTH);
		janela.getContentPane().add(painelBotoes, BorderLayout.SOUTH);

		janela.setVisible(true);
		janela.setSize(390, 180);
		janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Adicionar".equals(e.getActionCommand())) {
			Produtos cad = new Produtos();
			cad.setNome(txtNome.getText());
			cad.setCodigo(txtCodigo.getText());
			cad.setValor(Float.parseFloat(txtValor.getText()));
			cad.setGrupo(cmbGrupo.getSelectedItem());
			controle.adicionar(cad);
			JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO");

		} else if ("Pesquisar".equals(e.getActionCommand())) {
			Produtos cad = controle.pesquisar(txtNome.getText());
			txtNome.setText(cad.getNome());
			txtCodigo.setText(cad.getCodigo());
			txtValor.setText(String.valueOf(cad.getNome()));
			// txtGrupo.setText(cad.getGrupo());

		} else if ("Excluir".equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(null, "PRODUTO DELETADO");
		} else if ("Atualizar".equals(e.getActionCommand())) {
			// System.out.println
			JOptionPane.showMessageDialog(null, "PRODUTO ATUALIZADO");
		}

	}
}
