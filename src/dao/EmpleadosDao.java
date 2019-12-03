package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadosDao implements Dao<Empleado> {

	 private List<Empleado> listaempleados = new ArrayList<>();
	 JPAEmpleadoDao jp;
	public EmpleadosDao() {
	//	listaempleados.add(new Empleado("8555","Lopez","Empleado","7902","2003-01-08","1000", null, "20"));
		
		jp=new JPAEmpleadoDao();
	}
	
	@Override
	public Optional<Empleado> get(long id) {
		listaempleados.clear();
		listaempleados.addAll(jp.getAll());
		return listaempleados.stream().findAny().filter(i->(i.getEmp_no().equals(String.valueOf(id))));
	}

	@Override
	public List<Empleado> getAll() {
		listaempleados.clear();
		listaempleados.addAll(jp.getAll());
		return listaempleados;
	}

	@Override
	public void save(Empleado t) {
		listaempleados.add(t);
		jp.save(t);
		
	}

	@Override
	public void update(Empleado t, String[] params) {
	//	listaempleados.removeIf(i->(i.getEmp_no().equals(t.getEmp_no())));
		jp.update(t, params);
		listaempleados.clear();
		listaempleados.addAll(jp.getAll());
		
	}

	@Override
	public void delete(Empleado t) {
		listaempleados.remove(t);
		jp.delete(t);
	}

}
