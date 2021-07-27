import java.time.*;
import java.util.*;

public class GerenciadorDeSalas {

	// construtor
	public GerenciadorDeSalas() {}

	// métodos do enunciado
	public void adicionaSalaChamada(String nomeSala, int capacidadeMaxima, String descricao) {}

	// métodos do enunciado
	public void removeSalaChamada(String nomeSala) {}

	// métodos do enunciado
	public List<Sala> listaDeSalas() {}

	// métodos do enunciado
	public void adicionaSala(Sala novaSala) {}

	// métodos do enunciado
	public Reserva reservaSalaChamada(String nomeSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {}

	// métodos do enunciado
	public void cancelaReserva(Reserva cancelada) {}

	// métodos do enunciado
	public Collection<Reserva> reservaParaSala(String nomeSala) {}

	// métodos do enunciado
	public void imprimeReservasDaSala(String nomeSala) {}

}
