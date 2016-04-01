package oracle.retail.apps.aipdt.rswspm.model.view;

import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 10 17:00:19 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class WhToStPriorityMatrixProgVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        RowVal {
            public Object get(WhToStPriorityMatrixProgVORowImpl obj) {
                return obj.getRowVal();
            }

            public void put(WhToStPriorityMatrixProgVORowImpl obj, Object value) {
                obj.setRowVal((String) value);
            }
        }
        ,
        StoreAttr {
            public Object get(WhToStPriorityMatrixProgVORowImpl obj) {
                return obj.getStoreAttr();
            }

            public void put(WhToStPriorityMatrixProgVORowImpl obj, Object value) {
                obj.setStoreAttr((String) value);
            }
        }
        ,
        RegionAttr {
            public Object get(WhToStPriorityMatrixProgVORowImpl obj) {
                return obj.getRegionAttr();
            }

            public void put(WhToStPriorityMatrixProgVORowImpl obj, Object value) {
                obj.setRegionAttr((String) value);
            }
        }
        ,
        RegionIdAttr {
            public Object get(WhToStPriorityMatrixProgVORowImpl obj) {
                return obj.getRegionIdAttr();
            }

            public void put(WhToStPriorityMatrixProgVORowImpl obj, Object value) {
                obj.setRegionIdAttr((Number) value);
            }
        }
        ,
        StoreVOA {
            public Object get(WhToStPriorityMatrixProgVORowImpl obj) {
                return obj.getStoreVOA();
            }

            public void put(WhToStPriorityMatrixProgVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(WhToStPriorityMatrixProgVORowImpl object);

        public abstract void put(WhToStPriorityMatrixProgVORowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int ROWVAL = AttributesEnum.RowVal.index();
    public static final int STOREATTR = AttributesEnum.StoreAttr.index();
    public static final int REGIONATTR = AttributesEnum.RegionAttr.index();
    public static final int REGIONIDATTR = AttributesEnum.RegionIdAttr.index();
    public static final int STOREVOA = AttributesEnum.StoreVOA.index();

    /**
     * This is the default constructor (do not remove).
     */
    public WhToStPriorityMatrixProgVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute RowVal.
     * @return the RowVal
     */
    public String getRowVal() {
        return (String) getAttributeInternal(ROWVAL);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RowVal.
     * @param value value to set the  RowVal
     */
    public void setRowVal(String value) {
        setAttributeInternal(ROWVAL, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StoreAttr.
     * @return the StoreAttr
     */
    public String getStoreAttr() {
        return (String) getAttributeInternal(STOREATTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StoreAttr.
     * @param value value to set the  StoreAttr
     */
    public void setStoreAttr(String value) {
        setAttributeInternal(STOREATTR, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RegionAttr.
     * @return the RegionAttr
     */
    public String getRegionAttr() {
        return (String) getAttributeInternal(REGIONATTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RegionAttr.
     * @param value value to set the  RegionAttr
     */
    public void setRegionAttr(String value) {
        setAttributeInternal(REGIONATTR, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RegionIdAttr.
     * @return the RegionIdAttr
     */
    public Number getRegionIdAttr() {
        return (Number) getAttributeInternal(REGIONIDATTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RegionIdAttr.
     * @param value value to set the  RegionIdAttr
     */
    public void setRegionIdAttr(Number value) {
        setAttributeInternal(REGIONIDATTR, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> StoreVOA.
     */
    public RowSet getStoreVOA() {
        return (RowSet) getAttributeInternal(STOREVOA);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception {
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
    protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}

