package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import modelo.Miembro;
import modelo.Miembro;

public class MiembrosDao implements Dao<Miembro> {

	private List<Miembro> listamiembros = new ArrayList<>();
	JPAMiembrosDao jp;

	public MiembrosDao() {
	
		jp = new JPAMiembrosDao();
	}
	
	@Override
	public Optional<Miembro> get(long id) {
		listamiembros .clear();
		listamiembros .addAll(jp.getAll());
		return listamiembros .stream().findAny().filter(i -> (i.getMembership_number().equals(String.valueOf(id))));
	}

	@Override
	public List<Miembro> getAll() {
		listamiembros .clear();
		listamiembros .addAll(jp.getAll());
		return listamiembros ;
	}

	@Override
	public void save(Miembro t) {
		listamiembros .add(t);
		jp.save(t);

	}

	@Override
	public void update(Miembro t, String[] params) {
		// listamiembros .removeIf(i->(i.getEmp_no().equals(t.getEmp_no())));
		jp.update(t, params);
		listamiembros .clear();
		listamiembros .addAll(jp.getAll());

	}

	@Override
	public void delete(Miembro t) {
		listamiembros .remove(t);
		jp.delete(t);
	}

}
