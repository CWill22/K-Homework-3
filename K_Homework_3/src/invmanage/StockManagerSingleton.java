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
    public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice)
    public void printListOfMediaProduct(ArrayList<MediaProduct>productList)
    public ArrayList<VinylRecordProduct>
    getVinylRecordList(ArrayList<MediaProduct> productList)
    public ArrayList<CDRecordProduct>
    getCDRecordsList(ArrayList<MediaProduct> productList)
    public ArrayList<TapeRecordProduct>
    getTapeRecordList(ArrayList<MediaProduct> productList)

}
