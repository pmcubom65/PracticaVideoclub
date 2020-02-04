package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Statement;

import modelo.Categoria;
import modelo.Pelicula;

public class JPACategoriaDao implements Dao<Categoria> {

	ConexionBBDD miconexion;
	String sql;
	ResultSet rs;
	Connection conectado;

	public JPACategoriaDao() {
		this.miconexion = new ConexionBBDD();
	}

	@Override
	public void save(Categoria t) {
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}
		int filas = 0;

		
		
		try {
			sql="call insertandomiscategorias(?,?)";
			java.sql.PreparedStatement ps=conectado.prepareStatement(sql);
			ps.setString(1, t.getCategory_name());;
			ps.setString(2, t.getRemarks());
			filas=ps.executeUpdate();
		
			
					
		} catch (SQLException e) {
			System.out.println("Error de conexion");
		}

	
		String resultado = (filas>0) ? "Insertado" : "No Insertado";
		System.out.println(resultado);

		this.miconexion.desconectar(conectado);

	}
	
	
	
	public Optional<Categoria> get(long id) {
		String category_id="";
		String category_name="";
		String remarks="";
		
		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}
		String sql="call damelacategoria (?);";

		try {
			java.sql.PreparedStatement ps=conectado.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				category_id=String.valueOf(rs.getInt(1));
				category_name=rs.getString(2);
				remarks=rs.getString(3);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Categoria c=new Categoria(category_id,category_name , remarks);
		Optional<Categoria> op=Optional.of(c);
		
		return op;
		
	}

	
	
	
	
	@Override
	public List<Categoria> getAll() {
		List<Categoria> lista = new ArrayList<>();

		try {
			conectado = this.miconexion.obtenerConexion();
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		sql = "CALL `listarmiscategorias`()";

		try {
			java.sql.Statement stm = conectado.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				String categoria_id = String.valueOf(rs.getInt(1));
				String categoria_name = rs.getString(2);
				String categoria_remarks = rs.getString(3);
			
		

				lista.add(new Categoria(categoria_id, categoria_name, categoria_remarks));
			}
		} catch (SQLException e) {

		}
		this.miconexion.desconectar(conectado);

		return lista;
	}
	
	
	public static void main(String[] args) {
		JPACategoriaDao midao=new JPACategoriaDao();
		
	//	Categoria mc=new Categoria("Terrorificos", "para mayoressss");
		
		
		System.out.println(midao.get(1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
