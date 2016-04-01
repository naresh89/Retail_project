package oracle.retail.apps.aipdt.list.maintain.publicui.bean;

import java.util.ArrayList;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.export.ExportContext;
import oracle.adf.view.rich.export.FormatHandler;

import oracle.adf.view.rich.util.ResetUtils;

import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;

import oracle.jbo.ViewObject;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

import org.apache.myfaces.trinidad.model.RowKeySetImpl;
import org.apache.myfaces.trinidad.util.ComponentReference;

public class SupplyChainListMaintainBean {

    private RichInputText listNameBind;
    private RichSelectOneChoice listPrivacyBind;

    private Boolean isWorkingLevelDisabled = Boolean.FALSE;
    private Boolean isListNameDisabled = Boolean.FALSE;
    private Boolean isPrivacyDisabled = Boolean.FALSE;
    private Boolean isSearchBtnDisabled = Boolean.TRUE;

    private boolean saveDisabled = Boolean.TRUE;

    private ComponentReference<RichPopup> savePopup;
    private ComponentReference<RichPopup> saveClosePopup;
    private ComponentReference<RichPopup> cancelPopup;
    private ComponentReference<RichPopup> saveSuccessPopup;
    private ComponentReference<RichPopup> saveCloseSuccessPopup;
    private RichPopup listDtlsPopupBind;
    private RichTable listDtlsTableBind;
    private RichTable listHeaderTabBind;


    public SupplyChainListMaintainBean() {
        super();
    }

    private final static ADFLogger _logger = ADFLogger.createADFLogger(SupplyChainListMaintainBean.class);

    private RichSelectOneChoice workingLevelBind;

    public void setWorkingLevelBind(RichSelectOneChoice workingLevelBind) {
        this.workingLevelBind = workingLevelBind;
    }

    public RichSelectOneChoice getWorkingLevelBind() {
        return workingLevelBind;
    }

    public void setListNameBind(RichInputText listNameBind) {
        this.listNameBind = listNameBind;
    }

    public RichInputText getListNameBind() {
        return listNameBind;
    }

    public void setListPrivacyBind(RichSelectOneChoice listPrivacyBind) {
        this.listPrivacyBind = listPrivacyBind;
    }

    public RichSelectOneChoice getListPrivacyBind() {
        return listPrivacyBind;
    }

    public void setIsWorkingLevelDisabled(Boolean isWorkingLevelDisabled) {
        this.isWorkingLevelDisabled = isWorkingLevelDisabled;
    }

    public Boolean getIsWorkingLevelDisabled() {
        return isWorkingLevelDisabled;
    }

    public void setIsListNameDisabled(Boolean isListNameDisabled) {
        this.isListNameDisabled = isListNameDisabled;
    }

    public Boolean getIsListNameDisabled() {
        return isListNameDisabled;
    }

    public void setIsPrivacyDisabled(Boolean isPrivacyDisabled) {
        this.isPrivacyDisabled = isPrivacyDisabled;
    }

    public Boolean getIsPrivacyDisabled() {
        return isPrivacyDisabled;
    }

    public void setIsSearchBtnDisabled(Boolean isSearchBtnDisabled) {
        this.isSearchBtnDisabled = isSearchBtnDisabled;
    }

    public Boolean getIsSearchBtnDisabled() {
        return isSearchBtnDisabled;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void setCancelPopup(RichPopup cancelPopup) {
        this.cancelPopup = ComponentReference.newUIComponentReference(cancelPopup);
    }

    public RichPopup getCancelPopup() {
        if (cancelPopup != null) {
            return cancelPopup.getComponent();
        }
        return null;
    }

    public void setSavePopup(RichPopup savePopup) {
        this.savePopup = ComponentReference.newUIComponentReference(savePopup);
    }

    public RichPopup getSavePopup() {
        if (savePopup != null) {
            return savePopup.getComponent();
        }
        return null;
    }

    public void setSaveClosePopup(RichPopup saveClosePopup) {
        this.saveClosePopup = ComponentReference.newUIComponentReference(saveClosePopup);
    }

    public RichPopup getSaveClosePopup() {
        if (saveClosePopup != null) {
            return saveClosePopup.getComponent();
        }
        return null;
    }

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = ComponentReference.newUIComponentReference(saveSuccessPopup);
    }

