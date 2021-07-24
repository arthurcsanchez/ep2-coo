import java.time.*;
import java.util.*;

public class GerenciadorDeSalas {

	/* construtor */
	public GerenciadorDeSalas() {}

	/* métodos do enunciado */
	public void adicionaSalaChamada(String nomeSala, int capacidadeMaxima, String descricao) {}

	public void removeSalaChamada(String nomeSala) {}

	public List<Sala> listaDeSalas() {}

	public void adicionaSala(Sala novaSala) {}

	public Reserva reservaSalaChamada(String nomeSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {}

	public void cancelaReserva(Reserva cancelada) {}

	public Collection<Reserva> reservaParaSala(String nomeSala) {}

	public void imprimeReservasDaSala(String nomeSala) {}
}
