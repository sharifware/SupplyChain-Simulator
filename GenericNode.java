import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.swing.Spring;

/*
  * Class:           Gene
   * Author:  Muhammed-Sharif Adepetu
  * Date:     November 16, 2022
  *
   * Purpose:         a generic class to extend all producer and consumer nodes 
   *
   * Attributes: rareOfProduction
   * inventorysize
   * process:
   * material
   * 
   * materialsNeeded
   * materialsProduced
   * 
   * 
   * Methods:
   * 
   * Stuff(): this initializes the stacks and queue for the node
   * setInventory(): this initializes the inventory size of the node
   * material(): this sets the material being produced 
   * isAvailable(): a boolean that returns true if the required material(s) are available
   * 
   * getMaterialsNeeded(): returns the queue of materials needed
   * setMaterialsNeeded(): adds a required material
   * 
   *getMaterialsProduced(): returns the stack of all the materials produced
   *setMaterialsProduced(): adds a material to the stack
   * 
   * 
   * tellRate
  */      



public class GenericNode {

	chainCreator file = new chainCreator();
	private int rateOfProduction = 1;
	private int inventorySize = 5;
	private int process = 0;
	private Boolean isConsumer = false;
	private String material = "generic";
	private PriorityQueue<String> materialsNeeded;
	private Stack<String> materialsProduced;
	private String output = "";
	
	
	public void stuff(){
	materialsNeeded = new PriorityQueue<String>();
	materialsProduced = new Stack<String>();
	
	}
	
	public void build(int material) {
		
		try {
			file.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setRateOfProduction(material);
		setInventory(material);
	}
	
	public void setRateOfProduction(int prod) {
	
		rateOfProduction = file.Materialrate(prod);
		
	}
	
	
	public void setInventory(int material) {
		
		int size =0;
		inventorySize = file.materialInventory(material);
		size = inventorySize;
		
		if ((inventorySize > 5) || (inventorySize <= 0 )) {
			
			inventorySize = 5;
			
			System.out.println( (size) + " Is an Invalid Inventory Size. " + getMaterial() +  " Node Inventory Size Set to " + inventorySize);
		}
	}
	
	public boolean verifyInventory() {
		return ( inventorySize >=  materialsProduced.size());
	}

	
	public boolean producedYet() {
		return ((getMaterialsNeeded().size() == 0));
		}


	public void produce() {
		
 
		setProcess(getProcess() + 1);
		
	if (getProcess() >= rateOfProduction) {
		
		if (verifyInventory()) {
			
		setMaterialsProduced(material);
		System.out.println(getMaterial() + " inventory : " + getMaterialsProduced());
		setProcess(0);

	}else {
		System.out.println(getMaterial() + " inventory : " + getMaterialsProduced());
	}
	}else {
	System.out.println(getMaterial() + " inventory : " + getMaterialsProduced());
	}
	}

	public boolean isAvailable(){
		return getMaterialsProduced().contains(getMaterial());
	}
	
	public void needed() {
		
	}



public Stack<String> getMaterialsProduced() {
	return materialsProduced;
}

public void setMaterialsNeeded(String material) {
	materialsNeeded.add(material);
}

public PriorityQueue<String> getMaterialsNeeded() {
	return materialsNeeded;
}

public void setMaterialsProduced(String material) {
	materialsProduced.push(material);
}


public int getRateOfProduction() {
	return rateOfProduction;
}



public String getMaterial() {
	return material;
}

public void Consumer() {
	isConsumer = true;
	//System.out.println(getMaterial() + " is a consuma");
}

public Boolean isConsumer() {
	return isConsumer;
}

public void setMaterial(int material) {
	
	switch (material) {
	
	case 0:
		this.material = "Wood";
		break;
	case 1:
		this.material = "Plastic";
		break;
	case 2:
		this.material = "Steel";
		break;
	case 3:
		this.material = "Leg";
		break;
	case 4:
		this.material = "Desk";
		break;
	case 5:
		this.material = "Table";
		break;
	}
	
}

public int getProcess() {
	return process;
}

public void setProcess(int process) {
	this.process = process;
}

public void producetest(String material) {
	
	
}
}
