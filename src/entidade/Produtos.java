package entidade;

public class Produtos {

	String nome;
	String codigo;
	float valor;
	Object Grupo;

	// get e set só pega um produto e seta um valor a um atributo de um objeto

	// Get e Set Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Get e Set Codigo
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	// Get e Set Valor
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Object getGrupo() {
		return Grupo;
	}

	public void setGrupo(Object object) {
		Grupo = object;
	}

}
