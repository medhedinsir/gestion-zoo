package tn.esprit.gestionzoo.entities;

// Prosit 5 (Instruction 20) + Prosit 6 (Instruction 28: abstract swim, Instruction 31: equals)
// Instruction 28: the class becomes abstract so that swim() MUST be redefined in every child class.
public abstract class Aquatic extends Animal {

    protected String habitat;

    public Aquatic() {
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Instruction 24 version (before Instruction 28):
    // public void swim() {
    //     System.out.println("This aquatic animal is swimming");
    // }

    // Instruction 28 version:
    public abstract void swim();

    // Instruction 31: same name + same age + same habitat => identical
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Aquatic)) return false;
        Aquatic other = (Aquatic) obj;
        return getAge() == other.getAge()
                && getName() != null && getName().equals(other.getName())
                && habitat != null && habitat.equals(other.habitat);
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + "'";
    }
}
