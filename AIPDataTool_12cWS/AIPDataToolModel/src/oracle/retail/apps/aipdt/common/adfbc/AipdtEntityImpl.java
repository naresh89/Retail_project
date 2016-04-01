package oracle.retail.apps.aipdt.common.adfbc;

import oracle.retail.apps.aipdt.common.validation.Validatable;
import oracle.retail.apps.aipdt.common.validation.Validator;
import oracle.retail.apps.framework.bc.model.ext.RetailEntityImpl;

public class AipdtEntityImpl extends RetailEntityImpl implements Validatable{
    public AipdtEntityImpl() {
        super();
    }

    public void accept(Validator vd) {
        vd.visit((oracle.dms.util.Validatable) this);
    }
}
