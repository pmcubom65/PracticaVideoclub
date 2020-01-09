package modelo;

public class Pelicula {
	
	private String movie_id;
	private String title;
	private String year_released;
	private String director;
	private String category_id;
	
	public Pelicula() {}

	public Pelicula(String title, String year_released, String director, String category_id) {
		
		
		this.title = title;
		this.year_released = year_released;
		this.director = director;
		this.category_id = category_id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear_released() {
		return year_released;
	}

	public void setYear_released(String year_released) {
		this.year_released = year_released;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Pelicula [movie_id=" + movie_id + ", title=" + title + ", year_released=" + year_released
				+ ", director=" + director + ", category_id=" + category_id + "]";
	}
	

}
