package oracle.retail.apps.aipdt.cnpd.publicui.bean;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.TimeUnit;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.export.ExportContext;
import oracle.adf.view.rich.export.FormatHandler;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import oracle.retail.apps.aipdt.cnpd.model.view.DtGttNonPlanningDaysVORowImpl;
import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.DateUtil;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.dt.model.view.DeploymentTypeResultVORowImpl;
import oracle.retail.apps.aipdt.dt.publicui.bean.DeploymentTypeBean;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.framework.uicomponents.AppsPanelCustomComp;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

public class CorporateNonPlanningDaysBean {
    public CorporateNonPlanningDaysBean() {
        super();
    }
    private final static ADFLogger _logger = ADFLogger.createADFLogger(CorporateNonPlanningDaysBean.class);
    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();
    private Boolean isSaveBtnDisabled = Boolean.TRUE;
    AppsPanelCustomComp appsPanelBind = null;

    private RichButton searchBtn;

    private RichPopup cancelConfirmationPopup;
    private RichPopup saveConfirmationPopup;
    private RichPopup saveSuccessPopup;
    private RichPopup saveFailedPopup;

    private RichPopup resetConfirmationPopup;
    private RichPopup saveAndCloseConfirmationPopup;

    private Boolean isDefaultSelected = Boolean.TRUE;
    private Boolean isExceptionSelected = Boolean.FALSE;

    protected static Boolean isSaveAndCloseCliked = Boolean.FALSE;

    private RichSelectBooleanRadio defaultRadioComp;
    private RichSelectBooleanRadio exceptionRadioComp;
    private RichSelectOneChoice dayTypeComp;
    private RichSelectOneChoice storeListComp;
    private RichSelectOneChoice wareHouseListComp;

    private Boolean isStoreDisabled = true;
    private Boolean isWareHouseDisabled = true;

    private String dayTypeVal = null;
    private String storeVal = null;
    private String storeListVal = null;
    private String wareHouseVal = null;
    private String wareHouseListVal = null;
    private RichTable tableBind;
    private RichPanelGroupLayout resultContainer;
    private static String saveConfirmationPopupMessage =
        AipdtUIUtil.getUIBundleValue("CORP_NP_DAYS_DEF_SAVE_CONFIRMATION_MSG");
    private RichInputDate dayBind;
    private RichInputDate dayDateHeaderComp;

    public void setDayDateHeaderComp(RichInputDate dayDateHeaderComp) {
        this.dayDateHeaderComp = dayDateHeaderComp;
    }

    public RichInputDate getDayDateHeaderComp() {
        return dayDateHeaderComp;
    }

    public void setDayBind(RichInputDate dayBind) {
        this.dayBind = dayBind;
    }

    public RichInputDate getDayBind() {
        return dayBind;
    }

    public void setResultContainer(RichPanelGroupLayout resultContainer) {
        this.resultContainer = resultContainer;
    }

    public RichPanelGroupLayout getResultContainer() {
        return resultContainer;
    }


    public void setTableBind(RichTable tableBind) {
        this.tableBind = tableBind;
    }

    public RichTable getTableBind() {
        return tableBind;
    }

    public void setSaveFailedPopup(RichPopup saveFailedPopup) {
        this.saveFailedPopup = saveFailedPopup;
    }

    public RichPopup getSaveFailedPopup() {
        return saveFailedPopup;
    }

    public void setSaveAndCloseConfirmationPopup(RichPopup saveAndCloseConfirmationPopup) {
        this.saveAndCloseConfirmationPopup = saveAndCloseConfirmationPopup;
    }

    public RichPopup getSaveAndCloseConfirmationPopup() {
        return saveAndCloseConfirmationPopup;
    }

    public void setDayTypeVal(String dayTypeVal) {
        this.dayTypeVal = dayTypeVal;
    }

    public String getDayTypeVal() {
        return dayTypeVal;
    }

    public void setStoreVal(String storeVal) {
        this.storeVal = storeVal;
    }

    public String getStoreVal() {
        return storeVal;
    }

    public void setStoreListVal(String storeListVal) {
        this.storeListVal = storeListVal;
    }

    public String getStoreListVal() {
        return storeListVal;
    }

    public void setWareHouseVal(String wareHouseVal) {
        this.wareHouseVal = wareHouseVal;
    }

    public String getWareHouseVal() {
        return wareHouseVal;
    }

    public void setWareHouseListVal(String wareHouseListVal) {
        this.wareHouseListVal = wareHouseListVal;
    }

    public String getWareHouseListVal() {
        return wareHouseListVal;
    }

    public void setIsStoreDisabled(Boolean isStoreDisabled) {
        this.isStoreDisabled = isStoreDisabled;
    }

    public Boolean getIsStoreDisabled() {
        return isStoreDisabled;
    }

    public void setIsWareHouseDisabled(Boolean isWareHouseDisabled) {
        this.isWareHouseDisabled = isWareHouseDisabled;
    }

