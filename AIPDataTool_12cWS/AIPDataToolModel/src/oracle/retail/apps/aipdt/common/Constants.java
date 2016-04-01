package oracle.retail.apps.aipdt.common;

import java.util.LinkedHashMap;

public abstract class Constants {
    //All DataControl Name Entry here
    public final static String AIPDT_ROOT_AM_DATA_CONTROL = "AipdtRootAMDataControl";
    public final static String AIPDT_ROOT_AM = "AipdtRootAM";
    public final static String EXCEPTIONS_AM = "ExceptionsAM";

    public final static String CANCEL = "cancel";
    public final static String CLOSE_CONTENT = "closeContent";

    public final static String AIPDT_MODEL_BUNDLE = "oracle.retail.apps.aipdt.model.AIPDataToolModelBundle";
    public final static String AIPDT_VIEW_BUNDLE = "oracle.retail.apps.aipdt.view.AIPDataToolViewControllerBundle";

    public final static String DEAFULT_ERROR_MSG = "DEAFULT_ERROR_MSG";

    public final static String REGION_ID_VC_REFERENCE = "regId";
    //Receiving Calendar - start
    //public final static String WH_CALENDAR_CRE = "WH_CALENDAR_CRE";
    public final static String RECEIVING_CALENDAR_AM = "ReceivingCalendarAM";

    public final static String STORE_CODE = "S";
    public final static String WAREHOUSE_CODE = "W";
    public final static String SUPPLIER_CODE = "P";
    public final static String LOC_TYPE_STORE = "Store";
    public final static String LOC_TYPE_STORE_FORMAT = "Store Format";
    public final static String LOC_TYPE_WAREHOUSE = "Warehouse";
    public final static String LOC_TYPE_SUPPLIER = "Supplier";
    public final static String LOC_TYPE_CROSSDOCK = "Cross Dock";
    public final static String LOC_TYPE_RESERVED_STOCK = "Reserved Stock";
    public final static String LOC_TYPE_ALL = "All";
    public final static String ALL_CODE = "A";
    public final static String DEFAULT_RECEIVING_PATTERN = "NNNNNNN";
    public final static String DATE_VO = "DateVO1";

    public final static String DT_SEQ_RECEIVING_CAL_STG = "DT_SEQ_RECEIVING_CAL_STG";

    //Message Error Key entry here
    public final static String RC_ERROR_UPDATE_STAGE_DATA = "RC_ERROR_UPDATE_STAGE_DATA";
    public final static String RC_ERROR_INSERT_STAGE_DATA = "RC_ERROR_INSERT_STAGE_DATA";
    public final static String EXCEPTION_WITHOUT_DEFAULT_ERROR = "EXCEPTION_WITHOUT_DEFAULT_ERROR";
    public final static String RC_LOCATION_TYPE_REQUIRED = "RC_LOCATION_TYPE_REQUIRED";
    public final static String RC_PRODUCT_TYPE_REQUIRED = "RC_PRODUCT_TYPE_REQUIRED";
    public final static String RC_STORE_REQUIRED = "RC_STORE_REQUIRED";
    public final static String RC_STORE_FORMAT_REQUIRED = "RC_STORE_FORMAT_REQUIRED";
    public final static String RC_WAREHOUSE_REQUIRED = "RC_WAREHOUSE_REQUIRED";
    public final static String RC_PRODUCT_TYPE_NOT_FOUND = "RC_PRODUCT_TYPE_NOT_FOUND";
    public final static String RC_DESTINATION_NOT_FOUND = "RC_DESTINATION_NOT_FOUND";
    //Receiving Calendar - end

    //Netowrk Path - start
    public final static String NETWORK_PATH_AM = "NetworkPathAM";
    public final static String NP_SOURCE_TYPE_REQUIRED = "NP_SOURCE_TYPE_REQUIRED";
    public final static String NP_WH_TYPE_REQUIRED = "NP_WH_TYPE_REQUIRED";
    public final static String NP_DEST_TYPE_REQUIRED = "NP_DEST_TYPE_REQUIRED";
    public final static String NP_SUPPLIER_REQUIRED = "NP_SUPPLIER_REQUIRED";
    public final static String CROSSDOCK_CODE = "XD";
    public final static String RESERVED_STOCK_CODE = "CS";
    public final static String NP_SOURCE_NOT_FOUND = "NP_SOURCE_NOT_FOUND";
    public final static String NP_DESTINATION_NOT_FOUND = "NP_DESTINATION_NOT_FOUND";
    public final static String NP_ERROR_UPDATE_STAGE_DATA = "NP_ERROR_UPDATE_STAGE_DATA";
    public final static String NP_ERROR_INSERT_STAGE_DATA = "NP_ERROR_INSERT_STAGE_DATA";
    public final static String DT_SEQ_NETWORK_PATH_STG = "DT_SEQ_NETWORK_PATH_STG";
    public final static String SEL_ALL = "SetAll";
    public final static String EFFECTIVE_DATE = "EffectiveDate";
    public final static String SUNDAY_LEAD_TIME = "SundayLeadTime";
    public final static String MONDAY_LEAD_TIME = "MondayLeadTime";
    public final static String TUESDAY_LEAD_TIME = "TuesdayLeadTime";
    public final static String WEDNESDAY_LEAD_TIME = "WednesdayLeadTime";
    public final static String THURSDAY_LEAD_TIME = "ThursdayLeadTime";
    public final static String FRIDAY_LEAD_TIME = "FridayLeadTime";
    public final static String SATURDAY_LEAD_TIME = "SaturdayLeadTime";
    public final static String INVALID_SEARCH_CRITERIA = "INVALID_SEARCH_CRITERIA";
    public final static String NP_INVALID_LEAD_TIME = "NP_INVALID_LEAD_TIME";
    public final static String NP_ERROR_READ_SYSTEM_PARAM = "NP_ERROR_READ_SYSTEM_PARAM";
    public final static String NP_DST_RS_WH_ENABLE = "NP_DST_RS_WH_ENABLE";
    public final static String NO_RECORDS_SELECTED_FOR_SAVE = "NO_RECORDS_SELECTED_FOR_SAVE";
    public final static String NP_INPUT_SOURCE_WH_TYPE_INVALID = "NP_INPUT_SOURCE_WH_TYPE_INVALID";
    public final static String NP_INPUT_SOURCE_WH_INVALID = "NP_INPUT_SOURCE_WH_INVALID";
    public final static String NP_INPUT_DEST_INVALID = "NP_INPUT_DEST_INVALID";
    public final static String NO_LEAD_TIME_ENTERED_FOR_SAVE = "NO_LEAD_TIME_ENTERED_FOR_SAVE";
    public final static String NP_SET_ALL_EFF_DATE_COMP_ID = "setAllEffDateId";
    public final static String NP_SET_ALL_SUN_LD_COMP_ID = "setAllSunLDId";
    public final static String NP_SET_ALL_MON_LD_COMP_ID = "setAllMonLDId";
    public final static String NP_SET_ALL_TUE_LD_COMP_ID = "setAllTueLDId";
    public final static String NP_SET_ALL_WED_LD_COMP_ID = "setAllWedLDId";
    public final static String NP_SET_ALL_THU_LD_COMP_ID = "setAllThuLDId";
    public final static String NP_SET_ALL_FRI_LD_COMP_ID = "setAllFriLDId";
    public final static String NP_SET_ALL_SAT_LD_COMP_ID = "setAllSatLDId";
    public static final String NP_EXPORT_FILE_NAME = "NP_EXPORT_FILE_NAME";
    //Network Path - end

