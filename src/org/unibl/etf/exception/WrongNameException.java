package org.unibl.etf.exception;

public class WrongNameException extends Exception {
    public WrongNameException(String message) {
        super(message);
    }

    public WrongNameException() {
        super("Pogresno ime, unesite novo!");
    }
}
