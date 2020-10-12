import java.util.Scanner;

/*Realizar un programa en Java como se indica a continuación:

	X Crear una clase llamada Pelicula con atributos: titulo de la pelicula y genero de la pelicula.
	Agregar una interfaz llamada RentaPeliculas que contenga las operaciones basicas de una estructura tipo PILA, implementado con las operaciones de la renta de peliculas.
	Crear una clase llamada ImplementacionPilaEstatica, la cual implementara la interfaz anterior, aplicado un vector bidimensional para la estructura de pila.
	Crear una clase llamada ImplementacionPilaDinamica, la cual implementara la interfaz anterior, aplicado la clase STACK de Java para la estructura de pila.
	Agregar un menu para el usuario que permita mostrar lo siguiente:
	Cargar BD de peliculas.
	Rentar pelicula.
	Devolver pelicula.
	Mostrar cantidad de peliculas disponibles para renta.
*/
class Pelicula{
	private String titulo;
	private String genero;
	
	public Pelicula(String titulo, String genero) {
		super();
		this.titulo = titulo;
		this.genero = genero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + "]";
	}
	
	
}
interface RentaPeliculas{
	public boolean insetarPeliculaRentada(Pelicula peli);
	public boolean eliminarPeliculaRectada();
	
	boolean verificarPilaLlena();
	boolean verficarPilaVacia();
	
	public Pelicula mostrarCima();
}
class ImplementacionPilaEstatica implements RentaPeliculas{

	@Override
	public boolean insetarPeliculaRentada(Pelicula peli) {
		
		return false;
	}

	@Override
	public boolean eliminarPeliculaRectada() {
		
		return false;
	}

	@Override
	public boolean verificarPilaLlena() {
		
		return false;
	}

	@Override
	public boolean verficarPilaVacia() {
		
		return false;
	}

	@Override
	public Pelicula mostrarCima() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
public class Prueba {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		String op;
		System.out.println("Elige la opcion que desees");
		System.out.println("1-Cargar BD peliculas");
		System.out.println("2- Rentar Pelicula");
		System.out.println("3- Devolver pelicula");
		System.out.println("4- Cantidad de peliculas disponibles para la renta");
		System.out.println("5- Salir");
		op=entrada.nextLine();
		switch (op) {
		case "1":
			
			break;
		case "2":
			
			break;
		case "3":
			
			break;
		case "4":
	
	break;
		case "5":
	
	break;
		default:
			System.out.println("Error la opcion que seleccionaste no existe.");
			break;
		}//switch
		
	}//Main

}
