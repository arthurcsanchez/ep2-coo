import java.time.*;
import java.util.*;

public class MarcadorDeReuniao {

	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private Map<String, ArrayList<LocalDateTime>> participantes = new TreeMap<>();  // true indica que comparecerá, false indica incerteza ou negativa

	/* construtor */
	public MarcadorDeReuniao(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
		marcarReuniaoEntre(dataInicial, dataFinal, listaDeParticipantes);
	}

	/* métodos do enunciado */
	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		for (String s : listaDeParticipantes) {
			participantes.put(s, new ArrayList<>());
		}
	}

	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim) {
		participantes.get(participante).add(inicio);
		participantes.get(participante).add(fim);
	}

	public void mostrarSobreposicao() {}
}
