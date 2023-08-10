
public class ValorNoEsNumeroException extends RuntimeException{
	 private String valorNoNumerico;

	    public ValorNoEsNumeroException(String valorNoNumerico) {
	        this.valorNoNumerico = valorNoNumerico;
	    }

	    @Override
	    public String getMessage() {
	        return "El valor '" + valorNoNumerico + "' no es un numero valido.";
	    }
}