    public RichPopup getSaveSuccessPopup() {
        if (saveSuccessPopup != null) {
            return saveSuccessPopup.getComponent();
        }
        return null;
    }

    public void setSaveCloseSuccessPopup(RichPopup saveCloseSuccessPopup) {
        this.saveCloseSuccessPopup = ComponentReference.newUIComponentReference(saveCloseSuccessPopup);
    }

    public RichPopup getSaveCloseSuccessPopup() {
        if (saveCloseSuccessPopup != null) {
            return saveCloseSuccessPopup.getComponent();
        }
        return null;
    }

    public void setListDtlsPopupBind(RichPopup listDtlsPopupBind) {
        this.listDtlsPopupBind = listDtlsPopupBind;
    }

    public RichPopup getListDtlsPopupBind() {
        return listDtlsPopupBind;
    }

    public void setListDtlsTableBind(RichTable listDtlsTableBind) {
        this.listDtlsTableBind = listDtlsTableBind;
    }

    public RichTable getListDtlsTableBind() {
        return listDtlsTableBind;
    }

    public void setListHeaderTabBind(RichTable listHeaderTabBind) {
        this.listHeaderTabBind = listHeaderTabBind;
    }

    public RichTable getListHeaderTabBind() {
        return listHeaderTabBind;
    }

    /**Method to show common error message
     * @param null
     */

