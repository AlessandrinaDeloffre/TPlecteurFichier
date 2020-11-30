package lecteurFichier;

public class TypeHtml extends LecteurAbstract {
	
	@Override
	public boolean checkType(String filename) {
		if(filename.toUpperCase().endsWith(".HTML")) {
			return true;
		} else {
			System.out.println("Impossible de lire ce type de fichier");
			return false;
		}
	}

}
