package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        // ================= PROSIT 1 =================
        // Instruction 1
        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + " has " + nbrCages + " cages");

        // Instruction 2: read from keyboard, with input checks
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the zoo name: ");
        zooName = sc.nextLine();
        while (zooName.trim().isEmpty()) {
            System.out.print("Name cannot be empty, enter the zoo name: ");
            zooName = sc.nextLine();
        }

        System.out.print("Enter the number of cages: ");
        while (true) {
            if (sc.hasNextInt()) {
                nbrCages = sc.nextInt();
                if (nbrCages > 0) break;
                System.out.print("Must be a positive number, try again: ");
            } else {
                System.out.print("Please enter a valid integer: ");
                sc.next(); // discard bad input
            }
        }

        // Instruction 3
        System.out.println(zooName + " has " + nbrCages + " cages");

        // ================= PROSIT 2, 3, 4 =================
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal badAge = new Animal("Canidae", "Rex", -3, true); // negative age
        Animal bear = new Animal("Ursidae", "Baloo", 9, true);
        Animal monkey = new Animal("Cercopithecidae", "Abu", 4, true);

        Zoo myZoo = new Zoo(zooName, "Tunis");
        Zoo emptyName = new Zoo("", "Sousse"); // name check

        // ================= PROSIT 7 =================
        // Instructions 33 & 34: the zoo has only 3 cages.
        // Each add is in a try/catch, and "finally" ALWAYS displays the number of animals.
        Animal[] toAdd = {lion, tiger, badAge, bear, monkey};
        for (Animal a : toAdd) {
            try {
                myZoo.addAnimal(a);
                System.out.println(a.getName() + " added.");
            } catch (ZooFullException e) {
                System.out.println("ZooFullException: " + e.getMessage());
            } catch (InvalidAgeException e) {
                System.out.println("InvalidAgeException: " + e.getMessage());
            } finally {
                System.out.println("Number of animals: " + myZoo.getNbrAnimals());
            }
        }

        myZoo.displayAnimals();
        System.out.println(myZoo);
        System.out.println("Bigger zoo: " + Zoo.comparerZoo(myZoo, emptyName).getName());

        // ================= PROSIT 5 =================
        // Instruction 21: default constructors
        // Note: since Instruction 28, Aquatic is abstract, so "new Aquatic()" no longer compiles.
        // Aquatic aquatic = new Aquatic();
        Terrestrial terrestrial = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();

        // Instruction 22: parameterized constructors
        Terrestrial elephant = new Terrestrial("Elephantidae", "Dumbo", 10, true, 4);
        Dolphin flipper = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 35.5f);
        Penguin pingu = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120f);

        // Instruction 23: toString
        System.out.println(terrestrial);
        System.out.println(elephant);
        System.out.println(flipper);
        System.out.println(pingu);

        // Instruction 24
        flipper.swim(); // "This dolphin is swimming."
        pingu.swim();   // Before Instr. 28: inherited "This aquatic animal is swimming"

        // ================= PROSIT 6 =================
        // Instruction 26
        Penguin pingo = new Penguin("Spheniscidae", "Pingo", 4, false, "Antarctica", 200f);
        Dolphin willy = new Dolphin("Delphinidae", "Willy", 12, true, "Pacific", 40f);

        myZoo.addAquaticAnimal(flipper);
        myZoo.addAquaticAnimal(pingu);
        myZoo.addAquaticAnimal(pingo);
        myZoo.addAquaticAnimal(willy);

        // Instruction 27: each object calls ITS OWN version of swim() (polymorphism)
        myZoo.swimAll();

        // Instruction 29
        System.out.println("Max penguin depth: " + myZoo.maxPenguinSwimmingDepth());

        // Instruction 30
        myZoo.displayNumberOfAquaticsByType();

        // Instruction 31
        Penguin pinguCopy = new Penguin("Other", "Pingu", 3, false, "Antarctica", 50f);
        System.out.println("pingu equals pinguCopy? " + pingu.equals(pinguCopy)); // true
        System.out.println("pingu equals pingo? " + pingu.equals(pingo));         // false

        sc.close();
    }
}
