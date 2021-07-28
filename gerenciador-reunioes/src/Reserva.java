import java.time.LocalDateTime;

public class Reserva {

	private final Sala sala;
	private final LocalDateTime inicio;
	private final LocalDateTime fim;

	public Reserva(Sala sala, LocalDateTime inicio, LocalDateTime fim) {
		this.sala = sala;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Sala sala() {
		return sala;
	}

	public LocalDateTime inicio() {
		return inicio;
	}

	public LocalDateTime fim() {
		return fim;
	}
}