    public Boolean getIsWareHouseDisabled() {
        return isWareHouseDisabled;
    }

    public void setDayTypeComp(RichSelectOneChoice dayTypeComp) {
        this.dayTypeComp = dayTypeComp;
    }

    public RichSelectOneChoice getDayTypeComp() {
        return dayTypeComp;
    }

    public void setStoreListComp(RichSelectOneChoice storeListComp) {
        this.storeListComp = storeListComp;
    }

    public RichSelectOneChoice getStoreListComp() {
        return storeListComp;
    }

    public void setWareHouseListComp(RichSelectOneChoice wareHouseListComp) {
        this.wareHouseListComp = wareHouseListComp;
    }

    public RichSelectOneChoice getWareHouseListComp() {
        return wareHouseListComp;
    }


    public void setMultiSelectBaseFieldsBean(MultiSelectBaseFieldsBean multiSelectBaseFieldsBean) {
        this.multiSelectBaseFieldsBean = multiSelectBaseFieldsBean;
    }

    public MultiSelectBaseFieldsBean getMultiSelectBaseFieldsBean() {
        return multiSelectBaseFieldsBean;
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

    public void setDefaultRadioComp(RichSelectBooleanRadio defaultRadioComp) {
        this.defaultRadioComp = defaultRadioComp;
    }

    public RichSelectBooleanRadio getDefaultRadioComp() {
        return defaultRadioComp;
    }

    public void setExceptionRadioComp(RichSelectBooleanRadio exceptionRadioComp) {
        this.exceptionRadioComp = exceptionRadioComp;
    }

    public RichSelectBooleanRadio getExceptionRadioComp() {
        return exceptionRadioComp;
    }


    public void setCancelConfirmationPopup(RichPopup cancelConfirmationPopup) {
        this.cancelConfirmationPopup = cancelConfirmationPopup;
    }

    public void setSaveConfirmationPopup(RichPopup saveConfirmationPopup) {
        this.saveConfirmationPopup = saveConfirmationPopup;
    }

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = saveSuccessPopup;
    }

    public void setResetConfirmationPopup(RichPopup resetConfirmationPopup) {
        this.resetConfirmationPopup = resetConfirmationPopup;
    }

    public RichPopup getCancelConfirmationPopup() {
        return cancelConfirmationPopup;
    }

    public RichPopup getSaveConfirmationPopup() {
        return saveConfirmationPopup;
    }

    public RichPopup getSaveSuccessPopup() {
        return saveSuccessPopup;
    }

    public RichPopup getResetConfirmationPopup() {
        return resetConfirmationPopup;
    }


    public void setAppsPanelBind(AppsPanelCustomComp appsPanelBind) {
        this.appsPanelBind = appsPanelBind;
    }

    public AppsPanelCustomComp getAppsPanelBind() {
        return appsPanelBind;
    }

    public void setSearchBtn(RichButton searchBtn) {
        this.searchBtn = searchBtn;
    }

    public RichButton getSearchBtn() {
        return searchBtn;
    }

    public void setIsSaveBtnDisabled(Boolean isSaveBtnDisabled) {
        this.isSaveBtnDisabled = isSaveBtnDisabled;
    }

    public Boolean getIsSaveBtnDisabled() {
        return isSaveBtnDisabled;
    }


