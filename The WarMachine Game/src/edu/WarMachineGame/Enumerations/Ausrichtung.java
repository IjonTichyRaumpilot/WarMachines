package edu.WarMachineGame.Enumerations;

public enum Ausrichtung {
	KEINE(0),XPLUS(1),XMINUS(-1),YPLUS(2),YMINUS(-2);
	
	private final int richtung;
	
	private Ausrichtung(int richtung) {
		this.richtung = richtung;
	}
}
