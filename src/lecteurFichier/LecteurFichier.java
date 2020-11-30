package lecteurFichier;

import java.util.Scanner;

public class LecteurFichier {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\nIndiquez le nom du fichier que souhaitez ouvrir, avec son extension");
		String filename = scanner.nextLine();

			LecteurAbstract lecteur = null;
			String file = null;
		
		if(filename.toUpperCase().endsWith(".TXT")) {
			lecteur = new TypeTexte();
		} else if(filename.toUpperCase().endsWith(".HTML")) {
			lecteur = new TypeTexte();
		} else {
			System.out.println("Impossible de lire ce type de fichier");
		}

		if(lecteur!=null) {
			file = getFile(lecteur, filename);
		}
		if(file!=null) {
			System.out.println("Que souhaitez vous faire ?\n(1) Lire ce fichier\n(2) Lire ce fichier à l'envers\n(3) Lire ce fichier de manière palindromique\n(4) Comparer ce fichier avec un autre");
			//nextLine waits for user input
			String userChoice = scanner.nextLine();
	 
			switch(userChoice) {
				case "1" :
					lecteur.lire(file);
					break;
				case "2" :
				
					lecteur.lireReverse(file);
					break;
				case "3" : 
					lecteur.lirePalindrome(file);
					break;
				case "4" :
					//Scanner scanner2 = new Scanner(System.in);
					System.out.println("\nIndiquez le nom du fichier que souhaitez comparer, avec son extension");
					var filename2 = scanner.nextLine();
					String file2 = getFile(lecteur, filename2);
					lecteur.compareWith(file, file2);
					break;
			}
			
		
		}

	}
	
	static String getFile(LecteurAbstract lecteur, String file) {
		if (lecteur.checkFile(file)) {
			return file;
		} else {
			return null;
		}
		
	}

}
