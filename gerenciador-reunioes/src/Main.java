import javax.swing.text.DateFormatter;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
	public static void main(String[] args) {
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
	}
}
