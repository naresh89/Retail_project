
package oracle.retail.apps.aipdt.common.jdbc.type;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.jpub.runtime.MutableArray;
import oracle.sql.Datum;
import java.sql.SQLException;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
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
 * Generation Date   : 2016-03-30 18:52:000
 * Oracle Type Name  : DT_RSWH_RC_SEARCH_TBL
 * Owned by          : SYSTEM
 * Requested Schema  : SYSTEM
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:XE
 * Requested DB User : system
 *******************************************************/
public class DtRswhRcSearchTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_RSWH_RC_SEARCH_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtRswhRcSearchTbl _DtRswhRcSearchTblFactory = new DtRswhRcSearchTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtRswhRcSearchTblFactory;
    }
    public DtRswhRcSearchTbl() {
        this((DtRswhRcSearchRec[])null);
    }
    public DtRswhRcSearchTbl(DtRswhRcSearchRec[] a) {
        _array = new MutableArray(2002, a, DtRswhRcSearchRec.getORADataFactory());
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _array.toDatum(c, getSQLTypeName());  
    }
    public int length() throws SQLException {
        return _array.length();
    }

    public int getBaseType() throws SQLException {
        return _array.getBaseType();
    }

    public String getBaseTypeName() throws SQLException {
        return _array.getBaseTypeName();
    }

    public ArrayDescriptor getDescriptor() throws SQLException {
        return _array.getDescriptor();
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        DtRswhRcSearchTbl a = new DtRswhRcSearchTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtRswhRcSearchRec.getORADataFactory());
        return a;
    }

    public DtRswhRcSearchRec[] getArray() throws SQLException {
        return (DtRswhRcSearchRec[])_array.getObjectArray(new DtRswhRcSearchRec[_array.length()]);
    }

    public DtRswhRcSearchRec[] getArray(long index, int count) throws SQLException {
        return (DtRswhRcSearchRec[])_array.getObjectArray(index, new DtRswhRcSearchRec[_array.sliceLength(index,count)]);
    }

    public void setArray(DtRswhRcSearchRec[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtRswhRcSearchRec[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtRswhRcSearchRec getElement(long index) throws SQLException {
        return (DtRswhRcSearchRec)_array.getObjectElement(index);
    }

    public void setElement(DtRswhRcSearchRec a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
