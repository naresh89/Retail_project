package oracle.retail.apps.aipdt.dt.model.view;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Feb 09 22:03:06 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DeploymentTypeResultVOImpl extends AipdtViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public DeploymentTypeResultVOImpl() {
    }
    
    public void clearEntityObjectCache(){
        this.getDBTransaction().clearEntityCache(this.getEntityDef(0).getFullName());
    }
}

