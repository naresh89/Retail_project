package oracle.retail.apps.aipdt.fieldbinding.publicui.bean;

import com.oracle.retail.apps.comp.ms.view.MultiselectInputListOfValues;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;

public class SearchFieldsBean {
    private final static ADFLogger _logger = ADFLogger.createADFLogger(SearchFieldsBean.class);
    private boolean departmentDisabled = false;
    private boolean classDisabled = true;
    private boolean subclassDisabled = true;
    private boolean vpnDisabled = true;
    private boolean vpncolorDisabled = true;
    private boolean skuDisabled = true;
    private boolean itemListDisabled = true;
    private boolean regionDisabled = true;
    private boolean storeDisabled = true;
    private boolean storeListDisabled = true;
    private boolean ordFromSupplierDisabled = true;
    private boolean styleDisabled = true;
    private boolean styleColorDisabled = true;
    private boolean saveBtnDisabled = true;
    private boolean searchBtnDisabled = true;

    private String deptIds = null;
    private String classIds = null;
    private String subclassIds = null;
    private String vpnIds = null;
    private String vpncolorIds = null;
    private String skuIds = null;

    private String ordFromSupplierIds = null;

    private String regionId = null;
    private String storeIds = null;
    private String storeListId = null;
    private String storeIdsFromStoreList = null;

    private RichSelectOneChoice regionComp;
    private RichSelectOneChoice storeListComp;
    private RichInputListOfValues supplierComp;
    private RichSelectOneChoice itemListComp;
    private RichButton searchBtn;
    
    private Map searchInputs = new HashMap();

    public void setDepartmentDisabled(boolean departmentDisabled) {
        this.departmentDisabled = departmentDisabled;
    }

    public boolean isDepartmentDisabled() {
        return departmentDisabled;
    }

    public void setClassDisabled(boolean classDisabled) {
        this.classDisabled = classDisabled;
    }

    public boolean isClassDisabled() {
        return classDisabled;
    }

    public void setSubclassDisabled(boolean subclassDisabled) {
        this.subclassDisabled = subclassDisabled;
    }

    public boolean isSubclassDisabled() {
        return subclassDisabled;
    }

    public void setVpnDisabled(boolean vpnDisabled) {
        this.vpnDisabled = vpnDisabled;
    }

    public boolean isVpnDisabled() {
        return vpnDisabled;
    }

    public void setVpncolorDisabled(boolean vpncolorDisabled) {
        this.vpncolorDisabled = vpncolorDisabled;
    }

    public boolean isVpncolorDisabled() {
        return vpncolorDisabled;
    }

    public void setSkuDisabled(boolean skuDisabled) {
        this.skuDisabled = skuDisabled;
    }

    public boolean isSkuDisabled() {
        return skuDisabled;
    }

    public void setItemListDisabled(boolean itemListDisabled) {
        this.itemListDisabled = itemListDisabled;
    }

    public boolean isItemListDisabled() {
        return itemListDisabled;
    }

    public void setRegionDisabled(boolean regionDisabled) {
        this.regionDisabled = regionDisabled;
    }

    public boolean isRegionDisabled() {
        return regionDisabled;
    }

    public void setStoreDisabled(boolean storeDisabled) {
        this.storeDisabled = storeDisabled;
    }

    public boolean isStoreDisabled() {
        return storeDisabled;
    }

    public void setStoreListDisabled(boolean storeListDisabled) {
        this.storeListDisabled = storeListDisabled;
    }

    public boolean isStoreListDisabled() {
        return storeListDisabled;
    }

    public void setOrdFromSupplierDisabled(boolean ordFromSupplierDisabled) {
        this.ordFromSupplierDisabled = ordFromSupplierDisabled;
    }

    public boolean isOrdFromSupplierDisabled() {
        return ordFromSupplierDisabled;
    }

    public void setSearchBtnDisabled(boolean searchBtnDisabled) {
        this.searchBtnDisabled = searchBtnDisabled;
    }

