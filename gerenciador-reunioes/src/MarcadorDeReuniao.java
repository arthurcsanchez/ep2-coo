import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MarcadorDeReuniao {

	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private final Map<String, ArrayList<LocalDateTime>> participantes = new TreeMap<>();
	private final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	// construtor básico
	public MarcadorDeReuniao() {}

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
	public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim) throws ImpossibleDisponibilidadeException {
		if (inicio.isAfter(fim)) {
			throw new ImpossibleDisponibilidadeException("O período entre " + inicio + " e " + fim + " não é possível");
		}
		if (inicio.isEqual(fim)) {
			throw new ImpossibleDisponibilidadeException("Os horários de início e fim selecionados são iguais a " + inicio + ", o que não determina um período");
		}
		if (fim.isBefore(dataInicial)) {
			throw new ImpossibleDisponibilidadeException("O horário de fim selecionado " + fim + " é anterior ao início estipulado pelos organizadores " + dataInicial);
		}
		if (inicio.isAfter(dataFinal)) {
			throw new ImpossibleDisponibilidadeException("O horário de inicio selecionado " + inicio + " é posterior ao fim estipulado pelos organizadores " + dataFinal);
		}
		if (inicio.isBefore(dataInicial)) {
			inicio = dataInicial;
		}
		if (fim.isAfter(dataFinal)) {
			fim = dataFinal;
		}
		participantes.get(participante).add(inicio);
		participantes.get(participante).add(fim);
	}

	private boolean houveImpressao = false;

	// método do enunciado
	public void mostraSobreposicao() {
		System.out.println("---- Disponibilidades dos participantes da reunião: ----");
		for (Map.Entry<String, ArrayList<LocalDateTime>> e : participantes.entrySet()) {
			System.out.print(e.getKey() + ": ");
			int c = 0;
			for (LocalDateTime l : e.getValue()) {
				if (c % 2 == 0) System.out.print("(" + dateTimeFormat.format(l) + ")-");
				else System.out.print("(" + dateTimeFormat.format(l) + ")   ");
				c++;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("---- Horários possíveis para a reunião: ----");
		Iterator<Map.Entry<String, ArrayList<LocalDateTime>>> it = participantes.entrySet().iterator();
		mostraSobreposicao(0, dataInicial, dataFinal, it.next(), it, 1);
		if (!houveImpressao) {
			System.out.println("Não há sobreposição entre as disponibilidades dos participantes da reunião");
		}
		System.out.println();
	}

	// auxiliar
	private void mostraSobreposicao(int i, LocalDateTime menorData, LocalDateTime maiorData, Map.Entry<String, ArrayList<LocalDateTime>> participante, Iterator<Map.Entry<String, ArrayList<LocalDateTime>>> iterador, int cont) {
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
				mostraSobreposicao(++i, menorData, maiorData, participante, novoIt1, cont);
			} catch (IndexOutOfBoundsException ignored) {
			} catch (NoSuchElementException ignored) {
				houveImpressao = true;
				System.out.println("-> De " + dateTimeFormat.format(novaMenorData) + " a " + dateTimeFormat.format(novaMaiorData) + ".");
			}
			return;
		}

		boolean caughtException = false;
		try {
			mostraSobreposicao(0, novaMenorData, novaMaiorData, iterador.next(), iterador, cont + 1);
		} catch (NoSuchElementException ignored) {
			caughtException = true;
			houveImpressao = true;
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
				mostraSobreposicao(++i, novaMenorData, novaMaiorData, participante, novoIt2, cont);  // antes era cont + 1
			} catch (IndexOutOfBoundsException ignored) {
			} catch (NoSuchElementException ignored) {
				houveImpressao = true;
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
