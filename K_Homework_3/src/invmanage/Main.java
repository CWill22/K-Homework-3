package invmanage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a new StockManagerSingleton instance
		StockManagerSingleton stockManager = new StockManagerSingleton();
	    
		stockManager.initializeStock();
	    // Add a new VinylRecordProduct to the stock
		        stockManager.addItem(new VinylRecordProduct("The Dark Side of the Moon", 29.99, 1973, Genre.ROCK));
		      

	}

	
}
