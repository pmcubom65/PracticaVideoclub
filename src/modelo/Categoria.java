package modelo;

public class Categoria {
	
	private String category_id;
	private String category_name;
	private String remarks;
	
	public Categoria() {}
	
	public Categoria(String category_id, String category_name, String remarks) {
		
		this.category_id = category_id;
		this.category_name = category_name;
		this.remarks = remarks;
	}
	
	
	public Categoria(String category_name, String remarks) {
		
	
		this.category_name = category_name;
		this.remarks = remarks;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Categoria [category_id=" + category_id + ", category_name=" + category_name + ", remarks=" + remarks
				+ "]";
	}
	
	
	

}
