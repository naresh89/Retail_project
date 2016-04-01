package oracle.retail.apps.aipdt.common;

public enum DtListDetail {

    CLASS_ID("CLASS_ID", "CLASS_ID"),
    SUBCLASS_ID("SUBCLASS_ID", "SUBCLASS_ID"),
    COMMODITY_ID("COMMODITY_ID", "COMMODITY_ID"),
    PACK_SIZE("PACK_SIZE", "PACK_SIZE"),
    WAREHOUSE_ID("WAREHOUSE_ID", "WAREHOUSE_ID"),
    SUPPLIER_ID("SUPPLIER_ID", "SUPPLIER_ID"),
    STORE_ID("STORE_ID", "STORE_ID"),
    LIST_ID("LIST_ID", "LIST_ID");

    private final String columnName;
    private final String columnDesc;

    private DtListDetail(String name, String desc) {
        this.columnName = name;
        this.columnDesc = desc;
    }

}
