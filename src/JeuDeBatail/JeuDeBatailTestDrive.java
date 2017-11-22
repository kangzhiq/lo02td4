package JeuDeBatail;

public class JeuDeBatailTestDrive {
	public static void main(String[] args) {
		PartieDeCartes partie = new PartieDeCartes();

		partie.ajouterJoueur(4);
		// System.out.println(partie.getJoueurs());
		partie.distribuerCartes();
		int i = 0;
		while ((!(partie.estTermine())) && (i < 500)) {
			i++;
			System.out.println(i + " tour");
			partie.jouerUnTour();
		}
		partie.afficherRes();
		// partie.testIterator();

	}
}
