import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/*
  * Class:           Main
   * Author:  Muhammed-Sharif Adepetu
  * Date:     december 12, 2022
  *
   * Purpose: to create and control nodes
   * 
   * 
   * 
   * Methods:
   * initialize: makes the chain 
   * createChain(): makes an array of the chain with genericNodes
   * fillChain(): fills an array with specific nodes
   * 
   * displayNodes():  shows the nodes created
   * 
   * rawMaterials(): this changes all 
   * produce: produces materials
   * setInventorySize(int size): sets the inventory size of all nodes  
   *
   *
   * 
  */      


public class simulationControler {

	private int cycles = 91;
	chainCreator file = new chainCreator();
	private int tablePrice = 90;
	private int totalSales = 0;
	private int revenue = 0;
	private int rateOfConsumption = 5;
	private String output = "";
	
	private GenericNode[] chain;

	public void initialize() {
		
		createChain();
		fillChain();
		
	for(int i=0; i<chain.length; i++) {
		
		chain[i].stuff();
		chain[i].needed();
	}
	}
	
	
	
public void createChain() {
	
	try {
		file.readFile();
	} catch (IOException e) {

		e.printStackTrace();
	}
	chain = new GenericNode[file.total()]; // creating a place for the objects to go
	
	cycles = file.runFor();
	}
	


	
	public void fillChain() {
		int position = 0;
		
		for (int i=0; i < 6; i++) {
		for (int j=position; j < (position + file.materialCount(i)); j++) {
			
			
			if (!file.isConsumer(i)){
			chain[j] = new Producer();
			
			}else if(file.isConsumer(i)) {
			chain[j] = new ProducerConsumer();
			chain[j].Consumer();
			chain[j].needed();
			}
			
		chain[j].setMaterial(i);
		chain[j].build(i);
		
	}
		position+=file.materialCount(i);
	}
	}
	
	public void displayNodes() {
		
		int wood=0;
		int plastic=0;
		int steel=0;
		int leg=0;
		int desk=0;
		int table=0;
		

		for(int j=0; j<chain.length; j++) {
			
			switch (chain[j].getMaterial()) {
			
			case "Wood":
					wood++;
				
				break;
				
			case "Plastic":
					plastic++;
				break;
				
			case "Steel":
					steel++;
				break;
				
			case "Leg":
					leg++;
				break;
				
			case "Desk":
					desk++;
				break;
				
			case "Table":
					table++;
				break;
			}
			
		}
					
		System.out.println("Wood Node(s) Created : " +wood);
		System.out.println("Plastic Node(s) Created : " +plastic);
		System.out.println("steel Node(s) Created : " +steel);
		System.out.println("leg Node(s) Created : " +leg);
		System.out.println("desk Node(s) Created : " +desk);
		System.out.println("table Node(s) Created : "+ "" +table);
		
	}

	public void rawMaterials() throws IOException {
		    
		        
		for(int i=0; i<cycles; i++) {
			
			System.out.println("");
			System.out.println("Cycle " + (i+1) + ":");
			
			output += "Cycle " +  (i+1) + "\n";
			for(int j=0; j<chain.length; j++) {
		
				chain[j].produce();	
				readCycle(chain[j].getMaterial(), chain[j].getMaterialsProduced());
				produceMaterials(chain[j].getMaterial());
				
				
			}
			
			output += "\n";
			consume();
		}
		
		System.out.println(output);
		System.out.println("you made $" +revenue);
		
	}
	
	public String display() {
		
		output += "you made $" + revenue + " over " + cycles + " cycles";
		return output;
	}
	
	public void produceMaterials(String material) {
	
		
		
	for(int i=0; i<chain.length; i++) {	
		
		
		if(chain[i].isConsumer()) {
		

			for(int j=0; j<chain.length; j++) {
				
				if(chain[j].getMaterial() == (material)) {
				if(chain[j].isAvailable() && (chain[i].getMaterialsNeeded().contains(material) )) {
				
				System.out.println(chain[i].getMaterial() + "Node Recieved " + material + " Unit");
				
				output += chain[i].getMaterial() + " Node Recieved " + material + " Unit" + "\n";
				chain[i].getMaterialsNeeded().remove(material);
				chain[j].getMaterialsProduced().remove(material);
								
				}
				}
			}
			
		
			}
		}
	}
	
	public void readCycle(
			String material,Stack<String> produced) {
		
	
		output += material + " :" + produced + "\n";

	}
	
	public void consume() {
		
	
		for(int i=0; i<chain.length; i++) {	
			
			if(chain[i].getMaterialsProduced().contains("Table") ) {
				
				System.out.println("You sold a table for $" + tablePrice +"!");
				output += "\n You sold a table for $" + tablePrice +"! \n";
				chain[i].getMaterialsProduced().remove("Table");
				totalSales++;
				
			}

		}
		
		revenue = totalSales*tablePrice;
	}
}




	