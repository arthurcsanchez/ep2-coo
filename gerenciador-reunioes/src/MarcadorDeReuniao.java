import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MarcadorDeReuniao {

	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private final Map<String, ArrayList<LocalDateTime>> participantes = new TreeMap<>();  // talvez tenha q tirar final
	private final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	// construtor
	public MarcadorDeReuniao(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
		marcarReuniaoEntre(dataInicial, dataFinal, listaDeParticipantes);
	}

	// método do enunciado
	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
		this.dataInicial = dataInicial.atStartOfDay();
		this.dataFinal = dataFinal.atStartOfDay();
		for (String s : listaDeParticipantes) {
			participantes.put(s, new ArrayList<>());
		}
	}

	// método do enunciado
	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim) {
		participantes.get(participante).add(inicio);
		participantes.get(participante).add(fim);
	}

	// método do enunciado
	public void mostrarSobreposicao() {
		System.out.println("---- Horários possíveis para a reunião: ----");
		Iterator<Map.Entry<String, ArrayList<LocalDateTime>>> it = participantes.entrySet().iterator();
		mostrarSobreposicao(0, dataInicial, dataFinal, it.next(), it, 1);
	}

	// auxiliar
	private void mostrarSobreposicao(int i, LocalDateTime menorData, LocalDateTime maiorData, Map.Entry<String, ArrayList<LocalDateTime>> participante, Iterator<Map.Entry<String, ArrayList<LocalDateTime>>> iterador, int cont) {
		if (menorData.isAfter(maiorData)) {
			return;
		}
		LocalDateTime novaMenorData = menorData;
		LocalDateTime novaMaiorData = maiorData;

		if (participante.getValue().get(2*i).isAfter(menorData)) {
			novaMenorData = participante.getValue().get(2*i);
		}
		if (participante.getValue().get(2*i+1).isBefore(maiorData)) {
			novaMaiorData = participante.getValue().get(2*i+1);
		}

		if (novaMenorData.isAfter(novaMaiorData)) {
			try {
				Iterator<Map.Entry<String, ArrayList<LocalDateTime>>> novoIt1 = participantes.entrySet().iterator();
				for (int j = 0; j < cont; j++) {
					novoIt1.next();
				}
				mostrarSobreposicao(++i, menorData, maiorData, participante, novoIt1, cont);
			} catch (IndexOutOfBoundsException ignored) {
			} catch (NoSuchElementException ignored) {
				System.out.println("-> De " + dateTimeFormat.format(novaMenorData) + " a " + dateTimeFormat.format(novaMaiorData) + ".");
			}
			return;
		}

		boolean caughtException = false;
		try {
			mostrarSobreposicao(0, novaMenorData, novaMaiorData, iterador.next(), iterador, cont + 1);
		} catch (NoSuchElementException ignored) {
			caughtException = true;
			System.out.println("-> De " + dateTimeFormat.format(novaMenorData) + " a " + dateTimeFormat.format(novaMaiorData) + ".");
		}
		if (!caughtException) {
			try {
				if (novaMenorData.isEqual(participante.getValue().get(2*i))) novaMenorData = menorData;
				if (novaMaiorData.isEqual(participante.getValue().get(2*i+1))) novaMaiorData = maiorData;
				Iterator<Map.Entry<String, ArrayList<LocalDateTime>>> novoIt2 = participantes.entrySet().iterator();
				for (int j = 0; j < cont; j++) {
					novoIt2.next();
				}
				mostrarSobreposicao(++i, novaMenorData, novaMaiorData, participante, novoIt2, cont);  // antes era cont + 1
			} catch (IndexOutOfBoundsException ignored) {
			} catch (NoSuchElementException ignored) {
				System.out.println("-> De " + dateTimeFormat.format(novaMenorData) + " a " + dateTimeFormat.format(novaMaiorData) + ".");
			}
		}
	}

	// getter
	public LocalDateTime getDataInicial() {
		return this.dataInicial;
	}

	// getter
	public LocalDateTime getDataFinal() {
		return this.dataFinal;
	}
}
