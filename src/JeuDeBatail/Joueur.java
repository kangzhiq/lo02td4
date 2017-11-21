package JeuDeBatail;

import java.util.*;

public class Joueur {
	private String nom;
	private LinkedList<Carte> tas = new LinkedList<Carte>();

	public Joueur() {
	};

	public Joueur(int i) {
		this.setNom("Joueur" + i);
	}

	public void recupererCarte(LinkedList<Carte> cartes) {
		tas.addAll(cartes);
	}

	public void recupererCarte(Carte a) {
		tas.add(a);
	}

	public Carte poserCarte() {
		Carte a;
		if (!tas.isEmpty()) {
			a = tas.pop();
		} else {
			a = null;
		}
		return a;
	}

	public boolean aGagne() {
		boolean res = false;
		if (tas.size() == Carte.VALEURS.length * Carte.COULEURS.length) {
			res = true;
		}
		return res;
	}

	public boolean aPerdu() {
		return tas.isEmpty();
	}

	// getter et setter
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Joueur ");
		sb.append(this.getNom());
		return sb.toString();
	}
	public LinkedList<Carte> getTas(){
		return tas;
	}

}
