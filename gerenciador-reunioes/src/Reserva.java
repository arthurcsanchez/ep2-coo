import java.time.LocalDateTime;

public class Reserva {

	private Sala sala;
	private LocalDateTime inicio;
	private LocalDateTime fim;

	// construtor nulo
	public Reserva() {}

	// construtor
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

	public Sala getSala() {
		return sala();
	}

	public LocalDateTime getInicio() {
		return inicio();
	}

	public LocalDateTime getFim() {
		return fim();
	}
}
