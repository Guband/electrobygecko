package electro.by.gecko.vitrine.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Could not find product n°"+id);
    }
}
