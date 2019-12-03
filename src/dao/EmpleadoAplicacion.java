package dao;

import javax.xml.bind.JAXBException;

public class EmpleadoAplicacion {

	
	 private static Dao EmpleadoDao;
	
	
	public static void main(String[] args) {
		JPAEmpleadoDao jp=new JPAEmpleadoDao();
		Empleado t=new Empleado("4442","Lopez","gerente","7902","2003-01-08","1000", "0", "20");
		String[] valores={"4442","Lopez","Empleado","7902","2003-01-08","1000", null,"20" };
		jp.update(t, valores);
		
		System.out.println(jp.getAll());
	//	System.out.println(jp.get(8888));
	//	jp.save(new Empleado("8556","Lopez","Empleado","7902","2003-01-08","1000", null, "20"));
		
	//	Empleado e=new Empleado("8556","Lopez","Empleado","7902","2003-01-08","1000", null, "20");
	//jp.delete(e);
	}

}
