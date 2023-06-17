package mx.beheos.autos.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilerias {
	
	public  static String formatearFecha(Date fecha) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(fecha);
	}

}
