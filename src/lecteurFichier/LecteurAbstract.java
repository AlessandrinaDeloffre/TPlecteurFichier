package lecteurFichier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public abstract class LecteurAbstract implements LecteurInterface {

	@Override
	public abstract boolean checkType(String filename);
	
	@Override
	public boolean checkFile(String filename) {
		File file = new File(filename);
		try {
			FileInputStream fileInput = new FileInputStream(file);
			fileInput.close();
			return true;
		} catch (IOException e) {
			System.out.println("Le fichier demandé n'existe pas");
			return false;
		}
	}
	
	@Override 
	public void lire(String filename) {
		File file = new File(filename);
		ArrayList<String> lines = getFileLines(file);
		for (String line : lines) {
			System.out.println(line);
		}
		
	}
	
	@Override 
	public void lireReverse(String filename) {
		File file = new File(filename);
		ArrayList<String> lines = getFileLines(file);
		for(int i=(lines.size()-1); i>=0;i--) {
			System.out.println(lines.get(i));
		}
		
	}
	
	@Override 
	public void lirePalindrome(String filename) {
		File file = new File(filename);
		ArrayList<String> lines = getFileLines(file);
		for (String line : lines) {
			System.out.println(line);
			System.out.print(new StringBuilder(line).reverse());
		}
	}
	
	@Override 
	public void compareWith(String filename1, String filename2) {
		File file1 = new File(filename1);
		File file2 = new File(filename2);
		
		ArrayList<String> linesFile1 = getFileLines(file1);
		ArrayList<String> linesFile2 = getFileLines(file2);
		
		for (int i=0; i<linesFile1.size(); i++) {
			if(i<=(linesFile2.size()-1)) {
				if(linesFile1.get(i)!=linesFile2.get(i)) {
					//shows differences between lines
					System.out.println("< "+linesFile1.get(i));
					System.out.println("---------");
					System.out.println("> "+linesFile2.get(i));
				} else {
					//simply prints line when it's the same
					System.out.println(linesFile1.get(i));
				}
			} else {
				//if file1 longer than file2
				System.out.println("<<"+linesFile1.get(i));
			}	
		}
		//if file2 longer than file1
		if(linesFile1.size()<linesFile2.size()) {
			for(int i=linesFile1.size(); i<linesFile2.size(); i++) {
				System.out.println(">>"+linesFile2.get(i));
			}
		}
		
	}
	
	public ArrayList<String> getFileLines(File filename) {
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filename), StandardCharsets.UTF_8));) {
			String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
		} catch(IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
