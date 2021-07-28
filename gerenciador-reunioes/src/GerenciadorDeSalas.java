import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GerenciadorDeSalas {

	private final Map<String, Sala> chamadaSalas;
	private final List<Reserva> chamadaReservas;
	private final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	// construtor
	public GerenciadorDeSalas() {
		chamadaSalas = new TreeMap<>();
		chamadaReservas = new ArrayList<>();
	}

	// métodos do enunciado
	public void adicionaSalaChamada(String nomeSala, int capacidadeMaxima, String descricao) {
		Sala s = new Sala(nomeSala, capacidadeMaxima, descricao);
		chamadaSalas.put(nomeSala, s);
	}

	// métodos do enunciado
	public void removeSalaChamada(String nomeSala) {
		chamadaSalas.remove(nomeSala);
		chamadaReservas.removeIf(r -> r.sala().getNome().equals(nomeSala));
	}

	// métodos do enunciado
	public List<Sala> listaDeSalas() {
		List<Sala> result = new ArrayList<>();
		for (Map.Entry<String, Sala> e : chamadaSalas.entrySet()) {
			result.add(e.getValue());
		}
		return result;
	}

	// métodos do enunciado
	public void adicionaSala(Sala novaSala) {
		chamadaSalas.put(novaSala.getNome(), novaSala);
	}

	// métodos do enunciado
	public Reserva reservaSalaChamada(String nomeSala, LocalDateTime dataInicial, LocalDateTime dataFinal) throws NonExistentSalaException, OccupiedSalaException {
		if (!chamadaSalas.containsKey(nomeSala)) {
			throw new NonExistentSalaException("Não existe sala com o nome " + nomeSala);
		}
		if (chamadaSalas.get(nomeSala).verificarSeSalaEstaOcupada(dataInicial, dataFinal)) {
			throw new OccupiedSalaException("A sala " + nomeSala + " está reservada no período entre " + dateTimeFormat.format(dataInicial) + " e " + dateTimeFormat.format(dataFinal));
		}
		Reserva r = new Reserva(chamadaSalas.get(nomeSala), dataInicial, dataFinal);
		chamadaSalas.get(nomeSala).getListaReservas().add(r);
		chamadaReservas.add(r);
		return r;
	}

	// métodos do enunciado
	public void cancelaReserva(Reserva cancelada) {
		chamadaSalas.get(cancelada.sala().getNome()).removeReserva(cancelada);
		chamadaReservas.remove(cancelada);
	}

	// métodos do enunciado
	public Collection<Reserva> reservaParaSala(String nomeSala) {
		return chamadaSalas.get(nomeSala).getListaReservas();
	}

	// métodos do enunciado
	public void imprimeReservasDaSala(String nomeSala) {
		System.out.println("---- Reservas para a sala \"" + nomeSala + "\": ----");
		for (Reserva r : chamadaSalas.get(nomeSala).getListaReservas()) {
			System.out.println("-> De " + dateTimeFormat.format(r.inicio()) + " a " + dateTimeFormat.format(r.fim()));
		}
	}

}
