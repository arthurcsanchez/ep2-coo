import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sala {

	private String nome;
	private String local;
	private int capacidade;
	private String observacoes;
	private final List<Reserva> listaReservas;

	// construtor nulo
	public Sala() {
		listaReservas = new ArrayList<>();
	}

	// construtor
	public Sala(String nome, int capacidade, String observacoes) {
		this.nome = nome;
		this.capacidade = capacidade;
		this.observacoes = observacoes;
		listaReservas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public boolean verificarSeSalaEstaOcupada(LocalDateTime inicio, LocalDateTime fim) {
		for (Reserva r : listaReservas) {
			if (r.inicio().isEqual(inicio) || r.fim().isEqual(fim)) return true;
			if (r.inicio().isBefore(fim) && r.fim().isAfter(inicio)) return true;
		}
		return false;
	}
}
