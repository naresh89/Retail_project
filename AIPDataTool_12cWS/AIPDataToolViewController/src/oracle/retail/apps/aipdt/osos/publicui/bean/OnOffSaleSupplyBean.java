package oracle.retail.apps.aipdt.osos.publicui.bean;


import java.sql.Date;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.validator.ValidatorException;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.export.ExportContext;
import oracle.adf.view.rich.export.FormatHandler;
import oracle.adf.view.rich.util.ResetUtils;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.DateUtil;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.aipdt.osos.model.applicationmodule.common.OnOffSaleSupplyAM;
import oracle.retail.apps.aipdt.osos.model.view.OnOffSaleSupplyResultVORowImpl;
import oracle.retail.apps.framework.uicomponents.AppsPanelCustomComp;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

import org.apache.myfaces.trinidad.model.RowKeySetImpl;

public class OnOffSaleSupplyBean {
    private static ADFLogger logger = ADFLogger.createADFLogger(OnOffSaleSupplyBean.class);
    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();
    private Map searchParamMap = ADFContext.getCurrent().getPageFlowScope();

    private RichSelectOneChoice deptComp;
    private RichSelectOneChoice itemListComp;
    private RichSelectOneChoice storeListComp;
    private RichInputListOfValues supplierComp;

    private RichSelectOneChoice regionComp;

    private RichCommandButton searchComp;
    private RichCommandButton resetComp;

    private RichPopup resetPopup;
    private RichPopup itemValidationPopup;
    private RichPopup sourceValidationPopup;
    private RichPopup destinationValidationPopup;

    private RichPanelGroupLayout resultsArea;
    private RichTable resultTableComp;
    private RichPopup cancelPopup;
    private RichPopup saveSuccessPopup;
    private RichPopup saveFailedPopup;
    private RichPopup itemHierarchyPopup;

    private RichSelectBooleanCheckbox selectAllComp;
    private RichInputDate onSaleDateSetComp;
    private RichInputDate onSaleDateComp;
    private RichInputDate offSaleDateComp;
    private RichInputDate offSaleDateSetComp;
    private RichOutputText flagComp;
    private RichSelectBooleanCheckbox selectRecordComp;

    protected static String deptId = null;
    protected static String classId = null;
    protected static String subclassId = null;
    protected static String vpnColourIdVal = null;
    protected static String vpnIdVal = null;
    protected static String skuIdVal = null;

    protected static String itemListVal = null;
    protected static String storeVal = null;
    protected static String storeListVal = null;
    protected static String supplierVal = null;
    protected static String supplierListVal = null;
    protected static String regionIdVal = null;

    private boolean saveDisabled = true;
    private boolean isSaveCloseActioned = false;
    private RichPopup saveCloseSuccessPopup;
    private RichPopup storePopup;
    private RichPopup emptyResultPopup;

    private static String OSOS_SUPP_LOV_BIND = "filterSupplierLOVVO";
    private static String OSOS_STORE_LOV_BIND = "filterStoreVO";
    private static String OSOS_DEPT_PARAM = "deptId";
    private static String OSOS_REGION_PARAM = "regId";
    private static String OSOS_SELECT_CHECK_BOX_COMP = "Flag";
    private static int SUCCESS = 0;
    private static int FAIL = 1;

    public OnOffSaleSupplyBean() {
    }

    public void setDeptComp(RichSelectOneChoice deptComp) {
        this.deptComp = deptComp;
    }

    public RichSelectOneChoice getDeptComp() {
        return deptComp;
    }

    public void setItemListComp(RichSelectOneChoice itemListComp) {
        this.itemListComp = itemListComp;
    }

    public RichSelectOneChoice getItemListComp() {
        return itemListComp;
    }

    public void setStoreListComp(RichSelectOneChoice storeListComp) {
        this.storeListComp = storeListComp;
    }

    public RichSelectOneChoice getStoreListComp() {
        return storeListComp;
    }


    /* *********************************************************************************************************** */
    /* ******************************* START OF declarative components section *********************************** */
    /* *********************************************************************************************************** */

    public void setMultiSelectBaseFieldsBean(MultiSelectBaseFieldsBean multiSelectBaseFieldsBean) {
        this.multiSelectBaseFieldsBean = multiSelectBaseFieldsBean;
    }

    public MultiSelectBaseFieldsBean getMultiSelectBaseFieldsBean() {
        return multiSelectBaseFieldsBean;
    }

    /**
     * This method sets value of DepartmentId on to DepartmentId multiSelect component.
     */
    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")

