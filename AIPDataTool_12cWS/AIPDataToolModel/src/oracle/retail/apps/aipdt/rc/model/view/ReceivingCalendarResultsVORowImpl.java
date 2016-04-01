package oracle.retail.apps.aipdt.rc.model.view;

import java.math.BigDecimal;

import oracle.jbo.domain.Date;
import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jan 21 14:17:40 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ReceivingCalendarResultsVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        TransactionId {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getTransactionId();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setTransactionId((BigDecimal) value);
            }
        }
        ,
        IsException {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getIsException();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setIsException((String) value);
            }
        }
        ,
        ProductTypeId {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getProductTypeId();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setProductTypeId((BigDecimal) value);
            }
        }
        ,
        DestinationType {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getDestinationType();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        SelectionType {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getSelectionType();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        DestinationId {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getDestinationId();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ReceivingPattern {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getReceivingPattern();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setReceivingPattern((String) value);
            }
        }
        ,
        StartDate {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getStartDate();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setStartDate((Date) value);
            }
        }
        ,
        EndDate {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getEndDate();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setEndDate((Date) value);
            }
        }
        ,
        CreateUser {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getCreateUser();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setCreateUser((String) value);
            }
        }
        ,
        CreateDate {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getCreateDate();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setCreateDate((Date) value);
            }
        }
        ,
        UpdateUser {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getUpdateUser();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setUpdateUser((String) value);
            }
        }
        ,
        UpdateDate {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getUpdateDate();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setUpdateDate((Date) value);
            }
        }
        ,
        DestinationDesc {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getDestinationDesc();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setDestinationDesc((String) value);
            }
        }
        ,
        Sun {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getSun();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setSun((Boolean) value);
            }
        }
        ,
        Mon {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getMon();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setMon((Boolean) value);
            }
        }
        ,
        Tue {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getTue();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setTue((Boolean) value);
            }
        }
        ,
        Wed {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getWed();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setWed((Boolean) value);
            }
        }
        ,
        Thu {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getThu();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setThu((Boolean) value);
            }
        }
        ,
        Fri {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getFri();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setFri((Boolean) value);
            }
        }
        ,
        Sat {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getSat();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setSat((Boolean) value);
            }
        }
        ,
        Id {
            public Object get(ReceivingCalendarResultsVORowImpl obj) {
                return obj.getId();
            }

            public void put(ReceivingCalendarResultsVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(ReceivingCalendarResultsVORowImpl object);

        public abstract void put(ReceivingCalendarResultsVORowImpl object, Object value);

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
    public static final int TRANSACTIONID = AttributesEnum.TransactionId.index();
    public static final int ISEXCEPTION = AttributesEnum.IsException.index();
    public static final int PRODUCTTYPEID = AttributesEnum.ProductTypeId.index();
    public static final int DESTINATIONTYPE = AttributesEnum.DestinationType.index();
    public static final int SELECTIONTYPE = AttributesEnum.SelectionType.index();
    public static final int DESTINATIONID = AttributesEnum.DestinationId.index();
    public static final int RECEIVINGPATTERN = AttributesEnum.ReceivingPattern.index();
    public static final int STARTDATE = AttributesEnum.StartDate.index();
    public static final int ENDDATE = AttributesEnum.EndDate.index();
    public static final int CREATEUSER = AttributesEnum.CreateUser.index();
    public static final int CREATEDATE = AttributesEnum.CreateDate.index();
    public static final int UPDATEUSER = AttributesEnum.UpdateUser.index();
    public static final int UPDATEDATE = AttributesEnum.UpdateDate.index();
    public static final int DESTINATIONDESC = AttributesEnum.DestinationDesc.index();
    public static final int SUN = AttributesEnum.Sun.index();
    public static final int MON = AttributesEnum.Mon.index();
    public static final int TUE = AttributesEnum.Tue.index();
    public static final int WED = AttributesEnum.Wed.index();
    public static final int THU = AttributesEnum.Thu.index();
    public static final int FRI = AttributesEnum.Fri.index();
    public static final int SAT = AttributesEnum.Sat.index();
    public static final int ID = AttributesEnum.Id.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ReceivingCalendarResultsVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute TransactionId.
     * @return the TransactionId
     */
    public BigDecimal getTransactionId() {
        return (BigDecimal) getAttributeInternal(TRANSACTIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransactionId.
     * @param value value to set the  TransactionId
     */
    public void setTransactionId(BigDecimal value) {
        setAttributeInternal(TRANSACTIONID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute IsException.
     * @return the IsException
     */
    public String getIsException() {
        return (String) getAttributeInternal(ISEXCEPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute IsException.
     * @param value value to set the  IsException
     */
    public void setIsException(String value) {
        setAttributeInternal(ISEXCEPTION, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ProductTypeId.
     * @return the ProductTypeId
     */
    public BigDecimal getProductTypeId() {
        return (BigDecimal) getAttributeInternal(PRODUCTTYPEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ProductTypeId.
     * @param value value to set the  ProductTypeId
     */
    public void setProductTypeId(BigDecimal value) {
        setAttributeInternal(PRODUCTTYPEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DestinationType.
     * @return the DestinationType
     */
    public String getDestinationType() {
        return (String) getAttributeInternal(DESTINATIONTYPE);
    }

    /**
     * Gets the attribute value for the calculated attribute SelectionType.
     * @return the SelectionType
     */
    public String getSelectionType() {
        return (String) getAttributeInternal(SELECTIONTYPE);
    }

    /**
     * Gets the attribute value for the calculated attribute DestinationId.
     * @return the DestinationId
     */
    public BigDecimal getDestinationId() {
        return (BigDecimal) getAttributeInternal(DESTINATIONID);
    }

    /**
     * Gets the attribute value for the calculated attribute ReceivingPattern.
     * @return the ReceivingPattern
     */
    public String getReceivingPattern() {
        //return (String) getAttributeInternal(RECEIVINGPATTERN);
        String pattern = (String) getAttributeInternal(RECEIVINGPATTERN);
        StringBuilder patternBuilder = new StringBuilder();
        Boolean sunday = getSun();
        if(sunday != null && sunday){
            patternBuilder.append("Y");
        }
        else{
            patternBuilder.append("N"); 
        }
        Boolean monday = getMon();
        if(monday != null && monday){
            patternBuilder.append("Y");
        }
        else{
            patternBuilder.append("N"); 
        }
        Boolean tuesday = getTue();
        if(tuesday != null && tuesday){
            patternBuilder.append("Y");
        }
        else{
            patternBuilder.append("N"); 
        }
        Boolean wednesday = getWed();
        if(wednesday != null && wednesday){
            patternBuilder.append("Y");
        }
        else{
            patternBuilder.append("N"); 
        }
        Boolean thursday = getThu();
        if(thursday != null && thursday){
            patternBuilder.append("Y");
        }
        else{
            patternBuilder.append("N"); 
        }
        Boolean friday = getFri();
        if(friday != null && friday){
            patternBuilder.append("Y");
        }
        else{
            patternBuilder.append("N"); 
        }
        Boolean saturday = getSat();
        if(saturday != null && saturday){
            patternBuilder.append("Y");
        }
        else{
            patternBuilder.append("N"); 
        }
        pattern = patternBuilder.toString();
        populateAttribute(RECEIVINGPATTERN, pattern);
        return pattern;
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ReceivingPattern.
     * @param value value to set the  ReceivingPattern
     */
    public void setReceivingPattern(String value) {
        setAttributeInternal(RECEIVINGPATTERN, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StartDate.
     * @return the StartDate
     */
    public Date getStartDate() {
        return (Date) getAttributeInternal(STARTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StartDate.
     * @param value value to set the  StartDate
     */
    public void setStartDate(Date value) {
        setAttributeInternal(STARTDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EndDate.
     * @return the EndDate
     */
    public Date getEndDate() {
        return (Date) getAttributeInternal(ENDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EndDate.
     * @param value value to set the  EndDate
     */
    public void setEndDate(Date value) {
        setAttributeInternal(ENDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreateUser.
     * @return the CreateUser
     */
    public String getCreateUser() {
        return (String) getAttributeInternal(CREATEUSER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreateUser.
     * @param value value to set the  CreateUser
     */
    public void setCreateUser(String value) {
        setAttributeInternal(CREATEUSER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreateDate.
     * @return the CreateDate
     */
    public Date getCreateDate() {
        return (Date) getAttributeInternal(CREATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreateDate.
     * @param value value to set the  CreateDate
     */
    public void setCreateDate(Date value) {
        setAttributeInternal(CREATEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute UpdateUser.
     * @return the UpdateUser
     */
    public String getUpdateUser() {
        return (String) getAttributeInternal(UPDATEUSER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute UpdateUser.
     * @param value value to set the  UpdateUser
     */
    public void setUpdateUser(String value) {
        setAttributeInternal(UPDATEUSER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute UpdateDate.
     * @return the UpdateDate
     */
    public Date getUpdateDate() {
        return (Date) getAttributeInternal(UPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute UpdateDate.
     * @param value value to set the  UpdateDate
     */
    public void setUpdateDate(Date value) {
        setAttributeInternal(UPDATEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DestinationDesc.
     * @return the DestinationDesc
     */
    public String getDestinationDesc() {
        return (String) getAttributeInternal(DESTINATIONDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DestinationDesc.
     * @param value value to set the  DestinationDesc
     */
    public void setDestinationDesc(String value) {
        setAttributeInternal(DESTINATIONDESC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Sun.
     * @return the Sun
     */
    public Boolean getSun() {
        return (Boolean) getAttributeInternal(SUN);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Sun.
     * @param value value to set the  Sun
     */
    public void setSun(Boolean value) {
        setAttributeInternal(SUN, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Mon.
     * @return the Mon
     */
    public Boolean getMon() {
        return (Boolean) getAttributeInternal(MON);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Mon.
     * @param value value to set the  Mon
     */
    public void setMon(Boolean value) {
        setAttributeInternal(MON, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Tue.
     * @return the Tue
     */
    public Boolean getTue() {
        return (Boolean) getAttributeInternal(TUE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Tue.
     * @param value value to set the  Tue
     */
    public void setTue(Boolean value) {
        setAttributeInternal(TUE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Wed.
     * @return the Wed
     */
    public Boolean getWed() {
        return (Boolean) getAttributeInternal(WED);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Wed.
     * @param value value to set the  Wed
     */
    public void setWed(Boolean value) {
        setAttributeInternal(WED, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Thu.
     * @return the Thu
     */
    public Boolean getThu() {
        return (Boolean) getAttributeInternal(THU);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Thu.
     * @param value value to set the  Thu
     */
    public void setThu(Boolean value) {
        setAttributeInternal(THU, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Fri.
     * @return the Fri
     */
    public Boolean getFri() {
        return (Boolean) getAttributeInternal(FRI);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Fri.
     * @param value value to set the  Fri
     */
    public void setFri(Boolean value) {
        setAttributeInternal(FRI, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Sat.
     * @return the Sat
     */
    public Boolean getSat() {
        return (Boolean) getAttributeInternal(SAT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Sat.
     * @param value value to set the  Sat
     */
    public void setSat(Boolean value) {
        setAttributeInternal(SAT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Id.
     * @return the Id
     */
    public BigDecimal getId() {
        return (BigDecimal) getAttributeInternal(ID);
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

