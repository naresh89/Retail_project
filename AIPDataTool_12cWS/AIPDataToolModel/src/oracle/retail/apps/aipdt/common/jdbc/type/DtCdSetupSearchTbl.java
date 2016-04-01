
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

public class DtCdSetupSearchTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_CD_SETUP_SEARCH_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtCdSetupSearchTbl _DtCdSetupSearchTblFactory = new DtCdSetupSearchTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtCdSetupSearchTblFactory;
    }
    public DtCdSetupSearchTbl() {
        this((DtCdSetupSearchRec[])null);
    }
    public DtCdSetupSearchTbl(DtCdSetupSearchRec[] a) {
        _array = new MutableArray(2002, a, DtCdSetupSearchRec.getORADataFactory());
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
        DtCdSetupSearchTbl a = new DtCdSetupSearchTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtCdSetupSearchRec.getORADataFactory());
        return a;
    }

    public DtCdSetupSearchRec[] getArray() throws SQLException {
        return (DtCdSetupSearchRec[])_array.getObjectArray(new DtCdSetupSearchRec[_array.length()]);
    }

    public DtCdSetupSearchRec[] getArray(long index, int count) throws SQLException {
        return (DtCdSetupSearchRec[])_array.getObjectArray(index, new DtCdSetupSearchRec[_array.sliceLength(index,count)]);
    }

    public void setArray(DtCdSetupSearchRec[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtCdSetupSearchRec[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtCdSetupSearchRec getElement(long index) throws SQLException {
        return (DtCdSetupSearchRec)_array.getObjectElement(index);
    }

    public void setElement(DtCdSetupSearchRec a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
