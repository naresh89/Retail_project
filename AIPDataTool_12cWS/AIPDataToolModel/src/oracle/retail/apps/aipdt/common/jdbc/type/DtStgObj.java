
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
 * Generation Date   : 2016-01-18 14:38:009
 * Oracle Type Name  : DT_STG_OBJ
 * Owned by          : TEST_USER
 * Requested Schema  : TEST_USER
 * Requested DB URL  : jdbc:oracle:thin:@localhost:1521:orcl
 * Requested DB User : test_user
 *******************************************************/
public class DtStgObj implements ORAData, ORADataFactory, OracleTypeAdapter {
    public static final String _SQL_NAME = "DT_STG_OBJ";

    public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

    public static final int TRANSACTION_ID_IDX = 0;
    public static final int SUPPLIER_ID_IDX = 1;
    public static final int STOCKING_POINT_ID_IDX = 2;
    public static final int STORE_FORMAT_ID_IDX = 3;
    public static final int STORE_ID_IDX = 4;
    public static final int SOURCE_TYPE_IDX = 5;
    public static final int SOURCE_ID_IDX = 6;
    public static final int DESTINATION_TYPE_IDX = 7;
    public static final int DESTINATION_ID_IDX = 8;
    public static final int SOURCE_SEL_TYPE_IDX = 9;
    public static final int DEST_SEL_TYPE_IDX = 10;
    public static final int RECEIVING_PATTERN_IDX = 11;
    public static final int PALLET_MULTIPLE_IDX = 12;
    public static final int ORDER_MULTIPLE_IDX = 13;
    public static final int DEMAND_GROUP_ID_IDX = 14;
    public static final int ORDER_GROUP_ID_IDX = 15;
    public static final int RANGING_STATUS_IDX = 16;
    public static final int START_DATE_IDX = 17;
    public static final int END_DATE_IDX = 18;
    public static final int COMMODITY_ID_IDX = 19;
    public static final int PACK_SIZE_IDX = 20;
    public static final int IS_EXCEPTION_IDX = 21;
    public static final int STATUS_IDX = 22;
    public static final int IS_VALID_IDX = 23;
    public static final int ERROR_CODE_IDX = 24;
    public static final int IS_LIST_IDX = 25;
    public static final int IS_SRC_LIST_IDX = 26;
    public static final int CREATE_USER_IDX = 27;
    public static final int CREATE_DATE_IDX = 28;
    public static final int UPDATE_USER_IDX = 29;
    public static final int UPDATE_DATE_IDX = 30;
    protected MutableStruct _struct;
    protected static int[] _sqlType = {2,2,2,2,2,12,2,12,2,12,12,12,2,2,2,2,2,93,93,2,2,12,12,12,12,12,12,12,93,12,93};
    protected static ORADataFactory[] _factory = new ORADataFactory[31];
    static {
    }
    protected static final DtStgObj _DtStgObjFactory = new DtStgObj();
    public static ORADataFactory getORADataFactory() {
        return _DtStgObjFactory;
    }

    public DtStgObj() {
        _struct = new MutableStruct(new Object[31], _sqlType, _factory);
    }

    public Datum toDatum(Connection c) throws SQLException {
        return _struct.toDatum(c, getSQLTypeName()); 
    }

    public ORAData create(Datum d, int sqlType) throws SQLException {
        return create(null, d, sqlType);
    }

