package oracle.retail.apps.aipdt.common.model.util;

public enum StoreProcErrorCode {
    ORACLE_ERROR("ORACLE_ERROR", "00", "Oracle Error"),
    TRN_ID_NULL("TRN_ID_NULL", "01", "Transaction Id is NULL"),
    TRN_ID_INVD("TRN_ID_INVD", "02", "Transaction Id is not valid"),
    TBL_ID_NULL("TBL_ID_NULL", "03", "Table Indicator is NULL"),
    TBL_ID_INVD("TBL_ID_INVD", "04", "Table Indicator is not valid"),
    TRN_TBL_NULL("TRN_TBL_NULL", "05", "Table Name or Transaction Id is NULL"),
    STG_TBL_DEL("STG_TBL_DEL", "06",
                "Only staging table records can be deleted"),
    NO_WH_FND("NO_WH_FND", "07", "No warehouse exists for the warehouse id"),
    NO_ST_FND("NO_ST_FND", "08", "No store exists for the store list id"),
    ALT_CDE_NULL("ALT_CDE_NULL", "09", "Alert Code is NULL"),
    ERR_ALERT("ERR_ALERT", "10", "Alert Error"),
    NO_VLDPKSZ("NO_VLDPKSZ", "11", "No valid source/demand group id/destination combination found"),
    RECORD_LOCKED("RECORD_LOCKED", "12", "Record locked by the user");

    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;

    private String code;
    private String id;
    private String desc;

    private StoreProcErrorCode(String code, String id, String desc) {
        this.code = code;
        this.id = id;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public static StoreProcErrorCode toErrorCode(String id) {
        if(StringUtil.isNullOrEmpty(id)){
            return null;
        }
        for (StoreProcErrorCode errorCode : StoreProcErrorCode.values()) {
            if (errorCode.getId().equals(id)) {
                return errorCode;
            }
        }
        return null;
    }
}