    //All DB Table Name here
    public final static String TABLE_DT_LIST_HEADER = "DT_LIST_HEADER";


    public final static int SQL_IN_CLAUSE_CHUNK_SIZE = 1000;
    public final static int RESULT_SET_SIZE = 10000;
    //Copied from morrison for all constants

    public final static boolean isDevEnv = false;
    public final static LinkedHashMap<String, String> USER_MAP = new LinkedHashMap<String, String>();

    //All constants entry here
    public final static double ORDER_GROUP_GENERATIONMETHOD = 0;
    public final static double ORDER_GROUP_TIER = 1;
    public final static int WORKING_LEVEL_FUN_ROW_COUNT = 6;
    public final static int WORKING_INFO_CRE_FUN_ROW_COUNT = 7;
    public final static int WORKING_INFO_MNT_FUN_ROW_COUNT = 4;
    public final static int initialCapacity = 100;
    public final static String VDATE_DATE_FORMAT = "yyyyMMdd";

    public final static int HIER_LEVEL_CLASS = 3;
    public final static int HIER_LEVEL_SUBCLASS = 2;
    public final static int HIER_LEVEL_ITEM = 1;


    //All AM Name Entry here
    public final static String STORE_ORDER_CYCLE_AM = "StoreOrderCycleAM";
    public final static String SUPPLY_CHAIN_LIST_AM = "SupplyChainListAM";
    public final static String WAREHOUSE_ORDER_CYCLE_AM = "WarehouseOrderCycleAM";
    public final static String WAREHOUSE_ORDERABLE_UNIT_AM = "WarehouseOrderableUnitAM";
    public final static String WAREHOUSE_ORDER_MULTIPLE_AM = "WarehouseOrderMultipleAM";
    public final static String WAREHOUSE_PALLET_MULTIPLE_AM = "WarehousePalletMultipleAM";
    public final static String WAREHOUSE_RANGING_AM = "WarehouseRangingAM";
    public final static String WORKING_GROUP_AM = "WorkingGroupAM";
    public final static String WAREHOUSE_LEAD_TIME_AM = "WarehouseLeadTimeAM";
    public final static String STORE_ONOFF_SUPPLY_OFFSET_AM = "StoreOnOffSupplyOffsetAM";
    public final static String STORE_PACK_SIZE_AM = "StorePackSizeAM";
    public static final String STORE_SOURCE_AM = "StoreSourceAM";
    public static final String STORE_LEAD_TIME_AM = "StoreLeadTimeAM";
    public final static String SUMMARY_AM = "SummaryAM";


    public final static String METHOD_START_LOG = " Method: Start";
    public final static String METHOD_END_LOG = " Method: End";

    //ALL VO Name Entry here
    public final static String DATE_PARAM_VO1 = "DateParamVO1";

    //All Iterator Entry Here
    public final static String WORKING_GROUP_VO1_ITERATOR = "WorkingGroupVO1Iterator";


    //All DB Table Name here
    public final static String TABLE_ORDER_CYCLE = "ORDER_CYCLE";
    public final static String TABLE_STORE_ORDER_CYCLE = "STORE_ORDER_CYCLE";
    public final static String TABLE_ON_SUPPLY_OFF_SUPPLY = "ON_SUPPLY_OFF_SUPPLY";
    public final static String TABLE_DT_WH_RANGING_L1 = "DT_WH_RANGING_L1";

    //Sequences
    public final static String DT_SEQ_LIST_HEADER = "DT_SEQ_LIST_HEADER";

