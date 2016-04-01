package oracle.retail.apps.aipdt.common.model.view;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 06 17:47:33 IST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class StoreListVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        StoreListId {
            public Object get(StoreListVORowImpl obj) {
                return obj.getStoreListId();
            }

            public void put(StoreListVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        StoreListName {
            public Object get(StoreListVORowImpl obj) {
                return obj.getStoreListName();
            }

            public void put(StoreListVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Id {
            public Object get(StoreListVORowImpl obj) {
                return obj.getId();
            }

            public void put(StoreListVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(StoreListVORowImpl object);

        public abstract void put(StoreListVORowImpl object, Object value);

        public int index() {
            return StoreListVORowImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return StoreListVORowImpl.AttributesEnum.firstIndex() + StoreListVORowImpl.AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = StoreListVORowImpl.AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int STORELISTID = AttributesEnum.StoreListId.index();
    public static final int STORELISTNAME = AttributesEnum.StoreListName.index();
    public static final int ID = AttributesEnum.Id.index();

    /**
     * This is the default constructor (do not remove).
     */
    public StoreListVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute StoreListId.
     * @return the StoreListId
     */
    public Number getStoreListId() {
        return (Number) getAttributeInternal(STORELISTID);
    }


    /**
     * Gets the attribute value for the calculated attribute StoreListName.
     * @return the StoreListName
     */
    public String getStoreListName() {
        return (String) getAttributeInternal(STORELISTNAME);
    }


    /**
     * Gets the attribute value for the calculated attribute Id.
     * @return the Id
     */
    public Number getId() {
        return (Number) getAttributeInternal(ID);
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
