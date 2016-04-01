package oracle.retail.apps.aipdt.xdos.publicui.bean;

import com.oracle.retail.apps.comp.ms.view.SelectManyInputCheckBoxComponent;

import component.MultiSelectInputListOfValuesComponent;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.export.ExportContext;
import oracle.adf.view.rich.export.FormatHandler;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.common.publicui.bean.BaseRetailBean;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.aipdt.xdos.model.applicationmodule.common.XDOrderScheduleAM;
import oracle.retail.apps.aipdt.xdos.model.view.XDOrderScheduleResultsVORowImpl;
import oracle.retail.apps.aipdt.xdos.model.view.XDOrderScheduleTimeSetAllVORowImpl;
import oracle.retail.apps.framework.uicomponents.AppsPanelComponent;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

/**
 * Managed bean for XD Order Schedule Functionality. Holds the UI Component bindings and properties, even listener methods and
 * executes the business logic by invoking the AM methods exposed.
 */
public class XDOrderScheduleBean extends BaseRetailBean {
    @SuppressWarnings("compatibility:-1399113607473322536")
    private static final long serialVersionUID = 2714700244953687845L;

    private final static ADFLogger logger = ADFLogger.createADFLogger(XDOrderScheduleBean.class);

    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();

    private static final String XDOS_RESULTS_VO_ITERATOR = "XDOrderScheduleResultsVO1Iterator";
    private static final String ITEM_POPUP_VO_ITERATOR = "XDOrderScheduleItemHierPopupVO1Iterator";
    private static final String TIME_SET_ALL_POPUP_VO_ITERATOR = "XDOrderScheduleTimeSetAllVO1Iterator";

    private HashMap<String, Object> setAllMap = new HashMap<String, Object>();

    private boolean saveDisabled = true;
    private boolean isDefaultSelected = true;
    private boolean isExceptionSelected = false;
    private boolean isDefaultDisable = false;
    private boolean isExceptionDisable = false;

    private boolean isClassDisable = true;
    private boolean isSubClassDisable = true;
    private boolean isItemDisable = true;
    private boolean isStyleColourDisable = true;
    private boolean isItemListDisable = true;
    private boolean isVPNDisable = true;
    private boolean isStoreDisable = true;
    private boolean isStoreListDisable = true;
    private boolean isSupplierDisable = false;
    private boolean isSupplierListDisable = true;
    private boolean isAllItemDisable = true;
    private boolean isVpnColourDisable = true;
    private boolean isRegionDisable = true;
    private boolean isWarehouseDisable = false;

    protected static String deptId = null;
    protected static String classId = null;
    protected static String subclassId = null;

    protected static String itemListVal = null;

    protected static String vpnColourIdVal = null;
    protected static String vpnIdVal = null;
    protected static String skuIdVal = null;

    protected static String storeVal = null;
    protected static String storeListVal = null;
    protected static String supplierVal = null;
    protected static String supplierListVal = null;
    protected static String regionIdVal = null;
    protected static String warehouseIdVal = null;

    private static final String DEPT_SELECTION_TYPE = null;

    private static final String DEPT_SUPPLIER_STORE = null;
    private static final String DEPT_SUPPLIER_ALL_STORE = "A";
    private static final String DEPT_SUPPLIER_REGION = "R";

    private static final String CLASS_LEVEL_SELECTION_TYPE = "C";
    private static final String CLASS_STORE = "C";
    private static final String CLASS_ALL_STORE = "CA";
    private static final String CLASS_REGION = "CR";

    private static final String SUBCLASS_SELECTION_TYPE = "S";
    private static final String SUBCLASS_STORE = "S";
    private static final String SUBCLASS_ALL_STORE = "SA";
    private static final String SUBCLASS_REGION = "SR";

    private static final String VPN_SELECTION_TYPE = "ST";
    private static final String VPN_STORE = "ST";
    private static final String VPN_ALL_STORE = "STA";
    private static final String VPN_REGION = "STR";

    private static final String VPN_COLOUR_SELECTION_TYPE = "SC";
    private static final String VPN_COLOUR_STORE = "SC";
    private static final String VPN_COLOUR_ALL_STORE = "SCA";
    private static final String VPN_COLOUR_REGION = "SCR";

    private static final String ITEM_STORE_TYPE = "I";
    private static final String ITEM_ALL_STORE = "IA";
    private static final String ITEM_REGION = "IR";

    private long numberOfResultRecords;

    private AppsPanelComponent appsPanelBind;
    private RichSelectBooleanRadio defaultRadioComp;
    private RichSelectBooleanRadio exceptionRadioComp;
    private RichSelectOneChoice departmentComp;
    private SelectManyInputCheckBoxComponent classComp;
    private SelectManyInputCheckBoxComponent subClassComp;
    private RichSelectOneChoice itemListComp;
    private RichInputListOfValues supplierComp;
    private MultiSelectInputListOfValuesComponent vpnComp;
    private MultiSelectInputListOfValuesComponent styleColourComp;
    private MultiSelectInputListOfValuesComponent itemComp;
    private RichSelectOneChoice regionComp;
    private RichSelectOneChoice storeListComp;
    private RichButton searchBtn;
    private RichPanelGroupLayout resultsContainer;
    private RichPopup itemHierarchyPopup;
    private RichPopup storePopup;
    private RichPopup resetPopup;
    private RichPopup cancelPopup;
    private RichPopup saveCloseSuccessPopup;
    private RichSelectOneChoice warehouseComp;
    private RichSelectBooleanCheckbox checkBoxAllComp;
    private RichTable resultsTableComp;
    private RichPopup savePopup;
    private RichPopup saveClosePopup;
    private RichPopup saveSuccessPopup;
    private RichPopup timePopup;
    private RichInputDate setAllStartDateComp;
    private RichInputDate setAllEndDateComp;
    private RichTable dowTableComp;
    private RichPopup dowSetPopup;

    public XDOrderScheduleBean() {
        super();
    }

