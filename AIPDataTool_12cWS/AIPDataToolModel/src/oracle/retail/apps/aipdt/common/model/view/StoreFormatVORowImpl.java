package oracle.retail.apps.aipdt.common.model.view;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 21 17:43:03 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class StoreFormatVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        StoreFormatCode {
            public Object get(StoreFormatVORowImpl obj) {
                return obj.getStoreFormatCode();
            }

            public void put(StoreFormatVORowImpl obj, Object value) {
                obj.setStoreFormatCode((String)value);
            }
        }
        ,
        StoreFormatName {
            public Object get(StoreFormatVORowImpl obj) {
                return obj.getStoreFormatName();
            }

            public void put(StoreFormatVORowImpl obj, Object value) {
                obj.setStoreFormatName((String)value);
            }
        }
        ,
        StoreFormatId {
            public Object get(StoreFormatVORowImpl obj) {
                return obj.getStoreFormatId();
            }

            public void put(StoreFormatVORowImpl obj, Object value) {
                obj.setStoreFormatId((Number)value);
            }
        }
        ,
        Id {
            public Object get(StoreFormatVORowImpl obj) {
                return obj.getId();
            }

            public void put(StoreFormatVORowImpl obj, Object value) {
                obj.setId((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(StoreFormatVORowImpl object);

        public abstract void put(StoreFormatVORowImpl object, Object value);

        public int index() {
            return StoreFormatVORowImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return StoreFormatVORowImpl.AttributesEnum.firstIndex() + StoreFormatVORowImpl.AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = StoreFormatVORowImpl.AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int STOREFORMATCODE = AttributesEnum.StoreFormatCode.index();
    public static final int STOREFORMATNAME = AttributesEnum.StoreFormatName.index();
    public static final int STOREFORMATID = AttributesEnum.StoreFormatId.index();
    public static final int ID = AttributesEnum.Id.index();

    /**
     * This is the default constructor (do not remove).
     */
    public StoreFormatVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute StoreFormatId.
     * @return the StoreFormatId
     */
    public Number getStoreFormatId() {
        return (Number) getAttributeInternal(STOREFORMATID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StoreFormatId.
     * @param value value to set the  StoreFormatId
     */
    public void setStoreFormatId(Number value) {
        setAttributeInternal(STOREFORMATID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StoreFormatCode.
     * @return the StoreFormatCode
     */
    public String getStoreFormatCode() {
        return (String) getAttributeInternal(STOREFORMATCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StoreFormatCode.
     * @param value value to set the  StoreFormatCode
     */
    public void setStoreFormatCode(String value) {
        setAttributeInternal(STOREFORMATCODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StoreFormatName.
     * @return the StoreFormatName
     */
    public String getStoreFormatName() {
        return (String) getAttributeInternal(STOREFORMATNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StoreFormatName.
     * @param value value to set the  StoreFormatName
     */
    public void setStoreFormatName(String value) {
        setAttributeInternal(STOREFORMATNAME, value);
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