    //Functionality Type Code
    public final static String WH_CALENDAR_CRE = "WH_CALENDAR_CRE";
    public final static String WH_CALENDAR_MNT = "WH_CALENDAR_MNT";
    public final static String WH_RANGING_CRE = "WH_RANGING_CRE";
    public final static String WH_RANGING_MNT = "WH_RANGING_MNT";
    public final static String WH_LEADTIME_CRE = "WH_LEADTIME_CRE";
    public final static String WH_LEADTIME_MNT = "WH_LEADTIME_MNT";
    public final static String WH_ORDERABLEUNIT_CRE = "WH_ORDERABLEUNIT_CRE";
    public final static String WH_ORDERABLEUNIT_MNT = "WH_ORDERABLEUNIT_MNT";
    public final static String WH_ORDERMULTIPLE_CRE = "WH_ORDERMULTIPLE_CRE";
    public final static String WH_ORDERMULTIPLE_MNT = "WH_ORDERMULTIPLE_MNT";
    public final static String WH_PALLETMULTIPLE_CRE = "WH_PALLETMULTIPLE_CRE";
    public final static String WH_PALLETMULTIPLE_MNT = "WH_PALLETMULTIPLE_MNT";
    public final static String ST_CALENDAR_CRE = "ST_CALENDAR_CRE";
    public final static String ST_CALENDAR_MNT = "ST_CALENDAR_MNT";
    public final static String ST_ONOFFSUPPLYDATES_MNT = "ST_ONOFFSUPPLYDATES_MNT";
    public final static String ST_SOURCE_CRE = "ST_SOURCE_CRE";
    public final static String ST_SOURCE_MNT = "ST_SOURCE_MNT";
    public final static String ST_LEADTIME_CRE = "ST_LEADTIME_CRE";
    public final static String ST_LEADTIME_MNT = "ST_LEADTIME_MNT";
    public final static String ST_ORDERINGPACKSIZE_CRE = "ST_ORDERINGPACKSIZE_CRE";
    public final static String ST_ORDERINGPACKSIZE_MNT = "ST_ORDERINGPACKSIZE_MNT";
    public final static String ST_ONOFFSUPPLYOFFSET_MNT = "ST_ONOFFSUPPLYOFFSET_MNT";
    public final static String SC_LIST_CRE = "SC_LIST_CRE";
    public final static String SC_LIST_MNT = "SC_LIST_MNT";

    public final static String WORKING_LEVEL_L1D = "L1D";
    public final static String WORKING_LEVEL_L2D = "L2D";
    public final static String WORKING_LEVEL_L3D = "L3D";
    public final static String WORKING_LEVEL_L1E = "L1E";
    public final static String WORKING_LEVEL_L2E = "L2E";
    public final static String WORKING_LEVEL_L3E = "L3E";

    public final static String WORKING_INFO_ITEM = "ITEM";
    public final static String WORKING_INFO_STORE = "ST";
    public final static String WORKING_INFO_WAREHOUSE = "WH";
    public final static String WORKING_INFO_SUPPLIER = "SPL";

    public final static String CLASS_SUB_TYPE = "CLS";
    public final static String SUBCLASS_SUB_TYPE = "SCLS";
    public final static String ITEM_SUB_TYPE = "ITEM";
    public final static String ITEM_PACK_SUB_TYPE = "ITMPS";
    public final static String SUPPLIER_SUB_TYPE = "SPL";
    public final static String WAREHOUSE_SUB_TYPE = "WH";
    public final static String STORE_SUB_TYPE = "ST";

    public final static String VPN_SUB_TYPE = "VPN";
    public final static String VPN_COLOUR_SUB_TYPE = "VPNC";
    public final static String SKU_SUB_TYPE = "SKU";

    public final static String LIST_NAME_BIND = "Bv_V_Name";
    public final static String LIST_HDR_VC = "DtListHdrROVOCriteria";

    public final static String LIST_PRIVACY_PRIVATE = "P";
    public final static String LIST_PRIVACY_PUBLIC = "G";

    //Store Source status
    public final static String ST_SOURCE_ACTIVE = "A";
    public final static String ST_SOURCE_FUTURE = "F";
    public final static String ST_SOURCE_INACTIVE = "I";
    //Warehouse order status
    public final static String WH_ORDER_STATUS_ACTIVE = "A";
    public final static String WH_ORDER_STATUS_FUTURE = "F";
    public final static String WH_ORDER_STATUS_INACTIVE = "I";
    public final static String WH_ORDER_VENDOR = "V";
    public final static String WH_ORDER_WAREHOUSE = "W";

    // Order multiple Status
    public final static String WH_OM_STATUS_ACTIVE = "A";
    public final static String WH_OM_STATUS_FUTURE = "F";
    public final static String WH_OM_STATUS_INACTIVE = "I";

    //Warehouse Lead Time Status
    public final static String WH_LEAD_TIME_STATUS_ACTIVE = "A";
    public final static String WH_LEAD_TIME_STATUS_FUTURE = "F";
    public final static String WH_LEAD_TIME_STATUS_INACTIVE = "I";

    // Pallet multiple Status
    public final static String WH_PM_STATUS_ACTIVE = "A";
    public final static String WH_PM_STATUS_FUTURE = "F";
    public final static String WH_PM_STATUS_INACTIVE = "I";

    // Warehouse ranging Status
    public final static int WHRANGING_UNRANGED = 0;
    public final static int WHRANGING_PROFILE_RANGED = 1;
    public final static int WHRANGING_EXCEPTION_RANGED = 2;
    public final static int WHRANGING_PENDING_DERANGED = 3;
    public final static int WHRANGING_DERANGED = 4;

    // Warehouse lead time hier levels
    public final static int WH_LEAD_TIME_HIER_LEVEL_SKU = 1;
    public final static int WH_LEAD_TIME_HIER_LEVEL_SUBCLASS = 2;
    public final static int WH_LEAD_TIME_HIER_LEVEL_CLASS = 3;

    public final static String ROLLBACK = "Rollback";
    public final static String COMMIT = "Commit";
    public final static String SAVE = "save";
    public final static String SAVE_AND_CLOSE = "saveAndClose";
    public final static String CHECK_BOX_VALUE = "CheckVal";
    public final static String STATUS = "Status";

    //Message Error Key entry here

    public final static String DT_UI_CONFIG_NOT_DONE = "DT_UI_CONFIG_NOT_DONE";
    public final static String DT_FUN_NAME_CAN_NOT_BE_NULL = "DT_FUN_NAME_CAN_NOT_BE_NULL";
    public static final String NO_ROW_SELECTED_FOR_DELETE = "NO_ROW_SELECTED_FOR_DELETE";
    public static final String INACTIVE_ROW_SELECTED = "INACTIVE_ROW_SELECTED";
    public static final String AUTO_LIST_ROW_SELECTED = "AUTO_LIST_ROW_SELECTED";
    public static final String GLOBAL_LIST_ROW_SELECTED = "GLOBAL_LIST_ROW_SELECTED";
    public static final String DATA_SECURITY_IS_NOT_SETUP_USER = "DATA_SECURITY_IS_NOT_SETUP_USER";

