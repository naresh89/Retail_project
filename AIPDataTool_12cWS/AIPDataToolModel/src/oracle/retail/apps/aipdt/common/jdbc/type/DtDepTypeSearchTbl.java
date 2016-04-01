
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
 * Generation Date   : 2016-02-09 16:07:012
 * Oracle Type Name  : DT_DEP_TYPE_SEARCH_TBL
 * Owned by          : SYSTEM
 * Requested Schema  : SYSTEM
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:xe
 * Requested DB User : system
 *******************************************************/
public class DtDepTypeSearchTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_DEP_TYPE_SEARCH_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtDepTypeSearchTbl _DtDepTypeSearchTblFactory = new DtDepTypeSearchTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtDepTypeSearchTblFactory;
    }
    public DtDepTypeSearchTbl() {
        this((DtDepTypeSearchRec[])null);
    }
    public DtDepTypeSearchTbl(DtDepTypeSearchRec[] a) {
        _array = new MutableArray(2002, a, DtDepTypeSearchRec.getORADataFactory());
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
        DtDepTypeSearchTbl a = new DtDepTypeSearchTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtDepTypeSearchRec.getORADataFactory());
        return a;
    }

    public DtDepTypeSearchRec[] getArray() throws SQLException {
        return (DtDepTypeSearchRec[])_array.getObjectArray(new DtDepTypeSearchRec[_array.length()]);
    }

    public DtDepTypeSearchRec[] getArray(long index, int count) throws SQLException {
        return (DtDepTypeSearchRec[])_array.getObjectArray(index, new DtDepTypeSearchRec[_array.sliceLength(index,count)]);
    }

    public void setArray(DtDepTypeSearchRec[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtDepTypeSearchRec[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtDepTypeSearchRec getElement(long index) throws SQLException {
        return (DtDepTypeSearchRec)_array.getObjectElement(index);
    }

    public void setElement(DtDepTypeSearchRec a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
