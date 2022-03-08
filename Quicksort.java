import java.util.Arrays;

public class Quicksort {

	public static void quicksort(int[] L, int ini, int fin) {
		if (ini < fin) {
			// x es el pivote

			int x = pivotar(L, ini, fin);
			quicksort(L, ini, x - 1);
			quicksort(L, x + 1, fin);
		}
		System.out.println(Arrays.toString(L));
	}

	private static int pivotar(int[] L, int ini, int fin) {
		// aqui es donde vamos a seleccionar el pivote.
		int i = ini; // guaro la posicion del pivote.
		int p = L[ini];// guardo el valor del pivote.
		for (int j = ini + 1; j <= fin; j++) {
			if (L[j] <= p) {
				i++;
				if (i != j) {
					int aux = L[i];
					L[i] = L[j];
					L[j] = aux;

				}
			}

		}
		// aqui finalizamos cambiando el pivote con la ultima hubicacion de i
		int aux = L[ini];
		L[ini] = L[i];
		L[i] = aux;

		// posicion donde queda el pivote
		int x = i;

		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] L = { 23, 10, 9, 11, 20, 22 };
		quicksort(L, 0, (L.length - 1));
	}

}
