import java.util.PriorityQueue;

public class ProducerConsumer extends GenericNode {
	
	private PriorityQueue<String> tempQueue;

	public void needed() {
		
		if(getMaterial().equals("Table")) {
		
		if(getMaterialsNeeded().isEmpty()) {
			setMaterialsNeeded("Leg");
			setMaterialsNeeded("Leg");
			setMaterialsNeeded("Leg");
			setMaterialsNeeded("Leg");
			setMaterialsNeeded("Desk");
			}

	}else if(getMaterial().equals("Desk")) {
		
		if(getMaterialsNeeded().isEmpty()) {
			setMaterialsNeeded("Wood");
			setMaterialsNeeded("Steel");
			setMaterialsNeeded("Plastic");
			}
		
	}else if(getMaterial().equals("Leg")) {
		
		if(getMaterialsNeeded().isEmpty()) {
			setMaterialsNeeded("Wood");
			setMaterialsNeeded("Wood");
			setMaterialsNeeded("Plastic");
			}
}
}
	public void produce() {
		
		 
		setProcess(getProcess() + 1);
		
	if (getProcess() >= getRateOfProduction()) {
		
		if (verifyInventory() && producedYet()) {
			
		setMaterialsProduced(getMaterial());
		System.out.println(getMaterial() + " Produced!");
		System.out.println(getMaterial() + " inventory : " + getMaterialsProduced());
		needed();
		setProcess(0);

	}else {
		
		System.out.println(getMaterial() + " inventory : " + getMaterialsProduced());
		System.out.println("Materials required to produce " + getMaterial() + " " + getMaterialsNeeded());
	}
		
	}else {
		System.out.println(getMaterial() + " inventory : " + getMaterialsProduced());
	System.out.println("Materials required to produce " + getMaterial() + " " + getMaterialsNeeded());
	}
	}
	
	
}