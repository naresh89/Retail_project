package oracle.retail.apps.aipdt.rswspm.publicui.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.common.publicui.bean.BaseRetailBean;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.aipdt.list.create.publicui.bean.SupplyChainListCreationBean;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

import org.apache.myfaces.trinidad.util.ComponentReference;

public class WhToStPriorityMatrixBean  extends BaseRetailBean {
    @SuppressWarnings("compatibility:4759925068930068246")
    private static final long serialVersionUID = 1L;

    private final static ADFLogger _logger = ADFLogger.createADFLogger(SupplyChainListCreationBean.class);

    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();

    private boolean saveDisabled = Boolean.TRUE;
    private Boolean isSearchBtnDisabled = Boolean.TRUE;
    private Boolean isStoreDisabled = Boolean.FALSE;
    protected static String vpnIdVal = null;
    private transient RichButton searchBtnBind;
    private ComponentReference<RichPopup> savePopup;
    private ComponentReference<RichPopup> saveClosePopup;
    private ComponentReference<RichPopup> cancelPopup;
    private ComponentReference<RichPopup> saveSuccessPopup;
    private ComponentReference<RichPopup> saveCloseSuccessPopup;
    private ComponentReference<RichPopup> resetPopup;
    private RichTable resultTableBind;
    private RichPanelGroupLayout resultAreaPgBind;
    private RichSelectOneChoice wh1Bind;
    private RichSelectOneChoice wh2Bind;
    private RichSelectOneChoice wh3Bind;

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    public void setIsSearchBtnDisabled(Boolean isSearchBtnDisabled) {
        this.isSearchBtnDisabled = isSearchBtnDisabled;
    }

    public Boolean getIsSearchBtnDisabled() {
        return isSearchBtnDisabled;
    }
    
    public void setIsStoreDisabled(Boolean isStoreDisabled) {
        this.isStoreDisabled = isStoreDisabled;
    }

    public Boolean getIsStoreDisabled() {
        return isStoreDisabled;
    }
    
    public void setSearchBtnBind(RichButton searchBtnBind) {
        this.searchBtnBind = searchBtnBind;
    }

    public RichButton getSearchBtnBind() {
        return searchBtnBind;
    }
    
    public void setMultiSelectBaseFieldsBean(MultiSelectBaseFieldsBean multiSelectBaseFieldsBean) {
        this.multiSelectBaseFieldsBean = multiSelectBaseFieldsBean;
    }