    private void setDepartmentIdOnShuttleComponent() {
        try {
            deptId = (deptId != null && !deptId.isEmpty()) ? deptId : null;
            if (multiSelectBaseFieldsBean.getVpnComp() != null) {
                multiSelectBaseFieldsBean.getVpnComp().getValueInputText().setValue(deptId);
                multiSelectBaseFieldsBean.getVpnComp().setDEPARTMENT_ID(deptId);
            }
            if (multiSelectBaseFieldsBean.getStyleColourComp() != null) {
                multiSelectBaseFieldsBean.getStyleColourComp().getValueInputText().setValue(deptId);
                multiSelectBaseFieldsBean.getStyleColourComp().setDEPARTMENT_ID(deptId);
            }
            if (multiSelectBaseFieldsBean.getItemComp() != null) {
                multiSelectBaseFieldsBean.getItemComp().getValueInputText().setValue(deptId);
                multiSelectBaseFieldsBean.getItemComp().setDEPARTMENT_ID(deptId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method filters Class component based on DepartmentId value selected.
     */

    private void filterClassComponent() {
        logger.info("Entering  filterClassComponent()");
        try {
            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getClassComp());
            classId = null;
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("Class1", "DeparmentId", deptId, null, null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());

            /*Object oldInputTextValue = multiSelectBaseFieldsBean.getClassComp().getValueInputText().getValue();
            String classCode =
                multiSelectBaseFieldsBean.filterDependantLOV("Class1", "ClassCode", "DeparmentId", deptId,
                                                             oldInputTextValue, null, null);
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getClassComp().getValueInputText().setValue(classCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            classId = multiSelectBaseFieldsBean.getClassComp().getIdValueFromCode("Class1", classCode); */
        } catch (Exception e) {
            logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }


    /**
     * This method filters SubClass component based on DepartmentId and ClassId value selected.
     */

    private void filterSubClassComponent() {
        logger.info("Entering  filterSubClassComponent()");
        try {
            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getSubClassComp());
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("Subclass", "ClassId", classId,
                                                                          "DepartmentId", deptId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());

            /* Object oldInputTextValue = multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().getValue();

            String subClassCode =
                multiSelectBaseFieldsBean.filterDependantLOV("Subclass", "SubclassCode", "ClassId", classId,
                                                             oldInputTextValue, "DepartmentId", deptId);
            multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().setValue(subClassCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            subclassId = multiSelectBaseFieldsBean.getSubClassComp().getIdValueFromCode("Subclass", subClassCode);  */


        } catch (Exception e) {
            logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }


    /**
     * This method filters Item Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle
     * component which is correspondence to selected department.
     */

    private void filterSkuComponent() {
        logger.info("Entering  filterSkuComponent()");
        try {
            String codeVal = null;
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, vpnColourIdVal,
                                                                       multiSelectBaseFieldsBean.getItemComp());
            skuIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
            /*codeVal =
                multiSelectBaseFieldsBean.executeMultiShuttleForItem(deptId, "Item", "DepartmentId", "CommodityCode");
            multiSelectBaseFieldsBean.getItemComp().getValueInputText().setValue(codeVal);
            skuIdVal =
                multiSelectBaseFieldsBean.getShuttleComponentIdValue("Item", "CommodityId", "CommodityCode", "ITEM");  */
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
        } catch (Exception e) {
            logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }


    /**
     * This method filters VPN Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle
     * component which is correspondence to selected department.
     */

    private void filterVPNComponent() {
        logger.info("Entering  setFilterConditionToVPNComponent()");
        String vpnCodeVal = null;
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, null, null,
                                                                       multiSelectBaseFieldsBean.getVpnComp());
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
            vpnIdVal = null;
            /*vpnCodeVal =
                multiSelectBaseFieldsBean.executeMultiShuttleForVPN(deptId, "Vpn", "DepartmentId", "StyleCode");
            multiSelectBaseFieldsBean.getVpnComp().getValueInputText().setValue(vpnCodeVal);

            vpnIdVal = multiSelectBaseFieldsBean.getShuttleComponentIdValue("Vpn", "StyleId", "StyleCode", "VPN");  */

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());

        } catch (Exception e) {
            logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }

    /**
     * This method filters VPN/StyleColour Shuttle component based on DepartmentId value selected and sets the value to
     * ItemShuttle component which is correspondence to selected department.
     */

    private void filterVPNColourComponent() {
        logger.info("Entering  setFilterConditionToVPNStyleColourComponent()");
        String vpnColourCode = null;
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, null,
                                                                       multiSelectBaseFieldsBean.getStyleColourComp());
            vpnColourIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());

            /*vpnColourCode =
                multiSelectBaseFieldsBean.executeMultiShuttleForVPNColor(deptId, "StyleColor", "DepartmentId",
                                                                         "StyleColorCode");
            multiSelectBaseFieldsBean.getStyleColourComp().getValueInputText().setValue(vpnColourCode);

            vpnColourIdVal =
                multiSelectBaseFieldsBean.getShuttleComponentIdValue("StyleColor", "StyleColorId", "StyleColorCode",
                                                                     "VPN_COLOR");  */

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());

        } catch (Exception e) {
            logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }

    /**
     * This method filters SupplierComponent based on DepartmentId value selected and sets the value to ItemShuttle component which is correspondence to selected department.
     */
    @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")

    private void filterSupplierComponent() {
        logger.info("Entering  filterSupplierComponent()");
        try {
            OperationBinding supplierOpBind = AipdtUIUtil.findOperation(OSOS_SUPP_LOV_BIND);
            if (supplierOpBind != null) {
                supplierOpBind.getParamsMap().put(OSOS_DEPT_PARAM, deptId);
                supplierOpBind.execute();
            }
            if (deptId != null && !deptId.isEmpty()) {
                supplierComp.setDisabled(false);
            } else {
                //ResetUtils.reset(supplierComp);
                resetSelecOneChoiceComponent("Supplier");
                supplierComp.setDisabled(false);
            }
            supplierComp.resetValue();
            AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        } catch (Exception e) {
            logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }


    /* *********************************************************************************************************** */
    /* ******************************* END OF declarative components section ************************************* */
    /* *********************************************************************************************************** */

    /* *********************************************************************************************************** */
    /* ******************************* START OF ValueChangeEvents on Search Screen ******************************* */
    /* *********************************************************************************************************** */

    /**
     * This method used to enable/disable Product Hierarchy fields based on flag input value.
     * @param isDisable
     */

    private void disableProductHierarchyLevelFields(Boolean isDisable) {
        multiSelectBaseFieldsBean.getClassComp().setComponentDisable(isDisable);
        multiSelectBaseFieldsBean.getSubClassComp().setComponentDisable(isDisable);
        multiSelectBaseFieldsBean.getVpnComp().setDisabled(isDisable);
        multiSelectBaseFieldsBean.getStyleColourComp().setDisabled(isDisable);
        multiSelectBaseFieldsBean.getItemComp().setDisabled(isDisable);
        supplierComp.setDisabled(isDisable);

        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
    }


    /**
     * Invoked when department selected on screen
     * @param valueChangeEvent
     */
    public void onDepartmentChange(ValueChangeEvent valueChangeEvent) {
        Object newValue = valueChangeEvent.getNewValue();
        boolean isTrue = true;
        if (newValue != null && !newValue.toString().isEmpty()) {
            AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", newValue);
            deptId = AipdtUIUtil.resolveExpression("#{bindings.Department.attributeValue}").toString();
            filterClassComponent();
            filterSubClassComponent();
            filterVPNComponent();
            filterVPNColourComponent();
            filterSkuComponent();
            // Filtering Supplier component based on selected Department.
            filterSupplierComponent();
            isTrue = false;

            classId = null;
            subclassId = null;
            vpnColourIdVal = null;
            vpnIdVal = null;
            skuIdVal = null;
        } else {
            deptId = null;
        }

        disableProductHierarchyLevelFields(isTrue);
        itemListComp.setDisabled(!isTrue);
        AdfFacesContext.getCurrentInstance().addPartialTarget(itemListComp);
        
        setDepartmentIdOnShuttleComponent();
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
        
        AipdtUIUtil.setElExpression("#{bindings.Supplier.inputValue}", null);
        resetSelecOneChoiceComponent("Supplier");
        supplierComp.resetValue();
        AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
    }

    /**
     * Invoked when class selected on screen
     * @param valueChangeEvent
     */
    public void onClassChange(ValueChangeEvent valueChangeEvent) {
        Object newValue = valueChangeEvent.getNewValue();
        if (newValue != null && !newValue.toString().isEmpty()) {
            classId = String.valueOf(newValue);

            subclassId = null;
            vpnColourIdVal = null;
            vpnIdVal = null;
            skuIdVal = null;
        } else {
            classId = null;
        }
        //Filter Subclass/VPN/VPN-Color/Item values based on class value
        filterSubClassComponent();
        filterVPNComponent();
        filterVPNColourComponent();
        filterSkuComponent();
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Invoked when subclass selected on screen
     * @param valueChangeEvent
     */
    public void onSubclassChange(ValueChangeEvent valueChangeEvent) {
        Object newValue = valueChangeEvent.getNewValue();
        if (newValue != null && !newValue.toString().isEmpty()) {
            subclassId = String.valueOf(newValue);

            vpnColourIdVal = null;
            vpnIdVal = null;
            skuIdVal = null;
        } else {
            subclassId = null;
        }
        filterVPNComponent();
        filterVPNColourComponent();
        filterSkuComponent();
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Invoked when vpn selected on screen
     * @param valueChangeEvent
     */
    public void onVpnChange() {
        try {
            logger.info("Entering  onVpnChange()");
            String vpnCode = null;
            String newValue = this.getMultiSelectBaseFieldsBean().getVpnComp().getItemCompValue();
            logger.info("VPN newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                vpnCode = (String) newValue;

                vpnColourIdVal = null;
                skuIdVal = null;
            } else {
                vpnCode = null;
            }
            vpnIdVal = this.getMultiSelectBaseFieldsBean().getVpnComp().getIdValueFromCode();
            filterVPNColourComponent();
            filterSkuComponent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Invoked when style-colour selected on screen
     * @param valueChangeEvent
     */
    public void onStyleColourChange() {
        try {
            logger.info("Entering  onStyleColourChange()");
            String vpnCode = null;
            String newValue = this.getMultiSelectBaseFieldsBean().getStyleColourComp().getItemCompValue();
            if (newValue != null && !newValue.isEmpty()) {
                vpnCode = newValue;
                skuIdVal = null;
            } else {
                vpnCode = null;
            }
            vpnColourIdVal = this.getMultiSelectBaseFieldsBean().getStyleColourComp().getIdValueFromCode();
            filterSkuComponent();
            logger.info("onStyleColourChange newValue :" + vpnCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Invoked when item selected on screen
     * @param valueChangeEvent
     */
    public void onItemChange() {
        try {
            logger.info("Entering  onItemChange()");
            String newValue = this.getMultiSelectBaseFieldsBean().getItemComp().getItemCompValue();
            skuIdVal = this.getMultiSelectBaseFieldsBean().getItemComp().getIdValueFromCode();
            String skuCode = null;
            if (newValue != null && !newValue.isEmpty()) {
                skuCode = newValue;
            } else {
                skuCode = null;
            }
            logger.info("Item newValue :" + skuCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Invoked when item-list selected on screen
     * @param valueChangeEvent
     */
    public void onItemListChange(ValueChangeEvent valueChangeEvent) {
        String itemList = null;
        boolean isTrue = false;
        if (valueChangeEvent.getNewValue() != null && !valueChangeEvent.getNewValue().toString().isEmpty()) {
            AipdtUIUtil.setValueToEL("#{bindings.ItemList1.inputValue}", valueChangeEvent.getNewValue());
            itemList = AipdtUIUtil.resolveExpression("#{bindings.ItemList1.attributeValue}").toString();
            isTrue = true;
            disableProductHierarchyLevelFields(isTrue);
        }
        searchParamMap.put(Constants.ITEM_LIST, itemList);
        deptComp.setDisabled(isTrue);
        AdfFacesContext.getCurrentInstance().addPartialTarget(deptComp);
        supplierComp.setDisabled(!isTrue);
        AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Invoked when region selected on screen
     * @param valueChangeEvent
     */
    public void onRegionChange(ValueChangeEvent valueChangeEvent) {
        regionIdVal = null;
        boolean isTrue = false;
        if (valueChangeEvent.getNewValue() != null && !valueChangeEvent.getNewValue().toString().isEmpty()) {
            AipdtUIUtil.setValueToEL("#{bindings.Region.inputValue}", valueChangeEvent.getNewValue());
            regionIdVal = AipdtUIUtil.resolveExpression("#{bindings.Region.attributeValue}").toString();
            isTrue = true;
        }
        multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();

        //Filter StoreVOLOV VO based on RegionId.
        OperationBinding storeOpBind = AipdtUIUtil.findOperation(OSOS_STORE_LOV_BIND);
        if (storeOpBind != null) {
            storeOpBind.getParamsMap().put(OSOS_REGION_PARAM, regionIdVal);
            storeOpBind.execute();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        searchParamMap.put(Constants.REGION, regionIdVal);
        searchParamMap.put(Constants.STORE, null);
        searchParamMap.put(Constants.STORE_LIST, null);
        storeListComp.setDisabled(isTrue);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Invoked when store selected on screen
     * @param valueChangeEvent
     */
    public void onStoreChange(ValueChangeEvent valueChangeEvent) {
        String storeID = null;
        boolean isTrue = false;
        if (valueChangeEvent.getNewValue() != null) {
            storeID = valueChangeEvent.getNewValue().toString();
            isTrue = true;
        }
        searchParamMap.put(Constants.STORE, storeID);
        storeListComp.setDisabled(isTrue);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }

    /**
     * Below method invokes AmImpl method to reset ViewObject.
     */

    private void resetStoreComp() {
        OperationBinding storeOpBind = AipdtUIUtil.findOperation("resetViewObject");
        if (storeOpBind != null) {
            storeOpBind.execute();
        }
    }

    /**
     * Invoked when store-list selected on screen
     * @param valueChangeEvent
     */
    public void onStoreListChange(ValueChangeEvent valueChangeEvent) {
        String storeList = null;
        boolean isTrue = false;
        if (valueChangeEvent.getNewValue() != null && !valueChangeEvent.getNewValue().toString().isEmpty()) {
            AipdtUIUtil.setValueToEL("#{bindings.StoreList.inputValue}", valueChangeEvent.getNewValue());
            storeList = AipdtUIUtil.resolveExpression("#{bindings.StoreList.attributeValue}").toString();
            isTrue = true;
        }
        searchParamMap.put(Constants.REGION, null);
        searchParamMap.put(Constants.STORE, null);
        searchParamMap.put(Constants.STORE_LIST, storeList);
        regionComp.setDisabled(isTrue);
        AdfFacesContext.getCurrentInstance().addPartialTarget(regionComp);
        multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
        multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(isTrue);
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);

    }

    /**
     * Invoked when supplier selected on screen
     * @param valueChangeEvent
     */
    public void onSupplierChange(ValueChangeEvent valueChangeEvent) {
        String supplier = null;
        if (valueChangeEvent.getNewValue() != null && !valueChangeEvent.getNewValue().toString().isEmpty()) {
            AipdtUIUtil.setValueToEL("#{bindings.Supplier.inputValue}", valueChangeEvent.getNewValue());
            supplier = AipdtUIUtil.resolveExpression("#{bindings.Supplier.attributeValue}").toString();
        }
        searchParamMap.put(Constants.SUPPLIER, supplier);
        searchComp.setDisabled(disableSearchParams());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);

    }

    /**
     * Invoked when supplier-list selected on screen
     * @param valueChangeEvent
     */
    public void onSupplierListChnage(ValueChangeEvent valueChangeEvent) {

    }

    /* *********************************************************************************************************** */
    /* ******************************* END OF ValueChangeEvents on Search Screen ********************************* */
    /* *********************************************************************************************************** */

    /* *********************************************************************************************************** */
    /* ******************************* START OF Action Events on the Screen ************************************** */
    /* *********************************************************************************************************** */

    /**
     * Invoked on Search on screen
     */
    public String handleSearch() {
        int errorCode = 0;
        try {
            OnOffSaleSupplyAM oossAM =
                (OnOffSaleSupplyAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.ON_OFF_SALE_SUPPLY_AM);

            searchParamMap.put(Constants.DEPT, deptId);
            searchParamMap.put(Constants.CLASS, classId);
            searchParamMap.put(Constants.SUBCLASS, subclassId);
            searchParamMap.put(Constants.VPN, vpnIdVal);
            searchParamMap.put(Constants.VPN_COLOR, vpnColourIdVal);
            searchParamMap.put(Constants.ITEM, skuIdVal);

            Map outputMap = oossAM.handleSearch(searchParamMap);
            Object errorMessage = outputMap.get(Constants.SEARCH_ERROR_MESSAGE);
            Object result = outputMap.get(Constants.SEARCH_PLSQL_RETURN_STATUS);
            if (result == SUCCESS) {
                saveDisabled = false;
                disableSearchComponents();
                enableResultComponents();
                getResultsArea().setVisible(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsArea());
            } else {
                if (errorMessage == null) {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                    Constants.INVALID_SEARCH_CRITERIA),
                                                 null);
                } else {
                    AipdtUIUtil.showErrorMessage(errorMessage.toString(), null);
                }

            }
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
        return null;
    }

    /**
     * private function to validate search conditions
     */
    private boolean disableSearchParams() {
        if ((deptId == null) && searchParamMap.get(Constants.ITEM_LIST) == null) {
            return true;
        }
        if (searchParamMap.get(Constants.REGION) == null && searchParamMap.get(Constants.STORE) == null &&
            searchParamMap.get(Constants.STORE_LIST) == null) {
            return true;
        }
        if (searchParamMap.get(Constants.SUPPLIER) == null) {
            return true;
        }
        return false;
    }

    /**
     * Invoked when search returns recordset - This function will Disable Search Panel on the screen
     */
    private void disableSearchComponents() {
        deptComp.setDisabled(true);
        multiSelectBaseFieldsBean.getClassComp().setComponentDisable(true);
        multiSelectBaseFieldsBean.getSubClassComp().setComponentDisable(true);
        multiSelectBaseFieldsBean.getVpnComp().setDisabled(true);
        multiSelectBaseFieldsBean.getStyleColourComp().setDisabled(true);
        multiSelectBaseFieldsBean.getItemComp().setDisabled(true);
        itemListComp.setDisabled(true);
        //Destination section
        multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(true);
        regionComp.setDisabled(true);
        storeListComp.setDisabled(true);

        supplierComp.setDisabled(true);
        searchComp.setDisabled(true);
        refreshUIComponents();
    }

    /**
     * Invoked when search returns empty result - This function will enable Search Panel on the screen
     */
    private void enableResultComponents() {

    }

    /**
     * Invoked on Save
     */
    public String handleSave() {
        int errorCode = 0;
        try {
            ViewObject resultVO = AipdtUIUtil.findIterator(Constants.ON_OFF_SALE_SUPP_RESULT_VO_ITR).getViewObject();

            //If result table modified
            if (isRecordsSelected()) {
                OnOffSaleSupplyAM oossAM =
                    (OnOffSaleSupplyAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.ON_OFF_SALE_SUPPLY_AM);
                Map outputMap = oossAM.handleSave();
                Object errorMessage = outputMap.get(Constants.SEARCH_ERROR_MESSAGE);
                Object result = outputMap.get(Constants.SEARCH_PLSQL_RETURN_STATUS);
                //Handle save-close event
                if (isSaveCloseActioned) {
                    if (result == SUCCESS) {
                        ADFFacesUtil.showPopup(saveCloseSuccessPopup.getClientId(FacesContext.getCurrentInstance()));
                    } else {
                        AipdtUIUtil.getRootApplicationModule().getDBTransaction().rollback();
                        AipdtUIUtil.getRootApplicationModule().getDBTransaction().clearEntityCache(null);
                        AipdtUIUtil.invokeAction(Constants.CANCEL);
                    }
                } else {
                    //Handle save event
                    if (result == SUCCESS) {
                        ADFFacesUtil.showPopup(saveSuccessPopup.getClientId(FacesContext.getCurrentInstance()));
                    } else {
                        if (errorMessage == null) {
                            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                            Constants.INVALID_SEARCH_CRITERIA),
                                                         null);
                        } else {
                            AipdtUIUtil.showErrorMessage(errorMessage.toString(), null);
                        }
                    }
                }
            } else {
                ADFFacesUtil.showPopup(emptyResultPopup.getClientId(FacesContext.getCurrentInstance()));
            }

        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
        return null;
    }

    /**
     * Invoked on SaveAndClose - This will close the screen after save
     */
    public String handleSaveAndClose() {
        ViewObject resultVO = AipdtUIUtil.findIterator(Constants.ON_OFF_SALE_SUPP_RESULT_VO_ITR).getViewObject();
        //If result table modified
        if (resultVO.getApplicationModule().getTransaction().isDirty()) {
            isSaveCloseActioned = true;
            handleSave();
        } else {
            AipdtUIUtil.getRootApplicationModule().getDBTransaction().rollback();
            AipdtUIUtil.getRootApplicationModule().getDBTransaction().clearEntityCache(null);
            AipdtUIUtil.invokeAction(Constants.CANCEL);
        }
        return null;
    }



    /**
     * Invoked on Cancel - This will close the screen without save
     */
    public String handleCancel() {
        ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    /**
     * Invoked on Reset - This will reset the screen and clear cache
     */
    public String handleReset() {        
        ADFFacesUtil.showPopup(resetPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    /**
     * private function to reset all UI fields
     */
    private void resetAll() {
        deptId = null;
        classId = null;
        subclassId = null;
        vpnIdVal = null;
        vpnColourIdVal = null;
        skuIdVal = null;
        BindingContainer bc = AipdtUIUtil.getBindings();

        //Intially reset values on all UI components

        deptComp.resetValue();
        multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
        multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
        multiSelectBaseFieldsBean.getVpnComp().getValueInputText().setValue(null);
        multiSelectBaseFieldsBean.getStyleColourComp().getValueInputText().setValue(null);
        multiSelectBaseFieldsBean.getItemComp().getValueInputText().setValue(null);

        multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
        multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
        multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());

        itemListComp.resetValue();

        regionComp.resetValue();
        multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();

        storeListComp.resetValue();

        supplierComp.resetValue();

        //Disable/enable the UI components as per functionality
        deptComp.setDisabled(false);
        multiSelectBaseFieldsBean.getClassComp().setComponentDisable(true);
        multiSelectBaseFieldsBean.getSubClassComp().setComponentDisable(true);
        multiSelectBaseFieldsBean.getVpnComp().setDisabled(true);
        multiSelectBaseFieldsBean.getStyleColourComp().setDisabled(true);
        multiSelectBaseFieldsBean.getItemComp().setDisabled(true);
        itemListComp.setDisabled(false);
        //Destination section
        resetStoreComp();
        regionComp.setDisabled(false);
        multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(false);
        storeListComp.setDisabled(false);
        //Source Section
        supplierComp.setDisabled(true);
        getSelectAllComp().resetValue();

        searchComp.setDisabled(true);
        saveDisabled = true;
        //Clear Map
        searchParamMap.clear();
        resultTableComp.resetStampState();
        //Refresh the UI components
        refreshUIComponents();
        getResultsArea().setVisible(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsArea());
        onSaleDateSetComp.resetValue();
        offSaleDateSetComp.resetValue();
        AdfFacesContext.getCurrentInstance().addPartialTarget(onSaleDateSetComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(offSaleDateSetComp);
    }

    private void resetSelecOneChoiceComponent(String fieldName) {
        AipdtUIUtil.resetSelecOneChoiceComponent(fieldName);
    }

    /**
     * private function to refreshUIComponents
     */
    private void refreshUIComponents() {
        AdfFacesContext.getCurrentInstance().addPartialTarget(deptComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(itemListComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(regionComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);

        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchComp);
    }
    /* *********************************************************************************************************** */
    /* ******************************* END OF Action Events on the Screen **************************************** */
    /* *********************************************************************************************************** */

    public void cancelYesListener(ActionEvent actionEvent) {
        AipdtUIUtil.getRootApplicationModule().getDBTransaction().rollback();
        AipdtUIUtil.getRootApplicationModule().getDBTransaction().clearEntityCache(null);
        AipdtUIUtil.invokeAction(Constants.CANCEL);
    }

    /**
     * Invoked on Reset Yes condition - This will reset the screen and clear cache
     * @param ActionEvent
     */
    public void resetYesListener(ActionEvent actionEvent) {
        try {
            //actionEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());            
            OnOffSaleSupplyAM oossAM =
                (OnOffSaleSupplyAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.ON_OFF_SALE_SUPPLY_AM);
            oossAM.handleReset();
            resetAll();
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }
 
    public void setResetPopup(RichPopup resetPopup) {
        this.resetPopup = resetPopup;
    }

    public RichPopup getResetPopup() {
        return resetPopup;
    }

    public void setItemValidationPopup(RichPopup itemValidationPopup) {
        this.itemValidationPopup = itemValidationPopup;
    }

    public RichPopup getItemValidationPopup() {
        return itemValidationPopup;
    }

    public void setSourceValidationPopup(RichPopup sourceValidationPopup) {
        this.sourceValidationPopup = sourceValidationPopup;
    }

    public RichPopup getSourceValidationPopup() {
        return sourceValidationPopup;
    }

    public void setDestinationValidationPopup(RichPopup destinationValidationPopup) {
        this.destinationValidationPopup = destinationValidationPopup;
    }

    public RichPopup getDestinationValidationPopup() {
        return destinationValidationPopup;
    }

    public void setSearchComp(RichCommandButton searchComp) {
        this.searchComp = searchComp;
    }

    public RichCommandButton getSearchComp() {
        return searchComp;
    }

    public void setResetComp(RichCommandButton resetComp) {
        this.resetComp = resetComp;
    }

    public RichCommandButton getResetComp() {
        return resetComp;
    }

    public void setResultsArea(RichPanelGroupLayout resultsArea) {
        this.resultsArea = resultsArea;
    }

    public RichPanelGroupLayout getResultsArea() {
        return resultsArea;
    }

    public void setResultTableComp(RichTable resultTableComp) {
        this.resultTableComp = resultTableComp;
    }

    public RichTable getResultTableComp() {
        return resultTableComp;
    }

    public void setCancelPopup(RichPopup cancelPopup) {
        this.cancelPopup = cancelPopup;
    }

    public RichPopup getCancelPopup() {
        return cancelPopup;
    }

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = saveSuccessPopup;
    }

    public RichPopup getSaveSuccessPopup() {
        return saveSuccessPopup;
    }

    public void setSaveFailedPopup(RichPopup saveFailedPopup) {
        this.saveFailedPopup = saveFailedPopup;
    }

    public RichPopup getSaveFailedPopup() {
        return saveFailedPopup;
    }

    public void setSelectAllComp(RichSelectBooleanCheckbox selectAllComp) {
        this.selectAllComp = selectAllComp;
    }

    public RichSelectBooleanCheckbox getSelectAllComp() {
        return selectAllComp;
    }


    public void setOnSaleDateSetComp(RichInputDate onSaleDateSetComp) {
        this.onSaleDateSetComp = onSaleDateSetComp;
    }

    public RichInputDate getOnSaleDateSetComp() {
        return onSaleDateSetComp;
    }

    public void setOnSaleDateComp(RichInputDate onSaleDateComp) {
        this.onSaleDateComp = onSaleDateComp;
    }

    public RichInputDate getOnSaleDateComp() {
        return onSaleDateComp;
    }

    public void setOffSaleDateComp(RichInputDate offSaleDateComp) {
        this.offSaleDateComp = offSaleDateComp;
    }

    public RichInputDate getOffSaleDateComp() {
        return offSaleDateComp;
    }

    public void setOffSaleDateSetComp(RichInputDate offSaleDateSetComp) {
        this.offSaleDateSetComp = offSaleDateSetComp;
    }

    public RichInputDate getOffSaleDateSetComp() {
        return offSaleDateSetComp;
    }

    public void setFlagComp(RichOutputText flagComp) {
        this.flagComp = flagComp;
    }

    public RichOutputText getFlagComp() {
        return flagComp;
    }

    public void setRegionComp(RichSelectOneChoice regionComp) {
        this.regionComp = regionComp;
    }

    public RichSelectOneChoice getRegionComp() {
        return regionComp;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void setItemHierarchyPopup(RichPopup itemHierarchyPopup) {
        this.itemHierarchyPopup = itemHierarchyPopup;
    }

    public RichPopup getItemHierarchyPopup() {
        return itemHierarchyPopup;
    }

    public void setSupplierComp(RichInputListOfValues supplierComp) {
        this.supplierComp = supplierComp;
    }

    public RichInputListOfValues getSupplierComp() {
        return supplierComp;
    }

    public void setSaveCloseSuccessPopup(RichPopup saveCloseSuccessPopup) {
        this.saveCloseSuccessPopup = saveCloseSuccessPopup;
    }

    public RichPopup getSaveCloseSuccessPopup() {
        return saveCloseSuccessPopup;
    }

    public void setStorePopup(RichPopup storePopup) {
        this.storePopup = storePopup;
    }

    public RichPopup getStorePopup() {
        return storePopup;
    }


    public void setEmptyResultPopup(RichPopup emptyResultPopup) {
        this.emptyResultPopup = emptyResultPopup;
    }

    public RichPopup getEmptyResultPopup() {
        return emptyResultPopup;
    }

    public void setSelectRecordComp(RichSelectBooleanCheckbox selectRecordComp) {
        this.selectRecordComp = selectRecordComp;
    }

    public RichSelectBooleanCheckbox getSelectRecordComp() {
        return selectRecordComp;
    }

    /* *********************************************************************************************************** */
    /* ******************************* START OF Action Events on the result table header ************************* */
    /* *********************************************************************************************************** */

    /**
     * Invoke function to display the VPN/VPN-Color/Item details.
     */
    public void onClickViewItemPopup(ActionEvent actionEvent) {
        try {
            ViewObject itemHierVO =
                AipdtUIUtil.findIterator(Constants.ON_OFF_SALE_SUPP_ITEM_HIER_VO_ITR).getViewObject();
            if (itemHierVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.REC_EXCEEDS_LIMIT), null);
            } else {
                ADFFacesUtil.showPopup(itemHierarchyPopup.getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    /**
     * Invoke function to display the store details in the popup-onclick of ALL_STORES link.
     */
    public void onClickViewStorePopup(ActionEvent actionEvent) {
        try {
            ViewObject storeVO = AipdtUIUtil.findIterator(Constants.ON_OFF_SALE_STORE_VO_ITR).getViewObject();
            if (storeVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.REC_EXCEEDS_LIMIT), null);
            } else {
                ADFFacesUtil.showPopup(storePopup.getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    /**
     * private function to get selected row from table
     */
    private Object getSelectedRow(RichTable table) {
        Object _selectedRowData = table.getSelectedRowData();
        JUCtrlHierNodeBinding _nodeBinding = (JUCtrlHierNodeBinding) _selectedRowData;
        return _nodeBinding.getRow();
    }

    /**
     * Invoked on click of OffSaleDate Set All action in the header section of result table
     * @param ValueChangeEvent
     */
    public String handleOffSaleDateSetAll() {
        searchParamMap.put(Constants.SET_ALL_FLAG, 1);
        processSelectAll();
        return null;
    }

    /**
     * Invoked on click of OnSaleDate Set All action in the header section of result table
     * @param ValueChangeEvent
     */
    public String handleOnSaleDateSetAll() {
        searchParamMap.put(Constants.SET_ALL_FLAG, 0);
        processSelectAll();
        return null;
    }

    /**
     * Private function to process all select functions of result table header action events.
     */
    private void processSelectAll() {
        try {
            OnOffSaleSupplyAM oossAM =
                (OnOffSaleSupplyAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.ON_OFF_SALE_SUPPLY_AM);
            int result = oossAM.handleSetAllRules(searchParamMap);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getResultTableComp());
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    /**
     * Invoked on selection of OnSaleDate in the header section of result table
     * @param ValueChangeEvent
     */
    public void onOnSaleDateHeaderChange(FacesContext facesContext, UIComponent uIComponent, Object object) {
        java.util.Date onSaleDateHeader = (java.util.Date) object;
        searchParamMap.put(Constants.ON_SALE_DATE, onSaleDateHeader);
    }

    /**
     * Invoked on selection of OffSaleDate in the header section of result table
     * @param ValueChangeEvent
     */
    public void onOffSaleDateHeaderChange(FacesContext facesContext, UIComponent uIComponent, Object object) {
        java.util.Date offSaleDateHeader = (java.util.Date) object;
        searchParamMap.put(Constants.OFF_SALE_DATE, offSaleDateHeader);
    }

    /**
     * Invoked on selection of OnSaleDate in the detail section of result table
     * @param ValueChangeEvent
     */
    public void onOnSaleDateChange(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    }

    /**
     * Invoked on selection of OffSaleDate in the detail section of result table
     * @param ValueChangeEvent
     */
    public void onOffSaleDateChange(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    }

    /**
     * Invoked on selection of checkbox in the header section of result table
     * @param ValueChangeEvent
     */
    public void onAllRowsSelection(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        boolean isSelected = valueChangeEvent.getNewValue() == true ? true : false;
        try {
            OnOffSaleSupplyAM oossAM =
                (OnOffSaleSupplyAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.ON_OFF_SALE_SUPPLY_AM);
            long result = oossAM.handleCheckBoxAll(isSelected);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getResultTableComp());
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    /**
     * Invoked on selection of checkbox in the detail section of result table
     * @param ValueChangeEvent
     */
    public void onRowSelection(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        OnOffSaleSupplyResultVORowImpl currentRow =
            (OnOffSaleSupplyResultVORowImpl) getSelectedRow(getResultTableComp());
        if (valueChangeEvent.getNewValue() == true) {
            currentRow.setFlag(1);
        } else {
            currentRow.setFlag(0);
            getSelectAllComp().setValue(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectRecordComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(onSaleDateComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(offSaleDateComp);
    }

    /**
     * Invoked on exporting selected records -
     * @param ResultTableBinding, ResultTableIterator and CheckBox Component name
     */
    public Boolean exportSelectedRows(UIComponent uIComponent, ExportContext exportContext,
                                      FormatHandler formatHandler) {
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(Constants.ON_OFF_SALE_SUPP_RESULT_VO_ITR);
        if (dcItteratorBindings != null) {
            ViewObject resultVO = dcItteratorBindings.getViewObject();
            Row[] selectedRows = resultVO.getFilteredRows(OSOS_SELECT_CHECK_BOX_COMP, 1);
            RowKeySetImpl rks = new RowKeySetImpl();
            if (selectedRows != null && selectedRows.length > 0) {
                for (int i = 0; i < selectedRows.length; i++) {
                    Row row = selectedRows[i];
                    ArrayList<Object> keyList = new ArrayList<Object>(1);
                    keyList.add(row.getKey());
                    rks.add(keyList);
                }
            }
            if (rks.size() > 0) {
                getResultTableComp().setSelectedRowKeys(rks);
            } else {
                getResultTableComp().getSelectedRowKeys().clear();
                getResultTableComp().setSelectedRowKeys(rks);
            }
        }
        return true;
    }

    /**
     * Invoked on selecting query listener -
     * @param queryEvent
     */
    public void processQuery(QueryEvent queryEvent) {
        logger.info("****** Inside processQuery method ******");
        //Process default filter query event
        AipdtUIUtil.invokeQueryEventMethodExpression("#{bindings.OnOffSaleSupplyResultVOQuery.processQuery}",
                                                     queryEvent);
        //Enable or disable header level checkbox
        if (null != getSelectAllComp()) {
            if (isAllRecordsSelected()) {
                getSelectAllComp().setValue(Boolean.TRUE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
            } else {
                getSelectAllComp().setValue(Boolean.FALSE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
            }
        }
    }

    /**
     * Helper method to check whether the records are selected or not.
     * @return
     */
    private boolean isRecordsSelected() {
        logger.info("****** Inside isRecordsSelected method ******");
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(Constants.ON_OFF_SALE_SUPP_RESULT_VO_ITR);
        if (dcItteratorBindings != null) {
            ViewObject resultsVO = dcItteratorBindings.getViewObject();
            Row[] resultsRows = resultsVO.getFilteredRows(OSOS_SELECT_CHECK_BOX_COMP, 1);
            if ((resultsRows == null) || (resultsRows.length == 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to check whether all records are selected.
     * @return
     */
    private boolean isAllRecordsSelected() {
        logger.info("****** Inside isAllRecordsSelected method ******");
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(Constants.ON_OFF_SALE_SUPP_RESULT_VO_ITR);
        if (dcItteratorBindings != null) {
            ViewObject resultsVO = dcItteratorBindings.getViewObject();
            Row[] resultsRows = resultsVO.getFilteredRows(OSOS_SELECT_CHECK_BOX_COMP, 1);
            if (resultsRows != null && resultsRows.length == resultsVO.getEstimatedRowCount()) {
                return true;
            }
        }
        return false;
    }


    /**
     * Construts network path export file name
     * @return
     *      Export file name
     */
    public String getExportFileName() {
        return AipdtUIUtil.getExportFileName(Constants.OOSS_EXPORT_FILE_NAME);
    }
    /* *********************************************************************************************************** */
    /* ******************************* END OF Action Events on the result table header *************************** */
    /* *********************************************************************************************************** */


}
