package oracle.retail.apps.aipdt.rc.publicui.bean;


import com.oracle.retail.apps.comp.ms.view.SelectManyInputCheckBox;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.JboException;
import oracle.jbo.ViewObject;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.rc.model.applicationmodule.common.ReceivingCalendarAM;
import oracle.retail.apps.aipdt.rc.model.view.ReceivingCalendarSearchVORowImpl;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;


public class ReceivingCalendarBean {
    private static ADFLogger logger =
        ADFLogger.createADFLogger(ReceivingCalendarBean.class);
    private SelectManyInputCheckBox storeComponent;
    private RichSelectOneChoice storeFormatComponent;
    private SelectManyInputCheckBox warehouseComponent;
    private String inputStoreValue;
    private String inputWarehouseValue;
    private RichTable resultsTableComp;
    private boolean saveDisabled = true;
    private boolean selectDisabled;
    private RichPopup savePopup;
    private RichPopup saveClosePopup;
    private RichPopup cancelPopup;
    private RichPopup resetPopup;
    private RichPopup saveCloseSuccessPopup;
    private RichPopup saveSuccessPopup;
    private RichSelectOneChoice locationTypeComp;
    private RichSelectOneChoice productTypeComp;
    private RichPanelGroupLayout resultsArea;
    private long numberOfResultRecords;
    private boolean endDateDisable;


    public ReceivingCalendarBean() {
    }

    private boolean defaultSelected;
    private boolean exceptionSelected;

    public void setDefaultSelected(boolean defaultSelected) {
        this.defaultSelected = defaultSelected;
    }

    public boolean isDefaultSelected() {
        return defaultSelected;
    }

    public void setExceptionSelected(boolean exceptionSelected) {
        this.exceptionSelected = exceptionSelected;
    }

    public boolean isExceptionSelected() {
        return exceptionSelected;
    }

    public void setStoreComponent(SelectManyInputCheckBox storeComponent) {
        this.storeComponent = storeComponent;
    }

    public SelectManyInputCheckBox getStoreComponent() {
        return storeComponent;
    }

    public void setStoreFormatComponent(RichSelectOneChoice storeFormatComponent) {
        this.storeFormatComponent = storeFormatComponent;
    }

    public RichSelectOneChoice getStoreFormatComponent() {
        return storeFormatComponent;
    }

    public void setWarehouseComponent(SelectManyInputCheckBox warehouseComponent) {
        this.warehouseComponent = warehouseComponent;
    }

    public SelectManyInputCheckBox getWarehouseComponent() {
        return warehouseComponent;
    }

