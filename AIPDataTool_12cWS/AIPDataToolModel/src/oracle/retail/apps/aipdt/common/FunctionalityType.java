package oracle.retail.apps.aipdt.common;

public enum FunctionalityType {

    CREATE_LIST("CREATE_LIST", "Create List"),
    MAINTAIN_LIST("MAINTAIN_LIST", "Maintain List"),
    CREATE_WH_ORDER_CYCLE("CREATE_WH_ORDER_CYCLE", "Create Warehouse Order Cycle"),
    MAINTAIN_WH_ORDER_CYCLE("MAINTAIN_WH_ORDER_CYCLE", "Maintain Warehouse Order Cycle"),
    CREATE_ST_ORDER_CYCLE("CREATE_ST_ORDER_CYCLE", "Create Store Order Cycle"),
    MAINTAIN_ST_ORDER_CYCLE("MAINTAIN_ST_ORDER_CYCLE", "Maintain Store Order Cycle"),
    ST_ONOFFSUPPLYDATES_MNT("ST_ONOFFSUPPLYDATES_MNT", "Maintain On Off Supply Dates"),
    WH_RANGING_MNT("WH_RANGING_MNT", "Maintain Warehouse Ranging");
    
    @SuppressWarnings("compatibility:-5897625841457410941")
    private static final long serialVersionUID = 1L;


    private final String code;
    private final String desc;

    private FunctionalityType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String toString() {
        return desc;
    }

    public static FunctionalityType toStatus(String code) {
        for (FunctionalityType status : FunctionalityType.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

}
