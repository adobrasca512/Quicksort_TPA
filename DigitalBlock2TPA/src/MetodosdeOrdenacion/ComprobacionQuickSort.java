package MetodosdeOrdenacion;

import java.util.Arrays;

public class ComprobacionQuickSort {
	//QUICKSORT NORMAL
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static int pivot(double lista[], int inicio, int fin) {
		int i = inicio - 1;
		int j = fin - 1;
		double valor =  lista[inicio - 1];
		// Vamos a vaciar la posicion del pivote
		lista[inicio - 1] = 0;
		System.out.println("Lista inicial: " + Arrays.toString(lista));
		while (i != j) {


			if (lista[j] != 0) {
				System.out.println("\nEs :" + lista[j] + " mayor que: " + valor + " ?");
				if (lista[j] > valor) {
					System.out.print("Es mayor, por lo tanto ");
					System.out.println("cambiando posicion al lado izquierdo " + (i) + " por " + j);
					// Cambiando al lado izquierdo
					intercambiar(lista, j, i);
					System.out.println("Validando en j, Se cambiaron los valores a: " + Arrays.toString(lista));
					i++;
				}

				else {
					j--;
				}
			}

			if (j != i) {
				if (lista[i] != 0) {
					System.out.println("\nEs :" + lista[i] + " menor que: " + valor + " ?");
					if (lista[i] <= valor) {
						System.out.print("Es menor, por lo tanto ");
						System.out.println("cambiando posicion al lado derecho " + (i) + " por " + j);
						// Cambiando al lado derecho
						intercambiar(lista, i, j);
						System.out.println("Validando en i, Se cambiaron los valores a: " + Arrays.toString(lista));
						j--;
					}

					else {
						i++;
					}

				}

			}

		}
		System.out.println("J quedo en la posicion " + j);
		// Vemos como quedo la lista despues del bucle
		System.out.println(
				"Lista final 01: " + Arrays.toString(lista));
		// En el espacio que quedo vacio incluyo el valor pivote
		lista[j] = valor;
		// Comprobamos que se ordeno correctamente el pivote.
		System.out.println(
				"Lista final 02: " + Arrays.toString(lista) );
		return j;
	}

	public static void quickSort(double lista[], int inicio, int fin) {


		if ((fin) > inicio) {

			int x = pivot(lista, inicio, fin);

			System.out
			.println("\n\n QUICKSORT RECURSIVO: Evaluo lista desde la posicion " + (inicio) + " hasta " + (x));
			quickSort(lista, inicio, x);
			System.out.println(
					"\n\n QUICKSORT RECURSIVO 2: Evaluo lista desde la posicion " + (x + 2) + " hasta " + (fin));
			quickSort(lista, x + 2, fin);
			System.out.println("LISTA TERMINADA: "+Arrays.toString(lista));

		}

	}
	//QUICKSORT BIS
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static int pivotBis(int lista[], int inicio, int fin, int posiciones[]) {
		int valor = lista[inicio];
		// Estos valores solo cambian si el fin o el inicio cambio
		posiciones[0] = inicio;
		posiciones[1] = fin;

		System.out.println("Lista inicial: " + Arrays.toString(lista));

		int aux = 0;
		while (posiciones[0] != (posiciones[1] - aux)) {

			// Comparamos el ultimo con el primero
			System.out.println("\nEs :" + lista[posiciones[1]] + " menor o igual que: " + valor + " ?");
			if (lista[posiciones[1]] < valor) {
				System.out.print("Es menor, por lo tanto ");
				System.out.println("cambiando posicion al lado izquierdo " + (posiciones[0]) + " por " + posiciones[1]);
				// Movemos valores y Actualizo la posicion del pivote
				posiciones[0] = moverValores(lista, posiciones[1], posiciones[0]);
				System.out.println("Validando en posiciones[1]<, Se cambiaron los valores a: " + Arrays.toString(lista));

			}
			//Verificamos en el caso de que sean iguales 
			else if (lista[posiciones[1]] == valor) {

				System.out.print("Es igual, por lo tanto " );
				System.out.println("Intercambiando posicion " + posiciones[1] + " con posicion " + (posiciones[0] + 1));
				intercambiar(lista, posiciones[1], posiciones[0] + 1);
				System.out.println("Validando en posiciones[1]=, Se cambiaron los valores a: " + Arrays.toString(lista));
				// Me incluyo un valor para decirle adonde parar el bucle
				// Esto es un acumulador, si encontramos uno igual disminuimos el tiempo que
				// tendra el bucle.
				aux = aux + 1;


			} else {
				System.out.println("Default: No es menor ni tampoco igual\n");
				posiciones[1]--;
			}

		}
		// Aqui compruebo de que estamos privandonos los valores pivote.
		System.out.println("POSICION[0] quedo en la posicion " + posiciones[0]);
		System.out.println("POSICION[1] quedo en la posicion " + posiciones[1]);
		// Vemos como quedo la lista despues del bucle
		System.out.println(
				"Lista final 01: " + Arrays.toString(lista) );
		// En el espacio que quedo vacio incluyo el valor pivote
		// lista[j] = valor;
		// Comprobamos que se ordeno correctamente el pivote.
		System.out.println(
				"Lista final 02: " + Arrays.toString(lista) );
		return posiciones[0];
	}

