package vista;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import controlador.ControlarDatosUsuario;
import dao.Dao;
import dao.JPAEmpleadoDao;
import modelo.Empleado;

public class EmpleadoAplicacion {

	private static Dao EmpleadoDao;

	public void pruebas() {
		JPAEmpleadoDao jp = new JPAEmpleadoDao();
		Empleado t = new Empleado("4442", "Lopez", "gerente", "7902", "2003-01-08", "1000", "0", "20");
		// String[]
		// valores={"4442","Lopez","Empleado","7902","2003-01-08","1000",
		// null,"20" };
		// jp.update(t, valores);

		System.out.println(jp.getAll());
		// System.out.println(jp.get(8888));
		// jp.save(new
		// Empleado("8556","Lopez","Empleado","7902","2003-01-08","1000", null,
		// "20"));

		// Empleado e=new
		// Empleado("8556","Lopez","Empleado","7902","2003-01-08","1000", null,
		// "20");
		// jp.delete(e);
	}

	public static void main(String[] args) {
		int salida=0;
		Scanner sc=new Scanner(System.in);
		ControlarDatosUsuario cd= new ControlarDatosUsuario();
		do {
		
		System.out.println("Elija la opción deseada:\n\t1. Mostrar todos los empleados y todos los departamentos\n\t2."
				+ " Insertar\n\t3. Borrar\n\t4. Actualizar\n\t5. Salir");
		salida=sc.nextInt();
		cd.menu(salida);
		}while (salida!=5);
		System.out.println("Fin");
	//	JPAEmpleadoDao jp = new JPAEmpleadoDao();
	//	System.out.println(jp.getAll());
	}

}
