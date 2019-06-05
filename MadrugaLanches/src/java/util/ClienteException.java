package util;

@SuppressWarnings("serial")
public class ClienteException extends Exception {

	public ClienteException() {
		super();
	}

	public ClienteException(String erro) {
		super(erro);
	}
}
