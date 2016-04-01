package oracle.retail.apps.aipdt.common.adfbc;

import oracle.jbo.server.ViewDefImpl;

import oracle.retail.apps.aipdt.common.validation.Validatable;
import oracle.retail.apps.aipdt.common.validation.Validator;
import oracle.retail.apps.framework.bc.model.ext.RetailViewObjectImpl;


public class AipdtViewObjectImpl extends RetailViewObjectImpl implements Validatable {
    public AipdtViewObjectImpl(String string, ViewDefImpl viewDefImpl) {
        super(string, viewDefImpl);
    }

    public AipdtViewObjectImpl() {
        super();
    }
    
    public void accept(Validator vd) {
        vd.visit((oracle.dms.util.Validatable) this);
    }
}
