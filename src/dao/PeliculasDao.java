package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelo.Pelicula;
import modelo.Pelicula;

public class PeliculasDao implements Dao<Pelicula> {
	
	
	private List<Pelicula> listapelicula = new ArrayList<>();
	JPAPeliculaDao jp;

	@Override
	public Optional<Pelicula> get(long id) {
		listapelicula .clear();
		listapelicula .addAll(jp.getAll());
		return listapelicula .stream().findAny().filter(i -> (i.getMovie_id().equals(String.valueOf(id))));
	}

	@Override
	public List<Pelicula> getAll() {
		listapelicula .clear();
		listapelicula .addAll(jp.getAll());
		return listapelicula ;
	}

	@Override
	public void save(Pelicula t) {
		listapelicula .add(t);
		jp.save(t);

	}

	@Override
	public void update(Pelicula t, String[] params) {
		// listapelicula .removeIf(i->(i.getEmp_no().equals(t.getEmp_no())));
		jp.update(t, params);
		listapelicula .clear();
		listapelicula .addAll(jp.getAll());

	}

	@Override
	public void delete(Pelicula t) {
		listapelicula .remove(t);
		jp.delete(t);
	}

}