    //Store Source Error Keys
    public final static String ST_SOURCE_TRANSACTION_ID_NULL = "ST_SOURCE_TRANSACTION_ID_NULL";
    public final static String ST_SOURCE_ERROR_STAGING_RECORDS = "ST_SOURCE_ERROR_STAGING_RECORDS";
    public final static String ST_SOURCE_ERROR_PLSQL_VALIDATE = "ST_SOURCE_ERROR_PLSQL_VALIDATE";

    //Message Error Keys for Warehouse OU funtionality
    public final static String WH_OU_ERROR_TRANSACTION_ID_NULL = "WH_OU_ERROR_TRANSACTION_ID_NULL";
    public final static String WH_OU_ERROR_REQUIRED_FIELDS_BLANK = "WH_OU_ERROR_REQUIRED_FIELDS_BLANK";
    public final static String WH_OU_ERROR_CREATE_RECORDS = "WH_OU_ERROR_CREATE_RECORDS";
    public final static String WH_OU_ERROR_PLSQL_VALIDATE = "WH_OU_ERROR_PLSQL_VALIDATE";
    public final static String WH_OU_ERROR_PLSQL_LOAD = "WH_OU_ERROR_PLSQL_LOAD";
    public final static String WH_OU_ERROR_PLSQL_LOAD_TIMESTAMP_NULL = "WH_OU_ERROR_PLSQL_LOAD_TIMESTAMP_NULL";
    public final static String WH_ORDER_ERROR_AIP_DT_ROOT_AM_NULL = "WH_ORDER_ERROR_AIP_DT_ROOT_AM_NULL";

    //Message Error Keys for Warehouse Ranging funtionality
    public final static String WH_RANGING_ERROR_PLSQL_LOAD_TIMESTAMP_NULL =
        "WH_RANGING_ERROR_PLSQL_LOAD_TIMESTAMP_NULL";
    public final static String WH_RANGING_STATUS_EMPTY_ERROR = "WH_RANGING_STATUS_EMPTY_ERROR";

    //Message Error Keys for Warehouse PM funtionality
    public final static String WH_PM_ERROR_TRANSACTION_ID_NULL = "WH_PM_ERROR_TRANSACTION_ID_NULL";
    public final static String WH_PM_ERROR_REQUIRED_FIELDS_BLANK = "WH_PM_ERROR_REQUIRED_FIELDS_BLANK";
    public final static String WH_PM_ERROR_CREATE_RECORDS = "WH_PM_ERROR_CREATE_RECORDS";
    public final static String WH_PM_ERROR_PLSQL_VALIDATE = "WH_PM_ERROR_PLSQL_VALIDATE";
    public final static String WH_PM_ERROR_PLSQL_LOAD = "WH_PM_ERROR_PLSQL_LOAD";
    public final static String WH_PM_ERROR_PLSQL_LOAD_TIMESTAMP_NULL = "WH_PM_ERROR_PLSQL_LOAD_TIMESTAMP_NULL";

    //Message Error Keys for Warehouse OM funtionality
    public final static String WH_OM_ERROR_TRANSACTION_ID_NULL = "WH_OM_ERROR_TRANSACTION_ID_NULL";
    public final static String WH_OM_ERROR_REQUIRED_FIELDS_BLANK = "WH_OM_ERROR_REQUIRED_FIELDS_BLANK";
    public final static String WH_OM_ERROR_CREATE_RECORDS = "WH_OM_ERROR_CREATE_RECORDS";
    public final static String WH_OM_ERROR_PLSQL_VALIDATE = "WH_OM_ERROR_PLSQL_VALIDATE";
    public final static String WH_OM_ERROR_PLSQL_LOAD = "WH_OM_ERROR_PLSQL_LOAD";
    public final static String WH_OM_ERROR_PLSQL_LOAD_TIMESTAMP_NULL = "WH_OM_ERROR_PLSQL_LOAD_TIMESTAMP_NULL";

    //Message Error Keys for Warehouse Lead Time funtionality
    public final static String WH_LEAD_TIME_ERROR_PLSQL_VALIDATE = "WH_LEAD_TIME_ERROR_PLSQL_VALIDATE";
    public final static String WH_LEAD_TIME_ERROR_PLSQL_LOAD = "WH_LEAD_TIME_ERROR_PLSQL_LOAD";
    public final static String WH_LEAD_TIME_ERROR_REQUIRED_FIELDS_BLANK = "WH_LEAD_TIME_ERROR_REQUIRED_FIELDS_BLANK";
    public final static String WH_LEAD_TIME_ERROR_TRANSACTION_ID_NULL = "WH_LEAD_TIME_ERROR_TRANSACTION_ID_NULL";
    public final static String WH_LEAD_TIME_ERROR_CREATE_RECORDS = "WH_LEAD_TIME_ERROR_CREATE_RECORDS";
    public final static String WH_LEAD_TIME_ERROR_INVALID_HIER_LEVEL = "WH_LEAD_TIME_ERROR_INVALID_HIER_LEVEL";

    //Message Error Keys for Store Packsize funtionality
    public final static String SP_ERROR_REQUIRED_FIELDS_BLANK = "SP_ERROR_REQUIRED_FIELDS_BLANK";
    public final static String SP_ERROR_TRANSACTION_ID_NULL = "SP_ERROR_TRANSACTION_ID_NULL";
    public final static String SP_ERROR_CREATE_RECORDS = "SP_ERROR_CREATE_RECORDS";
    public final static String SP_ERROR_PLSQL_VALIDATE = "SP_ERROR_PLSQL_VALIDATE";
    public final static String SP_ERROR_PLSQL_LOAD = "SP_ERROR_PLSQL_LOAD";

    //Message Error Keys for Store Source funtionality
    public final static String SS_ERROR_PLSQL_VALIDATE = "SS_ERROR_PLSQL_VALIDATE";
    public final static String SS_ERROR_PLSQL_LOAD = "SS_ERROR_PLSQL_LOAD";

