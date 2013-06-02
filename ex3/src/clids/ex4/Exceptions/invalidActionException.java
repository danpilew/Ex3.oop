package clids.ex4.Exceptions;

public class invalidActionException extends Exception {

		private static final long serialVersionUID = 1L;

		public invalidActionException() {
			super("the action is legal only inside method");
		}

		
	}
