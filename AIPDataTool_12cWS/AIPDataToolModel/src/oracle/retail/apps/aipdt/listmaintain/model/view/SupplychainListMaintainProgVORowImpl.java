package oracle.retail.apps.aipdt.listmaintain.model.view;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Feb 26 17:50:23 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SupplychainListMaintainProgVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        RowVal {
            public Object get(SupplychainListMaintainProgVORowImpl obj) {
                return obj.getRowVal();
            }

            public void put(SupplychainListMaintainProgVORowImpl obj, Object value) {
                obj.setRowVal((String) value);
            }
        }
        ,
        WorkingLevelAttr {
            public Object get(SupplychainListMaintainProgVORowImpl obj) {
                return obj.getWorkingLevelAttr();
            }

            public void put(SupplychainListMaintainProgVORowImpl obj, Object value) {
                obj.setWorkingLevelAttr((String) value);
            }
        }
        ,
        ListNameAttr {
            public Object get(SupplychainListMaintainProgVORowImpl obj) {
                return obj.getListNameAttr();
            }

            public void put(SupplychainListMaintainProgVORowImpl obj, Object value) {
                obj.setListNameAttr((String) value);
            }
        }
        ,
        ListPrivacyAttr {
            public Object get(SupplychainListMaintainProgVORowImpl obj) {
                return obj.getListPrivacyAttr();
            }

            public void put(SupplychainListMaintainProgVORowImpl obj, Object value) {
                obj.setListPrivacyAttr((String) value);
            }
        }
        ,
        WorkingLevelTypeVOA {
            public Object get(SupplychainListMaintainProgVORowImpl obj) {
                return obj.getWorkingLevelTypeVOA();
            }

            public void put(SupplychainListMaintainProgVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        WorkingPrivacyVOA {
            public Object get(SupplychainListMaintainProgVORowImpl obj) {
                return obj.getWorkingPrivacyVOA();
            }

            public void put(SupplychainListMaintainProgVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SupplychainListMaintainProgVORowImpl object);

        public abstract void put(SupplychainListMaintainProgVORowImpl object, Object value);

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
    public static final int WORKINGLEVELATTR = AttributesEnum.WorkingLevelAttr.index();
    public static final int LISTNAMEATTR = AttributesEnum.ListNameAttr.index();
    public static final int LISTPRIVACYATTR = AttributesEnum.ListPrivacyAttr.index();
    public static final int WORKINGLEVELTYPEVOA = AttributesEnum.WorkingLevelTypeVOA.index();
    public static final int WORKINGPRIVACYVOA = AttributesEnum.WorkingPrivacyVOA.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SupplychainListMaintainProgVORowImpl() {
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
     * Gets the attribute value for the calculated attribute WorkingLevelAttr.
     * @return the WorkingLevelAttr
     */
    public String getWorkingLevelAttr() {
        return (String) getAttributeInternal(WORKINGLEVELATTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute WorkingLevelAttr.
     * @param value value to set the  WorkingLevelAttr
     */
    public void setWorkingLevelAttr(String value) {
        setAttributeInternal(WORKINGLEVELATTR, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ListNameAttr.
     * @return the ListNameAttr
     */
    public String getListNameAttr() {
        return (String) getAttributeInternal(LISTNAMEATTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ListNameAttr.
     * @param value value to set the  ListNameAttr
     */
    public void setListNameAttr(String value) {
        setAttributeInternal(LISTNAMEATTR, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ListPrivacyAttr.
     * @return the ListPrivacyAttr
     */
    public String getListPrivacyAttr() {
        return (String) getAttributeInternal(LISTPRIVACYATTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ListPrivacyAttr.
     * @param value value to set the  ListPrivacyAttr
     */
    public void setListPrivacyAttr(String value) {
        setAttributeInternal(LISTPRIVACYATTR, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> WorkingLevelTypeVOA.
     */
    public RowSet getWorkingLevelTypeVOA() {
        return (RowSet) getAttributeInternal(WORKINGLEVELTYPEVOA);
    }

    /**
     * Gets the view accessor <code>RowSet</code> WorkingPrivacyVOA.
     */
    public RowSet getWorkingPrivacyVOA() {
        return (RowSet) getAttributeInternal(WORKINGPRIVACYVOA);
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

