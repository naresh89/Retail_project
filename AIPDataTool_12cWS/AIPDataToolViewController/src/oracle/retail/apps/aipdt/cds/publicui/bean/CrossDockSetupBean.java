package oracle.retail.apps.aipdt.cds.publicui.bean;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.export.ExportContext;
import oracle.adf.view.rich.export.FormatHandler;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupResultVORowImpl;
import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupTimeSetAllVORowImpl;
import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.DateUtil;
import oracle.retail.apps.aipdt.common.model.util.PlsqlCallReturn;
import oracle.retail.apps.aipdt.common.publicui.bean.BaseRetailBean;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.common.view.util.StringUtility;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.SearchFieldsBean;
import oracle.retail.apps.framework.uicomponents.AppsPanelComponent;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

public class CrossDockSetupBean extends BaseRetailBean {

    @SuppressWarnings("compatibility:-5467707214534958703")
    private static final long serialVersionUID = -7836483198135603805L;
    private static ADFLogger logger = ADFLogger.createADFLogger(CrossDockSetupBean.class);
    private static final String RESULT_VO_ITERATOR = "CrossDockSetupResultVOIterator";
    private static final String ITEM_POPUP_VO_ITERATOR = "CrossDockSetupItemHierPopupVOIterator";
    private static final String STORE_POPUP_VO_ITERATOR = "CrossDockSetupStorePopupVOIterator";
    private static final String TIME_SET_ALL_POPUP_VO_ITERATOR = "CrossDockSetupTimeSetAllVO1Iterator";
    private static final String CDS_REPORT_POPUP_VO_ITERATOR = "CrossDockSetupReportVOIterator";
    private static final String CDS_ROW_DOW_VO_ITERATOR = "CrossDockSetupDOWVOIterator";


    private final static ADFLogger _logger = ADFLogger.createADFLogger(CrossDockSetupBean.class);
    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();
    private SearchFieldsBean searchFieldsBean = new SearchFieldsBean();
    private RichPopup resetPopup;
    private RichPopup cancelPopup;
    private RichPopup saveSuccessPopup;
    private RichPopup saveFailedPopup;
    private RichPopup itemHierarchyPopup;
    private RichPopup storePopup;
    private RichPanelGroupLayout resultsContainer;
    private RichTable resultTable;
    private Date vDate = DateUtil.getVDatePlusOne().getValue();
    private Date sysHighDate = DateUtil.getSystemHighDatePlusOne();
    private RichSelectOneChoice deptComp;
    private boolean isSaveAndCloseCliked = false;
    private RichSelectBooleanCheckbox selectAllComp;
    private RichInputDate startDateHeaderComp;
    private RichInputDate endDateHeaderComp;
    private RichPopup dowSetAllPopup;
    private AppsPanelComponent appsPanel;
    private RichInputDate startDateRowComp;
    private RichInputDate endDateRowComp;
    private RichPopup saveConfirmationPopup;
    private RichPopup saveCloseConfirmationPopup;
    private RichPopup cdsHistReportPopup;

    private String selDept;
    private String selSupplier;
    private String selStore;
    private String selRegion;
    private RichPopup rowDOWPopup;

    public CrossDockSetupBean() {
        super();
    }

    public void setMultiSelectBaseFieldsBean(MultiSelectBaseFieldsBean multiSelectBaseFieldsBean) {
        this.multiSelectBaseFieldsBean = multiSelectBaseFieldsBean;
    }

    public MultiSelectBaseFieldsBean getMultiSelectBaseFieldsBean() {
        return multiSelectBaseFieldsBean;
    }

    public void setSearchFieldsBean(SearchFieldsBean searchFieldsBean) {
        this.searchFieldsBean = searchFieldsBean;
    }

    public SearchFieldsBean getSearchFieldsBean() {
        return searchFieldsBean;
    }

    public void setResetPopup(RichPopup resetPopup) {
        this.resetPopup = resetPopup;
    }

    public RichPopup getResetPopup() {
        return resetPopup;
    }

    public void setCancelPopup(RichPopup cancelPopup) {
        this.cancelPopup = cancelPopup;
    }

    public RichPopup getCancelPopup() {
        return cancelPopup;
    }

    public void setResultsContainer(RichPanelGroupLayout resultsContainer) {
        this.resultsContainer = resultsContainer;
    }

    public RichPanelGroupLayout getResultsContainer() {
        return resultsContainer;
    }

