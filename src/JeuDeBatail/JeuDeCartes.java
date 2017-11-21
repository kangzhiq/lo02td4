package JeuDeBatail;

import java.util.*;

public class JeuDeCartes {
	private LinkedList<Carte> jeu = new LinkedList<Carte>();
	private static final int NOMBRE_CARTE = Carte.VALEURS.length * Carte.COULEURS.length;
    

	
	//Initialiser le jeu de carte
	public void initialiser() {
		for (int type = 0; type < 4; type++) {
			for (int valeur = 0; valeur < 8; valeur++) {
				jeu.add(new Carte(valeur, type));
			}
		}
	}
	
	//melange le jeu de carte
	public void melanger() {
		for(int i=0; i < NOMBRE_CARTE ; i++ ) {
			int position = (int) ((NOMBRE_CARTE-1) * Math.random());
			Carte a = jeu.pop();
			jeu.add(position, a);
		}
	}
	
	
	public boolean estVide() {
		return jeu.isEmpty();
	}
	
	public String toString() {
		return jeu.toString();
	}
	
	public Carte getCarte() {
		Carte a = jeu.pop();
		return a;
	}


}
