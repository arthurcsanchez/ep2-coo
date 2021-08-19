import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws ImpossibleSalaException, ImpossibleDisponibilidadeException, ImpossibleReservaException {

		/*========= REUNIÃO 1 =========*/

		System.out.println("/==============/ REUNIÃO 1 /==============/");

		/* TESTE PARTE 1*/
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


		LocalDate i1 = LocalDate.parse("26/07/2021", dateFormat);
		LocalDate f1 = LocalDate.parse("30/07/2021", dateFormat);

		List<String> p1 = new ArrayList<>();
		p1.add("jose@gmail.com");
		p1.add("maria@outlook.com");
		p1.add("ana@icloud.com");


		MarcadorDeReuniao r1 = new MarcadorDeReuniao(i1, f1, p1);

		LocalDateTime ip1 = LocalDateTime.parse("26/07/2021 08:00", dateTimeFormat);
		LocalDateTime fp1 = LocalDateTime.parse("26/07/2021 21:00", dateTimeFormat);
		r1.indicaDisponibilidadeDe("jose@gmail.com", ip1, fp1);

		ip1 = LocalDateTime.parse("28/07/2021 08:00", dateTimeFormat);
		fp1 = LocalDateTime.parse("28/07/2021 21:00", dateTimeFormat);
		r1.indicaDisponibilidadeDe("jose@gmail.com", ip1, fp1);

		ip1 = LocalDateTime.parse("26/07/2021 12:00", dateTimeFormat);
		fp1 = LocalDateTime.parse("28/07/2021 12:00", dateTimeFormat);
		r1.indicaDisponibilidadeDe("maria@outlook.com", ip1, fp1);

		ip1 = LocalDateTime.parse("28/07/2021 17:00", dateTimeFormat);
		fp1 = LocalDateTime.parse("29/07/2021 12:00", dateTimeFormat);
		r1.indicaDisponibilidadeDe("maria@outlook.com", ip1, fp1);

		ip1 = LocalDateTime.parse("26/07/2021 07:00", dateTimeFormat);
		fp1 = LocalDateTime.parse("28/07/2021 14:00", dateTimeFormat);
		r1.indicaDisponibilidadeDe("ana@icloud.com", ip1, fp1);

		ip1 = LocalDateTime.parse("28/07/2021 19:00", dateTimeFormat);
		fp1 = LocalDateTime.parse("29/07/2021 03:00", dateTimeFormat);
		r1.indicaDisponibilidadeDe("ana@icloud.com", ip1, fp1);


		r1.mostraSobreposicao();


		/* TESTE PARTE 2*/
		GerenciadorDeSalas m1 = new GerenciadorDeSalas();
		m1.adicionaSalaChamada("Auditório Azul", 200, "Auditório maior.");
		m1.adicionaSalaChamada("Auditório Vermelho", 100, "Auditório menor.");
		for (Sala s : m1.listaDeSalas()) {
			System.out.println(s.getNome() + "/" + s.getCapacidade() + "/" + s.getObservacoes());
		}
		System.out.println();
		m1.reservaSalaChamada("Auditório Vermelho", LocalDateTime.parse("29/07/2021 18:00", dateTimeFormat), LocalDateTime.parse("29/07/2021 23:00", dateTimeFormat));
		m1.reservaSalaChamada("Auditório Vermelho", LocalDateTime.parse("28/07/2021 12:30", dateTimeFormat), LocalDateTime.parse("28/07/2021 18:00", dateTimeFormat));
		m1.reservaSalaChamada("Auditório Azul", LocalDateTime.parse("16/08/2021 14:00", dateTimeFormat), LocalDateTime.parse("16/08/2021 19:00", dateTimeFormat));
		m1.reservaSalaChamada("Auditório Azul", LocalDateTime.parse("17/08/2021 13:20", dateTimeFormat), LocalDateTime.parse("17/08/2021 16:40", dateTimeFormat));

		m1.imprimeReservasDaSala("Auditório Vermelho");
		m1.imprimeReservasDaSala("Auditório Azul");
		System.out.println();
		m1.cancelaReserva(m1.reservaParaSala("Auditório Azul").iterator().next());
		m1.imprimeReservasDaSala("Auditório Azul");
		System.out.println();
		m1.removeSalaChamada("Auditório Azul");
		for (Sala s : m1.listaDeSalas()) {
			System.out.println(s.getNome() + "/" + s.getCapacidade() + "/" + s.getObservacoes());
		}




		/*========= REUNIÃO 2 =========*/

		System.out.println("/==============/ REUNIÃO 2 /==============/");

		/* TESTE PARTE 1 */

		LocalDate i2 = LocalDate.parse("15/11/2021", dateFormat);
		LocalDate f2 = LocalDate.parse("19/11/2021", dateFormat);

		List<String> p2 = new ArrayList<>();
		p2.add("mariajoaquina@gmail.com");
		p2.add("cirilo@outlook.com");
		p2.add("daniel@icloud.com");
		p2.add("valeria@yahoo.com");
		p2.add("profhelena@escolamundial.com");

		MarcadorDeReuniao r2 = new MarcadorDeReuniao(i2, f2, p2);


		LocalDateTime ip2 = LocalDateTime.parse("15/11/2021 18:00", dateTimeFormat);
		LocalDateTime fp2 = LocalDateTime.parse("15/11/2021 20:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("mariajoaquina@gmail.com", ip2, fp2);

		ip2 = LocalDateTime.parse("17/11/2021 18:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("17/11/2021 21:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("mariajoaquina@gmail.com", ip2, fp2);

		ip2 = LocalDateTime.parse("17/11/2021 12:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("18/11/2021 12:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("profhelena@escolamundial.com", ip2, fp2);

		ip2 = LocalDateTime.parse("15/11/2021 17:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("16/11/2021 12:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("daniel@icloud.com", ip2, fp2);

		ip2 = LocalDateTime.parse("16/11/2021 07:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("17/11/2021 14:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("daniel@icloud.com", ip2, fp2);

		ip2 = LocalDateTime.parse("17/11/2021 19:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("18/11/2021 03:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("daniel@icloud.com", ip2, fp2);

		ip2 = LocalDateTime.parse("17/11/2021 19:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("18/11/2021 01:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("cirilo@outlook.com", ip2, fp2);

		ip2 = LocalDateTime.parse("15/11/2021 15:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("16/11/2021 10:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("valeria@yahoo.com", ip2, fp2);

		ip2 = LocalDateTime.parse("17/11/2021 19:00", dateTimeFormat);
		fp2 = LocalDateTime.parse("17/11/2021 23:00", dateTimeFormat);
		r2.indicaDisponibilidadeDe("valeria@yahoo.com", ip2, fp2);

		r2.mostraSobreposicao();


		/* TESTE PARTE 2 */
		GerenciadorDeSalas m2 = new GerenciadorDeSalas();
		m2.adicionaSalaChamada("Sala de Aula", 20, "Tamanho ideal.");
		m2.adicionaSalaChamada("Laboratório de Informática", 10, "Poucos Equipamentos.");
		m2.adicionaSalaChamada("Quadra", 50, "Muito espaço.");
		for (Sala s : m2.listaDeSalas()) {
			System.out.println(s.getNome() + "/" + s.getCapacidade() + "/" + s.getObservacoes());
		}
		System.out.println();
		m2.reservaSalaChamada("Sala de Aula", LocalDateTime.parse("15/11/2021 18:00",dateTimeFormat), LocalDateTime.parse("15/11/2021 23:00", dateTimeFormat));
		m2.reservaSalaChamada("Sala de Aula", LocalDateTime.parse("17/11/2021 12:30", dateTimeFormat), LocalDateTime.parse("17/11/2021 23:00", dateTimeFormat));
		m2.reservaSalaChamada("Laboratório de Informática", LocalDateTime.parse("16/11/2021 14:00", dateTimeFormat), LocalDateTime.parse("16/11/2021 19:00", dateTimeFormat));
		m2.reservaSalaChamada("Quadra", LocalDateTime.parse("17/11/2021 13:20", dateTimeFormat), LocalDateTime.parse("17/11/2021 16:40", dateTimeFormat));

		m2.imprimeReservasDaSala("Sala de Aula");
		m2.imprimeReservasDaSala("Laboratório de Informática");
		m2.imprimeReservasDaSala("Quadra");
		System.out.println();
		m2.reservaSalaChamada("Sala de Aula", LocalDateTime.parse("17/11/2021 19:00",dateTimeFormat), LocalDateTime.parse("17/11/2021 21:00", dateTimeFormat));
	}
}
