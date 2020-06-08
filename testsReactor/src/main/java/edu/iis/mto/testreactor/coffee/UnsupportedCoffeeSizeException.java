package edu.iis.mto.testreactor.coffee;

public class UnsupportedCoffeeSizeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnsupportedCoffeeSizeException(CoffeeType type, CoffeeSize size) {
        super(type + " does not exists in size " + size);
    }

}
