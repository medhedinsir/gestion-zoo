package tn.esprit.gestionzoo.entities;

// Prosit 2 (Instruction 5 & 6) + Prosit 4 (Instruction 18: private attributes, age >= 0)
public class Animal {

    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    // Default constructor (needed by the child classes and Instruction 21)
    public Animal() {
    }

    // Parameterized constructor (Instruction 6)
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        // Prosit 7: the negative age check is now done in Zoo.addAnimal (InvalidAgeException)
        this.age = age;
        this.isMammal = isMammal;
    }

    // ---------- Getters & setters (Instruction 18) ----------
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    // An animal cannot have a negative age
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Error: age cannot be negative (" + age + "). Age set to 0.");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }

    @Override
    public String toString() {
        return "Animal{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + "}";
    }
}
