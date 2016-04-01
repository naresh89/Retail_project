
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
 * Generation Date   : 2016-03-21 10:27:041
 * Oracle Type Name  : DT_NP_DAYS_SEARCH_REC
 * Owned by          : HR
 * Requested Schema  : HR
 * Requested DB URL  : jdbc:oracle:thin:@LOCALHOST:1521:XE
 * Requested DB User : hr
 *******************************************************/
public class DtNpDaysSearchRec implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_NP_DAYS_SEARCH_REC";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int LOC_TYPE_IDX = 0;
    public static final int LOCATION_ID_IDX = 1;
    public static final int DAY_TYPE_IDX = 2;
    public static final int IS_EXCEPTION_IDX = 3;
    public static final int CREATE_USER_IDX = 4;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {12,12,12,12,12};
    protected static ORADataFactory[] _factory = new ORADataFactory[5];
    static {
    }
    protected static final DtNpDaysSearchRec _DtNpDaysSearchRecFactory = new DtNpDaysSearchRec();
    public static ORADataFactory getORADataFactory() {
        return _DtNpDaysSearchRecFactory;
    }

    public DtNpDaysSearchRec() {
        _struct = new MutableStruct(new Object[5], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtNpDaysSearchRec o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtNpDaysSearchRec();
        o._struct = new MutableStruct((STRUCT)d, _sqlType, _factory);
        return o;
    }
    public final java.lang.String  getLocType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(LOC_TYPE_IDX);
    }

    public final void setLocType(java.lang.String locType) throws SQLException 
    { 
        _struct.setAttribute(LOC_TYPE_IDX, locType);
    }

    public final java.lang.String  getLocationId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(LOCATION_ID_IDX);
    }

    public final void setLocationId(java.lang.String locationId) throws SQLException 
    { 
        _struct.setAttribute(LOCATION_ID_IDX, locationId);
    }

    public final java.lang.String  getDayType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(DAY_TYPE_IDX);
    }

    public final void setDayType(java.lang.String dayType) throws SQLException 
    { 
        _struct.setAttribute(DAY_TYPE_IDX, dayType);
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