    public void showCommonErrorMessage() {
        AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                        Constants.DEAFULT_ERROR_MSG), null);
    }
    
    /**
     * Invoked when the Working Level Value chnaged
     * @param valueChangeEvent
     */

    public void onWorkingLevelChange(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onWorkingLevelChange()" + valueChangeEvent.getComponent());
            workingLevelBind.processUpdates(FacesContext.getCurrentInstance());
            if (AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL) != null) {
                isSearchBtnDisabled = Boolean.FALSE;
            } else {
                isSearchBtnDisabled = Boolean.TRUE;
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in onWorkingLevelChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Clear all the values of all the components
     * @param null
     */

    public void clearAllComponents() {
        try {
            AipdtUIUtil.setValueToEL(Constants.LIST_NAME_INPUT_VAL_EL, null);
            AipdtUIUtil.setValueToEL(Constants.LIST_PRIVACY_INPUT_VAL_EL, null);
            workingLevelBind.setValue(null);
            workingLevelBind.setSubmittedValue(null);
            listNameBind.setValue(null);
            listNameBind.setSubmittedValue(null);
            listPrivacyBind.setValue(null);
            listPrivacyBind.setSubmittedValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(workingLevelBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(listNameBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(listPrivacyBind);
        } catch (Exception exp) {
            _logger.log("Exception occured in clearAllComponents " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Disable or enable all the components
     * @param null
     */

    public void disableAllComponents() {
        try {
            isWorkingLevelDisabled = Boolean.FALSE;
            isListNameDisabled = Boolean.FALSE;
            isPrivacyDisabled = Boolean.FALSE;

            isSearchBtnDisabled = Boolean.TRUE;
            saveDisabled = Boolean.TRUE;
        } catch (Exception exp) {
            _logger.log("Exception occured in disableCompsOnSearch " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when Cancel button is clicked, which triggers the cancel confirmation popup
     * @return
     */
    public String handleCancelSupplyChainList() {
        _logger.info("****** Inside handleCancelSupplyChainList method ******");
        try {
            if (getCancelPopup() != null) {
                ADFFacesUtil.showPopup(getCancelPopup().getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in handleCancelSupplyChainList " + exp);
            showCommonErrorMessage();
        }
        return null;
    }

    /**
     * Invoked when SaveAndClose button is clicked, which triggers the SaveAndClose confirmation popup
     * @return
     */
    public String handleSaveAndCloseSuppyChainList() {
        _logger.info("****** Inside saveAndCloseNetworkPath method ******");
        try {
            if (getSaveClosePopup() != null) {
                ADFFacesUtil.showPopup(getSaveClosePopup().getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in handleSaveAndCloseSuppyChainList " + exp);
            showCommonErrorMessage();
        }
        return null;
    }

    /**
     * Invoked when Save button is clicked, which triggers the Save confirmation popup
     * @param actionEvent
     */
    public void handleSaveSupplyChainList(ActionEvent actionEvent) {
        _logger.info("****** Inside handleSaveSupplyChainList method ******" + actionEvent.getComponent());
        try {
            if (getSavePopup() != null) {
                ADFFacesUtil.showPopup(getSavePopup().getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in handleSaveSupplyChainList " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when user selects 'Yes' from the Save confirmation popup
     * @param actionEvent
     */
    @SuppressWarnings("unchecked")
    public void saveYesListener(ActionEvent actionEvent) {
        _logger.info("****** Inside saveYesListener method ******");
        Object returnValue = null;
        try {
            OperationBinding saveOp = AipdtUIUtil.getBindings().getOperationBinding(Constants.SAVE_MAINTAIN_LIST_OPER);
            returnValue = saveOp.execute();

            if (returnValue == null) {
                String compId = actionEvent.getComponent().getId();
                if (compId.equals(Constants.SAVE_YES_BTN)) {
                    if (getSaveSuccessPopup() != null) {
                        ADFFacesUtil.showPopup(getSaveSuccessPopup().getClientId(FacesContext.getCurrentInstance()));
                    }
                } else if (compId.equals(Constants.SAVE_CLOSE_YES_BTN)) {
                    if (getSaveCloseSuccessPopup() != null) {
                        ADFFacesUtil.showPopup(getSaveCloseSuccessPopup().getClientId(FacesContext.getCurrentInstance()));
                    }
                }
            } else {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.ERR_SELECT_LIST), null);
            }
        } catch (JboException jboEx) {
            _logger.log("Exception occured in saveYesListener " + jboEx);
            showCommonErrorMessage();
        } catch (Exception exp) {
            _logger.log("Exception occured in saveYesListener " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when user selects 'Yes' from the Cancel confirmation popup
     * @param actionEvent
     */
    public void cancelYesListener(ActionEvent actionEvent) {
        _logger.info("****** Inside cancelYesListener method ******");
        try {
            disableAllComponents();
            clearAllComponents();
            AipdtUIUtil.clearTableFilter(listHeaderTabBind);
            getListHeaderTabBind().getSelectedRowKeys().clear();
            ResetUtils.reset(getListHeaderTabBind());
            
            OperationBinding op =
                BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.RESET_OPER);
            op.execute();
            String compId = actionEvent.getComponent().getId();
            if (compId != null && compId.equalsIgnoreCase(Constants.CANCEL_YES_BTN)) {
                AipdtUIUtil.invokeAction(Constants.CANCEL);
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in cancelYesListener " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when user selects 'Ok' from the Save Success confirmation popup, which reinitializes the screen after save.
     * @param actionEvent
     */
    public void saveOkListener(ActionEvent actionEvent) {
        _logger.info("****** Inside saveOkListener method ******" + actionEvent.getComponent());
        try {
            disableAllComponents();
            clearAllComponents();
            AipdtUIUtil.clearTableFilter(listHeaderTabBind);
            OperationBinding resetOper =
                BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.RESET_OPER);
            resetOper.execute();
        } catch (Exception exp) {
            _logger.log("Exception occured in saveOkListener " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when user selects 'Ok' from the SaveAndClose Success confirmation popup, which closes the tab.
     * @param actionEvent
     */
    public void saveCloseOkListener(ActionEvent actionEvent) {
        _logger.info("****** Inside saveCloseOkListener method ******" + actionEvent.getComponent());
        try {
            OperationBinding op =
                BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.ON_CLICK_RESET_ACTION_OPERBIND);
            op.execute();
            AipdtUIUtil.invokeAction(Constants.CLOSE_CONTENT);
        } catch (Exception exp) {
            _logger.log("Exception occured in saveCloseOkListener " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the search button click
     * @param actionEvent
     */

    @SuppressWarnings("unchecked")
    public void handleSearchBtnClick(ActionEvent actionEvent) {
        try {
            _logger.info("Entering  handleSearchBtnClick()" + actionEvent.getComponent());
            boolean proceed = Boolean.TRUE;
            proceed = validateInputs();
            Object returnValue = null;
            if (proceed) {
                AipdtUIUtil.clearTableFilter(listHeaderTabBind);
                OperationBinding op =
                    BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.SEARCH_CLICK_OPER);
                returnValue = op.execute();

                if (returnValue != null) {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.INVALID_SEARCH_CRITERIA), null);
                    isSearchBtnDisabled = Boolean.FALSE;
                    disableAllComponents();
                    clearAllComponents();
                    OperationBinding resetOperation =
                        BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.ON_CLICK_RESET_ACTION_OPERBIND);
                    resetOperation.execute();
                } else {
                    saveDisabled = Boolean.FALSE;
                    isSearchBtnDisabled = Boolean.TRUE;
                    isWorkingLevelDisabled = Boolean.TRUE;
                    isListNameDisabled = Boolean.TRUE;
                    isPrivacyDisabled = Boolean.TRUE;

                }
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in handleSearchBtnClick " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the reset button click
     * @param actionEvent
     */

    public void handleResetBtnClick(ActionEvent actionEvent) {
        try {
            _logger.info("Entering  handleResetBtnClick()" + actionEvent.getComponent());
            ADFFacesUtil.showPopup(AipdtUIUtil.findComponentInRoot(Constants.RESET_POPUP_ID).getClientId(FacesContext.getCurrentInstance()));
        } catch (Exception exp) {
            _logger.log("Exception occured in handleResetBtnClick " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     *Validating the inputs based on the user search criteria
     * @param null
     */

    public boolean validateInputs() {
        boolean validateCheck = Boolean.TRUE;
        try {
            _logger.info("Entering  validateInputs()");
            workingLevelBind.processUpdates(FacesContext.getCurrentInstance());
            if (AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL) == null) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.LIST_TYPE_CAN_NOT_BE_NULL), null);
                validateCheck = Boolean.FALSE;
                return validateCheck;
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in validateInputs " + exp);
            showCommonErrorMessage();
        }
        return validateCheck;
    }

    /**
     * Invoked while selecting the list id
     * @param null
     */
    @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")

    public void fetchListDetails(ActionEvent actionEvent) {
        oracle.jbo.domain.Number listId = null;
        try {
            _logger.info("Entering  fetchListDetails()" + actionEvent.getComponent());
            AipdtUIUtil.clearTableFilter(listDtlsTableBind);
            Row currow = AipdtUIUtil.getCurrentRowFromIterator(Constants.DT_LIST_HDR_ITER);
            if (currow != null) {
                listId = (oracle.jbo.domain.Number) currow.getAttribute(Constants.ID_ATTR);
            }
            OperationBinding fetchListDtlsOperation =
                AipdtUIUtil.getBindings().getOperationBinding(Constants.ON_FETCH_LIST_DTLS_OPER);
            fetchListDtlsOperation.getParamsMap().put(Constants.LIST_ID_OPER, listId);
            fetchListDtlsOperation.execute();
            if (getListDtlsPopupBind() != null) {
                ADFFacesUtil.showPopup(getListDtlsPopupBind().getClientId(FacesContext.getCurrentInstance()));
            }
        } catch (Exception e) {
            _logger.log("Exception occured in fetchListDetails " + e);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when updateInd is clicked.
     * @param uIComponent
     * @param exportContext
     * @param formatHandler
     * @return
     */

    public void onUpdateIndChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("****** Inside exportSelectedRows method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (getListHeaderTabBind() != null) {
            DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(Constants.DT_LIST_HDR_ITER);
            if (dcItteratorBindings != null) {
                ViewObject resultVO = dcItteratorBindings.getViewObject();
                Row[] selectedRows = resultVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Boolean.TRUE);
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
                    getListHeaderTabBind().setSelectedRowKeys(rks);
                } else {
                    getListHeaderTabBind().getSelectedRowKeys().clear();
                    getListHeaderTabBind().setSelectedRowKeys(rks);
                }
            }
        }
    }
}
