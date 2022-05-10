package bazar;

public class SelectorPrecio implements Selector {

	private int minimo;
	private int maximo;

	public SelectorPrecio(int min, int max) throws BazarException {
		if (max < min)
			throw new BazarException("ERROR: El valor minimo " + min + " es mayor que el maximo " + max);

		minimo = min;
		maximo = max;
	}

	@Override
	public boolean esSeleccionable(Ropa r) {
		if (r.getPrecio() >= minimo && r.getPrecio() < maximo)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "S[" + minimo + ", " + maximo + "]";
	}

}
