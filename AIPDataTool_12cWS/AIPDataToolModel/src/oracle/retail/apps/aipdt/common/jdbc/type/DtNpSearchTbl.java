
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
 * Generation Date   : 2016-01-29 10:33:019
 * Oracle Type Name  : DT_NP_SEARCH_TBL
 * Owned by          : TEST_USER
 * Requested Schema  : TEST_USER
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:orcl
 * Requested DB User : test_user
 *******************************************************/
public class DtNpSearchTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_NP_SEARCH_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtNpSearchTbl _DtNpSearchTblFactory = new DtNpSearchTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtNpSearchTblFactory;
    }
    public DtNpSearchTbl() {
        this((DtNpSearchRec[])null);
    }
    public DtNpSearchTbl(DtNpSearchRec[] a) {
        _array = new MutableArray(2002, a, DtNpSearchRec.getORADataFactory());
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
        DtNpSearchTbl a = new DtNpSearchTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtNpSearchRec.getORADataFactory());
        return a;
    }

    public DtNpSearchRec[] getArray() throws SQLException {
        return (DtNpSearchRec[])_array.getObjectArray(new DtNpSearchRec[_array.length()]);
    }

    public DtNpSearchRec[] getArray(long index, int count) throws SQLException {
        return (DtNpSearchRec[])_array.getObjectArray(index, new DtNpSearchRec[_array.sliceLength(index,count)]);
    }

    public void setArray(DtNpSearchRec[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtNpSearchRec[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtNpSearchRec getElement(long index) throws SQLException {
        return (DtNpSearchRec)_array.getObjectElement(index);
    }

    public void setElement(DtNpSearchRec a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
