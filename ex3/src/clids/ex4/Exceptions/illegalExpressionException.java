package clids.ex4.Exceptions;

public class illegalExpressionException extends CompilingException {
	private static final long serialVersionUID = 1L;

	public illegalExpressionException(int line) {
		super(line, "illegal expression");
	}

}
