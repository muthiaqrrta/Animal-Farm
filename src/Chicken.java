
public class Chicken extends FarmAnimal {
	 public Chicken() {

	    }

	    public Chicken(String name) {
	        super(name, "petok petok");
	    }

	    @Override
	    public String toString() {
	        return "The chicken named " + getName() + " makes the sound: " + noise();
	    }
}
