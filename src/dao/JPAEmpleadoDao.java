package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;

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
		Empleado emp=null;
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		sql = String.format("SET @p0='%s'; CALL `seleccionarempleado`(@p0);", String.valueOf(id));

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

				emp= new Empleado(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Empleado t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Empleado t) {
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		sql = String.format("SET @p0='%s'; CALL `borrarempleado`(@p0);", t.getEmp_no());

		try {
			java.sql.Statement stm = conectado.createStatement();
			
			int filas=stm.executeUpdate(sql);
			String resultado= (filas>0) ?"Borrado":"No Borrado";
			System.out.println(resultado);
		} catch (SQLException e) {
			
		}
		this.miconexion.desconectar(conectado);

	}

}