	public static void quickSortBis(int lista[], int inicio, int fin) {
		int[] arrposiciones = { inicio, fin };
		if ((fin) > inicio) {
		
			int x = pivotBis(lista, inicio, fin, arrposiciones);

			System.out.println(
					"\n\n QUICKSORT RECURSIVO: Evaluo lista desde la posicion " + (inicio) + " hasta " + (x - 1));
			quickSortBis(lista, inicio, x - 1);
			System.out.println(
					"\n\n QUICKSORT RECURSIVO 2: Evaluo lista desde la posicion " + (x + 1) + " hasta " + (fin));
			quickSortBis(lista, x + 1, fin);
			System.out.println("LISTA TERMINADA: "+Arrays.toString(lista));

		}
	}
	//FUNCIONES AUXILIARES
	//Estaba viendo y creo que si hay que tener dos funciones diferenciadas de intercambiar...una por int y otra por double...aunque no entendi muy bien a lo que se referia
	//con lo de las librerias :(
	//La otra opcion que veo es pregutar en el codigo si el valor de lista es un double .hasNextDouble y despues definimos que nos devuelva una lista 
	//y lo casteamos a lo que quisieras..supongo.

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void intercambiar(double[] list, int a, int b) {
		int value = (int) list[a];
		list[a] = list[b];

		list[b] = value;
		System.out.println("Cambiando: " + list[a] + " por " + list[b]);
	}
	public static void intercambiar(int[] list, int a, int b) {
		int value = list[a];
		list[a] = list[b];

		list[b] = value;
		System.out.println("Cambiando: " + list[a] + " por " + list[b]);
	}

	public static int moverValores(int[] list, int a, int b) {

		if (a == (b)) {

			// Le devuelvo a o b ya que son iguales
			return b;
		} else {

			intercambiar(list, a, a - 1);

			System.out.println(Arrays.toString(list));

			moverValores(list, a - 1, b);
			//Devuelvo la posicion nueva que tiene el pivote
			return b + 1;

		}
	}

	public static void main(String[] args) {

		double list[] = { 5, 3, 5, 7, 6, 2, 9, 8, 1,10 };
		int list1[] = { 4, 2, 8, 4, 3, 1, 6, 7 };

		//NOTA IMPORTANTE, NO INTRODUCIR 0, DAÑA MI PROGRAMA :0 
		//Explicacion en el documento pdf.
		//NOTA2 Me imprimi las respuestas de cada cosa para que se entienda como funciona cada cosita y que yo misma no me enrede.
		
		System.out.println("* * * * * * * * * * * * Ejecutando Quicksort * * * * * * * * * * * *");
		quickSort(list, 1, 10);
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("\n* * * * * * * * * * * * Ejecutando BISQuicksort * * * * * * * * * * * *");
		quickSortBis(list1, 0, list1.length-1);
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
	}

}