    public void setResultTable(RichTable resultTable) {
        this.resultTable = resultTable;
    }

    public RichTable getResultTable() {
        return resultTable;
    }

    public void setVDate(Date vDate) {
        this.vDate = vDate;
    }

    public Date getVDate() {
        return vDate;
    }

    public void setSysHighDate(Date sysHighDate) {
        this.sysHighDate = sysHighDate;
    }

    public Date getSysHighDate() {
        return sysHighDate;
    }

    public void setSelectAllComp(RichSelectBooleanCheckbox selectAllComp) {
        this.selectAllComp = selectAllComp;
    }

    public RichSelectBooleanCheckbox getSelectAllComp() {
        return selectAllComp;
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

    public void setDeptComp(RichSelectOneChoice deptComp) {
        this.deptComp = deptComp;
    }

    public RichSelectOneChoice getDeptComp() {
        return deptComp;
    }

    public void setEndDateHeaderComp(RichInputDate endDateHeaderComp) {
        this.endDateHeaderComp = endDateHeaderComp;
    }

    public RichInputDate getEndDateHeaderComp() {
        return endDateHeaderComp;
    }

    public void setStartDateRowComp(RichInputDate startDateRowComp) {
        this.startDateRowComp = startDateRowComp;
    }

    public RichInputDate getStartDateRowComp() {
        return startDateRowComp;
    }

    public void setEndDateRowComp(RichInputDate endDateRowComp) {
        this.endDateRowComp = endDateRowComp;
    }

    public RichInputDate getEndDateRowComp() {
        return endDateRowComp;
    }

    public void setStartDateHeaderComp(RichInputDate startDateHeaderComp) {
        this.startDateHeaderComp = startDateHeaderComp;
    }

    public RichInputDate getStartDateHeaderComp() {
        return startDateHeaderComp;
    }

    public void setSaveFailedPopup(RichPopup saveFailedPopup) {
        this.saveFailedPopup = saveFailedPopup;
    }

    public RichPopup getSaveFailedPopup() {
        return saveFailedPopup;
    }

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = saveSuccessPopup;
    }

    public RichPopup getSaveSuccessPopup() {
        return saveSuccessPopup;
    }

    public void setDowSetAllPopup(RichPopup dowSetAllPopup) {
        this.dowSetAllPopup = dowSetAllPopup;
    }

    public RichPopup getDowSetAllPopup() {
        return dowSetAllPopup;
    }

    public void setSaveCloseConfirmationPopup(RichPopup saveCloseConfirmationPopup) {
        this.saveCloseConfirmationPopup = saveCloseConfirmationPopup;
    }

    public RichPopup getSaveCloseConfirmationPopup() {
        return saveCloseConfirmationPopup;
    }

    public void setCdsHistReportPopup(RichPopup cdsHistReportPopup) {
        this.cdsHistReportPopup = cdsHistReportPopup;
    }

    public RichPopup getCdsHistReportPopup() {
        return cdsHistReportPopup;
    }


    public void setSelDept(String selDept) {
        this.selDept = selDept;
    }

    public String getSelDept() {
        return selDept;
    }

    public void setSelSupplier(String selSupplier) {
        this.selSupplier = selSupplier;
    }

    public String getSelSupplier() {
        return selSupplier;
    }

    public void setSelStore(String selStore) {
        this.selStore = selStore;
    }

    public String getSelStore() {
        return selStore;
    }

    public void setSelRegion(String selRegion) {
        this.selRegion = selRegion;
    }

    public String getSelRegion() {
        return selRegion;
    }

    public void setAppsPanel(AppsPanelComponent appsPanel) {
        this.appsPanel = appsPanel;
    }

    public AppsPanelComponent getAppsPanel() {
        return appsPanel;
    }

    public void setSaveConfirmationPopup(RichPopup saveConfirmationPopup) {
        this.saveConfirmationPopup = saveConfirmationPopup;
    }

    public RichPopup getSaveConfirmationPopup() {
        return saveConfirmationPopup;
    }

    /**
     * Invoked on Department change
     * @param valueChangeEvent
     */
    public void onDepartmentChange(ValueChangeEvent valueChangeEvent) {
        boolean prodHierarchy = true;
        boolean itemList = true;
        boolean ordFromSupply = false;
        boolean destination = false;
        deptComp.processUpdates(FacesContext.getCurrentInstance());
        searchFieldsBean.onDepartmentChange(multiSelectBaseFieldsBean, valueChangeEvent, prodHierarchy, itemList,
                                            ordFromSupply, destination);
    }

