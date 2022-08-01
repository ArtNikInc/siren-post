package main.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class entityClass, String searchValue) {
        super("Couldn't find " + entityClass.getName() + " by " + searchValue);
    }

    public EntityNotFoundException(Class entityClass, Long searchValue) {
        this(entityClass, searchValue.toString());
    }
}
