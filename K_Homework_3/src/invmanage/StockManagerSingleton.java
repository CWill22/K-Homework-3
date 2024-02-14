package invmanage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class StockManagerSingleton {
		
	public boolean initializeStock() {
		try {
			
		    // Read the Data from the csv file "inventory.csv" line by line
			final String inventoryFilePath = "inventory.csv";
		
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			
			if (fileIn.hasNext()) {
				fileIn.nextLine(); // Skip the first line, which is the header
			}
			else {
				// If the file is empty, return false
                return false;
            }
			for(fileIn.hasNextLine()){
				// Split the line into an array of strings
				String line=fileIn.nextLine();
				splitLine = line.split(",");
				
				// Convert the strings to the appropriate data types
				String type = splitLine[0];
				String title = splitLine[1];
				double price = Double.parseDouble(splitLine[2]);
				int year = Integer.parseInt(splitLine[3]);
				Genre genre = Genre.valueOf(splitLine[4]);
				
			// Create a new object of the appropriate type
				if(type.equals("CD")) {
					//create a CD object
					CDRecordProduct cd = new CDRecordProduct(title, price, year, genre);
					
                }
                else if(type.equals("Vinyl")) {
                    //create a Vinyl object
                	VinylRecordProduct vinyl = new VinylRecordProduct(title, price, year, genre);
                }
                else if(type.equals("Tape")) {
                    //create a Tape object
                	TapeProductProduct tape = new TapeProduct(title, price, year, genre);
                }
                else {
                    return false;
                }
                
             
			}
				}catch(FileNotFoundException e)
			{
				e.printStackTrace();
				return false;
			}
		    return true;
	}
	
    public boolean updateItemPrice(MediaProduct product, double newPrice) {
     if (product == null || newPrice < 0) {
        return false;
    }
   	 product.setPrice(newPrice);
	    return true;
    }

    public boolean addItem(MediaProduct product){
	return inventory.add(new MediaProduct(product));
    }

    public boolean removeItem(MediaProduct product){
	return inventory.remove(new MediaProduct(product));
    }
    public boolean saveStock()
    public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
        ArrayList<MediaProduct> products = new ArrayList<MediaProduct>();
        for (MediaProduct product : inventory){
           if (product.getPrice() < maxPrice){
                products.add(product);
        }
	    
    }
    return products;
    }
    public void printListOfMediaProduct(ArrayList<MediaProduct>productList)
    public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList)
    public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList)
    public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList)

}
