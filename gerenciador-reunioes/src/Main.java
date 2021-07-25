import javax.swing.text.DateFormatter;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("=======//=======");
		System.out.println("Bem-vindo, organizador.");
		System.out.println();

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Escolha um período em que o evento pode ser realizado.");
		System.out.print("Insira a data (dd/MM/aaaa) em que se inicia esse período: ");
		LocalDate inicio = LocalDate.parse(s.nextLine(), dateFormat);
		System.out.println();
		System.out.print("Insira a data (dd/MM/aaaa) em que se encerra esse período: ");
		LocalDate fim = LocalDate.parse(s.nextLine(), dateFormat);
		System.out.println();
		System.out.println();

		List<String> participantes = new ArrayList<>();
		System.out.println("Insira o e-mail dos participantes. Insira 0 quando terminar.");
		String atual;
		while (true) {
			atual = s.nextLine();
			if (atual.equals("0")) break;
			participantes.add(atual);
		}
		System.out.println();

		MarcadorDeReuniao reuniao = new MarcadorDeReuniao(inicio, fim, participantes);
		System.out.println("Reunião marcada. Os participantes agora serão perguntados sobre sua disponibilidade no período mencionado.");
		System.out.println("Após isso, um relatório com a sobreposição das disponibilidades dos participantes será exibido.");
		System.out.println();

		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		for (String p : participantes) {
			System.out.println("=======//=======");
			System.out.println("Bem-vindo, participante " + p + ".");
			System.out.println();

			System.out.println("O evento a que você foi convidado pode ocorrer entre " + inicio.toString() + " e " + fim.toString() + ".");
			System.out.println("Escolha um período entre as duas datas em que você pode participar do evento.");
			System.out.print("Insira a data e horário (dd/MM/aaaa HH:mm) em que se inicia esse período: ");
			LocalDateTime inicioDisp = LocalDateTime.parse(s.nextLine(), dateTimeFormat);
			System.out.println();
			System.out.print("Insira a data e horário (dd/MM/aaaa HH:mm) em que se encerra esse período: ");
			LocalDateTime fimDisp = LocalDateTime.parse(s.nextLine(), dateTimeFormat);
			System.out.println();
			reuniao.indicaDisponibilidadeDe(p, inicioDisp, fimDisp);
			System.out.println();
		}

		System.out.println("=======//=======");
		System.out.println("Bem-vindo de volta, organizador.");
		System.out.println();

		System.out.println("Este é o resultado da sobreposição da disponibilidade dos participantes:");
		reuniao.mostrarSobreposicao();

		// fazer a parte de gerenciamento de salas em seguida
	}
}
