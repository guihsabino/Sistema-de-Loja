package controle;

import java.util.List;

import entidade.Produtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ControleProdutos {

	private static String url = "jdbc:mariadb://localhost:3306/Produto";
	private static String user = "root";
	private static String pass = "";

	public ControleProdutos() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe Carregada ");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// sempre o array e do tipo da entidade
	// public List<Produtos> controle = new ArrayList<>();

	public void adicionar(Produtos l) {
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, pass);

			// declarando uma conexão com o bd

			Statement stmt = con.createStatement();
			String sql = "insert into produtos (nome_produto,codigo,valor,grupo)" + " values ('" + l.getNome() + "','"
					+ l.getCodigo() + "','" + l.getValor() + "','" + l.getGrupo() + "');";
			int i = stmt.executeUpdate(sql);
			System.out.printf("foram alteradas %d linhas", i);
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Produtos pesquisar(String txtNome) {
		Produtos p = new Produtos();
		try {
			Connection con;
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM produtos 	WHERE nome_produto like '%" + txtNome + "%'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				p.setNome(rs.getString("nome_produto"));
				p.setCodigo(rs.getString("codigo"));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				p.setGrupo(rs.getString("grupo"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}
}
