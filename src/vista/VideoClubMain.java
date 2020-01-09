package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.ControlarDatosUsuario;
import dao.JPAMiembrosDao;
import dao.JPAPeliculaDao;

public class VideoClubMain {
	
	public void menu() {
		int opcion=0;
		JPAPeliculaDao jp = new JPAPeliculaDao();
		JPAMiembrosDao jpm=new JPAMiembrosDao();
		ControlarDatosUsuario control=new ControlarDatosUsuario();
		System.out.println("Elija la opción deseada\n\t1. Insertar una película nueva\n\t2. Modificar el nombre de director de todas las películas de una categoría introducida por el usuario, por director modificado"
				+ "\n\t3. Borra todos los miembros que lleven más de tres meses sin abonar la cuota del videoclub\n\t4. Muestre todas las personas que hayan alquilado una película introducida por el usuario, en el último mes");

	Scanner sc=new Scanner(System.in);
	try {
	opcion=sc.nextInt();
	}catch (InputMismatchException e) {
		opcion=0;
	}
	
	switch(opcion) {
	case 1: 
		
		jp.save(control.recogerDatos()); menu(); break;
		
	case 2: 
		jp.update(control.categoriaPelicula());menu();break;
		
	case 3:
		jpm.delete();menu();break;
	
	case 4:
		jpm.getAll(control.tituloPelicula()).forEach(i->System.out.println(i));
		menu();
		break;
	default:
		System.out.println("Opción no válida");menu();break;
	}
	
	}
	
	
	public static void main(String[] args) {
		VideoClubMain m=new VideoClubMain();
		m.menu();
	}

}
