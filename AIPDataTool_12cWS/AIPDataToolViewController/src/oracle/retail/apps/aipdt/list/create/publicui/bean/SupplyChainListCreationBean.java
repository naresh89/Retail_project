package oracle.retail.apps.aipdt.list.create.publicui.bean;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.util.ResetUtils;

import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.publicui.bean.BaseRetailBean;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

import org.apache.myfaces.trinidad.util.ComponentReference;

public class SupplyChainListCreationBean extends BaseRetailBean {
    @SuppressWarnings("compatibility:-8913281033450343701")
    private static final long serialVersionUID = 1L;

    private final static ADFLogger _logger = ADFLogger.createADFLogger(SupplyChainListCreationBean.class);

    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();

    private RichInputText listNameBind;
    private RichSelectOneChoice listPrivacyBind;
    private RichSelectOneChoice regionCompBind;
    private RichSelectOneChoice workingLevelBind;

    private ComponentReference<RichPopup> savePopup;
    private ComponentReference<RichPopup> saveClosePopup;
    private ComponentReference<RichPopup> cancelPopup;
    private ComponentReference<RichPopup> saveSuccessPopup;
    private ComponentReference<RichPopup> saveCloseSuccessPopup;

    private Boolean isListNameDisabled = Boolean.FALSE;
    private Boolean isPrivacyDisabled = Boolean.FALSE;
    private Boolean isSearchBtnDisabled = Boolean.TRUE;
    private Boolean isClassDisable = Boolean.TRUE;
    private Boolean isSubClassDisable = Boolean.TRUE;
    private Boolean isVPNDisable = Boolean.TRUE;
    private Boolean isVpnColourDisable = Boolean.TRUE;
    private Boolean isSKUDisable = Boolean.TRUE;
    private Boolean isDepartmentDisabled = Boolean.TRUE;
    private Boolean isRegionDisabled = Boolean.TRUE;
    private Boolean isWorkingLevelDisabled = Boolean.FALSE;
    private boolean saveDisabled = Boolean.TRUE;

    private Boolean isStoreDisabled = Boolean.TRUE;
    private Boolean isWarehouseDisabled = Boolean.TRUE;

    protected static String deptId = null;
    protected static String classId = null;
    protected static String subclassId = null;
    protected static String vpnColourIdVal = null;
    protected static String vpnIdVal = null;
    protected static String skuIdVal = null;

    protected static String vpnColourCodeVal = null;
    protected static String vpnCodeVal = null;
    protected static String skuCodeVal = null;
    private RichButton searchBtnBind;


    public void setRegionCompBind(RichSelectOneChoice regionCompBind) {
        this.regionCompBind = regionCompBind;
    }

