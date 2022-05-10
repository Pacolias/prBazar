package bazar;

public class Ropa {

	private String descripcion;
	private int cantidad;
	private double precio;

	public Ropa(String d, int c, double p) throws BazarException {
		if (d == null || d.isEmpty() || c < 0 || p < 0)
			throw new BazarException("ERROR: Parametros de entrada incorrectos");

		descripcion = d;
		cantidad = c;
		precio = p;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setCantidad(int c) throws BazarException {
		if (c < 0)
			throw new BazarException("ERROR: Cantidad negativa: " + c);

		cantidad = c;
	}

	@Override
	public String toString() {
		return "(" + descripcion + ", " + cantidad + ", " + precio + ")";
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Ropa) {
			Ropa r = (Ropa) o;
			res = this.descripcion.equalsIgnoreCase(r.descripcion);
		}

		return res;
	}

	@Override
	public int hashCode() {
		return descripcion.toUpperCase().hashCode();
	}
}
