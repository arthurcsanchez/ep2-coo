public class Sala {

	private final String nome;
	private final String local;
	private int capacidade;
	private String observacoes;

	public Sala(String nome, String local, int capacidade, String observacoes) {
		this.nome = nome;
		this.local = local;
		this.capacidade = capacidade;
		this.observacoes = observacoes;
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int novo) {
		capacidade = novo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String novo) {
		observacoes = novo;
	}
}
