package oracle.retail.apps.aipdt.listcreate.model.entity;

import java.math.BigDecimal;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;

import oracle.retail.apps.aipdt.common.adfbc.AipdtEntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 10 11:04:58 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DtListDetailsEOImpl extends AipdtEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ClassId {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getClassId();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setClassId((Number) value);
            }
        }
        ,
        SubclassId {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getSubclassId();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setSubclassId((Number) value);
            }
        }
        ,
        CommodityId {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getCommodityId();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setCommodityId((Number) value);
            }
        }
        ,
        PackSize {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getPackSize();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setPackSize((Integer) value);
            }
        }
        ,
        WarehouseId {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getWarehouseId();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setWarehouseId((Number) value);
            }
        }
        ,
        SupplierId {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getSupplierId();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setSupplierId((Number) value);
            }
        }
        ,
        StoreId {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getStoreId();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setStoreId((Number) value);
            }
        }
        ,
        ListId {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getListId();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setListId((Number) value);
            }
        }
        ,
        RowID {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getRowID();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        DtListHeadersEO {
            public Object get(DtListDetailsEOImpl obj) {
                return obj.getDtListHeadersEO();
            }

            public void put(DtListDetailsEOImpl obj, Object value) {
                obj.setDtListHeadersEO((AipdtEntityImpl) value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(DtListDetailsEOImpl object);

        public abstract void put(DtListDetailsEOImpl object, Object value);

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


    public static final int CLASSID = AttributesEnum.ClassId.index();
    public static final int SUBCLASSID = AttributesEnum.SubclassId.index();
    public static final int COMMODITYID = AttributesEnum.CommodityId.index();
    public static final int PACKSIZE = AttributesEnum.PackSize.index();
    public static final int WAREHOUSEID = AttributesEnum.WarehouseId.index();
    public static final int SUPPLIERID = AttributesEnum.SupplierId.index();
    public static final int STOREID = AttributesEnum.StoreId.index();
    public static final int LISTID = AttributesEnum.ListId.index();
    public static final int ROWID = AttributesEnum.RowID.index();
    public static final int DTLISTHEADERSEO = AttributesEnum.DtListHeadersEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DtListDetailsEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("oracle.retail.apps.aipdt.listcreate.model.entity.DtListDetailsEO");
    }


    /**
     * Gets the attribute value for ClassId, using the alias name ClassId.
     * @return the value of ClassId
     */
    public Number getClassId() {
        return (Number) getAttributeInternal(CLASSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ClassId.
     * @param value value to set the ClassId
     */
    public void setClassId(Number value) {
        setAttributeInternal(CLASSID, value);
    }

    /**
     * Gets the attribute value for SubclassId, using the alias name SubclassId.
     * @return the value of SubclassId
     */
    public Number getSubclassId() {
        return (Number) getAttributeInternal(SUBCLASSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SubclassId.
     * @param value value to set the SubclassId
     */
    public void setSubclassId(Number value) {
        setAttributeInternal(SUBCLASSID, value);
    }

    /**
     * Gets the attribute value for CommodityId, using the alias name CommodityId.
     * @return the value of CommodityId
     */
    public Number getCommodityId() {
        return (Number) getAttributeInternal(COMMODITYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CommodityId.
     * @param value value to set the CommodityId
     */
    public void setCommodityId(Number value) {
        setAttributeInternal(COMMODITYID, value);
    }

    /**
     * Gets the attribute value for PackSize, using the alias name PackSize.
     * @return the value of PackSize
     */
    public Integer getPackSize() {
        return (Integer) getAttributeInternal(PACKSIZE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PackSize.
     * @param value value to set the PackSize
     */
    public void setPackSize(Integer value) {
        setAttributeInternal(PACKSIZE, value);
    }

    /**
     * Gets the attribute value for WarehouseId, using the alias name WarehouseId.
     * @return the value of WarehouseId
     */
    public Number getWarehouseId() {
        return (Number) getAttributeInternal(WAREHOUSEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for WarehouseId.
     * @param value value to set the WarehouseId
     */
    public void setWarehouseId(Number value) {
        setAttributeInternal(WAREHOUSEID, value);
    }

    /**
     * Gets the attribute value for SupplierId, using the alias name SupplierId.
     * @return the value of SupplierId
     */
    public Number getSupplierId() {
        return (Number) getAttributeInternal(SUPPLIERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SupplierId.
     * @param value value to set the SupplierId
     */
    public void setSupplierId(Number value) {
        setAttributeInternal(SUPPLIERID, value);
    }

    /**
     * Gets the attribute value for StoreId, using the alias name StoreId.
     * @return the value of StoreId
     */
    public Number getStoreId() {
        return (Number) getAttributeInternal(STOREID);
    }

    /**
     * Sets <code>value</code> as the attribute value for StoreId.
     * @param value value to set the StoreId
     */
    public void setStoreId(Number value) {
        setAttributeInternal(STOREID, value);
    }

    /**
     * Gets the attribute value for ListId, using the alias name ListId.
     * @return the value of ListId
     */
    public Number getListId() {
        return (Number) getAttributeInternal(LISTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ListId.
     * @param value value to set the ListId
     */
    public void setListId(Number value) {
        setAttributeInternal(LISTID, value);
    }

    /**
     * Gets the attribute value for RowID, using the alias name RowID.
     * @return the value of RowID
     */
    public RowID getRowID() {
        return (RowID) getAttributeInternal(ROWID);
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


    /**
     * @return the associated entity oracle.retail.apps.aipdt.common.adfbc.AipdtEntityImpl.
     */
    public AipdtEntityImpl getDtListHeadersEO() {
        return (AipdtEntityImpl) getAttributeInternal(DTLISTHEADERSEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.retail.apps.aipdt.common.adfbc.AipdtEntityImpl.
     */
    public void setDtListHeadersEO(AipdtEntityImpl value) {
        setAttributeInternal(DTLISTHEADERSEO, value);
    }

    /**
     * @param listId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal listId) {
        return new Key(new Object[] { listId });
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}

