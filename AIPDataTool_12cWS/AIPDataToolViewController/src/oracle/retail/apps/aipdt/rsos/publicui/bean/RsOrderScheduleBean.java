package oracle.retail.apps.aipdt.rsos.publicui.bean;

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

import oracle.adf.view.rich.export.ExportContext;
import oracle.adf.view.rich.export.FormatHandler;

import oracle.jbo.JboException;

import oracle.jbo.ViewObject;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.common.publicui.bean.BaseRetailBean;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.aipdt.rsos.model.applicationmodule.common.RsOrderScheduleAM;
import oracle.retail.apps.aipdt.rsos.model.view.RsOrderScheduleProgVORowImpl;
import oracle.retail.apps.aipdt.xdos.model.applicationmodule.common.XDOrderScheduleAM;
import oracle.retail.apps.aipdt.xdos.model.view.XDOrderScheduleResultsVORowImpl;
import oracle.retail.apps.framework.uicomponents.AppsPanelComponent;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

public class RsOrderScheduleBean extends BaseRetailBean {
    @SuppressWarnings("compatibility:-8920291428593866124")
    private static final long serialVersionUID = 1L;
    
    public RsOrderScheduleBean() {
    }

    private final static ADFLogger _logger = ADFLogger.createADFLogger(RsOrderScheduleBean.class);

    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();

    public void setMultiSelectBaseFieldsBean(MultiSelectBaseFieldsBean multiSelectBaseFieldsBean) {
        this.multiSelectBaseFieldsBean = multiSelectBaseFieldsBean;
    }

    public MultiSelectBaseFieldsBean getMultiSelectBaseFieldsBean() {
        return multiSelectBaseFieldsBean;
    }
    private AppsPanelComponent appsPanelBind;
  
    private Boolean saveDisabled = Boolean.TRUE;