    /**
     * Invoked on Supplier change
     */
    public void onSupplierChange() {
        searchFieldsBean.onSupplierChange(multiSelectBaseFieldsBean);
    }

    public void onClassChange(ValueChangeEvent valueChangeEvent) {
        // Not implemented, CDS exception created at Department level only
    }

    public void onSubclassChange(ValueChangeEvent valueChangeEvent) {
        // Not implemented, CDS exception created at Department level only
    }

    public void onStoreListChange(ValueChangeEvent valueChangeEvent) {
        searchFieldsBean.onStoreListChange(multiSelectBaseFieldsBean, valueChangeEvent);
    }

    public void onStoreChange(ValueChangeEvent valueChangeEvent) {
        searchFieldsBean.onStoreChange(valueChangeEvent);
    }

    public void onRegionChange(ValueChangeEvent valueChangeEvent) {
        searchFieldsBean.onRegionChange(multiSelectBaseFieldsBean, valueChangeEvent);
    }

    /**
     * Invoked on Search button. Validate user search criteria and call AM method
     * @param actionEvent
     */
    public void handleSearch(ActionEvent actionEvent) {
        String storeIdsFromStoreList = null;
        String storeSelType = null;
        PlsqlCallReturn callReturn = new PlsqlCallReturn();

        if (searchFieldsBean.getRegionId() != null) {
            if (!multiSelectBaseFieldsBean.isAllStoreSelected() && searchFieldsBean.getStoreIds() != null) {
                storeIdsFromStoreList = searchFieldsBean.getStoreIds();
                searchFieldsBean.setRegionId(null);
            } else {
                storeSelType = Constants.REGION_SELECTION_TYPE;
            }
        } else if (searchFieldsBean.getStoreIds() != null) {
            if (multiSelectBaseFieldsBean.isAllStoreSelected()) {
                storeSelType = Constants.ALL_STORE_SELECTION_TYPE;
            } else {
                storeIdsFromStoreList = searchFieldsBean.getStoreIds();
            }
        } else if (searchFieldsBean.getStoreListId() != null) {
            storeIdsFromStoreList = getStoresFromStoreList();
            searchFieldsBean.setStoreIdsFromStoreList(storeIdsFromStoreList);
        }

        OperationBinding opBind = AipdtUIUtil.findOperation("handleSearch");
        if (opBind != null) {
            Map input = searchFieldsBean.getSearchInputs();

            input.put(Constants.DEPT, searchFieldsBean.getDeptIds());
            input.put(Constants.SUPPLIER, searchFieldsBean.getOrdFromSupplierIds());
            input.put(Constants.SUPPLIER_SELECTION_TYPE, searchFieldsBean.getOrdFromSupplierIds());
            input.put(Constants.REGION, searchFieldsBean.getRegionId());
            input.put(Constants.STORE, storeIdsFromStoreList);
            input.put(Constants.STORE_SELECTION_TYPE, storeSelType);

            callReturn = (PlsqlCallReturn) opBind.execute();
        }

        if (callReturn.getExecutionStatus() == 1 && !StringUtility.isNullOrEmpty(callReturn.getErrorMessage())) {
            AipdtUIUtil.showErrorMessage(callReturn.getErrorMessage(), null);
            return;
        } else {
            componentsRefreshOnSearch();
        }
        return;
    }

    /**
     * Helper method to get Stores from Selected StoreList
     * @return
     *      Stores
     */
    private String getStoresFromStoreList() {
        String stores = null;
        OperationBinding OpBind = AipdtUIUtil.findOperation("loadStoresFromStoreList");
        if (OpBind != null) {
            stores = String.valueOf(OpBind.execute());
        }
        return stores;
    }

    /**
     * Invoked on Reset button, It shows reset popup to user for further action
     * @param actionEvent
     */
    public void handleReset(ActionEvent actionEvent) {
        ADFFacesUtil.showPopup(resetPopup.getClientId(FacesContext.getCurrentInstance()));
    }

    /**
     * Helper mthod to reset entire screen
     */
    private void resetScreen() {
        OperationBinding opBind = AipdtUIUtil.findOperation("handleReset");
        if (opBind != null) {
            opBind.execute();
        }
        componentsRefreshOnReset();
        getResultTable().resetStampState();
        AipdtUIUtil.clearTableFilter(getResultTable());
    }

