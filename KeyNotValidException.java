package linkedlist;

public class KeyNotValidException extends Exception {
    KeyNotValidException() {
        System.out.println("Woha, easy man, you can't do that, there's no person with that ID.");
    }
}