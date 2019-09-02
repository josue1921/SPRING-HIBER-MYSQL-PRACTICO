package practicas;

class Libros {
	private String titulo;
	private String autor;
	private int anio;
	
	Libros(String t, String a, int d){
		titulo = t;
		autor = a;
		anio = d;
	}
	
	void mostrar() {
		System.out.println(titulo);
		System.out.println(autor);
		System.out.println(anio);
	}
}