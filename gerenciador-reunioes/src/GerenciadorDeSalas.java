import java.time.*;
import java.util.*;
import java.util.stream.Stream;

public class GerenciadorDeSalas {

	private Map<String, Sala> chamada;

	// construtor
	public GerenciadorDeSalas() {
		chamada = new TreeMap<>();
	}

	// métodos do enunciado
	public void adicionaSalaChamada(String nomeSala, int capacidadeMaxima, String descricao) {
		Sala s = new Sala(nomeSala, capacidadeMaxima, descricao);
		chamada.put(nomeSala, s);
	}

	// métodos do enunciado
	public void removeSalaChamada(String nomeSala) {
		chamada.remove(nomeSala);
	}

	// métodos do enunciado
	public List<Sala> listaDeSalas() {
		List<Sala> result = new ArrayList<>();
		for (Map.Entry<String, Sala> e : chamada.entrySet()) {
			result.add(e.getValue());
		}
		return result;
	}

	// métodos do enunciado
	public void adicionaSala(Sala novaSala) {
		chamada.put(novaSala.getNome(), novaSala);
	}

	// métodos do enunciado
	public Reserva reservaSalaChamada(String nomeSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {}

	// métodos do enunciado
	public void cancelaReserva(Reserva cancelada) {}

	// métodos do enunciado
	public Collection<Reserva> reservaParaSala(String nomeSala) {}

	// métodos do enunciado
	public void imprimeReservasDaSala(String nomeSala) {}

}
