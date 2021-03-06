package oracle.retail.apps.aipdt.cnpd.model.view;

import java.math.BigDecimal;

import java.sql.Date;

import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtEntityImpl;
import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 21 11:48:50 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DtGttNonPlanningDaysVORowImpl extends AipdtViewRowImpl {
    public static final int ENTITY_DTGTTNONPLANNINGDAYSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Id {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getId();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setId((BigDecimal) value);
            }
        }
        ,
        TransactionId {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getTransactionId();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setTransactionId((BigDecimal) value);
            }
        }
        ,
        UpdateInd {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getUpdateInd();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setUpdateInd((String) value);
            }
        }
        ,
        Status {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getStatus();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setStatus((String) value);
            }
        }
        ,
        LocType {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getLocType();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setLocType((String) value);
            }
        }
        ,
        LocationId {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getLocationId();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setLocationId((BigDecimal) value);
            }
        }
        ,
        LocationCode {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getLocationCode();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setLocationCode((String) value);
            }
        }
        ,
        LocationDesc {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getLocationDesc();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setLocationDesc((String) value);
            }
        }
        ,
        DayType {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getDayType();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setDayType((String) value);
            }
        }
        ,
        Day {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getDay();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setDay((Date) value);
            }
        }
        ,
        IsException {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getIsException();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setIsException((String) value);
            }
        }
        ,
        CreateUser {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getCreateUser();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setCreateUser((String) value);
            }
        }
        ,
        CreateDate {
            public Object get(DtGttNonPlanningDaysVORowImpl obj) {
                return obj.getCreateDate();
            }

            public void put(DtGttNonPlanningDaysVORowImpl obj, Object value) {
                obj.setCreateDate((Date) value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(DtGttNonPlanningDaysVORowImpl object);

        public abstract void put(DtGttNonPlanningDaysVORowImpl object, Object value);

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
    public static final int ID = AttributesEnum.Id.index();
    public static final int TRANSACTIONID = AttributesEnum.TransactionId.index();
    public static final int UPDATEIND = AttributesEnum.UpdateInd.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int LOCTYPE = AttributesEnum.LocType.index();
    public static final int LOCATIONID = AttributesEnum.LocationId.index();
    public static final int LOCATIONCODE = AttributesEnum.LocationCode.index();
    public static final int LOCATIONDESC = AttributesEnum.LocationDesc.index();
    public static final int DAYTYPE = AttributesEnum.DayType.index();
    public static final int DAY = AttributesEnum.Day.index();
    public static final int ISEXCEPTION = AttributesEnum.IsException.index();
    public static final int CREATEUSER = AttributesEnum.CreateUser.index();
    public static final int CREATEDATE = AttributesEnum.CreateDate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DtGttNonPlanningDaysVORowImpl() {
    }

    /**
     * Gets DtGttNonPlanningDaysEO entity object.
     * @return the DtGttNonPlanningDaysEO
     */
    public AipdtEntityImpl getDtGttNonPlanningDaysEO() {
        return (AipdtEntityImpl) getEntity(ENTITY_DTGTTNONPLANNINGDAYSEO);
    }

    /**
     * Gets the attribute value for ID using the alias name Id.
     * @return the ID
     */
    public BigDecimal getId() {
        return (BigDecimal) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name Id.
     * @param value value to set the ID
     */
    public void setId(BigDecimal value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for TRANSACTION_ID using the alias name TransactionId.
     * @return the TRANSACTION_ID
     */
    public BigDecimal getTransactionId() {
        return (BigDecimal) getAttributeInternal(TRANSACTIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for TRANSACTION_ID using the alias name TransactionId.
     * @param value value to set the TRANSACTION_ID
     */
    public void setTransactionId(BigDecimal value) {
        setAttributeInternal(TRANSACTIONID, value);
    }

    /**
     * Gets the attribute value for UPDATE_IND using the alias name UpdateInd.
     * @return the UPDATE_IND
     */
    public String getUpdateInd() {
        return (String) getAttributeInternal(UPDATEIND);
    }

    /**
     * Sets <code>value</code> as attribute value for UPDATE_IND using the alias name UpdateInd.
     * @param value value to set the UPDATE_IND
     */
    public void setUpdateInd(String value) {
        setAttributeInternal(UPDATEIND, value);
    }

    /**
     * Gets the attribute value for STATUS using the alias name Status.
     * @return the STATUS
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS using the alias name Status.
     * @param value value to set the STATUS
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for LOC_TYPE using the alias name LocType.
     * @return the LOC_TYPE
     */
    public String getLocType() {
        return (String) getAttributeInternal(LOCTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for LOC_TYPE using the alias name LocType.
     * @param value value to set the LOC_TYPE
     */
    public void setLocType(String value) {
        setAttributeInternal(LOCTYPE, value);
    }

    /**
     * Gets the attribute value for LOCATION_ID using the alias name LocationId.
     * @return the LOCATION_ID
     */
    public BigDecimal getLocationId() {
        return (BigDecimal) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_ID using the alias name LocationId.
     * @param value value to set the LOCATION_ID
     */
    public void setLocationId(BigDecimal value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for LOCATION_CODE using the alias name LocationCode.
     * @return the LOCATION_CODE
     */
    public String getLocationCode() {
        return (String) getAttributeInternal(LOCATIONCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_CODE using the alias name LocationCode.
     * @param value value to set the LOCATION_CODE
     */
    public void setLocationCode(String value) {
        setAttributeInternal(LOCATIONCODE, value);
    }

    /**
     * Gets the attribute value for LOCATION_DESC using the alias name LocationDesc.
     * @return the LOCATION_DESC
     */
    public String getLocationDesc() {
        return (String) getAttributeInternal(LOCATIONDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_DESC using the alias name LocationDesc.
     * @param value value to set the LOCATION_DESC
     */
    public void setLocationDesc(String value) {
        setAttributeInternal(LOCATIONDESC, value);
    }

    /**
     * Gets the attribute value for DAY_TYPE using the alias name DayType.
     * @return the DAY_TYPE
     */
    public String getDayType() {
        return (String) getAttributeInternal(DAYTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY_TYPE using the alias name DayType.
     * @param value value to set the DAY_TYPE
     */
    public void setDayType(String value) {
        setAttributeInternal(DAYTYPE, value);
    }

    /**
     * Gets the attribute value for DAY using the alias name Day.
     * @return the DAY
     */
    public Date getDay() {
        return (Date) getAttributeInternal(DAY);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY using the alias name Day.
     * @param value value to set the DAY
     */
    public void setDay(Date value) {
        setAttributeInternal(DAY, value);
    }

    /**
     * Gets the attribute value for IS_EXCEPTION using the alias name IsException.
     * @return the IS_EXCEPTION
     */
    public String getIsException() {
        return (String) getAttributeInternal(ISEXCEPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for IS_EXCEPTION using the alias name IsException.
     * @param value value to set the IS_EXCEPTION
     */
    public void setIsException(String value) {
        setAttributeInternal(ISEXCEPTION, value);
    }

    /**
     * Gets the attribute value for CREATE_USER using the alias name CreateUser.
     * @return the CREATE_USER
     */
    public String getCreateUser() {
        return (String) getAttributeInternal(CREATEUSER);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATE_USER using the alias name CreateUser.
     * @param value value to set the CREATE_USER
     */
    public void setCreateUser(String value) {
        setAttributeInternal(CREATEUSER, value);
    }

    /**
     * Gets the attribute value for CREATE_DATE using the alias name CreateDate.
     * @return the CREATE_DATE
     */
    public Date getCreateDate() {
        return (Date) getAttributeInternal(CREATEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATE_DATE using the alias name CreateDate.
     * @param value value to set the CREATE_DATE
     */
    public void setCreateDate(Date value) {
        setAttributeInternal(CREATEDATE, value);
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