    public boolean isSearchBtnDisabled() {
        if(ordFromSupplierIds != null && (regionId != null || storeIds != null || storeListId != null)) {
            if(this.searchBtnDisabled) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public void setStyleDisabled(boolean styleDisabled) {
        this.styleDisabled = styleDisabled;
    }

    public boolean isStyleDisabled() {
        return styleDisabled;
    }

    public void setStyleColorDisabled(boolean styleColorDisabled) {
        this.styleColorDisabled = styleColorDisabled;
    }

    public boolean isStyleColorDisabled() {
        return styleColorDisabled;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setClassIds(String classIds) {
        this.classIds = classIds;
    }

    public String getClassIds() {
        return classIds;
    }

    public void setSubclassIds(String subclassIds) {
        this.subclassIds = subclassIds;
    }

    public String getSubclassIds() {
        return subclassIds;
    }

    public void setVpnIds(String vpnIds) {
        this.vpnIds = vpnIds;
    }

    public String getVpnIds() {
        return vpnIds;
    }

    public void setVpncolorIds(String vpncolorIds) {
        this.vpncolorIds = vpncolorIds;
    }

    public String getVpncolorIds() {
        return vpncolorIds;
    }

    public void setSkuIds(String skuIds) {
        this.skuIds = skuIds;
    }

    public String getSkuIds() {
        return skuIds;
    }

    public void setOrdFromSupplierIds(String ordFromSupplierIds) {
        this.ordFromSupplierIds = ordFromSupplierIds;
    }

    public String getOrdFromSupplierIds() {
        return ordFromSupplierIds;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setStoreIds(String storeIds) {
        this.storeIds = storeIds;
    }

    public String getStoreIds() {
        return storeIds;
    }

    public void setStoreListId(String storeListId) {
        this.storeListId = storeListId;
    }

    public String getStoreListId() {
        return storeListId;
    }

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

    public void setSupplierComp(RichInputListOfValues supplierComp) {
        this.supplierComp = supplierComp;
    }

    public RichInputListOfValues getSupplierComp() {
        return supplierComp;
    }

    public void setItemListComp(RichSelectOneChoice itemListComp) {
        this.itemListComp = itemListComp;
    }

    public RichSelectOneChoice getItemListComp() {
        return itemListComp;
    }

    public void setSaveBtnDisabled(boolean saveBtnDisabled) {
        this.saveBtnDisabled = saveBtnDisabled;
    }

    public boolean isSaveBtnDisabled() {
        return saveBtnDisabled;
    }

    public void setStoreIdsFromStoreList(String storeIdsFromStoreList) {
        this.storeIdsFromStoreList = storeIdsFromStoreList;
    }

    public String getStoreIdsFromStoreList() {
        return storeIdsFromStoreList;
    }

    public void setSearchInputs(Map searchInputs) {
        this.searchInputs = searchInputs;
    }

    public Map getSearchInputs() {
        return searchInputs;
    }

    public SearchFieldsBean() {
        super();
    }
    
    public void setSearchBtn(RichButton searchBtn) {
        this.searchBtn = searchBtn;
    }

    public RichButton getSearchBtn() {
        return searchBtn;
    }

    private void searchBtnRefresh() {
        if(ordFromSupplierIds != null && (regionId != null || storeIds != null || storeListId != null)) {
            if(this.searchBtnDisabled) {
                searchBtn.setDisabled(false);
            } else {
                searchBtn.setDisabled(true);
            }
        } else {
            searchBtn.setDisabled(true);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtn);
    }
    public void onStoreListChange(MultiSelectBaseFieldsBean msBean, ValueChangeEvent valueChangeEvent) {
        _logger.info("Inside  onStoreListChange ");
        getStoreListComp().processUpdates(FacesContext.getCurrentInstance());
        Object newValue = AipdtUIUtil.resolveExpression("#{bindings.StoreList.attributeValue}");
        if (!StringUtil.isNullOrEmpty(newValue)) {
            storeListId = String.valueOf(newValue);
            storeDisabled = true;
            regionDisabled = true;
        } else {
            storeListId = null;
            storeDisabled = false;
            regionDisabled = false;
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getStoreComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(regionComp);
        searchBtnRefresh();
    }

    public void onStoreChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("Inside  onStoreChange ");
        Object newValue = valueChangeEvent.getNewValue();
        _logger.info("Selected Store:" + newValue);

        if (!StringUtil.isNullOrEmpty(newValue)) {
            storeIds = String.valueOf(newValue);
            storeListDisabled = true;
        } else {
            storeIds = null;
            storeListDisabled = false;
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        searchBtnRefresh();
    }

    public void onRegionChange(MultiSelectBaseFieldsBean msBean, ValueChangeEvent valueChangeEvent) {
        _logger.info("Inside  onRegionChange ");
        regionComp.processUpdates(FacesContext.getCurrentInstance());
        Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Region.attributeValue}");
        
        if (!StringUtil.isNullOrEmpty(newValue)) {
            regionId = String.valueOf(newValue);
            storeListDisabled = true;
        } else {
            regionId = null;
            storeListDisabled = false;
        }

        //Filter Stores based on selected Region
        OperationBinding storeOpBind = AipdtUIUtil.findOperation("filterStoresByRegion");
        if (storeOpBind != null) {
            storeOpBind.execute();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getStoreComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        searchBtnRefresh();
    }

    public void onSupplierChange(MultiSelectBaseFieldsBean msBean) {
        _logger.info("Inside onSupplierChange ");
        String newValue = msBean.getSupplierComp().getSelectedValues();
        ordFromSupplierIds = msBean.getSupplierComp().getIdValueFromCode();
        String supplierCode = null;
        if (!StringUtil.isNullOrEmpty(newValue)) {
            supplierCode = newValue;
        } else {
            supplierCode = null;
        }
        searchBtnRefresh();
    }

    public void onDepartmentChange(MultiSelectBaseFieldsBean msBean, ValueChangeEvent valueChangeEvent,
                                   boolean... isDisableVarargs) {
        _logger.info("Inside onDepartmentChange ");
        Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Department.attributeValue}");        
        if (!StringUtil.isNullOrEmpty(newValue)) {
            deptIds = String.valueOf(newValue);
            filterSupplierComponent(msBean);            
            if(StringUtil.isNullOrEmpty(regionId) && StringUtil.isNullOrEmpty(storeIds) && StringUtil.isNullOrEmpty(storeListId)) {
                enableOrDisableDestFields(msBean, isDisableVarargs[3]);
            }
            
            setDepartmentIdOnShuttleComponent(msBean);
            enableOrDisableProdHierFields(msBean, isDisableVarargs);
            enableOrDisableOrdFromSuppField(msBean, isDisableVarargs[2]);
        }        
    }

    private void enableOrDisableProdHierFields(MultiSelectBaseFieldsBean msBean, boolean... isDisableVarargs) {
        boolean isDisable = isDisableVarargs[0];

        classDisabled = isDisable;
        subclassDisabled = isDisable;
        skuDisabled = isDisable;
        vpnDisabled = isDisable;
        vpncolorDisabled = isDisable;

        itemListDisabled = isDisableVarargs[1];

        if (isDisable) {
            skuIds = null;
            classIds = null;
            subclassIds = null;
            vpnIds = null;
            vpncolorIds = null;

            msBean.resetMultiShuttleComponent(msBean.getItemComp());
            msBean.resetMultiShuttleComponent(msBean.getVpnComp());
            msBean.resetMultiShuttleComponent(msBean.getStyleColourComp());
            msBean.getClassComp().resetDeclarativeComponent();
            msBean.getSubClassComp().resetDeclarativeComponent();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getSubClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getItemComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getVpnComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getStyleColourComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
    }

    private void enableOrDisableDestFields(MultiSelectBaseFieldsBean msBean, boolean isDisable) {
        if (isDisable) {
            regionId = null;
            storeIds = null;
            storeListId = null;
            regionComp.resetValue();
            storeListComp.resetValue();
            msBean.getStoreComp().resetDeclarativeComponent();
        }    
        
        regionDisabled = isDisable;
        storeDisabled = isDisable;
        storeListDisabled = isDisable;
        AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getStoreComp());
    }

    private void enableOrDisableOrdFromSuppField(MultiSelectBaseFieldsBean msBean, boolean isOrdFromSuppl) {        
        msBean.resetMultiShuttleComponent(msBean.getSupplierComp());
        setOrdFromSupplierDisabled(isOrdFromSuppl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(msBean.getSupplierComp());
    }
    
    private void filterSupplierComponent(MultiSelectBaseFieldsBean msBean) {
        _logger.info("Inside filterSupplierComponent ");
        MultiselectInputListOfValues comp = msBean.getSupplierComp();
        try {
            msBean.resetMultiShuttleComponent(comp);
            ordFromSupplierIds = null;
            AdfFacesContext.getCurrentInstance().addPartialTarget(comp);
        } catch (Exception e) {
            _logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }

    private void setDepartmentIdOnShuttleComponent(MultiSelectBaseFieldsBean msBean) {
        if (msBean.getSupplierComp() != null) {
            msBean.getSupplierComp().getValueInputText().setValue(deptIds);
            msBean.getSupplierComp().setDEPARTMENT_ID(deptIds);
        }
    }
}
