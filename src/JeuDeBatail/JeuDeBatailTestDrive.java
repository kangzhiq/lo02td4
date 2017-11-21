package JeuDeBatail;

public class JeuDeBatailTestDrive {
	public static void main(String[] args) {
		PartieDeCartes partie = new PartieDeCartes();
		partie.ajouterJoueur(16);
		//System.out.println(partie.getJoueurs());
		partie.distribuerCartes();
		/*while(!(partie.estTermine())) {
			partie.jouerUnTour();
		}
		partie.afficherRes();*/
		//partie.testIterator();
		
	}
}
