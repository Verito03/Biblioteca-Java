package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ATRIBUTOS
		Scanner sc = new Scanner(System.in);
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		int opc;

		//PROGRAMA

		do {
			System.out.println("--- BIENVENID@ ---");
			System.out.println("1) Agregar Libro \n2) Registrar Usuario \n3) Prestar Libro \n4) Devolver Libro \n5) Lista Libros Disponibles \n6) Lista Usuarios \n7) Salir");
			opc = sc.nextInt();

			switch(opc) {
			case 1:
				agregarLibro(libros);
				break;
			case 2:
				registrarUsuario(usuarios);
				break;
			case 3:
				prestarLibro(libros, usuarios);
				break;
			case 4:
				devolverlibro(libros, usuarios);
				break;
			case 5:
				listaLibros(libros);
				break;
			case 6:
				listaUsuarios(usuarios);
				break;
			case 7:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Introduce un valor válido");
			}
		}while(opc != 7);
	}

	//MÉTODOS

	public static void agregarLibro(ArrayList<Libro> libros) {
		Libro libro = new Libro();
		Scanner sc = new Scanner(System.in);

		System.out.println("Título del libro: ");
		libro.setTitulo(sc.nextLine());
		System.out.println("Autor del libro: ");
		libro.setAutor(sc.nextLine());
		System.out.println("ISBN del libro: ");
		libro.setIsbn(sc.nextLine());
		libro.setDisponible(true);

		libros.add(libro);
		System.out.println("Se ha añadido el libro correctamente");
	}

	public static void registrarUsuario(ArrayList<Usuario> usuarios) {
		Scanner sc = new Scanner(System.in);
		Usuario usuario = new Usuario();

		System.out.println("Nombre del usuario: ");
		usuario.setNombre(sc.nextLine());
		System.out.println("ID del usuario: ");
		usuario.setId(sc.nextInt());

		usuarios.add(usuario);
		System.out.println("Se ha añadido el usuario correctamente");
	}

	public static void prestarLibro(ArrayList<Libro> libros, ArrayList<Usuario> usuarios) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Título del libro: ");
		String tituloPrestar = sc.nextLine();

		System.out.println("ID del Usuario: ");
		int idUsuario = sc.nextInt();

		Libro libroPrestado = null;

		for(Libro libro : libros) {
			if(tituloPrestar.equalsIgnoreCase(libro.getTitulo())) {
				libro.setDisponible(false);
				libroPrestado = libro; //GUARDA EL LIBRO PRESTADO
				break; // SALE DEL BUCLE AL ENCONTRAR EL LIBRO
			}
		}
		if(libroPrestado != null) {
			for(Usuario usuario : usuarios) {
				if(idUsuario == usuario.getId()) {
					usuario.prestarLibro(libroPrestado);
					System.out.println("Se ha prestado el libro correctamente");
					break;
				}
			}

		} else {
			System.out.println("No existe el libro buscado");
		}

	}

	public static void listaUsuarios(ArrayList<Usuario> usuarios) {
		System.out.println("Usuarios registrados: ");
		for(Usuario usuario : usuarios) {
			usuario.mostrarDetalles();
		}
	}

	public static void listaLibros(ArrayList<Libro> libros) {
		System.out.println("Libros de la biblioteca: ");
		for(Libro libro : libros) {
			libro.mostrarInfo();
		}
	}
	
	public static void devolverlibro(ArrayList<Libro> libros, ArrayList<Usuario> usuarios) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Título del libro: ");
		String tituloDevolver = sc.nextLine();

		System.out.println("ID del Usuario: ");
		int idUsuario = sc.nextInt();

		Libro libroDevuelto = null;

		for(Libro libro : libros) {
			if(tituloDevolver.equalsIgnoreCase(libro.getTitulo())) {
				libro.setDisponible(true);
				libroDevuelto = libro; //GUARDA EL LIBRO DEVUELTO
				break; // SALE DEL BUCLE AL ENCONTRAR EL LIBRO
			}
		}
		if(libroDevuelto != null) {
			for(Usuario usuario : usuarios) {
				if(idUsuario == usuario.getId()) {
					usuario.devolverLibro(libroDevuelto);
					System.out.println("Se ha devuelto el libro correctamente");
					break;
				}
			}

		} else {
			System.out.println("No existe el libro buscado");
		}
	}
}

