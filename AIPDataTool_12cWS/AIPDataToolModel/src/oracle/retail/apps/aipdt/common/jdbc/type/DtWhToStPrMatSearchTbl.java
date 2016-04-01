
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
 * Generation Date   : 2016-03-10 19:24:006
 * Oracle Type Name  : DT_WH_TO_ST_PR_MAT_SEARCH_TBL
 * Owned by          : HR
 * Requested Schema  : HR
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:orcl
 * Requested DB User : hr
 *******************************************************/
public class DtWhToStPrMatSearchTbl implements ORAData, ORADataFactory, OracleTypeAdapter{
    public static final String _SQL_NAME = "DT_WH_TO_ST_PR_MAT_SEARCH_TBL";
    public static final int _SQL_TYPECODE = OracleTypes.ARRAY;
    MutableArray  _array;
    private static final DtWhToStPrMatSearchTbl _DtWhToStPrMatSearchTblFactory = new DtWhToStPrMatSearchTbl();
    public static ORADataFactory getORADataFactory() {
        return _DtWhToStPrMatSearchTblFactory;
    }
    public DtWhToStPrMatSearchTbl() {
        this((DtWhToStPrMatSearchRec[])null);
    }
    public DtWhToStPrMatSearchTbl(DtWhToStPrMatSearchRec[] a) {
        _array = new MutableArray(2002, a, DtWhToStPrMatSearchRec.getORADataFactory());
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
        DtWhToStPrMatSearchTbl a = new DtWhToStPrMatSearchTbl();
        a._array = new MutableArray(2002, (ARRAY)d, DtWhToStPrMatSearchRec.getORADataFactory());
        return a;
    }

    public DtWhToStPrMatSearchRec[] getArray() throws SQLException {
        return (DtWhToStPrMatSearchRec[])_array.getObjectArray(new DtWhToStPrMatSearchRec[_array.length()]);
    }

    public DtWhToStPrMatSearchRec[] getArray(long index, int count) throws SQLException {
        return (DtWhToStPrMatSearchRec[])_array.getObjectArray(index, new DtWhToStPrMatSearchRec[_array.sliceLength(index,count)]);
    }

    public void setArray(DtWhToStPrMatSearchRec[] a) throws SQLException {
        _array.setObjectArray(a);
    }

    public void setArray(DtWhToStPrMatSearchRec[] a, long index) throws SQLException {
        _array.setObjectArray(a, index);
    }

    public DtWhToStPrMatSearchRec getElement(long index) throws SQLException {
        return (DtWhToStPrMatSearchRec)_array.getObjectElement(index);
    }

    public void setElement(DtWhToStPrMatSearchRec a, long index) throws SQLException {
        _array.setObjectElement(a, index);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
