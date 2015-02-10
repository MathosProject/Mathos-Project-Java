package mathoscore.Chemistry;

import java.util.ArrayList;

public class Chemicals {
	
	ArrayList<Chemical> chemicals;
	
	public final class Chemical {
		private final String name;
		private final int amount;
		
		public Chemical(String name) {
			this(name, 1);
		}
		public Chemical (String name, int amount) {
			this.name = name;
			this.amount = amount;
		}
		
		public String getName() {
			return name;
		}
		
		public int getAmount() {
			return amount;
		}
		
		/**
		 * This method checks the name only. Two chemicals with different
		 * amounts are treated as the same.
		 */
		@Override
		public boolean equals(Object o) {
			if (o==null) return false;
			if (o==this) return true;
			if (!(o instanceof Chemical)) return false;
			
			Chemical obj = (Chemical)o;
			
			if(obj.getName() == this.name) return true;
			
			return false;
		}
	}
	
	public Chemicals() {
		
		chemicals = new ArrayList<Chemicals.Chemical>();
	}
	
	/**
	 * Adds a new chemical to the list of chemicals. 
	 * @param chemical The chemical.
	 * @return True if the chemical was already in the list or False otherwise.
	 */
	public boolean addChemical(String name, int amount) {
		
		Chemical chemical = new Chemical(name,amount);
		
		int index = chemicals.indexOf(chemical);
		
		if(index != -1) {
			
			Chemical current = chemicals.get(index);
			chemicals.set(index, new Chemical(current.getName(), current.getAmount() + chemical.getAmount()));
			return true;
		}
		else {
			
			chemicals.add(chemical);
			return false;
		}
	}
	
}
