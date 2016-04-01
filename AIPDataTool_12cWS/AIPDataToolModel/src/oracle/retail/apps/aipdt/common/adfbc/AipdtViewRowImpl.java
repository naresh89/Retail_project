package oracle.retail.apps.aipdt.common.adfbc;

import oracle.retail.apps.aipdt.common.validation.Validatable;
import oracle.retail.apps.aipdt.common.validation.Validator;
import oracle.retail.apps.framework.bc.model.ext.RetailViewRowImpl;

public class AipdtViewRowImpl extends RetailViewRowImpl implements Validatable {
    public AipdtViewRowImpl() {
        super();
    }
    
    public void accept(Validator vd) {
        vd.visit((oracle.dms.util.Validatable) this);
    }
}
