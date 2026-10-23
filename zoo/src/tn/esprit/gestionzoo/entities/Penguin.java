package tn.esprit.gestionzoo.entities;

// Prosit 5 (Instruction 20, 22, 23) + Prosit 6 (Instruction 28: must override swim)
public class Penguin extends Aquatic {

    protected float swimmingDepth;

    public Penguin() {
    }

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        this.swimmingDepth = swimmingDepth;
    }

    // Required since Instruction 28 (swim is abstract in Aquatic)
    @Override
    public void swim() {
        System.out.println("This penguin is swimming.");
    }

    @Override
    public String toString() {
        return "Penguin: " + super.toString() + ", swimmingDepth=" + swimmingDepth;
    }
}
