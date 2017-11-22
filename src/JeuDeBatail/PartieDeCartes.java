package JeuDeBatail;

import java.util.*;

public class PartieDeCartes {
	private ArrayList<Joueur> joueurs;
	private static int tourDeJeu = 0;
	private JeuDeCartes cartes;
	// pour controler le commencement de jeu
	private boolean jeuEnCours;

	// constructeur de la partie
	public PartieDeCartes() {
		joueurs = new ArrayList<Joueur>();
		cartes = new JeuDeCartes();
		cartes.initialiser();
		cartes.melanger();
		tourDeJeu++;
		jeuEnCours = false;
		System.out.println("On a initialise une partie, c'est parti!");
	}

	public void ajouterJoueur(int n) {

		if (jeuEnCours == false) {
			for (int i = 0; i < n; i++) {
				joueurs.add(new Joueur(i));
			}
			System.out.println("On a ajoute " + n + " joueurs");
		} else {
			System.out.println("Vous ne pouvez pas ajouter un joueur car le jeu a deja commence");
		}
	}

	public void retirerJoueur(Joueur j) {
		if (joueurs.contains(j)) {
			joueurs.remove(j);
			System.out.println("On a supprime le joueur " + j.getNom());
		} else {
			System.out.println("Ce joueur n'existe pas");
		}

	}

	// 涉及到重置迭代器iterator的问题
	public void distribuerCartes() {
		jeuEnCours = true;
		Iterator<Joueur> it = joueurs.iterator();
		while (!cartes.estVide()) {
			if (it.hasNext()) {
				Joueur j = it.next();
				Carte c = cartes.getCarte();
				j.recupererCarte(c);
				// test de distribution des cartes
				/*
				 * System.out.println("Carte " +c.toString() + " a " + j.toString());
				 * System.out.println("Nombre " + cartes.getCartes().size());
				 */
			} else {
				it = joueurs.iterator();

			}

		}
		/*
		 * it = joueurs.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next().getTas().toString()); }
		 */
		System.out.println("On a distribue toutes les cartes");

	}
	// test d'Iterator
	/*
	 * public void testIterator() { Iterator<Joueur> it = joueurs.iterator(); int i
	 * = 0; while (i < 10) { while (it.hasNext()) {
	 * System.out.println(it.next().toString()); System.out.println(i); i = i + 1; }
	 * } }
	 */

	public void jouerUnTour() {
		Iterator<Joueur> it = joueurs.iterator();
		// cartes posees dans ce tour
		LinkedList<Carte> cartesPosees = new LinkedList<Carte>();
		// pour recuperer le gagnant de ce tour
		HashMap<Carte, Joueur> coupleEnCour = new HashMap<Carte, Joueur>();
		Carte laPlusGrande = null;
		// commmence un tour
		while (it.hasNext()) {
			Joueur j = it.next();
			Carte c = j.poserCarte();
			if (!(c == null)) {
				System.out.println("Le joueur " + j.getNom() + " a pose " + c.toString() + " Nombre "+ j.getTas().size());
				coupleEnCour.put(c, j);
				if (laPlusGrande == null) {
					laPlusGrande = c;
				} else {
					laPlusGrande = laPlusGrande.comparer(c);
				}
				cartesPosees.add(c);
			}

		}
		// determiner le joueur gagnant
		Joueur gagnant = coupleEnCour.get(laPlusGrande);
		gagnant.recupererCarte(cartesPosees);
		Iterator<Joueur> itV = joueurs.iterator();
		while(itV.hasNext()) {
			Joueur j = itV.next();
			if(j.aPerdu()) {
				joueurs.remove(j);
			}
		}
		System.out.println("Le joueur " + gagnant.getNom() + " a gagne ce tour");
		System.out.println(" ");
		// supprimer eventuellement des joueurs perdants

	}

	public void retirerJoueurPerdant() {
		Iterator<Joueur> it = joueurs.iterator();
		while (it.hasNext()) {
			Joueur j = it.next();
			if (j.aPerdu()) {
				joueurs.remove(j);
			}
		}
	}

	public void retirerJoueurPerdant(Joueur j) {
		joueurs.remove(j);
	}

	public boolean estTermine() {
		Iterator<Joueur> it = joueurs.iterator();
		boolean res = false;
		while (it.hasNext()) {
			Joueur j = it.next();
			if (j.aGagne()) {
				res = true;
			}
		}
		return res;
	}

	public void afficherRes() {
		Iterator<Joueur> it = joueurs.iterator();
		while (it.hasNext()) {
			Joueur j = it.next();
			if (j.aGagne()) {
				System.out.println("Le joueur " + j.getNom() + "a gagne");
			} else {
				System.out.println("Le joueur " + j.getNom() + "a perdu");

			}
		}
	}

	// getter et setter
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

}
