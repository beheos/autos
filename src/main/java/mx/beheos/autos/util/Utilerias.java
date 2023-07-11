package mx.beheos.autos.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Utilerias {
	
	public static String formatearFecha(Date fecha) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(fecha);
	}
	
	public static String encriptarPassword(String password) {
		password = "Jh0n l3N0n_" + password;
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
	
	public static String generarIdEmpleado() {
		Date fecha = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		String anio = String.valueOf(calendar.get(Calendar.YEAR));
		String mes = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Los meses en Calendar se cuentan desde 0, por lo que se suma 1
		String dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		String hora = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		String minuto = String.valueOf(calendar.get(Calendar.MINUTE));
		String segundo = String.valueOf(calendar.get(Calendar.SECOND));
		
		return (dia.length() == 1 ? "0" + dia : dia) + (mes.length() == 1 ? "0" + mes : mes) + anio +
				(hora.length() == 1 ? "0" + hora : hora) + (minuto.length() == 1 ? "0" + minuto : minuto) +
				(segundo.length() == 1 ? "0" + segundo : segundo);
	}

}
