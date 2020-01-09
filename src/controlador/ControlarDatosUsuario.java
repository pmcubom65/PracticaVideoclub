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
		System.out.println("Introduzca año de lanzamiento, formato yyyy, si no será nulo.\n La base de datos tiene tipo dato year(4)"
				+ "\nrange '1901' to '2155'.");
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
			}else {
				salida=y;
			}
		}catch(NumberFormatException nfe){
			salida="";
		}
		return salida;
	}
	
	
	public String tituloPelicula() {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca el titulo de la pelicula");
		String titulo = input.nextLine();
		return titulo;
	}
	
	public String categoriaPelicula() {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca nombre categoria de la pelicula");
		String categoria = input.nextLine();
		return categoria;
	}	
	
	

	
}