    protected ORAData create(DtStgObj o, Datum d, int sqlType) throws SQLException {
        if (d == null)
            return null;
        if (o == null)
            o = new DtStgObj();
        o._struct = new MutableStruct((STRUCT)d, _sqlType, _factory);
        return o;
    }
    public final java.math.BigDecimal  getTransactionId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(TRANSACTION_ID_IDX);
    }

    public final void setTransactionId(java.math.BigDecimal transactionId) throws SQLException 
    { 
        _struct.setAttribute(TRANSACTION_ID_IDX, transactionId);
    }

    public final java.math.BigDecimal  getSupplierId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(SUPPLIER_ID_IDX);
    }

    public final void setSupplierId(java.math.BigDecimal supplierId) throws SQLException 
    { 
        _struct.setAttribute(SUPPLIER_ID_IDX, supplierId);
    }

    public final java.math.BigDecimal  getStockingPointId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(STOCKING_POINT_ID_IDX);
    }

    public final void setStockingPointId(java.math.BigDecimal stockingPointId) throws SQLException 
    { 
        _struct.setAttribute(STOCKING_POINT_ID_IDX, stockingPointId);
    }

    public final java.math.BigDecimal  getStoreFormatId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(STORE_FORMAT_ID_IDX);
    }

    public final void setStoreFormatId(java.math.BigDecimal storeFormatId) throws SQLException 
    { 
        _struct.setAttribute(STORE_FORMAT_ID_IDX, storeFormatId);
    }

    public final java.math.BigDecimal  getStoreId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(STORE_ID_IDX);
    }

    public final void setStoreId(java.math.BigDecimal storeId) throws SQLException 
    { 
        _struct.setAttribute(STORE_ID_IDX, storeId);
    }

    public final java.lang.String  getSourceType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SOURCE_TYPE_IDX);
    }

    public final void setSourceType(java.lang.String sourceType) throws SQLException 
    { 
        _struct.setAttribute(SOURCE_TYPE_IDX, sourceType);
    }

    public final java.math.BigDecimal  getSourceId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(SOURCE_ID_IDX);
    }

    public final void setSourceId(java.math.BigDecimal sourceId) throws SQLException 
    { 
        _struct.setAttribute(SOURCE_ID_IDX, sourceId);
    }

    public final java.lang.String  getDestinationType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(DESTINATION_TYPE_IDX);
    }

    public final void setDestinationType(java.lang.String destinationType) throws SQLException 
    { 
        _struct.setAttribute(DESTINATION_TYPE_IDX, destinationType);
    }

    public final java.math.BigDecimal  getDestinationId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(DESTINATION_ID_IDX);
    }

    public final void setDestinationId(java.math.BigDecimal destinationId) throws SQLException 
    { 
        _struct.setAttribute(DESTINATION_ID_IDX, destinationId);
    }

    public final java.lang.String  getSourceSelType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(SOURCE_SEL_TYPE_IDX);
    }

    public final void setSourceSelType(java.lang.String sourceSelType) throws SQLException 
    { 
        _struct.setAttribute(SOURCE_SEL_TYPE_IDX, sourceSelType);
    }

    public final java.lang.String  getDestSelType() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(DEST_SEL_TYPE_IDX);
    }

    public final void setDestSelType(java.lang.String destSelType) throws SQLException 
    { 
        _struct.setAttribute(DEST_SEL_TYPE_IDX, destSelType);
    }

    public final java.lang.String  getReceivingPattern() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(RECEIVING_PATTERN_IDX);
    }

    public final void setReceivingPattern(java.lang.String receivingPattern) throws SQLException 
    { 
        _struct.setAttribute(RECEIVING_PATTERN_IDX, receivingPattern);
    }

    public final java.math.BigDecimal  getPalletMultiple() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(PALLET_MULTIPLE_IDX);
    }

    public final void setPalletMultiple(java.math.BigDecimal palletMultiple) throws SQLException 
    { 
        _struct.setAttribute(PALLET_MULTIPLE_IDX, palletMultiple);
    }

    public final java.math.BigDecimal  getOrderMultiple() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(ORDER_MULTIPLE_IDX);
    }

    public final void setOrderMultiple(java.math.BigDecimal orderMultiple) throws SQLException 
    { 
        _struct.setAttribute(ORDER_MULTIPLE_IDX, orderMultiple);
    }

    public final java.math.BigDecimal  getDemandGroupId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(DEMAND_GROUP_ID_IDX);
    }

    public final void setDemandGroupId(java.math.BigDecimal demandGroupId) throws SQLException 
    { 
        _struct.setAttribute(DEMAND_GROUP_ID_IDX, demandGroupId);
    }

    public final java.math.BigDecimal  getOrderGroupId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(ORDER_GROUP_ID_IDX);
    }

    public final void setOrderGroupId(java.math.BigDecimal orderGroupId) throws SQLException 
    { 
        _struct.setAttribute(ORDER_GROUP_ID_IDX, orderGroupId);
    }

    public final java.math.BigDecimal  getRangingStatus() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(RANGING_STATUS_IDX);
    }

    public final void setRangingStatus(java.math.BigDecimal rangingStatus) throws SQLException 
    { 
        _struct.setAttribute(RANGING_STATUS_IDX, rangingStatus);
    }

    public final java.sql.Timestamp  getStartDate() throws SQLException 
    {
        return (java.sql.Timestamp)_struct.getAttribute(START_DATE_IDX);
    }

    public final void setStartDate(java.sql.Timestamp startDate) throws SQLException 
    { 
        _struct.setAttribute(START_DATE_IDX, startDate);
    }

    public final java.sql.Timestamp  getEndDate() throws SQLException 
    {
        return (java.sql.Timestamp)_struct.getAttribute(END_DATE_IDX);
    }

    public final void setEndDate(java.sql.Timestamp endDate) throws SQLException 
    { 
        _struct.setAttribute(END_DATE_IDX, endDate);
    }

    public final java.math.BigDecimal  getCommodityId() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(COMMODITY_ID_IDX);
    }

    public final void setCommodityId(java.math.BigDecimal commodityId) throws SQLException 
    { 
        _struct.setAttribute(COMMODITY_ID_IDX, commodityId);
    }

    public final java.math.BigDecimal  getPackSize() throws SQLException 
    {
        return (java.math.BigDecimal)_struct.getAttribute(PACK_SIZE_IDX);
    }

    public final void setPackSize(java.math.BigDecimal packSize) throws SQLException 
    { 
        _struct.setAttribute(PACK_SIZE_IDX, packSize);
    }

    public final java.lang.String  getIsException() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(IS_EXCEPTION_IDX);
    }

    public final void setIsException(java.lang.String isException) throws SQLException 
    { 
        _struct.setAttribute(IS_EXCEPTION_IDX, isException);
    }

    public final java.lang.String  getStatus() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(STATUS_IDX);
    }

    public final void setStatus(java.lang.String status) throws SQLException 
    { 
        _struct.setAttribute(STATUS_IDX, status);
    }

    public final java.lang.String  getIsValid() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(IS_VALID_IDX);
    }

    public final void setIsValid(java.lang.String isValid) throws SQLException 
    { 
        _struct.setAttribute(IS_VALID_IDX, isValid);
    }

    public final java.lang.String  getErrorCode() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(ERROR_CODE_IDX);
    }

    public final void setErrorCode(java.lang.String errorCode) throws SQLException 
    { 
        _struct.setAttribute(ERROR_CODE_IDX, errorCode);
    }

    public final java.lang.String  getIsList() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(IS_LIST_IDX);
    }

    public final void setIsList(java.lang.String isList) throws SQLException 
    { 
        _struct.setAttribute(IS_LIST_IDX, isList);
    }

    public final java.lang.String  getIsSrcList() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(IS_SRC_LIST_IDX);
    }

    public final void setIsSrcList(java.lang.String isSrcList) throws SQLException 
    { 
        _struct.setAttribute(IS_SRC_LIST_IDX, isSrcList);
    }

    public final java.lang.String  getCreateUser() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(CREATE_USER_IDX);
    }

    public final void setCreateUser(java.lang.String createUser) throws SQLException 
    { 
        _struct.setAttribute(CREATE_USER_IDX, createUser);
    }

    public final java.sql.Timestamp  getCreateDate() throws SQLException 
    {
        return (java.sql.Timestamp)_struct.getAttribute(CREATE_DATE_IDX);
    }

    public final void setCreateDate(java.sql.Timestamp createDate) throws SQLException 
    { 
        _struct.setAttribute(CREATE_DATE_IDX, createDate);
    }

    public final java.lang.String  getUpdateUser() throws SQLException 
    {
        return (java.lang.String)_struct.getAttribute(UPDATE_USER_IDX);
    }

    public final void setUpdateUser(java.lang.String updateUser) throws SQLException 
    { 
        _struct.setAttribute(UPDATE_USER_IDX, updateUser);
    }

    public final java.sql.Timestamp  getUpdateDate() throws SQLException 
    {
        return (java.sql.Timestamp)_struct.getAttribute(UPDATE_DATE_IDX);
    }

    public final void setUpdateDate(java.sql.Timestamp updateDate) throws SQLException 
    { 
        _struct.setAttribute(UPDATE_DATE_IDX, updateDate);
    }

    public static String getSQLTypeName() {    return DbSchemaResolverFactory.getResolver().resolveObjectName(_SQL_NAME);} 
    public static int getSQLTypeCode() {    return _SQL_TYPECODE;} 
} // end class