    public final static String WAREHOUSE_ORDERABLE_UNIT_DB_CODE = "OU";
    public final static String WAREHOUSE_ORDER_MULTIPLE_DB_CODE = "OM";
    public final static String WAREHOUSE_PALLET_MULTIPLE_DB_CODE = "PM";
    public final static String DT_SEQ_PM_OM_LOU_STG = "DT_SEQ_PM_OM_LOU_STG";
    public final static String DT_SEQ_WH_RANGING_STG = "DT_SEQ_WH_RANGING_STG";
    public final static String DT_SEQ_WH_LEADTIME_STG = "DT_SEQ_WH_LEADTIME_STG";
    public final static String DT_SEQ_ST_PACKSIZE_STG = "DT_SEQ_ST_PACKSIZE_STG";
    public final static String DT_SEQ_ST_SOURCE_STG = "DT_SEQ_ST_SOURCE_STG";

    //All Permission constant entry starts here
    public final static String DT_ADMIN_ROLE = "SUPPLY_PLANNING_ADMIN_PRIV";

    public final static String L1DComponentPermission = "L1DPermission";
    public final static String L2DComponentPermission = "L2DPermission";
    public final static String L3DComponentPermission = "L3DPermission";
    public final static String L1EComponentPermission = "L1EPermission";
    public final static String L2EComponentPermission = "L2EPermission";
    public final static String L3EComponentPermission = "L3EPermission";

    public final static String BATCH_LOCK = "BATCH_LOCK";
    public final static String NO_ROW_SELECTED_FOR_SAVE_ST_PACK_SIZE = "NO_ROW_SELECTED_FOR_SAVE_ST_PACK_SIZE";


    //Message Error Keys for Warehouse Lead Time funtionality
    public final static String ST_LEAD_TIME_ERROR_PLSQL_VALIDATE = "ST_LEAD_TIME_ERROR_PLSQL_VALIDATE";
    public final static String ST_LEAD_TIME_ERROR_REQUIRED_FIELDS_BLANK = "WH_LEAD_TIME_ERROR_REQUIRED_FIELDS_BLANK";
    public final static String ST_LEAD_TIME_ERROR_TRANSACTION_ID_NULL = "WH_LEAD_TIME_ERROR_TRANSACTION_ID_NULL";
    //Store LeadTime status
    public final static String ST_STATUS_ACTIVE = "A";
    public final static String ST_STATUS_FUTURE = "F";
    public final static String ST_STATUS_INACTIVE = "I";
    public final static String DT_SEQ_ST_LEADTIME_STG = "DT_SEQ_ST_LEADTIME_STG";
    public final static String LEAD_TIME_ERROR_PLSQL_LOAD = "LEAD_TIME_ERROR_PLSQL_LOAD";

    public final static String HIGH = "HIGH";
    public final static String TIMESTAMP = "Timestamp";

    public final static String LOV_IDENTIFIER_SKU = "SKU";
    public final static String LOV_IDENTIFIER_SKU_PACKSIZE = "SKU_PACKSIZE";
    public final static String LOV_IDENTIFIER_SUPPLIER = "SUPPLIER";

    //Variable Entry for OnOffSaleSupply screen ---Start
    public final static String ON_OFF_SALE_SUPPLY_AM = "OnOffSaleSupplyAM";
    public final static String ON_OFF_SALE_SUPP_SEARCH_VO_ITR = "OnOffSaleSupplySearchFieldsVO1Iterator";
    public final static String ON_OFF_SALE_SUPP_RESULT_VO_ITR = "OnOffSaleSupplyResultVOIterator";
    public final static String ON_OFF_SALE_SUPP_ITEM_HIER_VO_ITR = "OnOffSaleSupplyItemHierPopupVO1Iterator";
    public final static String ON_OFF_SALE_STORE_VO_ITR = "OnOffSaleSupplyStorePopupVO1Iterator";

    //Search Params
    public static final String DEPT = "DEPT";
    public static final String CLASS = "CLASS";
    public static final String SUBCLASS = "SUBCLASS";
    public static final String ITEM = "ITEM";
    public static final String VPN = "VPN";
    public static final String VPN_COLOR = "VPN_COLOR";
    public static final String ITEM_LIST = "ITEM_LIST";
    public static final String STORE = "STORE";
    public static final String REGION = "REGION";
    public static final String STORE_LIST = "STORE_LIST";
    public static final String SUPPLIER = "SUPPLIER";
    public static final String WAREHOUSE = "WAREHOUSE";
    public static final String SUPP_LIST = "SUPP_LIST";
    public static final String ALL_STORES = "ALL_STORES";
    public static final String ALL_ITEMS = "ALL_ITEMS";
    public static final String SET_ALL_FLAG = "SET_ALL_FLAG";
    public static final String ON_SALE_DATE = "ON_SALE_DATE";
    public static final String OFF_SALE_DATE = "OFF_SALE_DATE";
    public static final String REC_EXCEEDS_LIMIT = "REC_EXCEEDS_LIMIT";

    //OOSS screen validation messages
    public static final String OSOS_ITEM_VALIDATION = "OSOS_ITEM_VALIDATION";
    public static final String OSOS_LOCATION_VALIDATION = "OSOS_LOCATION_VALIDATION";
    public static final String OSOS_SUPPLIER_VALIDATION = "OSOS_SUPPLIER_VALIDATION";
    //DB Package names Entry for OnOffSaleSupply screen ---Start
    public static final String PLSQL_SEARCH_ON_OFF_SALE_SUPPLY = "DT_ON_OFF_SALE_SUPPLY_SQL.SEARCH_ON_OFF_SALE_SUPPLY";
    public static final String PLSQL_SAVE_ON_OFF_SALE_SUPPLY = "DT_ON_OFF_SALE_SUPPLY_SQL.SAVE_ON_OFF_SALE_SUPPLY";
    public static final String PLSQL_PROCESS_RULES_ON_OFF_SALE_SUPPLY =
        "DT_ON_OFF_SALE_SUPPLY_SQL.PROCESS_ON_OFF_SALE_SUPPLY";
    public static final String BIND_CLASS_ID = "bindClassId";
    public static final String BIND_SUBCLASS_ID = "bindSubClassId";
    public static final String BIND_VPN_ID = "bindVpnId";
    public static final String BIND_VPN_COLOR_ID = "bindVpnColorId";
    public static final String BIND_SUPPLIER_ID = "bindSupplierId";
    public static final String BIND_STORE_ID = "bindStoreId";
    public static final String BIND_DEPARTMENT_ID = "bindDepartmentId";
    public static final String BIND_REGION_ID = "bindRegionId";
    public static final String BIND_ID = "bindId";
    public static final String BIND_DESTINATION_SEQ = "bindDestinationSeq";
    public static final String BIND_SKU_ID = "bindSkuId";

