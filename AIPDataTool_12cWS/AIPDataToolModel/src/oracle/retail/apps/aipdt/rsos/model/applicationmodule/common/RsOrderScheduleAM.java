package oracle.retail.apps.aipdt.rsos.model.applicationmodule.common;

import java.util.Map;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 23 18:02:34 IST 2016
// ---------------------------------------------------------------------
public interface RsOrderScheduleAM extends ApplicationModule {
    void initRsOrderSchedule();

    void filterStoreVO(String regId);

    String getIdsFromDtListDetailTable(Integer itemList, String type);

    String getSupplierIdFromCode(String supplierCode, String deptId);

    void handleReset();


    void filterSupplierLOVVO(String deptId);

    long handleCheckBoxAll(boolean isSelected);

    boolean handleSearch(Map<String, String> inputSearchCriteria);
}

