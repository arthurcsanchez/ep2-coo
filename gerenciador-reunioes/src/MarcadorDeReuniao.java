import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MarcadorDeReuniao {

	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private Map<String, ArrayList<LocalDateTime>> participantes = new TreeMap<>();  // true indica que comparecerá, false indica incerteza ou negativa
	private LocalDateTime dataInicialSobreposta;
	private LocalDateTime dataFinalSobreposta;

	/* construtor */
	public MarcadorDeReuniao(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
		marcarReuniaoEntre(dataInicial, dataFinal, listaDeParticipantes);
	}

	/* métodos do enunciado */
	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
		this.dataInicial = dataInicial.atStartOfDay();
		this.dataFinal = dataFinal.atStartOfDay();
		for (String s : listaDeParticipantes) {
			participantes.put(s, new ArrayList<>());
		}
	}

	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim) {
		participantes.get(participante).add(inicio);
		participantes.get(participante).add(fim);
	}

	public void mostrarSobreposicao() {
		LocalDateTime menorData = dataInicial;
		LocalDateTime maiorData = dataFinal;
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		for (Map.Entry<String, ArrayList<LocalDateTime>> e : participantes.entrySet()) {
			if (e.getValue().get(0).isAfter(menorData)) {
				menorData = e.getValue().get(0);
			}
			if (e.getValue().get(1).isBefore(maiorData)) {
				maiorData = e.getValue().get(1);
			}
		}
		if (menorData.isAfter(maiorData)) {
			System.out.println("Infelizmente os participantes selecionaram horários incompatíveis.");
			System.out.println("Tente novamente com outro período.");
		} else {
			this.dataInicialSobreposta = menorData;
			this.dataFinalSobreposta = maiorData;
			System.out.println("O horário ideal é:");
			System.out.println("De " + dateTimeFormat.format(menorData) + " a " + dateTimeFormat.format(maiorData) + ".");
		}
	}

	public LocalDateTime getDataInicialSobreposta() {
		return this.dataInicialSobreposta;
	}

	public LocalDateTime getDataFinalSobreposta() {
		return this.dataFinalSobreposta;
	}

	public LocalDateTime getDataInicial() {
		return this.dataInicial;
	}

	public LocalDateTime getDataFinal() {
		return this.dataFinal;
	}
}
