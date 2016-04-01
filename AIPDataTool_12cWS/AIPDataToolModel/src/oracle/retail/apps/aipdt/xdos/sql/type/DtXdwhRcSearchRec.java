
package oracle.retail.apps.aipdt.xdos.sql.type;
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
 * Generation Date   : 2016-03-15 19:10:004
 * Oracle Type Name  : DT_XDWH_RC_SEARCH_REC
 * Owned by          : TEST_USER
 * Requested Schema  : TEST_USER
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:orcl
 * Requested DB User : test_user
 *******************************************************/
public class DtXdwhRcSearchRec implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_XDWH_RC_SEARCH_REC";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int DEPARTMENT_ID_IDX = 0;
    public static final int SUPPLIER_ID_IDX = 1;
    public static final int STOCKING_POINT_ID_IDX = 2;
    public static final int CLASS_ID_IDX = 3;
    public static final int SUBCLASS_ID_IDX = 4;
    public static final int STYLE_ID_IDX = 5;
    public static final int STYLE_COLOR_ID_IDX = 6;
    public static final int COMMODITY_ID_IDX = 7;
    public static final int STORE_ID_IDX = 8;
    public static final int REGION_ID_IDX = 9;
    public static final int SELECTION_LEVEL_IDX = 10;
    public static final int CREATE_USER_IDX = 11;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {2,2,2,12,12,12,12,12,12,2,2,12};
    protected static ORADataFactory[] _factory = new ORADataFactory[12];
    static {
    }
    protected static final DtXdwhRcSearchRec _DtXdwhRcSearchRecFactory = new DtXdwhRcSearchRec();
    public static ORADataFactory getORADataFactory() {
        return _DtXdwhRcSearchRecFactory;
    }

    public DtXdwhRcSearchRec() {
        _struct = new MutableStruct(new Object[12], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtXdwhRcSearchRec o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtXdwhRcSearchRec();
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

    public final java.math.BigDecimal  getSupplierId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(SUPPLIER_ID_IDX);
    }

    public final void setSupplierId(java.math.BigDecimal supplierId) throws SQLException 
    { 
        _struct.setAttribute(SUPPLIER_ID_IDX, supplierId);
    }

    public final java.math.BigDecimal  getStockingPointId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(STOCKING_POINT_ID_IDX);
    }

    public final void setStockingPointId(java.math.BigDecimal stockingPointId) throws SQLException 
    { 
        _struct.setAttribute(STOCKING_POINT_ID_IDX, stockingPointId);
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

    public final java.math.BigDecimal  getSelectionLevel() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(SELECTION_LEVEL_IDX);
    }

    public final void setSelectionLevel(java.math.BigDecimal selectionLevel) throws SQLException 
    { 
        _struct.setAttribute(SELECTION_LEVEL_IDX, selectionLevel);
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
