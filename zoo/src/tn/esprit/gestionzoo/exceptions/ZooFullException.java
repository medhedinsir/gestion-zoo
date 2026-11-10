package tn.esprit.gestionzoo.exceptions;

// Prosit 7 - Instruction 33: thrown when we try to add an animal to a full zoo
public class ZooFullException extends Exception {

    public ZooFullException(String message) {
        super(message);
    }
}
