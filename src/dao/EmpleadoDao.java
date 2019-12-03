package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDao implements Dao<Empleado> {

	 private List<Empleado> listaempleados = new ArrayList<>();
	
	public EmpleadoDao() {
		listaempleados.add(new Empleado("8555","Lopez","Empleado","7902","2003-01-08","1000", null, "20"));
	}
	
	@Override
	public Optional<Empleado> get(long id) {
		return Optional.ofNullable(listaempleados.get((int) id));
	}

	@Override
	public List<Empleado> getAll() {
		return listaempleados;
	}

	@Override
	public void save(Empleado t) {
		listaempleados.add(t);
		
	}

	@Override
	public void update(Empleado t, String[] params) {
		listaempleados.add(t);
		
	}

	@Override
	public void delete(Empleado t) {
		listaempleados.remove(t);
		
	}

}
