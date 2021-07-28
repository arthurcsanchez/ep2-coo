import java.util.ArrayList;
import java.util.List;

public class Sala {

	private final String nome;
	private String local;
	private int capacidade;
	private String observacoes;
	private final List<Reserva> listaReservas;

	public Sala(String nome, int capacidade, String observacoes) {
		this.nome = nome;
		this.capacidade = capacidade;
		this.observacoes = observacoes;
		listaReservas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String novo) {
		local = novo;
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

	public void adicionaReserva(Reserva r) {
		listaReservas.add(r);
	}

	public void removeReserva(Reserva r) {
		listaReservas.remove(r);
	}

	public List<Reserva> getListaReservas() {
		return listaReservas;
	}
}
