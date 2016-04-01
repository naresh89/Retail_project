package oracle.retail.apps.aipdt.dt.publicui.bean;

import com.oracle.retail.apps.comp.ms.view.MultiselectInputListOfValues;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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
import oracle.adf.view.rich.component.rich.fragment.RichDeclarativeComponent;
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
import oracle.adf.view.rich.model.AttributeCriterion;
import oracle.adf.view.rich.model.ConjunctionCriterion;
import oracle.adf.view.rich.model.Criterion;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;
import oracle.adf.view.rich.util.ResetUtils;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.JboException;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.RowIterator;
import oracle.jbo.RowMatch;
import oracle.jbo.RowSetIterator;

import oracle.retail.apps.aipdt.common.Constants;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.RowQualifier;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import oracle.retail.apps.aipdt.common.model.util.DateUtil;
import oracle.retail.apps.aipdt.common.publicui.bean.BaseRetailBean;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;
import oracle.retail.apps.aipdt.dt.model.view.DeploymentTypeResultVOImpl;
import oracle.retail.apps.aipdt.dt.model.view.DeploymentTypeResultVORowImpl;
import oracle.retail.apps.aipdt.fieldbinding.publicui.bean.MultiSelectBaseFieldsBean;
import oracle.retail.apps.aipdt.osos.model.view.OnOffSaleSupplyResultVORowImpl;
import oracle.retail.apps.framework.uicomponents.AppsPanelCustomComp;
import oracle.retail.apps.framework.uicomponents.util.ADFFacesUtil;

import org.apache.myfaces.trinidad.model.RowKeySetImpl;


public class DeploymentTypeBean extends BaseRetailBean {
    @SuppressWarnings("compatibility:7349620677563128513")
    private static final long serialVersionUID = 2327373161540735074L;

    private final static ADFLogger _logger = ADFLogger.createADFLogger(DeploymentTypeBean.class);

    private MultiSelectBaseFieldsBean multiSelectBaseFieldsBean = new MultiSelectBaseFieldsBean();
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
    private RichTable resultTable;
    private Boolean isSaveBtnDisabled = Boolean.TRUE;

    private static final Integer DEPT_SELECTION_LEVEL = 1;
    private static final Integer DEPT_SUPPLIER_SELECTION_LEVEL = 2;
    private static final Integer DEPT_ITEM_LEVEL = 3;

    AppsPanelCustomComp appsPanelBind = null;

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

    private RichSelectOneChoice storeListComp;
    private RichInputListOfValues supplierComp;
    private RichSelectOneChoice supplierListComp;
    private RichSelectOneChoice itemListComp;

    private RichSelectOneChoice departmentComp;
    private RichSelectOneChoice regionComp;
    private RichPanelGroupLayout resutlContainer;
    private RichSelectBooleanCheckbox allItemCheckBoxComp;
    private RichSelectBooleanCheckbox selectAllComp;
    private RichSelectBooleanCheckbox selectRowComp;

    private RichSelectBooleanRadio defaultRadioComp;
    private RichSelectBooleanRadio exceptionRadioComp;
    private Boolean isExceptionDisable = Boolean.FALSE;
    private Boolean isRegionDisable = Boolean.TRUE;

    private Boolean isDefaultDisable = Boolean.FALSE;

    private Boolean isDefaultSelected = Boolean.TRUE;
    private Boolean isExceptionSelected = Boolean.FALSE;

    private RichPopup saveCloseSuccessPopup;
    private RichPopup storePopup;
    private RichPopup cancelPopup;
    private RichPopup saveSuccessPopup;
    private RichPopup saveFailedPopup;
    private RichPopup resetPopup;
    private RichPopup supplierPopup;
    private RichPopup itemHierarchyPopup;
    private RichPopup saveConfirmationPopup;
    private RichPopup saveAndCloseConfirmationPopup;

    protected static Boolean isSaveAndCloseCliked = Boolean.FALSE;
    private RichButton searchBtn;

    private RichInputDate startDateHeaderComp;
    private RichInputDate endDateHeaderComp;
    private RichInputDate startDateRowLevelComp;

    private static final String DEPLOYMENT_TYPE_RESULT_VO_ITERATOR = "DeploymentTypeResultVOIterator";

    private static final String DEPLOYMENT_TYPE_RESULTEO_ALTKEY_WITHOUTDATE = "AltKey_Without_Date";

    private java.util.Date vDate = DateUtil.getVDatePlusOne().getValue();
    private java.util.Date sysHighDate =
        new Date(DateUtil.getSystemHighDate().getValue().getTime() + TimeUnit.DAYS.toMillis(1));


    public void setSaveAndCloseConfirmationPopup(RichPopup saveAndCloseConfirmationPopup) {
        this.saveAndCloseConfirmationPopup = saveAndCloseConfirmationPopup;
    }

    public RichPopup getSaveAndCloseConfirmationPopup() {
        return saveAndCloseConfirmationPopup;
    }

    public void setSaveConfirmationPopup(RichPopup saveConfirmationPopup) {
        this.saveConfirmationPopup = saveConfirmationPopup;
    }

    public RichPopup getSaveConfirmationPopup() {
        return saveConfirmationPopup;
    }

    public void setSupplierPopup(RichPopup supplierPopup) {
        this.supplierPopup = supplierPopup;
    }

    public RichPopup getSupplierPopup() {
        return supplierPopup;
    }

    public void setStartDateRowLevelComp(RichInputDate startDateRowLevelComp) {
        this.startDateRowLevelComp = startDateRowLevelComp;
    }

    public RichInputDate getStartDateRowLevelComp() {
        return startDateRowLevelComp;
    }

    public void setVDate(Date vDate) {
        this.vDate = vDate;
    }

    public Date getVDate() {
        return vDate;
    }

    public void setAppsPanelBind(AppsPanelCustomComp appsPanelBind) {
        this.appsPanelBind = appsPanelBind;
    }

    public AppsPanelCustomComp getAppsPanelBind() {
        return appsPanelBind;
    }


    public void setSysHighDate(Date sysHighDate) {
        this.sysHighDate = sysHighDate;
    }

    public Date getSysHighDate() {
        return sysHighDate;
    }

    public void setStartDateHeaderComp(RichInputDate startDateHeaderComp) {
        this.startDateHeaderComp = startDateHeaderComp;
    }

    public RichInputDate getStartDateHeaderComp() {
        return startDateHeaderComp;
    }

    public void setEndDateHeaderComp(RichInputDate endDateHeaderComp) {
        this.endDateHeaderComp = endDateHeaderComp;
    }

    public RichInputDate getEndDateHeaderComp() {
        return endDateHeaderComp;
    }

    public void setIsSaveBtnDisabled(Boolean isSaveBtnDisabled) {
        this.isSaveBtnDisabled = isSaveBtnDisabled;
    }

    public Boolean getIsSaveBtnDisabled() {
        return isSaveBtnDisabled;
    }

    public void setSearchBtn(RichButton searchBtn) {
        this.searchBtn = searchBtn;
    }

    public RichButton getSearchBtn() {
        return searchBtn;
    }

    public void setItemHierarchyPopup(RichPopup itemHierarchyPopup) {
        this.itemHierarchyPopup = itemHierarchyPopup;
    }

    public RichPopup getItemHierarchyPopup() {
        return itemHierarchyPopup;
    }

    public void setSaveCloseSuccessPopup(RichPopup saveCloseSuccessPopup) {
        this.saveCloseSuccessPopup = saveCloseSuccessPopup;
    }

    public RichPopup getSaveCloseSuccessPopup() {
        return saveCloseSuccessPopup;
    }

    public void setStorePopup(RichPopup storePopup) {
        this.storePopup = storePopup;
    }

    public RichPopup getStorePopup() {
        return storePopup;
    }

    public void setCancelPopup(RichPopup cancelPopup) {
        this.cancelPopup = cancelPopup;
    }

    public RichPopup getCancelPopup() {
        return cancelPopup;
    }

    public void setSaveSuccessPopup(RichPopup saveSuccessPopup) {
        this.saveSuccessPopup = saveSuccessPopup;
    }

    public RichPopup getSaveSuccessPopup() {
        return saveSuccessPopup;
    }

    public void setSaveFailedPopup(RichPopup saveFailedPopup) {
        this.saveFailedPopup = saveFailedPopup;
    }

    public RichPopup getSaveFailedPopup() {
        return saveFailedPopup;
    }

    public void setResetPopup(RichPopup resetPopup) {
        this.resetPopup = resetPopup;
    }

    public RichPopup getResetPopup() {
        return resetPopup;
    }

    public void setIsVpnColourDisable(Boolean isVpnColourDisable) {
        this.isVpnColourDisable = isVpnColourDisable;
    }

    public void setSelectRowComp(RichSelectBooleanCheckbox selectRowComp) {
        this.selectRowComp = selectRowComp;
    }

    public RichSelectBooleanCheckbox getSelectRowComp() {
        return selectRowComp;
    }

    public Boolean getIsVpnColourDisable() {
        return isVpnColourDisable;
    }


    public void setIsAllItemDisable(Boolean isAllItemDisable) {
        this.isAllItemDisable = isAllItemDisable;
    }

    public Boolean getIsAllItemDisable() {
        return isAllItemDisable;
    }

    public void setIsRegionDisable(Boolean isRegionDisable) {
        this.isRegionDisable = isRegionDisable;
    }

    public Boolean getIsRegionDisable() {
        return isRegionDisable;
    }

    public void setRegionComp(RichSelectOneChoice regionComp) {
        this.regionComp = regionComp;
    }

    public RichSelectOneChoice getRegionComp() {
        return regionComp;
    }

    public void setResultTable(RichTable resultTable) {
        this.resultTable = resultTable;
    }

    public void setResutlContainer(RichPanelGroupLayout resutlContainer) {
        this.resutlContainer = resutlContainer;
    }