    public void setSaveDisabled(Boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public Boolean getSaveDisabled() {
        return saveDisabled;
    }

    public void setIsDefaultSelected(Boolean isDefaultSelected) {
        this.isDefaultSelected = isDefaultSelected;
    }

    public Boolean getIsDefaultSelected() {
        return isDefaultSelected;
    }

    public void setIsExceptionSelected(Boolean isExceptionSelected) {
        this.isExceptionSelected = isExceptionSelected;
    }

    public Boolean getIsExceptionSelected() {
        return isExceptionSelected;
    }

    public void setIsDefaultDisable(Boolean isDefaultDisable) {
        this.isDefaultDisable = isDefaultDisable;
    }

    public Boolean getIsDefaultDisable() {
        return isDefaultDisable;
    }

    public void setIsExceptionDisable(Boolean isExceptionDisable) {
        this.isExceptionDisable = isExceptionDisable;
    }

    public Boolean getIsExceptionDisable() {
        return isExceptionDisable;
    }

    public void setIsClassDisable(Boolean isClassDisable) {
        this.isClassDisable = isClassDisable;
    }

    public Boolean getIsClassDisable() {
        return isClassDisable;
    }

    public void setIsSubClassDisable(Boolean isSubClassDisable) {
        this.isSubClassDisable = isSubClassDisable;
    }

    public Boolean getIsSubClassDisable() {
        return isSubClassDisable;
    }

    public void setIsItemDisable(Boolean isItemDisable) {
        this.isItemDisable = isItemDisable;
    }

    public Boolean getIsItemDisable() {
        return isItemDisable;
    }

    public void setIsStyleColourDisable(Boolean isStyleColourDisable) {
        this.isStyleColourDisable = isStyleColourDisable;
    }

    public Boolean getIsStyleColourDisable() {
        return isStyleColourDisable;
    }

    public void setIsItemListDisable(Boolean isItemListDisable) {
        this.isItemListDisable = isItemListDisable;
    }

    public Boolean getIsItemListDisable() {
        return isItemListDisable;
    }

    public void setIsVPNDisable(Boolean isVPNDisable) {
        this.isVPNDisable = isVPNDisable;
    }

    public Boolean getIsVPNDisable() {
        return isVPNDisable;
    }

    public void setIsStoreDisable(Boolean isStoreDisable) {
        this.isStoreDisable = isStoreDisable;
    }

    public Boolean getIsStoreDisable() {
        return isStoreDisable;
    }

    public void setIsStoreListDisable(Boolean isStoreListDisable) {
        this.isStoreListDisable = isStoreListDisable;
    }

    public Boolean getIsStoreListDisable() {
        return isStoreListDisable;
    }

    public void setIsSupplierDisable(Boolean isSupplierDisable) {
        this.isSupplierDisable = isSupplierDisable;
    }

    public Boolean getIsSupplierDisable() {
        return isSupplierDisable;
    }

    public void setIsSupplierListDisable(Boolean isSupplierListDisable) {
        this.isSupplierListDisable = isSupplierListDisable;
    }

    public Boolean getIsSupplierListDisable() {
        return isSupplierListDisable;
    }

    public void setIsAllItemDisable(Boolean isAllItemDisable) {
        this.isAllItemDisable = isAllItemDisable;
    }

    public Boolean getIsAllItemDisable() {
        return isAllItemDisable;
    }

    public void setIsVpnColourDisable(Boolean isVpnColourDisable) {
        this.isVpnColourDisable = isVpnColourDisable;
    }

    public Boolean getIsVpnColourDisable() {
        return isVpnColourDisable;
    }

    public void setIsRegionDisable(Boolean isRegionDisable) {
        this.isRegionDisable = isRegionDisable;
    }

    public Boolean getIsRegionDisable() {
        return isRegionDisable;
    }

    public void setIsWarehouseDisable(Boolean isWarehouseDisable) {
        this.isWarehouseDisable = isWarehouseDisable;
    }

    public Boolean getIsWarehouseDisable() {
        return isWarehouseDisable;
    }
    
    private Boolean isDefaultSelected = Boolean.TRUE;
    private Boolean isExceptionSelected = Boolean.FALSE;
    private Boolean isDefaultDisable = Boolean.FALSE;
    private Boolean isExceptionDisable = Boolean.FALSE;

    private Boolean isClassDisable = Boolean.TRUE;
    private Boolean isSubClassDisable = Boolean.TRUE;
    private Boolean isItemDisable = Boolean.TRUE;
    private Boolean isStyleColourDisable = Boolean.TRUE;
    private Boolean isItemListDisable = Boolean.TRUE;
    private Boolean isVPNDisable = Boolean.TRUE;
    private Boolean isStoreDisable = Boolean.TRUE;
    private Boolean isStoreListDisable = Boolean.TRUE;
    private Boolean isSupplierDisable = Boolean.TRUE;
    private Boolean isSupplierListDisable = Boolean.TRUE;
    private Boolean isAllItemDisable = Boolean.TRUE;
    private Boolean isVpnColourDisable = Boolean.TRUE;
    private Boolean isRegionDisable = Boolean.TRUE;
    private Boolean isWarehouseDisable = Boolean.TRUE;

    protected static Boolean isSaveAndCloseCliked = Boolean.FALSE;

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

    private static final String ITEM_SELECTION_TYPE = "I";
    private static final String ITEM_STORE_TYPE = "I";
    private static final String ITEM_ALL_STORE = "IA";
    private static final String ITEM_REGION = "IR";

    private long numberOfResultRecords;
    
    private RichSelectBooleanRadio defaultRadioComp;

    public void setDefaultRadioComp(RichSelectBooleanRadio defaultRadioComp) {
        this.defaultRadioComp = defaultRadioComp;
    }

    public RichSelectBooleanRadio getDefaultRadioComp() {
        return defaultRadioComp;
    }
    private RichSelectBooleanRadio exceptionRadioComp;

    public void setExceptionRadioComp(RichSelectBooleanRadio exceptionRadioComp) {
        this.exceptionRadioComp = exceptionRadioComp;
    }

    public RichSelectBooleanRadio getExceptionRadioComp() {
        return exceptionRadioComp;
    }
    private RichSelectOneChoice departmentComp;
    private SelectManyInputCheckBoxComponent classComp;
    private SelectManyInputCheckBoxComponent subClassComp;
    private RichSelectOneChoice itemListComp;

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

    public void setSubClassComp(SelectManyInputCheckBoxComponent subClassComp) {
        this.subClassComp = subClassComp;
    }

    public SelectManyInputCheckBoxComponent getSubClassComp() {
        return subClassComp;
    }

    public void setItemListComp(RichSelectOneChoice itemListComp) {
        this.itemListComp = itemListComp;
    }

    public RichSelectOneChoice getItemListComp() {
        return itemListComp;
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
    private RichInputListOfValues supplierComp;

    public void setSupplierComp(RichInputListOfValues supplierComp) {
        this.supplierComp = supplierComp;
    }

    public RichInputListOfValues getSupplierComp() {
        return supplierComp;
    }
    private MultiSelectInputListOfValuesComponent vpnComp;
    private MultiSelectInputListOfValuesComponent styleColourComp;
    private MultiSelectInputListOfValuesComponent itemComp;
    private RichSelectOneChoice regionComp;

    public void setRegionComp(RichSelectOneChoice regionComp) {
        this.regionComp = regionComp;
    }

    public RichSelectOneChoice getRegionComp() {
        return regionComp;
    }

    public void setStoreListComp(RichSelectOneChoice storeListComp) {
        this.storeListComp = storeListComp;
    }

    public RichSelectOneChoice getStoreListComp() {
        return storeListComp;
    }

    public void setSearchBtn(RichButton searchBtn) {
        this.searchBtn = searchBtn;
    }

    public RichButton getSearchBtn() {
        return searchBtn;
    }
    private RichSelectOneChoice storeListComp;
    private RichButton searchBtn;
    private RichPanelGroupLayout resultsContainer;

    public void setResultsContainer(RichPanelGroupLayout resultsContainer) {
        this.resultsContainer = resultsContainer;
    }

    public RichPanelGroupLayout getResultsContainer() {
        return resultsContainer;
    }
    private RichPopup itemHierarchyPopup;
    private RichPopup storePopup;
    private RichPopup resetPopup;
    private RichPopup cancelPopup;
    private RichPopup saveFailedPopup;
    private RichPopup saveCloseSuccessPopup;
    private RichSelectOneChoice warehouseComp;

    public void setWarehouseComp(RichSelectOneChoice warehouseComp) {
        this.warehouseComp = warehouseComp;
    }

    public RichSelectOneChoice getWarehouseComp() {
        return warehouseComp;
    }
    private RichSelectBooleanCheckbox checkBoxAllComp;

    public void setCheckBoxAllComp(RichSelectBooleanCheckbox checkBoxAllComp) {
        this.checkBoxAllComp = checkBoxAllComp;
    }

    public RichSelectBooleanCheckbox getCheckBoxAllComp() {
        return checkBoxAllComp;
    }
    private RichTable resultsTableComp;

    public void setResultsTableComp(RichTable resultsTableComp) {
        this.resultsTableComp = resultsTableComp;
    }

    public RichTable getResultsTableComp() {
        return resultsTableComp;
    }
    private RichPopup savePopup;
    private RichPopup saveClosePopup;
    private RichPopup saveSuccessPopup;
    private RichPopup timePopup;
    private RichInputDate setAllStartDateComp;
    private RichInputDate setAllEndDateComp;



    public void setSavePopup(RichPopup savePopup) {
        this.savePopup = savePopup;
    }

    public RichPopup getSavePopup() {
        return savePopup;
    }
    
    public void setSaveClosePopup(RichPopup saveClosePopup) {
        this.saveClosePopup = saveClosePopup;
    }

    public RichPopup getSaveClosePopup() {
        return saveClosePopup;
    }
    
    public void setCancelPopup(RichPopup cancelPopup) {
        this.cancelPopup = cancelPopup;
    }

    public RichPopup getCancelPopup() {
        return cancelPopup;
    }

    public void setResetPopup(RichPopup resetPopup) {
        this.resetPopup = resetPopup;
    }

    public RichPopup getResetPopup() {
        return resetPopup;
    }


    public void setAppsPanelBind(AppsPanelComponent appsPanelBind) {
        this.appsPanelBind = appsPanelBind;
    }

    public AppsPanelComponent getAppsPanelBind() {
        return appsPanelBind;
    }
    
    public void onDefaultVCE(ValueChangeEvent valueChangeEvent) {
        isDefaultSelected = (valueChangeEvent.getNewValue() != null) ? (Boolean) valueChangeEvent.getNewValue() : false;
        resetDeptAndItemList();
        enableDisableFields();
    }
    
    private void enableDisableFields(){
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
            }
            else if(!StringUtil.isNullOrEmpty(itemListVal)){
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(false);  
            }
            else{
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(false);  
            }
        }
        else{
            //Default
            if (!StringUtil.isNullOrEmpty(deptId)) {
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(true);
            } 
            else{
                disableProductHierarchyLevelFields(true);
                disableSupplier(false);
                disableSourceFields(false);
                disableDestinationFields(true);  
            }
        }
        enableDisableDepartment();
        enableDisableItemListComponent();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
    }
    
