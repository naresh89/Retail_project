package oracle.retail.apps.aipdt.common;

public enum ActivityType {
    
    CREATE("CREATE", "Create"),
    UPDATE("UPDATE", "Update"),
    DELETE("DELETE", "Delete");
    @SuppressWarnings("compatibility:7933748772590900690")
    private static final long serialVersionUID = 1L;


    private final String code;
    private final String desc;

    private ActivityType(String code, String desc) {
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

    public static ActivityType toStatus(String code) {
        for (ActivityType status : ActivityType.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
