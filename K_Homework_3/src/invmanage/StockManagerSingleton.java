package invmanage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StockManagerSingleton {
		
	public boolean initializeStock() {
		try {
			
		    // Read the Data from the csv file "inventory.csv" line by line
			final String inventoryFilePath = "inventory.csv";
		
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			
			
			}catch(FileNotFoundException e)
			{
				e.printStackTrace();
				return false;
			}
		    return true;
	}
}
