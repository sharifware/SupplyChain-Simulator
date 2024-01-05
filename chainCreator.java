/*
  * Class:           Main
   * Author:  Muhammed-Sharif Adepetu
  * Date:     November 16, 2022
  *
   * Purpose: to read from a file and pass along the attributes of nodes
   * 
   * 
   * 
   * Methods:
   * readFile() 
   *  materialInventory(int material)
   *   chooseChain: chooses the type of chain:
   *    isConsumery(int material):
   *     materialRate(int material):
   */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class chainCreator {
	
	private int cycles = 0;
	private int numNodes =0;
	private int rate =0;
	private int inventorySize=0;
	private int isConsumer=0;
	private int[][] chainInformation;
	private int i;
	
	
	
	public void readFile() throws IOException {
		createArray();

		String type = "";
		String[] material;
		
		material = new String[8];
		
			try {
				
				BufferedReader br = new BufferedReader(new FileReader("chain.txt"));
				String scan = "";
				
			
				try {
					cycles = Integer.parseInt(br.readLine());
					
					
		        } catch (NumberFormatException nfe) {
		        	System.out.println("Invalid Cycle Number, Setting Number of cycles to 25");
		        	cycles = 25;
		        }
		     
		        	
				
				
					
					while( (scan = br.readLine() ) !=null) { 
						
						material = scan.split("\\s");
						
						type = material[0];
						
				
						numNodes = Integer.parseInt(material[1]);
				
						inventorySize = Integer.parseInt(material[2]);
							
						rate = Integer.parseInt(material[3]);
							
						isConsumer = Integer.parseInt(material[4]);
						
						chooseChain(type);
						
						i++;
		
					}
					
					br.close();
					} catch (Exception e) {
						verifyCycle(i);
						e.printStackTrace();
					}
			verifyCycle(i);
			total();
			} 
	
	
	public void fillChain(int Type, int number, int inventory, int rate, int isConsumer) {
		
		chainInformation[Type][0] = number;
		chainInformation[Type][1] = inventory;
		chainInformation[Type][2] = rate;
		chainInformation[Type][3] = isConsumer;
	}
	
	
	public void chooseChain(String type){
	if (type.equals("Wood")){
		
		fillChain(0, numNodes, inventorySize,rate,isConsumer);
	
	}else if (type.equals("Plastic")) {
		fillChain(1, numNodes, inventorySize,rate,isConsumer);
		
	}else if (type.equals("Steel")) {
		fillChain(2, numNodes, inventorySize,rate,isConsumer);
		
	}else if (type.equals("Leg")) {
		fillChain(3, numNodes, inventorySize,rate,isConsumer);
		
	}else if (type.equals("Desk")) {
		fillChain(4, numNodes, inventorySize,rate,isConsumer);
		
	}else if (type.equals("Table")) {
		fillChain(5, numNodes, inventorySize,rate,isConsumer);
		
	}	
		
	}
	
public void createArray() {
	chainInformation = new int[6][4]; // creating a place for the objects to go
	}

public int total() {
	int totalNode=0;
	
	for (int i =0; i < 6; i++){
		
		totalNode += chainInformation[i][0];	
}		
	return totalNode;
}

public boolean isConsumer(int material) {
	
	if (chainInformation[material][3] == 0) {	
	return false;
	}
	
return true;
}

public void verifyCycle(int i) {
	
	if (cycles > 101) {
		
		System.out.println("the number you chose exceesds allowed amount of maximum cycles. Setting Number of cycles to 100");
		cycles = 100;
	}else if(cycles < 5) {
		
		System.out.println("minimum allowed number of cycles is 5");
		cycles = 5;
			
		}
	
	if (i==0){
		System.out.println("\nError in file! please enter a file in the following format: \nNumber of cycles \nType of mterial, number of nodes of that material, inventory size, rate of production, does that node consume or not\n\n");
		cycles = 0; 
	}
	}


public int materialCount(int material) {
	
	return chainInformation[material][0];
}

public int materialInventory(int material) {
	
	return chainInformation[material][1];
}

public int runFor() {
	
	return cycles;
}

public int Materialrate(int material) {
	
	return chainInformation[material][2];
}

}