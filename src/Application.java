public class Application {

    private static Barn barn;

    public static void main(String[] args) {

        int n = 1;
        do{
            if(n<1)System.out.printf("Invalid animal limit%n");
            System.out.print("Choose how many animals will fit in the barn: ");
            n = Input.getInt();
        }while(n<1);
        barn = new Barn(n);
        System.out.printf("%n");
        selection();
    }

    private static void selection() {
        System.out.printf("1. Add animal%n%n");
        System.out.printf("2. Listen to the animals in the barn%n%n");
        System.out.printf("3. Quit%n%n");
        System.out.print("What do you want to do: ");
        int choice = Input.getInt();
        System.out.printf("%n");
        switch (choice) {
            case 1:
                addAnimal();
                break;
            case 2:
                makeSomeNoise();
                break;
            case 3:
                break;
            default:
                System.out.printf("Selection unknown%n%n");
                selection();
                break;
        }
    }

    private static void addAnimal() {
        String animalTypes = "Chicken, Sheep";
        if (barn.getAnimals().length == barn.getMaxAnimals()) {
            System.out.printf("The barn is full!%n%n");
        } else {
            System.out.print("What type of animal do you want to add: ");
            String animalChoice = Input.getString();
            if (!animalTypes.contains(animalChoice.substring(0,1).toUpperCase()+animalChoice.substring(1).toLowerCase())) {
                System.out.printf("That animal does not exist!%nExisting animals: "+animalTypes+"%n%n");
                selection();
                return;
            }
            System.out.print("What would you like to name the animal: ");
            String animalName = Input.getString();
            if (animalChoice.equalsIgnoreCase("Chicken")) barn.addAnimal(new Chicken(animalName));
            if (animalChoice.equalsIgnoreCase("Sheep")) barn.addAnimal(new Sheep(animalName));
            System.out.printf("%n");
        }
        selection();
    }

    private static void makeSomeNoise() {
        if (barn.getAnimals().length == 0) {
            System.out.printf("The barn is empty!%n");
        }
        for (FarmAnimal fam : barn.getAnimals()) {
            System.out.printf(fam.toString() + "%n");
        }
        System.out.printf("%n");
        selection();
    }
}
