package lecteurFichier;

public interface LecteurInterface {
	
	boolean checkFile(String filename);
	
	boolean checkType(String filename);
	
	void lire(String filename);
	
	void lireReverse(String filename);
	
	void lirePalindrome(String filename);
	
	void compareWith(String filename1, String filename2);

}
