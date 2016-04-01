package oracle.retail.apps.aipdt.common.adfbc;

import oracle.retail.apps.aipdt.common.validation.Validatable;
import oracle.retail.apps.aipdt.common.validation.Validator;
import oracle.retail.apps.framework.bc.model.ext.RetailEntityCache;

public class AipdtEntityCache extends RetailEntityCache implements Validatable {
    public AipdtEntityCache() {
        super();
    }
    
    public void accept(Validator vd) {
        vd.visit((oracle.dms.util.Validatable) this);
    }
}