    @SuppressWarnings("unchecked")
    public String handleSearch(ActionEvent actionEvent) {
        try {
            _logger.info("Entering in to handleSearch()");
            String locationId = null;
            Map outputMap = null;
            _logger.info("Input Values used in Search Functions : ");
            _logger.info("Store Value : " + storeVal);
            _logger.info("StoreList Value : " + storeListVal);
            _logger.info("Warehouse Value : " + wareHouseVal);
            _logger.info("WareHouseList Value : " + wareHouseListVal);
            _logger.info("IsException  : " + isExceptionSelected);
            _logger.info("Day Type  : " + dayTypeVal);

            if (storeVal != null || storeListVal != null) {
                if (storeVal != null) {
                    locationId = storeVal;
                } else {
                    locationId = getStoreValueFromDtListDetailTbl(Integer.valueOf(storeListVal));
                }
            } else if (wareHouseVal != null || wareHouseListVal != null) {
                if (wareHouseVal != null) {
                    locationId = wareHouseVal;
                } else {
                    locationId = getWarehouseValueFromDtListDetailTbl(Integer.valueOf(wareHouseListVal));
                }
            } else {
                locationId = null;
            }
            _logger.info("LocationId Value : " + locationId);

            String LocationType =
                (storeVal != null || storeListVal != null) ? Constants.STORE_LOCATION_TYPE :
                ((wareHouseVal != null || wareHouseListVal != null) ? Constants.WAREHOUSE_LOCATION_TYPE : null);
            _logger.info("Location Type Value : " + LocationType);

            OperationBinding storeOpBind = AipdtUIUtil.findOperation("handleSearch");
            if (storeOpBind != null) {
                _logger.info("Inside handleSearch method Invocation method");
                Map input = new HashMap();
                input.put(Constants.LOCATION_TYPE, LocationType);
                input.put(Constants.LOCATION_ID, locationId);
                input.put(Constants.DAY_TYPE, dayTypeVal);
                input.put(Constants.IS_EXCEPTION, isExceptionSelected ? "Y" : "N");
                storeOpBind.getParamsMap().put("inputMap", input);
                outputMap = (Map) storeOpBind.execute();
            }

            Object errorCode = outputMap.get(Constants.SEARCH_ERROR_CODE);
            Object errorMessage = outputMap.get(Constants.SEARCH_ERROR_MESSAGE);
            Object plsqlStatus = outputMap.get(Constants.SEARCH_PLSQL_RETURN_STATUS);

            if (errorMessage != null) {
                AipdtUIUtil.showErrorMessage(errorMessage.toString(), null);
                searchBtn.setDisabled(false);
                return null;
            }
            if (errorMessage == null && (Integer) plsqlStatus == 0) {
                // Search Success Operation.
                disableSearchOnSuccessfulSearch();
                searchBtn.setDisabled(true);
                isSaveBtnDisabled = false;
                AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtn);
                AdfFacesContext.getCurrentInstance().addPartialTarget(appsPanelBind);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method will be called upon successfull Search to disable all Search Elements.
     */
    private void disableSearchOnSuccessfulSearch() {
        dayTypeComp.setDisabled(true);
        defaultRadioComp.setDisabled(true);
        exceptionRadioComp.setDisabled(true);
        dayTypeComp.setDisabled(true);

        storeListComp.setDisabled(true);

        wareHouseListComp.setDisabled(true);

        isStoreDisabled = true;

        isWareHouseDisabled = true;

        AdfFacesContext.getCurrentInstance().addPartialTarget(dayTypeComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(defaultRadioComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionRadioComp);

    }

    public String handleReset() {
        ADFFacesUtil.showPopup(resetConfirmationPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    public String handleSave() {
        if (isDirty()) {
            if (!isAnyValidation()) {
                if (isRowsSelectedForDelete()) {
                    saveConfirmationPopupMessage =
                        AipdtUIUtil.getUIBundleValue("CORP_NP_DAYS_DELETE_SAVE_CONFIRMATION_MSG");
                } else {
                    saveConfirmationPopupMessage =
                        AipdtUIUtil.getUIBundleValue("CORP_NP_DAYS_DEF_SAVE_CONFIRMATION_MSG");
                }
                ADFFacesUtil.showPopup(saveConfirmationPopup.getClientId(FacesContext.getCurrentInstance()));
            }
        } else {
            AipdtUIUtil.showErrorMessage("No changes available to Save", null);
        }
        return null;
    }

    public String handleCancel() {
        ADFFacesUtil.showPopup(cancelConfirmationPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    public String handleSaveAndClose() {
        if (isDirty()) {
            if (!isAnyValidation()) {
                if (isRowsSelectedForDelete()) {
                    saveConfirmationPopupMessage =
                        AipdtUIUtil.getUIBundleValue("CORP_NP_DAYS_DELETE_SAVE_AND_CLOSE_CONFIRMATION_MSG");
                } else {
                    saveConfirmationPopupMessage =
                        AipdtUIUtil.getUIBundleValue("CORP_NP_DAYS_SAVE_AND_CLOSE_CONFIRMATION_MSG");
                }
                ADFFacesUtil.showPopup(saveAndCloseConfirmationPopup.getClientId(FacesContext.getCurrentInstance()));
            }
        } else {
            AipdtUIUtil.showErrorMessage("No changes available to Save", null);
        }
        return null;
    }

    public Boolean isDirty() {
        Boolean isDirty = false;
        OperationBinding OpBind = AipdtUIUtil.findOperation("isTransactionDirty");
        if (OpBind != null) {
            isDirty = (Boolean) OpBind.execute();
        }
        return isDirty;
    }


    public String initActivity() {
        OperationBinding OpBind = AipdtUIUtil.findOperation("initActivity");
        if (OpBind != null) {
            OpBind.execute();
        }
        return null;
    }


    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleResetYesListener(ActionEvent actionEvent) {
        try {
            resetConfirmationPopup.hide();
            resetScreen();
            AdfFacesContext.getCurrentInstance().addPartialTarget(appsPanelBind);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This method invokes both reset method of Search section and Result section.
     */
    private void resetScreen() {
        try {
            resetSearchFields();
            tableBind.resetStampState();
            AipdtUIUtil.clearTableFilter(tableBind);
            dayDateHeaderComp.resetValue();     
            AdfFacesContext.getCurrentInstance().addPartialTarget(dayDateHeaderComp);
            OperationBinding storeOpBind = AipdtUIUtil.findOperation("handleReset");
            if (storeOpBind != null) {
                storeOpBind.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method resets screen elements upon click of Reset and successfull Save.
     */
    private void resetSearchFields() {
        isExceptionSelected = false;
        isDefaultSelected = true;
        defaultRadioComp.resetValue();
        exceptionRadioComp.resetValue();
        defaultRadioComp.setDisabled(false);
        exceptionRadioComp.setDisabled(false);

        resetDayTypeComponent();
        dayTypeComp.setDisabled(false);

        resetDestinationFields();
        disableDestinationFields(true);
        filterDayType();

        isSaveBtnDisabled = true;

        AdfFacesContext.getCurrentInstance().addPartialTarget(dayTypeComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(defaultRadioComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionRadioComp);
        enableSearchButton();
        AdfFacesContext.getCurrentInstance().addPartialTarget(appsPanelBind);
    }

    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleResetNoListener(ActionEvent actionEvent) {
        try {
            resetConfirmationPopup.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleCancelYesListener(ActionEvent actionEvent) {
        try {
            cancelConfirmationPopup.hide();
            resetScreen();
            AipdtUIUtil.invokeAction(Constants.CANCEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleCancelNoListener(ActionEvent actionEvent) {
        try {
            cancelConfirmationPopup.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleSaveYesListener(ActionEvent actionEvent) {
        try {
            saveConfirmationPopup.hide();
            isSaveAndCloseCliked = Boolean.FALSE;
            updateStatusForNewRows();
            processSave();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleSaveNoListener(ActionEvent actionEvent) {
        try {
            saveConfirmationPopup.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleSaveAndCloseYesListener(ActionEvent actionEvent) {
        try {
            isSaveAndCloseCliked = true;
            saveAndCloseConfirmationPopup.hide();
            updateStatusForNewRows();
            processSave();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will check whether any rows has been marked for Delete or not on Result Table.
     * @return
     */
    private Boolean isRowsSelectedForDelete() {
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("DtGttNonPlanningDaysVOIterator");
        Row[] rows = dcItteratorBindings.getViewObject().getFilteredRows("UpdateInd", "1");
        if (rows != null && rows.length > 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method will update 'UpdateInd' attribute value to '1' for the modified records to indicate DB to process for Save.
     */

    private void updateStatusForNewRows() {
        try {
            DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("DtGttNonPlanningDaysVOIterator");
            Row[] rows = dcItteratorBindings.getViewObject().getFilteredRows("Status", "N");
            if (rows != null && rows.length > 0) {
                for (int i = 0; i < rows.length; i++) {
                    Row row = rows[i];
                    if (row.getAttribute("Day") != null && !row.getAttribute("Day").toString().isEmpty()) {
                        row.setAttribute("UpdateInd", "1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleSaveAndCloseNoListener(ActionEvent actionEvent) {
        try {
            saveAndCloseConfirmationPopup.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void resetDayTypeComponent() {
        dayTypeVal = null;
        BindingContainer binding = getBindings();
        JUCtrlListBinding attrBind = (JUCtrlListBinding) binding.get("DayType");
        attrBind.setSelectedIndex(-1);
        attrBind.clearSelectedIndices();
        dayTypeComp.resetValue();
    }

    private void resetStoreListComponent() {
        storeListVal = null;
        BindingContainer binding = getBindings();
        JUCtrlListBinding attrBind = (JUCtrlListBinding) binding.get("StoreList");
        attrBind.setSelectedIndex(-1);
        attrBind.clearSelectedIndices();
        storeListComp.resetValue();
    }

    private void resetWareHouseListComponent() {
        wareHouseListVal = null;
        BindingContainer binding = getBindings();
        JUCtrlListBinding attrBind = (JUCtrlListBinding) binding.get("WarehouseList");
        attrBind.setSelectedIndex(-1);
        attrBind.clearSelectedIndices();
        wareHouseListComp.resetValue();
    }


    private BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    @SuppressWarnings("unchecked")
    public void filterDayType() {
        String type = null;
        if (isDefaultSelected && !isExceptionSelected) {
            type = Constants.DEFAULT_LOOKUP_TYPE;
        } else {
            type = Constants.EXCEPTION_LOOKUP_TYPE;
        }

        OperationBinding OpBind = AipdtUIUtil.findOperation("filterDayTypeDropdown");
        if (OpBind != null) {
            OpBind.getParamsMap().put("lookupType", type);
            OpBind.execute();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(dayTypeComp);
    }

    private void resetDestinationFields() {
        resetStoreListComponent();
        resetWareHouseListComponent();
        storeVal = null;
        wareHouseVal = null;
        multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
        multiSelectBaseFieldsBean.getWareHouseComp().resetDeclarativeComponent();
    }


    private void disableDestinationFields(Boolean isDisable) {
        disableWareHouseElements(isDisable);
        disableStoreElements(isDisable);
    }


    private void disableWareHouseElements(Boolean isDisable) {
        if (isDisable) {
            wareHouseVal = null;
            wareHouseListVal = null;
            resetWareHouseListComponent();
            multiSelectBaseFieldsBean.getWareHouseComp().resetDeclarativeComponent();
        }
        wareHouseListComp.setDisabled(isDisable);
        isWareHouseDisabled = isDisable;
        AdfFacesContext.getCurrentInstance().addPartialTarget(wareHouseListComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getWareHouseComp());
    }

    private void disableStoreElements(Boolean isDisable) {
        if (isDisable) {
            storeVal = null;
            storeListVal = null;
            resetStoreListComponent();
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
        }
        storeListComp.setDisabled(isDisable);
        isStoreDisabled = isDisable;
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
    }


    public void onDefaultVCE(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        isDefaultSelected = (Boolean) valueChangeEvent.getNewValue();
        setIsExceptionSelected(!isDefaultSelected);
        enableSearchButton();
    }

    public void onExceptionVCE(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        isExceptionSelected = (Boolean) valueChangeEvent.getNewValue();
        setIsDefaultSelected(!isExceptionSelected);
        resetDayTypeComponent();
        disableDestinationFields(true);
        filterDayType();
        AdfFacesContext.getCurrentInstance().addPartialTarget(dayTypeComp);
        enableSearchButton();
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onDayTypeVCE(ValueChangeEvent valueChangeEvent) {
        dayTypeVal = null;
        AipdtUIUtil.setValueToEL("#{bindings.DayType.inputValue}", valueChangeEvent.getNewValue());
        Object newValue = AipdtUIUtil.resolveExpression("#{bindings.DayType.attributeValue}");
        if (newValue != null && !newValue.toString().isEmpty()) {
            dayTypeVal = String.valueOf(newValue);
            if (isExceptionSelected) {
                if (Constants.NON_DELIVERY_DAY_TYPE.equalsIgnoreCase(dayTypeVal)) {
                    disableWareHouseElements(false);
                    disableStoreElements(true);
                } else if (Constants.NON_RECEIPT_DAY_TYPE.equalsIgnoreCase(dayTypeVal)) {
                    disableWareHouseElements(true);
                    disableStoreElements(false);
                } else {

                }
            }
        } else {
            resetDestinationFields();
            disableDestinationFields(true);
        }
        enableSearchButton();
    }


    /**
     *
     * @param valueChangeEvent
     */

    public void onWarehouseVCE(ValueChangeEvent valueChangeEvent) {
        wareHouseVal = null;
        Object newValue = valueChangeEvent.getNewValue();
        if (newValue != null && !newValue.toString().isEmpty()) {
            wareHouseVal = String.valueOf(newValue);
            wareHouseListComp.setDisabled(true);
        } else {
            wareHouseListComp.setDisabled(false);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(wareHouseListComp);
        enableSearchButton();
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onWarehouseListVCE(ValueChangeEvent valueChangeEvent) {
        wareHouseListVal = null;
        AipdtUIUtil.setValueToEL("#{bindings.WarehouseList.inputValue}", valueChangeEvent.getNewValue());
        Object newValue = AipdtUIUtil.resolveExpression("#{bindings.WarehouseList.attributeValue}");
        if (newValue != null && !newValue.toString().isEmpty()) {
            wareHouseListVal = String.valueOf(newValue);
            isWareHouseDisabled = true;
        } else {
            isWareHouseDisabled = false;

        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getWareHouseComp());
        enableSearchButton();
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onStoreVCE(ValueChangeEvent valueChangeEvent) {
        storeVal = null;
        Object newValue = valueChangeEvent.getNewValue();
        if (newValue != null && !newValue.toString().isEmpty()) {
            storeVal = String.valueOf(newValue);
            storeListComp.setDisabled(true);
        } else {
            storeListComp.setDisabled(false);
            resetStoreListComponent();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        enableSearchButton();
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onStoreListVCE(ValueChangeEvent valueChangeEvent) {
        storeListVal = null;
        AipdtUIUtil.setValueToEL("#{bindings.StoreList.inputValue}", valueChangeEvent.getNewValue());
        Object newValue = AipdtUIUtil.resolveExpression("#{bindings.StoreList.attributeValue}");
        if (newValue != null && !newValue.toString().isEmpty()) {
            storeListVal = String.valueOf(newValue);
            isStoreDisabled = true;
        } else {

            isStoreDisabled = false;
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        enableSearchButton();
    }


    /**
     * This method enable/disables search button based on the values given in the search criteria.
     */
    private void enableSearchButton() {
        if (isDefaultSelected) {
            if (dayTypeVal != null) {
                searchBtn.setDisabled(false);
            } else {
                searchBtn.setDisabled(true);
            }
        } else if (isExceptionSelected) {
            if (storeVal != null || storeListVal != null) {
                searchBtn.setDisabled(false);
            } else if (wareHouseVal != null || wareHouseListVal != null) {
                searchBtn.setDisabled(false);
            } else {
                searchBtn.setDisabled(true);
            }
        } else {
            searchBtn.setDisabled(true);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtn);
    }

    /**
     * This method fetches Sku from DT_LIST_DETAIL table based on provided ItemList value.
     * @param itemList
     * @return
     */
    private String getStoreValueFromDtListDetailTbl(Integer StoreList) {
        String itemVal = null;
        OperationBinding OpBind = AipdtUIUtil.findOperation("getIdsFromDtListDetailTable");
        if (OpBind != null) {
            OpBind.getParamsMap().put("itemList", StoreList);
            OpBind.getParamsMap().put("TYPE", "STORE_LIST");
            itemVal = String.valueOf(OpBind.execute());
        }
        return itemVal;
    }

    /**
     * This method fetches Sku from DT_LIST_DETAIL table based on provided ItemList value.
     * @param itemList
     * @return
     */
    private String getWarehouseValueFromDtListDetailTbl(Integer itemList) {
        String itemVal = null;
        OperationBinding OpBind = AipdtUIUtil.findOperation("getIdsFromDtListDetailTable");
        if (OpBind != null) {
            OpBind.getParamsMap().put("itemList", itemList);
            OpBind.getParamsMap().put("TYPE", "WAREHOUSE_LIST");
            itemVal = String.valueOf(OpBind.execute());
        }
        return itemVal;
    }


    /**
     * Construts network path export file name
     * @return
     *      Export file name
     */
    public String getExportFileName() {
        return AipdtUIUtil.getExportFileName(Constants.CNPD_EXPORT_FILE_NAME);
    }

    /**
     * Invoked when export selected rows command link is clicked.
     * @param uIComponent
     * @param exportContext
     * @param formatHandler
     * @return
     */
    public Boolean exportSelectedRows(UIComponent uIComponent, ExportContext exportContext,
                                      FormatHandler formatHandler) {
        _logger.info("****** Inside exportSelectedRows method ******");
        //AipdtUIUtil.selectAllRowsInTable(getResultTable(), DEPLOYMENT_TYPE_RESULT_VO_ITERATOR, "UpdateInd"); //TODO
        return Boolean.TRUE;
    }

    private void processSave() {
        Map outMap = null;
        try {
            OperationBinding storeOpBind = AipdtUIUtil.findOperation("handleSave");
            if (storeOpBind != null) {
                outMap = (Map) storeOpBind.execute();
                if (outMap != null && outMap.size() > 2) {
                    Object errorMsg = outMap.get(Constants.SEARCH_ERROR_MESSAGE);
                    Integer status = (Integer) outMap.get(Constants.SEARCH_PLSQL_RETURN_STATUS);
                    if (status != null && status == 0) {
                        ADFFacesUtil.showPopup(saveSuccessPopup.getClientId(FacesContext.getCurrentInstance()));
                    } else if (status == 1 && errorMsg != null) {
                        AipdtUIUtil.showErrorMessage(errorMsg.toString(), null);
                    } else {
                        ADFFacesUtil.showPopup(saveFailedPopup.getClientId(FacesContext.getCurrentInstance()));
                    }
                }
            }
        } catch (Exception e) {
            ADFFacesUtil.showPopup(saveFailedPopup.getClientId(FacesContext.getCurrentInstance()));
            e.printStackTrace();
        }
    }

    /**
     * This method will be invoked on click of ok on save Fail popup.
     * @param actionEvent
     */
    public void handleSaveFailedOkEvent(ActionEvent actionEvent) {
        saveFailedPopup.hide();
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("DtGttNonPlanningDaysVOIterator");
        Row[] rows = dcItteratorBindings.getViewObject().getFilteredRows("Status", "N");
        if (rows != null && rows.length > 0) {
            for (int i = 0; i < rows.length; i++) {
                Row row = rows[i];
                if (row.getAttribute("Day") != null && !row.getAttribute("Day").toString().isEmpty()) {
                    row.setAttribute("UpdateInd", "0");
                }
            }
        }
    }

    /**
     * This method will be invoked on click of ok on save Successfull popup. this method clears screen data and resets.
     * @param actionEvent
     */
    public void okSavePopupListener(ActionEvent actionEvent) {
        saveSuccessPopup.hide();
        resetSearchFields();
        tableBind.resetStampState();
        AipdtUIUtil.clearTableFilter(tableBind);

        OperationBinding storeOpBind = AipdtUIUtil.findOperation("handleReset");
        if (storeOpBind != null) {
            storeOpBind.execute();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(appsPanelBind);
        if (isSaveAndCloseCliked) {
            ADFFacesUtil.showPopup(cancelConfirmationPopup.getClientId(FacesContext.getCurrentInstance()));
        }
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onRowLevelCheckBoxVCE(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        _logger.info("new Value --> ", valueChangeEvent.getNewValue());
        Object currentRow = getSelectedRow(tableBind);
        if (currentRow != null) {
            DtGttNonPlanningDaysVORowImpl rowImpl = (DtGttNonPlanningDaysVORowImpl) currentRow;
            if ((Boolean) valueChangeEvent.getNewValue()) {
                rowImpl.setStatus("D");
            } else {
                rowImpl.setStatus("E");
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(tableBind);
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
     * This method adds new Row on to Results Table. This event will be enabled only for Default Setup Type schenario.
     * @param actionEvent
     */

    public void handleAddNewRowEvent(ActionEvent actionEvent) {
        OperationBinding storeOpBind = AipdtUIUtil.findOperation("addRowOnResultVO");
        if (storeOpBind != null) {
            storeOpBind.execute();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(tableBind);

    }


    /**
     * This method Deletes Row from Result Table. This event will be enabled only for Default Setup Type schenario.
     * @param actionEvent
     */

    public void handleDeleteRowEvent(ActionEvent actionEvent) {
        OperationBinding storeOpBind = AipdtUIUtil.findOperation("deleteRowsFromResultVO");
        if (storeOpBind != null) {
            storeOpBind.execute();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(tableBind);

    }

    /**
     * Below method will returns SaveConfirmation popup content.
     * @return
     */
    public String getSaveConfirmationPopUpMessage() {
        return saveConfirmationPopupMessage;
    }

    public void onDayDateVCE(ValueChangeEvent valueChangeEvent) {
        try {
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            String errorMsg = null;
            if (valueChangeEvent.getNewValue() != null) {
                java.sql.Date date = (java.sql.Date) valueChangeEvent.getNewValue();
                DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("DtGttNonPlanningDaysVOIterator");

                if (isExceptionSelected) {

                } else {
                    Row[] rows = dcItteratorBindings.getViewObject().getFilteredRows("Day", date);
                    if (rows != null && rows.length > 0) {
                        //errorMsg = date + " record already exists. Please change date.";


                    }
                }
            }
            if (errorMsg != null) {
                FacesContext.getCurrentInstance().addMessage(valueChangeEvent.getComponent().getClientId(),
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                                              errorMsg));

                //FacesContext.getCurrentInstance().renderResponse();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    public void onDayDateValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        try {
            if (object != null) {
                java.util.Date newDate = (java.util.Date) object;
                java.util.Date vDate = getVDate();
                java.util.Date sysHighDate = getSysHighDate();

                if (newDate.compareTo(vDate) < 0) {
                    facesContext.addMessage(uIComponent.getClientId(),
                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                             "Date cannot be less than " +
                                                             AipdtUIUtil.getDateFormatted(vDate)));
                    facesContext.renderResponse();
                } else if (newDate.compareTo(sysHighDate) > 0) {
                    facesContext.addMessage(uIComponent.getClientId(),
                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                             "Date cannot be greater than " +
                                                             AipdtUIUtil.getDateFormatted(sysHighDate)));
                    facesContext.renderResponse();
                } else {
                    if (!isExceptionSelected) {
                        DCIteratorBinding dcItteratorBindings =
                            AipdtUIUtil.findIterator("DtGttNonPlanningDaysVOIterator");
                        Row[] rows =
                            dcItteratorBindings.getViewObject().getFilteredRows("Day", (java.sql.Date) (object));
                        if (rows != null && rows.length > 0) {
                            //                        facesContext.addMessage(uIComponent.getClientId(),
                            //                                                new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                            //                                                                 "Please provide unique value."));
                            //facesContext.getCurrentInstance().renderResponse();
















                        } //FacesContext.getCurrentInstance().addMessage(arg0, arg1);
                    } else {

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*private Boolean isOverLapOnDateExist(DeploymentTypeResultVORowImpl masterRow, Date inputDate, String type) {
        Boolean isException = false;
        BigDecimal skuId = masterRow.getCommodityId();
        BigDecimal supplierId = masterRow.getSupplierId();
        BigDecimal storeId = masterRow.getStoreId();
        DCIteratorBinding resultIter = AipdtUIUtil.findIterator("DEPLOYMENT_TYPE_RESULT_VO_ITERATOR");
        RowIterator rowSet1 = resultIter.getViewObject().findByAltKey("LOCATION_DAY_KEY", new Key(new Object[] {
                                                                                                                           skuId,
                                                                                                                           supplierId,
                                                                                                                           storeId
            }), -1, true);
        // Below condition makes sure that if only one row found than it will skip as Current row match will lead to count 1.
        if (rowSet1.getRowCount() > 1) {
            while (rowSet1.hasNext()) {
                //DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) rowSet1.next();
                if (type.equalsIgnoreCase(Constants.STAxRT_DATE)) {
                    if (currentRow.getStartDate().compareTo(inputDate) == 0) {
                        isException = true;
                        break;
                    }
                } else {
                    if (currentRow.getEndDate().compareTo(inputDate) == 0) {
                        isException = true;
                        break;
                    }
                }
            }
        }
        return isException;
    }
*/


    private Boolean isAnyValidation() {
        Boolean isError = false;
        String errorMessage = null;
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("DtGttNonPlanningDaysVOIterator");
        Row[] childRowArray = dcItteratorBindings.getViewObject().getFilteredRows("Status", "N");

        RowSetIterator rowIter = dcItteratorBindings.getViewObject().createRowSetIterator(null);

        if (isExceptionSelected) {
            for (int i = 0; i < childRowArray.length; i++) {
                Row childRow = childRowArray[i];
                Object date = childRow.getAttribute("Day");
                String locCode = (String) childRow.getAttribute("LocationCode");
                // Skipping validation check for those unmodified new record.
                if (date != null) {
                    Row[] locRowArray = dcItteratorBindings.getViewObject().getFilteredRows("LocationCode", locCode);
                    for (int locCount = 0; locCount < locRowArray.length; locCount++) {
                        Row locRow = locRowArray[locCount];
                        Object locDate = locRow.getAttribute("Day");
                        if (locDate != null) {
                            if ((childRow.getKey().hashCode() != locRow.getKey().hashCode()) &&
                                ((Date) locDate).compareTo((Date) date) == 0) {
                                errorMessage =
                                    "For the Location " + locCode + " already Exception has been set with Date" +
                                    AipdtUIUtil.getDateFormatted((Date) date) + ". Please provide different date.";
                                break;
                            }
                        }

                    } // Second for loop end.
                    if (errorMessage != null) {
                        break;
                    }
                }
            } // First for loop end.

            // Checking for Save value validation on New rows.
            if (errorMessage == null) {
                Row[] uniqueDateRows = dcItteratorBindings.getViewObject().getFilteredRows("Status", "N");
                Date firstDate = null;
                for (int count = 0; count < uniqueDateRows.length; count++) {
                    Row currentRow = uniqueDateRows[count];
                    Object dateVal = currentRow.getAttribute("Day");
                    // Below check to skip validation check for the first Row as no Date available for comparision.
                    if (dateVal != null) {
                        if (firstDate != null) {
                            if (firstDate.compareTo((Date) dateVal) == 0) {
                                // Valid schenario where in Same date has been entered.




















                            } else {
                                errorMessage =
                                    "Exception cannot be Set with Different Date. Please provide same Date. Otherwise redefine Search.";
                            }
                        }
                        firstDate = (Date) dateVal;
                    }
                    if (errorMessage != null) {
                        break;
                    }
                }
            }

        } else {
            for (int i = 0; i < childRowArray.length; i++) {
                Row childRow = childRowArray[i];
                Object date = childRow.getAttribute("Day");
                if (date != null) {
                    Row[] parentRowArray = rowIter.getFilteredRows("Day", date);
                    for (int j = 0; j < parentRowArray.length; j++) {
                        Row parentRow = parentRowArray[j];
                        if (parentRow.getKey().hashCode() != childRow.getKey().hashCode()) {
                            errorMessage =
                                "Already Row exists with Date " + AipdtUIUtil.getDateFormatted((Date) date) +
                                ". Please provide unique Date value.";
                        }
                    }
                }
            }

        }
        if (errorMessage != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                                          errorMessage));
            isError = true;
        }
        return isError;
    }


    /**
     * This method sets Date value to all rows which are all as Status as 'N' in Exception schenario.
     * @param actionEvent
     */
    @SuppressWarnings("unchecked")
    public void handleDayDateSetAll(ActionEvent actionEvent) {
        if (dayDateHeaderComp != null && dayDateHeaderComp.getValue() != null) {
            OperationBinding storeOpBind = AipdtUIUtil.findOperation("setAll");
            if (storeOpBind != null) {
                storeOpBind.getParamsMap().put("date", (Date) dayDateHeaderComp.getValue());
                storeOpBind.execute();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(dayDateHeaderComp.getClientId(),
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                                          "Please Enter Date to apply SetAll"));
        }
    }


    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    public void onHeaderDateValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        try {
            if (object != null) {
                java.util.Date newDate = (java.util.Date) object;
                java.util.Date vDate = getVDate();
                java.util.Date sysHighDate = getSysHighDate();

                if (newDate.compareTo(vDate) < 0) {
                    facesContext.addMessage(uIComponent.getClientId(),
                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                             "Date cannot be less than " +
                                                             AipdtUIUtil.getDateFormatted(vDate)));
                    facesContext.renderResponse();
                } else if (newDate.compareTo(sysHighDate) > 0) {
                    facesContext.addMessage(uIComponent.getClientId(),
                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                             "Date cannot be greater than " +
                                                             AipdtUIUtil.getDateFormatted(sysHighDate)));
                    facesContext.renderResponse();
                } else {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getVDate() {
        return DateUtil.getVDatePlusOne().getValue();
    }

    public Date getSysHighDate() {
        return new Date(DateUtil.getSystemHighDate().getValue().getTime());
    }
}
