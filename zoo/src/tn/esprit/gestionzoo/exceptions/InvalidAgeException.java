package tn.esprit.gestionzoo.exceptions;

// Prosit 7 - Instruction 34: thrown when we try to add an animal with a negative age
public class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}
