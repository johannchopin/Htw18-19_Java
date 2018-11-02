package artikel;

import java.util.Scanner;

public class ArtikelDialog {
	private Artikel artikel1;
	private Scanner input = new Scanner(System.in);
	
	private static final int ENDE        = 0;
	private static final int ANLEGEN     = 1;
	private static final int ZUSTAND     = 2;
	private static final int SET_BESTAND = 4;
	private static final int ZUGANG      = 5;
	private static final int ABGANG      = 6;
	
	private int einlesen() {
		System.out.println(ENDE + ": beenden; " +
						 ANLEGEN + ": anlegen; " +
						 ZUSTAND + ": zustand; " +
						 SET_BESTAND + ": bestand einstellen; " + 
						 ZUGANG + ": zugang; " +
						 ABGANG + ": abgang; ");
		return input.nextInt();
	}
	
	private void ausfuehrenFunktion(int wahl) {
		switch(wahl) {
			case ENDE:
				break;
				
			case ANLEGEN:
				break;
				
			case ZUSTAND:
				break;
				
			case SET_BESTAND:
				break;
				
			case ZUGANG:
				break;
				
			case ABGANG:
				break;
		}
	}

	private void start() {
		artikel1 = null;
		int funktion = -1;
		
		while(funktion != ENDE) {
			try {
				funktion = einlesen();
				ausfuehrenFunktion(funktion); 
			} 
			catch (Exception e) {
				System.out.println(e);
				e.printStackTrace(System.out);
			}
		}
	}
	
	public static void main(String[] args) {
		new ArtikelDialog().start();
	}

}