    /**
     * Invoked on Save button. Validate required logic and call AM save method
     * @return
     */
    public String handleSave() {
        if (isRowSelectedInResultTable()) {
            isSaveAndCloseCliked = false;
            ADFFacesUtil.showPopup(getSaveConfirmationPopup().getClientId(FacesContext.getCurrentInstance()));
        } else {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SAVE_ERROR_MSG, null);
        }
        return null;
    }


    /**
     * Invoked on SaveAndClose button. Validate required logi and call AM save method.
     * If scthen close screen.
     * @return
     */
    public String handleSaveAndClose() {
        if (isRowSelectedInResultTable()) {
            isSaveAndCloseCliked = true;
            ADFFacesUtil.showPopup(getSaveCloseConfirmationPopup().getClientId(FacesContext.getCurrentInstance()));
        } else {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SAVE_AND_CLOSE_ERROR_MSG, null);
        }
        return null;
    }

    /**
     * Helper method to call AM save method
     */
    private void processSave() {
        PlsqlCallReturn callReturn = new PlsqlCallReturn();
        OperationBinding opBind = AipdtUIUtil.findOperation("handleSave");
        if (opBind != null) {
            callReturn = (PlsqlCallReturn) opBind.execute();
            if (callReturn.getExecutionStatus() == 1 && !StringUtility.isNullOrEmpty(callReturn.getErrorMessage())) {
                AipdtUIUtil.showErrorMessage(callReturn.getErrorMessage(), null);
            } else if (callReturn.getExecutionStatus() == 0 &&
                       StringUtility.isNullOrEmpty(callReturn.getErrorMessage())) {
                ADFFacesUtil.showPopup(saveSuccessPopup.getClientId(FacesContext.getCurrentInstance()));
            }
            return;
        }
    }

    /**
     * Helper method to identify row(s) selected in result table by calling AM method
     * @return
     */
    private boolean isRowSelectedInResultTable() {
        OperationBinding opBind = AipdtUIUtil.findOperation("isRowSelectedInResultTable");
        if (opBind != null) {
            return (Boolean) opBind.execute();
        }
        return false;
    }

    /**
     * Invoked on Cancel button action. Show cancel confirmation message to user
     * @return
     */
    public String handleCancel() {
        ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    /**
     * Invoked on selection of check box.
     * @param valueChangeEvent
     */
    public void onSelectionOfCheckBox(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(RESULT_VO_ITERATOR);
        if (dcItteratorBindings != null) {
            ViewObject resultVO = dcItteratorBindings.getViewObject();
            boolean newValue =
                (valueChangeEvent.getNewValue() == null) ? Boolean.FALSE :
                Boolean.parseBoolean(valueChangeEvent.getNewValue().toString());
            if (getSelectAllComp() != null) {
                if (newValue) {
                    Row[] resultsRows = resultVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
                    if ((resultsRows != null) && (resultsRows.length == resultVO.getEstimatedRowCount())) {
                        getSelectAllComp().setValue(Boolean.TRUE);
                    } else {
                        getSelectAllComp().setValue(Boolean.FALSE);
                    }
                } else {
                    getSelectAllComp().setValue(Boolean.FALSE);
                }
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
    }

    /**
     * Invoked on selection of header level checkbox to select All or Filtered row's
     * @param valueChangeEvent
     */
    public void onSelectionOfAllCheckBox(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        boolean isSelected = valueChangeEvent.getNewValue() == true ? true : false;
        OperationBinding opBind = AipdtUIUtil.findOperation("handleAllCheckBox");
        if (opBind != null) {
            opBind.getParamsMap().put("isSelected", isSelected);
            opBind.execute();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getResultTable());
    }

    /**
     * Helper method to refresh entire screen on reset button action
     */
    private void componentsRefreshOnReset() {
        searchFieldsBean.setDeptIds(null);
        getDeptComp().resetValue();
        searchFieldsBean.setDepartmentDisabled(false);
        searchFieldsBean.setOrdFromSupplierIds(null);
        searchFieldsBean.setOrdFromSupplierDisabled(true);
        multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getSupplierComp());
        searchFieldsBean.setRegionId(null);
        searchFieldsBean.getRegionComp().resetValue();
        searchFieldsBean.setRegionDisabled(true);
        searchFieldsBean.setStoreIds(null);
        searchFieldsBean.setStoreDisabled(true);
        multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
        searchFieldsBean.setStoreListId(null);
        searchFieldsBean.getStoreListComp().resetValue();
        searchFieldsBean.setStoreListDisabled(true);

        searchFieldsBean.setSaveBtnDisabled(true);
        searchFieldsBean.getSearchBtn().setDisabled(true);

        //getSelectAllComp().setValue(Boolean.FALSE);
        getSelectAllComp().resetValue();
        getStartDateHeaderComp().resetValue();
        getEndDateHeaderComp().resetValue();

        isSaveAndCloseCliked = false;
        AdfFacesContext.getCurrentInstance().addPartialTarget(getAppsPanel());

        AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getStartDateHeaderComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getEndDateHeaderComp());
        componentsAddPartialTarget();

    }

    /**
     * Helper method to refresh a screen on search button action
     */
    private void componentsRefreshOnSearch() {
        searchFieldsBean.setDepartmentDisabled(true);
        searchFieldsBean.setOrdFromSupplierDisabled(true);
        searchFieldsBean.setRegionDisabled(true);
        searchFieldsBean.setStoreDisabled(true);
        searchFieldsBean.setStoreListDisabled(true);
        searchFieldsBean.setSaveBtnDisabled(false);
        searchFieldsBean.setSearchBtnDisabled(true);
        searchFieldsBean.getSearchBtn().setDisabled(true);

        isSaveAndCloseCliked = false;

        componentsAddPartialTarget();
    }

    private void componentsAddPartialTarget() {
        AdfFacesContext.getCurrentInstance().addPartialTarget(getDeptComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSupplierComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchFieldsBean.getRegionComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchFieldsBean.getStoreListComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchFieldsBean.getSearchBtn());
        AipdtUIUtil.clearTableFilter(resultTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsContainer());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
    }

    /**
     * Construt CDS export file name
     * @return
     *      Export file name
     */
    public String getExportFileName() {
        return AipdtUIUtil.getExportFileName(Constants.CDS_EXPORT_FILE_NAME);
    }

    public Boolean exportSelectedRows(UIComponent uIComponent, ExportContext exportContext,
                                      FormatHandler formatHandler) {
        AipdtUIUtil.selectAllRowsInTable(getResultTable(), RESULT_VO_ITERATOR, Constants.UPDATE_IND_ATTR);
        return Boolean.TRUE;
    }

    private Object getSelectedRow(RichTable table) {
        Object _selectedRowData = table.getSelectedRowData();
        JUCtrlHierNodeBinding _nodeBinding = (JUCtrlHierNodeBinding) _selectedRowData;
        return _nodeBinding.getRow();
    }

    private BindingContainer getBinding() {
        BindingContext lBindingContext = BindingContext.getCurrent();
        BindingContainer bindings = lBindingContext.getCurrentBindingsEntry();
        return bindings;
    }

    public String handleStartDateSetAll() {
        if (startDateHeaderComp.getValue() != null) {
            Map inputMap = new HashMap();
            inputMap.put(Constants.START_DATE, startDateHeaderComp.getValue());
            invokeHandleSetAllAMMethod(inputMap);
        } else {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.START_DATE_NULL, startDateHeaderComp);
        }
        return null;
    }

    public String handleEndDateSetAll() {
        if (endDateHeaderComp != null && endDateHeaderComp.getValue() != null) {
            Map inputMap = new HashMap();
            inputMap.put(Constants.END_DATE, endDateHeaderComp.getValue());
            invokeHandleSetAllAMMethod(inputMap);
        } else {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.END_DATE_NULL, endDateHeaderComp);
        }
        return null;
    }

    private void invokeHandleSetAllAMMethod(Map inputMap) {
        if (isRowSelectedInResultTable()) {
            OperationBinding opBind = AipdtUIUtil.findOperation("handleDateSetAll");
            if (opBind != null) {
                opBind.getParamsMap().put("setAllMap", inputMap);
                opBind.execute();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsContainer());
            }
        } else {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SELECT_ROW_FOR_SETALL, null);
        }
    }

    /**
     * Invoked on Department link selection to show Item/Sku hierarchy popup to user
     * @param actionEvent
     */
    public void onClickViewItemPopup(ActionEvent actionEvent) {
        ViewObject itemHierVO = AipdtUIUtil.findIterator(ITEM_POPUP_VO_ITERATOR).getViewObject();
        CrossDockSetupResultVORowImpl currentRow = (CrossDockSetupResultVORowImpl) getSelectedRow(getResultTable());
        itemHierVO.setNamedWhereClauseParam(Constants.BIND_DEPARTMENT_ID, currentRow.getDepartmentId());
        itemHierVO.setNamedWhereClauseParam(Constants.BIND_SUPPLIER_ID, currentRow.getSupplierId());
        itemHierVO.setNamedWhereClauseParam(Constants.BIND_STORE_ID, currentRow.getStoreId());
        itemHierVO.setNamedWhereClauseParam(Constants.BIND_REGION_ID, currentRow.getRegionId());
        itemHierVO.executeQuery();
        if (itemHierVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.REC_EXCEEDS_LIMIT, null);
        } else {
            ADFFacesUtil.showPopup(itemHierarchyPopup.getClientId(FacesContext.getCurrentInstance()));
        }
    }


    public void onClickViewStorePopup(ActionEvent actionEvent) {
        ViewObject storeVO = AipdtUIUtil.findIterator(STORE_POPUP_VO_ITERATOR).getViewObject();
        CrossDockSetupResultVORowImpl currentRow = (CrossDockSetupResultVORowImpl) getSelectedRow(getResultTable());
        storeVO.setNamedWhereClauseParam(Constants.BIND_DEPARTMENT_ID, currentRow.getDepartmentId());
        storeVO.setNamedWhereClauseParam(Constants.BIND_SUPPLIER_ID, currentRow.getSupplierId());
        storeVO.setNamedWhereClauseParam(Constants.BIND_REGION_ID, currentRow.getRegionId());
        storeVO.executeQuery();

        if (storeVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.REC_EXCEEDS_LIMIT, null);
        } else {
            ADFFacesUtil.showPopup(storePopup.getClientId(FacesContext.getCurrentInstance()));
        }
    }

    public void onClickViewCDSReportPopup(ActionEvent actionEvent) {
        ViewObject reportVO = AipdtUIUtil.findIterator(CDS_REPORT_POPUP_VO_ITERATOR).getViewObject();
        CrossDockSetupResultVORowImpl currentRow = (CrossDockSetupResultVORowImpl) getSelectedRow(getResultTable());
        reportVO.setNamedWhereClauseParam(Constants.BIND_DEPARTMENT_ID, currentRow.getDepartmentId());
        reportVO.setNamedWhereClauseParam(Constants.BIND_SUPPLIER_ID, currentRow.getSupplierId());
        reportVO.setNamedWhereClauseParam(Constants.BIND_REGION_ID, currentRow.getRegionId());
        reportVO.setNamedWhereClauseParam(Constants.BIND_DESTINATION_SEQ, currentRow.getDestinationSeq());
        reportVO.executeQuery();
        if (reportVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.REC_EXCEEDS_LIMIT, null);
        } else {
            setSelDept(currentRow.getDepartmentCode() + " ~ " + currentRow.getDepartmentDesc());
            setSelSupplier(currentRow.getSupplierCode() + " ~ " + currentRow.getSupplierDesc());
            if (currentRow.getRegionCode() != null) {
                setSelRegion(currentRow.getRegionCode() + " ~ " + currentRow.getRegionDesc());
            }

            if (currentRow.getStoreCode() != null) {
                setSelStore(currentRow.getStoreCode() + " ~ " + currentRow.getStoreDesc());
            }
            ADFFacesUtil.showPopup(getCdsHistReportPopup().getClientId(FacesContext.getCurrentInstance()));
        }
    }

    public void onClickViewRowDOWSetPopup(ActionEvent actionEvent) {
        CrossDockSetupResultVORowImpl currentRow = (CrossDockSetupResultVORowImpl) getSelectedRow(getResultTable());
        OperationBinding opBind = AipdtUIUtil.findOperation("createEmptyDOWRows");
        if (opBind != null) {
            opBind.getParamsMap().put("currentResultRow", currentRow);
            opBind.execute();

            setSelDept(currentRow.getDepartmentCode() + " ~ " + currentRow.getDepartmentDesc());
            setSelSupplier(currentRow.getSupplierCode() + " ~ " + currentRow.getSupplierDesc());
            if (currentRow.getRegionCode() != null) {
                setSelRegion(currentRow.getRegionCode() + " ~ " + currentRow.getRegionDesc());
            }

            if (currentRow.getStoreCode() != null) {
                setSelStore(currentRow.getStoreCode() + " ~ " + currentRow.getStoreDesc());
            }
            ADFFacesUtil.showPopup(getRowDOWPopup().getClientId(FacesContext.getCurrentInstance()));
        }
    }

    public void handleDOWSetAllAction(ActionEvent actionEvent) {
        if (isRowSelectedInResultTable()) {
            OperationBinding opBind = AipdtUIUtil.findOperation("createEmptyDOWSetAll");
            if (opBind != null) {
                opBind.execute();
                ADFFacesUtil.showPopup(dowSetAllPopup.getClientId(FacesContext.getCurrentInstance()));
            }
        } else {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.SELECT_ROW_FOR_SETALL, null);
        }
    }

    public void onStartDateChange(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        AdfFacesContext.getCurrentInstance().addPartialTarget(endDateRowComp);
    }

    public void onEndDateChange(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        AdfFacesContext.getCurrentInstance().addPartialTarget(startDateRowComp);
    }

    /**
     * Invoked on click of Set All button from DOW popup. Validates required logic then call AM method
     * @param actionEvent
     */
    public void dowSetAllListener(ActionEvent actionEvent) {
        ViewObject vo = AipdtUIUtil.findIterator(TIME_SET_ALL_POPUP_VO_ITERATOR).getViewObject();

        Row[] resultsRows = vo.getAllRowsInRange();
        if ((resultsRows == null) || (resultsRows.length == 0)) {
            logger.warning("No records selected to update.");
            return;
        }
        int count = 0;
        for (int rowIndex = 0; rowIndex < resultsRows.length; rowIndex++) {
            CrossDockSetupTimeSetAllVORowImpl resultsRow = (CrossDockSetupTimeSetAllVORowImpl) resultsRows[rowIndex];
            if (!isDOWNull(resultsRow.getSunday())) {
                ++count;
                break;
            }
            if (!isDOWNull(resultsRow.getMonday())) {
                ++count;
                break;
            }
            if (!isDOWNull(resultsRow.getTuesday())) {
                ++count;
                break;
            }
            if (!isDOWNull(resultsRow.getWednesday())) {
                ++count;
                break;
            }
            if (!isDOWNull(resultsRow.getThursday())) {
                ++count;
                break;
            }
            if (!isDOWNull(resultsRow.getFriday())) {
                ++count;
                break;
            }
            if (!isDOWNull(resultsRow.getSaturday())) {
                ++count;
                break;
            }
        }

        if (count == 0) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.DOW_INPUT_IS_NULL, null);
        } else {
            OperationBinding opBind = AipdtUIUtil.findOperation("handleDOWSetAll");
            if (opBind != null) {
                opBind.execute();
                if (getResultTable() != null) {
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getResultTable());
                    dowSetAllPopup.hide();
                }
            }
        }
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

    public void saveFailedOkListener(ActionEvent actionEvent) {
        saveFailedPopup.hide();
    }

    /**
     * Invoked when Ok is clicked from Save popup.
     * @param actionEvent
     */
    public void saveSuccessOkListener(ActionEvent actionEvent) {
        if (isSaveAndCloseCliked) {
            AipdtUIUtil.invokeAction(Constants.CANCEL);
        }

        saveSuccessPopup.hide();
        resetScreen();
    }

    /**
     * Invoked when Yes is clicked from Cancel confirmation popup. On click Yes screen would be closed
     * @param actionEvent
     */
    public void cancelYesListener(ActionEvent actionEvent) {
        cancelPopup.hide();
        AipdtUIUtil.invokeAction(Constants.CANCEL);
    }

    /**
     * Invoked when No is clicked from Cancel confirmation popup. On click Close user stays on current transaction
     * @param actionEvent
     */
    public void cancelNoListener(ActionEvent actionEvent) {
        cancelPopup.hide();
    }

    /**
     * Invoked when Close is clicked from DOW popup.
     * @param actionEvent
     */
    public void dowCloseListener(ActionEvent actionEvent) {
        dowSetAllPopup.hide();
    }

    /**
     * Invoked when Close is clicked from Item Hierarchy popup.
     * @param actionEvent
     */
    public void itemHierCloseListener(ActionEvent actionEvent) {
        itemHierarchyPopup.hide();
    }

    /**
     * Invoked when Close is clicked from Store popup.
     * @param actionEvent
     */
    public void storeCloseListener(ActionEvent actionEvent) {
        storePopup.hide();
    }

    public void cdsHistReportCloseListener(ActionEvent actionEvent) {
        getCdsHistReportPopup().hide();
    }

    /**
     * Invoked on Reset Popup Yes button. Close reset popup and Reset entire screen like initial state
     * @param actionEvent
     */
    public void resetYesListener(ActionEvent actionEvent) {
        resetPopup.hide();
        resetScreen();
    }

    /**
     * Invoked on Reset Popup Close button. Close reset popup and no changes on screen
     * @param actionEvent
     */
    public void resetNoListener(ActionEvent actionEvent) {
        resetPopup.hide();
    }

    public void saveConfirmYesListener(ActionEvent actionEvent) {
        getSaveConfirmationPopup().hide();
        processSave();
    }

    public void saveConfirmNoListener(ActionEvent actionEvent) {
        getSaveConfirmationPopup().hide();
    }

    public void saveCloseConfirmYesListener(ActionEvent actionEvent) {
        getSaveConfirmationPopup().hide();
        processSave();
    }

    public void saveCloseConfirmNoListener(ActionEvent actionEvent) {
        getSaveCloseConfirmationPopup().hide();
    }


    /**
     * Invoked when Close is clicked from DOW popup.
     * @param actionEvent
     */
    public void rowDOWCloseListener(ActionEvent actionEvent) {
        getRowDOWPopup().hide();
    }

    /**
     * Invoked on click of Set All button from DOW popup. Validates required logic then call AM method
     * @param actionEvent
     */
    public void rowDOWSetListener(ActionEvent actionEvent) {
        ViewObject vo = AipdtUIUtil.findIterator(CDS_ROW_DOW_VO_ITERATOR).getViewObject();

        Row[] dowRows = vo.getAllRowsInRange();
        if ((dowRows == null) || (dowRows.length == 0)) {
            logger.warning("No records selected to update.");
            return;
        }
        int count = 0;
        BigDecimal id = ((CrossDockSetupTimeSetAllVORowImpl) dowRows[0]).getId();
        for (int rowIndex = 0; rowIndex < dowRows.length; rowIndex++) {
            CrossDockSetupTimeSetAllVORowImpl dowRow = (CrossDockSetupTimeSetAllVORowImpl) dowRows[rowIndex];
            if (!isDOWNull(dowRow.getSunday())) {
                ++count;
                break;
            }
            if (!isDOWNull(dowRow.getMonday())) {
                ++count;
                break;
            }
            if (!isDOWNull(dowRow.getTuesday())) {
                ++count;
                break;
            }
            if (!isDOWNull(dowRow.getWednesday())) {
                ++count;
                break;
            }
            if (!isDOWNull(dowRow.getThursday())) {
                ++count;
                break;
            }
            if (!isDOWNull(dowRow.getFriday())) {
                ++count;
                break;
            }
            if (!isDOWNull(dowRow.getSaturday())) {
                ++count;
                break;
            }
        }

        if (count == 0) {
            AipdtUIUtil.showErrorMessageFromUIBundle(Constants.DOW_INPUT_IS_NULL, null);
        } else {
            for (int rowIndex = 0; rowIndex < dowRows.length; rowIndex++) {
                CrossDockSetupTimeSetAllVORowImpl dowRow = (CrossDockSetupTimeSetAllVORowImpl) dowRows[rowIndex];
                System.out.println(dowRow.getSunday());
                System.out.println(dowRow.getMonday());
                System.out.println(dowRow.getTuesday());
                System.out.println(dowRow.getWednesday());
                System.out.println(dowRow.getThursday());
                System.out.println(dowRow.getFriday());
                System.out.println(dowRow.getSaturday());
            }
            OperationBinding opBind = AipdtUIUtil.findOperation("handleRowDOWSet");
            if (opBind != null) {
                opBind.getParamsMap().put("id", id);
                opBind.execute();
                if (getResultTable() != null) {
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getResultTable());
                    getRowDOWPopup().hide();
                }
            }
        }
    }

    public void setRowDOWPopup(RichPopup rowDOWPopup) {
        this.rowDOWPopup = rowDOWPopup;
    }

    public RichPopup getRowDOWPopup() {
        return rowDOWPopup;
    }
}
