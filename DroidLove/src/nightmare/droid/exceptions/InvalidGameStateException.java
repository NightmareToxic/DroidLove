package nightmare.droid.exceptions;

public class InvalidGameStateException extends Exception{

	private static final long serialVersionUID = -6239313122996922851L;
	private String invalid;
	
	public InvalidGameStateException(String gameState){
		this.invalid = gameState;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Attempt to load invalid game state: [" + invalid + "]";
	}
	
	
}
