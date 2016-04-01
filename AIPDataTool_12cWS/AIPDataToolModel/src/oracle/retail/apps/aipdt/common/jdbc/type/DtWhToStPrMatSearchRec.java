
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
 * Generation Date   : 2016-03-10 19:24:006
 * Oracle Type Name  : DT_WH_TO_ST_PR_MAT_SEARCH_REC
 * Owned by          : HR
 * Requested Schema  : HR
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:orcl
 * Requested DB User : hr
 *******************************************************/
public class DtWhToStPrMatSearchRec implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_WH_TO_ST_PR_MAT_SEARCH_REC";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int STORE_ID_IDX = 0;
    public static final int CREATE_USER_IDX = 1;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {12,12};
    protected static ORADataFactory[] _factory = new ORADataFactory[2];
    static {
    }
    protected static final DtWhToStPrMatSearchRec _DtWhToStPrMatSearchRecFactory = new DtWhToStPrMatSearchRec();
    public static ORADataFactory getORADataFactory() {
        return _DtWhToStPrMatSearchRecFactory;
    }

    public DtWhToStPrMatSearchRec() {
        _struct = new MutableStruct(new Object[2], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtWhToStPrMatSearchRec o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtWhToStPrMatSearchRec();
        o._struct = new MutableStruct((STRUCT)d, _sqlType, _factory);
        return o;
    }
    public final java.lang.String  getStoreId() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STORE_ID_IDX);
    }

    public final void setStoreId(java.lang.String storeId) throws SQLException 
    { 
        _struct.setAttribute(STORE_ID_IDX, storeId);
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