    /**
     * Invoked when Save button is clicked, which opens up the Save confirmation popup
     * @param actionEvent
     */
    public void handleSave(ActionEvent actionEvent) {
        logger.info("****** Inside handleSave method ******");
        int areRecordsValid = areRecordsSelectedForSave(true);
        if (areRecordsValid == 0) {
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.NO_RECORDS_SELECTED_FOR_SAVE),
                                         null);
            return;
        } else if (areRecordsValid == 1) {
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.NO_LEAD_TIME_ENTERED_FOR_SAVE),
                                         null);
            return;
        }
        if (getSavePopup() != null) {
            ADFFacesUtil.showPopup(getSavePopup().getClientId(FacesContext.getCurrentInstance()));
        }
    }

    /**
     * Invoked when SaveAndClose button is clicked, which opens up the SaveAndClose confirmation popup
     * @return
     */
    public String handleSaveAndClose() {
        logger.info("****** Inside handleSaveAndClose method ******");
        int areRecordsValid = areRecordsSelectedForSave(true);
        if (areRecordsValid == 0) {
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.NO_RECORDS_SELECTED_FOR_SAVE),
                                         null);
            return null;
        } else if (areRecordsValid == 1) {
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.NO_LEAD_TIME_ENTERED_FOR_SAVE),
                                         null);
            return null;
        }
        if (getSaveClosePopup() != null) {
            ADFFacesUtil.showPopup(getSaveClosePopup().getClientId(FacesContext.getCurrentInstance()));
        }
        return null;
    }

    /**
     * Invoked when Cancel button is clicked, which opens up the cancel confirmation popup
     * @return
     */
    public String handleCancel() {
        logger.info("****** Inside handleCancel method ******");
        ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    public void setAppsPanelBind(AppsPanelComponent appsPanelBind) {
        this.appsPanelBind = appsPanelBind;
    }

    public AppsPanelComponent getAppsPanelBind() {
        return appsPanelBind;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public boolean getSaveDisabled() {
        return saveDisabled;
    }

    public void setIsDefaultSelected(boolean isDefaultSelected) {
        this.isDefaultSelected = isDefaultSelected;
    }

    public boolean getIsDefaultSelected() {
        return isDefaultSelected;
    }

    public void setIsExceptionSelected(boolean isExceptionSelected) {
        this.isExceptionSelected = isExceptionSelected;
    }

    public boolean getIsExceptionSelected() {
        return isExceptionSelected;
    }

    public void setDefaultRadioComp(RichSelectBooleanRadio defaultRadioComp) {
        this.defaultRadioComp = defaultRadioComp;
    }

    public RichSelectBooleanRadio getDefaultRadioComp() {
        return defaultRadioComp;
    }

    public void setIsDefaultDisable(boolean isDefaultDisable) {
        this.isDefaultDisable = isDefaultDisable;
    }

    public boolean getIsDefaultDisable() {
        return isDefaultDisable;
    }

    public void setIsExceptionDisable(boolean isExceptionDisable) {
        this.isExceptionDisable = isExceptionDisable;
    }

    public boolean getIsExceptionDisable() {
        return isExceptionDisable;
    }

    /**
     * Invoked when default radio button value is changed.
     * @param valueChangeEvent
     */
    public void onDefaultVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onDefaultVCE method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        isDefaultSelected = (valueChangeEvent.getNewValue() != null) ? (Boolean) valueChangeEvent.getNewValue() : false;
        resetDeptAndItemList();
        enableDisableFields();
    }

    public void setExceptionRadioComp(RichSelectBooleanRadio exceptionRadioComp) {
        this.exceptionRadioComp = exceptionRadioComp;
    }

    public RichSelectBooleanRadio getExceptionRadioComp() {
        return exceptionRadioComp;
    }

    public void setIsClassDisable(boolean isClassDisable) {
        this.isClassDisable = isClassDisable;
    }

    public boolean getIsClassDisable() {
        return isClassDisable;
    }

    public void setIsSubClassDisable(boolean isSubClassDisable) {
        this.isSubClassDisable = isSubClassDisable;
    }

    public boolean getIsSubClassDisable() {
        return isSubClassDisable;
    }

    public void setIsItemDisable(boolean isItemDisable) {
        this.isItemDisable = isItemDisable;
    }

    public boolean getIsItemDisable() {
        return isItemDisable;
    }

    public void setIsStyleColourDisable(boolean isStyleColourDisable) {
        this.isStyleColourDisable = isStyleColourDisable;
    }

    public boolean getIsStyleColourDisable() {
        return isStyleColourDisable;
    }

    public void setIsItemListDisable(boolean isItemListDisable) {
        this.isItemListDisable = isItemListDisable;
    }

    public boolean getIsItemListDisable() {
        return isItemListDisable;
    }

    public void setIsVPNDisable(boolean isVPNDisable) {
        this.isVPNDisable = isVPNDisable;
    }

    public boolean getIsVPNDisable() {
        return isVPNDisable;
    }

    public void setIsStoreDisable(boolean isStoreDisable) {
        this.isStoreDisable = isStoreDisable;
    }

    public boolean getIsStoreDisable() {
        return isStoreDisable;
    }

    public void setIsStoreListDisable(boolean isStoreListDisable) {
        this.isStoreListDisable = isStoreListDisable;
    }

    public boolean getIsStoreListDisable() {
        return isStoreListDisable;
    }

    public void setIsSupplierDisable(boolean isSupplierDisable) {
        this.isSupplierDisable = isSupplierDisable;
    }

    public boolean getIsSupplierDisable() {
        return isSupplierDisable;
    }

    public void setIsSupplierListDisable(boolean isSupplierListDisable) {
        this.isSupplierListDisable = isSupplierListDisable;
    }

    public boolean getIsSupplierListDisable() {
        return isSupplierListDisable;
    }

    public void setIsAllItemDisable(boolean isAllItemDisable) {
        this.isAllItemDisable = isAllItemDisable;
    }

    public boolean getIsAllItemDisable() {
        return isAllItemDisable;
    }

    public void setIsVpnColourDisable(boolean isVpnColourDisable) {
        this.isVpnColourDisable = isVpnColourDisable;
    }

    public boolean getIsVpnColourDisable() {
        return isVpnColourDisable;
    }

    /**
     * Invoked when exception radio button value is changed
     * @param valueChangeEvent
     */
    public void onExceptionVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onExceptionVCE method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        isExceptionSelected =
            (valueChangeEvent.getNewValue() != null) ? (Boolean) valueChangeEvent.getNewValue() : false;
        resetDeptAndItemList();
        enableDisableFields();
        enableSearchButton();
    }

    /**
     * Resets the department and item list components on search screen
     */
    private void resetDeptAndItemList() {
        if (getDepartmentComp() != null) {
            deptId = null;
            AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", null);
            getDepartmentComp().resetValue();
            getDepartmentComp().setDisabled(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDepartmentComp());
        }
        if (getItemListComp() != null) {
            itemListVal = null;
            AipdtUIUtil.setValueToEL("#{bindings.ItemList.inputValue}", null);
            getItemListComp().resetValue();
            if (isExceptionSelected) {
                getItemListComp().setDisabled(false);
            } else {
                getItemListComp().setDisabled(true);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
        }
    }

    /**
     * Filters Class component based on DepartmentId value selected.
     */
    private void filterClassComponent() {
        logger.info("****** Inside filterClassComponent method ******");
        try {
            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getClassComp());
            classId = null;
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("Class1", "DeparmentId", deptId, null, null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        } catch (Exception e) {
            logger.severe("Exception occured in filterClassComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters SubClass component based on DepartmentId and ClassId value selected.
     */
    private void filterSubClassComponent() {
        logger.info("****** Inside filterSubClassComponent method ******");
        try {
            subclassId = null;
            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getSubClassComp());
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("Subclass", "ClassId", classId,
                                                                          "DepartmentId", deptId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        } catch (Exception e) {
            logger.severe("Exception occured in filterSubClassComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters VPN Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */
    private void filterVPNComponent() {
        logger.info("****** Inside filterVPNComponent method ******");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, null, null,
                                                                       multiSelectBaseFieldsBean.getVpnComp());
            vpnIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());

        } catch (Exception e) {
            logger.severe("Exception occured in filterVPNComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters VPN/StyleColour Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */
    private void filterVPNColourComponent() {
        logger.info("****** Inside filterVPNColourComponent method ******");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, null,
                                                                       multiSelectBaseFieldsBean.getStyleColourComp());
            vpnColourIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());

        } catch (Exception e) {
            logger.severe("Exception occured in filterVPNColourComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters Item Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */
    private void filterSkuComponent() {
        logger.info("****** Inside filterSkuComponent method ******");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, vpnColourIdVal,
                                                                       multiSelectBaseFieldsBean.getItemComp());
            skuIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
        } catch (Exception e) {
            logger.severe("Exception occured in filterSkuComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Resets Supplier component.
     */
    private void resetSupplierComponent() {
        logger.info("****** Inside resetSupplierComponent method ******");
        if (getSupplierComp() != null) {
            supplierVal = null;
            getSupplierComp().setValue(null);
            getSupplierComp().setSubmittedValue(null);
            getSupplierComp().processUpdates(FacesContext.getCurrentInstance());
            getSupplierComp().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
        }
    }

    /**
     * Helper method to reset region component.
     */
    private void resetRegionComponent() {
        logger.info("****** Inside resetRegionComponent method ******");
        if (getRegionComp() != null) {
            regionIdVal = null;
            AipdtUIUtil.setValueToEL("#{bindings.Region.inputValue}", null);
            getRegionComp().resetValue();
            getRegionComp().setDisabled(true);
            //setIsRegionDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
        }
    }

    /**
     * Helper method to reset store component.
     */
    private void resetStoreComponent() {
        logger.info("****** Inside resetStoreComponent method ******");
        if (multiSelectBaseFieldsBean.getStoreComp() != null) {
            storeVal = null;
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(true);
            //setIsStoreDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        }
    }

    /**
     * Helper method to reset StoreList component.
     */
    private void resetStoreListComponent() {
        logger.info("****** Inside resetStoreListComponent method ******");
        if (getStoreListComp() != null) {
            storeListVal = null;
            AipdtUIUtil.setValueToEL("#{bindings.StoreList.inputValue}", null);
            getStoreListComp().resetValue();
            getStoreListComp().setDisabled(true);
            //setIsStoreListDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
        }
    }


    /**
     * Helper method to reset Itemlist component.
     */
    private void resetItemListComponent() {
        logger.info("****** Inside resetItemListComponent method ******");
        if (getItemListComp() != null) {
            itemListVal = null;
            AipdtUIUtil.setValueToEL("#{bindings.ItemList.inputValue}", null);
            getItemListComp().resetValue();
            getItemListComp().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
        }
    }

    /**
     * Enable/disable ItemList component based on Exception Radio button selection and DeptId value.
     */
    private void enableDisableItemListComponent() {
        logger.info("****** Inside enableDisableItemListComponent method ******");
        if (isExceptionSelected) {
            if (!StringUtil.isNullOrEmpty(deptId)) {
                resetItemListComponent();
            } else {
                getItemListComp().setDisabled(false);
            }
        } else {
            resetItemListComponent();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
    }

    /**
     * Enable/disable search button based on the values selected in the search criteria.
     */
    private void enableSearchButton() {
        logger.info("****** Inside enableSearchButton method ******");
        if (isExceptionSelected) {
            if (!StringUtil.isNullOrEmpty(deptId) && !StringUtil.isNullOrEmpty(supplierVal) &&
                !StringUtil.isNullOrEmpty(warehouseIdVal)) {
                if ((!StringUtil.isNullOrEmpty(classId) || !StringUtil.isNullOrEmpty(subclassId) ||
                     !StringUtil.isNullOrEmpty(vpnIdVal) || !StringUtil.isNullOrEmpty(vpnColourIdVal) ||
                     !StringUtil.isNullOrEmpty(skuIdVal))) {
                    // Enable search button for Item Level
                    getSearchBtn().setDisabled(false);
                } else {
                    // Disable Search button.
                    getSearchBtn().setDisabled(true);
                }
            } else if (!StringUtil.isNullOrEmpty(itemListVal) && !StringUtil.isNullOrEmpty(supplierVal) &&
                       !StringUtil.isNullOrEmpty(warehouseIdVal)) {
                getSearchBtn().setDisabled(false);
            } else {
                getSearchBtn().setDisabled(true);
            }
        } else {
            if (!StringUtil.isNullOrEmpty(deptId) && !StringUtil.isNullOrEmpty(warehouseIdVal)) {
                getSearchBtn().setDisabled(false);
            } else {
                //Disable button as department component value is empty.
                getSearchBtn().setDisabled(true);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchBtn());
    }

    /**
     * Invoked when department value is changed in the search section.
     * @param valueChangeEvent
     */
    public void onDepartmentVCE(ValueChangeEvent valueChangeEvent) {
        try {
            logger.info("****** Inside onDepartmentVCE method ******");
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", valueChangeEvent.getNewValue());
            Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Department.attributeValue}");
            logger.info("Department newValue : " + newValue);

            if (newValue != null && !newValue.toString().isEmpty()) {
                deptId = String.valueOf(newValue);
            } else {
                deptId = null;
            }
            // Filtering Supplier component based on selected Department.
            filterSupplierComponent();
            setDepartmentIdOnShuttleComponent();
            enableDisableFields();
            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onDepartmentVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Enable/disable search fields
     */
    private void enableDisableFields() {
        if (isExceptionSelected) {
            //Exception
            if (!StringUtil.isNullOrEmpty(deptId)) {
                disableProductHierarchyLevelFields(false);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(false);

                filterClassComponent();

                filterSubClassComponent();

                filterVPNComponent();

                filterVPNColourComponent();

                filterSkuComponent();
            } else if (!StringUtil.isNullOrEmpty(itemListVal)) {
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(false);
            } else {
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(false);
            }
        } else {
            //Default
            if (!StringUtil.isNullOrEmpty(deptId)) {
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(true);
            } else {
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(true);
            }
        }
        enableDisableDepartment();
        enableDisableItemListComponent();
    }

    /**
     * Enable/disable department component on search panel
     */
    private void enableDisableDepartment() {
        if (getDepartmentComp() != null) {
            if (isExceptionSelected) {
                if (!StringUtil.isNullOrEmpty(itemListVal)) {
                    resetDepartment();
                } else {
                    getDepartmentComp().setDisabled(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getDepartmentComp());
                }
            } else {
                getDepartmentComp().setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getDepartmentComp());
            }
        }
    }

    /**
     * Resets department component on search panel
     */
    private void resetDepartment() {
        if (getDepartmentComp() != null) {
            deptId = null;
            AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", null);
            getDepartmentComp().resetValue();
            getDepartmentComp().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDepartmentComp());
        }
    }

    /**
     * Helper method to enable/disable Product Hierarchy fields based on flag input value.
     * @param isDisable
     */
    private void disableProductHierarchyLevelFields(boolean isDisable) {
        logger.info("****** Inside disableProductHierarchyLevelFields method ******");
        try {
            setIsItemDisable(isDisable);
            setIsVpnColourDisable(isDisable);
            setIsVPNDisable(isDisable);
            setIsSubClassDisable(isDisable);
            setIsClassDisable(isDisable);
            if (isDisable) {
                skuIdVal = null;
                classId = null;
                subclassId = null;
                vpnIdVal = null;
                vpnColourIdVal = null;
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
                multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
                multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        } catch (Exception e) {
            logger.severe("Exception occured in disableProductHierarchyLevelFields method");
            e.printStackTrace();
        }
    }

    /**
     * Helper method to disable source fields in the search section.
     * @param isDisable
     */
    private void disableSourceFields(boolean isDisable) {
        logger.info("****** Inside disableSourceFields method ******");
        if (getWarehouseComp() != null) {
            if (isDisable) {
                warehouseIdVal = null;
                AipdtUIUtil.setValueToEL("#{bindings.Warehouse.inputValue}", null);
                getWarehouseComp().resetValue();
            }
            getWarehouseComp().setDisabled(isDisable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getWarehouseComp());
        }
    }

    /**
     * Helper method to disable supplier field in the search section.
     * @param isDisable
     */
    private void disableSupplier(boolean isDisable) {
        if (getSupplierComp() != null) {
            if (isDisable) {
                resetSupplierComponent();
            } else {
                getSupplierComp().setDisabled(isDisable);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
            }
        }
    }

    /**
     * Helper method to enable/disable Destination fields based on flag input value.
     * @param isDisable
     */
    private void disableDestinationFields(boolean isDisable) {
        logger.info("****** Inside disableDestinationFields method ******");
        try {
            if (isDisable) {
                resetRegionComponent();
                resetStoreComponent();
                resetStoreListComponent();
            } else {
                getRegionComp().setDisabled(false);
                multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(false);
                getStoreListComp().setDisabled(false);

                setIsRegionDisable(false);
                setIsStoreDisable(false);
                setIsStoreListDisable(false);

                AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
                AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
                AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
            }
        } catch (Exception e) {
            logger.severe("Exception occured in disableDestinationFields method");
            e.printStackTrace();
        }
    }

    /**
     * Resets all Products Hierarchy fields and Destination fields.
     * It is called in two schenarios : 1. On click of Reset button and 2.On selection of empty department.
     */
    private void resetProductAndDestinationFields() {
        logger.info("****** Inside resetProductAndDestinationFields method ******");
        disableProductHierarchyLevelFields(true);
        resetItemListComponent();
        disableDestinationFields(true);
    }

    /**
     * Filters SupplierComponent based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */
    @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")
    private void filterSupplierComponent() {
        logger.info("****** Inside filterSupplierComponent method ******");
        try {
            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            xdosAM.filterSupplierLOVVO(deptId);
            if (getSupplierComp() != null) {
                supplierVal = null;
                getSupplierComp().setValue(null);
                getSupplierComp().setSubmittedValue(null);
                getSupplierComp().processUpdates(FacesContext.getCurrentInstance());
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
            }
        } catch (Exception e) {
            logger.severe("Exception occured in filterSupplierComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Helper method to set value of DepartmentId on DepartmentId multiSelect component.
     */
    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    private void setDepartmentIdOnShuttleComponent() {
        logger.info("****** Inside setDepartmentIdOnShuttleComponent method ******");
        try {
            deptId = !StringUtil.isNullOrEmpty(deptId) ? deptId : null;

            if (multiSelectBaseFieldsBean.getVpnComp() != null) {
                multiSelectBaseFieldsBean.setDepartmentIdOnShuttleComponent(deptId,
                                                                            multiSelectBaseFieldsBean.getVpnComp());
            }
            if (multiSelectBaseFieldsBean.getStyleColourComp() != null) {
                multiSelectBaseFieldsBean.setDepartmentIdOnShuttleComponent(deptId,
                                                                            multiSelectBaseFieldsBean.getStyleColourComp());
            }
            if (multiSelectBaseFieldsBean.getItemComp() != null) {
                multiSelectBaseFieldsBean.setDepartmentIdOnShuttleComponent(deptId,
                                                                            multiSelectBaseFieldsBean.getItemComp());
            }
        } catch (Exception e) {
            logger.severe("Exception occured in setDepartmentIdOnShuttleComponent method");
            e.printStackTrace();
        }

    }

    public void setDepartmentComp(RichSelectOneChoice departmentComp) {
        this.departmentComp = departmentComp;
    }

    public RichSelectOneChoice getDepartmentComp() {
        return departmentComp;
    }

    public void setClassComp(SelectManyInputCheckBoxComponent classComp) {
        this.classComp = classComp;
    }

    public SelectManyInputCheckBoxComponent getClassComp() {
        return classComp;
    }

    /**
     * Invoked when class value is changed in search section.
     * @param valueChangeEvent
     */
    public void onClassVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onClassVCE method ******");
        try {
            Object newValue = valueChangeEvent.getNewValue();
            logger.info("Class newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                classId = String.valueOf(newValue);
            } else {
                classId = null;
            }
            filterSubClassComponent();

            filterVPNComponent();

            filterVPNColourComponent();

            filterSkuComponent();
            enableSearchButton();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        } catch (Exception e) {
            logger.severe("Exception occured in onClassVCE method");
            e.printStackTrace();
        }
    }

    public void setSubClassComp(SelectManyInputCheckBoxComponent subClassComp) {
        this.subClassComp = subClassComp;
    }

    public SelectManyInputCheckBoxComponent getSubClassComp() {
        return subClassComp;
    }

    /**
     * Invoked when subclass value is changed in search section.
     * @param valueChangeEvent
     */
    public void onSubClassVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onSubClassVCE method ******");
        try {
            Object newValue = valueChangeEvent.getNewValue();
            logger.info("Subclass newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                subclassId = (String) newValue;
            } else {
                subclassId = null;
            }
            filterVPNComponent();

            filterVPNColourComponent();

            filterSkuComponent();

            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onSubClassVCE method");
            e.printStackTrace();
        }
    }

    public void setItemListComp(RichSelectOneChoice itemListComp) {
        this.itemListComp = itemListComp;
    }

    public RichSelectOneChoice getItemListComp() {
        return itemListComp;
    }

    /**
     * Invoked when item list value is changed in search section.
     * @param valueChangeEvent
     */
    public void onItemListVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onItemListVCE method ******");
        try {
            AipdtUIUtil.setValueToEL("#{bindings.ItemList.inputValue}", valueChangeEvent.getNewValue());
            Object newValue = AipdtUIUtil.resolveExpression("#{bindings.ItemList.attributeValue}");
            logger.info("ItemList value :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                itemListVal = String.valueOf(newValue);
            } else {
                itemListVal = null;
            }
            enableDisableFields();
        } catch (Exception e) {
            logger.severe("Exception occured in onItemListVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Invoked when supplier value is changed in search section.
     * @param valueChangeEvent
     */
    public void onSupplierVCE(ValueChangeEvent valueChangeEvent) {
        try {
            logger.info("****** Inside onSupplierVCE method ******");
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            Object newValue = valueChangeEvent.getNewValue();
            logger.info("Supplier newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                Object idVal = fetchSupplierIdFromCode(String.valueOf(newValue));
                supplierVal = idVal != null && !idVal.toString().isEmpty() ? idVal.toString() : null;

            } else {
                supplierVal = null;
            }
            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onSupplierVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Invokes AM method to fetch supplier Id for the given supplier code.
     * @param supplierCode
     * @return
     */
    private Object fetchSupplierIdFromCode(String supplierCode) {
        logger.info("****** Inside fetchSupplierIdFromCode method ******");
        XDOrderScheduleAM xdosAM = (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
        return xdosAM.getSupplierIdFromCode(supplierCode, deptId);
    }

    public void setSupplierComp(RichInputListOfValues supplierComp) {
        this.supplierComp = supplierComp;
    }

    public RichInputListOfValues getSupplierComp() {
        return supplierComp;
    }

    public void setVpnComp(MultiSelectInputListOfValuesComponent vpnComp) {
        this.vpnComp = vpnComp;
    }

    public MultiSelectInputListOfValuesComponent getVpnComp() {
        return vpnComp;
    }

    public void setStyleColourComp(MultiSelectInputListOfValuesComponent styleColourComp) {
        this.styleColourComp = styleColourComp;
    }

    public MultiSelectInputListOfValuesComponent getStyleColourComp() {
        return styleColourComp;
    }

    public void setItemComp(MultiSelectInputListOfValuesComponent itemComp) {
        this.itemComp = itemComp;
    }

    public MultiSelectInputListOfValuesComponent getItemComp() {
        return itemComp;
    }

    public void setRegionComp(RichSelectOneChoice regionComp) {
        this.regionComp = regionComp;
    }

    public RichSelectOneChoice getRegionComp() {
        return regionComp;
    }

    /**
     * Invoked when region value is changed in search section.
     * @param valueChangeEvent
     */
    public void onRegionVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onRegionVCE method ******");
        try {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            AipdtUIUtil.setValueToEL("#{bindings.Region.inputValue}", valueChangeEvent.getNewValue());
            Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Region.attributeValue}");
            logger.info("Region newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                regionIdVal = String.valueOf(newValue);
            } else {
                regionIdVal = null;
            }
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            storeVal = null;

            //Filter StoreVOLOV VO based on RegionId.
            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            xdosAM.filterStoreVO(regionIdVal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());

            disableStoreListComponent();

            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onRegionVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Helper method to disable store list component in search section.
     */
    private void disableStoreListComponent() {
        logger.info("****** Inside disableStoreListComponent method ******");
        try {
            if ((!StringUtil.isNullOrEmpty(regionIdVal)) || (!StringUtil.isNullOrEmpty(storeVal))) {
                resetStoreListComponent();
            } else {
                getStoreListComp().setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
            }
        } catch (Exception e) {
            logger.severe("Exception occured in disableStoreListComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Invoked when store value is changed in search section.
     * @param valueChangeEvent
     */
    public void onStoreVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onStoreVCE method ******");
        try {
            Object newValue = valueChangeEvent.getNewValue();
            logger.info("Store newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                storeVal = (String) newValue;
            } else {
                storeVal = null;
            }
            disableStoreListComponent();
            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onStoreVCE method");
            e.printStackTrace();
        }
    }

    public void setStoreListComp(RichSelectOneChoice storeListComp) {
        this.storeListComp = storeListComp;
    }

    public RichSelectOneChoice getStoreListComp() {
        return storeListComp;
    }

    /**
     * Invoked when store list value is changed in search section.
     * @param valueChangeEvent
     */
    public void onStoreListVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onStoreListVCE method ******");
        try {
            AipdtUIUtil.setValueToEL("#{bindings.StoreList.inputValue}", valueChangeEvent.getNewValue());
            Object newValue = AipdtUIUtil.resolveExpression("#{bindings.StoreList.attributeValue}");
            logger.info("StoreList newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                storeListVal = String.valueOf(newValue);
            } else {
                storeListVal = null;
            }
            disableRegionAndStoreComponent();
            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onStoreListVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Helper method to disable region and store components in search section.
     */
    private void disableRegionAndStoreComponent() {
        logger.info("****** Inside disableRegionAndStoreComponent method ******");
        try {
            if (!StringUtil.isNullOrEmpty(storeListVal)) {
                resetRegionComponent();
                resetStoreComponent();
            } else {
                getRegionComp().setDisabled(false);
                multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
                AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
            }
        } catch (Exception e) {
            logger.severe("Exception occured in disableRegionAndStoreComponent method");
            e.printStackTrace();
        }
    }

    public void setSearchBtn(RichButton searchBtn) {
        this.searchBtn = searchBtn;
    }

    public RichButton getSearchBtn() {
        return searchBtn;
    }

    /**
     * Invoked when search button is clicked from search section. Invokes AM method to stage
     * records in GTT table.
     * @param actionEvent
     */
    public void handleSearch(ActionEvent actionEvent) {
        logger.info("****** Inside handleSearch method ******");
        try {
            boolean isValidInput = validateInput();
            if (!isValidInput) {
                logger.warning("Values for One or more required search fields are missing.");
                return;
            }
            String itemValFromList = null;
            String storeValFromList = null;
            String selectionType = null;
            int selectLevel = 1;
            // This condition is to get All item which is belowngs to selected Item_List.
            if (StringUtil.isNullOrEmpty(deptId) && !StringUtil.isNullOrEmpty(itemListVal)) {
                itemValFromList = getItemValueFromDtListDetailTbl(Integer.valueOf(itemListVal));
            } else {
                itemValFromList = skuIdVal;
            }
            // This condition is to get All Stored belong to selected Store_List.
            if (StringUtil.isNullOrEmpty(storeVal) && !StringUtil.isNullOrEmpty(storeListVal)) {
                storeValFromList = getStoreValueFromDtListDetailTbl(Integer.valueOf(storeListVal));
            } else {
                storeValFromList = storeVal;
            }
            selectionType = findSelectionType();

            logger.info("Selection Type --> " + selectionType);

            selectLevel = findSelectionLevel();

            logger.info("Selection Level --> " + selectLevel);

            Map<String, String> input = new HashMap<String, String>();

            input.put(Constants.DEPT, deptId);
            input.put(Constants.CLASS, classId);
            input.put(Constants.SUBCLASS, subclassId);
            input.put(Constants.VPN, vpnIdVal);
            input.put(Constants.VPN_COLOR, vpnColourIdVal);
            input.put(Constants.ITEM, itemValFromList);
            input.put(Constants.REGION, regionIdVal);
            input.put(Constants.STORE, storeValFromList);
            input.put(Constants.SUPPLIER, supplierVal);
            input.put(Constants.WAREHOUSE, warehouseIdVal);
            input.put(Constants.SELECTION_LEVEL, String.valueOf(selectLevel));
            input.put(Constants.SELECTION_TYPE, selectionType);
            input.put(Constants.IS_EXCEPTION, isExceptionSelected ? Constants.YES : Constants.NO);

            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            boolean selectValid = xdosAM.handleSearch(input);
            if (!selectValid) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.INVALID_SEARCH_CRITERIA),
                                             null);
                return;
            }
            if (getNumberOfResultRecords() > 0) {
                disableSearchComponents();
                setSaveDisabled(false);
                if (getCheckBoxAllComp() != null) {
                    getCheckBoxAllComp().resetValue();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
                }
                if (getResultsContainer() != null) {
                    getResultsContainer().setVisible(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsContainer());
                }
            }

        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(jboEx.getLocalizedMessage(), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    /**
     * Returns the number of records from results table.
     * @return
     */
    public long getNumberOfResultRecords() {
        logger.info("****** Inside getNumberOfResultRecords method ******");
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
        if (dcItteratorBindings != null) {
            numberOfResultRecords = dcItteratorBindings.getEstimatedRowCount();
        }
        logger.info("Results Record Count :" + numberOfResultRecords);
        return numberOfResultRecords;
    }

    /**
     * Checks whether the required fields are entered on the search panel or not.
     * @return
     */
    private boolean validateInput() {
        boolean isValid = true;
        if (isExceptionSelected) {
            if (StringUtil.isNullOrEmpty(deptId) && StringUtil.isNullOrEmpty(itemListVal)) {
                isValid = false;
                AipdtUIUtil.showErrorMessageFromUIBundle(Constants.XDOS_DEPT_OR_ITEM_LIST_REQUIRED,
                                                         getDepartmentComp());
            } else if (StringUtil.isNullOrEmpty(supplierVal)) {
                isValid = false;
                AipdtUIUtil.showErrorMessageFromUIBundle(Constants.XDOS_SUPPLIER_REQUIRED, getSupplierComp());
            } else if (!StringUtil.isNullOrEmpty(deptId)) {
                if (StringUtil.isNullOrEmpty(classId) && StringUtil.isNullOrEmpty(subclassId) &&
                    StringUtil.isNullOrEmpty(vpnIdVal) && StringUtil.isNullOrEmpty(vpnColourIdVal) &&
                    StringUtil.isNullOrEmpty(skuIdVal)) {
                    isValid = false;
                    AipdtUIUtil.showErrorMessageFromUIBundle(Constants.XDOS_PRODUCT_HIERARCHY_REQUIRED, getClassComp());
                }
            }
            if (isValid && !StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal)) {
                isValid = false;
                AipdtUIUtil.showErrorMessageFromUIBundle(Constants.XDOS_STORE_REQUIRED,
                                                         multiSelectBaseFieldsBean.getStoreComp().getValueInputText());
            }
        } else {
            if (StringUtil.isNullOrEmpty(deptId)) {
                isValid = false;
                AipdtUIUtil.showErrorMessageFromUIBundle(Constants.XDOS_DEPT_REQUIRED, getDepartmentComp());
            }
        }
        if (isValid && StringUtil.isNullOrEmpty(warehouseIdVal)) {
            isValid = false;
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.XDOS_WAREHOUSE_REQUIRED, getWarehouseComp());
        }
        return isValid;
    }

    /**
     * Fetches Sku from DT_LIST_DETAIL table based on input item list value.
     * @param itemList
     * @return
     */
    private String getItemValueFromDtListDetailTbl(Integer itemList) {
        logger.info("****** Inside getItemValueFromDtListDetailTbl method ******");
        XDOrderScheduleAM xdosAM = (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
        return xdosAM.getIdsFromDtListDetailTable(itemList, "ITEM_LIST");
    }

    /**
     * Fetches store from DT_LIST_DETAIL table based on input store list value.
     * @param storeList
     * @return
     */
    private String getStoreValueFromDtListDetailTbl(Integer storeList) {
        logger.info("****** Inside getStoreValueFromDtListDetailTbl method ******");
        XDOrderScheduleAM xdosAM = (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
        return xdosAM.getIdsFromDtListDetailTable(storeList, "STORE_LIST");
    }

    /**
     * Finds selectionType value based on the Search criteria value.
     * @return
     */
    private String findSelectionType() {
        logger.info("****** Inside findSelectionType method ******");
        String selectionType = null;
        boolean isAllStoreSelected = isAllStoreSelected();
        if (!StringUtil.isNullOrEmpty(skuIdVal)) {
            if (!StringUtil.isNullOrEmpty(storeVal) && isAllStoreSelected) {
                selectionType = ITEM_ALL_STORE;
            } else if (StringUtil.isNullOrEmpty(regionIdVal) &&
                       (!StringUtil.isNullOrEmpty(storeVal) || !StringUtil.isNullOrEmpty(storeListVal))) {
                selectionType = ITEM_STORE_TYPE;
            } else if (!StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal)) {
                selectionType = ITEM_REGION;
            }
            return selectionType;
        }
        if (!StringUtil.isNullOrEmpty(vpnColourIdVal)) {
            if (!StringUtil.isNullOrEmpty(storeVal) && isAllStoreSelected) {
                selectionType = VPN_COLOUR_ALL_STORE;
            } else if (StringUtil.isNullOrEmpty(regionIdVal) &&
                       (!StringUtil.isNullOrEmpty(storeVal) || !StringUtil.isNullOrEmpty(storeListVal))) {
                selectionType = VPN_COLOUR_STORE;
            } else if (!StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal)) {
                selectionType = VPN_COLOUR_REGION;
            } else {
                selectionType = VPN_COLOUR_SELECTION_TYPE;
            }
            return selectionType;
        }

        if (!StringUtil.isNullOrEmpty(vpnIdVal)) {
            if (!StringUtil.isNullOrEmpty(storeVal) && isAllStoreSelected) {
                selectionType = VPN_ALL_STORE;
            } else if (StringUtil.isNullOrEmpty(regionIdVal) &&
                       (!StringUtil.isNullOrEmpty(storeVal) || !StringUtil.isNullOrEmpty(storeListVal))) {
                selectionType = VPN_STORE;
            } else if (!StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal)) {
                selectionType = VPN_REGION;
            } else {
                selectionType = VPN_SELECTION_TYPE;
            }
            return selectionType;
        }

        if (!StringUtil.isNullOrEmpty(subclassId)) {
            if (!StringUtil.isNullOrEmpty(storeVal) && isAllStoreSelected) {
                selectionType = SUBCLASS_ALL_STORE;
            } else if (StringUtil.isNullOrEmpty(regionIdVal) &&
                       (!StringUtil.isNullOrEmpty(storeVal) || !StringUtil.isNullOrEmpty(storeListVal))) {
                selectionType = SUBCLASS_STORE;
            } else if (!StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal)) {
                selectionType = SUBCLASS_REGION;
            } else {
                selectionType = SUBCLASS_SELECTION_TYPE;
            }
            return selectionType;
        }

        if (!StringUtil.isNullOrEmpty(classId)) {
            if (!StringUtil.isNullOrEmpty(storeVal) && isAllStoreSelected) {
                selectionType = CLASS_ALL_STORE;
            } else if (StringUtil.isNullOrEmpty(regionIdVal) &&
                       (!StringUtil.isNullOrEmpty(storeVal) || !StringUtil.isNullOrEmpty(storeListVal))) {
                selectionType = CLASS_STORE;
            } else if (!StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal)) {
                selectionType = CLASS_REGION;
            } else {
                selectionType = CLASS_LEVEL_SELECTION_TYPE;
            }
            return selectionType;
        }

        if (!StringUtil.isNullOrEmpty(deptId)) {
            if ((!StringUtil.isNullOrEmpty(storeVal) && isAllStoreSelected)) {
                selectionType = DEPT_SUPPLIER_ALL_STORE;
            } else if (StringUtil.isNullOrEmpty(regionIdVal) &&
                       (!StringUtil.isNullOrEmpty(storeVal) || !StringUtil.isNullOrEmpty(storeListVal))) {
                selectionType = DEPT_SUPPLIER_STORE;
            } else if (!StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal)) {
                selectionType = DEPT_SUPPLIER_REGION;
            } else if ((StringUtil.isNullOrEmpty(regionIdVal) && StringUtil.isNullOrEmpty(storeVal) &&
                        StringUtil.isNullOrEmpty(storeListVal) && !StringUtil.isNullOrEmpty(supplierVal))) {
                selectionType = DEPT_SUPPLIER_ALL_STORE;
            } else {
                selectionType = DEPT_SELECTION_TYPE;
            }
        }
        return selectionType;
    }

    /**
     * Helper method to check all stores is selected or not.
     * @return
     */
    private boolean isAllStoreSelected() {
        logger.info("****** Inside isAllStoreSelected method ******");
        return multiSelectBaseFieldsBean.isAllStoreSelected();
    }

    /**
     * Returns Selection Level : Dept or Dept/Supplier or VPN or Item level based on input provided in Search section.
     * @return
     */
    private int findSelectionLevel() {
        logger.info("****** Inside findSelectionLevel method ******");
        int level = 1;
        if (isExceptionSelected) {
            if (!StringUtil.isNullOrEmpty(skuIdVal)) {
                level = 4;
            } else if ((!StringUtil.isNullOrEmpty(classId)) || (!StringUtil.isNullOrEmpty(subclassId)) ||
                       (!StringUtil.isNullOrEmpty(vpnIdVal)) || (!StringUtil.isNullOrEmpty(vpnColourIdVal))) {
                level = 3;
            }
        } else if (!StringUtil.isNullOrEmpty(supplierVal)) {
            level = 2;
        }
        return level;
    }

    /**
     * Disables all the components on the search panel. Invoked on successful search.
     */
    private void disableSearchComponents() {
        logger.info("****** Inside disableSearchComponents method ******");
        //Disable search button
        getSearchBtn().setDisabled(true);
        //Default and Exception Radio Buttton Disable
        setIsDefaultDisable(true);
        setIsExceptionDisable(true);

        // Product Hierarchy disable
        getDepartmentComp().setDisabled(true);
        setIsItemListDisable(true);
        setIsClassDisable(true);
        setIsSubClassDisable(true);
        setIsVPNDisable(true);
        setIsVpnColourDisable(true);
        setIsItemDisable(true);

        //Supplier and Warehouse Components disable
        getSupplierComp().setDisabled(true);
        getWarehouseComp().setDisabled(true);

        //Destination fields disable
        //setIsRegionDisable(true);
        //setIsStoreDisable(true);
        //setIsStoreListDisable(true);

        getRegionComp().setDisabled(true);
        multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(true);
        getStoreListComp().setDisabled(true);

        AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchBtn());

        AdfFacesContext.getCurrentInstance().addPartialTarget(getDefaultRadioComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getExceptionRadioComp());

        AdfFacesContext.getCurrentInstance().addPartialTarget(getDepartmentComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());

        AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getWarehouseComp());

        AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
    }

    /**
     * Invoked when reset button is clicked from search section. It opens up reset confirmation popup.
     * @param actionEvent
     */
    public void handleReset(ActionEvent actionEvent) {
        logger.info("Entering  handleReset()");
        ADFFacesUtil.showPopup(resetPopup.getClientId(FacesContext.getCurrentInstance()));
    }

    public void setResultsContainer(RichPanelGroupLayout resultsContainer) {
        this.resultsContainer = resultsContainer;
    }

    public RichPanelGroupLayout getResultsContainer() {
        return resultsContainer;
    }

    public void setItemHierarchyPopup(RichPopup itemHierarchyPopup) {
        this.itemHierarchyPopup = itemHierarchyPopup;
    }

    public RichPopup getItemHierarchyPopup() {
        return itemHierarchyPopup;
    }

    public void setStorePopup(RichPopup storePopup) {
        this.storePopup = storePopup;
    }

    public RichPopup getStorePopup() {
        return storePopup;
    }

    public void setResetPopup(RichPopup resetPopup) {
        this.resetPopup = resetPopup;
    }

    public RichPopup getResetPopup() {
        return resetPopup;
    }

    /**
     * Resets the screen. Invoked when yes is selected from reset confirmation popup.
     * @param actionEvent
     */
    public void resetYesListener(ActionEvent actionEvent) {
        logger.info("****** Inside resetYesListener method ******");
        try {
            resetScreen();
            AipdtUIUtil.clearTableFilter(resultsTableComp);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getAppsPanelBind());
        } catch (Exception e) {
            logger.info("Exception occured in resetYesListener method");
            e.printStackTrace();
        }
    }

    /**
     * Helper method for resetting components on the screen.
     */
    private void resetScreen() {
        logger.info("****** Inside resetScreen method ******");
        try {
            getDepartmentComp().setDisabled(false);
            AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", null);
            getDepartmentComp().resetValue();
            deptId = null;
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDepartmentComp());

            supplierVal = null;
            getSupplierComp().setValue(null);
            getSupplierComp().setSubmittedValue(null);
            getSupplierComp().processUpdates(FacesContext.getCurrentInstance());
            getSupplierComp().setDisabled(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());

            resetProductAndDestinationFields();

            //resetSourceComponents();
            warehouseIdVal = null;
            AipdtUIUtil.setValueToEL("#{bindings.Warehouse.inputValue}", null);
            getWarehouseComp().resetValue();
            getWarehouseComp().setDisabled(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getWarehouseComp());

            defaultRadioComp.resetValue();
            defaultRadioComp.setValue(true);
            isDefaultSelected = true;
            isDefaultDisable = false;
            AdfFacesContext.getCurrentInstance().addPartialTarget(defaultRadioComp);

            exceptionRadioComp.resetValue();
            exceptionRadioComp.setValue(false);
            isExceptionSelected = false;
            isExceptionDisable = false;
            AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionRadioComp);

            saveDisabled = true;

            getSearchBtn().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchBtn());
            //resetItemListComponent();
            //enableDisableItemListComponent();
            getCheckBoxAllComp().resetValue();
            //resetPopup.hide();
            resetViewObjectOnReset();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultsContainer);
        } catch (Exception e) {
            logger.severe("Exception occured in resetScreen method");
            e.printStackTrace();
        }
    }

    /**
     * Helper method for clearing search and results view objects.
     */
    private void resetViewObjectOnReset() {
        logger.info("****** Inside resetViewObjectOnReset method ******");
        XDOrderScheduleAM xdosAM = (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
        xdosAM.handleReset();
    }

    public void closeResetPopUp(ActionEvent actionEvent) {
        closePopUp(resetPopup);
        resetPopup.hide();
    }

    public void closePopUp(RichPopup popUpId) {
        popUpId.hide();
    }

    public void setCancelPopup(RichPopup cancelPopup) {
        this.cancelPopup = cancelPopup;
    }

    public RichPopup getCancelPopup() {
        return cancelPopup;
    }

    /*public void cancelBtnPopUpYesListener(ActionEvent actionEvent) {
        cancelPopup.hide();
        AipdtUIUtil.invokeAction(Constants.CANCEL);
    }

    public void closeCancelPopUp(ActionEvent actionEvent) {
        closePopUp(cancelPopup);
    }

    public void setSaveFailedPopup(RichPopup saveFailedPopup) {
        this.saveFailedPopup = saveFailedPopup;
    }

    public RichPopup getSaveFailedPopup() {
        return saveFailedPopup;
    }

    public void handleSaveFailedOkEvent(ActionEvent actionEvent) {
        saveFailedPopup.hide();
    }*/

    public void setSaveCloseSuccessPopup(RichPopup saveCloseSuccessPopup) {
        this.saveCloseSuccessPopup = saveCloseSuccessPopup;
    }

    public RichPopup getSaveCloseSuccessPopup() {
        return saveCloseSuccessPopup;
    }

    public void setMultiSelectBaseFieldsBean(MultiSelectBaseFieldsBean multiSelectBaseFieldsBean) {
        this.multiSelectBaseFieldsBean = multiSelectBaseFieldsBean;
    }

    public MultiSelectBaseFieldsBean getMultiSelectBaseFieldsBean() {
        return multiSelectBaseFieldsBean;
    }

    public void setIsRegionDisable(boolean isRegionDisable) {
        this.isRegionDisable = isRegionDisable;
    }

    public boolean getIsRegionDisable() {
        return isRegionDisable;
    }

    public void setIsWarehouseDisable(boolean isWarehouseDisable) {
        this.isWarehouseDisable = isWarehouseDisable;
    }

    public boolean getIsWarehouseDisable() {
        return isWarehouseDisable;
    }

    /**
     * Invoked when warehouse value is changed in search section.
     * @param valueChangeEvent
     */
    public void onWarehouseVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onWarehouseVCE method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        AipdtUIUtil.setValueToEL("#{bindings.Warehouse.inputValue}", valueChangeEvent.getNewValue());
        Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Warehouse.attributeValue}");
        if (newValue != null && !newValue.toString().isEmpty()) {
            warehouseIdVal = (String) newValue;
        } else {
            warehouseIdVal = null;
        }
        enableSearchButton();
    }

    public void setWarehouseComp(RichSelectOneChoice warehouseComp) {
        this.warehouseComp = warehouseComp;
    }

    public RichSelectOneChoice getWarehouseComp() {
        return warehouseComp;
    }

    /**
     * Invoked when VPN value is changed in search section.
     *
     */
    public void onVpnVCE() {
        logger.info("****** Inside onVpnVCE method ******");
        try {
            String vpnCode = null;
            String newValue = multiSelectBaseFieldsBean.getVpnComp().getSelectedValues();
            logger.info("VPN newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                vpnCode = (String) newValue;
            } else {
                vpnCode = null;
            }
            vpnIdVal = multiSelectBaseFieldsBean.getVpnComp().getIdValueFromCode();
            filterVPNColourComponent();
            filterSkuComponent();
            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onVpnVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Invoked when VPN Color value is changed in search section.
     */
    public void onVpnColourVCE() {
        logger.info("****** Inside onVpnColourVCE method ******");
        try {
            String newValue = multiSelectBaseFieldsBean.getStyleColourComp().getSelectedValues();
            logger.info("VPN Colour newValue :" + newValue);
            String vpnColorCode = null;
            if (newValue != null && !newValue.isEmpty()) {
                vpnColorCode = newValue;
            } else {
                vpnColorCode = null;
            }
            vpnColourIdVal = multiSelectBaseFieldsBean.getStyleColourComp().getIdValueFromCode();

            filterSkuComponent();
            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onVpnColourVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Invoked when SKU value is changed in search section.
     */
    public void onSkuVCE() {
        logger.info("****** Inside onSkuVCE method ******");
        try {
            String newValue = multiSelectBaseFieldsBean.getItemComp().getSelectedValues();
            logger.info("Item newValue :" + newValue);
            String skuCode = null;
            if (newValue != null && !newValue.isEmpty()) {
                skuCode = newValue;
            } else {
                skuCode = null;
            }
            skuIdVal = multiSelectBaseFieldsBean.getItemComp().getIdValueFromCode();
            enableSearchButton();
        } catch (Exception e) {
            logger.severe("Exception occured in onSkuVCE method");
            e.printStackTrace();
        }

    }

    public void setCheckBoxAllComp(RichSelectBooleanCheckbox checkBoxAllComp) {
        this.checkBoxAllComp = checkBoxAllComp;
    }

    public RichSelectBooleanCheckbox getCheckBoxAllComp() {
        return checkBoxAllComp;
    }

    /**
     * Invoked when All check box value is changed in the results table.
     * @param valueChangeEvent
     */
    public void onCheckBoxAllValueChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onCheckBoxAllValueChange method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        logger.info("old value===>" + valueChangeEvent.getOldValue());
        logger.info("new  value===>" + valueChangeEvent.getNewValue());

        boolean oldValue =
            (valueChangeEvent.getOldValue() == null) ? false :
            Boolean.parseBoolean(valueChangeEvent.getOldValue().toString());
        boolean newValue =
            (valueChangeEvent.getNewValue() == null) ? false :
            Boolean.parseBoolean(valueChangeEvent.getNewValue().toString());
        if (oldValue != newValue) {
            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            long numberOfRecords = xdosAM.handleCheckBoxAll(newValue);
            if (numberOfRecords > 0) {
                if (getResultsTableComp() != null) {
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
                }
            }
        }
    }

    public void setResultsTableComp(RichTable resultsTableComp) {
        this.resultsTableComp = resultsTableComp;
    }

    public RichTable getResultsTableComp() {
        return resultsTableComp;
    }

    /**
     * Gives the export excel file name
     * @return
     */
    public String getExportFileName() {
        return AipdtUIUtil.getExportFileName(Constants.XDOS_EXPORT_FILE_NAME);
    }

    /**
     * Marks rows selected using check box for exporting to excel.
     * @param uIComponent
     * @param exportContext
     * @param formatHandler
     * @return
     */
    public boolean exportSelectedRows(UIComponent uIComponent, ExportContext exportContext,
                                      FormatHandler formatHandler) {
        logger.info("****** Inside exportSelectedRows method ******");
        AipdtUIUtil.selectAllRowsInTable(getResultsTableComp(), XDOS_RESULTS_VO_ITERATOR, Constants.UPDATE_IND_ATTR);
        return true;
    }

    public void setSavePopup(RichPopup savePopup) {
        this.savePopup = savePopup;
    }

    public RichPopup getSavePopup() {
        return savePopup;
    }

    /**
     * Saves the transaction. Invoked when yes is clicked from save confirmation poup.
     * @param actionEvent
     */
    public void handleSaveYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveYes method ******");
        try {
            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            xdosAM.saveXDOS();
            setSaveDisabled(true);
            if (getSaveSuccessPopup() != null) {
                ADFFacesUtil.showPopup(getSaveSuccessPopup().getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(jboEx.getLocalizedMessage(), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    public void setSaveClosePopup(RichPopup saveClosePopup) {
        this.saveClosePopup = saveClosePopup;
    }

    public RichPopup getSaveClosePopup() {
        return saveClosePopup;
    }

    /**
     * Saves the transaction and closes the screen tab. Invoked when yes is clicked from save and close confirmation poup.
     * @param actionEvent
     */
    public void handleSaveCloseYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveCloseYes method ******");
        try {
            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            xdosAM.saveXDOS();
            setSaveDisabled(true);
            if (getSaveCloseSuccessPopup() != null) {
                ADFFacesUtil.showPopup(getSaveCloseSuccessPopup().getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(jboEx.getLocalizedMessage(), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    /**
     * Cancels the transaction. Invoked when yes is clicked from cancel confirmation poup.
     * @param actionEvent
     */
    public void handleCancelYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleCancelYes method ******");
        AipdtUIUtil.invokeAction(Constants.CANCEL);
    }

    /**
     * Cancels transaction and Resets the screen. Invoked when yes is clicked from reset confirmation poup.
     * @param actionEvent
     */
    public void handleResetYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleResetYes method ******");
        try {
            resetScreen();
            AipdtUIUtil.clearTableFilter(resultsTableComp);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getAppsPanelBind());
        } catch (JboException jboEx) {
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(jboEx.getLocalizedMessage(), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                            Constants.DEAFULT_ERROR_MSG), null);
        }
    }

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = saveSuccessPopup;
    }

    public RichPopup getSaveSuccessPopup() {
        return saveSuccessPopup;
    }

    /**
     * Initializes the screeen after save. Invoked when ok is clicked from save successful confirmation popup.
     * @param actionEvent
     */
    public void handleSaveOk(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveOk method ******");
        handleResetYes(null);
    }

    /**
     * Closes the screen after save. Invoked when ok is clicked from save and close successful confirmation popup.
     * @param actionEvent
     */
    public void handleSaveCloseOk(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveCloseOk method ******");
        AipdtUIUtil.invokeAction(Constants.CLOSE_CONTENT);
    }

    /**
     * Helper method to check whether the records are selected for save or not.
     * @return
     */
    private int areRecordsSelectedForSave(boolean isSave) {
        logger.info("****** Inside areRecordsSelectedForSave method ******");
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
        if (dcItteratorBindings != null) {
            ViewObject resultsVO = dcItteratorBindings.getViewObject();
            Row[] resultsRows = resultsVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
            if ((resultsRows == null) || (resultsRows.length == 0)) {
                logger.warning("No records selected to save.");
                return 0;
            }
            if (isSave) {
                for (int rowIndex = 0; rowIndex < resultsRows.length; rowIndex++) {
                    Row resultRow = resultsRows[rowIndex];
                    Integer sunLT = (Integer) resultRow.getAttribute(Constants.SUN_LEAD_TIME);
                    Integer monLT = (Integer) resultRow.getAttribute(Constants.MON_LEAD_TIME);
                    Integer tueLT = (Integer) resultRow.getAttribute(Constants.TUE_LEAD_TIME);
                    Integer wedLT = (Integer) resultRow.getAttribute(Constants.WED_LEAD_TIME);
                    Integer thuLT = (Integer) resultRow.getAttribute(Constants.THU_LEAD_TIME);
                    Integer friLT = (Integer) resultRow.getAttribute(Constants.FRI_LEAD_TIME);
                    Integer satLT = (Integer) resultRow.getAttribute(Constants.SAT_LEAD_TIME);
                    if ((sunLT != null) || (monLT != null) || (tueLT != null) || (wedLT != null) || (thuLT != null) ||
                        (friLT != null) || (satLT != null)) {
                        continue;
                    }
                    return 1;
                }
            }
        }
        return 2;
    }

    /**
     * Checks whether the frequency value is same for all selected records or not.
     * @return
     */
    private int isFrequencySameForAllRecordsSelected() {
        logger.info("****** Inside isFrequencySameForAllRecordsSelected method ******");
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
        if (dcItteratorBindings != null) {
            ViewObject resultsVO = dcItteratorBindings.getViewObject();
            Row[] resultsRows = resultsVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
            int tempFreq = -1;
            for (int rowIndex = 0; rowIndex < resultsRows.length; rowIndex++) {
                Row resultRow = resultsRows[rowIndex];
                Integer frequency = (Integer) resultRow.getAttribute("Frequency");
                if ((frequency == null) || ((tempFreq != -1) && (tempFreq != frequency.intValue()))) {
                    return 0;
                }
                tempFreq = frequency.intValue();
            }
        }
        return 1;
    }

    /**
     * Invoked when Close is clicked from Item Hierarchy popup.
     * @param actionEvent
     */
    public void itemHierCloseListener(ActionEvent actionEvent) {
        itemHierarchyPopup.hide();
    }

    /**
     * Invoked on Department link selection to show Item/Sku hierarchy popup to user
     * @param actionEvent
     */
    public void onClickViewItemPopup(ActionEvent actionEvent) {
        logger.info("****** Inside onClickViewItemPopup method ******");
        ViewObject itemHierVO = AipdtUIUtil.findIterator(ITEM_POPUP_VO_ITERATOR).getViewObject();
        XDOrderScheduleResultsVORowImpl currentRow =
            (XDOrderScheduleResultsVORowImpl) getSelectedRow(getResultsTableComp());
        itemHierVO.setNamedWhereClauseParam(Constants.BIND_DEPARTMENT_ID, currentRow.getDeptId());
        itemHierVO.setNamedWhereClauseParam(Constants.BIND_SUPPLIER_ID, currentRow.getSupplierId());
        itemHierVO.setNamedWhereClauseParam(Constants.BIND_STORE_ID, currentRow.getStoreId());
        itemHierVO.executeQuery();
        if (itemHierVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.REC_EXCEEDS_LIMIT, null);
        } else {
            ADFFacesUtil.showPopup(itemHierarchyPopup.getClientId(FacesContext.getCurrentInstance()));
        }
    }

    /**
     * Gets the selected row from results table
     * @param table
     * @return
     */
    private Object getSelectedRow(RichTable table) {
        logger.info("****** Inside getSelectedRow method ******");
        Object _selectedRowData = table.getSelectedRowData();
        JUCtrlHierNodeBinding _nodeBinding = (JUCtrlHierNodeBinding) _selectedRowData;
        return _nodeBinding.getRow();
    }

    /**
     * Helper method to check DOW value is null
     * @param dow
     * @return
     */
    private boolean isDOWNull(Integer dow) {
        if (dow == null) {
            return true;
        }
        return false;
    }

    /**
     * Creates DOW Set All Row for lead time and launches the set all dow popup
     * @param actionEvent
     */
    public void handleDOWSetAllAction(ActionEvent actionEvent) {
        logger.info("****** Inside handleDOWSetAllAction method ******");
        if (areRecordsSelectedForSave(false) != 0) {
            if(isFrequencySameForAllRecordsSelected() == 0){
                AipdtUIUtil.showErrorMessageFromUIBundle(Constants.FREQUENCY_IS_INVALID_FOR_SET_ALL, null);
                return;
            }
            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            xdosAM.createEmptyDOWSetAll();
            ADFFacesUtil.showPopup(timePopup.getClientId(FacesContext.getCurrentInstance()));
        } else {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SELECT_ROW_FOR_SETALL, null);
        }
    }

    public void setTimePopup(RichPopup timePopup) {
        this.timePopup = timePopup;
    }

    public RichPopup getTimePopup() {
        return timePopup;
    }

    /**
     * Invoked when Set All button is clicked from DOW Set All Popup
     * @param actionEvent
     */
    public void dowSetAllListener(ActionEvent actionEvent) {
        logger.info("****** Inside dowSetAllListener method ******");
        ViewObject vo = AipdtUIUtil.findIterator(TIME_SET_ALL_POPUP_VO_ITERATOR).getViewObject();
        XDOrderScheduleTimeSetAllVORowImpl resultsRow = (XDOrderScheduleTimeSetAllVORowImpl) vo.first();
        if (resultsRow == null) {
            logger.warning("No records selected to update.");
            return;
        }
        boolean isOverlapped = false;
        java.util.List<String> deliveryDayList = new java.util.ArrayList<String>(7);
        if (!isDOWNull(resultsRow.getSunday())) {
            deliveryDayList.add(String.valueOf(Constants.SUNDAY_INDEX + resultsRow.getSunday()));
        }
        if (!isDOWNull(resultsRow.getMonday())) {
            if (deliveryDayList.contains(String.valueOf(Constants.MONDAY_INDEX + resultsRow.getMonday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.MONDAY_INDEX + resultsRow.getMonday()));
            }
        }
        if (!isDOWNull(resultsRow.getTuesday())) {
            if (deliveryDayList.contains(String.valueOf(Constants.TUESDAY_INDEX + resultsRow.getTuesday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.TUESDAY_INDEX + resultsRow.getTuesday()));
            }
        }
        if (!isDOWNull(resultsRow.getWednesday())) {
            if (deliveryDayList.contains(String.valueOf(Constants.WEDNESDAY_INDEX + resultsRow.getWednesday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.WEDNESDAY_INDEX + resultsRow.getWednesday()));
            }
        }
        if (!isDOWNull(resultsRow.getThursday())) {
            if (deliveryDayList.contains(String.valueOf(Constants.THURSDAY_INDEX + resultsRow.getThursday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.THURSDAY_INDEX + resultsRow.getThursday()));
            }
        }
        if (!isDOWNull(resultsRow.getFriday())) {
            if (deliveryDayList.contains(String.valueOf(Constants.FRIDAY_INDEX + resultsRow.getFriday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.FRIDAY_INDEX + resultsRow.getFriday()));
            }
        }
        if (!isDOWNull(resultsRow.getSaturday())) {
            if (deliveryDayList.contains(String.valueOf(Constants.SATURDAY_INDEX + resultsRow.getSaturday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.SATURDAY_INDEX + resultsRow.getSaturday()));
            }
        }

        if (deliveryDayList.isEmpty()) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.DOW_INPUT_IS_NULL, null);
        } else {
            if (isOverlapped) {
                AipdtUIUtil.showErrorMessageFromUIBundle(Constants.DOW_VALUES_ARE_OVERLAPPED, null);
                return;
            }
            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            xdosAM.handleDOWSetAll();
            if (getResultsTableComp() != null) {
                AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
                timePopup.hide();
            }
        }
    }

    /**
     * Invoked when close button is clicked from DOW Set All Popup
     * @param actionEvent
     */
    public void dowCloseListener(ActionEvent actionEvent) {
        logger.info("****** Inside dowCloseListener method ******");
        if (timePopup != null) {
            timePopup.hide();
        }
        if (dowSetPopup != null) {
            dowSetPopup.hide();
        }
    }

    /**
     * Invoked on Set All dates value is changed
     * @param valueChangeEvent
     */
    public void onSetAllValueChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onSetAllValueChange method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        UIComponent setAllComp = (UIComponent) valueChangeEvent.getSource();
        if (setAllComp == null) {
            logger.severe("Set All Component is null.");
            return;
        }

        String setAllCompId = setAllComp.getId();
        clearSetAllFields(setAllCompId);
        if (Constants.XDOS_SET_ALL_START_DATE_COMP_ID.equals(setAllCompId)) {
            java.util.Date startDate = (java.util.Date) valueChangeEvent.getNewValue();
            logger.info("Set All Start Date  :" + startDate);
            setAllMap.put(Constants.XDOS_SET_ALL_START_DATE_COMP_ID, startDate);
        } else if (Constants.XDOS_SET_ALL_END_DATE_COMP_ID.equals(setAllCompId)) {
            java.util.Date endDate = (java.util.Date) valueChangeEvent.getNewValue();
            logger.info("Set All End Date  :" + endDate);
            setAllMap.put(Constants.XDOS_SET_ALL_END_DATE_COMP_ID, endDate);
        } else {
            logger.warning("Set All action is NOT defined for this event.");
            return;
        }
    }

    /**
     * Clears the set all fields
     */
    private void clearSetAllFields(String setAllCompId) {
        logger.info("****** Inside clearSetAllFields method ******");
        setAllMap.clear();
        if (getSetAllStartDateComp() != null) {
            if (!getSetAllStartDateComp().getId().equals(setAllCompId)) {
                getSetAllStartDateComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllStartDateComp());
            }
        }
        if (getSetAllEndDateComp() != null) {
            if (!getSetAllEndDateComp().getId().equals(setAllCompId)) {
                getSetAllEndDateComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllEndDateComp());
            }
        }
    }

    /**
     * Invoked on click of Set All button is clicked for dates
     * @param actionEvent
     */
    public void handleSetAll(ActionEvent actionEvent) {
        logger.info("****** Inside handleSetAll method ******");
        int areRecordsSelected = areRecordsSelectedForSave(false);
        if (areRecordsSelected == 0) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SELECT_ROW_FOR_SETALL, null);
            return;
        }
        if (setAllMap.isEmpty()) {
            logger.severe("No records to save.");
            return;
        }
        XDOrderScheduleAM xdosAM = (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
        xdosAM.handleSetAll(setAllMap);
        if (getResultsTableComp() != null) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
        }
        clearSetAllFields(null);
    }

    public void setSetAllStartDateComp(RichInputDate setAllStartDateComp) {
        this.setAllStartDateComp = setAllStartDateComp;
    }

    public RichInputDate getSetAllStartDateComp() {
        return setAllStartDateComp;
    }

    public void setSetAllEndDateComp(RichInputDate setAllEndDateComp) {
        this.setAllEndDateComp = setAllEndDateComp;
    }

    public RichInputDate getSetAllEndDateComp() {
        return setAllEndDateComp;
    }

    public void setDowTableComp(RichTable dowTableComp) {
        this.dowTableComp = dowTableComp;
    }

    public RichTable getDowTableComp() {
        return dowTableComp;
    }

    /**
     * Invoked when Set button is clicked from DOW Popup
     * @param actionEvent
     */
    public void dowSetListener(ActionEvent actionEvent) {
        logger.info("****** Inside dowSetListener method ******");
        ViewObject vo = AipdtUIUtil.findIterator(TIME_SET_ALL_POPUP_VO_ITERATOR).getViewObject();
        XDOrderScheduleTimeSetAllVORowImpl resultsRow = (XDOrderScheduleTimeSetAllVORowImpl) vo.getCurrentRow();
        if (resultsRow == null) {
            logger.warning("No records selected to update.");
            return;
        }
        boolean isOverlapped = false;
        int count = 0;
        java.util.List<String> deliveryDayList = new java.util.ArrayList<String>(7);
        if (!isDOWNull(resultsRow.getSunday())) {
            count++;
            deliveryDayList.add(String.valueOf(Constants.SUNDAY_INDEX + resultsRow.getSunday()));
        }
        if (!isDOWNull(resultsRow.getMonday())) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.MONDAY_INDEX + resultsRow.getMonday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.MONDAY_INDEX + resultsRow.getMonday()));
            }
        }
        if (!isDOWNull(resultsRow.getTuesday())) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.TUESDAY_INDEX + resultsRow.getTuesday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.TUESDAY_INDEX + resultsRow.getTuesday()));
            }
        }
        if (!isDOWNull(resultsRow.getWednesday())) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.WEDNESDAY_INDEX + resultsRow.getWednesday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.WEDNESDAY_INDEX + resultsRow.getWednesday()));
            }
        }
        if (!isDOWNull(resultsRow.getThursday())) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.THURSDAY_INDEX + resultsRow.getThursday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.THURSDAY_INDEX + resultsRow.getThursday()));
            }
        }
        if (!isDOWNull(resultsRow.getFriday())) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.FRIDAY_INDEX + resultsRow.getFriday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.FRIDAY_INDEX + resultsRow.getFriday()));
            }
        }
        if (!isDOWNull(resultsRow.getSaturday())) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.SATURDAY_INDEX + resultsRow.getSaturday()))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.SATURDAY_INDEX + resultsRow.getSaturday()));
            }
        }

        if (deliveryDayList.isEmpty()) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.DOW_INPUT_IS_NULL, null);
        } else {
            DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
            if (dcItteratorBindings != null) {
                ViewObject resultsVO = dcItteratorBindings.getViewObject();
                Row resultCurrentRow = resultsVO.getCurrentRow();
                Integer frequency = (Integer) resultCurrentRow.getAttribute("Frequency");
                if (7 == frequency) {
                    if (isOverlapped) {
                        AipdtUIUtil.showErrorMessageFromUIBundle(Constants.DOW_VALUES_ARE_OVERLAPPED, null);
                        return;
                    }
                } else {
                    if (count > 1) {
                        AipdtUIUtil.showErrorMessageFromUIBundle(Constants.LEADTIME_CAN_BE_ENTERED_FOR_ONLY_ONE_DOW,
                                                                 null);
                        return;
                    }
                }
            }

            XDOrderScheduleAM xdosAM =
                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
            xdosAM.handleDOWSet();
            if (getResultsTableComp() != null) {
                AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
                dowSetPopup.hide();
            }
        }
    }

    public void setDowSetPopup(RichPopup dowSetPopup) {
        this.dowSetPopup = dowSetPopup;
    }

    public RichPopup getDowSetPopup() {
        return dowSetPopup;
    }

    /**
     * Invoked when Set DOW from the results is clicked, which launches the DOW popup to feed in lead time values
     * @param actionEvent
     */
    public void onClickSetDowPopup(ActionEvent actionEvent) {
        logger.info("****** Inside onClickSetDowPopup method ******");
        XDOrderScheduleResultsVORowImpl resultsRow =
            (XDOrderScheduleResultsVORowImpl) getSelectedRow(getResultsTableComp());
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
        if (dcItteratorBindings != null) {
            ViewObject resultsVO = dcItteratorBindings.getViewObject();
            resultsVO.setCurrentRow(resultsRow);
        }
        XDOrderScheduleAM xdosAM = (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
        xdosAM.createEmptyDOWRow();
        ADFFacesUtil.showPopup(dowSetPopup.getClientId(FacesContext.getCurrentInstance()));
    }

    /**
     * Invoked on table filtering. No change in the filtering feature,
     * it only enables/disables the header level checkbox on filtering.
     * @param queryEvent
     */
    public void processQuery(QueryEvent queryEvent) {
        logger.info("****** Inside processQuery method ******");
        //Process default filter query event
        AipdtUIUtil.invokeQueryEventMethodExpression("#{bindings.XDOrderScheduleResultsVO1Query.processQuery}",
                                                     queryEvent);
        //Enable or disable header level checkbox
        if (getCheckBoxAllComp() != null) {
            DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
            if (dcItteratorBindings != null) {
                ViewObject resultVO = dcItteratorBindings.getViewObject();
                Row[] resultsRows = resultVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
                if ((resultsRows != null) && (resultsRows.length == resultVO.getEstimatedRowCount())) {
                    getCheckBoxAllComp().setValue(Boolean.TRUE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
                } else {
                    getCheckBoxAllComp().setValue(Boolean.FALSE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
                }
            }
        }
    }
}