    private void enableDisableDepartment() {
        if (getDepartmentComp() != null) {
            if (isExceptionSelected) {
                if (!StringUtil.isNullOrEmpty(itemListVal)) {
                    //getDepartmentComp().resetValue();
                    //getDepartmentComp().setDisabled(true);
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
    
    private void resetDepartment() {
        if (getDepartmentComp() != null) {
            deptId = null;
            AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", null);
            getDepartmentComp().resetValue();
            getDepartmentComp().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDepartmentComp());
        }
    }

    
    private void disableSupplier(boolean isDisable) {
        if (getSupplierComp() != null) {
            if (isDisable) {
                //supplierVal = null;
                //getSupplierComp().setValue(null);
                //getSupplierComp().resetValue();
                resetSupplierComponent();
            } else {
                getSupplierComp().setDisabled(isDisable);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
            }
        }
    }
    
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
            AipdtUIUtil.setValueToEL("#{bindings.ItemlistAttr.inputValue}", null);
            getItemListComp().resetValue();
            if(isExceptionSelected){
                getItemListComp().setDisabled(false);  
            }
            else{
                getItemListComp().setDisabled(true);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
        }
    }

    
     /**
      * Invoked when exception radio button value is changed
      * @param valueChangeEvent
      */
     public void onExceptionVCE(ValueChangeEvent valueChangeEvent) {
         _logger.info("****** Inside onExceptionVCE method ******");
         valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
         isExceptionSelected = (valueChangeEvent.getNewValue() != null) ? (Boolean) valueChangeEvent.getNewValue() : false;
         resetDeptAndItemList();
         enableDisableFields();
         
         /*if (isExceptionSelected) {
             if (!StringUtil.isNullOrEmpty(deptId)) {
                 setIsClassDisable(false);
                 setIsSubClassDisable(false);
                 setIsItemDisable(false);
                 setIsVPNDisable(false);
                 setIsVpnColourDisable(false);
                 setIsRegionDisable(false);
                 setIsStoreDisable(false);
                 setIsStoreListDisable(false);

                 //Refreshing components only if Exception Radio button unchecked to refresh component.
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());

                 AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());

                 filterClassComponent();

                 filterSubClassComponent();

                 filterVPNComponent();

                 filterVPNColourComponent();

                 filterSkuComponent();
             }
         } else {
             setIsClassDisable(true);
             setIsSubClassDisable(true);
             setIsItemDisable(true);
             setIsVPNDisable(true);
             setIsVpnColourDisable(true);
             setIsRegionDisable(true);
             setIsStoreDisable(true);
             setIsStoreListDisable(true);
             
             if (!StringUtil.isNullOrEmpty(deptId)) {
                 if (!StringUtil.isNullOrEmpty(classId)) {
                     multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
                     classId = null;
                 }
                 if (!StringUtil.isNullOrEmpty(subclassId)) {
                     multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
                     subclassId = null;
                 }

                 if (!StringUtil.isNullOrEmpty(vpnIdVal)) {
                     multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
                     vpnIdVal = null;
                 }
                 if (!StringUtil.isNullOrEmpty(vpnColourIdVal)) {
                     multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());
                     vpnColourIdVal = null;
                 }
                 if (!StringUtil.isNullOrEmpty(skuIdVal)) {
                     multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
                     skuIdVal = null;
                 }

                 //Refreshing components only if Exception Radio button unchecked to refresh component.
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
                 
                 AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
             }
         }
         if (!StringUtil.isNullOrEmpty(itemListVal)) {
             // this block is to handle when ItemList value selected and Changing Radiobutton from Exception to Default.
             setIsRegionDisable(true);
             setIsStoreDisable(true);
             setIsStoreListDisable(true);

             setIsSupplierDisable(true);
             setIsItemListDisable(true);
             disableSourceFields(true);
             supplierComp.setDisabled(true);
             resetSupplierComponent();
             resetSourceComponents();
             resetDestinationComponents();
             resetItemListComponent();
             departmentComp.setDisabled(false);

             AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);
             AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
         }
         enableDisableItemListComponent();
         enableSearchButton();
         
         //////////////
          if (!StringUtil.isNullOrEmpty(deptId)) {
             setIsClassDisable(!isExceptionSelected);
             setIsSubClassDisable(!isExceptionSelected);
             setIsItemDisable(!isExceptionSelected);
             setIsVPNDisable(!isExceptionSelected);
             setIsVpnColourDisable(!isExceptionSelected);
             setIsRegionDisable(!isExceptionSelected);
             setIsStoreDisable(!isExceptionSelected);
             setIsStoreListDisable(!isExceptionSelected);
             if (isExceptionSelected) {
                 filterClassComponent();

                 filterSubClassComponent();

                 filterVPNComponent();

                 filterVPNColourComponent();

                 filterSkuComponent();
             } else {
                 if (!StringUtil.isNullOrEmpty(classId)) {
                     multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
                     classId = null;
                 }
                 if (!StringUtil.isNullOrEmpty(subclassId)) {
                     multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
                     subclassId = null;
                 }

                 if (!StringUtil.isNullOrEmpty(vpnIdVal)) {
                     multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
                     vpnIdVal = null;
                 }
                 if (!StringUtil.isNullOrEmpty(vpnColourIdVal)) {
                     multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());
                     vpnColourIdVal = null;
                 }
                 if (!StringUtil.isNullOrEmpty(skuIdVal)) {
                     multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
                     skuIdVal = null;
                 }
                 // Below code is to enable ItemList if only Exception Radio button selected. If Default then, reset Itemlist and disable it.
                 //Refreshing components only if Exception Radio button unchecked to refresh component.
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
                 
                 AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
                 AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
             }
         } else if (!StringUtil.isNullOrEmpty(itemListVal)) {
             // this block is to handle when ItemList value selected and Changing Radiobutton from Exception to Default.
             setIsRegionDisable(true);
             setIsStoreDisable(true);
             setIsStoreListDisable(true);
             
             setIsSupplierDisable(true);
             setIsItemListDisable(true);
             disableSourceFields(true);
             supplierComp.setDisabled(true);
             resetSupplierComponent();
             resetSourceComponents();
             resetDestinationComponents();
             resetItemListComponent();
             departmentComp.setDisabled(false);

             AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);
             AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
         }*/
         //enableDisableItemListComponent();
         enableSearchButton();
     }
    
    /**
     * Helper method to disable source fields in the search section.
     * @param isDisable
     */
    private void disableSourceFields(boolean isDisable) {
        _logger.info("****** Inside disableSourceFields method ******");
        if (getWarehouseComp() != null) {
            if(isDisable){
                warehouseIdVal = null;
                AipdtUIUtil.setValueToEL("#{bindings.Warehouse.inputValue}", null);
                getWarehouseComp().resetValue();   
            }
            getWarehouseComp().setDisabled(isDisable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getWarehouseComp());
        }
    }
    
     /**
      * Resets Supplier component.
      */
     private void resetSupplierComponent() {
         _logger.info("****** Inside resetSupplierComponent method ******");
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
      * Resets the source fields on search section.
      */
     private void resetSourceComponents() {
         _logger.info("****** Inside resetSourceComponents method ******");
         warehouseIdVal = null;
         if (getWarehouseComp() != null) {
             getWarehouseComp().resetValue();
             getWarehouseComp().setValue(null);
             getWarehouseComp().setDisabled(true);
             AdfFacesContext.getCurrentInstance().addPartialTarget(getWarehouseComp());
         }
     }
    
     /**
      * Resets destination components.
      */
     private void resetDestinationComponents() {
         _logger.info("****** Inside resetDestinationComponents method ******");
         resetRegionComponent();
         resetStoreListComponent();
         if (!StringUtil.isNullOrEmpty(storeVal)) {
             multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
             AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
         }
     }

     /**
      * Helper method to reset region component.
      */
     private void resetRegionComponent() {
         _logger.info("****** Inside resetRegionComponent method ******");
         if (getRegionComp() != null) {
             regionIdVal = null;
             AipdtUIUtil.setValueToEL("#{bindings.Region.inputValue}", null);
             getRegionComp().resetValue();
             getRegionComp().setDisabled(true);
             setIsRegionDisable(true);
             AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
         }
     }


     /**
      * Helper method to reset StoreList component.
      */
     private void resetStoreListComponent() {
         _logger.info("****** Inside resetStoreListComponent method ******");
         if (getStoreListComp() != null) {
             storeListVal = null;
             AipdtUIUtil.setValueToEL("#{bindings.StoreList.inputValue}", null);
             getStoreListComp().resetValue();
             getStoreListComp().setDisabled(true);
             setIsStoreListDisable(true);
             AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
         }
     }


     /**
      * Helper method to reset Itemlist component.
      */
     private void resetItemListComponent() {
         _logger.info("****** Inside resetItemListComponent method ******");
         if (getItemListComp() != null) {
             itemListVal = null;
             AipdtUIUtil.setValueToEL("#{bindings.ItemlistAttr.inputValue}", null);
             getItemListComp().resetValue();
             getItemListComp().setDisabled(true);
             AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
         }
     }

     /**
      * Enable/disable ItemList component based on Exception Radio button selection and DeptId value.
      */
     private void enableDisableItemListComponent() {
         _logger.info("****** Inside enableDisableItemListComponent method ******");
         if (isExceptionSelected) {
             if (!StringUtil.isNullOrEmpty(deptId)) {
                 //getItemListComp().setDisabled(true);
                 resetItemListComponent();
             } else {
                 getItemListComp().setDisabled(false);
             }
         } else {
             //getItemListComp().setDisabled(true);
             resetItemListComponent();
         }
         AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
     }

    /**
     * Enable/disable search button based on the values selected in the search criteria.
     */
    private void enableSearchButton() {
        _logger.info("****** Inside enableSearchButton method ******");
        if (isExceptionSelected) {
            if (!StringUtil.isNullOrEmpty(deptId) && !StringUtil.isNullOrEmpty(supplierVal) && !StringUtil.isNullOrEmpty(warehouseIdVal)) {
                if ((!StringUtil.isNullOrEmpty(classId) || !StringUtil.isNullOrEmpty(subclassId) ||
                     !StringUtil.isNullOrEmpty(vpnIdVal) || !StringUtil.isNullOrEmpty(vpnColourIdVal) ||
                     !StringUtil.isNullOrEmpty(skuIdVal))) {
                    // Enable search button for Item Level
                    searchBtn.setDisabled(false);
                } else {
                    // Disable Search button.
                    searchBtn.setDisabled(true);
                }
            } else if (!StringUtil.isNullOrEmpty(itemListVal) && !StringUtil.isNullOrEmpty(supplierVal) && !StringUtil.isNullOrEmpty(warehouseIdVal)) {
                    searchBtn.setDisabled(false);
            } else {
                searchBtn.setDisabled(true);
            }
        } else {
            if (!StringUtil.isNullOrEmpty(deptId) && !StringUtil.isNullOrEmpty(warehouseIdVal)) {
                searchBtn.setDisabled(false);
            } else {
                //Disable button as department component value is empty.
                searchBtn.setDisabled(true);
            }
        }
        /*if ((!StringUtil.isNullOrEmpty(deptId) || !StringUtil.isNullOrEmpty(itemListVal))&& !StringUtil.isNullOrEmpty(warehouseIdVal)) {
            searchBtn.setDisabled(false);
        } else {
            //Disable button as department component value is empty.
            searchBtn.setDisabled(true);
        }*/
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtn);
    }


     /**
      * Invoked when department value is changed in the search section.
      * @param valueChangeEvent
      */
     public void onDepartmentVCE(ValueChangeEvent valueChangeEvent) {
         try {
             _logger.info("****** Inside onDepartmentVCE method ******");
             valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
             AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", valueChangeEvent.getNewValue());
             Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Department.attributeValue}");
             _logger.info("Department newValue :" + newValue);

             if (newValue != null && !newValue.toString().isEmpty()) {
                 deptId = String.valueOf(newValue);
             } else {
                 deptId = null;
             }
             
             /*if (newValue != null && !newValue.toString().isEmpty()) {
                 deptId = String.valueOf(newValue);
                 // Below condition is added to filter Product Hierarchy fields if only Exception Type is selected.
                 if (isExceptionSelected) {
                     disableProductHierarchyLevelFields(false);
                     disableDestinationFields(false);
                     
                     filterClassComponent();

                     filterSubClassComponent();

                     filterVPNComponent();

                     filterVPNColourComponent();

                     filterSkuComponent();
                 }
                 disableSourceFields(false);
                 setIsItemListDisable(true);
                 supplierComp.setDisabled(false);
             } else {
                 deptId = null;
                 supplierComp.setDisabled(true);
                 resetProductAndDestinationFields();
                 isItemListDisable = false;
                 resetSourceComponents();
                 disableSourceFields(true);
                 disableDestinationFields(true);
             }*/
             // Filtering Supplier component based on selected Department.
             resetSupplierComponent();
             filterSupplierComponent();
             //enableDisableItemListComponent();
             setDepartmentIdOnShuttleComponent();
             enableDisableFields();
             enableSearchButton();
             //AdfFacesContext.getCurrentInstance().addPartialTarget(itemListComp);
         } catch (Exception e) {
             _logger.severe("Exception occured in onDepartmentVCE method");
             e.printStackTrace();
         }
     }

    /**
     * Helper method to enable/disable Product Hierarchy fields based on flag input value.
     * @param isDisable
     */
    private void disableProductHierarchyLevelFields(boolean isDisable) {
        _logger.info("****** Inside disableProductHierarchyLevelFields method ******");
        try {
            setIsClassDisable(isDisable);
            setIsSubClassDisable(isDisable);
            setIsItemDisable(isDisable);
            setIsVPNDisable(isDisable);
            setIsVpnColourDisable(isDisable);
            //setIsItemListDisable(!isDisable);
            //enableDisableDepartment();
            if (isDisable) {
                skuIdVal = null;
                classId = null;
                subclassId = null;
                vpnIdVal = null;
                vpnColourIdVal = null;
                //deptId = null;

                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());
                //resetSupplierComponent();
                multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
                multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());

            //AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
            //AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
        } catch (Exception e) {
            _logger.severe("Exception occured in disableProductHierarchyLevelFields method");
            e.printStackTrace();
        }
    }
     /**
      * Helper method to enable/disable Destination fields based on flag input value.
      * @param isDisable
      */

