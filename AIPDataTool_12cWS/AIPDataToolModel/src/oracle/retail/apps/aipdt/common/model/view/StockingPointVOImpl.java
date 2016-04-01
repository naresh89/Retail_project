package oracle.retail.apps.aipdt.common.model.view;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 08 10:46:16 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class StockingPointVOImpl extends AipdtViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public StockingPointVOImpl() {
    }

    /**
     * Returns the variable value for bindWarehouseType.
     * @return variable value for bindWarehouseType
     */
    public String getbindWarehouseType() {
        return (String) ensureVariableManager().getVariableValue("bindWarehouseType");
    }

    /**
     * Sets <code>value</code> for variable bindWarehouseType.
     * @param value value to bind as bindWarehouseType
     */
    public void setbindWarehouseType(String value) {
        ensureVariableManager().setVariableValue("bindWarehouseType", value);
    }
}
