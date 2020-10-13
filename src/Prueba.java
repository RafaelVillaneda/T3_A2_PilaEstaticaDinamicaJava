import java.util.Scanner;
import java.util.Stack;

/*Realizar un programa en Java como se indica a continuación:

	X Crear una clase llamada Pelicula con atributos: titulo de la pelicula y genero de la pelicula.
	XAgregar una interfaz llamada RentaPeliculas que contenga las operaciones basicas de una estructura tipo PILA, implementado con las operaciones de la renta de peliculas.
	 XCrear una clase llamada ImplementacionPilaEstatica, la cual implementara la interfaz anterior, aplicado un vector bidimensional para la estructura de pila.
	 Crear una clase llamada ImplementacionPilaDinamica, la cual implementara la interfaz anterior, aplicado la clase STACK de Java para la estructura de pila.
	 Agregar un menu para el usuario que permita mostrar lo siguiente:
	X Cargar BD de peliculas.
	X Rentar pelicula.
	X Devolver pelicula.
	X Mostrar cantidad de peliculas disponibles para renta.
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
	boolean insetarPeliculaRentada(Pelicula peli);
	public boolean eliminarPeliculaRectada();
	
	public boolean verificarPilaLlena();
	public boolean verficarPilaVacia();
	
	public void mostrarCima();
}
class ImplementacionPilaEstatica implements RentaPeliculas{
	private Pelicula pilaPelis[];
	private int cima;
	public ImplementacionPilaEstatica() {
		pilaPelis=new Pelicula[3];
		cima=-1;
	}
	@Override
	public boolean insetarPeliculaRentada(Pelicula peli) {
		if(verificarPilaLlena()) {
			return false;
		}else {
			cima++;
			pilaPelis[cima]=peli;
			return true;
		}
		
	}
	@Override
	public boolean eliminarPeliculaRectada() {
		if(verficarPilaVacia()==false) {
			pilaPelis[cima]=null;
			cima--;
			return true;
		}else {
			return false;
		}

	}
	@Override
	public boolean verificarPilaLlena() {
		if(cima==pilaPelis.length-1) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public boolean verficarPilaVacia() {
		if(cima==-1) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void mostrarCima() {
		if(verficarPilaVacia()==false) {
			System.out.println(pilaPelis[cima]);
		}else {
			System.out.println("La pil esta vacia");
		}
		
	}
	

}
class ImplementacionPilaDinamica implements RentaPeliculas{
	private Stack<Pelicula> pilaPelis=new Stack<Pelicula>();
	private int cima;
	public ImplementacionPilaDinamica() {
		this.cima =-1;
	}
	@Override
	public boolean insetarPeliculaRentada(Pelicula peli) {
			pilaPelis.push(peli);
			cima++;
			return true;
		}
	@Override
	public boolean eliminarPeliculaRectada() {
		if(cima>=0) {
		pilaPelis.pop();
		cima--;
		return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean verificarPilaLlena() {
		return false;
	}
	@Override
	public boolean verficarPilaVacia() {
		return pilaPelis.isEmpty();
	}
	@Override
	public void mostrarCima() {
		System.out.println(pilaPelis.peek());
	}
	
}
public class Prueba {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		byte opcionPelicula=0;
		System.out.println("En mi programa me plantie que un cliente no puede tener mas de 3 peliculas rentadas al mismo tiempo");
		int pocipeli=0;
		Pelicula[] pila=new Pelicula[5];
		String op;
		ImplementacionPilaEstatica pilaE=new ImplementacionPilaEstatica();
		ImplementacionPilaDinamica pilaDi=new ImplementacionPilaDinamica();
		do {
		System.out.println("Elige la opcion que desees");
		System.out.println("1-Cargar BD peliculas");
		System.out.println("2- Rentar Pelicula");
		System.out.println("3- Devolver pelicula");
		System.out.println("4- Cantidad de peliculas disponibles para la renta");
		System.out.println("5- Salir");
		op=entrada.nextLine();
		switch (op) {
		case "1":
				pila[0]=new Pelicula("Coraline y la puerta secreta","Fantasia");
				pila[1]=new Pelicula("El orgen de los guardines","Fantasia");
				pila[2]=new Pelicula("Promare","Ciencia Ficcion");
				pila[3]=new Pelicula("El gato con botas","Ciencia ficcion");
				pila[4]=new Pelicula("Star Wars: Los últimos Jedi","Ciencia ficcion");
				System.out.println("Se cargo la BD de peliculas");
			break;
		case "2":
			System.out.println("En donde quieres guardar A-> PILA ESTATICA B-> PILA DINAMICA");
			String op2=entrada.nextLine();
			if(pila[0]!=null) {
				if(op2.equalsIgnoreCase("A")) {
					System.out.println("Que pelicula deseas rentar");
					for(int i=0;i<pila.length;i++) {
						System.out.println((i+1)+"-->"+pila[i]);
					}
					op2=entrada.nextLine();
					try {
						System.out.println(pilaE.insetarPeliculaRentada(pila[Integer.parseInt(op2)-1])? "Listo se a rentado la pelicula":"Oh vaya ya no puedes rentar mas peliculas");
						pocipeli++;
					}catch(NumberFormatException e) {
						System.out.println("Oh vaya no ingresaste un numero");
					}
				}else if(op2.equalsIgnoreCase("B")) {
					for(int i=0;i<pila.length;i++) {
						System.out.println((i+1)+"-->"+pila[i]);
					}
					op2=entrada.nextLine();
					try {
						System.out.println(pilaDi.insetarPeliculaRentada(pila[Integer.parseInt(op2)-1])? "Listo se a rentado la pelicula":"Oh vaya ya no puedes rentar mas peliculas");
						pocipeli++;
					}catch(NumberFormatException e) {
						System.out.println("Oh vaya no ingresaste un numero");
					}
				}//B
			}else {
				System.out.println("No se an cargado pelicuas");
			}
			break;
		case "3":
			System.out.println("En donde quieres eliminar A-> PILA ESTATICA B-> PILA DINAMICA");
			String opOp3=entrada.nextLine();
			if(pila[0]!=null) {
				if(opOp3.equalsIgnoreCase("A")) {
					System.out.println(pilaE.eliminarPeliculaRectada()? "Listo se a devuelto la pelicula":"Oh vaya ya no puedes devolver mas peliculas");
					pocipeli--;
				}else if(opOp3.equalsIgnoreCase("B")) {
					System.out.println(pilaDi.eliminarPeliculaRectada()? "Listo se a devuelto la pelicula":"Oh vaya ya no puedes devolver mas peliculas");
					pocipeli--;
				}
			}else {
				System.out.println("No se an cargado pelicuas");
			}
			break;
		case "4":
				System.out.println("La catidad de peliculas disponibles para rentar es de:"+(5-pocipeli));
	break;
		case "5":
	
	break;
		default:
			System.out.println("Error la opcion que seleccionaste no existe.");
			break;
		}//switch
		}while(!op.equals("5"));
	}//Main
}
