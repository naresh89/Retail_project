package oracle.retail.apps.aipdt.dt.model.view;

import java.math.BigDecimal;

import java.sql.Date;

import oracle.jbo.RowSet;
import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtEntityImpl;
import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 11 18:11:39 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DeploymentTypeResultVORowImpl extends AipdtViewRowImpl {
    public static final int ENTITY_DEPLOYMENTTYPERESULTEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Id {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setId((BigDecimal) value);
            }
        }
        ,
        TransactionId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getTransactionId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setTransactionId((BigDecimal) value);
            }
        }
        ,
        UpdateInd {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getUpdateInd();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setUpdateInd((String) value);
            }
        }
        ,
        DepartmentId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getDepartmentId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setDepartmentId((BigDecimal) value);
            }
        }
        ,
        DepartmentCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getDepartmentCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setDepartmentCode((String) value);
            }
        }
        ,
        DepartmentDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getDepartmentDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setDepartmentDesc((String) value);
            }
        }
        ,
        ClassId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getClassId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setClassId((BigDecimal) value);
            }
        }
        ,
        ClassCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getClassCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setClassCode((String) value);
            }
        }
        ,
        ClassDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getClassDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setClassDesc((String) value);
            }
        }
        ,
        SubclassId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSubclassId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSubclassId((BigDecimal) value);
            }
        }
        ,
        SubclassCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSubclassCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSubclassCode((String) value);
            }
        }
        ,
        SubclassDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSubclassDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSubclassDesc((String) value);
            }
        }
        ,
        StyleId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStyleId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStyleId((BigDecimal) value);
            }
        }
        ,
        StyleCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStyleCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStyleCode((String) value);
            }
        }
        ,
        StyleDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStyleDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStyleDesc((String) value);
            }
        }
        ,
        StyleColorId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStyleColorId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStyleColorId((BigDecimal) value);
            }
        }
        ,
        StyleColorCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStyleColorCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStyleColorCode((String) value);
            }
        }
        ,
        StyleColorDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStyleColorDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStyleColorDesc((String) value);
            }
        }
        ,
        CommodityId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getCommodityId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setCommodityId((BigDecimal) value);
            }
        }
        ,
        CommodityCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getCommodityCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setCommodityCode((String) value);
            }
        }
        ,
        CommodityDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getCommodityDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setCommodityDesc((String) value);
            }
        }
        ,
        SupplierId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSupplierId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSupplierId((BigDecimal) value);
            }
        }
        ,
        SupplierCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSupplierCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSupplierCode((String) value);
            }
        }
        ,
        SupplierDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSupplierDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSupplierDesc((String) value);
            }
        }
        ,
        StoreId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStoreId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStoreId((BigDecimal) value);
            }
        }
        ,
        StoreCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStoreCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStoreCode((String) value);
            }
        }
        ,
        StoreDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStoreDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStoreDesc((String) value);
            }
        }
        ,
        RegionId {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getRegionId();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setRegionId((BigDecimal) value);
            }
        }
        ,
        RegionCode {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getRegionCode();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setRegionCode((String) value);
            }
        }
        ,
        RegionDesc {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getRegionDesc();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setRegionDesc((String) value);
            }
        }
        ,
        SelectionType {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSelectionType();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSelectionType((String) value);
            }
        }
        ,
        SelectionLevel {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getSelectionLevel();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setSelectionLevel((Integer) value);
            }
        }
        ,
        IsException {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getIsException();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setIsException((String) value);
            }
        }
        ,
        DeploymentType {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getDeploymentType();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setDeploymentType((String) value);
            }
        }
        ,
        StartDate {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getStartDate();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setStartDate((Date) value);
            }
        }
        ,
        EndDate {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getEndDate();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setEndDate((Date) value);
            }
        }
        ,
        CreateUser {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getCreateUser();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setCreateUser((String) value);
            }
        }
        ,
        CreateDate {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getCreateDate();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setCreateDate((Date) value);
            }
        }
        ,
        DtLookupCodesVO1 {
            public Object get(DeploymentTypeResultVORowImpl obj) {
                return obj.getDtLookupCodesVO1();
            }

            public void put(DeploymentTypeResultVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(DeploymentTypeResultVORowImpl object);

        public abstract void put(DeploymentTypeResultVORowImpl object, Object value);

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
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int DEPARTMENTCODE = AttributesEnum.DepartmentCode.index();
    public static final int DEPARTMENTDESC = AttributesEnum.DepartmentDesc.index();
    public static final int CLASSID = AttributesEnum.ClassId.index();
    public static final int CLASSCODE = AttributesEnum.ClassCode.index();
    public static final int CLASSDESC = AttributesEnum.ClassDesc.index();
    public static final int SUBCLASSID = AttributesEnum.SubclassId.index();
    public static final int SUBCLASSCODE = AttributesEnum.SubclassCode.index();
    public static final int SUBCLASSDESC = AttributesEnum.SubclassDesc.index();
    public static final int STYLEID = AttributesEnum.StyleId.index();
    public static final int STYLECODE = AttributesEnum.StyleCode.index();
    public static final int STYLEDESC = AttributesEnum.StyleDesc.index();
    public static final int STYLECOLORID = AttributesEnum.StyleColorId.index();
    public static final int STYLECOLORCODE = AttributesEnum.StyleColorCode.index();
    public static final int STYLECOLORDESC = AttributesEnum.StyleColorDesc.index();
    public static final int COMMODITYID = AttributesEnum.CommodityId.index();
    public static final int COMMODITYCODE = AttributesEnum.CommodityCode.index();
    public static final int COMMODITYDESC = AttributesEnum.CommodityDesc.index();
    public static final int SUPPLIERID = AttributesEnum.SupplierId.index();
    public static final int SUPPLIERCODE = AttributesEnum.SupplierCode.index();
    public static final int SUPPLIERDESC = AttributesEnum.SupplierDesc.index();
    public static final int STOREID = AttributesEnum.StoreId.index();
    public static final int STORECODE = AttributesEnum.StoreCode.index();
    public static final int STOREDESC = AttributesEnum.StoreDesc.index();
    public static final int REGIONID = AttributesEnum.RegionId.index();
    public static final int REGIONCODE = AttributesEnum.RegionCode.index();
    public static final int REGIONDESC = AttributesEnum.RegionDesc.index();
    public static final int SELECTIONTYPE = AttributesEnum.SelectionType.index();
    public static final int SELECTIONLEVEL = AttributesEnum.SelectionLevel.index();
    public static final int ISEXCEPTION = AttributesEnum.IsException.index();
    public static final int DEPLOYMENTTYPE = AttributesEnum.DeploymentType.index();
    public static final int STARTDATE = AttributesEnum.StartDate.index();
    public static final int ENDDATE = AttributesEnum.EndDate.index();
    public static final int CREATEUSER = AttributesEnum.CreateUser.index();
    public static final int CREATEDATE = AttributesEnum.CreateDate.index();
    public static final int DTLOOKUPCODESVO1 = AttributesEnum.DtLookupCodesVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DeploymentTypeResultVORowImpl() {
    }

    /**
     * Gets DeploymentTypeResultEO entity object.
     * @return the DeploymentTypeResultEO
     */
    public AipdtEntityImpl getDeploymentTypeResultEO() {
        return (AipdtEntityImpl) getEntity(ENTITY_DEPLOYMENTTYPERESULTEO);
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
     * Gets the attribute value for DEPARTMENT_ID using the alias name DepartmentId.
     * @return the DEPARTMENT_ID
     */
    public BigDecimal getDepartmentId() {
        return (BigDecimal) getAttributeInternal(DEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for DEPARTMENT_ID using the alias name DepartmentId.
     * @param value value to set the DEPARTMENT_ID
     */
    public void setDepartmentId(BigDecimal value) {
        setAttributeInternal(DEPARTMENTID, value);
    }

    /**
     * Gets the attribute value for DEPARTMENT_CODE using the alias name DepartmentCode.
     * @return the DEPARTMENT_CODE
     */
    public String getDepartmentCode() {
        return (String) getAttributeInternal(DEPARTMENTCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for DEPARTMENT_CODE using the alias name DepartmentCode.
     * @param value value to set the DEPARTMENT_CODE
     */
    public void setDepartmentCode(String value) {
        setAttributeInternal(DEPARTMENTCODE, value);
    }

    /**
     * Gets the attribute value for DEPARTMENT_DESC using the alias name DepartmentDesc.
     * @return the DEPARTMENT_DESC
     */
    public String getDepartmentDesc() {
        return (String) getAttributeInternal(DEPARTMENTDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for DEPARTMENT_DESC using the alias name DepartmentDesc.
     * @param value value to set the DEPARTMENT_DESC
     */
    public void setDepartmentDesc(String value) {
        setAttributeInternal(DEPARTMENTDESC, value);
    }

    /**
     * Gets the attribute value for CLASS_ID using the alias name ClassId.
     * @return the CLASS_ID
     */
    public BigDecimal getClassId() {
        return (BigDecimal) getAttributeInternal(CLASSID);
    }

    /**
     * Sets <code>value</code> as attribute value for CLASS_ID using the alias name ClassId.
     * @param value value to set the CLASS_ID
     */
    public void setClassId(BigDecimal value) {
        setAttributeInternal(CLASSID, value);
    }

    /**
     * Gets the attribute value for CLASS_CODE using the alias name ClassCode.
     * @return the CLASS_CODE
     */
    public String getClassCode() {
        return (String) getAttributeInternal(CLASSCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for CLASS_CODE using the alias name ClassCode.
     * @param value value to set the CLASS_CODE
     */
    public void setClassCode(String value) {
        setAttributeInternal(CLASSCODE, value);
    }

    /**
     * Gets the attribute value for CLASS_DESC using the alias name ClassDesc.
     * @return the CLASS_DESC
     */
    public String getClassDesc() {
        return (String) getAttributeInternal(CLASSDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for CLASS_DESC using the alias name ClassDesc.
     * @param value value to set the CLASS_DESC
     */
    public void setClassDesc(String value) {
        setAttributeInternal(CLASSDESC, value);
    }

    /**
     * Gets the attribute value for SUBCLASS_ID using the alias name SubclassId.
     * @return the SUBCLASS_ID
     */
    public BigDecimal getSubclassId() {
        return (BigDecimal) getAttributeInternal(SUBCLASSID);
    }

    /**
     * Sets <code>value</code> as attribute value for SUBCLASS_ID using the alias name SubclassId.
     * @param value value to set the SUBCLASS_ID
     */
    public void setSubclassId(BigDecimal value) {
        setAttributeInternal(SUBCLASSID, value);
    }

    /**
     * Gets the attribute value for SUBCLASS_CODE using the alias name SubclassCode.
     * @return the SUBCLASS_CODE
     */
    public String getSubclassCode() {
        return (String) getAttributeInternal(SUBCLASSCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for SUBCLASS_CODE using the alias name SubclassCode.
     * @param value value to set the SUBCLASS_CODE
     */
    public void setSubclassCode(String value) {
        setAttributeInternal(SUBCLASSCODE, value);
    }

    /**
     * Gets the attribute value for SUBCLASS_DESC using the alias name SubclassDesc.
     * @return the SUBCLASS_DESC
     */
    public String getSubclassDesc() {
        return (String) getAttributeInternal(SUBCLASSDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for SUBCLASS_DESC using the alias name SubclassDesc.
     * @param value value to set the SUBCLASS_DESC
     */
    public void setSubclassDesc(String value) {
        setAttributeInternal(SUBCLASSDESC, value);
    }

    /**
     * Gets the attribute value for STYLE_ID using the alias name StyleId.
     * @return the STYLE_ID
     */
    public BigDecimal getStyleId() {
        return (BigDecimal) getAttributeInternal(STYLEID);
    }

    /**
     * Sets <code>value</code> as attribute value for STYLE_ID using the alias name StyleId.
     * @param value value to set the STYLE_ID
     */
    public void setStyleId(BigDecimal value) {
        setAttributeInternal(STYLEID, value);
    }

    /**
     * Gets the attribute value for STYLE_CODE using the alias name StyleCode.
     * @return the STYLE_CODE
     */
    public String getStyleCode() {
        return (String) getAttributeInternal(STYLECODE);
    }

    /**
     * Sets <code>value</code> as attribute value for STYLE_CODE using the alias name StyleCode.
     * @param value value to set the STYLE_CODE
     */
    public void setStyleCode(String value) {
        setAttributeInternal(STYLECODE, value);
    }

    /**
     * Gets the attribute value for STYLE_DESC using the alias name StyleDesc.
     * @return the STYLE_DESC
     */
    public String getStyleDesc() {
        return (String) getAttributeInternal(STYLEDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for STYLE_DESC using the alias name StyleDesc.
     * @param value value to set the STYLE_DESC
     */
    public void setStyleDesc(String value) {
        setAttributeInternal(STYLEDESC, value);
    }

    /**
     * Gets the attribute value for STYLE_COLOR_ID using the alias name StyleColorId.
     * @return the STYLE_COLOR_ID
     */
    public BigDecimal getStyleColorId() {
        return (BigDecimal) getAttributeInternal(STYLECOLORID);
    }

    /**
     * Sets <code>value</code> as attribute value for STYLE_COLOR_ID using the alias name StyleColorId.
     * @param value value to set the STYLE_COLOR_ID
     */
    public void setStyleColorId(BigDecimal value) {
        setAttributeInternal(STYLECOLORID, value);
    }

    /**
     * Gets the attribute value for STYLE_COLOR_CODE using the alias name StyleColorCode.
     * @return the STYLE_COLOR_CODE
     */
    public String getStyleColorCode() {
        return (String) getAttributeInternal(STYLECOLORCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for STYLE_COLOR_CODE using the alias name StyleColorCode.
     * @param value value to set the STYLE_COLOR_CODE
     */
    public void setStyleColorCode(String value) {
        setAttributeInternal(STYLECOLORCODE, value);
    }

    /**
     * Gets the attribute value for STYLE_COLOR_DESC using the alias name StyleColorDesc.
     * @return the STYLE_COLOR_DESC
     */
    public String getStyleColorDesc() {
        return (String) getAttributeInternal(STYLECOLORDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for STYLE_COLOR_DESC using the alias name StyleColorDesc.
     * @param value value to set the STYLE_COLOR_DESC
     */
    public void setStyleColorDesc(String value) {
        setAttributeInternal(STYLECOLORDESC, value);
    }

    /**
     * Gets the attribute value for COMMODITY_ID using the alias name CommodityId.
     * @return the COMMODITY_ID
     */
    public BigDecimal getCommodityId() {
        return (BigDecimal) getAttributeInternal(COMMODITYID);
    }

    /**
     * Sets <code>value</code> as attribute value for COMMODITY_ID using the alias name CommodityId.
     * @param value value to set the COMMODITY_ID
     */
    public void setCommodityId(BigDecimal value) {
        setAttributeInternal(COMMODITYID, value);
    }

    /**
     * Gets the attribute value for COMMODITY_CODE using the alias name CommodityCode.
     * @return the COMMODITY_CODE
     */
    public String getCommodityCode() {
        return (String) getAttributeInternal(COMMODITYCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for COMMODITY_CODE using the alias name CommodityCode.
     * @param value value to set the COMMODITY_CODE
     */
    public void setCommodityCode(String value) {
        setAttributeInternal(COMMODITYCODE, value);
    }

    /**
     * Gets the attribute value for COMMODITY_DESC using the alias name CommodityDesc.
     * @return the COMMODITY_DESC
     */
    public String getCommodityDesc() {
        return (String) getAttributeInternal(COMMODITYDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for COMMODITY_DESC using the alias name CommodityDesc.
     * @param value value to set the COMMODITY_DESC
     */
    public void setCommodityDesc(String value) {
        setAttributeInternal(COMMODITYDESC, value);
    }

    /**
     * Gets the attribute value for SUPPLIER_ID using the alias name SupplierId.
     * @return the SUPPLIER_ID
     */
    public BigDecimal getSupplierId() {
        return (BigDecimal) getAttributeInternal(SUPPLIERID);
    }

    /**
     * Sets <code>value</code> as attribute value for SUPPLIER_ID using the alias name SupplierId.
     * @param value value to set the SUPPLIER_ID
     */
    public void setSupplierId(BigDecimal value) {
        setAttributeInternal(SUPPLIERID, value);
    }

    /**
     * Gets the attribute value for SUPPLIER_CODE using the alias name SupplierCode.
     * @return the SUPPLIER_CODE
     */
    public String getSupplierCode() {
        return (String) getAttributeInternal(SUPPLIERCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for SUPPLIER_CODE using the alias name SupplierCode.
     * @param value value to set the SUPPLIER_CODE
     */
    public void setSupplierCode(String value) {
        setAttributeInternal(SUPPLIERCODE, value);
    }

    /**
     * Gets the attribute value for SUPPLIER_DESC using the alias name SupplierDesc.
     * @return the SUPPLIER_DESC
     */
    public String getSupplierDesc() {
        return (String) getAttributeInternal(SUPPLIERDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for SUPPLIER_DESC using the alias name SupplierDesc.
     * @param value value to set the SUPPLIER_DESC
     */
    public void setSupplierDesc(String value) {
        setAttributeInternal(SUPPLIERDESC, value);
    }

    /**
     * Gets the attribute value for STORE_ID using the alias name StoreId.
     * @return the STORE_ID
     */
    public BigDecimal getStoreId() {
        return (BigDecimal) getAttributeInternal(STOREID);
    }

    /**
     * Sets <code>value</code> as attribute value for STORE_ID using the alias name StoreId.
     * @param value value to set the STORE_ID
     */
    public void setStoreId(BigDecimal value) {
        setAttributeInternal(STOREID, value);
    }

    /**
     * Gets the attribute value for STORE_CODE using the alias name StoreCode.
     * @return the STORE_CODE
     */
    public String getStoreCode() {
        return (String) getAttributeInternal(STORECODE);
    }

    /**
     * Sets <code>value</code> as attribute value for STORE_CODE using the alias name StoreCode.
     * @param value value to set the STORE_CODE
     */
    public void setStoreCode(String value) {
        setAttributeInternal(STORECODE, value);
    }

    /**
     * Gets the attribute value for STORE_DESC using the alias name StoreDesc.
     * @return the STORE_DESC
     */
    public String getStoreDesc() {
        return (String) getAttributeInternal(STOREDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for STORE_DESC using the alias name StoreDesc.
     * @param value value to set the STORE_DESC
     */
    public void setStoreDesc(String value) {
        setAttributeInternal(STOREDESC, value);
    }

    /**
     * Gets the attribute value for REGION_ID using the alias name RegionId.
     * @return the REGION_ID
     */
    public BigDecimal getRegionId() {
        return (BigDecimal) getAttributeInternal(REGIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for REGION_ID using the alias name RegionId.
     * @param value value to set the REGION_ID
     */
    public void setRegionId(BigDecimal value) {
        setAttributeInternal(REGIONID, value);
    }

    /**
     * Gets the attribute value for REGION_CODE using the alias name RegionCode.
     * @return the REGION_CODE
     */
    public String getRegionCode() {
        return (String) getAttributeInternal(REGIONCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for REGION_CODE using the alias name RegionCode.
     * @param value value to set the REGION_CODE
     */
    public void setRegionCode(String value) {
        setAttributeInternal(REGIONCODE, value);
    }

    /**
     * Gets the attribute value for REGION_DESC using the alias name RegionDesc.
     * @return the REGION_DESC
     */
    public String getRegionDesc() {
        return (String) getAttributeInternal(REGIONDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for REGION_DESC using the alias name RegionDesc.
     * @param value value to set the REGION_DESC
     */
    public void setRegionDesc(String value) {
        setAttributeInternal(REGIONDESC, value);
    }

    /**
     * Gets the attribute value for SELECTION_TYPE using the alias name SelectionType.
     * @return the SELECTION_TYPE
     */
    public String getSelectionType() {
        return (String) getAttributeInternal(SELECTIONTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for SELECTION_TYPE using the alias name SelectionType.
     * @param value value to set the SELECTION_TYPE
     */
    public void setSelectionType(String value) {
        setAttributeInternal(SELECTIONTYPE, value);
    }

    /**
     * Gets the attribute value for SELECTION_LEVEL using the alias name SelectionLevel.
     * @return the SELECTION_LEVEL
     */
    public Integer getSelectionLevel() {
        return (Integer) getAttributeInternal(SELECTIONLEVEL);
    }

    /**
     * Sets <code>value</code> as attribute value for SELECTION_LEVEL using the alias name SelectionLevel.
     * @param value value to set the SELECTION_LEVEL
     */
    public void setSelectionLevel(Integer value) {
        setAttributeInternal(SELECTIONLEVEL, value);
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
     * Gets the attribute value for DEPLOYMENT_TYPE using the alias name DeploymentType.
     * @return the DEPLOYMENT_TYPE
     */
    public String getDeploymentType() {
        return (String) getAttributeInternal(DEPLOYMENTTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for DEPLOYMENT_TYPE using the alias name DeploymentType.
     * @param value value to set the DEPLOYMENT_TYPE
     */
    public void setDeploymentType(String value) {
        setAttributeInternal(DEPLOYMENTTYPE, value);
    }

    /**
     * Gets the attribute value for START_DATE using the alias name StartDate.
     * @return the START_DATE
     */
    public Date getStartDate() {
        return (Date) getAttributeInternal(STARTDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for START_DATE using the alias name StartDate.
     * @param value value to set the START_DATE
     */
    public void setStartDate(Date value) {
        setAttributeInternal(STARTDATE, value);
    }

    /**
     * Gets the attribute value for END_DATE using the alias name EndDate.
     * @return the END_DATE
     */
    public Date getEndDate() {
        return (Date) getAttributeInternal(ENDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for END_DATE using the alias name EndDate.
     * @param value value to set the END_DATE
     */
    public void setEndDate(Date value) {
        setAttributeInternal(ENDDATE, value);
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
     * Gets the view accessor <code>RowSet</code> DtLookupCodesVO1.
     */
    public RowSet getDtLookupCodesVO1() {
        return (RowSet) getAttributeInternal(DTLOOKUPCODESVO1);
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

