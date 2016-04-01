package oracle.retail.apps.aipdt.np.publicui.bean;

import com.oracle.retail.apps.comp.ms.view.SelectManyInputCheckBox;

import java.util.HashMap;
import java.util.List;
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
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.export.ExportContext;
import oracle.adf.view.rich.export.FormatHandler;
import oracle.adf.view.rich.model.AttributeCriterion;
import oracle.adf.view.rich.model.ConjunctionCriterion;
import oracle.adf.view.rich.model.Criterion;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.common.publicui.bean.BaseRetailBean;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.np.model.applicationmodule.common.NetworkPathAM;
import oracle.retail.apps.aipdt.np.model.view.NetworkPathResultsVORowImpl;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

import org.apache.myfaces.trinidad.util.ComponentReference;

/**
 * Managed bean for Network Path Functionality. Holds the UI Component bindings and properties, even listener methods and
 * executes the business logic by invoking the AM methods exposed.
 */
public class NetworkPathBean extends BaseRetailBean {
    @SuppressWarnings("compatibility:-4318371811831539215")
    private static final long serialVersionUID = 5329326921579557849L;
    private boolean saveDisabled = true;
    private ComponentReference<RichPopup> savePopup;
    private ComponentReference<RichPopup> saveClosePopup;
    private ComponentReference<RichPopup> cancelPopup;
    private ComponentReference<RichPopup> resetPopup;
    private ComponentReference<RichPopup> saveSuccessPopup;
    private ComponentReference<RichPopup> saveCloseSuccessPopup;
    private ComponentReference<RichSelectOneChoice> srcWhTypeComp;
    private ComponentReference<SelectManyInputCheckBox> srcWarehouseComp;
    private ComponentReference<SelectManyInputCheckBox> storeComp;
    private ComponentReference<SelectManyInputCheckBox> dstWarehouseComp;
    private long numberOfResultRecords;

    private final static ADFLogger logger = ADFLogger.createADFLogger(NetworkPathBean.class);
    private ComponentReference<RichPanelGroupLayout> resultsArea;
    private ComponentReference<RichTable> resultsTableComp;
    private ComponentReference<RichSelectBooleanCheckbox> checkBoxAllComp;

    private String srcWhType;
    private String sourceId;
    private String dstStoreId;
    private String dstWarehouseId;
    private HashMap<String, Object> setAllMap = new HashMap<String, Object>();
    private boolean srcWhDisable = true;
    private boolean dstStoreDisable;
    private boolean dstWhDisable = true;
    private String dstWhEnableFlag;
    private ComponentReference<RichInputDate> setAllEffDateComp;
    private ComponentReference<RichInputText> setAllSunLDComp;
    private ComponentReference<RichInputText> setAllMonLDComp;
    private ComponentReference<RichInputText> setAllTueLDComp;
    private ComponentReference<RichInputText> setAllWedLDComp;
    private ComponentReference<RichInputText> setAllThuLDComp;
    private ComponentReference<RichInputText> setAllFriLDComp;
    private ComponentReference<RichInputText> setAllSatLDComp;
    private ComponentReference<RichButton> searchComp;

    public NetworkPathBean() {
        dstWhEnableFlag = (String) ADFContext.getCurrent().getPageFlowScope().get(Constants.NP_DST_RS_WH_ENABLE);
        if ((dstWhEnableFlag == null) || Constants.NO.equals(dstWhEnableFlag)) {
            dstWhDisable = true;
        } else {
            dstWhDisable = false;
        }
    }

