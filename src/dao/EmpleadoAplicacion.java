package dao;

public class EmpleadoAplicacion {

	
	 private static Dao EmpleadoDao;
	
	
	public static void main(String[] args) {
		EmpleadoDao=new EmpleadoDao();
		EmpleadoDao.getAll().forEach(i->System.out.println(i));
		
		
	}

}