     private void disableDestinationFields(boolean isDisable) {
         _logger.info("****** Inside disableDestinationFields method ******");
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
             _logger.severe("Exception occured in disableDestinationFields method");
             e.printStackTrace();
         }
     }
     
    private void resetStoreComponent() {
        _logger.info("****** Inside resetStoreComponent method ******");
        if (multiSelectBaseFieldsBean.getStoreComp() != null) {
            storeVal = null;
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(true);
            setIsStoreDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        }
    }
     
     /**
      * Resets all Products Hierarchy fields and Destination fields.
      * It is called in two schenarios : 1. On click of Reset button and 2.On selection of empty department.
      */
     private void resetProductAndDestinationFields() {
         _logger.info("****** Inside resetProductAndDestinationFields method ******");
         disableProductHierarchyLevelFields(true);

         //isItemListDisable = false;
         resetItemListComponent();
         //itemListVal = null;

         disableDestinationFields(true);

         //isSupplierDisable = true;
         //resetSupplierComponent();
     }
    /**
     * Filters SupplierComponent based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */
    @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")

    private void filterSupplierComponent() {
        _logger.info("****** Inside filterSupplierComponent method ******");
        try {
            RsOrderScheduleAM rsosAM = (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
            rsosAM.filterSupplierLOVVO(deptId);
            /*if (!StringUtil.isNullOrEmpty(deptId)) {
                getSupplierComp().setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
            } else {
                resetSupplierComponent();
            }*/
        } catch (Exception e) {
            _logger.severe("Exception occured in filterSupplierComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Helper method to set value of DepartmentId on DepartmentId multiSelect component.
     */
    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")

    private void setDepartmentIdOnShuttleComponent() {
        _logger.info("****** Inside setDepartmentIdOnShuttleComponent method ******");
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
            _logger.severe("Exception occured in setDepartmentIdOnShuttleComponent method");
            e.printStackTrace();
        }

    }
    
    /**
     * Filters Class component based on DepartmentId value selected.
     */

    private void filterClassComponent() {
        _logger.info("****** Inside filterClassComponent method ******");
        try {
            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getClassComp());
            classId = null;
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("ClassAttr", "DeparmentId", deptId, null, null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        } catch (Exception e) {
            _logger.severe("Exception occured in filterClassComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters SubClass component based on DepartmentId and ClassId value selected.
     */

    private void filterSubClassComponent() {
        _logger.info("****** Inside filterSubClassComponent method ******");
        try {
            subclassId = null;
            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getSubClassComp());
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("SubclassAttr", "ClassId", classId,
                                                                          "DepartmentId", deptId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        } catch (Exception e) {
            _logger.severe("Exception occured in filterSubClassComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters VPN Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */

    private void filterVPNComponent() {
        _logger.info("****** Inside filterVPNComponent method ******");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, null, null,
                                                                       multiSelectBaseFieldsBean.getVpnComp());
            vpnIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());

        } catch (Exception e) {
            _logger.severe("Exception occured in filterVPNComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters VPN/StyleColour Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */

    private void filterVPNColourComponent() {
        _logger.info("****** Inside filterVPNColourComponent method ******");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, null,
                                                                       multiSelectBaseFieldsBean.getStyleColourComp());
            vpnColourIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());

        } catch (Exception e) {
            _logger.severe("Exception occured in filterVPNColourComponent method");
            e.printStackTrace();
        }
    }

    /**
     * Filters Item Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component for the selected department.
     */

    private void filterSkuComponent() {
        _logger.info("****** Inside filterSkuComponent method ******");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, vpnColourIdVal,
                                                                       multiSelectBaseFieldsBean.getItemComp());
            skuIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
        } catch (Exception e) {
            _logger.severe("Exception occured in filterSkuComponent method");
            e.printStackTrace();
        }
    }
    /**
     * Invoked when Save button is clicked, which opens up the Save confirmation popup
     * @param actionEvent
     */
    public void handleSave(ActionEvent actionEvent) {
        _logger.info("****** Inside handleSave method ******");
        if (getSavePopup() != null) {
            ADFFacesUtil.showPopup(getSavePopup().getClientId(FacesContext.getCurrentInstance()));
        }
    }
    
    /**
     * Invoked when SaveAndClose button is clicked, which opens up the SaveAndClose confirmation popup
     * @return
     */
    public String handleSaveAndClose() {
        _logger.info("****** Inside handleSaveAndClose method ******");
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
        ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

      /**
       * Invoked when search button is clicked from search section. Invokes AM method to stage
       * records in GTT table.
       * @param actionEvent
       */
      public void handleSearch(ActionEvent actionEvent) {
          _logger.info("****** Inside handleSearch method ******");
          try {
              boolean isValidInput = validateInput();
              if (!isValidInput) {
                  _logger.warning("Values for One or more required search fields are missing.");
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

              _logger.info("Selection Type --> " + selectionType);

              selectLevel = findSelectionLevel();

              _logger.info("Selection Level --> " + selectLevel);

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

              RsOrderScheduleAM rsosAM = (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
              boolean selectValid = rsosAM.handleSearch(input);
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
      * Finds selectionType value based on the Search criteria value.
      * @return
      */
     private String findSelectionType() {
         _logger.info("****** Inside findSelectionType method ******");
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
    private Boolean isAllStoreSelected() {
        _logger.info("****** Inside isAllStoreSelected method ******");
        Boolean flag = Boolean.FALSE;
        flag = multiSelectBaseFieldsBean.isAllStoreSelected();
        return flag;
    }
    
    /**
     * Returns Selection Level : Dept or Dept/Supplier or VPN or Item level based on input provided in Search section.
     * @return
     */
    private int findSelectionLevel() {
        _logger.info("****** Inside findSelectionLevel method ******");
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
     * Returns the number of records from results table.
     * @return
     */
    public long getNumberOfResultRecords() {
        _logger.info("****** Inside getNumberOfResultRecords method ******");
//--        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
//--        if (dcItteratorBindings != null) {
//--            numberOfResultRecords = dcItteratorBindings.getEstimatedRowCount();
//--        }
        _logger.info("Results Record Count :" + numberOfResultRecords);
        return numberOfResultRecords;
    }
    
     /**
      * Disables all the components on the search panel. Invoked on successful search.
      */
     private void disableSearchComponents() {
         _logger.info("****** Inside disableSearchComponents method ******");
         //Disable search button
         searchBtn.setDisabled(true);
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
         setIsRegionDisable(true);
         setIsStoreDisable(true);
         setIsStoreListDisable(true);
         
         getRegionComp().setDisabled(true);
         multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(true);
         getStoreListComp().setDisabled(true);
             
         AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtn);
         
         AdfFacesContext.getCurrentInstance().addPartialTarget(defaultRadioComp);
         AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionRadioComp);

         AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);
         AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
         AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
         AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
         AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
         AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
         AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
        
         AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
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
        _logger.info("Entering  handleReset()");
        ADFFacesUtil.showPopup(resetPopup.getClientId(FacesContext.getCurrentInstance()));
    }
    
    /**
     * Saves the transaction. Invoked when yes is clicked from save confirmation poup.
     * @param actionEvent
     */
    public void handleSaveYes(ActionEvent actionEvent) {
        _logger.info("****** Inside handleSaveYes method ******");
        try {
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

    /**
     * Saves the transaction and closes the screen tab. Invoked when yes is clicked from save and close confirmation poup.
     * @param actionEvent
     */
    public void handleSaveCloseYes(ActionEvent actionEvent) {
        _logger.info("****** Inside handleSaveCloseYes method ******");
        try {
            
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
        _logger.info("****** Inside handleCancelYes method ******");
        AipdtUIUtil.invokeAction(Constants.CANCEL);
    }

    /**
     * Cancels transaction and Resets the screen. Invoked when yes is clicked from reset confirmation poup.
     * @param actionEvent
     */
    public void handleResetYes(ActionEvent actionEvent) {
        _logger.info("****** Inside handleResetYes method ******");
        try {
            resetScreen();
            //--AipdtUIUtil.clearTableFilter(resultsTableComp);
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

     /**
      * Helper method for resetting components on the screen.
      */
     private void resetScreen() {
         _logger.info("****** Inside resetScreen method ******");
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

             //resetItemListComponent();
             //enableDisableItemListComponent();
            //-- getCheckBoxAllComp().resetValue();
             //resetPopup.hide();
             resetViewObjectOnReset();
             AdfFacesContext.getCurrentInstance().addPartialTarget(resultsContainer);

         } catch (Exception e) {
             _logger.severe("Exception occured in resetScreen method");
             e.printStackTrace();
         }
     }
    /**
     * Helper method for clearing search and results view objects.
     */
    private void resetViewObjectOnReset() {
        _logger.info("****** Inside resetViewObjectOnReset method ******");
        RsOrderScheduleAM rsosAM = (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
        rsosAM.handleReset();
    }
    

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = saveSuccessPopup;
    }

    public RichPopup getSaveSuccessPopup() {
        return saveSuccessPopup;
    }

    public void setSaveCloseSuccessPopup(RichPopup saveCloseSuccessPopup) {
        this.saveCloseSuccessPopup = saveCloseSuccessPopup;
    }

    public RichPopup getSaveCloseSuccessPopup() {
        return saveCloseSuccessPopup;
    }
    
    /**
     * Initializes the screeen after save. Invoked when ok is clicked from save successful confirmation popup.
     * @param actionEvent
     */
    public void handleSaveOk(ActionEvent actionEvent) {
        _logger.info("****** Inside handleSaveOk method ******");
        handleResetYes(null);
    }

    /**
     * Closes the screen after save. Invoked when ok is clicked from save and close successful confirmation popup.
     * @param actionEvent
     */
    public void handleSaveCloseOk(ActionEvent actionEvent) {
        _logger.info("****** Inside handleSaveCloseOk method ******");
        AipdtUIUtil.invokeAction(Constants.CLOSE_CONTENT);
    }

     /**
      * Invoked when item list value is changed in search section.
      * @param valueChangeEvent
      */
     public void onItemListVCE(ValueChangeEvent valueChangeEvent) {
         _logger.info("****** Inside onItemListVCE method ******");
         try {
             _logger.info("Entering  onItemListVCE()");

             AipdtUIUtil.setValueToEL("#{bindings.ItemlistAttr.inputValue}", valueChangeEvent.getNewValue());
             Object newValue = AipdtUIUtil.resolveExpression("#{bindings.ItemlistAttr.attributeValue}");
             _logger.info("ItemList value :" + newValue);
             if (newValue != null && !newValue.toString().isEmpty()) {
                 itemListVal = String.valueOf(newValue);
                 //supplierComp.setDisabled(false);
             } else {
                 itemListVal = null;
                // supplierComp.setDisabled(true);
             }
             enableDisableFields();
             //enableDisableFieldsOnItemListVCE(itemListVal);

         } catch (Exception e) {
             _logger.severe("Exception occured in onItemListVCE method");
             e.printStackTrace();
         }
     }
    /**
     * Enable/disable fields on ItemList value change.
     * @param itemList
     */
    private void enableDisableFieldsOnItemListVCE(Object itemList) {
        _logger.info("****** Inside enableDisableFieldsOnItemListVCE method ******");
        if (itemList != null) {
            isSupplierDisable = false;
            isRegionDisable = false;
            isStoreDisable = false;
            isStoreListDisable = false;

            departmentComp.setDisabled(true);
            disableSourceFields(false);

        } else {
            resetSupplierComponent();

            isSupplierDisable = true;
            isRegionDisable = true;
            isStoreDisable = true;
            isStoreListDisable = true;

            departmentComp.setDisabled(false);
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            resetRegionComponent();
            resetStoreListComponent();
            resetSourceComponents();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(regionComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
    }

     /**
      * Invoked when supplier value is changed in search section.
      * @param valueChangeEvent
      */
     public void onSupplierVCE(ValueChangeEvent valueChangeEvent) {
         try {
             _logger.info("****** Inside onSupplierVCE method ******");
             valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
             Object newValue = valueChangeEvent.getNewValue();
             _logger.info("Supplier newValue :" + newValue);
             if (newValue != null && !newValue.toString().isEmpty()) {
                 //supplierVal = String.valueOf(newValue);
                 Object idVal = fetchSupplierIdFromCode(String.valueOf(newValue));
                 supplierVal = idVal != null && !idVal.toString().isEmpty() ? idVal.toString() : null;

             } else {
                 supplierVal = null;
             }
             enableSearchButton();
         } catch (Exception e) {
             _logger.severe("Exception occured in onSupplierVCE method");
             e.printStackTrace();
         }
     }
     /**
      * Invoked when VPN value is changed in search section.
      *
      */
     public void onVpnVCE() {
         _logger.info("****** Inside onVpnVCE method ******");
         try {
             String vpnCode = null;
             String newValue = multiSelectBaseFieldsBean.getVpnComp().getSelectedValues();
             _logger.info("VPN newValue :" + newValue);
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
             _logger.severe("Exception occured in onVpnVCE method");
             e.printStackTrace();
         }
     }

    /**
     * Invoked when VPN Color value is changed in search section.
     */
    public void onVpnColourVCE() {
        _logger.info("****** Inside onVpnColourVCE method ******");
        try {
            String newValue = multiSelectBaseFieldsBean.getStyleColourComp().getSelectedValues();
            _logger.info("vpnColour newValue :" + newValue);
            String vpnCode = null;
            if (newValue != null && !newValue.isEmpty()) {
                vpnCode = newValue;
            } else {
                vpnCode = null;
            }
            vpnColourIdVal = multiSelectBaseFieldsBean.getStyleColourComp().getIdValueFromCode();

            filterSkuComponent();
            enableSearchButton();

        } catch (Exception e) {
            _logger.severe("Exception occured in onVpnColourVCE method");
            e.printStackTrace();
        }
    }

    /**
     * Invoked when SKU value is changed in search section.
     */
    public void onSkuVCE() {
        _logger.info("****** Inside onSkuVCE method ******");
        try {
            String newValue = multiSelectBaseFieldsBean.getItemComp().getSelectedValues();
            _logger.info("Item newValue :" + newValue);
            skuIdVal = multiSelectBaseFieldsBean.getItemComp().getIdValueFromCode();
            String skuCode = null;
            if (newValue != null && !newValue.isEmpty()) {
                skuCode = newValue;
            } else {
                skuCode = null;
            }
            enableSearchButton();
        } catch (Exception e) {
            _logger.severe("Exception occured in onSkuVCE method");
            e.printStackTrace();
        }

    }


     /**
      * Invoked when warehouse value is changed in search section.
      * @param valueChangeEvent
      */
     public void onWarehouseVCE(ValueChangeEvent valueChangeEvent) {
         _logger.info("****** Inside onWarehouseVCE method ******");
         valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
         AipdtUIUtil.setValueToEL("#{bindings.Warehouse.inputValue}", valueChangeEvent.getNewValue());
         Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Warehouse.attributeValue}");
         if (newValue != null && !newValue.toString().isEmpty()) {
             warehouseIdVal = newValue.toString();
         } else {
             warehouseIdVal = null;
         }
         enableSearchButton();
     }

    
     /**
      * Invoked when region value is changed in search section.
      * @param valueChangeEvent
      */
     public void onRegionVCE(ValueChangeEvent valueChangeEvent) {
         _logger.info("****** Inside onRegionVCE method ******");
         try {
             valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
             AipdtUIUtil.setValueToEL("#{bindings.Region.inputValue}", valueChangeEvent.getNewValue());
             Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Region.attributeValue}");
             _logger.info("Region newValue :" + newValue);
             if (newValue != null && !newValue.toString().isEmpty()) {
                 regionIdVal = String.valueOf(newValue);
             } else {
                 regionIdVal = null;
             }
             multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
             storeVal = null;
             AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
             
             disableStoreListComponent();
             
             //Filter StoreVOLOV VO based on RegionId.
             RsOrderScheduleAM rsosAM =
                 (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
             rsosAM.filterStoreVO(regionIdVal);
             
             AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
             enableSearchButton();
         } catch (Exception e) {
             _logger.severe("Exception occured in onRegionVCE method");
             e.printStackTrace();
         }
     }
     /**
      * Helper method to disable store list component in search section.
      */
     private void disableStoreListComponent() {
         _logger.info("****** Inside disableStoreListComponent method ******");
         try {
             if ((!StringUtil.isNullOrEmpty(regionIdVal)) || (!StringUtil.isNullOrEmpty(storeVal))) {
                 //getStoreListComp().setDisabled(true);
                 resetStoreListComponent();
             } else {
                 getStoreListComp().setDisabled(false);
                 //if (!StringUtil.isNullOrEmpty(storeListVal)) {
                     //resetStoreListComponent();
                 //}
                 AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
             }
         } catch (Exception e) {
             _logger.severe("Exception occured in disableStoreListComponent method");
             e.printStackTrace();
         }
     }
     /**
      * Invoked when store value is changed in search section.
      * @param valueChangeEvent
      */
     public void onStoreVCE(ValueChangeEvent valueChangeEvent) {
         _logger.info("****** Inside onStoreVCE method ******");
         try {
             Object newValue = valueChangeEvent.getNewValue();
             _logger.info("Store newValue :" + newValue);
             if (newValue != null && !newValue.toString().isEmpty()) {
                 storeVal = (String) newValue;
             } else {
                 storeVal = null;
             }
             disableStoreListComponent();
             enableSearchButton();
         } catch (Exception e) {
             _logger.severe("Exception occured in onStoreVCE method");
             e.printStackTrace();
         }
     }
     /**
      * Invoked when store list value is changed in search section.
      * @param valueChangeEvent
      */
     public void onStoreListVCE(ValueChangeEvent valueChangeEvent) {
         _logger.info("****** Inside onStoreListVCE method ******");
         try {
             AipdtUIUtil.setValueToEL("#{bindings.StoreList.inputValue}", valueChangeEvent.getNewValue());
             Object newValue = AipdtUIUtil.resolveExpression("#{bindings.StoreList.attributeValue}");
             _logger.info("StoreList newValue :" + newValue);
             if (newValue != null && !newValue.toString().isEmpty()) {
                 storeListVal = String.valueOf(newValue);
             } else {
                 storeListVal = null;
             }
             disableRegionAndStoreComponent();
             enableSearchButton();
             // AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
         } catch (Exception e) {
             _logger.severe("Exception occured in onStoreListVCE method");
             e.printStackTrace();
         }
     }
    
    /**
     * Helper method to disable region and store components in search section.
     */
    private void disableRegionAndStoreComponent() {
        _logger.info("****** Inside disableRegionAndStoreComponent method ******");
        try {
            if (!StringUtil.isNullOrEmpty(storeListVal)) {
                resetRegionComponent();
                resetStoreComponent();
                /*isRegionDisable = true;
                isStoreDisable = true;
                if (regionComp != null && regionComp.getValue() != null) {
                    regionIdVal = null;
                    regionComp.setValue(null);
                }*/
                /*multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
                storeVal = null;
                multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());*/
            } else {
                getRegionComp().setDisabled(false);
                multiSelectBaseFieldsBean.getStoreComp().setComponentDisable(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
                AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
            }
        } catch (Exception e) {
            _logger.severe("Exception occured in disableRegionAndStoreComponent method");
            e.printStackTrace();
        }
    }
    
    /**
     * Fetches Sku from DT_LIST_DETAIL table based on input item list value.
     * @param itemList
     * @return
     */
    private String getItemValueFromDtListDetailTbl(Integer itemList) {
        _logger.info("****** Inside getItemValueFromDtListDetailTbl method ******");
        RsOrderScheduleAM rsosAM = (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
        String itemVal = rsosAM.getIdsFromDtListDetailTable(itemList, "ITEM_LIST");
        return itemVal;
    }

    /**
     * Fetches store from DT_LIST_DETAIL table based on input store list value.
     * @param storeList
     * @return
     */
    private String getStoreValueFromDtListDetailTbl(Integer storeList) {
        _logger.info("****** Inside getStoreValueFromDtListDetailTbl method ******");
        RsOrderScheduleAM rsosAM = (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
        String itemVal = rsosAM.getIdsFromDtListDetailTable(storeList, "STORE_LIST");

        return itemVal;
    }
    
    /**
     * Invokes AM method to fetch supplier Id for the given supplier code.
     * @param supplierCode
     * @return
     */
    private Object fetchSupplierIdFromCode(String supplierCode) {
        _logger.info("****** Inside fetchSupplierIdFromCode method ******");
        RsOrderScheduleAM rsosAM = (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
        return rsosAM.getSupplierIdFromCode(supplierCode, deptId);
    }
    
    /**
     * Invoked when class value is changed in search section.
     * @param valueChangeEvent
     */
    public void onClassVCE(ValueChangeEvent valueChangeEvent) {
        _logger.info("****** Inside onClassVCE method ******");
        try {
            _logger.info("Entering  onClassVCE()");
            Object newValue = valueChangeEvent.getNewValue();
            _logger.info("class newValue :" + newValue);
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
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        } catch (Exception e) {
            _logger.severe("Exception occured in onClassVCE method");
            e.printStackTrace();
        }
    }
    
    /**
     * Invoked when subclass value is changed in search section.
     * @param valueChangeEvent
     */
    public void onSubClassVCE(ValueChangeEvent valueChangeEvent) {
        _logger.info("****** Inside onSubClassVCE method ******");
        try {
            _logger.info("Entering  onSubClassVCE()");
            Object newValue = valueChangeEvent.getNewValue();
            _logger.info("subClass newValue :" + newValue);
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
            _logger.severe("Exception occured in onSubClassVCE method");
            e.printStackTrace();
        }
    }
    
    /**
     * Invoked when All check box value is changed in the results table.
     * @param valueChangeEvent
     */
    public void onCheckBoxAllValueChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("****** Inside onCheckBoxAllValueChange method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        _logger.info("old value===>" + valueChangeEvent.getOldValue());
        _logger.info("new  value===>" + valueChangeEvent.getNewValue());

        boolean oldValue =
            (valueChangeEvent.getOldValue() == null) ? false :
            Boolean.parseBoolean(valueChangeEvent.getOldValue().toString());
        boolean newValue =
            (valueChangeEvent.getNewValue() == null) ? false :
            Boolean.parseBoolean(valueChangeEvent.getNewValue().toString());
        if (oldValue != newValue) {
            RsOrderScheduleAM rsosAM = (RsOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RSOS_AM);
            long numberOfRecords = rsosAM.handleCheckBoxAll(newValue);
            if (numberOfRecords > 0) {
                if (getResultsTableComp() != null) {
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
                }
            }
        }
    }
    
    /**
     * Invoked on Department link selection to show Item/Sku hierarchy popup to user
     * @param actionEvent
     */
    public void onClickViewItemPopup(ActionEvent actionEvent) {
        //get access to the clicked command link
        //RichLink comp = (RichLink)actionEvent.getComponent();
        //read the added f:attribute value
        //Key rowKey = (Key) comp.getAttributes().get("rowKey");
//--        ViewObject itemHierVO = AipdtUIUtil.findIterator(ITEM_POPUP_VO_ITERATOR).getViewObject();
//--         //XDOrderScheduleResultsVORowImpl currentRow = (XDOrderScheduleResultsVORowImpl) itemHierVO.getRow(rowKey);
//--         XDOrderScheduleResultsVORowImpl currentRow =
//--             (XDOrderScheduleResultsVORowImpl) getSelectedRow(getResultsTableComp());
//--         itemHierVO.setNamedWhereClauseParam(Constants.BIND_DEPARTMENT_ID, currentRow.getDeptId());
//--         itemHierVO.setNamedWhereClauseParam(Constants.BIND_SUPPLIER_ID, currentRow.getSupplierId());
//--         itemHierVO.setNamedWhereClauseParam(Constants.BIND_STORE_ID, currentRow.getStoreId());
//--         itemHierVO.executeQuery();
//--         if (itemHierVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
//--             AipdtUIUtil.showErrorMessageFromUIBundle(Constants.REC_EXCEEDS_LIMIT, null);
//--         } else {
//--             ADFFacesUtil.showPopup(itemHierarchyPopup.getClientId(FacesContext.getCurrentInstance()));
//--         }
    }
    
    public void onClickSetDowPopup(ActionEvent actionEvent) {
        //if (areRecordsSelectedForSave() != 0) {
            //ViewObject vo = AipdtUIUtil.findIterator(TIME_SET_ALL_POPUP_VO_ITERATOR).getViewObject();
            //XDOrderScheduleTimeSetAllVORowImpl dowRow = (XDOrderScheduleTimeSetAllVORowImpl)vo.getCurrentRow();
//--            XDOrderScheduleResultsVORowImpl resultsRow =
//--                (XDOrderScheduleResultsVORowImpl) getSelectedRow(getResultsTableComp());
//--            DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(XDOS_RESULTS_VO_ITERATOR);
//--            if (dcItteratorBindings != null) {
//--                ViewObject resultsVO = dcItteratorBindings.getViewObject();
//--                resultsVO.setCurrentRow(resultsRow);
//--            }
            /*if(dowRow != null && resultsRow != null){
                dowRow.setSunday(resultsRow.getSunLeadTime());
                dowRow.setMonday(resultsRow.getMonLeadTime());
                dowRow.setTuesday(resultsRow.getTueLeadTime());
                dowRow.setWednesday(resultsRow.getWedLeadTime());
                dowRow.setThursday(resultsRow.getThuLeadTime());
                dowRow.setFriday(resultsRow.getFriLeadTime());
                dowRow.setSaturday(resultsRow.getSatLeadTime());
            }*/
//--            XDOrderScheduleAM xdosAM =
//--                (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
//--            xdosAM.createEmptyDOWRow();
//--            ADFFacesUtil.showPopup(dowSetPopup.getClientId(FacesContext.getCurrentInstance()));
        //} else {
            //AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SELECT_ROW_FOR_SETALL, null);
        //}
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
        _logger.info("****** Inside exportSelectedRows method ******");
        AipdtUIUtil.selectAllRowsInTable(getResultsTableComp(), "RsOrderScheduleResultVOIterator", Constants.UPDATE_IND_ATTR);
        return true;
    }
    
    /**
     * Invoked on click of Set All button is clicked for dates
     * @param actionEvent
     */
    public void handleSetAll(ActionEvent actionEvent) {
//--        logger.info("****** Inside handleSetAll method ******");
//--        int areRecordsSelected = areRecordsSelectedForSave(false);
//--        if(areRecordsSelected == 0){
//--            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SELECT_ROW_FOR_SETALL, null);
//--            return;
//--        }
// --       if (setAllMap.isEmpty()) {
// --           logger.severe("No records to save.");
//--            return;
// --       }
//--        XDOrderScheduleAM xdosAM = (XDOrderScheduleAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.XDOS_AM);
//--        xdosAM.handleSetAll(setAllMap);
//--        if (getResultsTableComp() != null) {
//--            AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
//--        }
//--        clearSetAllFields(null);
    }
    
    /**
     * Clears the set all fields
     */
    private void clearSetAllFields(String setAllCompId) {
        _logger.info("****** Inside clearSetAllFields method ******");
//--        setAllMap.clear();
//--        if (getSetAllStartDateComp() != null) {
//--            if (!getSetAllStartDateComp().getId().equals(setAllCompId)) {
//--                getSetAllStartDateComp().resetValue();
//--                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllStartDateComp());
// --           }
//--        }
// --       if (getSetAllEndDateComp() != null) {
// --           if (!getSetAllEndDateComp().getId().equals(setAllCompId)) {
// --               getSetAllEndDateComp().resetValue();
// --               AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllEndDateComp());
// --           }
//--        }
    }
    
}
