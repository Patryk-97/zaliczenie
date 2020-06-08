package edu.iis.mto.testreactor.coffee;

public class UnsupportedCoffeeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnsupportedCoffeeException(CoffeeType type) {
        super(type.toString());
    }
}