    /**
     * Invoked when source warehouse is changed
     * @param valueChangeEvent
     */
    public void onSourceWarehouseChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onSourceWarehouseChange method ******");
        String inputSrcWhValue = (String) valueChangeEvent.getNewValue();
        logger.info("Source Warehouses Selected : " + inputSrcWhValue);
        sourceId = inputSrcWhValue;
        //Search Button Enable
        if (getSearchComp() != null) {
            getSearchComp().setDisabled(!isInputValid());
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchComp());
        }
    }

    public boolean isSaveDisabled() {
        return saveDisabled;
    }

    /**
     * Invoked when Cancel button is clicked, which triggers the cancel confirmation popup
     * @return
     */
    public String cancelNetworkPath() {
        logger.info("****** Inside cancelNetworkPath method ******");
        if (getCancelPopup() != null) {
            ADFFacesUtil.showPopup(getCancelPopup().getClientId(FacesContext.getCurrentInstance()));
        }
        return null;
    }

    /**
     * Invoked when SaveAndClose button is clicked, which triggers the SaveAndClose confirmation popup
     * @return
     */
    public String saveAndCloseNetworkPath() {
        logger.info("****** Inside saveAndCloseNetworkPath method ******");
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
     * Invoked when Save button is clicked, which triggers the Save confirmation popup
     * @param actionEvent
     */
    public void saveNetworkPath(ActionEvent actionEvent) {
        logger.info("****** Inside saveNetworkPath method ******");
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
     * Invoked when source warehouse type is changed
     * @param valueChangeEvent
     */
    public void onSourceWhTypeChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onSourceWhTypeChange method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        Map map = ((UIComponent) valueChangeEvent.getSource()).getAttributes();
        srcWhType = (String) map.get("srcWhTypeVal");
        logger.info("Source Warehouse Type Selected : " + srcWhType);

        if (getSrcWarehouseComp() != null) {
            if (!StringUtil.isNullOrEmpty(srcWhType)) {
                getSrcWarehouseComp().resetDeclarativeComponent();
                setSrcWhDisable(false);
                refreshWarehouses(srcWhType, "SrcWarehouse");
            } else {
                getSrcWarehouseComp().resetDeclarativeComponent();
                setSrcWhDisable(true);
            }
            sourceId = null;
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSrcWarehouseComp());
        }
        //Disable destination warehouse when source is cross dock
        if (getDstWarehouseComp() != null) {
            if (Constants.LOC_TYPE_CROSSDOCK.equals(srcWhType)) {
                getDstWarehouseComp().resetDeclarativeComponent();
                setDstWhDisable(true);
            } else {
                getDstWarehouseComp().resetDeclarativeComponent();
                setDstWhDisable(false);
            }
            dstWarehouseId = null;
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDstWarehouseComp());
            if (getStoreComp() != null) {
                setDstStoreDisable(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreComp());
            }
        }
        //Search Button Enable
        if (getSearchComp() != null) {
            getSearchComp().setDisabled(!isInputValid());
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchComp());
        }
    }

    /**
     * Helper method to repopulate the LOV with specific warehouses for the selected warehouse type
     * @param whType
     */
    private void refreshWarehouses(String whType, String attrFieldBinding) {
        logger.info("****** Inside refreshWarehouses method ******");
        String vcName = null;
        String bindWarehouseTypeValue = null;
        if (Constants.LOC_TYPE_CROSSDOCK.equals(whType)) {
            vcName = "StockingPointXDVC";
            bindWarehouseTypeValue = Constants.CROSSDOCK_CODE;
        } else if (Constants.LOC_TYPE_RESERVED_STOCK.equals(whType)) {
            vcName = "StockingPointRSVC";
            bindWarehouseTypeValue = Constants.RESERVED_STOCK_CODE;
        } else {
            vcName = null;
            bindWarehouseTypeValue = null;
        }
        ViewObjectImpl spVO = AipdtUIUtil.getViewObjectByAttrFieldBinding(attrFieldBinding);
        spVO.setApplyViewCriteriaName(null);
        spVO.setApplyViewCriteriaName(vcName);
        spVO.setNamedWhereClauseParam("bindWarehouseType", bindWarehouseTypeValue);
        logger.info("Repopulating Warehouse LOV by executing query : " + spVO.getQuery());
        spVO.executeQuery();
    }

    /**
     * Invoked when select button is clicked from the search area
     * @param actionEvent
     */
    public void handleSelectButtonClick(ActionEvent actionEvent) {
        logger.info("****** Inside handleSelectButtonClick method ******");
        boolean isValid = false;
        try {
            isValid = validateInput();
            if (isValid) {
                //Search Button Enable
                if (getSearchComp() != null) {
                    getSearchComp().setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchComp());
                }
                disableAll();
                NetworkPathAM npAM =
                    (NetworkPathAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.NETWORK_PATH_AM);
                boolean selectValid = npAM.handleSelect();
                if (!selectValid) {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                    Constants.INVALID_SEARCH_CRITERIA),
                                                 null);
                    return;
                }
                if (getNumberOfResultRecords() > 0) {
                    setSaveDisabled(false);
                    if (getCheckBoxAllComp() != null) {
                        getCheckBoxAllComp().resetValue();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
                    }
                    if (getResultsArea() != null) {
                        getResultsArea().setVisible(true);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsArea());
                    }
                }
            } else {
                logger.severe("One or more search fields are not valid.");
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
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("NetworkPathResultsVO1Iterator");
        if (dcItteratorBindings != null) {
            numberOfResultRecords = dcItteratorBindings.getEstimatedRowCount();
        }
        logger.info("Results Record Count :" + numberOfResultRecords);
        return numberOfResultRecords;
    }

    /**
     * Helper method to validate the search criteria input passed
     * @return
     */
    private boolean validateInput() {
        logger.info("****** Inside validateInput method ******");
        boolean isValidInput = true;
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("NetworkPathSearchVO1Iterator");
        if (dcItteratorBindings != null) {
            Row currentRow = dcItteratorBindings.getCurrentRow();
            currentRow.setAttribute("SrcWarehouse", sourceId);
            if (StringUtil.isNullOrEmpty(dstWarehouseId)) {
                currentRow.setAttribute("Store", dstStoreId);
            } else {
                currentRow.setAttribute("DstWarehouse", dstWarehouseId);
            }

            boolean isSrcWhTypeValid = false;
            if (getSrcWhTypeComp() != null) {
                isSrcWhTypeValid =
                    getSrcWhTypeComp().isDisabled() ||
                    !StringUtil.isNullOrEmpty((String) currentRow.getAttribute("SrcWhType"));
            }
            boolean isSrcWarehouseValid = false;
            if (getSrcWarehouseComp() != null) {
                isSrcWarehouseValid =
                    isSrcWhDisable() || !StringUtil.isNullOrEmpty((String) currentRow.getAttribute("SrcWarehouse"));
            }
            boolean isStoreValid = false;
            if (getStoreComp() != null) {
                isStoreValid =
                    isDstStoreDisable() || !StringUtil.isNullOrEmpty((String) currentRow.getAttribute("Store"));
            }
            boolean isDstWarehouseValid = false;
            if (getDstWarehouseComp() != null) {
                isDstWarehouseValid =
                    isDstWhDisable() || !StringUtil.isNullOrEmpty((String) currentRow.getAttribute("SrcWarehouse"));
            }
            if (!isSrcWhTypeValid) {
                isValidInput = false;
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.NP_WH_TYPE_REQUIRED),
                                             getSrcWhTypeComp());
            } else if (!isSrcWarehouseValid) {
                isValidInput = false;
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.RC_WAREHOUSE_REQUIRED),
                                             (getSrcWarehouseComp() != null) ?
                                             getSrcWarehouseComp().getValueInputText() : null);
            } else if (!isStoreValid) {
                isValidInput = false;
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.RC_STORE_REQUIRED),
                                             (getStoreComp() != null) ? getStoreComp().getValueInputText() : null);
            } else if (!isDstWarehouseValid) {
                isValidInput = false;
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.RC_WAREHOUSE_REQUIRED),
                                             (getDstWarehouseComp() != null) ?
                                             getDstWarehouseComp().getValueInputText() : null);
            }
        }
        return isValidInput;
    }

    /**
     * Invoked when reset button is clicked from the search area
     * @param actionEvent
     */
    public void handleResetButtonClick(ActionEvent actionEvent) {
        logger.info("****** Inside handleResetButtonClick method ******");
        if (getResetPopup() != null) {
            ADFFacesUtil.showPopup(getResetPopup().getClientId(FacesContext.getCurrentInstance()));
        }
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

    /**
     * Invoked when user selects 'Yes' from the Save confirmation popup
     * @param actionEvent
     */
    public void handleSaveYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveYes method ******");
        try {
            NetworkPathAM npAM = (NetworkPathAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.NETWORK_PATH_AM);
            npAM.saveNetworkPath();
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
        this.saveClosePopup = ComponentReference.newUIComponentReference(saveClosePopup);
    }

    public RichPopup getSaveClosePopup() {
        if (saveClosePopup != null) {
            return saveClosePopup.getComponent();
        }
        return null;
    }

    /**
     * Invoked when user selects 'Yes' from the SaveAndClose confirmation popup
     * @param actionEvent
     */
    public void handleSaveCloseYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveCloseYes method ******");
        try {
            NetworkPathAM npAM = (NetworkPathAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.NETWORK_PATH_AM);
            npAM.saveNetworkPath();
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

    public void setCancelPopup(RichPopup cancelPopup) {
        this.cancelPopup = ComponentReference.newUIComponentReference(cancelPopup);
    }

    public RichPopup getCancelPopup() {
        if (cancelPopup != null) {
            return cancelPopup.getComponent();
        }
        return null;
    }

    /**
     * Invoked when user selects 'Yes' from the Cancel confirmation popup
     * @param actionEvent
     */
    public void handleCancelYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleCancelYes method ******");
        AipdtUIUtil.invokeAction(Constants.CANCEL);
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

    /**
     * Invoked when user selects 'Yes' from the Reset confirmation popup
     * @param actionEvent
     */
    public void handleResetYes(ActionEvent actionEvent) {
        logger.info("****** Inside handleResetYes method ******");
        try {
            resetAll();
            NetworkPathAM npAM = (NetworkPathAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.NETWORK_PATH_AM);
            npAM.handleReset();
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

    /**
     * Invoked when user selects 'Ok' from the SaveAndClose Success confirmation popup, which closes the tab.
     * @param actionEvent
     */
    public void handleSaveCloseOk(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveCloseOk method ******");
        AipdtUIUtil.invokeAction(Constants.CLOSE_CONTENT);
    }

    /**
     * Resets all the components in the search area
     */
    private void resetAll() {
        logger.info("****** Inside resetAll method ******");

        sourceId = null;
        dstStoreId = null;
        dstWarehouseId = null;
        setAllMap.clear();

        if (getSrcWhTypeComp() != null) {
            getSrcWhTypeComp().resetValue();
            getSrcWhTypeComp().setValue(null);
            getSrcWhTypeComp().setDisabled(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSrcWhTypeComp());
        }
        if (getSrcWarehouseComp() != null) {
            getSrcWarehouseComp().resetDeclarativeComponent();
            setSrcWhDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSrcWarehouseComp());
        }

        if (getStoreComp() != null) {
            getStoreComp().resetDeclarativeComponent();
            setDstStoreDisable(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreComp());
        }

        if (getDstWarehouseComp() != null) {
            getDstWarehouseComp().resetDeclarativeComponent();
            setDstWhDisable(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDstWarehouseComp());
        }


        //Search Button Enable
        if (getSearchComp() != null) {
            getSearchComp().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchComp());
        }
        setSaveDisabled(true);
        if (getCheckBoxAllComp() != null) {
            getCheckBoxAllComp().resetValue();
            AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
        }
        resetResultsTableFilter();
        clearSetAllFields(null);
        if (getResultsArea() != null) {
            //ResetUtils.reset(getResultsArea());
            getResultsArea().setVisible(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsArea());
        }
    }

    /**
     * Disables all the components in the search area
     */
    private void disableAll() {
        logger.info("****** Inside disableAll method ******");
        if (getSrcWhTypeComp() != null) {
            getSrcWhTypeComp().setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSrcWhTypeComp());
        }
        if (getSrcWarehouseComp() != null) {
            setSrcWhDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSrcWarehouseComp());
        }

        if (getStoreComp() != null) {
            setDstStoreDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreComp());
        }
        if (getDstWarehouseComp() != null) {
            setDstWhDisable(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getDstWarehouseComp());
        }
    }

    /**
     * Invoked when store value is changed
     * @param valueChangeEvent
     */
    public void onStoreChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onStoreChange method ******");
        String inputStoreValue = (String) valueChangeEvent.getNewValue();
        logger.info("Stores Selected : " + inputStoreValue);
        dstStoreId = inputStoreValue;
        if (!StringUtil.isNullOrEmpty(dstStoreId)) {
            if (getDstWarehouseComp() != null) {
                getDstWarehouseComp().resetDeclarativeComponent();
                setDstWhDisable(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getDstWarehouseComp());
            }
        } else {
            if (getDstWarehouseComp() != null) {
                getDstWarehouseComp().resetDeclarativeComponent();
                setDstWhDisable(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getDstWarehouseComp());
            }
        }
        //Search Button Enable
        if (getSearchComp() != null) {
            getSearchComp().setDisabled(!isInputValid());
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchComp());
        }
    }

    /**
     * Invoked when destination warehouse is changed
     * @param valueChangeEvent
     */
    public void onDestinationWarehouseChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onDestinationWarehouseChange method ******");
        String inputDstWhValue = (String) valueChangeEvent.getNewValue();
        logger.info("Destination Warehouses Selected : " + inputDstWhValue);
        dstWarehouseId = inputDstWhValue;
        if (!StringUtil.isNullOrEmpty(inputDstWhValue)) {
            if (getStoreComp() != null) {
                getStoreComp().resetDeclarativeComponent();
                setDstStoreDisable(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreComp());
            }
        } else {
            if (getStoreComp() != null) {
                getStoreComp().resetDeclarativeComponent();
                setDstStoreDisable(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreComp());
            }
        }
        //Search Button Enable
        if (getSearchComp() != null) {
            getSearchComp().setDisabled(!isInputValid());
            AdfFacesContext.getCurrentInstance().addPartialTarget(getSearchComp());
        }
    }

    public void setSrcWhTypeComp(RichSelectOneChoice srcWhTypeComp) {
        this.srcWhTypeComp = ComponentReference.newUIComponentReference(srcWhTypeComp);
    }

    public RichSelectOneChoice getSrcWhTypeComp() {
        if (srcWhTypeComp != null) {
            return srcWhTypeComp.getComponent();
        }
        return null;
    }

    public void setSrcWarehouseComp(SelectManyInputCheckBox srcWarehouseComp) {
        this.srcWarehouseComp = ComponentReference.newUIComponentReference(srcWarehouseComp);
    }

    public SelectManyInputCheckBox getSrcWarehouseComp() {
        if (srcWarehouseComp != null) {
            return srcWarehouseComp.getComponent();
        }
        return null;
    }

    public void setStoreComp(SelectManyInputCheckBox storeComp) {
        this.storeComp = ComponentReference.newUIComponentReference(storeComp);
    }

    public SelectManyInputCheckBox getStoreComp() {
        if (storeComp != null) {
            return storeComp.getComponent();
        }
        return null;
    }

    public void setDstWarehouseComp(SelectManyInputCheckBox dstWarehouseComp) {
        this.dstWarehouseComp = ComponentReference.newUIComponentReference(dstWarehouseComp);
    }

    public SelectManyInputCheckBox getDstWarehouseComp() {
        if (dstWarehouseComp != null) {
            return dstWarehouseComp.getComponent();
        }
        return null;
    }

    public void setSaveDisabled(boolean saveDisabled) {
        this.saveDisabled = saveDisabled;
    }

    public void setDstWhDisable(boolean dstWhDisable) {
        if (Constants.YES.equals(dstWhEnableFlag)) {
            this.dstWhDisable = dstWhDisable;
        }
    }

    public boolean isDstWhDisable() {
        return dstWhDisable;
    }

    public void setSrcWhDisable(boolean srcWhDisable) {
        this.srcWhDisable = srcWhDisable;
    }

    public boolean isSrcWhDisable() {
        return srcWhDisable;
    }

    public void setDstStoreDisable(boolean dstStoreDisable) {
        this.dstStoreDisable = dstStoreDisable;
    }

    public boolean isDstStoreDisable() {
        return dstStoreDisable;
    }

    public void setResultsArea(RichPanelGroupLayout resultsArea) {
        this.resultsArea = ComponentReference.newUIComponentReference(resultsArea);
    }

    public RichPanelGroupLayout getResultsArea() {
        if (resultsArea != null) {
            return resultsArea.getComponent();
        }
        return null;
    }

    public void setResultsTableComp(RichTable resultsTableComp) {
        this.resultsTableComp = ComponentReference.newUIComponentReference(resultsTableComp);
    }

    public RichTable getResultsTableComp() {
        if (resultsTableComp != null) {
            return resultsTableComp.getComponent();
        }
        return null;
    }

    public void setCheckBoxAllComp(RichSelectBooleanCheckbox checkBoxAllComp) {
        this.checkBoxAllComp = ComponentReference.newUIComponentReference(checkBoxAllComp);
    }

    public RichSelectBooleanCheckbox getCheckBoxAllComp() {
        if (checkBoxAllComp != null) {
            return checkBoxAllComp.getComponent();
        }
        return null;
    }

    public void setSetAllEffDateComp(RichInputDate setAllEffDateComp) {
        this.setAllEffDateComp = ComponentReference.newUIComponentReference(setAllEffDateComp);
    }

    public RichInputDate getSetAllEffDateComp() {
        if (setAllEffDateComp != null) {
            return setAllEffDateComp.getComponent();
        }
        return null;
    }

    public void setSetAllSunLDComp(RichInputText setAllSunLDComp) {
        this.setAllSunLDComp = ComponentReference.newUIComponentReference(setAllSunLDComp);
    }

    public RichInputText getSetAllSunLDComp() {
        if (setAllSunLDComp != null) {
            return setAllSunLDComp.getComponent();
        }
        return null;
    }

    public void setSetAllMonLDComp(RichInputText setAllMonLDComp) {
        this.setAllMonLDComp = ComponentReference.newUIComponentReference(setAllMonLDComp);
    }

    public RichInputText getSetAllMonLDComp() {
        if (setAllMonLDComp != null) {
            return setAllMonLDComp.getComponent();
        }
        return null;
    }

    public void setSetAllTueLDComp(RichInputText setAllTueLDComp) {
        this.setAllTueLDComp = ComponentReference.newUIComponentReference(setAllTueLDComp);
    }

    public RichInputText getSetAllTueLDComp() {
        if (setAllTueLDComp != null) {
            return setAllTueLDComp.getComponent();
        }
        return null;
    }

    public void setSetAllWedLDComp(RichInputText setAllWedLDComp) {
        this.setAllWedLDComp = ComponentReference.newUIComponentReference(setAllWedLDComp);
    }

    public RichInputText getSetAllWedLDComp() {
        if (setAllWedLDComp != null) {
            return setAllWedLDComp.getComponent();
        }
        return null;
    }

    public void setSetAllThuLDComp(RichInputText setAllThuLDComp) {
        this.setAllThuLDComp = ComponentReference.newUIComponentReference(setAllThuLDComp);
    }

    public RichInputText getSetAllThuLDComp() {
        if (setAllThuLDComp != null) {
            return setAllThuLDComp.getComponent();
        }
        return null;
    }

    public void setSetAllFriLDComp(RichInputText setAllFriLDComp) {
        this.setAllFriLDComp = ComponentReference.newUIComponentReference(setAllFriLDComp);
    }

    public RichInputText getSetAllFriLDComp() {
        if (setAllFriLDComp != null) {
            return setAllFriLDComp.getComponent();
        }
        return null;
    }

    public void setSetAllSatLDComp(RichInputText setAllSatLDComp) {
        this.setAllSatLDComp = ComponentReference.newUIComponentReference(setAllSatLDComp);
    }

    public RichInputText getSetAllSatLDComp() {
        if (setAllSatLDComp != null) {
            return setAllSatLDComp.getComponent();
        }
        return null;
    }

    public void setSearchComp(RichButton searchComp) {
        this.searchComp = ComponentReference.newUIComponentReference(searchComp);
    }

    public RichButton getSearchComp() {
        if (searchComp != null) {
            return searchComp.getComponent();
        }
        return null;
    }

    /**
     * Handles the value change event for 'All' check box on the column header of the table.
     * This method selects/deselects the records based on the selection made on the header.
     * @param valueChangeEvent
     */
    public void onCheckBoxAllValueChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onCheckBoxAllValueChange method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        logger.info("old value===>" + valueChangeEvent.getOldValue());
        logger.info("new  value===>" + valueChangeEvent.getNewValue());

        boolean oldValue =
            (valueChangeEvent.getOldValue() == null) ? Boolean.FALSE :
            Boolean.parseBoolean(valueChangeEvent.getOldValue().toString());
        boolean newValue =
            (valueChangeEvent.getNewValue() == null) ? Boolean.FALSE :
            Boolean.parseBoolean(valueChangeEvent.getNewValue().toString());
        if (oldValue != newValue) {
            NetworkPathAM npAM = (NetworkPathAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.NETWORK_PATH_AM);
            long numberOfRecords = npAM.handleCheckBoxAll(newValue);
            if (numberOfRecords > 0) {
                if (getResultsTableComp() != null) {
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
                }
            }
        }
    }

    /**
     * Executes when user changes the any set all value from the results section
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
        if (Constants.NP_SET_ALL_EFF_DATE_COMP_ID.equals(setAllCompId)) {
            java.util.Date effectiveDate = (java.util.Date) valueChangeEvent.getNewValue();
            logger.info("Set All Effective Date  :" + effectiveDate);
            setAllMap.put(Constants.NP_SET_ALL_EFF_DATE_COMP_ID, effectiveDate);
        } else {
            Integer leadTime = null;
            String val = (String) valueChangeEvent.getNewValue();
            if (!StringUtil.isNullOrEmpty(val)) {
                leadTime = Integer.valueOf(val.toString());
            }
            if (Constants.NP_SET_ALL_SUN_LD_COMP_ID.equals(setAllCompId)) {
                logger.info("Set All Sunday Lead Time  :" + leadTime);
                setAllMap.put(Constants.NP_SET_ALL_SUN_LD_COMP_ID, leadTime);
            } else if (Constants.NP_SET_ALL_MON_LD_COMP_ID.equals(setAllCompId)) {
                logger.info("Set All Monday Lead Time  :" + leadTime);
                setAllMap.put(Constants.NP_SET_ALL_MON_LD_COMP_ID, leadTime);
            } else if (Constants.NP_SET_ALL_TUE_LD_COMP_ID.equals(setAllCompId)) {
                logger.info("Set All Tuesday Lead Time  :" + leadTime);
                setAllMap.put(Constants.NP_SET_ALL_TUE_LD_COMP_ID, leadTime);
            } else if (Constants.NP_SET_ALL_WED_LD_COMP_ID.equals(setAllCompId)) {
                logger.info("Set All Wednesday Lead Time  :" + leadTime);
                setAllMap.put(Constants.NP_SET_ALL_WED_LD_COMP_ID, leadTime);
            } else if (Constants.NP_SET_ALL_THU_LD_COMP_ID.equals(setAllCompId)) {
                logger.info("Set All Thursday Lead Time  :" + leadTime);
                setAllMap.put(Constants.NP_SET_ALL_THU_LD_COMP_ID, leadTime);
            } else if (Constants.NP_SET_ALL_FRI_LD_COMP_ID.equals(setAllCompId)) {
                logger.info("Set All Friday Lead Time  :" + leadTime);
                setAllMap.put(Constants.NP_SET_ALL_FRI_LD_COMP_ID, leadTime);
            } else if (Constants.NP_SET_ALL_SAT_LD_COMP_ID.equals(setAllCompId)) {
                logger.info("Set All Saturday Lead Time  :" + leadTime);
                setAllMap.put(Constants.NP_SET_ALL_SAT_LD_COMP_ID, leadTime);
            } else {
                logger.warning("Set All action is NOT defined for this event.");
                return;
            }
        }
    }

    /**
     * Handles set all action events from results section
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
        /*if (!checkForOverlappingLeadTimesOnSetAll()) {
            logger.severe("Lead times are overlapping. Re-enter lead times.");
            return;
        }*/
        NetworkPathAM npAM = (NetworkPathAM) AipdtUIUtil.findApplicationModuleFromRootAM(Constants.NETWORK_PATH_AM);
        npAM.handleSetAll(setAllMap);
        if (getResultsTableComp() != null) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(getResultsTableComp());
        }
        clearSetAllFields(null);
    }

    /**
     * Check for overlapping of lead times on click of set all for lead times
     * @return
     */
    private boolean checkForOverlappingLeadTimesOnSetAll() {
        logger.info("****** Inside checkForOverlappingLeadTimesOnSetAll method ******");
        java.util.List<String> deliveryDayList = new java.util.ArrayList<String>(7);
        boolean isOverlapped = false;
        int count = 0;
        Integer sunLeadTime = (Integer) setAllMap.get(Constants.NP_SET_ALL_SUN_LD_COMP_ID);
        if (sunLeadTime != null) {
            count++;
            deliveryDayList.add(String.valueOf(Constants.SUNDAY_INDEX + sunLeadTime));
        }
        Integer monLeadTime = (Integer) setAllMap.get(Constants.NP_SET_ALL_MON_LD_COMP_ID);
        if (monLeadTime != null) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.MONDAY_INDEX + monLeadTime))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.MONDAY_INDEX + monLeadTime));
            }
        }
        Integer tueLeadTime = (Integer) setAllMap.get(Constants.NP_SET_ALL_TUE_LD_COMP_ID);
        if (tueLeadTime != null) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.TUESDAY_INDEX + tueLeadTime))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.TUESDAY_INDEX + tueLeadTime));
            }
        }
        Integer wedLeadTime = (Integer) setAllMap.get(Constants.NP_SET_ALL_WED_LD_COMP_ID);
        if (wedLeadTime != null) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.WEDNESDAY_INDEX + wedLeadTime))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.WEDNESDAY_INDEX + wedLeadTime));
            }
        }
        Integer thuLeadTime = (Integer) setAllMap.get(Constants.NP_SET_ALL_THU_LD_COMP_ID);
        if (thuLeadTime != null) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.THURSDAY_INDEX + thuLeadTime))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.THURSDAY_INDEX + thuLeadTime));
            }
        }
        Integer friLeadTime = (Integer) setAllMap.get(Constants.NP_SET_ALL_FRI_LD_COMP_ID);
        if (friLeadTime != null) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.FRIDAY_INDEX + friLeadTime))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.FRIDAY_INDEX + friLeadTime));
            }
        }
        Integer satLeadTime = (Integer) setAllMap.get(Constants.NP_SET_ALL_SAT_LD_COMP_ID);
        if (satLeadTime != null) {
            count++;
            if (deliveryDayList.contains(String.valueOf(Constants.SATURDAY_INDEX + satLeadTime))) {
                isOverlapped = true;
            } else {
                deliveryDayList.add(String.valueOf(Constants.SATURDAY_INDEX + satLeadTime));
            }
        }

        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("NetworkPathResultsVO1Iterator");
        if (dcItteratorBindings != null) {
            ViewObject resultsVO = dcItteratorBindings.getViewObject();
            Row resultCurrentRow = resultsVO.getCurrentRow();
            String frequency = (String) resultCurrentRow.getAttribute("Frequency");
            if ("7".equals(frequency)) {
                if (isOverlapped) {
                    AipdtUIUtil.showErrorMessageFromUIBundle(Constants.DOW_VALUES_ARE_OVERLAPPED, null);
                    return false;
                }
            } else {
                if (count > 1) {
                    AipdtUIUtil.showErrorMessageFromUIBundle(Constants.LEADTIME_CAN_BE_ENTERED_FOR_ONLY_ONE_DOW, null);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Clears the set all fields
     */
    private void clearSetAllFields(String setAllCompId) {
        logger.info("****** Inside clearSetAllFields method ******");
        setAllMap.clear();
        if (getSetAllEffDateComp() != null) {
            if (!getSetAllEffDateComp().getId().equals(setAllCompId)) {
                getSetAllEffDateComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllEffDateComp());
            }
        }
        if (getSetAllSunLDComp() != null) {
            if (!getSetAllSunLDComp().getId().equals(setAllCompId)) {
                getSetAllSunLDComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllSunLDComp());
            }
        }
        if (getSetAllMonLDComp() != null) {
            if (!getSetAllMonLDComp().getId().equals(setAllCompId)) {
                getSetAllMonLDComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllMonLDComp());
            }
        }
        if (getSetAllTueLDComp() != null) {
            if (!getSetAllTueLDComp().getId().equals(setAllCompId)) {
                getSetAllTueLDComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllTueLDComp());
            }
        }
        if (getSetAllWedLDComp() != null) {
            if (!getSetAllWedLDComp().getId().equals(setAllCompId)) {
                getSetAllWedLDComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllWedLDComp());
            }
        }
        if (getSetAllThuLDComp() != null) {
            if (!getSetAllThuLDComp().getId().equals(setAllCompId)) {
                getSetAllThuLDComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllThuLDComp());
            }
        }
        if (getSetAllFriLDComp() != null) {
            if (!getSetAllFriLDComp().getId().equals(setAllCompId)) {
                getSetAllFriLDComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllFriLDComp());
            }
        }
        if (getSetAllSatLDComp() != null) {
            if (!getSetAllSatLDComp().getId().equals(setAllCompId)) {
                getSetAllSatLDComp().resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(getSetAllSatLDComp());
            }
        }
    }

    /**
     * Invoked when user selects 'Ok' from the Save Success confirmation popup, which reinitializes the screen after save.
     * @param actionEvent
     */
    public void handleSaveOk(ActionEvent actionEvent) {
        logger.info("****** Inside handleSaveOk method ******");
        handleResetYes(null);
    }

    /**
     * Validates the lead time entered in the results section
     * @param facesContext
     * @param uIComponent
     * @param object
     */
    public void validateLeadTime(FacesContext facesContext, UIComponent uIComponent, Object object) {
        logger.info("****** Inside validateLeadTime method ******");
        if (object != null) {
            Integer leadTime = null;
            if (object instanceof String && !Constants.EMPTY.equals(object.toString().trim())) {
                leadTime = Integer.getInteger(object.toString().trim());
            } else if (object instanceof Integer) {
                leadTime = (Integer) object;
            } else if (object instanceof Long) {
                leadTime = ((Long) object).intValue();
            } else {
                return;
            }
            if (leadTime < 0 || leadTime > 99) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                                 Constants.NP_INVALID_LEAD_TIME),
                                                              null));
            }
            //Check for overlapping lead times
            /*int overlapResult = checkForOverlappingLeadTimes();
            if (overlapResult == 0) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                                 Constants.DOW_VALUES_ARE_OVERLAPPED),
                                                              null));
            } else if (overlapResult == 1) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                                 Constants.LEADTIME_CAN_BE_ENTERED_FOR_ONLY_ONE_DOW),
                                                              null));
            }*/
        }
    }

    /**
     * Check whether the lead times are overlapping or not on lead time value change
     * @return
     */
    private int checkForOverlappingLeadTimes() {
        logger.info("****** Inside checkForOverlappingLeadTimes method ******");
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("NetworkPathResultsVO1Iterator");
        if (dcItteratorBindings != null) {
            ViewObject resultsVO = dcItteratorBindings.getViewObject();
            NetworkPathResultsVORowImpl resultsRow = (NetworkPathResultsVORowImpl) resultsVO.getCurrentRow();
            java.util.List<String> deliveryDayList = new java.util.ArrayList<String>(7);
            boolean isOverlapped = false;
            int count = 0;
            Integer sunLeadTime = resultsRow.getSundayLeadTime();
            if (sunLeadTime != null) {
                count++;
                deliveryDayList.add(String.valueOf(Constants.SUNDAY_INDEX + sunLeadTime));
            }
            Integer monLeadTime = resultsRow.getMondayLeadTime();
            if (monLeadTime != null) {
                count++;
                if (deliveryDayList.contains(String.valueOf(Constants.MONDAY_INDEX + monLeadTime))) {
                    isOverlapped = true;
                } else {
                    deliveryDayList.add(String.valueOf(Constants.MONDAY_INDEX + monLeadTime));
                }
            }
            Integer tueLeadTime = resultsRow.getTuesdayLeadTime();
            if (tueLeadTime != null) {
                count++;
                if (deliveryDayList.contains(String.valueOf(Constants.TUESDAY_INDEX + tueLeadTime))) {
                    isOverlapped = true;
                } else {
                    deliveryDayList.add(String.valueOf(Constants.TUESDAY_INDEX + tueLeadTime));
                }
            }
            Integer wedLeadTime = resultsRow.getWednesdayLeadTime();
            if (wedLeadTime != null) {
                count++;
                if (deliveryDayList.contains(String.valueOf(Constants.WEDNESDAY_INDEX + wedLeadTime))) {
                    isOverlapped = true;
                } else {
                    deliveryDayList.add(String.valueOf(Constants.WEDNESDAY_INDEX + wedLeadTime));
                }
            }
            Integer thuLeadTime = resultsRow.getThursdayLeadTime();
            if (thuLeadTime != null) {
                count++;
                if (deliveryDayList.contains(String.valueOf(Constants.THURSDAY_INDEX + thuLeadTime))) {
                    isOverlapped = true;
                } else {
                    deliveryDayList.add(String.valueOf(Constants.THURSDAY_INDEX + thuLeadTime));
                }
            }
            Integer friLeadTime = resultsRow.getFridayLeadTime();
            if (friLeadTime != null) {
                count++;
                if (deliveryDayList.contains(String.valueOf(Constants.FRIDAY_INDEX + friLeadTime))) {
                    isOverlapped = true;
                } else {
                    deliveryDayList.add(String.valueOf(Constants.FRIDAY_INDEX + friLeadTime));
                }
            }
            Integer satLeadTime = resultsRow.getSaturdayLeadTime();
            if (satLeadTime != null) {
                count++;
                if (deliveryDayList.contains(String.valueOf(Constants.SATURDAY_INDEX + satLeadTime))) {
                    isOverlapped = true;
                } else {
                    deliveryDayList.add(String.valueOf(Constants.SATURDAY_INDEX + satLeadTime));
                }
            }
            String frequency = resultsRow.getFrequency();
            if ("7".equals(frequency)) {
                if (isOverlapped) {
                    return 0;
                }
            } else {
                if (count > 1) {
                    return 1;
                }
            }
        }
        return 2;
    }

    /**
     * Updates the current row update indicator based on the user selection on the results table
     * @param valueChangeEvent
     */
    public void onCheckBoxValueChange(ValueChangeEvent valueChangeEvent) {
        logger.info("****** Inside onCheckBoxValueChange method ******");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("NetworkPathResultsVO1Iterator");
        if (dcItteratorBindings != null) {
            ViewObject resultVO = dcItteratorBindings.getViewObject();
            boolean newValue =
                (valueChangeEvent.getNewValue() == null) ? Boolean.FALSE :
                Boolean.parseBoolean(valueChangeEvent.getNewValue().toString());
            if (getCheckBoxAllComp() != null) {
                if (newValue) {
                    Row[] resultsRows = resultVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
                    if ((resultsRows != null) && (resultsRows.length == resultVO.getEstimatedRowCount())) {
                        getCheckBoxAllComp().setValue(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
                    } else {
                        getCheckBoxAllComp().setValue(Boolean.FALSE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
                    }
                } else {
                    getCheckBoxAllComp().setValue(Boolean.FALSE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getCheckBoxAllComp());
                }
            }
        }
    }

    /**
     * Method to clear the results table filter criteria
     */
    private void resetResultsTableFilter() {
        logger.info("****** Inside resetResultsTableFilter method ******");
        if (getResultsTableComp() != null) {
            FilterableQueryDescriptor queryDescriptor =
                (FilterableQueryDescriptor) getResultsTableComp().getFilterModel();
            if (queryDescriptor != null && queryDescriptor.getFilterConjunctionCriterion() != null) {
                ConjunctionCriterion cc = queryDescriptor.getFilterConjunctionCriterion();
                List<Criterion> lc = cc.getCriterionList();
                for (Criterion c : lc) {
                    if (c instanceof AttributeCriterion) {
                        AttributeCriterion ac = (AttributeCriterion) c;
                        ac.setValue(null);
                    }
                }
                getResultsTableComp().queueEvent(new QueryEvent(getResultsTableComp(), queryDescriptor));
            }
        }
    }

    /**
     * Helper method to check whether the records are selected for save or not.
     * @return
     */
    private int areRecordsSelectedForSave(boolean isSave) {
        logger.info("****** Inside areRecordsSelectedForSave method ******");
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("NetworkPathResultsVO1Iterator");
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
                    Integer sunLT = (Integer) resultRow.getAttribute(Constants.SUNDAY_LEAD_TIME);
                    Integer monLT = (Integer) resultRow.getAttribute(Constants.MONDAY_LEAD_TIME);
                    Integer tueLT = (Integer) resultRow.getAttribute(Constants.TUESDAY_LEAD_TIME);
                    Integer wedLT = (Integer) resultRow.getAttribute(Constants.WEDNESDAY_LEAD_TIME);
                    Integer thuLT = (Integer) resultRow.getAttribute(Constants.THURSDAY_LEAD_TIME);
                    Integer friLT = (Integer) resultRow.getAttribute(Constants.FRIDAY_LEAD_TIME);
                    Integer satLT = (Integer) resultRow.getAttribute(Constants.SATURDAY_LEAD_TIME);
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
     * Invoked on table filtering. No change in the filtering feature,
     * it only enables/disables the header level checkbox on filtering.
     * @param queryEvent
     */
    public void processQuery(QueryEvent queryEvent) {
        logger.info("****** Inside processQuery method ******");
        //Process default filter query event
        AipdtUIUtil.invokeQueryEventMethodExpression("#{bindings.NetworkPathResultsVO1Query.processQuery}", queryEvent);
        //Enable or disable header level checkbox
        if (getCheckBoxAllComp() != null) {
            DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator("NetworkPathResultsVO1Iterator");
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

    /**
     * Invoked when export selected rows command link is clicked.
     * @param uIComponent
     * @param exportContext
     * @param formatHandler
     * @return
     */
    public Boolean exportSelectedRows(UIComponent uIComponent, ExportContext exportContext,
                                      FormatHandler formatHandler) {
        logger.info("****** Inside exportSelectedRows method ******");
        AipdtUIUtil.selectAllRowsInTable(getResultsTableComp(), "NetworkPathResultsVO1Iterator",
                                         Constants.UPDATE_IND_ATTR);
        return Boolean.TRUE;
    }

    /**
     * Checks whether the all the required input is entered or not.
     * @return
     */
    private boolean isInputValid() {
        logger.info("****** Inside isInputValid method ******");
        if (!StringUtil.isNullOrEmpty(srcWhType) && !StringUtil.isNullOrEmpty(sourceId) &&
            (!StringUtil.isNullOrEmpty(dstStoreId) || !StringUtil.isNullOrEmpty(dstWarehouseId))) {
            return true;
        }
        return false;
    }

    /**
     * Construts network path export file name
     * @return
     *      Export file name
     */
    public String getExportFileName() {
        return AipdtUIUtil.getExportFileName(Constants.NP_EXPORT_FILE_NAME);
    }
}
