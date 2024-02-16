package invmanage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StockManagerSingleton {

	//private static StockManagerSingleton instance = null;
	//initialize inventory
	public StockManagerSingleton() {
		this.inventory = new ArrayList<MediaProduct>();
	}
	
	private final String inventoryFilePath = "./files/inventory.csv";
	public ArrayList<MediaProduct> inventory;
	
	public boolean initializeStock() {
		try {
			
		    // Read the Data from the csv file "inventory.csv" line by line
			
		
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			
			if (fileIn.hasNext()) {
				fileIn.nextLine(); // Skip the first line, which is the header
			}
			else {
				// If the file is empty, return false
				//close file
				fileIn.close();
                return false;
            }
			
			while(fileIn.hasNextLine())  {
				System.out.println("In while loop");
				// Split the line into an array of strings
				String line=fileIn.nextLine();
				String[] splitLine = line.split(",");
				
				// Convert the strings to the appropriate data types
				String type = splitLine[0];
				System.out.println(type);
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
					
					
                }
                else if(type.equals("Vinyl")) {
                    //create a Vinyl object
                	VinylRecordProduct vinyl = new VinylRecordProduct(title, price, year, genre);
                	ec= addItem(vinyl);
                	
                }
                else if(type.equals("Tape")) {
                    //create a Tape object
                	TapeRecordProduct tape = new TapeRecordProduct(title, price, year, genre);
                	ec= addItem(tape);
					
                }
                if(ec == false) {
			//close file
			fileIn.close();
                    return false;
                }
			}//endwhile
				//close file
				fileIn.close();
			
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
		return this.inventory.add(product);
    }

    public boolean removeItem(MediaProduct product){
	    if (product == null) {
        	return false;
	    }
		return this.inventory.remove(product);
    }
    public boolean saveStock() {
    	BufferedWriter writer = null;
		try  {
			writer = new BufferedWriter(new FileWriter(inventoryFilePath));
			writer.write("Type,Title,Price,Year,Genre\n");
			ArrayList<VinylRecordProduct> vinylList = getVinylRecordList(inventory);
			if(vinylList.isEmpty())
			{
				System.out.println("File is Empty");
			}
			for (VinylRecordProduct product : vinylList) {
				System.out.println("In Vinyl write loop");
				writer.write(String.format("%s,%s,%.2f,%d,%s\n", "Vinyl",
						product.getTitle(), product.getPrice(), product.getYear(), product.getGenre().toString()));
			}
			ArrayList<CDRecordProduct> cdList = getCDRecordsList(inventory);
			for (CDRecordProduct product : cdList) {
				writer.write(String.format("%s,%s,%.2f,%d,%s\n", "CD", product.getTitle(), product.getPrice(),
						product.getYear(), product.getGenre().toString()));
			}
			ArrayList<TapeRecordProduct> tapeList = getTapeRecordList(inventory);
			for (TapeRecordProduct product : tapeList) {
				writer.write(String.format("%s,%s,%.2f,%d,%s\n", "Tape", product.getTitle(), product.getPrice(),
						product.getYear(), product.getGenre().toString()));
			}
			writer.close();	
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
		VinylRecordProduct product1;
		for (MediaProduct product : productList) {
			
			// Check if the product is a VinylRecordProduct
			try {
				System.out.println("In try block");
			    product1=(VinylRecordProduct)product;
                vinylList.add((VinylRecordProduct) product);
            }
            catch(Exception e) {
                
            }
		}
		return vinylList;
    }
    public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList) {
    	        ArrayList<CDRecordProduct> cdList = new ArrayList<CDRecordProduct>();
    	        CDRecordProduct product2;
				for (MediaProduct product : productList) {
					
					try{
						product2=(CDRecordProduct)product;
						cdList.add((CDRecordProduct) product);
					}
					catch(Exception e){
                        
                    }
					
				}
				return cdList;
    }
    public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
    	        ArrayList<TapeRecordProduct> tapeList = new ArrayList<TapeRecordProduct>();
    	        TapeRecordProduct product3;
    	        for (MediaProduct product : productList) {
					try {
						product3 = (TapeRecordProduct) product;
						tapeList.add((TapeRecordProduct) product);
					} catch (Exception e) {

					}

				}
				return tapeList;
    }

}