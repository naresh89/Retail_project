
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
 * Generation Date   : 2016-02-11 09:15:043
 * Oracle Type Name  : DT_OOSS_SEARCH_REC
 * Owned by          : SYSTEM
 * Requested Schema  : SYSTEM
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:xe
 * Requested DB User : system
 *******************************************************/
public class DtOossSearchRec implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_OOSS_SEARCH_REC";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int DEPT_IDX = 0;
    public static final int CLASS_IDX = 1;
    public static final int SUBCLASS_IDX = 2;
    public static final int VPN_IDX = 3;
    public static final int VPN_COLOR_IDX = 4;
    public static final int SKU_IDX = 5;
    public static final int ITEM_LIST_IDX = 6;
    public static final int REGION_IDX = 7;
    public static final int STORE_IDX = 8;
    public static final int STORE_LIST_IDX = 9;
    public static final int SUPPLIER_IDX = 10;
    public static final int ALL_STORES_IDX = 11;
    public static final int ALL_ITEMS_IDX = 12;
    public static final int CREATE_USER_IDX = 13;
    public static final int FLAG_IDX = 14;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {2,12,12,12,12,12,12,2,12,12,12,12,12,12,2};
    protected static ORADataFactory[] _factory = new ORADataFactory[15];
    static {
    }
    protected static final DtOossSearchRec _DtOossSearchRecFactory = new DtOossSearchRec();
    public static ORADataFactory getORADataFactory() {
        return _DtOossSearchRecFactory;
    }

    public DtOossSearchRec() {
        _struct = new MutableStruct(new Object[15], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtOossSearchRec o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtOossSearchRec();
        o._struct = new MutableStruct((STRUCT)d, _sqlType, _factory);
        return o;
    }
    public final java.math.BigDecimal  getDept() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(DEPT_IDX);
    }

    public final void setDept(java.math.BigDecimal dept) throws SQLException 
    { 
        _struct.setAttribute(DEPT_IDX, dept);
    }

    public final java.lang.String  getClassAttribute() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(CLASS_IDX);
    }

    public final void setClassAttribute(java.lang.String classAttribute) throws SQLException 
    { 
        _struct.setAttribute(CLASS_IDX, classAttribute);
    }

    public final java.lang.String  getSubclass() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SUBCLASS_IDX);
    }

    public final void setSubclass(java.lang.String subclass) throws SQLException 
    { 
        _struct.setAttribute(SUBCLASS_IDX, subclass);
    }

    public final java.lang.String  getVpn() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(VPN_IDX);
    }

    public final void setVpn(java.lang.String vpn) throws SQLException 
    { 
        _struct.setAttribute(VPN_IDX, vpn);
    }

    public final java.lang.String  getVpnColor() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(VPN_COLOR_IDX);
    }

    public final void setVpnColor(java.lang.String vpnColor) throws SQLException 
    { 
        _struct.setAttribute(VPN_COLOR_IDX, vpnColor);
    }

    public final java.lang.String  getSku() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SKU_IDX);
    }

    public final void setSku(java.lang.String sku) throws SQLException 
    { 
        _struct.setAttribute(SKU_IDX, sku);
    }

    public final java.lang.String  getItemList() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(ITEM_LIST_IDX);
    }

    public final void setItemList(java.lang.String itemList) throws SQLException 
    { 
        _struct.setAttribute(ITEM_LIST_IDX, itemList);
    }

    public final java.math.BigDecimal  getRegion() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(REGION_IDX);
    }

    public final void setRegion(java.math.BigDecimal region) throws SQLException 
    { 
        _struct.setAttribute(REGION_IDX, region);
    }

    public final java.lang.String  getStore() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STORE_IDX);
    }

    public final void setStore(java.lang.String store) throws SQLException 
    { 
        _struct.setAttribute(STORE_IDX, store);
    }

    public final java.lang.String  getStoreList() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STORE_LIST_IDX);
    }

    public final void setStoreList(java.lang.String storeList) throws SQLException 
    { 
        _struct.setAttribute(STORE_LIST_IDX, storeList);
    }

    public final java.lang.String  getSupplier() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SUPPLIER_IDX);
    }

    public final void setSupplier(java.lang.String supplier) throws SQLException 
    { 
        _struct.setAttribute(SUPPLIER_IDX, supplier);
    }

    public final java.lang.String  getAllStores() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(ALL_STORES_IDX);
    }

    public final void setAllStores(java.lang.String allStores) throws SQLException 
    { 
        _struct.setAttribute(ALL_STORES_IDX, allStores);
    }

    public final java.lang.String  getAllItems() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(ALL_ITEMS_IDX);
    }

    public final void setAllItems(java.lang.String allItems) throws SQLException 
    { 
        _struct.setAttribute(ALL_ITEMS_IDX, allItems);
    }

    public final java.lang.String  getCreateUser() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(CREATE_USER_IDX);
    }

    public final void setCreateUser(java.lang.String createUser) throws SQLException 
    { 
        _struct.setAttribute(CREATE_USER_IDX, createUser);
    }

    public final java.math.BigDecimal  getFlag() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(FLAG_IDX);
    }

    public final void setFlag(java.math.BigDecimal flag) throws SQLException 
    { 
        _struct.setAttribute(FLAG_IDX, flag);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