    public MultiSelectBaseFieldsBean getMultiSelectBaseFieldsBean() {
        return multiSelectBaseFieldsBean;
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
    
    public void setResetPopup(RichPopup resetPopup) {
        this.resetPopup = ComponentReference.newUIComponentReference(resetPopup);
    }

    public RichPopup getResetPopup() {
        if (resetPopup != null) {
            return resetPopup.getComponent();
        }
        return null;
    }

    public void setWh1Bind(RichSelectOneChoice wh1Bind) {
        this.wh1Bind = wh1Bind;
    }

    public RichSelectOneChoice getWh1Bind() {
        return wh1Bind;
    }

    public void setWh2Bind(RichSelectOneChoice wh2Bind) {
        this.wh2Bind = wh2Bind;
    }

    public RichSelectOneChoice getWh2Bind() {
        return wh2Bind;
    }

    public void setWh3Bind(RichSelectOneChoice wh3Bind) {
        this.wh3Bind = wh3Bind;
    }

    public RichSelectOneChoice getWh3Bind() {
        return wh3Bind;
    }
    
    public void setResultTableBind(RichTable resultTableBind) {
        this.resultTableBind = resultTableBind;
    }

    public RichTable getResultTableBind() {
        return resultTableBind;
    }

    public void setResultAreaPgBind(RichPanelGroupLayout resultAreaPgBind) {
        this.resultAreaPgBind = resultAreaPgBind;
    }

    public RichPanelGroupLayout getResultAreaPgBind() {
        return resultAreaPgBind;
    }


    public WhToStPriorityMatrixBean() {
        super();
    }
    
    /**Method to show common error message
     * @param null
     */
    public void showCommonErrorMessage() {
        AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                        Constants.DEAFULT_ERROR_MSG), null);
    }  
    
    public void clearAllComponents(){
        vpnIdVal = null;
        multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
    }

    /**
     * Invoked when Cancel button is clicked, which triggers the cancel confirmation popup
     * @return
     */
    public String handleCancelMatrix() {
        _logger.info("****** Inside cancelNetworkPath method ******");
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
    public String handleSaveAndCloseMatrix() {
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
    public void handleSaveMatrix(ActionEvent actionEvent) {
        _logger.info("****** Inside handleSaveSupplyChainList method ******" + actionEvent.getComponent());
        try {
            OperationBinding saveMatrixValidation =
                AipdtUIUtil.getBindings().getOperationBinding(Constants.SAVE_MATRIX_VALIDATION_OPERBIND);
            Object returnValue = saveMatrixValidation.execute();
            if(returnValue == null){
                if (getSavePopup() != null) {
                    ADFFacesUtil.showPopup(getSavePopup().getClientId(FacesContext.getCurrentInstance()));
                }
            }else{
                AipdtUIUtil.showErrorMessage(returnValue.toString(), null);
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in handleSaveSupplyChainList " + exp);
            showCommonErrorMessage();
        }
    }
    
    /**
     * Invoked on the search button click
     * @param actionEvent
     */

    @SuppressWarnings("unchecked")
    public void handleSearchBtnClick(ActionEvent actionEvent) {
        Map outMap = new HashMap();
        try {
            _logger.info("Entering  handleSearchBtnClick()" + actionEvent.getComponent());
            OperationBinding searchOp =
                AipdtUIUtil.getBindings().getOperationBinding(Constants.SEARCH_MATRIX_OPERBIND);
            searchOp.getParamsMap().put(Constants.SELECTED_ST_CODE_OPERMAP, vpnIdVal);
            outMap =  (Map)searchOp.execute();        
            Object errorMessage = outMap.get(Constants.SEARCH_ERROR_MESSAGE);
            Object result = outMap.get(Constants.SEARCH_PLSQL_RETURN_STATUS);
            if (result == 0) {
                isStoreDisabled = Boolean.TRUE;
                isSearchBtnDisabled = Boolean.TRUE;
                saveDisabled = false;
                resultAreaPgBind.setVisible(Boolean.TRUE);
                AipdtUIUtil.clearTableFilter(resultTableBind);
                AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
                AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtnBind);
                AdfFacesContext.getCurrentInstance().addPartialTarget(resultAreaPgBind);
            } else {
                if (errorMessage == null) {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                    Constants.INVALID_SEARCH_CRITERIA),
                                                 null);
                } else {
                    AipdtUIUtil.showErrorMessage(errorMessage.toString(), null);
                }

            }
            return;
            
        } catch (Exception exp) {
            _logger.log("Exception occured in handleSearchBtnClick " + exp);
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
            Object stCodeValues = multiSelectBaseFieldsBean.getStoreComp().getSelectedValues();
            if(!StringUtil.isNullOrEmpty(stCodeValues)){
                isSearchBtnDisabled = Boolean.FALSE;
            }else{
                isSearchBtnDisabled = Boolean.TRUE;
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in validateInputs " + exp);
            showCommonErrorMessage();
        }
        return validateCheck;        
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
     * Invoked when user selects 'Yes' from the Save confirmation popup
     * @param actionEvent
     */
    @SuppressWarnings("unchecked")
    public void saveYesListener(ActionEvent actionEvent) {
        _logger.info("****** Inside saveYesListener method ******");
        try {
            OperationBinding saveOp =
                AipdtUIUtil.getBindings().getOperationBinding(Constants.SAVE_MATRIX_OPERBIND);
            saveOp.execute();  
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
        _logger.info("****** Inside cancelYesListener method ******" + actionEvent.getComponent());
        try {
            clearAllComponents();
            if(actionEvent.getComponent().getId().equalsIgnoreCase(Constants.CANCEL_YES_BTN)){
                AipdtUIUtil.invokeAction(Constants.CANCEL);
            }else{
                OperationBinding op =
                    BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.ON_CLICK_RESET_ACTION_OPERBIND);
                op.execute();
                AipdtUIUtil.clearTableFilter(resultTableBind);
                resultTableBind.resetStampState();
                isSearchBtnDisabled = Boolean.TRUE;
                isStoreDisabled = Boolean.FALSE;
                saveDisabled = Boolean.TRUE;
                getResultAreaPgBind().setVisible(Boolean.FALSE);
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
            clearAllComponents();
            OperationBinding op =
                BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.ON_CLICK_RESET_ACTION_OPERBIND);
            op.execute();
            isStoreDisabled = Boolean.FALSE;
            saveDisabled = Boolean.TRUE;
            isSearchBtnDisabled = Boolean.FALSE;
            resultAreaPgBind.setVisible(Boolean.FALSE);
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
     * Invoked on the value change of Store
     * @param valueChangeEvent
     */

    public void onStoreChange(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onStoreChange()" + valueChangeEvent.getComponent());
            if(valueChangeEvent.getNewValue() != null){
                vpnIdVal = valueChangeEvent.getNewValue().toString();
                isSearchBtnDisabled = Boolean.FALSE;
            }else{
                vpnIdVal= null;
                isSearchBtnDisabled = Boolean.TRUE;
            }
         AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtnBind);
        } catch (Exception exp) {
            _logger.log("Exception occured in onStoreChange " + exp);
            showCommonErrorMessage();
        }
    }
    
    /**
     * Invoked on the value change of warehouse 1
     * @param valueChangeEvent
     */
    
    public void onWh1Change(ValueChangeEvent valueChangeEvent) {
        try{
            _logger.info("Entering  onWh1Change()" + valueChangeEvent.getComponent());
        wh1Bind.processUpdates(FacesContext.getCurrentInstance());
        OperationBinding whValidationOper =
        AipdtUIUtil.getBindings().getOperationBinding(Constants.WH_VALIDATION_OPERBIND);
        Object errMsg = whValidationOper.execute();
        if(errMsg != null){
            AipdtUIUtil.showErrorMessage(errMsg.toString(), null);
        }
        } catch (Exception exp) {
            _logger.log("Exception occured in onStoreChange " + exp);
            showCommonErrorMessage();
        }     
    }
    
    /**
     * Invoked on the value change of warehouse 2
     * @param valueChangeEvent
     */

    public void onWh2Change(ValueChangeEvent valueChangeEvent) {
        try{
            _logger.info("Entering  onWh2Change()" + valueChangeEvent.getComponent());
        wh2Bind.processUpdates(FacesContext.getCurrentInstance());
        OperationBinding whValidationOper =
        AipdtUIUtil.getBindings().getOperationBinding(Constants.WH_VALIDATION_OPERBIND);
        Object errMsg = whValidationOper.execute();
        
        if(errMsg != null){
            AipdtUIUtil.showErrorMessage(errMsg.toString(), null);
        }
        } catch (Exception exp) {
            _logger.log("Exception occured in onStoreChange " + exp);
            showCommonErrorMessage();
        }
    }
    
    /**
     * Invoked on the value change of warehouse 3
     * @param valueChangeEvent
     */

    public void onWh3Change(ValueChangeEvent valueChangeEvent) {
        try{
            _logger.info("Entering  onWh3Change()" + valueChangeEvent.getComponent());
        wh3Bind.processUpdates(FacesContext.getCurrentInstance());
        OperationBinding whValidationOper =
        AipdtUIUtil.getBindings().getOperationBinding(Constants.WH_VALIDATION_OPERBIND);
        Object errMsg = whValidationOper.execute();
        
        if(errMsg != null){
            AipdtUIUtil.showErrorMessage(errMsg.toString(), null);
        }
        } catch (Exception exp) {
            _logger.log("Exception occured in onStoreChange " + exp);
            showCommonErrorMessage();
        }
    }
    /**
     * Invoked on the click of clear button
     * @param valueChangeEvent
     */

    public void clearTableFilterBtnAction(ActionEvent actionEvent) {
        try{
            _logger.info("Entering  clearTableFilterBtnAction()" + actionEvent.getComponent());
        AipdtUIUtil.clearTableFilter(resultTableBind);
        }catch (Exception exp) {
            _logger.log("Exception occured in clearTableFilterBtnAction " + exp);
            showCommonErrorMessage();
        }
    }
}
