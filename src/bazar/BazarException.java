package bazar;

public class BazarException extends Exception {

	private static final long serialVersionUID = 1L;

	public BazarException() {
		super();
	}

	public BazarException(String mensaje) {
		super(mensaje);
	}
}
