package clases;

public class Libro {

	//MÉTODOS

	private String titulo;
	private String autor;
	private String isbn;
	private boolean disponible;
	private String respuesta;

	//GETTER Y SETTERS

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getRespuesta() {
		return respuesta;
	} 
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	//CONSTRUCTORES

	Libro(){

	}
	public Libro(String titulo, String autor, String isbn, boolean disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.disponible = disponible;
	}

	//MÉTODOS

	public void mostrarInfo() {
		System.out.println("----------------------------------");
		System.out.println("Título: " + getTitulo());
		System.out.println("Autor: " + getAutor());
		System.out.println("ISBN: " + getIsbn());
		System.out.println("Disponible: " + (isDisponible() ? "Sí" : "No"));
		System.out.println("----------------------------------");
	}
}
