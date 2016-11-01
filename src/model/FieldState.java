package model;

public enum FieldState {
	
	CROSS('x'),
	CIRCLE('o'),
	EMPTY('e');
	
	private char sign;
	
	private FieldState(char sign){
		this.sign = sign;
	}
	
	public char getName(){
		return sign;
	}
}
