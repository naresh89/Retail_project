package oracle.retail.apps.aipdt.common.model.view;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 06 16:44:25 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SupplierListVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        SupplierListId {
            public Object get(SupplierListVORowImpl obj) {
                return obj.getSupplierListId();
            }

            public void put(SupplierListVORowImpl obj, Object value) {
                obj.setSupplierListId((Number)value);
            }
        }
        ,
        SupplierListName {
            public Object get(SupplierListVORowImpl obj) {
                return obj.getSupplierListName();
            }

            public void put(SupplierListVORowImpl obj, Object value) {
                obj.setSupplierListName((String)value);
            }
        }
        ,
        Id {
            public Object get(SupplierListVORowImpl obj) {
                return obj.getId();
            }

            public void put(SupplierListVORowImpl obj, Object value) {
                obj.setId((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SupplierListVORowImpl object);

        public abstract void put(SupplierListVORowImpl object, Object value);

        public int index() {
            return SupplierListVORowImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return SupplierListVORowImpl.AttributesEnum.firstIndex() + SupplierListVORowImpl.AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = SupplierListVORowImpl.AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int SUPPLIERLISTID = AttributesEnum.SupplierListId.index();
    public static final int SUPPLIERLISTNAME = AttributesEnum.SupplierListName.index();
    public static final int ID = AttributesEnum.Id.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SupplierListVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute SupplierListId.
     * @return the SupplierListId
     */
    public Number getSupplierListId() {
        return (Number) getAttributeInternal(SUPPLIERLISTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SupplierListId.
     * @param value value to set the  SupplierListId
     */
    public void setSupplierListId(Number value) {
        setAttributeInternal(SUPPLIERLISTID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SupplierListName.
     * @return the SupplierListName
     */
    public String getSupplierListName() {
        return (String) getAttributeInternal(SUPPLIERLISTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SupplierListName.
     * @param value value to set the  SupplierListName
     */
    public void setSupplierListName(String value) {
        setAttributeInternal(SUPPLIERLISTNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Id.
     * @return the Id
     */
    public Number getId() {
        return (Number) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Id.
     * @param value value to set the  Id
     */
    public void setId(Number value) {
        setAttributeInternal(ID, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
