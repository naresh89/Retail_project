package oracle.retail.apps.aipdt.dt.model.appModule.common;

import java.util.Map;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jan 07 19:47:44 IST 2016
// ---------------------------------------------------------------------
public interface DeploymentTypeAM extends ApplicationModule {

    void filterStoreVO(String regId);

    void filterSupplierLOVVO(String deptId);

    void resetViewObject();

    void initActivity();


    String getIdsFromDtListDetailTable(Integer itemList, String TYPE);


    long handleCheckBoxAll(boolean isSelected);


    String getSupplierIdFromCode(String supplierCode, String deptId);


    Map handleSearch(Map inputMap);

    int handleSetAll(Map setAllMap);

    Map handleSave();
}
