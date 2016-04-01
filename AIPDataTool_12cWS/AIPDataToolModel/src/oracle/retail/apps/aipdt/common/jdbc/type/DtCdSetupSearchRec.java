
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

public class DtCdSetupSearchRec implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_CD_SETUP_SEARCH_REC";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int DEPARTMENT_ID_IDX = 0;
    public static final int SUPPLIER_ID_IDX = 1;
    public static final int SUPP_SEL_TYPE_IDX = 2;
    public static final int REGION_ID_IDX = 3;
    public static final int STORE_ID_IDX = 4;
    public static final int STORE_SEL_TYPE_IDX = 5;
    public static final int IS_EXCEPTION_IDX = 6;
    public static final int CREATE_USER_IDX = 7;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {2,12,12,2,12,12,12,12};
    protected static ORADataFactory[] _factory = new ORADataFactory[8];
    static {
    }
    protected static final DtCdSetupSearchRec _DtCdSetupSearchRecFactory = new DtCdSetupSearchRec();
    public static ORADataFactory getORADataFactory() {
        return _DtCdSetupSearchRecFactory;
    }

    public DtCdSetupSearchRec() {
        _struct = new MutableStruct(new Object[8], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtCdSetupSearchRec o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtCdSetupSearchRec();
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

    public final java.lang.String  getSupplierId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SUPPLIER_ID_IDX);
    }

    public final void setSupplierId(java.lang.String supplierId) throws SQLException 
    { 
        _struct.setAttribute(SUPPLIER_ID_IDX, supplierId);
    }

    public final java.lang.String  getSuppSelType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SUPP_SEL_TYPE_IDX);
    }

    public final void setSuppSelType(java.lang.String suppSelType) throws SQLException 
    { 
        _struct.setAttribute(SUPP_SEL_TYPE_IDX, suppSelType);
    }

    public final java.math.BigDecimal  getRegionId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(REGION_ID_IDX);
    }

    public final void setRegionId(java.math.BigDecimal regionId) throws SQLException 
    { 
        _struct.setAttribute(REGION_ID_IDX, regionId);
    }

    public final java.lang.String  getStoreId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STORE_ID_IDX);
    }

    public final void setStoreId(java.lang.String storeId) throws SQLException 
    { 
        _struct.setAttribute(STORE_ID_IDX, storeId);
    }

    public final java.lang.String  getStoreSelType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STORE_SEL_TYPE_IDX);
    }

    public final void setStoreSelType(java.lang.String storeSelType) throws SQLException 
    { 
        _struct.setAttribute(STORE_SEL_TYPE_IDX, storeSelType);
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
