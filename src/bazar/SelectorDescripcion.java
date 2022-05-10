package bazar;

import java.util.ArrayList;
import java.util.StringJoiner;

public class SelectorDescripcion implements Selector {

	private ArrayList<String> descripciones;

	public SelectorDescripcion(ArrayList<String> d) throws BazarException {
		if (d == null)
			throw new BazarException("ERROR: El parametro de entrada es nulo");

		descripciones = d;
	}

	@Override
	public boolean esSeleccionable(Ropa r) {

		boolean seleccionable = false;

		for (String s : descripciones) {
			if (r.getDescripcion().equalsIgnoreCase(s))
				seleccionable = true;
		}

		return seleccionable;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",", "S[", "]");

		for (String s : descripciones)
			sj.add(s);

		return sj.toString();
	}
}
