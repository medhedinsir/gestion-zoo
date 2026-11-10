package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

// Prosit 2/3 (Zoo + methods), Prosit 4 (private attributes, name not empty, isZooFull in addAnimal)
// Prosit 6 (aquaticAnimals array + related methods)
// Prosit 7 (addAnimal throws ZooFullException / InvalidAgeException, 3 cages)
public class Zoo {

    public static final int NBR_CAGES = 3;       // Instruction 33: reduced from 25 to 3 to test the exception
    public static final int MAX_AQUATIC = 10;    // Instruction 25

    private Animal[] animals;
    private String name;
    private String city;
    private int nbrAnimals;

    // Instruction 25: up to 10 aquatic animals
    private Aquatic[] aquaticAnimals = new Aquatic[MAX_AQUATIC];
    private int nbrAquatics;

    public Zoo() {
        animals = new Animal[NBR_CAGES];
    }

    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        setName(name);
        this.city = city;
    }

    // ---------- Getters & setters ----------
    public String getName() {
        return name;
    }

    // Zoo names must not be empty (Instruction 18)
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: zoo name cannot be empty. Name set to \"Unnamed zoo\".");
            this.name = "Unnamed zoo";
        } else {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    // ---------- Prosit 3 / 4 methods ----------
    public boolean isZooFull() {
        return nbrAnimals >= NBR_CAGES;
    }

    // Prosit 7 - Instructions 32, 33, 34:
    // return type changed from boolean to void, the isZooFull() test is replaced by exceptions.
    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("Cannot add " + animal.getName()
                    + ": age cannot be negative (" + animal.getAge() + ")");
        }
        if (nbrAnimals >= NBR_CAGES) {
            throw new ZooFullException("Cannot add " + animal.getName()
                    + ": the zoo " + name + " is full (" + NBR_CAGES + " cages)");
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
    }

    // Returns the index of the animal (same name), or -1 if not found
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Animals of " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println("  " + animals[i]);
        }
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.nbrAnimals >= z2.nbrAnimals) ? z1 : z2;
    }

    // ---------- Prosit 6 methods ----------

    // Instruction 26
    public void addAquaticAnimal(Aquatic aquatic) {
        if (nbrAquatics >= MAX_AQUATIC) {
            System.out.println("No more room for aquatic animals in " + name);
            return;
        }
        aquaticAnimals[nbrAquatics] = aquatic;
        nbrAquatics++;
    }

    // Instruction 27: each animal swims in its own way (polymorphism)
    public void swimAll() {
        for (int i = 0; i < nbrAquatics; i++) {
            aquaticAnimals[i].swim();
        }
    }

    // Instruction 29
    public float maxPenguinSwimmingDepth() {
        float max = 0;
        for (int i = 0; i < nbrAquatics; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > max) {
                    max = p.getSwimmingDepth();
                }
            }
        }
        return max;
    }

    // Instruction 30
    public void displayNumberOfAquaticsByType() {
        int dolphins = 0;
        int penguins = 0;
        for (int i = 0; i < nbrAquatics; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguins++;
            }
        }
        System.out.println("Dolphins: " + dolphins + " | Penguins: " + penguins);
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES
                + ", nbrAnimals=" + nbrAnimals + ", nbrAquatics=" + nbrAquatics + "}";
    }
}
