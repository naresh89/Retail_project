
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
 * Generation Date   : 2016-01-18 14:38:009
 * Oracle Type Name  : DT_STG_TBL
 * Owned by          : TEST_USER
 * Requested Schema  : TEST_USER
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:orcl
 * Requested DB User : test_user
 *******************************************************/
public class DtStgTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_STG_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtStgTbl _DtStgTblFactory = new DtStgTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtStgTblFactory;
    }
    public DtStgTbl() {
        this((DtStgObj[]) null);
    }
    public DtStgTbl(DtStgObj[] a) {
        _array = new MutableArray(2002, a, DtStgObj.getORADataFactory());
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
        DtStgTbl a = new DtStgTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtStgObj.getORADataFactory());
        return a;
    }

    public DtStgObj[] getArray() throws SQLException {
        return (DtStgObj[]) _array.getObjectArray(new DtStgObj[_array.length()]);
    }

    public DtStgObj[] getArray(long index, int count) throws SQLException {
        return (DtStgObj[]) _array.getObjectArray(index, new DtStgObj[_array.sliceLength(index,count)]);
    }

    public void setArray(DtStgObj[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtStgObj[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtStgObj getElement(long index) throws SQLException {
        return (DtStgObj) _array.getObjectElement(index);
    }

    public void setElement(DtStgObj a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
