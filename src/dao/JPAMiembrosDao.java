package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import com.mysql.jdbc.PreparedStatement;

import modelo.Miembro;
import modelo.Pelicula;

public class JPAMiembrosDao implements Dao<Miembro> {

	ConexionBBDD miconexion;
	String sql;
	ResultSet rs;
	Connection conectado;

	public JPAMiembrosDao() {
		this.miconexion = new ConexionBBDD();
	}




	@Override
	public List<Miembro> getAll(String s) {
	
		List<Miembro> lista = new ArrayList<>();

		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}
		sql="DROP PROCEDURE `mostrar_miembros_rental`"; 
		boolean consulta=false;
	
		try {
			java.sql.Statement stm = conectado.createStatement();
			stm.execute(sql);
			sql="CREATE PROCEDURE `mostrar_miembros_rental`(IN `v_title` VARCHAR(150)) NOT DETERMINISTIC NO SQL SQL SECURITY DEFINER SELECT m.membership_number, m.full_names, m.contact_number, m.date_of_birth, m.email, m.gender, m.physical_address, m.postal_address FROM members m, movies mo, movierentals r where m.membership_number=r.membership_number and mo.movie_id=r.movie_id and mo.title=v_title and transaction_date between subdate(curdate(), interval 1 month) and curdate() ";
			stm.execute(sql);
			sql =String.format("CALL `mostrar_miembros_rental`('%s')",s);
			
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				Miembro m=new Miembro();
				m.setMembership_number(String.valueOf(rs.getInt(1)));
				m.setFull_names(rs.getString(2));
				m.setContact_number(rs.getString(3));
				m.setDate_of_birth(rs.getDate(4).toString());
				m.setEmail(rs.getString(5));
				m.setGender(rs.getString(6));
				m.setPhysical_address(rs.getString(7));
				m.setPostal_address(rs.getString(8));
				
				lista.add(m);
			}
			
			
		}catch (SQLException e) {
			
		}
			System.out.println(lista.toString());
		return lista;
	            
	}



	@Override
	public void delete() {
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}
		sql = "DROP PROCEDURE `deletemiembros`";

	//	boolean consulta = false;
		int filas=0;
		try {
			java.sql.Statement stm = conectado.createStatement();
			stm.execute(sql);
			sql="CREATE  PROCEDURE `deletemiembros`() NOT DETERMINISTIC CONTAINS SQL SQL SECURITY DEFINER begin SET FOREIGN_KEY_CHECKS=0; delete from members where membership_number IN (select membership_number from payments where payment_date not between subdate(curdate(), interval 3 month) and curdate()); SET FOREIGN_KEY_CHECKS=1; end";
			
			stm.execute(sql);
			java.sql.CallableStatement sentencia = conectado.prepareCall("{call deletemiembros()}");

			filas = sentencia.executeUpdate();

		
			System.out.println("Borrado procesado");
		} catch (SQLException e) {

		}
		this.miconexion.desconectar(conectado);

	}

}