    public static final String SELECTION_TYPE = "SELECTION_TYPE";
    public static final String SELECTION_LEVEL = "SELECTION_LEVEL";
    public static final String IS_EXCEPTION = "IS_EXCEPTION";

    public static final String OSOS_ON_SALE_GRT_VADATE_MSG = "OSOS_ON_SALE_GRT_VADATE_MSG";
    public static final String OSOS_OFF_SALE_GRT_VADATE_MSG = "OSOS_OFF_SALE_GRT_VADATE_MSG";
    public static final String OSOS_OFF_SALE_LESS_ON_SALE_MSG = "OSOS_OFF_SALE_LESS_ON_SALE_MSG";
    public static final String OSOS_ON_SALE_GRT_OFF_SALE_MSG = "OSOS_ON_SALE_GRT_OFF_SALE_MSG";

    public static final String STORE_SELECTION_TYPE = "STORE_SELECTION_TYPE";
    public static final String SUPPLIER_SELECTION_TYPE = "SUPPLIER_SELECTION_TYPE";


    public static final String SEARCH_ERROR_CODE = "ERROR_CODE";
    public static final String SEARCH_ERROR_MESSAGE = "ERROR_MESSAGE";
    public static final String SEARCH_PLSQL_RETURN_STATUS = "PLSQL_RETURN_STATUS";

    public static final String START_DATE = "START_DATE";
    public static final String END_DATE = "END_DATE";

    public static final String OOSS_EXPORT_FILE_NAME = "OOSS_EXPORT_FILE_NAME";

    public static final String DATE_FORMAT_FOR_FILE_NAME = "MMddyyyy_HHmmss";
    public static final String EXPORT_FILE_FORMAT = ".xls";
    public static final String CDS_EXPORT_FILE_NAME = "CDS_EXPORT_FILE_NAME";
    public final static String CDS_AM = "CrossDockSetupAM";
    public final static String REGION_SELECTION_TYPE = "R";
    public final static String ALL_STORE_SELECTION_TYPE = "A";
    public final static String STOCKING_POINT_XD_VC = "StockingPointXDVC";
    public final static String STOCKING_POINT_RS_VC = "StockingPointRSVC";
    public final static String STOCKING_POINT_VC_BIND_NAME = "bindWarehouseType";
    public final static String SAVE_ERROR_MSG = "SAVE_ERROR_MSG";
    public final static String SAVE_AND_CLOSE_ERROR_MSG = "SAVE_AND_CLOSE_ERROR_MSG";
    public final static String ENTER_PROPER_START_DATE = "ENTER_PROPER_START_DATE";
    public final static String START_DATE_NULL = "START_DATE_NULL";
    public final static String ENTER_PROPER_END_DATE = "ENTER_PROPER_END_DATE";
    public final static String END_DATE_NULL = "END_DATE_NULL";
    public final static String SELECT_ROW_FOR_SETALL = "SELECT_ROW_FOR_SETALL";
    public final static String UPDATE_IND_1 = "1";
    public final static String UPDATE_IND_0 = "0";
    public final static String UPDATE_IND_ATTR = "UpdateInd";
    public final static String MAX_HOLDING_TIME = "MAX_HOLDING_TIME";
    public final static String PROCESSING_TIME = "PROCESSING_TIME";
    public final static String DOW_INPUT_IS_NULL = "DOW_INPUT_IS_NULL";

    // Create List Messages Starts
    public final static String WORK_LEVEL_ATTR_VAL_EL = "#{bindings.WorkingLevelAttr.attributeValue}";
    public final static String WORK_LEVEL_INPUT_VALUE_EL = "#{bindings.WorkingLevelAttr.inputValue}";
    public final static String LIST_NAME_INPUT_VAL_EL = "#{bindings.ListNameAttr.inputValue}";
    public final static String LIST_PRIVACY_INPUT_VAL_EL = "#{bindings.ListPrivacyAttr.inputValue}";
    public final static String LIST_PRIVACY_ATTR_VAL_EL = "#{bindings.ListPrivacyAttr.attributeValue}";
    public final static String REGION_CODE_INPUT_VAL_EL = "#{bindings.RegionCodeAttr.inputValue}";

    public final static String VALIDATE_LIST_NAME_DUPLICATE_OPERBIND = "validateListNameDuplicate";
    public final static String CREATE_SEARCH_LIST_RESULT_OPERBIND = "createSearchListResult";
    public final static String ON_CLICK_RESET_ACTION_OPERBIND = "onClickResetAction";
    public final static String FILTER_STOREVO_OPERBIND = "filterStoreVO";
    public final static String SAVE_CREATE_LIST_OPERBIND = "saveCreateList";

    public final static String LEVEL_TYPE_OPERMAP = "levelType";
    public final static String SELCTED_CODE_OPERMAP = "selctedCode";
    public final static String SELECTED_VALUES_OPERMAP = "selectedValues";

    public final static String SUPPLY_LIST_SEARCH_PROGVO_ITER = "SupplyListCreationProgVO1Iterator";
    public final static String VPN_CODE_ATTR = "VPN";
    public final static String VPN_COLORCODE_ATTR = "VPNOrColorCodeAttr";
    public final static String SKU_CODE_ATTR = "SKUCodeAttr";