    /**
     * Invoked when default radio button value is changed
     * @param valueChangeEvent
     */
    public void onDefaultVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("Inside onDefaultVCE method from RC");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        defaultSelected = (Boolean)valueChangeEvent.getNewValue();
        logger.info("Default Level : " + defaultSelected);
    }

    /**
     * Invoked when exception radio button value is changed
     * @param valueChangeEvent
     */
    public void onExceptionVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("Inside onExceptionVCE method from RC");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        exceptionSelected = (Boolean)valueChangeEvent.getNewValue();
        logger.info("Exception Level : " + exceptionSelected);
    }

    /**
     * Invoked when location type value is changed
     * @param valueChangeEvent
     */
    public void onLocationTypeVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("Inside onLocationTypeVCE method from RC");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        Map map = ((UIComponent)valueChangeEvent.getSource()).getAttributes();
        String locationType = (String)map.get("locationTypeVal");
        logger.info("Location Type Selected : " + locationType);
        resetAllLocations();
        if (!StringUtil.isNullOrEmpty(locationType)) {
            productTypeComp.setDisabled(false);
            if (Constants.LOC_TYPE_STORE.equals(locationType)) {
                warehouseComponent.setComponentDisable(true);
                storeComponent.setComponentDisable(false);
                storeFormatComponent.setDisabled(false);
            } else if (Constants.LOC_TYPE_WAREHOUSE.equals(locationType)) {
                storeFormatComponent.setDisabled(true);
                storeComponent.setComponentDisable(true);
                warehouseComponent.setComponentDisable(false);
            }
        }
        else{
            productTypeComp.setDisabled(true);
            warehouseComponent.setComponentDisable(true);
            storeComponent.setComponentDisable(true);
            storeFormatComponent.setDisabled(true);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(productTypeComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeFormatComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(warehouseComponent);
    }
    
    /**
     * Resets only the location components in the search area
     */
    private void resetAllLocations(){
        logger.info("Inside resetAllLocations method");
        warehouseComponent.resetDeclarativeComponent();
        storeComponent.resetDeclarativeComponent();
        storeFormatComponent.resetValue();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeFormatComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(warehouseComponent);
    }
    
    /**
     * Resets all the components in the search area
     */
    private void resetAll(){
        logger.info("Inside resetAll method");
        locationTypeComp.resetValue();
        productTypeComp.resetValue();
        storeFormatComponent.resetValue();
        storeComponent.resetDeclarativeComponent();
        warehouseComponent.resetDeclarativeComponent();
        
        locationTypeComp.setDisabled(false);
        productTypeComp.setDisabled(true);
        storeFormatComponent.setDisabled(true);
        storeComponent.setComponentDisable(true);
        warehouseComponent.setComponentDisable(true);
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(locationTypeComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(productTypeComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeFormatComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(warehouseComponent);
        
        setSelectDisabled(false);
        setSaveDisabled(true);
        getResultsArea().setVisible(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsArea());
    }
    
    /**
     * Disables all the components in the search area
     */
    private void disableAll(){
        logger.info("Inside disableAll method");
        storeFormatComponent.setDisabled(true);
        storeComponent.setComponentDisable(true);
        warehouseComponent.setComponentDisable(true); 
        locationTypeComp.setDisabled(true);
        productTypeComp.setDisabled(true);

        AdfFacesContext.getCurrentInstance().addPartialTarget(storeFormatComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(warehouseComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(locationTypeComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(productTypeComp);
    }
    
    /**
     * Invoked when product type value is changed
     * @param valueChangeEvent
     */
    public void onProductTypeVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("Inside onProductTypeVCE method RC");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        Map map = ((UIComponent)valueChangeEvent.getSource()).getAttributes();
        String productType = (String)map.get("productTypeVal");
        logger.info("Product Type Selected : " + productType);
    }

    /**
     * Invoked when store format value is changed
     * @param valueChangeEvent
     */
    public void onStoreFormatVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("Inside onStoreFormatVCE method from RC");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        Map map = ((UIComponent)valueChangeEvent.getSource()).getAttributes();
        String storeFormat = (String)map.get("storeFormatVal");
        logger.info("Store Format Selected : " + storeFormat);
        storeComponent.resetDeclarativeComponent();
        if(!StringUtil.isNullOrEmpty(storeFormat)){
            storeComponent.setComponentDisable(true); 
        }
        else{
            storeComponent.setComponentDisable(false);  
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeComponent);
    }

    /**
     * Invoked when store value is changed
     * @param valueChangeEvent
     */
    public void onStoreVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("Inside onStoreVCE method from RC");
        //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        inputStoreValue = (String)valueChangeEvent.getNewValue();
        storeFormatComponent.resetValue();
        if(!StringUtil.isNullOrEmpty(inputStoreValue)){
            storeFormatComponent.setDisabled(true);
        }
        else{
            storeFormatComponent.setDisabled(false); 
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeFormatComponent);
        logger.info("Store Selected : " + inputStoreValue);
    }

    /**
     * Invoked when warehouse value is changed
     * @param valueChangeEvent
     */
    public void onStockingPointVCE(ValueChangeEvent valueChangeEvent) {
        logger.info("Inside onStockingPointVCE method from RC");
        //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        inputWarehouseValue = (String)valueChangeEvent.getNewValue();

        logger.info("Warehouse Selected : " + inputWarehouseValue);
        
    }

    /**
     * Invoked when select button is clicked from the search area
     * @param actionEvent
     */
    public void handleSearchEvent(ActionEvent actionEvent) {
        logger.info("Inside handleSearchEvent method from RC");
        boolean isValid = false;
        try {
            isValid = validateInput();
            if (isValid) {
                setSelectDisabled(true);
                ReceivingCalendarAM rcAM =
                    (ReceivingCalendarAM)AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RECEIVING_CALENDAR_AM);
                disableAll();
                boolean selectValid = rcAM.handleSelect();
                if (!selectValid) {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                        Constants.EXCEPTION_WITHOUT_DEFAULT_ERROR), null);
                    return;
                }
                getResultsArea().setVisible(true);
                setSaveDisabled(getNumberOfResultRecords() < 1);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsArea());
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
     * Helper method to validate the search criteria input passed 
     * @return
     */
    private boolean validateInput(){
        logger.info("Inside validateInput method");
        boolean isValidInput = true;
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("ReceivingCalendarSearchVO1Iterator");
        if (dcItteratorBindings != null) {
            ViewObject viewObject = dcItteratorBindings.getViewObject();
            ReceivingCalendarSearchVORowImpl currentRow = (ReceivingCalendarSearchVORowImpl)viewObject.getCurrentRow();
            currentRow.setStore((String)storeComponent.getValueInputText().getValue());
            currentRow.setStockingPoint((String)warehouseComponent.getValueInputText().getValue());
            
            //Start Validation
            boolean isStoreValid = ((storeComponent.getComponentDisable() != null) && storeComponent.getComponentDisable()) || !StringUtil.isNullOrEmpty(currentRow.getStore());
            boolean isStoreFormatValid = storeFormatComponent.isDisabled() || !StringUtil.isNullOrEmpty(currentRow.getStoreFormat());
            boolean isWarehouseValid = ((warehouseComponent.getComponentDisable() != null) && warehouseComponent.getComponentDisable()) || !StringUtil.isNullOrEmpty(currentRow.getStockingPoint());
            boolean isLocationTypeValid = locationTypeComp.isDisabled() || !StringUtil.isNullOrEmpty(currentRow.getLocationType());
            boolean isProductTypeValid = productTypeComp.isDisabled() || !StringUtil.isNullOrEmpty(currentRow.getProductType());
            
            if(!isLocationTypeValid) {
                isValidInput = false;  
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                               Constants.RC_LOCATION_TYPE_REQUIRED), locationTypeComp);
            }
            else if(!isProductTypeValid) {
                isValidInput = false;  
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                               Constants.RC_PRODUCT_TYPE_REQUIRED), productTypeComp);
            }
            else if(!isStoreValid && !isStoreFormatValid){
                isValidInput = false;  
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                               Constants.RC_STORE_REQUIRED), storeComponent.getValueInputText());
            }
            else if(!isWarehouseValid){
                isValidInput = false;  
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                               Constants.RC_WAREHOUSE_REQUIRED), warehouseComponent.getValueInputText());
            }
        }
        return isValidInput;
    }
    
    /**
     * Invoked when reset button is clicked from the search area
     * @param actionEvent
     */
    public void handleResetEvent(ActionEvent actionEvent) {
        logger.info("Inside handleResetEvent method from RC");
        ADFFacesUtil.showPopup(resetPopup.getClientId(FacesContext.getCurrentInstance()));
    }

    public void setResultsTableComp(RichTable resultsTableComp) {
        this.resultsTableComp = resultsTableComp;
    }

    public RichTable getResultsTableComp() {
        return resultsTableComp;
    }

    /**
     * Invoked when Cancel button is clicked, which triggers the cancel confirmation popup
     * @return
     */
    public String handleCancelEvent() {
        logger.info("Inside handleCancelEvent method from RC");
        ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    /**
     * Invoked when SaveAndClose button is clicked, which triggers the SaveAndClose confirmation popup
     * @return
     */
    public String handleSaveAndCloseEvent() {
        logger.info("Inside handleSsaveAndCloseEvent method from RC");
        ADFFacesUtil.showPopup(saveClosePopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    /**
     * Invoked when Save button is clicked, which triggers the Save confirmation popup
     * @param actionEvent
     */
    public void handleSaveEvent(ActionEvent actionEvent) {
        logger.info("Inside handleSaveEvent method from RC");
        ADFFacesUtil.showPopup(savePopup.getClientId(FacesContext.getCurrentInstance()));
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void setSavePopup(RichPopup savePopup) {
        this.savePopup = savePopup;
    }

    public RichPopup getSavePopup() {
        return savePopup;
    }

    /**
     * Invoked when user selects 'Yes' from the Save confirmation popup
     * @param actionEvent
     */
    public void saveYesListener(ActionEvent actionEvent) {
        logger.info("Inside saveYesListener method");
        try{
            ReceivingCalendarAM rcAM = (ReceivingCalendarAM)AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RECEIVING_CALENDAR_AM);
            rcAM.saveReceivingCalendar();  
            setSaveDisabled(true);
            ADFFacesUtil.showPopup(saveSuccessPopup.getClientId(FacesContext.getCurrentInstance()));
        }
        catch(JboException jboEx){
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                               Constants.DEAFULT_ERROR_MSG), null);
        }
        catch(Exception ex){
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
     * Invoked when user selects 'Yes' from the SaveAndClose confirmation popup
     * @param actionEvent
     */
    public void saveCloseYesListener(ActionEvent actionEvent) {
        logger.info("Inside saveCloseYesListener method");
        try{
            ReceivingCalendarAM rcAM = (ReceivingCalendarAM)AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RECEIVING_CALENDAR_AM);
            rcAM.saveReceivingCalendar();  
            setSaveDisabled(true);
            ADFFacesUtil.showPopup(saveCloseSuccessPopup.getClientId(FacesContext.getCurrentInstance()));
        }
        catch(JboException jboEx){
            jboEx.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                               Constants.DEAFULT_ERROR_MSG), null);
        }
        catch(Exception ex){
            ex.printStackTrace();
            AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                               Constants.DEAFULT_ERROR_MSG), null);
        }
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

    /**
     * Invoked when user selects 'Yes' from the Reset confirmation popup
     * @param actionEvent
     */
    public void resetYesListener(ActionEvent actionEvent) {
        logger.info("Inside resetYesListener method");
        try {
            ReceivingCalendarAM rcAM =
                (ReceivingCalendarAM)AipdtUIUtil.findApplicationModuleFromRootAM(Constants.RECEIVING_CALENDAR_AM);
            rcAM.handleReset();
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

    /**
     * Invoked when user selects 'Ok' from the SaveAndClose Success confirmation popup, which closes the tab.
     * @param actionEvent
     */
    public void saveCloseOkListener(ActionEvent actionEvent) {
        logger.info("Inside saveCloseOkListener method");
        AipdtUIUtil.invokeAction(Constants.CLOSE_CONTENT);
    }

    public void setSaveCloseSuccessPopup(RichPopup saveCloseSuccessPopup) {
        this.saveCloseSuccessPopup = saveCloseSuccessPopup;
    }

    public RichPopup getSaveCloseSuccessPopup() {
        return saveCloseSuccessPopup;
    }

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = saveSuccessPopup;
    }

    public RichPopup getSaveSuccessPopup() {
        return saveSuccessPopup;
    }

    /**
     * Invoked when user selects 'Yes' from the Cancel confirmation popup
     * @param actionEvent
     */
    public void cancelYesListener(ActionEvent actionEvent) {
        logger.info("Inside cancelYesListener method");
        AipdtUIUtil.invokeAction(Constants.CANCEL);
    }

    public void setLocationTypeComp(RichSelectOneChoice locationTypeComp) {
        this.locationTypeComp = locationTypeComp;
    }

    public RichSelectOneChoice getLocationTypeComp() {
        return locationTypeComp;
    }

    public void setProductTypeComp(RichSelectOneChoice productTypeComp) {
        this.productTypeComp = productTypeComp;
    }

    public RichSelectOneChoice getProductTypeComp() {
        return productTypeComp;
    }

    public void setResultsArea(RichPanelGroupLayout resultsArea) {
        this.resultsArea = resultsArea;
    }

    public RichPanelGroupLayout getResultsArea() {
        return resultsArea;
    }
    
    /**
     * Returns the number of records from results table.
     * @return
     */
    public long getNumberOfResultRecords() {
        logger.info("Inside getNumberOfResultRecords method");
        DCIteratorBinding dcItteratorBindings =
            AipdtUIUtil.findIterator("ReceivingCalendarResultsVO1Iterator");
        if (dcItteratorBindings != null) {
            numberOfResultRecords = dcItteratorBindings.getEstimatedRowCount();
        }
        logger.info("Results Record Count :" + numberOfResultRecords);
        return numberOfResultRecords;
    }

    public void setSelectDisabled(boolean selectDisabled) {
        this.selectDisabled = selectDisabled;
    }

    public boolean isSelectDisabled() {
        return selectDisabled;
    }

    public void setEndDateDisable(boolean endDateDisable) {
        this.endDateDisable = endDateDisable;
    }

    public boolean isEndDateDisable() {
        return endDateDisable;
    }
}
