package developmentalVersion;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileReaderTest {

	
	private static void readInventoryFile() {
		
		File inputFile = new File("inventory.csv");
		FileReader inputFR = null;
		BufferedReader inputBR = null;
		String itemID; //  Holds Item ID input
		Scanner aScanner; 
		String invLine;
		boolean foundItem = false; 
		
		String searchItem = "16";
		try {
			inputFR = new FileReader(inputFile); //init FR
			inputBR = new BufferedReader(inputFR); // init BR
			
			System.out.println("Searching for item, " + searchItem);
			
			invLine = inputBR.readLine(); // read next line from file
			
			whileloop:while(invLine != null) {
				
				aScanner = new Scanner(invLine).useDelimiter("\\s*,\\s*"); // Delineate the line of text into 1 comma csv and ignore white spaces. only grabbing the first value
				itemID = aScanner.next();
				if(itemID.equals(searchItem)) {
					System.out.println("Item " + searchItem + " was FOUND!");
					foundItem = true;
					break whileloop;
				}
				else {
					invLine = inputBR.readLine(); // if item wasnt found we skip to the next line, ensuring we only evaluate the item number and not the the rest of the item description.
				}
	
			} // end while
			if(!foundItem) System.out.println(searchItem + " Was not found");
			
		} // end try
		catch(FileNotFoundException fileNotFoundException) {
			JOptionPane.showMessageDialog(null, "Error File not found","Nile Dot Com - Error", JOptionPane.ERROR_MESSAGE);
		} // end catch file not found
		catch(IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error: Problem reading from File", "Nile Dot Com - Error", JOptionPane.ERROR_MESSAGE);
		}// end catch io exception

	} // end readInventoryFile method
	
	public static void main(String [] args) { 
		readInventoryFile();
	}
}
