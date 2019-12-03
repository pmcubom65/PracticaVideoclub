package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BBDD")
public class ConexionBBDD {

	private String url;
	private String usuario;
	private String password;
	private Connection conexion = null;
	public ConexionBBDD() {
	}

	public ConexionBBDD(String url, String usuario, String password) {
		super();
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}

	@XmlElement(name = "conexion")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlElement(name = "usuario")
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@XmlElement(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ConexionBBDD [url=" + url + ", usuario=" + usuario + ", password=" + password + "]";
	}

	public Connection obtenerConexion() throws JAXBException {
		
		JAXBContext jaxbcontext = JAXBContext.newInstance(ConexionBBDD.class);
		Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
		ConexionBBDD conexionbbdd = (ConexionBBDD) unmarshaller.unmarshal(new File("BBDD.xml"));
		String basededatos = conexionbbdd.getUrl();
		String usuario = conexionbbdd.getUsuario();
		String password = conexionbbdd.getPassword();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(basededatos, usuario, password);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexion;
	}

	public void desconectar(Connection conexion) {
		try {
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
