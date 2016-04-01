package oracle.retail.apps.aipdt.common.validation;


/**
 * This interface should be implemented by classes that are validatable
 * By default AIP Data Tool Base EntityObject and View Object implementation classes will be implementing this interface
 */
public interface Validatable {
    
    /**
     * This method accepts a validator and should invoke visit method of validator
     */
    void accept(Validator vd);
    
}
