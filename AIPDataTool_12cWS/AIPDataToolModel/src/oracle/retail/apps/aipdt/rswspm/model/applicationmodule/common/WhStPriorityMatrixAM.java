package oracle.retail.apps.aipdt.rswspm.model.applicationmodule.common;

import java.util.Map;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 09 15:12:16 IST 2016
// ---------------------------------------------------------------------
public interface WhStPriorityMatrixAM extends ApplicationModule {
    void initWhToStMatrix();


    void onClickResetAction();


    Map searchMatrix(String selectedStoreCodes);

    Map saveMatrix();

    String saveMatrixValidation();

    String warehouseValidationrowLevel();
}

