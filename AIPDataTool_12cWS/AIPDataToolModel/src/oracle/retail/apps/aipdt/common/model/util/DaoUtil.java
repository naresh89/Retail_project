package oracle.retail.apps.aipdt.common.model.util;

import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;

import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupSearchVORowImpl;
import oracle.retail.apps.aipdt.common.Constants;

public class DaoUtil {
    public DaoUtil() {
        super();
    }

    public static void filterSuppliersByDepartment(ViewObject deptOrdFromSuppVO, String deptId) {
        if (deptOrdFromSuppVO != null) {
            if (deptId != null && !deptId.isEmpty()) {
                String whereClause = "DEPARTMENT_ID IN(" + Integer.valueOf(deptId) + ")";
                deptOrdFromSuppVO.setWhereClause(whereClause);
                deptOrdFromSuppVO.executeQuery();
            } else {
                deptOrdFromSuppVO.setWhereClause(null);
                deptOrdFromSuppVO.executeQuery();
            }
        }
    }

    public static void filterStoresByRegion(ViewObject storeVO, String selectedRegion) {
        if (storeVO != null && selectedRegion != null) {
            ViewCriteria storeVC = storeVO.getViewCriteriaManager().getViewCriteria("StoreRegionVOCriteria");
            VariableValueManager vm = storeVO.ensureVariableManager();
            vm.setVariableValue(Constants.REGION_ID_VC_REFERENCE, Integer.valueOf(selectedRegion));
            storeVC.setVariableManager(vm);
            storeVO.applyViewCriteria(storeVC);
            storeVO.executeQuery();
        } else {
            storeVO.applyViewCriteria(null);
            storeVO.executeQuery();
        }
    }
}