    public final static String LIST_TYPE_CAN_NOT_BE_NULL = "LIST_TYPE_CAN_NOT_BE_NULL";
    public final static String LIST_NAME_CAN_NOT_BE_NULL = "LIST_NAME_CAN_NOT_BE_NULL";
    public final static String LIST_PRIVACY_CAN_NOT_BE_NULL = "LIST_PRIVACY_CAN_NOT_BE_NULL";
    public final static String DUPLICATE_LIST_NAME = "DUPLICATE_LIST_NAME";
    public final static String DEPARTMENT_CAN_NOT_NULL = "DEPARTMENT_CAN_NOT_NULL";
    public final static String VPN_CAN_NOT_BE_NULL = "VPN_CAN_NOT_BE_NULL";

    public final static String SAVE_YES_BTN = "saveYesBtn";
    public final static String SAVE_CLOSE_YES_BTN = "saveCloseYesBtn";
    public final static String CANCEL_YES_BTN = "cancelYesBtn";
    public final static String RESET_YES_BTN = "resetYesBtn";


    //LIST CREATION ATTRIBUTES STARTS

    public final static String LIST_ID_ATTR = "ListId";
    public final static String WAREHOUSE_ID_ATTR = "WarehouseId";
    public final static String STORE_ID_ATTR = "StoreId";
    public final static String COMMODITYCODE_ATTR = "CommodityCode";
    public final static String COMMODITYID_ATTR = "CommodityId";

    public final static String ROW_VAL_ATTR = "RowVal";

    public final static String ID_ATTR = "Id";
    public final static String NAME_ATTR = "Name";
    public final static String TYPE_ATTR = "Type";
    public final static String SUB_TYPE_ATTR = "SubType";
    public final static String PRIVACY_ATTR = "Privacy";
    public final static String IS_DELETED_ATTR = "IsDeleted";
    public final static String IS_AUTO_LIST_ATTR = "IsAutoList";
    public final static String TIME_STAMP_ATTR = "Timestamp";
    public final static String CREATE_USER_ATTR = "CreateUser";
    public final static String CREATE_DATE_ATTR = "CreateDate";
    //LIST CREATION ATTRIBUTES ENDS

    public final static String COMMODITY_CODE_IN = "COMMODITY_CODE IN ( ";
    public final static String STYLE_COLOR_CODE_IN = "STYLE_COLOR_CODE IN (";
    public final static String STYLE_CODE_IN = "STYLE_CODE IN (";
    public final static String STORE_QUERY = "SELECT store_id,store_code FROM V_DT_STORE_REGION WHERE store_code in (";
    public final static String WAREHOUSE_QUERY =
        "SELECT stocking_point_id,stocking_point_number FROM V_DT_STOCKING_POINT WHERE stocking_point_number in (";

    public static final String PRIVATE_DESC = "Private";
    public static final String PUBLIC_DESC = "Public";
    public static final String LOC_TYPE_ITEM = "Item";

    //List Maintain
    public static final String DT_LIST_HDR_ITER = "DtListHeadrVOIterator";
    public static final String ON_FETCH_LIST_DTLS_OPER = "onfetchListDtls";
    public static final String LIST_ID_OPER = "listId";
    public static final String SEARCH_CLICK_OPER = "onSearchClick";
    public static final String RESET_OPER = "onClickResetAction";
    public static final String SAVE_MAINTAIN_LIST_OPER = "saveMaintainList";

    public final static String UPDATE_USER_ATTR = "UpdateUser";
    public final static String UPDATE_DATE_ATTR = "UpdateDate";

    public final static String LIST_ID_BIND = "BV_N_List_Id";
    public final static String WHERE_IS_DELETED_TYPE = "is_deleted = 'N' and Type='";
    public final static String WHERE_NAME = "and name ='";
    public final static String WHERE_PRIVACY = "and privacy ='";

    public final static String ERR_SELECT_LIST = "ERR_SELECT_LIST";
    //List Maintain
    public static final String RESET_POPUP_ID = "resetPopup";

    public final static String STORE_REGION_VC = "StoreRegionVOCriteria";

    // Create List Messages Ends

    //StringConstants moved to constants Starts
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String SEMI_COLON = ";";
    public static final String DASH = "-";
    public static final String DOT = ".";
    public static final String NULL = "null";
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String NEW_LINE = "\n";
    public static final String PIPE_WITH_SPACE = " | ";
    public static final String UNDERLINE = "_";
    public static final String SINGLE_QUOTE = "'";
    public static final String QUOTE_COMMA = "','";
    public static final String QUOTE_BRACE = "')";
    public final static String RESET_WHERE_VALUE = "1=2";
    public static final String PREFIX_PRIVATE = "pvt_";
    public static final String PREFIX_GLOBAL = "pub_";
    //StringConstants moved to constants Ends

    //MessageConstants moved to constants Starts
    public static final String MSG_BUNDLE = "oracle.retail.apps.aipdt.view.AIPDataToolUIBundle";
    public static final String DEFAULT_ERROR_MSG_KEY = "DEAFULT_ERROR_MSG";
    public static final String SQL_EXCEPTION_RECEIVED_KEY = "SQL_EXCEPTION_RECEIVED";
    public static final String DUPLICATE_EXCEPTION_ON_ROW_CREATION = "DUPLICATE_EXCEPTION_ON_ROW_CREATION";
    public static final String DEFAULT_ERROR_AND_DESC_MSG_KEY = "DEFAULT_ERROR_AND_DESC_MSG";
    public static final String CONCURRENT_ROW_MODIFICATION_DETECTED_KEY = "CONCURRENT_ROW_MODIFICATION_DETECTED";
    public static final String ON_SUPPLY_SUCCESS = "000";
    public static final String ON_SUPPLY_NO_DATE_SELECT = "001";
    public static final String ON_SUPPLY_INVALID_DATE = "002";
    public static final String ON_SUPPLY_NO_CHECK = "003";
    //MessageConstants moved to constants Ends

