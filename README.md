# K-Homework-3
Will Curry, GIT ID: CWill22
Ethan Darling, GIT ID: edar115
Alasdair Orr, GIT ID: 49ersMcAfree
Braeden Penrod, GIT ID: oRackzyy

The objective of this project is to develop an inventory management system tailored for a media product emporium using Java. This involves creating class structures to represent different types of media products, along with implementing a singleton class for the store's inventory operations.

The project consists of several Java classes. A MediaProduct class represents a base class for media products with attributes such as title, price, year, and genre. The subclasses of MediaProduct are VinylRecordProduct, CDRecordProduct, and TapeRecordProduct, which are used for different types of media products. The Genre class is an enum representing the genres of media products. The StockManagerSingleton class is responsible for managing the shop's inventory, with methods for initializing the stock from a CSV file, updating item prices, adding and removing items from inventory, saving the inventory back to the CSV file, and retrieving lists of media products based on certain criteria. The Main class is used to run the program and demonstrate the functionality of the inventory management system.

To run the program, make sure you clone the repository to your computer. Navigate to the project directory and compile the files. Then, simply run the Main class to start the program.

There are no external dependencies for this project.
