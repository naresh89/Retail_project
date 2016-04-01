
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
 * Generation Date   : 2016-01-29 10:33:019
 * Oracle Type Name  : DT_NP_SEARCH_REC
 * Owned by          : TEST_USER
 * Requested Schema  : TEST_USER
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:orcl
 * Requested DB User : test_user
 *******************************************************/
public class DtNpSearchRec implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_NP_SEARCH_REC";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int SOURCE_TYPE_IDX = 0;
    public static final int SOURCE_ID_IDX = 1;
    public static final int SOURCE_SEL_TYPE_IDX = 2;
    public static final int DESTINATION_TYPE_IDX = 3;
    public static final int DESTINATION_ID_IDX = 4;
    public static final int DEST_SEL_TYPE_IDX = 5;
    public static final int CREATE_USER_IDX = 6;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {12,12,12,12,12,12,12};
    protected static ORADataFactory[] _factory = new ORADataFactory[7];
    static {
    }
    protected static final DtNpSearchRec _DtNpSearchRecFactory = new DtNpSearchRec();
    public static ORADataFactory getORADataFactory() {
        return _DtNpSearchRecFactory;
    }

    public DtNpSearchRec() {
        _struct = new MutableStruct(new Object[7], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtNpSearchRec o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtNpSearchRec();
        o._struct = new MutableStruct((STRUCT)d, _sqlType, _factory);
        return o;
    }
    public final java.lang.String  getSourceType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SOURCE_TYPE_IDX);
    }

    public final void setSourceType(java.lang.String sourceType) throws SQLException 
    { 
        _struct.setAttribute(SOURCE_TYPE_IDX, sourceType);
    }

    public final java.lang.String  getSourceId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SOURCE_ID_IDX);
    }

    public final void setSourceId(java.lang.String sourceId) throws SQLException 
    { 
        _struct.setAttribute(SOURCE_ID_IDX, sourceId);
    }

    public final java.lang.String  getSourceSelType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SOURCE_SEL_TYPE_IDX);
    }

    public final void setSourceSelType(java.lang.String sourceSelType) throws SQLException 
    { 
        _struct.setAttribute(SOURCE_SEL_TYPE_IDX, sourceSelType);
    }

    public final java.lang.String  getDestinationType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(DESTINATION_TYPE_IDX);
    }

    public final void setDestinationType(java.lang.String destinationType) throws SQLException 
    { 
        _struct.setAttribute(DESTINATION_TYPE_IDX, destinationType);
    }

    public final java.lang.String  getDestinationId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(DESTINATION_ID_IDX);
    }

    public final void setDestinationId(java.lang.String destinationId) throws SQLException 
    { 
        _struct.setAttribute(DESTINATION_ID_IDX, destinationId);
    }

    public final java.lang.String  getDestSelType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(DEST_SEL_TYPE_IDX);
    }

    public final void setDestSelType(java.lang.String destSelType) throws SQLException 
    { 
        _struct.setAttribute(DEST_SEL_TYPE_IDX, destSelType);
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
