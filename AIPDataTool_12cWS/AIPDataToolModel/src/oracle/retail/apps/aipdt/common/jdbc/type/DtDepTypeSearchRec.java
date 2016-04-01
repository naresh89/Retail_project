
package oracle.retail.apps.aipdt.common.jdbc.type;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.jpub.runtime.MutableStruct;
import oracle.sql.Datum;
import java.sql.SQLException;
import oracle.sql.STRUCT;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.retail.apps.framework.jdbc.DbSchemaResolverFactory;
import oracle.retail.apps.framework.jdbc.OracleTypeAdapter;
/*******************************************************
 * THIS CODE IS AUTO-GENERATED.  DO NOT MODIFY THIS CODE!
 * 
 * Modify the Oracle Type this class was based on and 
 * re-generate the contents of this file using the oracle.retail.apps.framework.jdbc.OracleTypeAdapterGenerator application. 
 * 
 * Generator Version : 1.0
 * Generation Date   : 2016-02-09 16:07:011
 * Oracle Type Name  : DT_DEP_TYPE_SEARCH_REC
 * Owned by          : SYSTEM
 * Requested Schema  : SYSTEM
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:xe
 * Requested DB User : system
 *******************************************************/
public class DtDepTypeSearchRec implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_DEP_TYPE_SEARCH_REC";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int DEPARTMENT_ID_IDX = 0;
    public static final int CLASS_ID_IDX = 1;
    public static final int SUBCLASS_ID_IDX = 2;
    public static final int STYLE_ID_IDX = 3;
    public static final int STYLE_COLOR_ID_IDX = 4;
    public static final int COMMODITY_ID_IDX = 5;
    public static final int SUPPLIER_ID_IDX = 6;
    public static final int STORE_ID_IDX = 7;
    public static final int REGION_ID_IDX = 8;
    public static final int SELECTION_TYPE_IDX = 9;
    public static final int SELECTION_LEVEL_IDX = 10;
    public static final int IS_EXCEPTION_IDX = 11;
    public static final int CREATE_USER_IDX = 12;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {2,12,12,12,12,12,2,12,2,12,2,12,12};
    protected static ORADataFactory[] _factory = new ORADataFactory[13];
    static {
    }
    protected static final DtDepTypeSearchRec _DtDepTypeSearchRecFactory = new DtDepTypeSearchRec();
    public static ORADataFactory getORADataFactory() {
        return _DtDepTypeSearchRecFactory;
    }

    public DtDepTypeSearchRec() {
        _struct = new MutableStruct(new Object[13], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtDepTypeSearchRec o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtDepTypeSearchRec();
        o._struct = new MutableStruct((STRUCT)d, _sqlType, _factory);
        return o;
    }
    public final java.math.BigDecimal  getDepartmentId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(DEPARTMENT_ID_IDX);
    }

    public final void setDepartmentId(java.math.BigDecimal departmentId) throws SQLException 
    { 
        _struct.setAttribute(DEPARTMENT_ID_IDX, departmentId);
    }

    public final java.lang.String  getClassId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(CLASS_ID_IDX);
    }

    public final void setClassId(java.lang.String classId) throws SQLException 
    { 
        _struct.setAttribute(CLASS_ID_IDX, classId);
    }

    public final java.lang.String  getSubclassId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SUBCLASS_ID_IDX);
    }

    public final void setSubclassId(java.lang.String subclassId) throws SQLException 
    { 
        _struct.setAttribute(SUBCLASS_ID_IDX, subclassId);
    }

    public final java.lang.String  getStyleId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STYLE_ID_IDX);
    }

    public final void setStyleId(java.lang.String styleId) throws SQLException 
    { 
        _struct.setAttribute(STYLE_ID_IDX, styleId);
    }

    public final java.lang.String  getStyleColorId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STYLE_COLOR_ID_IDX);
    }

    public final void setStyleColorId(java.lang.String styleColorId) throws SQLException 
    { 
        _struct.setAttribute(STYLE_COLOR_ID_IDX, styleColorId);
    }

    public final java.lang.String  getCommodityId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(COMMODITY_ID_IDX);
    }

    public final void setCommodityId(java.lang.String commodityId) throws SQLException 
    { 
        _struct.setAttribute(COMMODITY_ID_IDX, commodityId);
    }

    public final java.math.BigDecimal  getSupplierId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(SUPPLIER_ID_IDX);
    }

    public final void setSupplierId(java.math.BigDecimal supplierId) throws SQLException 
    { 
        _struct.setAttribute(SUPPLIER_ID_IDX, supplierId);
    }

    public final java.lang.String  getStoreId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STORE_ID_IDX);
    }

    public final void setStoreId(java.lang.String storeId) throws SQLException 
    { 
        _struct.setAttribute(STORE_ID_IDX, storeId);
    }

    public final java.math.BigDecimal  getRegionId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(REGION_ID_IDX);
    }

    public final void setRegionId(java.math.BigDecimal regionId) throws SQLException 
    { 
        _struct.setAttribute(REGION_ID_IDX, regionId);
    }

    public final java.lang.String  getSelectionType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SELECTION_TYPE_IDX);
    }

    public final void setSelectionType(java.lang.String selectionType) throws SQLException 
    { 
        _struct.setAttribute(SELECTION_TYPE_IDX, selectionType);
    }

    public final java.math.BigDecimal  getSelectionLevel() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(SELECTION_LEVEL_IDX);
    }

    public final void setSelectionLevel(java.math.BigDecimal selectionLevel) throws SQLException 
    { 
        _struct.setAttribute(SELECTION_LEVEL_IDX, selectionLevel);
    }

    public final java.lang.String  getIsException() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(IS_EXCEPTION_IDX);
    }

    public final void setIsException(java.lang.String isException) throws SQLException 
    { 
        _struct.setAttribute(IS_EXCEPTION_IDX, isException);
    }

    public final java.lang.String  getCreateUser() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(CREATE_USER_IDX);
    }

    public final void setCreateUser(java.lang.String createUser) throws SQLException 
    { 
        _struct.setAttribute(CREATE_USER_IDX, createUser);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
