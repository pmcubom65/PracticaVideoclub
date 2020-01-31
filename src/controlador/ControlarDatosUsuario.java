package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


import modelo.Pelicula;

public class ControlarDatosUsuario {

	public Pelicula recogerDatos() {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca titulo");
		String titulo = input.nextLine();
		System.out.println("Introduzca director");
		String director = input.nextLine();
		System.out.println("Introduzca año de lanzamiento, formato yyyy, si no será nulo.\nLa base de datos tiene tipo dato year(4)"
				+ "range '1901' to '2155'. Si no será nulo.");
		String year = input.nextLine();
		String year_v=verificaranho(year);
		System.out.println("Introduzca categoria");
		String categoria = input.nextLine();

		return new Pelicula(titulo, year_v, director, categoria);
	}
	
	
	
	public String verificaranho(String y) {
		String salida="";
		LocalDate ld=LocalDate.now();
		int anho=0;
		try {
			anho=Integer.parseInt(y);
			if (anho>ld.getYear()){
				salida="";
			}else if (anho<1901) {
				salida="";
			}
			else {
				salida=y;
			}
		}catch(NumberFormatException nfe){
			salida="";
		}
		return salida;
	}
	
	
	public String tituloPelicula() {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca el titulo de la pelicula, por ejemplo Pirates of the Caribean 4");
		String titulo = input.nextLine();
		return titulo;
	}
	
	public String categoriaPelicula() {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca nombre categoria de la pelicula. Por ejemplo Comedy, Romantic, Epic... ");
		String categoria = input.nextLine();
		return categoria;
	}	
	
	

	
}
