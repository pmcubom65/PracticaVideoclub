package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JPAEmpleadoDao implements Dao<Empleado> {
	ConexionBBDD miconexion;
	String sql;
	ResultSet rs;
	Connection conectado;

	public JPAEmpleadoDao() {
		this.miconexion = new ConexionBBDD();
	}

	@Override
	public Optional<Empleado> get(long id) {
		Empleado emp = null;
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		sql = String.format("CALL `seleccionarempleado`(%s);", String.valueOf(id));

		try {
			java.sql.Statement stm = conectado.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				String emp_no = rs.getString(1);
				String apellido = rs.getString(2);
				String oficio = rs.getString(3);
				String dir = rs.getString(4);
				String fecha_alt = rs.getString(5);
				String salario = rs.getString(6);
				String comision = rs.getString(7);
				String dept_no = rs.getString(8);

				emp = new Empleado(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no);
				System.out.println(emp);
			}
		} catch (SQLException e) {

		}
		this.miconexion.desconectar(conectado);

		Optional<Empleado> full = Optional.ofNullable(emp);
		return full;

	}

	@Override
	public List<Empleado> getAll() {
		List<Empleado> lista = new ArrayList<>();

		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		sql = "CALL `listar`()";

		try {
			java.sql.Statement stm = conectado.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				String emp_no = rs.getString(1);
				String apellido = rs.getString(2);
				String oficio = rs.getString(3);
				String dir = rs.getString(4);
				String fecha_alt = rs.getString(5);
				String salario = rs.getString(6);
				String comision = rs.getString(7);
				String dept_no = rs.getString(8);

				lista.add(new Empleado(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no));
			}
		} catch (SQLException e) {

		}
		this.miconexion.desconectar(conectado);

		return lista;
	}

	@Override
	public void save(Empleado t) {
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}
		sql = "CALL `insertarempleado`(?, ?, ?, ?, ?, ?, ?, ?);";
		int filas = 0;
		try {
			java.sql.PreparedStatement sentencia = conectado.prepareStatement(sql);
			sentencia.setString(1, t.getEmp_no());
			sentencia.setString(2, t.getApellido().toUpperCase());
			sentencia.setString(3, t.getOficio().toUpperCase());
			sentencia.setString(4, t.getDir());
			sentencia.setString(5, t.getFecha_alt());
			sentencia.setString(6, t.getSalario());
			sentencia.setString(7, t.getComision());
			sentencia.setString(8, t.getDept_no());

			filas = sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String resultado = (filas > 0) ? "Insertado" : "No Insertado";
		System.out.println(resultado);

		this.miconexion.desconectar(conectado);

	}

	@Override
	public void update(Empleado t, String[] params) {
		String emp_no = null;
		String apellido = null;
		String oficio = null;
		String dir = null;
		String fecha_alt = null;
		String salario = null;
		String comision = null;
		String dept_no = null;
		int referencia = 0;
		int i = 0;
		try {
			for (i = 0; i < params.length; i++) {
				emp_no = params[0];
				apellido = params[1];
				oficio = params[2];
				dir = params[3];
				fecha_alt = params[4];
				salario = params[5];
				comision = params[6];
				dept_no = params[7];
			}

			try {
				conectado = this.miconexion.obtenerConexion();
			} catch (JAXBException e) {

				e.printStackTrace();
			}

			// sql = "update emple set emp_no=?, apellido=?, oficio=?, dir=?,
			// fecha_alt=?, salario=?, comision=?, dept_no=? where emp_no=? ";

			sql = "CALL `actualizarempleado`(?, ?, ?, ?, ?, ?, ?, ?)";

			int filas = 0;
			try {
				java.sql.PreparedStatement sentencia = conectado.prepareStatement(sql);
				sentencia.setString(1, emp_no);
				sentencia.setString(2, apellido.toUpperCase());
				sentencia.setString(3, oficio.toUpperCase());
				sentencia.setString(4, dir);
				sentencia.setString(5, fecha_alt);
				sentencia.setString(6, salario);
				sentencia.setString(7, comision);
				sentencia.setString(8, dept_no);
			//	sentencia.setString(9, t.getEmp_no());
				filas = sentencia.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			String resultado = (filas > 0) ? "Actualizado" : "No Actualizado";
			System.out.println(resultado);

			this.miconexion.desconectar(conectado);
		} catch (ArrayIndexOutOfBoundsException npe) {
			System.out.println("faltan parámetros");
		}
	}

	@Override
	public void delete(Empleado t) {
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		sql = String.format("CALL `borrarempleado`(%s);", t.getEmp_no());

		try {
			java.sql.Statement stm = conectado.createStatement();

			int filas = stm.executeUpdate(sql);
			String resultado = (filas > 0) ? "Borrado" : "No Borrado";
			System.out.println(resultado);
		} catch (SQLException e) {

		}
		this.miconexion.desconectar(conectado);

	}

}