    public static final String DEPL_TYPE_EXPORT_FILE_NAME = "DEPL_TYPE_EXPORT_FILE_NAME";

    // Store Priority Matrix
    public static final String SAVE_MATRIX_OPERBIND = "saveMatrix";
    public static final String SAVE_MATRIX_VALIDATION_OPERBIND = "saveMatrixValidation";
    public static final String SEARCH_MATRIX_OPERBIND = "searchMatrix";
    public static final String SELECTED_ST_CODE_OPERMAP = "selectedStoreCodes";
    public static final String PRIMARY_WH_ERR =
        " store(s) does not have primary warehouse. Please map the primary warehouse. ";
    public static final String STOCKING_POINT_ID1_ATTR = "StockingPointId1";
    public static final String STOCKING_POINT_ID2_ATTR = "StockingPointId2";
    public static final String STOCKING_POINT_ID3_ATTR = "StockingPointId3";
    public static final String STORE_CODE_ATTR = "StoreCode";
    public static final String WH_VALIDATION_OPERBIND = "warehouseValidationrowLevel";

    public static final String WH1_COMPARE_WH2_ERR = "WH1_COMPARE_WH2_ERR";
    public static final String WH1_COMPARE_WH3_ERR = "WH1_COMPARE_WH3_ERR";
    public static final String WH2_COMPARE_WH3_ERR = "WH2_COMPARE_WH3_ERR";
    public static final String INVALID_COMBINATION_MATRIX = "contains invalid warehouse matrix.";
    // Store Priority Matrix


    // Deployment Type
    public static final String DEPARTMENTID_WHERE_CLAUSE_PARAM = "DEPARTMENT_ID";
    public static final String DEPLTYPE_SUPPLIERVO_ITER = "DeploymentTypeSupplierpopupVOIterator";
    public static final String DEPLTYPE_STOREVO_ITER = "DeploymentTypeStorePopupVOIterator";
    public static final String DEPLTYPE_ITEMPOPUPVO_ITER = "DeploymentTypeItemHierPopupVOIterator";
    // Deployment Type

    //XD Order Schedule - start
    public final static String XDOS_AM = "XDOrderScheduleAM";
    public final static String RSOS_AM = "RsOrderScheduleAM";
    public static final String XDOS_EXPORT_FILE_NAME = "XDOS_EXPORT_FILE_NAME";
    public final static String XDOS_SET_ALL_START_DATE_COMP_ID = "setAllStartDateId";
    public final static String XDOS_SET_ALL_END_DATE_COMP_ID = "setAllEndDateId";
    public final static int SUNDAY_INDEX = 1; 
    public final static int MONDAY_INDEX = 2; 
    public final static int TUESDAY_INDEX = 3; 
    public final static int WEDNESDAY_INDEX = 4; 
    public final static int THURSDAY_INDEX = 5; 
    public final static int FRIDAY_INDEX = 6; 
    public final static int SATURDAY_INDEX = 7; 
    public final static String SUN_LEAD_TIME = "SunLeadTime";
    public final static String MON_LEAD_TIME = "MonLeadTime";
    public final static String TUE_LEAD_TIME = "TueLeadTime";
    public final static String WED_LEAD_TIME = "WedLeadTime";
    public final static String THU_LEAD_TIME = "ThuLeadTime";
    public final static String FRI_LEAD_TIME = "FriLeadTime";
    public final static String SAT_LEAD_TIME = "SatLeadTime";
    public final static String DOW_VALUES_ARE_OVERLAPPED = "DOW_VALUES_ARE_OVERLAPPED";
    public final static String XDOS_DEPT_REQUIRED = "XDOS_DEPT_REQUIRED";
    public final static String XDOS_DEPT_OR_ITEM_LIST_REQUIRED = "XDOS_DEPT_OR_ITEM_LIST_REQUIRED";
    public final static String XDOS_WAREHOUSE_REQUIRED = "XDOS_WAREHOUSE_REQUIRED";
    public final static String XDOS_SUPPLIER_REQUIRED = "XDOS_SUPPLIER_REQUIRED";
    public final static String XDOS_PRODUCT_HIERARCHY_REQUIRED = "XDOS_PRODUCT_HIERARCHY_REQUIRED";
    public final static String XDOS_STORE_REQUIRED = "XDOS_STORE_REQUIRED";
    public final static String LEADTIME_CAN_BE_ENTERED_FOR_ONLY_ONE_DOW = "LEADTIME_CAN_BE_ENTERED_FOR_ONLY_ONE_DOW";
    public final static String FREQUENCY_IS_INVALID_FOR_SET_ALL = "FREQUENCY_IS_INVALID_FOR_SET_ALL";
    //XD Order Schedule - end


    // Corporate Non Planning Days

    public static final String DT_LOOKUP_CODES_VIEW_CRITERIA = "DtLookupCodesVOCriteria";
    public static final String DT_LOOKUP_CODES_TYPE_VARIABLE = "LOOKUP_TYPE";

    public static final String DEFAULT_LOOKUP_TYPE = "NP_DAY_DEF";
    public static final String EXCEPTION_LOOKUP_TYPE = "NP_DAY_EXP";
    public static final String DAY_TYPE = "NP_DAY_EXP";
    public static final String LOCATION_TYPE = "LOC_TYPE";
    public static final String LOCATION_ID = "LOC_ID";
    public static final String CNPD_EXPORT_FILE_NAME = "CNPD_EXPORT_FILE_NAME";
    public static final String STORE_LOCATION_TYPE = "S";
    public static final String WAREHOUSE_LOCATION_TYPE = "W";
    public static final String NON_ORDER_DAY_TYPE = "NOR";
    public static final String NON_DELIVERY_DAY_TYPE = "NDL";
    public static final String NON_RECEIPT_DAY_TYPE = "NRC";
    public static final String NON_RELEASE_DAY_TYPE = "NRL";
    //

    public static final String DATE_FORMAT_UI_DISPLAY = "MM/dd/yyyy";

    public Constants() {
        super();
    }
}
