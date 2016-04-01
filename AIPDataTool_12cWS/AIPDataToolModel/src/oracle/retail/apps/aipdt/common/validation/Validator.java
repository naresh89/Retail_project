package oracle.retail.apps.aipdt.common.validation;

import oracle.dms.util.Validatable;


/**
 * This interface must be implemented by any custom validators
 * that provides complex validation logic which cannot be achived by Entity/Attribute level validations.
 */
public interface Validator {
    
    /**
     * This method should throw a ValidationException in case validatable object is not valid
     * @param vl a validatable object
     */
    void visit(Validatable vl);
}
