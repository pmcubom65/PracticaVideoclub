package controlador;

import java.util.Scanner;

import dao.JPAEmpleadoDao;
import modelo.Empleado;

public class ControlarDatosUsuario {

	public Empleado recogerDatos() {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca codigo");
		String codigo = input.nextLine();
		System.out.println("Introduzca apellido");
		String apellido = input.nextLine();
		System.out.println("Introduzca oficio");
		String oficio = input.nextLine();
		System.out.println("Introduzca codigo director");
		String codigodir = input.nextLine();
		System.out.println("Introduzca fecha entrada");
		String fechaentrada = input.nextLine();
		System.out.println("Introduzca salario");
		String salario = input.nextLine();
		System.out.println("Introduzca comision");
		String comision = input.nextLine();
		System.out.println("Introduzca depto");
		String dpto = input.nextLine();
		return new Empleado(codigo, apellido.toUpperCase(), oficio.toUpperCase(), codigodir, fechaentrada, salario,
				comision, dpto);
	}

	public String[] recogerString() {
		String[] param = new String[8];
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca codigo");
		String codigo = input.nextLine();
		param[0] = codigo;
		System.out.println("Introduzca apellido");
		String apellido = input.nextLine();
		param[1] = apellido;
		System.out.println("Introduzca oficio");
		String oficio = input.nextLine();
		param[2] = oficio;
		System.out.println("Introduzca codigo director");
		String codigodir = input.nextLine();
		param[3] = codigodir;
		System.out.println("Introduzca fecha entrada");
		String fechaentrada = input.nextLine();
		param[4] = fechaentrada;
		System.out.println("Introduzca salario");
		String salario = input.nextLine();
		param[5] = salario;
		System.out.println("Introduzca comision");
		String comision = input.nextLine();
		param[6] = comision;
		System.out.println("Introduzca depto");
		String dpto = input.nextLine();
		param[7] = dpto;
		return param;
	}

	public Empleado recogerCodigo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca codigo");
		String codigo = input.nextLine();
		return new Empleado(codigo);
	}

	public Empleado saberCodigo(String codigo) {

		return new Empleado(codigo);
	}

	public void menu(int opcion) {
		JPAEmpleadoDao jp = new JPAEmpleadoDao();
		ControlarDatosUsuario cd = new ControlarDatosUsuario();
		switch (opcion) {
		case 1:
			System.out.println(jp.getAll());
			break;
		case 2:
			jp.save(cd.recogerDatos());
			break;
		case 3:
			jp.delete(cd.recogerCodigo());
			break;
		case 4:
			String[] parametros = cd.recogerString();
			jp.update(new Empleado(parametros[0]), parametros);
			break;
		case 5:
			break;
		default:
			System.out.println("no valido");
			break;
		}

	}

}
