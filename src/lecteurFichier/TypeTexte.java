package lecteurFichier;

public class TypeTexte extends LecteurAbstract {

	@Override
	public boolean checkType(String filename) {
		if(filename.toUpperCase().endsWith(".TXT")) {
			return true;
		} else {
			System.out.println("Impossible de lire ce type de fichier");
			return false;
		}
	}

}
