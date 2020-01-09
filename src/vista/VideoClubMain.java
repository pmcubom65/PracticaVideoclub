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
		System.out.println("Elija la opci�n deseada\n\t1. Insertar una pel�cula nueva\n\t2. Modificar el nombre de director de todas las pel�culas de una categor�a introducida por el usuario, por director modificado"
				+ "\n\t3. Borra todos los miembros que lleven m�s de tres meses sin abonar la cuota del videoclub\n\t4. Muestre todas las personas que hayan alquilado una pel�cula introducida por el usuario, en el �ltimo mes");

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
		System.out.println("Opci�n no v�lida");menu();break;
	}
	
	}
	
	
	public static void main(String[] args) {
		VideoClubMain m=new VideoClubMain();
		m.menu();
	}

}