    public RichSelectOneChoice getRegionCompBind() {
        return regionCompBind;
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

    public void setIsRegionDisabled(Boolean isRegionDisabled) {
        this.isRegionDisabled = isRegionDisabled;
    }

    public Boolean getIsRegionDisabled() {
        return isRegionDisabled;
    }

    public void setIsDepartmentDisabled(Boolean isDepartmentDisabled) {
        this.isDepartmentDisabled = isDepartmentDisabled;
    }

    public Boolean getIsDepartmentDisabled() {
        return isDepartmentDisabled;
    }

    public void setIsStoreDisabled(Boolean isStoreDisabled) {
        this.isStoreDisabled = isStoreDisabled;
    }

    public Boolean getIsStoreDisabled() {
        return isStoreDisabled;
    }

    public void setIsWarehouseDisabled(Boolean isWarehouseDisabled) {
        this.isWarehouseDisabled = isWarehouseDisabled;
    }

    public Boolean getIsWarehouseDisabled() {
        return isWarehouseDisabled;
    }

    public void setMultiSelectBaseFieldsBean(MultiSelectBaseFieldsBean multiSelectBaseFieldsBean) {
        this.multiSelectBaseFieldsBean = multiSelectBaseFieldsBean;
    }

    public MultiSelectBaseFieldsBean getMultiSelectBaseFieldsBean() {
        return multiSelectBaseFieldsBean;
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

    public void setIsVPNDisable(Boolean isVPNDisable) {
        this.isVPNDisable = isVPNDisable;
    }

    public Boolean getIsVPNDisable() {
        return isVPNDisable;
    }

    public void setIsVpnColourDisable(Boolean isVpnColourDisable) {
        this.isVpnColourDisable = isVpnColourDisable;
    }

    public Boolean getIsVpnColourDisable() {
        return isVpnColourDisable;
    }

    public void setIsSKUDisable(Boolean isSKUDisable) {
        this.isSKUDisable = isSKUDisable;
    }

    public Boolean getIsSKUDisable() {
        return isSKUDisable;
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

    public void setWorkingLevelBind(RichSelectOneChoice workingLevelBind) {
        this.workingLevelBind = workingLevelBind;
    }

    public RichSelectOneChoice getWorkingLevelBind() {
        return workingLevelBind;
    }

    public void setSearchBtnBind(RichButton searchBtnBind) {
        this.searchBtnBind = searchBtnBind;
    }

    public RichButton getSearchBtnBind() {
        return searchBtnBind;
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
        String workingInfo = null;
        try {
            _logger.info("Entering  onWorkingLevelChange()" + valueChangeEvent.getComponent());
            workingLevelBind.processUpdates(FacesContext.getCurrentInstance());
            if (AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL) != null) {
                clearAllComponents();
                workingInfo = AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL).toString();
                disableOnLevelType(workingInfo);
                if (getListNameBind().getValue() == null) {
                    /* Commented by Arun - Need to be added in future*/
                    //                    ||AipdtUIUtil.resolveExpression(Constants.LIST_PRIVACY_ATTR_VAL_EL) == null) {
                    isSearchBtnDisabled = Boolean.TRUE;
                } else {
                    isSearchBtnDisabled = Boolean.FALSE;
                }
            } else {
                clearAllComponents();
                disableAllComponents();
                isSearchBtnDisabled = Boolean.TRUE;
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtnBind);
        } catch (Exception exp) {
            _logger.log("Exception occured in onWorkingLevelChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * this will disable all the components except Working Level, List Name and Type
     * @param null
     */

    public void disableCompsOnSearch() {
        try {
            isSearchBtnDisabled = Boolean.TRUE;
            isListNameDisabled = Boolean.TRUE;
            isPrivacyDisabled = Boolean.TRUE;
            isWorkingLevelDisabled = Boolean.TRUE;

            isDepartmentDisabled = Boolean.TRUE;
            isClassDisable = Boolean.TRUE;
            isSubClassDisable = Boolean.TRUE;
            isVPNDisable = Boolean.TRUE;
            isVpnColourDisable = Boolean.TRUE;
            isSKUDisable = Boolean.TRUE;

            isRegionDisabled = Boolean.TRUE;
            isStoreDisabled = Boolean.TRUE;
            isWarehouseDisabled = Boolean.TRUE;

            saveDisabled = Boolean.FALSE;
        } catch (Exception exp) {
            _logger.log("Exception occured in disableCompsOnSearch " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Method will disable the components based
     * on the selection of working level type
     * @param Working Level Type
     */

    public void disableOnLevelType(String workingLevel) {
        try {
            _logger.info("Entering  disableAttrsMethod()");
            if (workingLevel != null && workingLevel.equalsIgnoreCase(Constants.WORKING_INFO_ITEM)) {
                isDepartmentDisabled = Boolean.FALSE;
                isRegionDisabled = Boolean.TRUE;
                isStoreDisabled = Boolean.TRUE;
                isWarehouseDisabled = Boolean.TRUE;
            } else if (workingLevel != null && workingLevel.equalsIgnoreCase(Constants.WORKING_INFO_STORE)) {
                isRegionDisabled = Boolean.FALSE;
                isStoreDisabled = Boolean.FALSE;
                isWarehouseDisabled = Boolean.TRUE;
            } else if (workingLevel != null && workingLevel.equalsIgnoreCase(Constants.WORKING_INFO_WAREHOUSE)) {
                isWarehouseDisabled = Boolean.FALSE;
                isStoreDisabled = Boolean.TRUE;
                isRegionDisabled = Boolean.TRUE;
            }
            if (workingLevel != null &&
                (workingLevel.equalsIgnoreCase(Constants.WORKING_INFO_STORE) ||
                 workingLevel.equalsIgnoreCase(Constants.WORKING_INFO_WAREHOUSE))) {
                isDepartmentDisabled = Boolean.TRUE;
                isClassDisable = Boolean.TRUE;
                isSubClassDisable = Boolean.TRUE;
                isVPNDisable = Boolean.TRUE;
                isVpnColourDisable = Boolean.TRUE;
                isSKUDisable = Boolean.TRUE;
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in disableOnLevelType " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Disable or enable all the components
     * @param null
     */

    public void disableAllComponents() {
        try {
            isDepartmentDisabled = Boolean.TRUE;
            isClassDisable = Boolean.TRUE;
            isSubClassDisable = Boolean.TRUE;
            isVPNDisable = Boolean.TRUE;
            isVpnColourDisable = Boolean.TRUE;
            isSKUDisable = Boolean.TRUE;
            isRegionDisabled = Boolean.TRUE;
            isStoreDisabled = Boolean.TRUE;
            isWarehouseDisabled = Boolean.TRUE;

            isListNameDisabled = Boolean.FALSE;
            isPrivacyDisabled = Boolean.FALSE;
            isWorkingLevelDisabled = Boolean.FALSE;
        } catch (Exception exp) {
            _logger.log("Exception occured in disableCompsOnSearch " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Clear all the values of all the components
     * @param null
     */

    public void clearAllComponents() {
        try {
            deptId = null;
            classId = null;
            subclassId = null;
            vpnIdVal = null;
            vpnColourIdVal = null;
            skuIdVal = null;
            vpnColourCodeVal = null;
            vpnCodeVal = null;
            skuCodeVal = null;

            AipdtUIUtil.setValueToEL(Constants.LIST_NAME_INPUT_VAL_EL, null);
            AipdtUIUtil.setValueToEL(Constants.LIST_PRIVACY_INPUT_VAL_EL, null);
            AipdtUIUtil.setValueToEL(Constants.REGION_CODE_INPUT_VAL_EL, null);

            listNameBind.setValue(null);
            listNameBind.setSubmittedValue(null);
            listPrivacyBind.setValue(null);
            listPrivacyBind.setSubmittedValue(null);
            regionCompBind.setValue(null);
            regionCompBind.setSubmittedValue(null);

            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());

            AdfFacesContext.getCurrentInstance().addPartialTarget(listNameBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(listPrivacyBind);
            AdfFacesContext.getCurrentInstance().addPartialTarget(regionCompBind);

            multiSelectBaseFieldsBean.getDepartmentComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getStockingPointComp().resetDeclarativeComponent();

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getDepartmentComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStockingPointComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());

            ResetUtils.reset(multiSelectBaseFieldsBean.getDepartmentComp());
        } catch (Exception exp) {
            _logger.log("Exception occured in clearAllComponents " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     *Validating the inputs based on the user search criteria
     * @param null
     */

    public boolean validateInputs() {
        boolean validateCheck = Boolean.TRUE;
        String workingInfo = null;
        try {
            _logger.info("Entering  validateInputs()");
            workingLevelBind.processUpdates(FacesContext.getCurrentInstance());
            if (AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL) == null) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.LIST_TYPE_CAN_NOT_BE_NULL), null);
                validateCheck = Boolean.FALSE;
                return validateCheck;
            }
            if (listNameBind.getValue() == null) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.LIST_NAME_CAN_NOT_BE_NULL), null);
                validateCheck = Boolean.FALSE;
                return validateCheck;
            }

            if (listNameBind.getValue() != null) {
                OperationBinding validateListNameDuplicate =
                    AipdtUIUtil.getBindings().getOperationBinding(Constants.VALIDATE_LIST_NAME_DUPLICATE_OPERBIND);
                validateCheck = Boolean.valueOf(validateListNameDuplicate.execute().toString());
                if (!validateCheck) {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.DUPLICATE_LIST_NAME), null);
                    return validateCheck;
                }
            }
            // Need to be added in future - Privacy -- Commented by Arun
            //            if (getListPrivacyBind().getValue() == null || getListPrivacyBind().getValue().equals("")) {
            //                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.LIST_PRIVACY_CAN_NOT_BE_NULL),
            //                                             null);
            //                validateCheck = Boolean.FALSE;
            //                return validateCheck;
            //            }

            if (validateCheck) {
                workingInfo = AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL).toString();
                if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_ITEM)) {
                    Object departValue = multiSelectBaseFieldsBean.getDepartmentComp().getValueInputText().getValue();
                    if (departValue == null) {
                        AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.DEPARTMENT_CAN_NOT_NULL),
                                                     null);
                        validateCheck = Boolean.FALSE;
                        return validateCheck;
                    }
                    if (vpnCodeVal == null) {
                        AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.VPN_CAN_NOT_BE_NULL), null);
                        validateCheck = Boolean.FALSE;
                        return validateCheck;
                    }
                } else if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_STORE)) {
                    Object storeValue = multiSelectBaseFieldsBean.getStoreComp().getValueInputText().getValue();
                    if (storeValue == null) {
                        AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.RC_STORE_REQUIRED), null);
                        validateCheck = Boolean.FALSE;
                        return validateCheck;
                    }
                } else if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_WAREHOUSE)) {
                    Object warehouseValue =
                        multiSelectBaseFieldsBean.getStockingPointComp().getValueInputText().getValue();
                    if (warehouseValue == null) {
                        AipdtUIUtil.showErrorMessage(AipdtUIUtil.getUIBundleValue(Constants.RC_WAREHOUSE_REQUIRED),
                                                     null);
                        validateCheck = Boolean.FALSE;
                        return validateCheck;
                    }
                }
            }
        } catch (Exception exp) {
            _logger.log("Exception occured in validateInputs " + exp);
            showCommonErrorMessage();
        }
        return validateCheck;
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
            Object selectedListValue = null;
            String workingInfo = null;
            Object returnValue = null;
            if (proceed) {
                disableCompsOnSearch();
                workingInfo = AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL).toString();

                if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_ITEM)) {
                    selectedListValue = this.multiSelectBaseFieldsBean.getItemComp().getItemCompValue();
                    if (skuCodeVal != null) {
                        selectedListValue = skuCodeVal;
                    } else if (vpnColourCodeVal != null) {
                        selectedListValue = vpnColourCodeVal;
                    } else if (vpnCodeVal != null) {
                        selectedListValue = vpnCodeVal;
                    }

                } else if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_STORE)) {
                    selectedListValue = multiSelectBaseFieldsBean.getStoreComp().getValueInputText().getValue();
                } else if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_WAREHOUSE)) {
                    selectedListValue = multiSelectBaseFieldsBean.getStockingPointComp().getValueInputText().getValue();
                }
                if (selectedListValue != null) {
                    OperationBinding op =
                        BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.CREATE_SEARCH_LIST_RESULT_OPERBIND);
                    op.getParamsMap().put(Constants.LEVEL_TYPE_OPERMAP, workingInfo);
                    op.getParamsMap().put(Constants.SELCTED_CODE_OPERMAP, selectedListValue.toString());
                    returnValue = op.execute();

                    if (returnValue != null) {
                        AipdtUIUtil.showErrorMessage(returnValue.toString(), null);
                        isSearchBtnDisabled = Boolean.FALSE;
                        disableAllComponents();
                        AipdtUIUtil.setValueToEL(Constants.WORK_LEVEL_INPUT_VALUE_EL, null);
                        workingLevelBind.setValue(null);
                        workingLevelBind.resetValue();
                        workingLevelBind.setSubmittedValue(null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(workingLevelBind);
                        clearAllComponents();
                        OperationBinding resetOperation =
                            BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.ON_CLICK_RESET_ACTION_OPERBIND);
                        resetOperation.execute();
                    }
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
     * Invoked on the value change of Store
     * @param valueChangeEvent
     */

    public void onStoreChange(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onStoreChange()" + valueChangeEvent.getComponent());
            multiSelectBaseFieldsBean.getStoreComp().getValueInputText().getValue();
        } catch (Exception exp) {
            _logger.log("Exception occured in onStoreChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of Region
     * @param valueChangeEvent
     */

    @SuppressWarnings("unchecked")
    public void onRegionChange(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onRegionChange()" + valueChangeEvent.getComponent());
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
            OperationBinding op =
                BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.FILTER_STOREVO_OPERBIND);
            regionCompBind.processUpdates(FacesContext.getCurrentInstance());
            op.getParamsMap().put(Constants.REGION_ID_VC_REFERENCE, null);
            op.execute();
        } catch (Exception exp) {
            _logger.log("Exception occured in onRegionChange " + exp);
            showCommonErrorMessage();
        }
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
        try {
            Object selectedListValue = null;
            String workingInfo = AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL).toString();

            if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_ITEM)) {
                if (skuCodeVal != null) {
                    selectedListValue = skuCodeVal;
                } else if (vpnColourCodeVal != null) {
                    selectedListValue = vpnColourCodeVal;
                } else if (vpnCodeVal != null) {
                    selectedListValue = vpnCodeVal;
                }

            } else if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_STORE)) {
                selectedListValue = multiSelectBaseFieldsBean.getStoreComp().getValueInputText().getValue();
            } else if (workingInfo != null && workingInfo.equalsIgnoreCase(Constants.WORKING_INFO_WAREHOUSE)) {
                selectedListValue = multiSelectBaseFieldsBean.getStockingPointComp().getValueInputText().getValue();
            }
            OperationBinding saveOp =
                AipdtUIUtil.getBindings().getOperationBinding(Constants.SAVE_CREATE_LIST_OPERBIND);
            saveOp.getParamsMap().put(Constants.SELECTED_VALUES_OPERMAP, selectedListValue);
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
     * Invoked when Cancel button is clicked, which triggers the cancel confirmation popup
     * @return
     */
    public String handleCancelSupplyChainList() {
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
     * Invoked when user selects 'Yes' from the Cancel confirmation popup
     * @param actionEvent
     */
    public void cancelYesListener(ActionEvent actionEvent) {
        _logger.info("****** Inside cancelYesListener method ******");
        try {
            String compId = actionEvent.getComponent().getId();
            if (compId != null && compId.equalsIgnoreCase(Constants.CANCEL_YES_BTN)) {
                AipdtUIUtil.invokeAction(Constants.CANCEL);
            } else if (compId != null && compId.equalsIgnoreCase(Constants.RESET_YES_BTN)) {
                isSearchBtnDisabled = Boolean.TRUE;
                disableAllComponents();
                AipdtUIUtil.setValueToEL(Constants.WORK_LEVEL_INPUT_VALUE_EL, null);
                workingLevelBind.setValue(null);
                workingLevelBind.resetValue();
                workingLevelBind.setSubmittedValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(workingLevelBind);
                AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtnBind);
                clearAllComponents();
                OperationBinding op =
                    BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.ON_CLICK_RESET_ACTION_OPERBIND);
                op.execute();
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
            AipdtUIUtil.setValueToEL(Constants.WORK_LEVEL_INPUT_VALUE_EL, null);
            workingLevelBind.setValue(null);
            workingLevelBind.resetValue();
            workingLevelBind.setSubmittedValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(workingLevelBind);
            clearAllComponents();
            OperationBinding op =
                BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding(Constants.ON_CLICK_RESET_ACTION_OPERBIND);
            op.execute();
            isSearchBtnDisabled = Boolean.TRUE;
            saveDisabled = Boolean.TRUE;
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
     * Invoked on the value change of warehouse
     * @param valueChangeEvent
     */

    public void onWarehouseChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("****** Inside onWarehouseChange method ******" + valueChangeEvent.getComponent());
        try {
            multiSelectBaseFieldsBean.getStockingPointComp().getValueInputText().getValue();
        } catch (Exception exp) {
            _logger.log("Exception occured in onWarehouseChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of Department
     * @param valueChangeEvent
     */

    public void onDepartmentChange(ValueChangeEvent valueChangeEvent) {
        String workingInfo = null;
        Object departmentValues = null;
        try {
            workingLevelBind.processUpdates(FacesContext.getCurrentInstance());
            if (AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL) != null) {
                workingInfo = AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL).toString();
                disableOnLevelType(workingInfo);
            }
            if (valueChangeEvent.getNewValue() != null) {
                isClassDisable = Boolean.FALSE;
                isSubClassDisable = Boolean.FALSE;
                isVPNDisable = Boolean.FALSE;
            } else {
                disableOnLevelType(workingInfo);
            }

            if (valueChangeEvent.getNewValue() != null) {
                departmentValues = valueChangeEvent.getNewValue();
                if (departmentValues != null) {
                    deptId = departmentValues.toString();
                    filterClassComponent();
                    filterSubClassComponent();
                    filterVPNComponent();
                    filterVPNColourComponent();
                    filterSkuComponent();

                    classId = null;
                    subclassId = null;
                    vpnColourIdVal = null;
                    vpnIdVal = null;
                    skuIdVal = null;
                }
            } else {
                deptId = null;
                multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getClassComp());
                multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getSubClassComp());
                multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getSubClassComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());
            }
            isVpnColourDisable = Boolean.TRUE;
            isSKUDisable = Boolean.TRUE;
            setDepartmentIdOnShuttleComponent();
        } catch (Exception exp) {
            _logger.log("Exception occured in onDepartmentChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of Class
     * @param valueChangeEvent
     */

    public void onClassChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("****** Inside onClassChange method ******" + valueChangeEvent.getComponent());
        try {
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
            isVpnColourDisable = Boolean.TRUE;
            isSKUDisable = Boolean.TRUE;
        } catch (Exception exp) {
            _logger.log("Exception occured in onClassChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of Subclass
     * @param valueChangeEvent
     */

    public void onSubClassChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("****** Inside onSubClassChange method ******" + valueChangeEvent.getComponent());
        try {
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
            isVpnColourDisable = Boolean.TRUE;
            isSKUDisable = Boolean.TRUE;
        } catch (Exception exp) {
            _logger.log("Exception occured in onSubClassChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of VPN
     * @param null
     */

    public void onVPNVChange() {
        _logger.info("****** Inside onVPNVChange method ******");
        try {
            _logger.info("Entering  onVpnChange()");
            String vpnCode = null;
            String newValue = this.getMultiSelectBaseFieldsBean().getVpnComp().getSelectedValues();
            vpnCodeVal = newValue;
            AipdtUIUtil.getCurrentRowFromIterator(Constants.SUPPLY_LIST_SEARCH_PROGVO_ITER).setAttribute(Constants.VPN_CODE_ATTR,
                                                                                                         newValue);
            _logger.info("VPN newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                isVpnColourDisable = Boolean.FALSE;
                isSKUDisable = Boolean.FALSE;
                vpnCode = newValue;
                vpnColourIdVal = null;
                skuIdVal = null;
            } else {
                vpnCode = null;
                isVpnColourDisable = Boolean.TRUE;
                isSKUDisable = Boolean.TRUE;
            }
            vpnIdVal = this.getMultiSelectBaseFieldsBean().getVpnComp().getIdValueFromCode();

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStockingPointComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
            filterVPNColourComponent();
            filterSkuComponent();
        } catch (Exception exp) {
            _logger.log("Exception occured in onVPNVChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of VPN color
     * @param null
     */

    public void onVPNColorChange() {
        _logger.info("****** Inside onVPNColorChange method ******");
        try {
            _logger.info("Entering  onStyleColourChange()");
            String vpnCode = null;
            String newValue = this.getMultiSelectBaseFieldsBean().getStyleColourComp().getSelectedValues();
            vpnColourCodeVal = newValue;
            AipdtUIUtil.getCurrentRowFromIterator(Constants.SUPPLY_LIST_SEARCH_PROGVO_ITER).setAttribute(Constants.VPN_COLORCODE_ATTR,
                                                                                                         newValue);
            if (newValue != null && !newValue.isEmpty()) {
                vpnCode = newValue;
                skuIdVal = null;
            } else {
                vpnCode = null;
            }
            vpnColourIdVal = this.getMultiSelectBaseFieldsBean().getStyleColourComp().getIdValueFromCode();
            filterSkuComponent();
            _logger.info("onStyleColourChange newValue :" + vpnCode);
        } catch (Exception exp) {
            _logger.log("Exception occured in onVPNColorChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of SKU(ITEM)
     * @param null
     */

    public void onSKUCodeChange() {
        _logger.info("****** Inside onSKUCodeChange method ******");
        try {
            String newValue = this.getMultiSelectBaseFieldsBean().getItemComp().getSelectedValues();
            skuCodeVal = newValue;
            AipdtUIUtil.getCurrentRowFromIterator(Constants.SUPPLY_LIST_SEARCH_PROGVO_ITER).setAttribute(Constants.SKU_CODE_ATTR,
                                                                                                         newValue);
            skuIdVal = this.getMultiSelectBaseFieldsBean().getItemComp().getIdValueFromCode();
            String skuCode = null;
            if (newValue != null && !newValue.isEmpty()) {
                skuCode = newValue;
            } else {
                skuCode = null;
            }
            _logger.info("Item newValue :" + skuCode);
        } catch (Exception exp) {
            _logger.log("Exception occured in onSKUCodeChange " + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked on the value change of Store
     * @param valueChangeEvent
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
        } catch (Exception exp) {
            _logger.log("Exception occured in setDepartmentIdOnShuttleComponent " + exp);
            showCommonErrorMessage();
        }

    }

    /**
     * This method filters Class component based on DepartmentId value selected.
     */

    private void filterClassComponent() {
        _logger.info("Entering  filterClassComponent()");
        try {

            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getClassComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            classId = null;
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("ClassIdAttr", "DeparmentId", deptId, null,
                                                                          null);

            /* Object oldInputTextValue = multiSelectBaseFieldsBean.getClassComp().getValueInputText().getValue();
            String classCode =
                multiSelectBaseFieldsBean.filterDependantLOV("ClassIdAttr", "ClassCode", "DeparmentId", deptId,
                                                             oldInputTextValue, null, null);
            multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getClassComp().getValueInputText().setValue(classCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            classId = multiSelectBaseFieldsBean.getClassComp().getIdValueFromCode("ClassIdAttr", classCode);
            */
        } catch (Exception exp) {
            _logger.info("Exception occured at filterClassComponent()" + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * This method filters SubClass component based on DepartmentId and ClassId value selected.
     */

    private void filterSubClassComponent() {
        _logger.info("Entering  filterSubClassComponent()");
        try {
            subclassId = null;
            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getSubClassComp());
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("SubClassIdAttr", "ClassId", classId,
                                                                          "DepartmentId", deptId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            /* Object oldInputTextValue = multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().getValue();
            String subClassCode =
                multiSelectBaseFieldsBean.filterDependantLOV("SubClassIdAttr", "SubclassCode", "ClassId", classId,
                                                             oldInputTextValue, "DepartmentId", deptId);
            multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().setValue(subClassCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            subclassId = multiSelectBaseFieldsBean.getSubClassComp().getIdValueFromCode("SubClassIdAttr", subClassCode);
           */
        } catch (Exception exp) {
            _logger.info("Exception occured at filterSubClassComponent()" + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * This method filters Item Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle
     * component which is correspondence to selected department.
     */

    private void filterSkuComponent() {
        _logger.info("Entering  filterSkuComponent()");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, vpnColourIdVal,
                                                                       multiSelectBaseFieldsBean.getItemComp());
            skuIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
            /*String codeVal = null;
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, vpnColourIdVal,
                                                                       multiSelectBaseFieldsBean.getItemComp());
            codeVal =
                multiSelectBaseFieldsBean.executeMultiShuttleForItem(deptId, "SKUCodeAttr", "DepartmentId",
                                                                     "CommodityCode");
            multiSelectBaseFieldsBean.getItemComp().getValueInputText().setValue(codeVal);
            skuIdVal =
                multiSelectBaseFieldsBean.getShuttleComponentIdValue("SKUCodeAttr", "CommodityId", "CommodityCode",
                                                                     "ITEM");
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
            */
        } catch (Exception exp) {
            _logger.info("Exception occured at filterSkuComponent()" + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * This method filters VPN Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle
     * component which is correspondence to selected department.
     */

    private void filterVPNComponent() {
        _logger.info("Entering  filterVPNComponent()");

        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, null, null,
                                                                       multiSelectBaseFieldsBean.getVpnComp());
            vpnIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
            /*
            * String vpnCodeVal = null;
            * multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, null, null,
                                                                       multiSelectBaseFieldsBean.getVpnComp());
            vpnCodeVal =
                multiSelectBaseFieldsBean.executeMultiShuttleForVPN(deptId, "VPN", "DepartmentId", "StyleCode");
            multiSelectBaseFieldsBean.getVpnComp().getValueInputText().setValue(vpnCodeVal);

            vpnIdVal = multiSelectBaseFieldsBean.getShuttleComponentIdValue("VPN", "StyleId", "StyleCode", "VPN");

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
            */
        } catch (Exception exp) {
            _logger.info("Exception occured at filterVPNComponent()" + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * This method filters VPN/StyleColour Shuttle component based on DepartmentId value selected and sets the value to
     * ItemShuttle component which is correspondence to selected department.
     */

    private void filterVPNColourComponent() {
        _logger.info("Entering  filterVPNColourComponent()");

        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, null,
                                                                       multiSelectBaseFieldsBean.getStyleColourComp());
            vpnColourIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());

            /*String vpnColourCode = null;
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, null,
                                                                       multiSelectBaseFieldsBean.getStyleColourComp());
            vpnColourCode =
                multiSelectBaseFieldsBean.executeMultiShuttleForVPNColor(deptId, "VPNOrColorCodeAttr", "DepartmentId",
                                                                         "StyleColorCode");
            multiSelectBaseFieldsBean.getStyleColourComp().getValueInputText().setValue(vpnColourCode);

            vpnColourIdVal =
                multiSelectBaseFieldsBean.getShuttleComponentIdValue("VPNOrColorCodeAttr", "StyleColorId",
                                                                     "StyleColorCode", "VPN_COLOR");

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
            */
        } catch (Exception exp) {
            _logger.info("Exception occured at filterVPNColourComponent()" + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when the List Name Value changed
     * @param valueChangeEvent
     */

    public void onListNameChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("Entering  onListNameChange()" + valueChangeEvent.getComponent());
        try {
            if (valueChangeEvent.getNewValue() == null || "".equals(valueChangeEvent.getNewValue()) ||
                /* Commented by Arun - Need to be added in future*/
                //AipdtUIUtil.resolveExpression(Constants.LIST_PRIVACY_ATTR_VAL_EL) == null ||
                AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL) == null) {
                isSearchBtnDisabled = Boolean.TRUE;
            } else {
                isSearchBtnDisabled = Boolean.FALSE;
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtnBind);
        } catch (Exception exp) {
            _logger.info("Exception occured at onListNameChange()" + exp);
            showCommonErrorMessage();
        }
    }

    /**
     * Invoked when the List Privacy Value changed
     * @param valueChangeEvent
     */

    public void onListPrivacyChange(ValueChangeEvent valueChangeEvent) {
        _logger.info("Entering  onListPrivacyChange()" + valueChangeEvent.getComponent());
        try {
            /* Commented by Arun - Need to be added in future*/
            //            listPrivacyBind.processUpdates(FacesContext.getCurrentInstance());
            //        if (AipdtUIUtil.resolveExpression(Constants.WORK_LEVEL_ATTR_VAL_EL) == null || getListNameBind() == null ||
            //            AipdtUIUtil.resolveExpression(Constants.LIST_PRIVACY_ATTR_VAL_EL) == null) {
            //            isSearchBtnDisabled = Boolean.TRUE;
            //        } else {
            //            isSearchBtnDisabled = Boolean.FALSE;
            //        }
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtnBind);
        } catch (Exception exp) {
            _logger.info("Exception occured at onListPrivacyChange()" + exp);
            showCommonErrorMessage();
        }
    }

}
