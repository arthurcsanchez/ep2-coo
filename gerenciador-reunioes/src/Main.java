import javax.swing.text.DateFormatter;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws OccupiedSalaException, NonExistentSalaException {

		/* TESTE PARTE 1*/
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


		LocalDate inicio = LocalDate.parse("26/07/2021", dateFormat);
		LocalDate fim = LocalDate.parse("30/07/2021", dateFormat);

		List<String> participantes = new ArrayList<>();
		participantes.add("jose@gmail.com");
		participantes.add("maria@outlook.com");
		participantes.add("ana@icloud.com");


		MarcadorDeReuniao reuniao = new MarcadorDeReuniao(inicio, fim, participantes);

		LocalDateTime inicioDisp = LocalDateTime.parse("26/07/2021 08:00", dateTimeFormat);
		LocalDateTime fimDisp = LocalDateTime.parse("26/07/2021 21:00", dateTimeFormat);
		reuniao.indicaDisponibilidadeDe("jose@gmail.com", inicioDisp, fimDisp);

		inicioDisp = LocalDateTime.parse("28/07/2021 08:00", dateTimeFormat);
		fimDisp = LocalDateTime.parse("28/07/2021 21:00", dateTimeFormat);
		reuniao.indicaDisponibilidadeDe("jose@gmail.com", inicioDisp, fimDisp);

		inicioDisp = LocalDateTime.parse("26/07/2021 12:00", dateTimeFormat);
		fimDisp = LocalDateTime.parse("28/07/2021 12:00", dateTimeFormat);
		reuniao.indicaDisponibilidadeDe("maria@outlook.com", inicioDisp, fimDisp);

		inicioDisp = LocalDateTime.parse("26/07/2021 07:00", dateTimeFormat);
		fimDisp = LocalDateTime.parse("29/07/2021 20:00", dateTimeFormat);
		reuniao.indicaDisponibilidadeDe("ana@icloud.com", inicioDisp, fimDisp);


		reuniao.mostrarSobreposicao();


		/* TESTE PARTE 2*/
		GerenciadorDeSalas m = new GerenciadorDeSalas();
		m.adicionaSalaChamada("Auditório Azul", 200, "Auditório maior.");
		m.adicionaSalaChamada("Auditório Vermelho", 100, "Auditório menor.");
		for (Sala s : m.listaDeSalas()) {
			System.out.println(s.getNome() + "/" + s.getCapacidade() + "/" + s.getObservacoes());
		}
		System.out.println();
		m.reservaSalaChamada("Auditório Vermelho", LocalDateTime.parse("29/07/2021 18:00", dateTimeFormat), LocalDateTime.parse("29/07/2021 23:00", dateTimeFormat));
		m.reservaSalaChamada("Auditório Vermelho", LocalDateTime.parse("28/07/2021 12:30", dateTimeFormat), LocalDateTime.parse("28/07/2021 18:00", dateTimeFormat));
		m.reservaSalaChamada("Auditório Azul", LocalDateTime.parse("16/08/2021 14:00", dateTimeFormat), LocalDateTime.parse("16/08/2021 19:00", dateTimeFormat));
		m.reservaSalaChamada("Auditório Azul", LocalDateTime.parse("17/08/2021 13:20", dateTimeFormat), LocalDateTime.parse("17/08/2021 16:40", dateTimeFormat));

		m.imprimeReservasDaSala("Auditório Vermelho");
		m.imprimeReservasDaSala("Auditório Azul");
		System.out.println();
		m.cancelaReserva(m.reservaParaSala("Auditório Azul").iterator().next());
		m.imprimeReservasDaSala("Auditório Azul");
		System.out.println();
		m.removeSalaChamada("Auditório Azul");
		for (Sala s : m.listaDeSalas()) {
			System.out.println(s.getNome() + "/" + s.getCapacidade() + "/" + s.getObservacoes());
		}


	}
}
