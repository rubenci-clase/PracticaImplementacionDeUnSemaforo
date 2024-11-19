package ejer5;

import java.util.regex.Pattern;

public class Comprobar {
	
	//Función Para comprobar si el nombre es válido.
	public static boolean Nombre(String nombre) {
		//Comprobamos si es mayor a 5
		if (nombre.length() < 5) return false;
		
		for (int i = 0; i < nombre.length(); i++) {
			//Comprobamos si tiene numeros
			if (Character.isDigit(nombre.charAt(i))) return false;
		}
		return true;
	}
	//Función Para comprobar si la fecha es válida.
	public static boolean Fecha(String fechaNacimiento) {
		String exRegularFecha = "^([0-2]?[0-9]|3[01])/(0?[1-9]|1[0-2])/([0-9]{4})$";
		if(!Pattern.matches(exRegularFecha, fechaNacimiento)) return false;
		return true;
	}
	//Función Para comprobar si el correo es válido.
	public static boolean Correo(String email) {
		String exRegularCorreo = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
		if(!Pattern.matches(exRegularCorreo, email)) return false;
		return true;
	}
}
