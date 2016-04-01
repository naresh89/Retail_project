
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
 * Generation Date   : 2016-02-11 09:15:043
 * Oracle Type Name  : DT_OOSS_SEARCH_TBL
 * Owned by          : SYSTEM
 * Requested Schema  : SYSTEM
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:xe
 * Requested DB User : system
 *******************************************************/
public class DtOossSearchTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_OOSS_SEARCH_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtOossSearchTbl _DtOossSearchTblFactory = new DtOossSearchTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtOossSearchTblFactory;
    }
    public DtOossSearchTbl() {
        this((DtOossSearchRec[])null);
    }
    public DtOossSearchTbl(DtOossSearchRec[] a) {
        _array = new MutableArray(2002, a, DtOossSearchRec.getORADataFactory());
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
        DtOossSearchTbl a = new DtOossSearchTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtOossSearchRec.getORADataFactory());
        return a;
    }

    public DtOossSearchRec[] getArray() throws SQLException {
        return (DtOossSearchRec[])_array.getObjectArray(new DtOossSearchRec[_array.length()]);
    }

    public DtOossSearchRec[] getArray(long index, int count) throws SQLException {
        return (DtOossSearchRec[])_array.getObjectArray(index, new DtOossSearchRec[_array.sliceLength(index,count)]);
    }

    public void setArray(DtOossSearchRec[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtOossSearchRec[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtOossSearchRec getElement(long index) throws SQLException {
        return (DtOossSearchRec)_array.getObjectElement(index);
    }

    public void setElement(DtOossSearchRec a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
