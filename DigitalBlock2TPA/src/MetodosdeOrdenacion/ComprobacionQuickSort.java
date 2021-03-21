package MetodosdeOrdenacion;

import java.util.Arrays;

public class ComprobacionQuickSort {
	public static int pivot(int lista[], int inicio, int fin) {
		int i = inicio;
		int j = fin;
		int valor = lista[inicio];
		// Vamos a vaciar la posicion del pivote
		lista[inicio] = 0;
		System.out.println("Lista inicial: " + Arrays.toString(lista));
		while (i != j) {
			System.out.println("Es :" + lista[j] + " mayor que: " + valor + " ?");

			if (lista[j] != 0) {
				if (lista[j] > valor) {
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
					System.out.println("Es :" + lista[i] + " menor que: " + valor + " ?");
					if (lista[i] < valor) {
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
				"Lista final 01: " + Arrays.toString(lista) + "Valor de inicio " + lista[inicio] + " valor de i " + i);
		// En el espacio que quedo vacio incluyo el valor pivote
		lista[j] = valor;
		// Comprobamos que se ordeno correctamente el pivote.
		System.out.println(
				"Lista final 01: " + Arrays.toString(lista) + "Valor de inicio " + lista[inicio] + " valor de i " + i);
		return j;
	}

	public static void quickSort(int lista[], int inicio, int fin) {

		System.out.println("Es " + (inicio) + " menor que " + fin);
		if ((fin) > inicio) {
			System.out.println("Si es menor, ejecutando quicksort");
			int x = pivot(lista, inicio, fin);

			System.out.println(
					"\n\n QUICKSORT RECURSIVO: Evaluo lista desde la posicion " + (inicio) + " hasta " + (x - 1));
			quickSort(lista, inicio, x - 1);
			System.out.println(
					"\n\n QUICKSORT RECURSIVO 2: Evaluo lista desde la posicion " + (x + 1) + " hasta " + (fin));
			quickSort(lista, x + 1, fin);
			
		} 
	}

	public static void intercambiar(int[] list, int a, int b) {
		int value = list[a];
		list[a] = list[b];

		list[b] = value;
		System.out.println("Cambiando: " + list[a] + " por " + list[b]);
	}

	public static void main(String[] args) {

		int list[] = { 5, 3, 5, 7, 6, 2, 9, 8, 1 };

		quickSort(list, 0, 8);

	}

}
