
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
 * Generation Date   : 2016-03-21 10:27:041
 * Oracle Type Name  : DT_NP_DAYS_SEARCH_TBL
 * Owned by          : HR
 * Requested Schema  : HR
 * Requested DB URL  : jdbc:oracle:thin:@LOCALHOST:1521:XE
 * Requested DB User : hr
 *******************************************************/
public class DtNpDaysSearchTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_NP_DAYS_SEARCH_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtNpDaysSearchTbl _DtNpDaysSearchTblFactory = new DtNpDaysSearchTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtNpDaysSearchTblFactory;
    }
    public DtNpDaysSearchTbl() {
        this((DtNpDaysSearchRec[])null);
    }
    public DtNpDaysSearchTbl(DtNpDaysSearchRec[] a) {
        _array = new MutableArray(2002, a, DtNpDaysSearchRec.getORADataFactory());
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
        DtNpDaysSearchTbl a = new DtNpDaysSearchTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtNpDaysSearchRec.getORADataFactory());
        return a;
    }

    public DtNpDaysSearchRec[] getArray() throws SQLException {
        return (DtNpDaysSearchRec[])_array.getObjectArray(new DtNpDaysSearchRec[_array.length()]);
    }

    public DtNpDaysSearchRec[] getArray(long index, int count) throws SQLException {
        return (DtNpDaysSearchRec[])_array.getObjectArray(index, new DtNpDaysSearchRec[_array.sliceLength(index,count)]);
    }

    public void setArray(DtNpDaysSearchRec[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtNpDaysSearchRec[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtNpDaysSearchRec getElement(long index) throws SQLException {
        return (DtNpDaysSearchRec)_array.getObjectElement(index);
    }

    public void setElement(DtNpDaysSearchRec a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
