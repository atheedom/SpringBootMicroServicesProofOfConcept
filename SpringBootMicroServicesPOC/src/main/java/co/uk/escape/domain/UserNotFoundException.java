package co.uk.escape.domain;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 4808136549437221828L;
		
	@Override
	public String getMessage() {
		return "User not found";
	}

}
