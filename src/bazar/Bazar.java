package bazar;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringJoiner;

public class Bazar {

	private ArrayList<Ropa> datos;

	public Bazar() {
		datos = new ArrayList<>();
	}

	public void anyadir(Ropa r) throws BazarException {
		if (indice(r) != -1) {
			int cantidad = datos.get(indice(r)).getCantidad();
			r.setCantidad(cantidad);
			datos.set(indice(r), r);

		} else {
			datos.add(r);
		}
	}

	private int indice(Ropa r) {
		for (int i = 0; i < datos.size(); i++) {
			if (r.equals(datos.get(i)))
				return i;
		}

		return -1;
	}

	public ArrayList<Ropa> seleccionar(Selector s) {
		ArrayList<Ropa> seleccion = new ArrayList<>();

		for (Ropa r : datos) {
			if (s.esSeleccionable(r))
				seleccion.add(r);
		}

		return seleccion;
	}

	public int calcSumaCantidad(Selector s) {
		ArrayList<Ropa> seleccion = seleccionar(s);

		int suma = 0;

		for (Ropa r : seleccion) {
			suma += r.getCantidad();
		}

		return suma;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(";", "[", "]");

		for (Ropa r : datos) {
			sj.add(r.toString());
		}

		return sj.toString();
	}

	public void cargarDeFichero(String nomFich) throws IOException, NumberFormatException, BazarException {
		Path entrada = Path.of(nomFich);

		Scanner sc = new Scanner(entrada);

		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			procesarLinea(linea);
		}

		sc.close();

	}

	private void procesarLinea(String linea) throws BazarException {
		Scanner sc = new Scanner(linea);

		sc.useDelimiter("\\s*[;]\\s*");
		sc.useLocale(Locale.ENGLISH);

		anyadir(new Ropa(sc.next(), sc.nextInt(), sc.nextDouble()));

		sc.close();
	}

	public void guardarEnFichero(String nomFich) throws IOException {
		PrintWriter pw = new PrintWriter(nomFich);

		for (Ropa r : datos) {
			pw.print(r.getDescripcion() + "; " + r.getCantidad() + "; " + r.getPrecio() + "\n");
		}

		pw.close();
	}

}