    public RichPanelGroupLayout getResutlContainer() {
        return resutlContainer;
    }

    public void setSelectAllComp(RichSelectBooleanCheckbox selectAllComp) {
        this.selectAllComp = selectAllComp;
    }

    public RichSelectBooleanCheckbox getSelectAllComp() {
        return selectAllComp;
    }


    public RichTable getResultTable() {
        return resultTable;
    }

    public void setExceptionRadioComp(RichSelectBooleanRadio exceptionRadioComp) {
        this.exceptionRadioComp = exceptionRadioComp;
    }

    public RichSelectBooleanRadio getExceptionRadioComp() {
        return exceptionRadioComp;
    }

    public void setDefaultRadioComp(RichSelectBooleanRadio defaultRadioComp) {
        this.defaultRadioComp = defaultRadioComp;
    }

    public RichSelectBooleanRadio getDefaultRadioComp() {
        return defaultRadioComp;
    }

    public void setAllItemCheckBoxComp(RichSelectBooleanCheckbox allItemCheckBoxComp) {
        this.allItemCheckBoxComp = allItemCheckBoxComp;
    }

    public RichSelectBooleanCheckbox getAllItemCheckBoxComp() {
        return allItemCheckBoxComp;
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

    public void setDepartmentComp(RichSelectOneChoice departmentComp) {
        this.departmentComp = departmentComp;
    }

    public RichSelectOneChoice getDepartmentComp() {
        return departmentComp;
    }

    public DeploymentTypeBean() {
        super();
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

    public String initActivity() {

        String userName = AipdtUIUtil.getUserName();

        OperationBinding op = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("initActivity");

        if (op != null) {

            op.getParamsMap().put("userName", userName);
            //op.execute();
        }
        deptId = null;
        classId = null;
        subclassId = null;
        itemListVal = null;
        supplierVal = null;
        vpnIdVal = null;
        vpnColourIdVal = null;
        skuIdVal = null;
        storeVal = null;
        storeListVal = null;
        regionIdVal = null;
        ViewObject deptLOVVO = getLOVViewObjectFromBinding("Department");

        //deptLOVVO.setNamedWhereClauseParam("bindLoggedUser", userName);

        //deptLOVVO.executeQuery();
        //System.out.println("row Count -->" + deptLOVVO.getEstimatedRowCount());
        return "success";
    }


    /**
     * This method will return the view object instance based on the code provided.
     * @param attrName
     * @return
     */
    public ViewObjectImpl getLOVViewObjectFromBinding(String attrName) {
        ViewObjectImpl lovVO = null;
        try {
            if (_logger.isLoggable(Level.INFO)) {
                _logger.info("Entering into the method getViewObjectFromBinding");
            }
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            JUCtrlListBinding allDepartsmentList = (JUCtrlListBinding) bindings.get(attrName);

            lovVO = (ViewObjectImpl) allDepartsmentList.getListIterBinding().getViewObject();

            if (_logger.isLoggable(Level.INFO)) {
                _logger.info("Exiting from the method getViewObjectFromBinding");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lovVO;
    }

    /**
     *
     * @param valueChangeEvent
     */
    @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")

    public void onDepartmentVCE(ValueChangeEvent valueChangeEvent) {
        try {
            System.out.println("asasa");
            _logger.info("Entering  onDepartmentVCE()");

            AipdtUIUtil.setValueToEL("#{bindings.Department.inputValue}", valueChangeEvent.getNewValue());
            Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Department.attributeValue}");
            _logger.info("Department newValue :" + newValue);

            if (newValue != null && !newValue.toString().isEmpty()) {
                deptId = String.valueOf(newValue);
                // Below condition is added to filter Product Hierarchy fields if only Exception Type is selected.
                if (!isDefaultSelected && isExceptionSelected) {
                    disableProductHierarchyLevelFields(false);

                    filterClassComponent();

                    filterSubClassComponent();

                    filterVPNComponent();

                    filterVPNColourComponent();

                    filterSkuComponent();
                }
                disableDestinationFields(false);
                setIsItemListDisable(true);
                supplierComp.setDisabled(false);
            } else {
                deptId = null;
                supplierComp.setDisabled(true);
                resetProductAndDestinationFields();
                isItemListDisable = false;
            }
            // Filtering Supplier component based on selected Department.
            filterSupplierComponent();
            enableDisableItemListComponent();
            setDepartmentIdOnShuttleComponent();
            enableSearchButton();
            AdfFacesContext.getCurrentInstance().addPartialTarget(itemListComp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method used to enable/disable ItemList component based on Exception Radio button selection and DeptId value.
     */
    private void enableDisableItemListComponent() {
        if (isExceptionSelected) {
            if (deptId != null) {
                isItemListDisable = true;
            } else {
                isItemListDisable = false;
            }
        } else {
            isItemListDisable = true;
            resetItemListComponent();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(itemListComp);
    }


    /**
     * This method sets value of DepartmentId on to DepartmentId multiSelect component.
     */
    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")

    private void setDepartmentIdOnShuttleComponent() {
        try {
            deptId = (deptId != null && !deptId.isEmpty()) ? deptId : null;

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
            e.printStackTrace();
        }

    }

    /**
     * This method filters Class component based on DepartmentId value selected.
     */

    private void filterClassComponent() {
        _logger.info("Entering  filterClassComponent()");
        try {

            multiSelectBaseFieldsBean.resetMultiSelectComponent(multiSelectBaseFieldsBean.getClassComp());
            classId = null;
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("Class1", "DeparmentId", deptId, null, null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());

            /* Object oldInputTextValue = multiSelectBaseFieldsBean.getClassComp().getValueInputText().getValue();
             valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
            multiSelectBaseFieldsBean.getClassComp().getValueInputText().setValue(classCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            classId = multiSelectBaseFieldsBean.getClassComp().getIdValueFromCode("Class1", classCode);   */
        } catch (Exception e) {
            _logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
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
            multiSelectBaseFieldsBean.filterDependantMultiSelectComponent("Subclass", "ClassId", classId,
                                                                          "DepartmentId", deptId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            /* Object oldInputTextValue = multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().getValue();
               String subClassCode =
                multiSelectBaseFieldsBean.filterDependantLOV("Subclass", "SubclassCode", "ClassId", classId,
                                                             oldInputTextValue, "DepartmentId", deptId);
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
            isItemListDisable = true;
            multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().setValue(subClassCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            subclassId = multiSelectBaseFieldsBean.getSubClassComp().getIdValueFromCode("Subclass", subClassCode);  */

        } catch (Exception e) {
            _logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }


    /**
     * This method filters Item Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component which is correspondence to selected department.
     */

    private void filterSkuComponent() {
        _logger.info("Entering  filterSkuComponent()");
        try {

            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, vpnColourIdVal,
                                                                       multiSelectBaseFieldsBean.getItemComp());
            skuIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());

            /*String codeVal =
                multiSelectBaseFieldsBean.fetchValidCodeValue(deptId, "Item", "DepartmentId", "CommodityCode",
                                                              multiSelectBaseFieldsBean.getItemComp());
            multiSelectBaseFieldsBean.getItemComp().getInputBinding().setValue(codeVal);
            multiSelectBaseFieldsBean.getItemComp().processUpdates(FacesContext.getCurrentInstance());
            skuIdVal =
                multiSelectBaseFieldsBean.getShuttleComponentIdValue(codeVal, "Item", "CommodityId", "CommodityCode",
                                                                     "ITEM");  */
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
        } catch (Exception e) {
            _logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }


    /**
     * This method filters VPN Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component which is correspondence to selected department.
     */

    private void filterVPNComponent() {
        _logger.info("Entering  setFilterConditionToVPNComponent()");
        String vpnCodeVal = null;
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, null, null,
                                                                       multiSelectBaseFieldsBean.getVpnComp());
            vpnIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
            /*vpnCodeVal =
                multiSelectBaseFieldsBean.fetchValidCodeValue(deptId, "Vpn", "DepartmentId", "StyleCode",
                                                              multiSelectBaseFieldsBean.getVpnComp());
            multiSelectBaseFieldsBean.getVpnComp().getInputBinding().setValue(vpnCodeVal);
            multiSelectBaseFieldsBean.getVpnComp().processUpdates(FacesContext.getCurrentInstance());
            vpnIdVal =
                multiSelectBaseFieldsBean.getShuttleComponentIdValue(vpnCodeVal, "Vpn", "StyleId", "StyleCode", "VPN");   */

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());

        } catch (Exception e) {
            _logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }

    /**
     * This method filters VPN/StyleColour Shuttle component based on DepartmentId value selected and sets the value to ItemShuttle component which is correspondence to selected department.
     */

    private void filterVPNColourComponent() {
        _logger.info("Entering  setFilterConditionToVPNStyleColourComponent()");
        try {
            multiSelectBaseFieldsBean.setWhereClauseOnShuttleComponent(classId, subclassId, vpnIdVal, null,
                                                                       multiSelectBaseFieldsBean.getStyleColourComp());
            vpnColourIdVal = null;
            multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());

            /*String vpnColourCode =
                multiSelectBaseFieldsBean.fetchValidCodeValue(deptId, "StyleColor", "DepartmentId", "StyleColorCode",
                                                              multiSelectBaseFieldsBean.getStyleColourComp());
            multiSelectBaseFieldsBean.getStyleColourComp().getInputBinding().setValue(vpnColourCode);
            multiSelectBaseFieldsBean.getStyleColourComp().processUpdates(FacesContext.getCurrentInstance());
            vpnColourIdVal =
                multiSelectBaseFieldsBean.getShuttleComponentIdValue(vpnColourCode, "StyleColor", "StyleColorId",
                                                                     "StyleColorCode", "VPN_COLOR");  */

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());

        } catch (Exception e) {
            _logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }

    /**
     * This method filters SupplierComponent based on DepartmentId value selected and sets the value to ItemShuttle component which is correspondence to selected department.
     */
    @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")

    private void filterSupplierComponent() {
        _logger.info("Entering  filterSupplierComponent()");
        try {
            OperationBinding supplierOpBind = AipdtUIUtil.findOperation("filterSupplierLOVVO");
            if (supplierOpBind != null) {
                supplierOpBind.getParamsMap().put("deptId", deptId);
                supplierOpBind.execute();
            }
            if (deptId != null && !deptId.isEmpty()) {
                isSupplierDisable = Boolean.FALSE;
            } else {
                isSupplierDisable = Boolean.TRUE;
            }
            resetSupplierComponent();
            AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        } catch (Exception e) {
            _logger.info("Exception occured at filterClassComponent()");
            e.printStackTrace();
        }
    }


    /**
     * this method resets Supplier component in various schenarios.
     */
    private void resetSupplierComponent() {
        if (supplierVal != null) {
            BindingContainer bind = getBinding();
            JUCtrlListBinding list = (JUCtrlListBinding) bind.get("Supplier");
            list.setSelectedIndex(-1);
            list.clearSelectedIndices();
            supplierVal = null;
            supplierComp.resetValue();
            AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        }
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onClassVCE(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onClassVCE()");
            Object newValue = valueChangeEvent.getNewValue();
            _logger.info("class newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                classId = String.valueOf(newValue);

                /*Object oldInputTextValue = multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().getValue();
                String classCodeVal =
                    String.valueOf(multiSelectBaseFieldsBean.getClassComp().getValueInputText().getValue()); //TODO
                String deptCodeVal =
                    String.valueOf(multiSelectBaseFieldsBean.getClassComp().getValueInputText().getValue());
                String subclassNewValue =
                    multiSelectBaseFieldsBean.filterDependantLOV("Subclass", "SubclassCode", "ClassId", classId,
                                                                 oldInputTextValue, "DepartmentId", deptId);
                multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
                multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().setValue(subclassNewValue);  */
            } else {
                classId = null;
                /*subclassId = null;
                multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
                multiSelectBaseFieldsBean.getSubClassComp().getValueInputText().setValue(null);
                setIsSubClassDisable(Boolean.TRUE);  */
            }
            filterSubClassComponent();

            filterVPNComponent();

            filterVPNColourComponent();

            filterSkuComponent();
            enableSearchButton();
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onSubClassVCE(ValueChangeEvent valueChangeEvent) {
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
            e.printStackTrace();
        }
    }

    /**
     * This method will be called on value change of ItemShuttle component.
     */

    public void onSkuVCE() {
        try {
            _logger.info("Entering  actionFromItemChange()");
            String newValue = multiSelectBaseFieldsBean.getItemComp().getSelectedValues();
            skuIdVal = multiSelectBaseFieldsBean.getItemComp().getIdValueFromCode();
            String skuCode = null;
            if (newValue != null && !newValue.isEmpty()) {
                skuCode = newValue;
            } else {
                skuCode = null;
            }
            enableSearchButton();
            _logger.info("Item newValue :" + skuCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * This method will be called on value change of VPN Shuttle component.
     *
     */
    public void onVpnVCE() {
        try {
            _logger.info("Entering  onVpnVCE()");
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
            e.printStackTrace();
        }
    }

    /**
     * This method will be called on value change of vpnColour Shuttle component.
     */

    public void onVpnColourVCE() {
        try {
            _logger.info("Entering  onVpnColourVCE()");
            String vpnCode = null;
            String newValue = multiSelectBaseFieldsBean.getStyleColourComp().getSelectedValues();
            if (newValue != null && !newValue.isEmpty()) {
                vpnCode = newValue;
            } else {
                vpnCode = null;
            }
            vpnColourIdVal = multiSelectBaseFieldsBean.getStyleColourComp().getIdValueFromCode();

            filterSkuComponent();
            enableSearchButton();
            _logger.info("vpnColour newValue :" + vpnCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param valueChangeEvent
     */
    public void onItemListVCE(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onItemListVCE()");

            AipdtUIUtil.setValueToEL("#{bindings.ItemList.inputValue}", valueChangeEvent.getNewValue());
            Object newValue = AipdtUIUtil.resolveExpression("#{bindings.ItemList.attributeValue}");
            _logger.info("ItemList value :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                itemListVal = String.valueOf(newValue);
                supplierComp.setDisabled(false);
            } else {
                itemListVal = null;
                supplierComp.setDisabled(true);
            }
            enableDisableFieldsOnItemListVCE(itemListVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Below method resets/Enable/Disable fields on ItemList value change.
     * @param itemList
     */
    private void enableDisableFieldsOnItemListVCE(Object itemList) {
        if (itemList != null) {
            /*isClassDisable = true;
            isSubClassDisable = true;
            isVPNDisable = true;
            isVpnColourDisable = true;
            isItemDisable = true; */



            isSupplierDisable = false;
            isRegionDisable = false;
            isStoreDisable = false;
            isStoreListDisable = false;

            departmentComp.setDisabled(true);

            //AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            //AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
            //AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
            //AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
            //AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
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
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(regionComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
    }


    /**
     *
     * @param valueChangeEvent
     */

    public void onStoreVCE(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onStoreVCE()");
            Object newValue = valueChangeEvent.getNewValue();
            _logger.info("Store newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                storeVal = (String) newValue;
            } else {
                storeVal = null;
            }
            disableStoreListComponent();
            enableSearchButton();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private void disableStoreListComponent() {
        try {
            if ((regionIdVal != null && !regionIdVal.isEmpty()) || (storeVal != null && !storeVal.isEmpty())) {
                isStoreListDisable = true;
            } else {
                isStoreListDisable = false;
                if (storeListVal != null) {
                    resetStoreListComponent();
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *
     */
    private void disableRegionAndStoreComponent() {
        try {
            if (storeListVal != null && !storeListVal.isEmpty()) {
                isRegionDisable = true;
                isStoreDisable = true;
                if (regionComp != null && regionComp.getValue() != null) {
                    regionIdVal = null;
                    regionComp.setValue(null);
                }
                if (multiSelectBaseFieldsBean.getStoreComp().getValueInputText().getValue() != null) {
                    multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
                    storeVal = null;
                }
            } else {
                isRegionDisable = false;
                isStoreDisable = false;
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(regionComp);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param valueChangeEvent
     */
    public void onStoreListVCE(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onStoreListVCE()");
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
            e.printStackTrace();
        }
    }

    public void onStoreFormatVCE(ValueChangeEvent valueChangeEvent) {

    }

    /**
     *
     * @param valueChangeEvent
     */
    public void onSupplierVCE(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onSupplierVCE()");
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
            e.printStackTrace();
        }
    }


    /**
     * This method invoked AM method to fetch supplierId based on supplierCode.
     * @param supplierCode
     * @return
     */
    @SuppressWarnings("unchecked")
    private Object fetchSupplierIdFromCode(String supplierCode) {
        Object supplierId = null;

        OperationBinding supplierOpBind = AipdtUIUtil.findOperation("getSupplierIdFromCode");
        if (supplierOpBind != null) {
            supplierOpBind.getParamsMap().put("supplierCode", supplierCode);
            supplierOpBind.getParamsMap().put("deptId", deptId);
            supplierId = supplierOpBind.execute();
        }


        return supplierId;
    }


    /**
     *
     * @param valueChangeEvent
     */
    public void onSupplierListVCE(ValueChangeEvent valueChangeEvent) {
        try {
            _logger.info("Entering  onSupplierListVCE()");
            Object newValue = valueChangeEvent.getNewValue();
            _logger.info("SupplierList newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                supplierListVal = String.valueOf(newValue);
                //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                isSupplierDisable = true;
            } else {
                supplierListVal = null;
                isSupplierDisable = false;
            }
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            //AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param valueChangeEvent
     */
    @SuppressWarnings("unchecked")
    public void onRegionVCE(ValueChangeEvent valueChangeEvent) {
        try {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            _logger.info("Entering  onSupplierListVCE()");
            AipdtUIUtil.setValueToEL("#{bindings.Region.inputValue}", valueChangeEvent.getNewValue());
            Object newValue = AipdtUIUtil.resolveExpression("#{bindings.Region.attributeValue}");
            _logger.info("SupplierList newValue :" + newValue);
            if (newValue != null && !newValue.toString().isEmpty()) {
                regionIdVal = String.valueOf(newValue);
            } else {
                regionIdVal = null;
            }
            disableStoreListComponent();
            //Filter StoreVOLOV VO based on RegionId.
            OperationBinding storeOpBind = AipdtUIUtil.findOperation("filterStoreVO");
            if (storeOpBind != null) {
                storeOpBind.getParamsMap().put("regId", regionIdVal);
                storeOpBind.execute();
            }
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            storeVal = null;
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
            enableSearchButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This method prepares whereClause with selected Class and subClass values which will be used to apply filter on ItemShuttleComponent popUp table.
     */
    public void setFilterCriteriaForShuttleComponent(String classVal, String subClass, String vpnVal, String styleColor,
                                                     MultiselectInputListOfValues component) {
        try {
            RichDeclarativeComponent rcd = component;
            if (classVal != null && !classVal.isEmpty()) {
                classVal = classVal.replace(";", ",");
                rcd.getAttributes().put("ClassWhereClause", "CLASS1 IN (" + classVal + ")");
            } else {
                rcd.getAttributes().put("ClassWhereClause", null);
            }
            if (subClass != null && !subClass.isEmpty()) {
                subClass = subClass.replace(";", ",");
                rcd.getAttributes().put("SubclassWhereClause", "CLASS1 IN (" + subClass + ")");
            } else {
                rcd.getAttributes().put("SubclassWhereClause", null);
            }
            // Below block assigning vpn where clause param.
            if (vpnVal != null && !vpnVal.isEmpty()) {
                vpnVal = vpnVal.replace(";", ",");
                rcd.getAttributes().put("VPNWhereClause", "CLASS1 IN (" + vpnVal + ")");
            } else {
                rcd.getAttributes().put("VPNWhereClause", null);
            }
            // Below block assigning VPNColor where clause param.
            if (styleColor != null && !styleColor.isEmpty()) {
                styleColor = styleColor.replace(";", ",");
                rcd.getAttributes().put("StyleColorWhereClause", "CLASS1 IN (" + styleColor + ")");
            } else {
                rcd.getAttributes().put("StyleColorWhereClause", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */

    public String handleReset() {
        _logger.info("Entering  handleReset()");
        ADFFacesUtil.showPopup(resetPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }


    /**
     * Invoked on Reset Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void resetYesListener(ActionEvent actionEvent) {
        try {
            //actionEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            resetScreen();
            AipdtUIUtil.clearTableFilter(resultTable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getAppsPanelBind());
        } catch (Exception e) {
            _logger.info("Exception occured at resetYesListener()");
            e.printStackTrace();
        }
    }

    private BindingContainer getBinding() {
        BindingContext lBindingContext = BindingContext.getCurrent();
        BindingContainer bindings = lBindingContext.getCurrentBindingsEntry();
        return bindings;
    }

    /**
     * This method resets screen component values.
     */

    private void resetScreen() {
        BindingContainer bc = getBinding();
        try {
            departmentComp.setDisabled(false);
            departmentComp.resetValue();
            deptId = null;
            AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);

            isSupplierDisable = true;
            supplierComp.setDisabled(true);
            resetProductAndDestinationFields();

            defaultRadioComp.resetValue();
            defaultRadioComp.setValue(Boolean.TRUE);
            isDefaultSelected = Boolean.TRUE;
            isDefaultDisable = false;
            AdfFacesContext.getCurrentInstance().addPartialTarget(defaultRadioComp);

            exceptionRadioComp.resetValue();
            exceptionRadioComp.setValue(Boolean.FALSE);
            isExceptionSelected = Boolean.FALSE;
            isExceptionDisable = false;
            AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionRadioComp);

            isSaveBtnDisabled = true;

            resetItemListComponent();
            enableDisableItemListComponent();
            getSelectAllComp().resetValue();
            getStartDateHeaderComp().resetValue();
            getEndDateHeaderComp().resetValue();
            resetPopup.hide();
            resetViewObjectOnReset();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resutlContainer);

        } catch (Exception e) {
            _logger.info("Exception occured at handleReset()");
            e.printStackTrace();
        }
    }

    /**
     * This method will be invoked on click of Yes button on Cancel popup.
     * @param actionEvent
     */
    public void cancelBtnPopUpYesListener(ActionEvent actionEvent) {
        cancelPopup.hide();
        AipdtUIUtil.invokeAction(Constants.CANCEL);
    }


    /**
     * This method will be invoked on click of ok on save Successfull popup. this method clears screen data and resets.
     * @param actionEvent
     */
    public void okSavePopupListener(ActionEvent actionEvent) {
        saveCloseSuccessPopup.hide();
        resetScreen();
        if (isSaveAndCloseCliked) {
            ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));
        }
    }

    /**
     * This method will be invoked on click of ok on save Fail popup.
     * @param actionEvent
     */
    public void handleSaveFailedOkEvent(ActionEvent actionEvent) {
        saveFailedPopup.hide();
    }

    /**
     * This method will be invoked on click of Search button. This method collects data from search region and sends to DB package and returns result on Result section.
     * @return
     */
    @SuppressWarnings("unchecked")
    public String handleSearch() {
        try {
            Boolean isError = validateSearchData();
            String itemValFromList = null;
            String storeValFromList = null;
            String selectionType = null;
            Integer selectLevel = null;
            Map outputMap = null;

            if (!isError) {
                // This condition is to get All item which is belowngs to selected Item_List.
                if (deptId == null && itemListVal != null) {
                    itemValFromList = getItemValueFromDtListDetailTbl(Integer.valueOf(itemListVal));
                } else {
                    itemValFromList = skuIdVal;
                }
                // This condition is to get All Store which is belowngs to selected Store_List.
                if (storeVal == null && storeListVal != null) {
                    storeValFromList = getStoreValueFromDtListDetailTbl(Integer.valueOf(storeListVal));
                } else {
                    storeValFromList = storeVal;
                }
                selectionType = findSelectionType();

                _logger.info("Selection Type --> " + selectionType);

                selectLevel = findSelectionLevel();

                _logger.info("Selection Level --> " + selectLevel);
                OperationBinding storeOpBind = AipdtUIUtil.findOperation("handleSearch");
                if (storeOpBind != null) {
                    Map input = new HashMap();

                    input.put(Constants.DEPT, deptId);
                    input.put(Constants.CLASS, classId);
                    input.put(Constants.SUBCLASS, subclassId);
                    input.put(Constants.VPN, vpnIdVal);
                    input.put(Constants.VPN_COLOR, vpnColourIdVal);
                    input.put(Constants.ITEM, itemValFromList);
                    input.put(Constants.REGION, regionIdVal);
                    input.put(Constants.STORE, storeValFromList);
                    input.put(Constants.SUPPLIER, supplierVal);
                    input.put(Constants.SELECTION_LEVEL, selectLevel);
                    input.put(Constants.SELECTION_TYPE, selectionType);
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
                    //saveDisabled = false;
                    //disableSearchComponents();
                    //enableResultComponents();

                    searchBtn.setDisabled(true);
                    isSaveBtnDisabled = false;
                    disableSearchCriteriaOnSuccessfulSearch();
                    setTableRowFocusToFirstRow();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getAppsPanelBind());
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getResutlContainer());
                    AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtn);
                }
                /*else if (rowCount == 0) {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                    Constants.INVALID_SEARCH_CRITERIA),
                                                 null);
                } else {
                    AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                    Constants.DEAFULT_ERROR_MSG), null);
                } */
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
        return null;
    }

    /**
     *
     */

    private void disableSearchCriteriaOnSuccessfulSearch() {

        // Product Hierarchy disable
        setIsClassDisable(true);
        setIsSubClassDisable(true);
        setIsItemDisable(true);
        setIsVPNDisable(true);
        setIsVpnColourDisable(true);
        setIsItemListDisable(true);
        supplierComp.setDisabled(true);
        departmentComp.setDisabled(true);

        // Destination field disable
        setIsRegionDisable(true);
        setIsStoreDisable(true);
        setIsStoreListDisable(true);
        isDefaultDisable = true;
        isExceptionDisable = true;

        AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());

        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(supplierComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(defaultRadioComp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionRadioComp);

    }


    /**
     * This method enable/disables search button based on the values given in the search criteria.
     */
    private void enableSearchButton() {
        if (isExceptionSelected) {
            if (deptId != null) {
                if (deptId != null && supplierVal != null &&
                    (classId != null || subclassId != null || vpnIdVal != null || vpnColourIdVal != null ||
                     skuIdVal != null) && (storeListVal != null || storeVal != null || regionIdVal != null)) {
                    // Enable search button for Item Level
                    searchBtn.setDisabled(false);
                } else {
                    // Disable Search button.
                    searchBtn.setDisabled(true);
                }
            } else if (itemListVal != null) {
                if (supplierVal != null && ((storeListVal != null || storeVal != null || regionIdVal != null))) {
                    searchBtn.setDisabled(false);
                } else {
                    searchBtn.setDisabled(true);
                }
            } else {
                searchBtn.setDisabled(true);
            }
        } else {
            if (deptId != null) {
                if (supplierVal != null || storeListVal != null || storeVal != null || regionIdVal != null) {
                    if (supplierVal != null) {
                        //Enabling for Dept Supplier level.
                        searchBtn.setDisabled(false);
                    } else if ((storeListVal != null || storeVal != null || regionIdVal != null) &&
                               (supplierVal == null)) {
                        //Disabling Search button as Supplier is required when Destination value is selected.
                        searchBtn.setDisabled(true);
                    } else {
                        //Disable search button
                        searchBtn.setDisabled(true);
                    }
                } else {
                    //enable button . It is Department Level.
                    searchBtn.setDisabled(false);
                }
            } else {
                //Disable button as department component value is empty.
                searchBtn.setDisabled(true);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchBtn);
    }


    /**
     * This method finds selectionType value based on the Search criteria value and return Type value which will be used for fetching data in Search PLSQL package.
     * @return
     */
    private String findSelectionType() {
        String selectionType = null;
        Boolean isAllStoreSelected = isAllStoreSelected();
        if (skuIdVal != null) {
            if (storeVal != null && isAllStoreSelected) {
                selectionType = ITEM_ALL_STORE;
            } else if (regionIdVal == null && (storeVal != null || storeListVal != null)) {
                selectionType = ITEM_STORE_TYPE;
            } else if ((regionIdVal != null && storeVal == null)) {
                selectionType = ITEM_REGION;
            }
            return selectionType;
        }
        if (vpnColourIdVal != null) {
            if (storeVal != null && isAllStoreSelected) {
                selectionType = VPN_COLOUR_ALL_STORE;
            } else if (regionIdVal == null && (storeVal != null || storeListVal != null)) {
                selectionType = VPN_COLOUR_STORE;
            } else if ((regionIdVal != null && storeVal == null)) {
                selectionType = VPN_COLOUR_REGION;
            } else {
                selectionType = VPN_COLOUR_SELECTION_TYPE;
            }
            return selectionType;
        }

        if (vpnIdVal != null) {
            if (storeVal != null && isAllStoreSelected) {
                selectionType = VPN_ALL_STORE;
            } else if (regionIdVal == null && (storeVal != null || storeListVal != null)) {
                selectionType = VPN_STORE;
            } else if ((regionIdVal != null && storeVal == null)) {
                selectionType = VPN_REGION;
            } else {
                selectionType = VPN_SELECTION_TYPE;
            }
            return selectionType;
        }

        if (subclassId != null) {
            if (storeVal != null && isAllStoreSelected) {
                selectionType = SUBCLASS_ALL_STORE;
            } else if (regionIdVal == null && (storeVal != null || storeListVal != null)) {
                selectionType = SUBCLASS_STORE;
            } else if ((regionIdVal != null && storeVal == null)) {
                selectionType = SUBCLASS_REGION;
            } else {
                selectionType = SUBCLASS_SELECTION_TYPE;
            }
            return selectionType;
        }


        if (classId != null) {
            if (storeVal != null && isAllStoreSelected) {
                selectionType = CLASS_ALL_STORE;
            } else if (regionIdVal == null && (storeVal != null || storeListVal != null)) {
                selectionType = CLASS_STORE;
            } else if ((regionIdVal != null && storeVal == null)) {
                selectionType = CLASS_REGION;
            } else {
                selectionType = CLASS_LEVEL_SELECTION_TYPE;
            }
            return selectionType;
        }

        if (deptId != null) {
            if ((storeVal != null && isAllStoreSelected)) {
                selectionType = DEPT_SUPPLIER_ALL_STORE;
            } else if (regionIdVal == null && (storeVal != null || storeListVal != null)) {
                selectionType = DEPT_SUPPLIER_STORE;
            } else if ((regionIdVal != null && storeVal == null)) {
                selectionType = DEPT_SUPPLIER_REGION;
            } else if ((regionIdVal == null && storeVal == null && storeListVal == null && supplierVal != null)) {
                selectionType = DEPT_SUPPLIER_ALL_STORE;
            } else {
                selectionType = DEPT_SELECTION_TYPE;
            }
        }
        return selectionType;
    }

    /**
     * Below method returns SelectionLevel whether Dept or Dept/Supplier or Item level based on input provide in Search section.
     * @return
     */
    private Integer findSelectionLevel() {
        Integer level = 1;

        if ((classId != null && !classId.isEmpty()) || (subclassId != null && !subclassId.isEmpty()) ||
            (vpnIdVal != null && !vpnIdVal.isEmpty()) || (vpnColourIdVal != null && !vpnColourIdVal.isEmpty()) ||
            (skuIdVal != null && !skuIdVal.isEmpty())) {
            level = 3;
        } else if (supplierVal != null && !supplierVal.isEmpty()) {
            level = 2;
        } else {
            //Default Department level
        }
        return level;
    }

    /**
     * This method will be called on click of Save button on Screen.
     * @return
     */
    public String handleSave() {
        if (isRowSelectedInResultTable()) {
            Iterator<FacesMessage> isError = FacesContext.getCurrentInstance().getMessages();
            //Below condition added to skip this method execution when error thrown from Validator.
            if (!isError.hasNext()) {
                ADFFacesUtil.showPopup(saveConfirmationPopup.getClientId(FacesContext.getCurrentInstance()));
            }
        } else {
            AipdtUIUtil.showErrorMessage("Please select atleast one row to Proceed with Save", null);
        }
        return null;
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
                        ADFFacesUtil.showPopup(saveCloseSuccessPopup.getClientId(FacesContext.getCurrentInstance()));
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
     * This method will be called on click of Save And Close button on screen.
     * @return
     */

    public String handleSaveAndClose() {
        if (isRowSelectedInResultTable()) {
            Iterator<FacesMessage> isError = FacesContext.getCurrentInstance().getMessages();
            //Below condition added to skip this method execution when error thrown from Validator.
            if (!isError.hasNext()) {
                ADFFacesUtil.showPopup(saveAndCloseConfirmationPopup.getClientId(FacesContext.getCurrentInstance()));
            }
        } else {
            AipdtUIUtil.showErrorMessage("Please select atleast one row to Proceed with Save", null);
        }
        return null;
    }

    public String handleCancel() {
        ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));
        return null;
    }

    private Boolean isAllStoreSelected() {
        Boolean flag = Boolean.FALSE;
        flag = multiSelectBaseFieldsBean.isAllStoreSelected();
        return flag;
    }

    private Boolean isAllRegionSelected() {
        Boolean flag = Boolean.FALSE;
        //TODO
        if (true) {
            flag = Boolean.TRUE;
        }
        return flag;
    }

    /**
     * This method fetches Sku from DT_LIST_DETAIL table based on provided ItemList value.
     * @param itemList
     * @return
     */
    private String getItemValueFromDtListDetailTbl(Integer itemList) {
        String itemVal = null;
        OperationBinding OpBind = AipdtUIUtil.findOperation("getIdsFromDtListDetailTable");
        if (OpBind != null) {
            OpBind.getParamsMap().put("itemList", itemList);
            OpBind.getParamsMap().put("TYPE", "ITEM_LIST");
            itemVal = String.valueOf(OpBind.execute());
        }
        return itemVal;
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


    public Boolean validateSearchData() {
        Boolean flag = false;


        return flag;
    }


    /**
     * Below method will be cassed in two schenarios : 1. On click of Reset button, 2.On selection empty department.
     * This method resets all Products Hierarchy fields and Destination fields.
     */

    private void resetProductAndDestinationFields() {
        BindingContainer bind = getBinding();
        disableProductHierarchyLevelFields(true);

        isItemListDisable = Boolean.FALSE;
        resetItemListComponent();
        itemListVal = null;

        disableDestinationFields(true);

        isSupplierDisable = true;
        resetSupplierComponent();
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
     * Invoked on selection of checkbox in the detail section of result table
     * @param ValueChangeEvent
     */
    public void onSelectionOfCheckBox(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);
        if (dcItteratorBindings != null) {
            ViewObject resultVO = dcItteratorBindings.getViewObject();
            boolean newValue =
                (valueChangeEvent.getNewValue() == null) ? Boolean.FALSE :
                Boolean.parseBoolean(valueChangeEvent.getNewValue().toString());
            if (getSelectAllComp() != null) {
                if (newValue) {
                    Row[] resultsRows = resultVO.getFilteredRows("UpdateInd", Constants.UPDATE_IND_1);
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
        AdfFacesContext.getCurrentInstance().addPartialTarget(resultTable);
    }


    /**
     * Invoked on selection of checkbox in the header section of result table
     * @param ValueChangeEvent
     */
    @SuppressWarnings("unchecked")
    public void onClickSelectAllCheckBox(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        boolean isSelected = valueChangeEvent.getNewValue() == true ? true : false;
        try {
            OperationBinding storeOpBind = AipdtUIUtil.findOperation("handleCheckBoxAll");
            if (storeOpBind != null) {
                storeOpBind.getParamsMap().put("isSelected", isSelected);
                storeOpBind.execute();
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getResultTable());
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
     * Invoked on table filtering. No change in the filtering feature,
     * it only enables/disables the header level checkbox on filtering.
     * @param queryEvent
     */
    public void processQuery(QueryEvent queryEvent) {
        _logger.info("****** Inside processQuery method ******");

        //Enable or disable header level checkbox
        if (getSelectAllComp() != null) {
            DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);
            if (dcItteratorBindings != null) {
                ViewObject resultVO = dcItteratorBindings.getViewObject();
                Row[] resultsRows = resultVO.getFilteredRows("UpdateInd", Constants.UPDATE_IND_1);
                if ((resultsRows != null) && (resultsRows.length == resultVO.getEstimatedRowCount())) {
                    getSelectAllComp().setValue(Boolean.TRUE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
                } else {
                    getSelectAllComp().setValue(Boolean.FALSE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(getSelectAllComp());
                }
            }
        }

        //Process default filter query event
        AipdtUIUtil.invokeQueryEventMethodExpression("#{bindings.DeploymentTypeResultVOQuery.processQuery}",
                                                     queryEvent);
    }

    /**
     * Invoke function to display the VPN/VPN-Color/Item details.
     */
    public void viewCommodityPopup(ActionEvent actionEvent) {
        try {
            ViewObject itemHierVO = AipdtUIUtil.findIterator("DeploymentTypeItemHierPopupVOIterator").getViewObject();
            DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_CLASS_ID, currentRow.getClassId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_SUBCLASS_ID, currentRow.getSubclassId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_VPN_ID, currentRow.getStyleId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_VPN_COLOR_ID, currentRow.getStyleColorId());
            //itemHierVO.setNamedWhereClauseParam(Constants.BIND_VPN_COLOR_ID, 2);
            itemHierVO.executeQuery();
            if (itemHierVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.REC_EXCEEDS_LIMIT), null);
            } else {
                ADFFacesUtil.showPopup(itemHierarchyPopup.getClientId(FacesContext.getCurrentInstance()));
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
     *
     * @param comp
     */

    private void resetUIComponent(UIComponent comp) {
        //ResetUtils.reset(comp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(comp);
    }

    /**
     * Below method invokes AmImpl method to reset ViewObject.
     */

    private void resetViewObjectOnReset() {
        OperationBinding storeOpBind = AipdtUIUtil.findOperation("resetViewObject");
        if (storeOpBind != null) {
            storeOpBind.execute();
        }
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

    public void closePopUp(RichPopup popUpId) {
        popUpId.hide();
    }


    public void closeItemPopUp(ActionEvent actionEvent) {
        closePopUp(itemHierarchyPopup);
    }

    public void closeStorePopUp(ActionEvent actionEvent) {
        closePopUp(storePopup);
    }

    public void closeResetPopUp(ActionEvent actionEvent) {
        closePopUp(resetPopup);
        resetPopup.hide();
    }

    public void closeCancelPopUp(ActionEvent actionEvent) {
        closePopUp(cancelPopup);

    }

    /**
     * This method used to enable/disable Product Hierarchy fields based on flag input value.
     * @param isDisable
     */

    private void disableProductHierarchyLevelFields(Boolean isDisable) {
        try {
            setIsClassDisable(isDisable);
            setIsSubClassDisable(isDisable);
            setIsItemDisable(isDisable);
            setIsVPNDisable(isDisable);
            setIsVpnColourDisable(isDisable);
            setIsItemListDisable(!isDisable);

            if (isDisable) {
                skuIdVal = null;
                classId = null;
                subclassId = null;
                vpnIdVal = null;
                vpnColourIdVal = null;
                deptId = null;

                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getItemComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
                multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());
                resetSupplierComponent();
                multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
                multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());

            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getVpnComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStyleColourComp());

            AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());
            //AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method used to enable/disable Destination fields based on flag input value.
     * @param isDisable
     */

    private void disableDestinationFields(Boolean isDisable) {
        try {
            if (isDisable) {
                setIsRegionDisable(isDisable);
                setIsStoreDisable(isDisable);
                setIsStoreListDisable(isDisable);
                storeVal = null;
                storeListVal = null;
                resetRegionComponent();
                storeListComp.resetValue();
                multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            } else {
                // This else condition is to handle when Department value is changes, to restrict Destination value enable/disable as it alredy been changed.
                if (storeVal != null || storeListVal != null || regionIdVal != null) {

                } else {
                    setIsRegionDisable(isDisable);
                    setIsStoreDisable(isDisable);
                    setIsStoreListDisable(isDisable);
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param isEnable
     */

    private void resetRegionComponent() {
        if (regionIdVal != null) {
            regionIdVal = null;
            BindingContainer bc = getBinding();
            JUCtrlListBinding list = (JUCtrlListBinding) bc.get("Region");
            list.setSelectedIndex(-1);
            list.clearSelectedIndices();
            regionComp.resetValue();
            AdfFacesContext.getCurrentInstance().addPartialTarget(getRegionComp());
        }
    }

    /**
     * this method resets Itemlist component value if any values selected.
     */
    private void resetItemListComponent() {
        if (itemListVal != null) {
            itemListVal = null;
            BindingContainer bc = getBinding();
            JUCtrlListBinding list = (JUCtrlListBinding) bc.get("ItemList");
            list.setSelectedIndex(-1);
            list.clearSelectedIndices();
            itemListComp.resetValue();
            AdfFacesContext.getCurrentInstance().addPartialTarget(itemListComp);
        }
    }

    /**
     * this method resets StoreList component value if any values selected.
     */
    private void resetStoreListComponent() {
        if (storeListVal != null) {
            storeListVal = null;
            BindingContainer bc = getBinding();
            JUCtrlListBinding list = (JUCtrlListBinding) bc.get("StoreList");
            list.setSelectedIndex(-1);
            list.clearSelectedIndices();
            storeListComp.resetValue();
            AdfFacesContext.getCurrentInstance().addPartialTarget(getStoreListComp());
        }
    }


    private void disableAllDependantComponent(Boolean isEnable) {

        setIsClassDisable(isEnable);
        setIsSubClassDisable(isEnable);
        setIsItemDisable(isEnable);
        //setIsItemListDisable(isEnable);
        setIsVPNDisable(isEnable);
        setIsStoreDisable(isEnable);
        setIsStoreListDisable(isEnable);
        setIsAllItemDisable(isEnable);
        setIsSupplierDisable(isEnable);
        setIsSupplierListDisable(isEnable);


        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getSubClassComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getItemComp());

        AdfFacesContext.getCurrentInstance().addPartialTarget(getItemListComp());

        AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());

        AdfFacesContext.getCurrentInstance().addPartialTarget(getSupplierComp());
        AdfFacesContext.getCurrentInstance().addPartialTarget(storeListComp);
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
        AipdtUIUtil.selectAllRowsInTable(getResultTable(), DEPLOYMENT_TYPE_RESULT_VO_ITERATOR, "UpdateInd");
        return Boolean.TRUE;
    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onDefaultVCE(ValueChangeEvent valueChangeEvent) {
        isDefaultSelected = (Boolean) valueChangeEvent.getNewValue();

    }

    /**
     *
     * @param valueChangeEvent
     */

    public void onExceptionVCE(ValueChangeEvent valueChangeEvent) {
        isExceptionSelected = (Boolean) valueChangeEvent.getNewValue();
        if (deptId != null && !deptId.isEmpty()) {
            setIsClassDisable(!isExceptionSelected);
            setIsSubClassDisable(!isExceptionSelected);
            setIsItemDisable(!isExceptionSelected);
            setIsVPNDisable(!isExceptionSelected);
            setIsVpnColourDisable(!isExceptionSelected);
            if (isExceptionSelected) {
                classId = null;
                filterClassComponent();
                subclassId = null;
                filterSubClassComponent();
                vpnIdVal = null;
                filterVPNComponent();
                vpnColourIdVal = null;
                filterVPNColourComponent();
                skuIdVal = null;
                filterSkuComponent();
            } else {
                if (classId != null) {
                    multiSelectBaseFieldsBean.getClassComp().resetDeclarativeComponent();
                    classId = null;
                }
                if (subclassId != null) {
                    multiSelectBaseFieldsBean.getSubClassComp().resetDeclarativeComponent();
                    subclassId = null;
                }

                if (vpnIdVal != null) {
                    multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getVpnComp());
                    vpnIdVal = null;
                }
                if (vpnColourIdVal != null) {
                    multiSelectBaseFieldsBean.resetMultiShuttleComponent(multiSelectBaseFieldsBean.getStyleColourComp());
                    vpnColourIdVal = null;
                }
                if (skuIdVal != null) {
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
            }
        } else if (itemListVal != null) {
            // this block is to handle when ItemList value selected and Changing Radiobutton from Exception to Default.
            isStoreListDisable = true;
            isSupplierDisable = true;
            isItemListDisable = true;
            isRegionDisable = true;
            supplierComp.setDisabled(true);
            resetSupplierComponent();
            resetDestinationComponents();
            isStoreDisable = true;
            resetItemListComponent();
            departmentComp.setDisabled(false);

            AdfFacesContext.getCurrentInstance().addPartialTarget(departmentComp);
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        } else {
            // Nothing to do.
        }
        enableDisableItemListComponent();
        enableSearchButton();
    }

    /**
     * This method consolidates resetMethod of DestinationFields and invokes each method and resets component.
     */
    private void resetDestinationComponents() {
        resetRegionComponent();
        resetStoreListComponent();
        if (storeVal != null) {
            multiSelectBaseFieldsBean.getStoreComp().resetDeclarativeComponent();
            AdfFacesContext.getCurrentInstance().addPartialTarget(multiSelectBaseFieldsBean.getStoreComp());
        }
    }

    /**
     * Invoke function to display the VPN/VPN-Color/Item details.
     */
    public void onClickViewItemPopup(ActionEvent actionEvent) {
        try {
            ViewObject itemHierVO = AipdtUIUtil.findIterator(Constants.DEPLTYPE_ITEMPOPUPVO_ITER).getViewObject();
            DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_DEPARTMENT_ID, currentRow.getDepartmentId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_CLASS_ID, currentRow.getClassId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_SUBCLASS_ID, currentRow.getSubclassId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_VPN_ID, currentRow.getStyleId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_VPN_COLOR_ID, currentRow.getStyleColorId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_SKU_ID, currentRow.getCommodityId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_SUPPLIER_ID, currentRow.getSupplierId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_STORE_ID, currentRow.getStoreId());
            itemHierVO.setNamedWhereClauseParam(Constants.BIND_REGION_ID, currentRow.getRegionId());
            itemHierVO.executeQuery();
            if (itemHierVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.REC_EXCEEDS_LIMIT), null);
            } else {
                ADFFacesUtil.showPopup(itemHierarchyPopup.getClientId(FacesContext.getCurrentInstance()));
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
     * Invoke function to display the store details in the popup-onclick of ALL_STORES link.
     */
    public void onClickViewStorePopup(ActionEvent actionEvent) {
        try {
            ViewObject storeVO = AipdtUIUtil.findIterator(Constants.DEPLTYPE_STOREVO_ITER).getViewObject();

            DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());
            storeVO.setNamedWhereClauseParam(Constants.BIND_DEPARTMENT_ID, currentRow.getDepartmentId());
            storeVO.setNamedWhereClauseParam(Constants.BIND_CLASS_ID, currentRow.getClassId());
            storeVO.setNamedWhereClauseParam(Constants.BIND_SUBCLASS_ID, currentRow.getSubclassId());
            storeVO.setNamedWhereClauseParam(Constants.BIND_VPN_ID, currentRow.getStyleId());
            storeVO.setNamedWhereClauseParam(Constants.BIND_VPN_COLOR_ID, currentRow.getStyleColorId());
            storeVO.setNamedWhereClauseParam(Constants.BIND_SKU_ID, currentRow.getCommodityId());
            storeVO.setNamedWhereClauseParam(Constants.BIND_SUPPLIER_ID, currentRow.getSupplierId());
            storeVO.setNamedWhereClauseParam(Constants.BIND_REGION_ID, currentRow.getRegionId());
            storeVO.executeQuery();

            if (storeVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.REC_EXCEEDS_LIMIT), null);
            } else {
                ADFFacesUtil.showPopup(storePopup.getClientId(FacesContext.getCurrentInstance()));
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
     * Invoke function to display the store details in the popup-onclick of ALL_STORES link.
     */
    public void onClickViewSupplierPopup(ActionEvent actionEvent) {
        try {
            ViewObject supplierVO = AipdtUIUtil.findIterator(Constants.DEPLTYPE_SUPPLIERVO_ITER).getViewObject();

            DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());
            String whereClause = Constants.DEPARTMENTID_WHERE_CLAUSE_PARAM + " = " + currentRow.getDepartmentId();
            supplierVO.setWhereClause(null);
            supplierVO.setWhereClause(whereClause);
            supplierVO.executeQuery();
            if (supplierVO.getEstimatedRowCount() > Constants.RESULT_SET_SIZE) {
                AipdtUIUtil.showErrorMessage(AipdtUIUtil.getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE,
                                                                                Constants.REC_EXCEEDS_LIMIT), null);
            } else {
                ADFFacesUtil.showPopup(supplierPopup.getClientId(FacesContext.getCurrentInstance()));
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
     * This method handles EndDate SetAll button functionality.
     * @return
     */
    @SuppressWarnings("unchecked")

    public String handleEndDateSetAll(ActionEvent actionEvent) {
        actionEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (!isDefaultSelected) {
            if (endDateHeaderComp != null && endDateHeaderComp.getValue() != null) {
                if (isRowSelectedInResultTable()) {
                    Date endDate = (Date) endDateHeaderComp.getValue();
                    String errorMsg = checkValidationOnSetAll(endDate, Constants.END_DATE);
                    if (errorMsg == null) {
                        Map inputMap = new HashMap();
                        inputMap.put(Constants.END_DATE, endDateHeaderComp.getValue());
                        inputMap.put(Constants.SET_ALL_FLAG, 1);
                        invokeHandleSetAllAmMethod(inputMap);
                        endDateHeaderComp.resetValue();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(resutlContainer);
                    } else {
                        AipdtUIUtil.showErrorMessage(errorMsg, null);

                        // AipdtUIUtil.showErrorMessage("SetAll caanot be done with this EndDate. Please provide proper value.",
                        //                            null);
                    }
                } else {
                    AipdtUIUtil.showErrorMessage("Please select rows to apply setAll", null);
                }
            } else {
                AipdtUIUtil.showErrorMessage("Please provide End Date to apply setAll", endDateHeaderComp);
            }
        } else {
            AipdtUIUtil.showErrorMessage("SetAll on EndDate cannot be applied on Default DeploymentType selection",
                                         null);
        }
        return null;
    }


    /**
     * This method handles StartDate SetAll button functionality.
     * @return
     */
    @SuppressWarnings("unchecked")

    public String handleOnStartDateSetAll() {
        //actionEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (startDateHeaderComp.getValue() != null) {
            if (isRowSelectedInResultTable()) {
                Date startDate = (Date) startDateHeaderComp.getValue();
                String errorMsg = checkValidationOnSetAll(startDate, Constants.START_DATE);
                if (errorMsg == null) {
                    Map inputMap = new HashMap();
                    inputMap.put(Constants.SET_ALL_FLAG, 0);
                    inputMap.put(Constants.START_DATE, startDateHeaderComp.getValue());
                    invokeHandleSetAllAmMethod(inputMap);
                    startDateHeaderComp.resetValue();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(resutlContainer);
                    //return null;
                } else {
                    AipdtUIUtil.showErrorMessage(errorMsg, null);
                    //("SetAll caanot be done with this StartDate. Please provide proper value.",
                    //   startDateHeaderComp);
                }
            } else {
                AipdtUIUtil.showErrorMessage("Please select rows to apply setAll", null);
            }
        } else {
            AipdtUIUtil.showErrorMessage("Please provide Start Date to apply setAll", startDateHeaderComp);
        }
        return null;
    }

    /**
     * This method gets All selected Rows from Table and compares each rows start and End Date with other unique combination rows value.
     * This method
     * @param inputDate
     * @param type
     * @return
     */

    private String checkValidationOnSetAll(Date inputDate, String type) {
        String isException = null;
        Integer level = findSelectionLevel();
        // Below check is added to enable to perform this validation for all level except Department and Department/Supplier level.
        if (level.compareTo(3) == 0) {
            RowSetIterator rwoSetIter = getResultVORowSetIterator();
            Row[] rows = rwoSetIter.getFilteredRows("UpdateInd", "1");
            for (int index = 0; index < rows.length; index++) {
                isException = null;
                DeploymentTypeResultVORowImpl masterRow = (DeploymentTypeResultVORowImpl) rows[index];
                isException = isOverLapOnDateExist(masterRow, inputDate, type);
                if (isException != null) {
                    break;
                }
            }
        }
        return isException;
    }

    private RowSetIterator getResultVORowSetIterator() {
        DCIteratorBinding resultIter = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);
        RowSetIterator rwoSetIter = resultIter.getViewObject().createRowSetIterator(null);
        return rwoSetIter;
    }

    private String isOverLapOnDateExist(DeploymentTypeResultVORowImpl masterRow, Date inputDate, String type) {
        String ErrorMsg = null;
        StringBuffer errorString = new StringBuffer();
        BigDecimal skuId = masterRow.getCommodityId();
        BigDecimal supplierId = masterRow.getSupplierId();
        BigDecimal storeId = masterRow.getStoreId();
        if (storeId != null && skuId != null) {
            Row[] rowSet = getMatchedRows(skuId, supplierId, storeId);
            DCIteratorBinding resultIter = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);
            // Below condition makes sure that if only one row found than it will skip as Current row match will lead to count 1.
            for (int count = 0; count < rowSet.length; count++) {
                DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) rowSet[count];
                if (masterRow.getKey().hashCode() != currentRow.getKey().hashCode()) {
                    if (currentRow.getStartDate() != null) {
                        Object updateInd = currentRow.getUpdateInd();
                        // Below condition is to separate check for selectedRows and Unselected Rows.
                        // If Same Combination found on selected Rows then error will be thrown.
                        // If Same Combination with Same StartDate/EndDate available on Unselected Rows, then exception will be thrown.
                        if (updateInd != null && Integer.valueOf(updateInd.toString()).compareTo(1) == 0) {
                            errorString.append("Set All Cannot be performed on more than one selected combination of  Sku : " +
                                               masterRow.getCommodityCode() + ", Order From Supplier : " +
                                               masterRow.getSupplierCode() + ", Store : " + masterRow.getStoreCode());
                            break;
                        } else {
                            if (type.equalsIgnoreCase(Constants.START_DATE)) {
                                if (currentRow.getStartDate().compareTo(inputDate) == 0) {
                                    errorString.append("With StartDate " + AipdtUIUtil.getDateFormatted(inputDate) +
                                                       " Already row exists with Combination : Sku : " +
                                                       masterRow.getCommodityCode() + ", Order From Supplier : " +
                                                       masterRow.getSupplierCode() + ", Store : " +
                                                       masterRow.getStoreCode());
                                    break;
                                }
                            } else {
                                if (currentRow.getEndDate().compareTo(inputDate) == 0) {
                                    errorString.append("With EndDate " + AipdtUIUtil.getDateFormatted(inputDate) +
                                                       " Already row exists with Combination : Sku : " +
                                                       masterRow.getCommodityCode() + ", Order From Supplier : " +
                                                       masterRow.getSupplierCode() + ", Store : " +
                                                       masterRow.getStoreCode());
                                    break;
                                }
                            }
                        }


                    } else {
                        _logger.info("Found Same row");
                    }
                }
            }
            resetRowSetIterator();
            if (errorString != null && !errorString.toString().isEmpty()) {
                ErrorMsg = errorString.toString();
                //"SetAll cannot be done as More than one row exists with the Combination - " +
            }
        }
        return ErrorMsg;
    }


    private Row[] getMatchedRows(BigDecimal skuId, BigDecimal supplierId, BigDecimal storeId) {
        RowSetIterator rowSetIter = null;
        DCIteratorBinding resultIter = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);
        /*RowIterator rowSet1 = resultIter.getViewObject().findByAltKey(DEPLOYMENT_TYPE_RESULTEO_ALTKEY_WITHOUTDATE, new Key(new Object[] {
                                                                                                                           skuId,
                                                                                                                           storeId,
                                                                                                                           supplierId


            }), -1, true);  */

        DeploymentTypeResultVOImpl voImpl = (DeploymentTypeResultVOImpl) resultIter.getViewObject();
        RowQualifier rq =
            new RowQualifier("CommodityId = " + skuId + " AND StoreId = " + storeId + " AND SupplierId = " +
                             supplierId);
        //vo.setRowMatch(rm);
        //vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_ENTITY_ROWS);
        //vo.executeQuery();
        //rowSetIter = vo.createRowSetIterator(null);
        //vo.setRowMatch(null);

        Row[] rows = voImpl.getFilteredRows(rq);

        return rows;
    }


    private void resetRowSetIterator() {
        RowSetIterator rowIter = null;
        try {
            DCIteratorBinding resultIter = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);
            rowIter = resultIter.getViewObject().createRowSetIterator(null);
            if (rowIter != null) {
                rowIter.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rowIter != null) {
                rowIter.closeRowSetIterator();
            }
        }
    }


    /**
     * This method invoked handleSetAll method which is written in DeploymentTypeAmImpl class and apply date value to selected rows.
     * @param inputMap
     */

    @SuppressWarnings("unchecked")
    private void invokeHandleSetAllAmMethod(Map inputMap) {

        OperationBinding storeOpBind = AipdtUIUtil.findOperation("handleSetAll");
        if (storeOpBind != null) {
            storeOpBind.getParamsMap().put("setAllMap", inputMap);
            storeOpBind.execute();
        }

    }


    public void onDeploymentTypeVCE(ValueChangeEvent valueChangeEvent) {
        DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());
        String oldVal = currentRow.getDeploymentType();
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        try {
            if (currentRow.getStartDate().before(vDate)) {
                AipdtUIUtil.showErrorMessage("Deployment Type can not be set to past Date. Please change start Date to valid date.",
                                             null);
                currentRow.setDeploymentType(oldVal);
                AdfFacesContext.getCurrentInstance().addPartialTarget(valueChangeEvent.getComponent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method checks whether any checkBox has been selected in any of the Result rows or not and returns tru or false value.
     * @return
     */

    private Boolean isRowSelectedInResultTable() {
        RowSetIterator rowSet = null;
        DCIteratorBinding dcItteratorBindings = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);
        if (dcItteratorBindings != null) {
            ViewObject resultVO = dcItteratorBindings.getViewObject();
            if (resultVO != null) {
                rowSet = resultVO.createRowSetIterator(null);
                Row[] rows = rowSet.getFilteredRows("UpdateInd", "1");
                if (rows != null && rows.length > 0) {
                    return true;
                }
            }
        }
        if (rowSet != null) {
            rowSet.closeRowSetIterator();
        }
        return false;
    }

    public void onStartDateValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        try {
            System.out.println("");
            //dateMinAndMaxRangeValidation(facesContext, uIComponent, object);

            /*DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());

            Object startDtObj = currentRow.getAttribute("StartDate");
            Object endDtObj = currentRow.getAttribute("EndDate");
            if (startDtObj != null && endDtObj != null) {
                java.util.Date startDate = (java.util.Date) startDtObj;
                java.util.Date endDate = (java.util.Date) endDtObj;
                if (startDate.compareTo(endDate) <= 0) {
                    Integer level = findSelectionLevel();
                    if (level == 3) {
                        Boolean isException = isOverLapOnDateExist(currentRow, (Date) object, Constants.START_DATE);
                        if (isException) {
                            facesContext.addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                                     "With StartDate " + object +
                                                                     " already row exists. Please provide valid date."));
                            //                            AipdtUIUtil.showErrorMessage("With StartDate " + object +
                            //                                                         " already row exists. Please provide valid date.", null);
                        }
                    }
                } else {
                    facesContext.addMessage(startDateRowLevelComp.getClientId(facesContext),
                                            new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                                                             "Please Enter Start Date between " +
                                                             AipdtUIUtil.getDateFormatted(getVDate()) + " and " +
                                                             AipdtUIUtil.getDateFormatted((java.util.Date) endDtObj)));

                }
            }  */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dateMinAndMaxRangeValidation(FacesContext facesContext, UIComponent uIComponent, Object object) {
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
            }
        }
    }

    public void onEndDateValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        try {
            //dateMinAndMaxRangeValidation(facesContext, uIComponent, object);
            /* DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());
            Integer level = findSelectionLevel();
            if (level == 3) {
                Boolean isException = isOverLapOnDateExist(currentRow, (Date) object, Constants.END_DATE);
                if (isException) {
                    AipdtUIUtil.showErrorMessage("With EndDate " + object +
                                                 " already row exists. Please change date accordingly.", null);
                }
            }  */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDeploymentTypeValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) getSelectedRow(getResultTable());
        /*if (currentRow.getStartDate().before(vDate)) {
            AipdtUIUtil.showErrorMessage("Deployment Type can not be set to past Date. Please change start Date to valid date.",
                                         startDateRowLevelComp);
        }*/
    }


    /**
     * Construts network path export file name
     * @return
     *      Export file name
     */
    public String getExportFileName() {
        return AipdtUIUtil.getExportFileName(Constants.DEPL_TYPE_EXPORT_FILE_NAME);
    }

    /**
     * Invoked on Save Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleSaveYesListener(ActionEvent actionEvent) {
        try {
            saveConfirmationPopup.hide();
            isSaveAndCloseCliked = Boolean.FALSE;
            processSave();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked on Save No condition - This will Close Save confirmation popup.
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
     * Invoked on SaveAndClose Yes condition - This will invoke reseScreen method and clear cache
     * @param ActionEvent
     */
    public void handleSaveAndCloseYesListener(ActionEvent actionEvent) {
        try {
            saveAndCloseConfirmationPopup.hide();
            ViewObject resultVO = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR).getViewObject();
            if (resultVO.getApplicationModule().getTransaction().isDirty()) {
                isSaveAndCloseCliked = Boolean.TRUE;
                processSave();
                //Cancel screen code to be written.
            } else {
                AipdtUIUtil.invokeAction(Constants.CANCEL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked on SaveAndClose No condition - This will Close Save confirmation popup.
     * @param ActionEvent
     */
    public void handleSaveAndCloseNoListener(ActionEvent actionEvent) {
        try {
            getSaveCloseSuccessPopup().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void OnstartDateVCE(ValueChangeEvent valueChangeEvent) {
        String errorMsg = null;
        Object newValue = valueChangeEvent.getNewValue();
        Object oldValue = valueChangeEvent.getOldValue();
        try {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            if (newValue != null) {
                DeploymentTypeResultVORowImpl masterRow = (DeploymentTypeResultVORowImpl) getSelectedRow(resultTable);
                errorMsg = checkOverlapOnRowLevelDateVCE(masterRow, (Date) newValue, Constants.START_DATE);
                if (errorMsg != null && !errorMsg.isEmpty()) {
                    //valueChangeEvent.getComponent().processRestoreState(FacesContext.getCurrentInstance(), oldValue);

                    masterRow.setStartDate((java.sql.Date) oldValue);
                    //restoreState(FacesContext.getCurrentInstance(), oldValue.toString());
                    AdfFacesContext.getCurrentInstance().addPartialTarget(startDateRowLevelComp);
                    AipdtUIUtil.showErrorMessage(errorMsg, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OnEndDateVCE(ValueChangeEvent valueChangeEvent) {
        String errorMsg = null;
        Object newValue = valueChangeEvent.getNewValue();
        try {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            if (newValue != null) {
                DeploymentTypeResultVORowImpl masterRow = (DeploymentTypeResultVORowImpl) getSelectedRow(resultTable);
                errorMsg = checkOverlapOnRowLevelDateVCE(masterRow, (Date) newValue, Constants.END_DATE);
                if (errorMsg != null && !errorMsg.isEmpty()) {
                    masterRow.setEndDate((java.sql.Date) valueChangeEvent.getOldValue());
                    AdfFacesContext.getCurrentInstance().addPartialTarget(valueChangeEvent.getComponent());
                    AipdtUIUtil.showErrorMessage(errorMsg, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(startDateRowLevelComp);
    }


    private String checkOverlapOnRowLevelDateVCE(DeploymentTypeResultVORowImpl masterRow, Date inputDate, String type) {
        StringBuffer errorString = new StringBuffer();
        BigDecimal skuId = masterRow.getCommodityId();
        BigDecimal supplierId = masterRow.getSupplierId();
        BigDecimal storeId = masterRow.getStoreId();
        String ErrorMsg = null;
        if (storeId != null && skuId != null) {
            Row[] rowArray = getMatchedRows(skuId, supplierId, storeId);
            // Below condition makes sure that if only one row found than it will skip as Current row match will lead to count 1.
            for (int count = 0; count < rowArray.length; count++) {
                DeploymentTypeResultVORowImpl currentRow = (DeploymentTypeResultVORowImpl) rowArray[count];
                if (masterRow.getKey().hashCode() != currentRow.getKey().hashCode()) {
                    if (currentRow.getStartDate() != null) {
                        Object updateInd = currentRow.getUpdateInd();
                        // Below condition is to separate check for selectedRows and Unselected Rows.
                        // If Same Combination with Same StartDate/EndDate available on Unselected Rows, then exception will be thrown.

                        if (type.equalsIgnoreCase(Constants.START_DATE)) {
                            if (currentRow.getStartDate().compareTo(inputDate) == 0) {
                                errorString.append("With StartDate " + AipdtUIUtil.getDateFormatted(inputDate) +
                                                   " Already row exists with Combination : Sku : " +
                                                   masterRow.getCommodityCode() + ", Order From Supplier : " +
                                                   masterRow.getSupplierCode() + ", Store : " +
                                                   masterRow.getStoreCode());
                                break;
                            }
                        } else {
                            if (currentRow.getEndDate().compareTo(inputDate) == 0) {
                                errorString.append("With EndDate " + AipdtUIUtil.getDateFormatted(inputDate) +
                                                   " Already row exists with Combination : Sku : " +
                                                   masterRow.getCommodityCode() + ", Order From Supplier : " +
                                                   masterRow.getSupplierCode() + ", Store : " +
                                                   masterRow.getStoreCode());
                                break;
                            }
                        }
                    } else {
                        _logger.info("Found Same row");
                    }
                }
            }

            if (errorString != null && !errorString.toString().isEmpty()) {
                ErrorMsg = errorString.toString();
                //"SetAll cannot be done as More than one row exists with the Combination - " +
            }
        }
        return ErrorMsg;
    }


    @SuppressWarnings("unchecked")
    private void setTableRowFocusToFirstRow() {
        try {
            DCIteratorBinding resultIter = AipdtUIUtil.findIterator(DEPLOYMENT_TYPE_RESULT_VO_ITERATOR);

            Row cRow = resultIter.getViewObject().getRowAtRangeIndex(0);
            if (cRow != null) {
                System.out.println("Current row is not null so fixed ");
                resultIter.setCurrentRowIndexInRange(0);
                RowKeySetImpl rks = new RowKeySetImpl();
                ArrayList keyList = new ArrayList();
                keyList.add(cRow.getKey());
                rks.add(keyList);
                resultTable.setSelectedRowKeys(rks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


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

    public void setSupplierListComp(RichSelectOneChoice supplierListComp) {
        this.supplierListComp = supplierListComp;
    }

    public RichSelectOneChoice getSupplierListComp() {
        return supplierListComp;
    }

    public void setItemListComp(RichSelectOneChoice itemListComp) {
        this.itemListComp = itemListComp;
    }

    public RichSelectOneChoice getItemListComp() {
        return itemListComp;
    }
}
