package invmanage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StockManagerSingleton {

	public ArrayList<MediaProduct> inventory;
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
				fileIn.close(); // Close the fileIn resource
				return false;
			}
			fileIn.close(); // Close the fileIn resource
			
			while(fileIn.hasNextLine())  {
				// Split the line into an array of strings
				String line=fileIn.nextLine();
				String[] splitLine = line.split(",");
				
				// Convert the strings to the appropriate data types
				String type = splitLine[0];
				String title = splitLine[1];
				double price = Double.parseDouble(splitLine[2]);
				int year = Integer.parseInt(splitLine[3]);
				Genre genre = Genre.valueOf(splitLine[4]);
				
				boolean ec = false;
			// Create a new object of the appropriate type
				if(type.equals("CD")) {
					//create a CD object
					CDRecordProduct cd = new CDRecordProduct(title, price, year, genre);
					ec= addItem(cd);
					if(ec==false) {
						return false;
					}
					
                }
                else if(type.equals("Vinyl")) {
                    //create a Vinyl object
                	VinylRecordProduct vinyl = new VinylRecordProduct(title, price, year, genre);
                	ec= addItem(vinyl);
                	if(ec==false) {
                		return false;
                	}
                }
                else if(type.equals("Tape")) {
                    //create a Tape object
                	TapeRecordProduct tape = new TapeRecordProduct(title, price, year, genre);
                	ec= addItem(tape);
					if (ec == false) {
						return false;
					}
                }
                else {
                    return false;
                }
			}//endfor
			
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
	    if (product == null) {
        return false;
	    }
		return this.inventory.add(new MediaProduct(product));
    }

    public boolean removeItem(MediaProduct product){
	    if (product == null) {
        return false;
	    }
		return this.inventory.remove(new MediaProduct(product));
    }
    public boolean saveStock() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"))) {
			writer.write("Type,Title,Price,Year,Genre\n");
			for (MediaProduct product : inventory) {
				writer.write(String.format("%s,%s,%.2f,%d,%s,\n", product.getClass().getSimpleName(), product.getTitle(), product.getPrice(), product.getYear(), product.getGenre().toString()));
			} 
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    }
    public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
        ArrayList<MediaProduct> products = new ArrayList<MediaProduct>();
        for (MediaProduct product : inventory){
           if (product.getPrice() < maxPrice) {
                products.add(product);
        	}
	
    	}
   	 	return products;
    }
    public void printListOfMediaProduct(ArrayList<MediaProduct>productList) {
    	        for (MediaProduct product : productList) {
    	        	        	            System.out.println(product);
    	        }
    }
    public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
		ArrayList<VinylRecordProduct> vinylList = new ArrayList<VinylRecordProduct>();
		for (MediaProduct product : productList) {
			if (product instanceof VinylRecordProduct) {
				vinylList.add((VinylRecordProduct) product);
			}
		}
		return vinylList;
    }
    public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList) {
    	        ArrayList<CDRecordProduct> cdList = new ArrayList<CDRecordProduct>();
				for (MediaProduct product : productList) {
					if (product instanceof CDRecordProduct) {
						cdList.add((CDRecordProduct) product);
					}
				}
				return cdList;
    }
    public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
    	        ArrayList<TapeRecordProduct> tapeList = new ArrayList<TapeRecordProduct>();
    	        for (MediaProduct product : productList) {
    	        	if (product instanceof TapeRecordProduct) {
    	        		tapeList.add((TapeRecordProduct) product);
					}
    	         }
    	                        return tapeList;
    }

}
