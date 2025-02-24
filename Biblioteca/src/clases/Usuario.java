package clases;

import java.util.ArrayList;

public class Usuario {

	//MÉTODOS

	private String nombre;
	private int id;
	private ArrayList<Libro> librosPrestados = new ArrayList<Libro>();

	//GETTERS Y SETTERS

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}
	public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	//CONSTRUCTORES

	Usuario(){
	}
	public Usuario(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
		this.librosPrestados = new ArrayList<>();
	}

	//MÉTODOS

	public void mostrarDetalles() {
		System.out.println("----------------------------------");
		System.out.println("Nombre Usuario: " + getNombre());
		System.out.println("ID: " + getId());
		System.out.println("Libros prestados:");
		for(Libro libro : librosPrestados) {
			libro.mostrarInfo();

		}
		System.out.println("----------------------------------");
	}
	public void prestarLibro(Libro libro) {
		librosPrestados.add(libro);
	}

	public void devolverLibro(Libro libro) {
		librosPrestados.remove(libro);
	}


}
