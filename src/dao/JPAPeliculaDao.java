package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Statement;

import modelo.Pelicula;

public class JPAPeliculaDao implements Dao<Pelicula> {

	ConexionBBDD miconexion;
	String sql;
	ResultSet rs;
	Connection conectado;

	public JPAPeliculaDao() {
		this.miconexion = new ConexionBBDD();
	}

	@Override
	public void save(Pelicula t) {
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}
		int filas = 0;

		sql = "DROP PROCEDURE IF EXISTS insertar_pelicula";

		try {
			java.sql.Statement st = conectado.createStatement();
			st.execute(sql);
			sql = "CREATE PROCEDURE `insertar_pelicula`(IN `v_title` VARCHAR(300), IN `v_director` VARCHAR(150), IN `v_year_released` YEAR(4), IN `v_category_id` INT(11)) NOT DETERMINISTIC NO SQL SQL SECURITY DEFINER insert into movies (title, director, year_released, category_id) values (v_title, v_director, v_year_released, v_category_id)";
			st.execute(sql);
			java.sql.CallableStatement cStmt = conectado.prepareCall("{call insertar_pelicula(?, ?,?,?)}");

			if (t.getTitle().isEmpty()) {
				cStmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
				cStmt.setString(1, t.getTitle());
			}
			if (t.getDirector().isEmpty()) {
				cStmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
				cStmt.setString(2, t.getDirector());
			}

			int anho = 0;
			int micat = 0;
			try {
				anho = Integer.parseInt(t.getYear_released());

				cStmt.setInt(3, anho);
			} catch (NumberFormatException nfe) {
				cStmt.setNull(3, java.sql.Types.TINYINT);
			}

			try {
				micat = Integer.parseInt(t.getCategory_id());
				if (micat > 8 || micat < 1) {
					cStmt.setNull(4, micat);
				} else {
					cStmt.setInt(4, micat);
				}

			} catch (NumberFormatException nfe) {
				cStmt.setNull(4, micat);
			}

			cStmt.execute();

			filas = cStmt.getUpdateCount();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String resultado = (filas > 0) ? "Insertado" : "No Insertado";
		System.out.println(resultado);

		this.miconexion.desconectar(conectado);

	}

	@Override
	public void update(String s) {

		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		sql = "DROP PROCEDURE if exists `modificar_director` ";
		int filas = 0;

		try {
			java.sql.Statement st = conectado.createStatement();
			st.execute(sql);
			if (s.isEmpty()) {
				sql = "CREATE PROCEDURE `modificar_director`(IN `v_category_name` VARCHAR(150)) NOT DETERMINISTIC NO SQL SQL SECURITY DEFINER update movies set director='director modificado' where category_id is null;";
			} else {
				sql = "CREATE PROCEDURE `modificar_director`(IN `v_category_name` VARCHAR(150)) NOT DETERMINISTIC NO SQL SQL SECURITY DEFINER update movies set director='director modificado' where category_id=(select category_id from categories where category_name=v_category_name);";
			}

			st.execute(sql);
			java.sql.CallableStatement sentencia = conectado.prepareCall("{call modificar_director(?)}");
			sentencia.setString(1, s);

			sentencia.execute();
			filas = sentencia.getUpdateCount();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String resultado = (filas > 0) ? "Actualizado" : "No Actualizado";
		System.out.println(resultado);

		this.miconexion.desconectar(conectado);

	}

}
