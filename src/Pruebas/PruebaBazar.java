package Pruebas;

import java.io.IOException;
import java.util.ArrayList;
import bazar.Bazar;
import bazar.BazarException;
import bazar.Ropa;
import bazar.Selector;
import bazar.SelectorDescripcion;
import bazar.SelectorPrecio;

public class PruebaBazar {

	public static void main(String[] args) throws IOException, BazarException {
		Bazar b = new Bazar();

		b.anyadir(new Ropa("camisa", 25, 2.2));
		b.anyadir(new Ropa("pantalon", 12, 5.3));
		b.anyadir(new Ropa("falda", 16, 8.4));

		b.anyadir(new Ropa("Camisa", 9, 6.45));
		b.anyadir(new Ropa("Pantalon", 12, 3.25));
		b.anyadir(new Ropa("Falda", 16, 9.35));

		System.out.println(b);	
		System.out.println(b.seleccionar(new SelectorPrecio(2, 8)));
		System.out.println(b.calcSumaCantidad(new SelectorPrecio(2, 8)));
		System.out.println(b.calcSumaCantidad(new SelectorPrecio(100, 200)));
		
		ArrayList<String> r = new ArrayList<>();
		r.add("camisa");
		r.add("pantalon");
		
		System.out.println(b.seleccionar(new SelectorDescripcion(r)));	
		System.out.println(b.calcSumaCantidad(new SelectorDescripcion(r)));
		
		r = new ArrayList<>();
		r.add("xxx");
		
		System.out.println(b.calcSumaCantidad(new SelectorDescripcion(r)));

		b.guardarEnFichero("salida.txt");

		Bazar a = new Bazar();
		a.cargarDeFichero("entrada.txt");
		System.out.println(a);

	}

}
