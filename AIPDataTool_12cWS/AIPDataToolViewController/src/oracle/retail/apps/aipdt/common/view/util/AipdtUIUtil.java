package oracle.retail.apps.aipdt.common.view.util;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.adf.view.rich.model.AttributeCriterion;
import oracle.adf.view.rich.model.ConjunctionCriterion;
import oracle.adf.view.rich.model.Criterion;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.javatools.resourcebundle.BundleFactory;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.adfbc.AipdtApplicationModuleImpl;
import oracle.retail.apps.aipdt.common.model.util.DateUtil;
import oracle.retail.apps.aipdt.root.model.applicationmodule.AipdtRootAMImpl;

import org.apache.commons.lang.StringUtils;
import org.apache.myfaces.trinidad.component.UIXComponent;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;

public class AipdtUIUtil {
    private static ADFLogger logger = ADFLogger.createADFLogger(AipdtUIUtil.class);

    public AipdtUIUtil() {
        super();
    }

    /**
     * Function to get the Current Bindings Entry.
     */
    public static BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /**
     * Determines if a warning is needed when user clicks on a cancel button
     * and either shows warning in case it is needed or invokes a cancel action
     * specified by the parameter cancelAction. Logic to determine warning is �
     * 1. Not needed if mode is read only
     * 2. Not needed if transaction is not dirty
     *
     * @param cancelPopup handle to popup component that needs to be displayed as cancel warning
     * @param cancelAction name of task flow control flow to navigate to in case warning is not needed
     */
    /*public static void showPopupOrCancel(RichPopup cancelPopup, String cancelAction) {
        if (AipdtAccessibilityMode.isViewMode() || !isDirtyTransaction())
            invokeAction(cancelAction);
        else
            ADFFacesUtil.showPopup(cancelPopup.getClientId(FacesContext.getCurrentInstance()));

    }*/


    /**
     * Helper method to execute an operation and refresh a UI component subsequently.
     * It is a very common scenario in ADF screens.
     *
     * @param operation operation to execute
     * @param component component to refresh
     */
    public static void executeAndRefresh(String operation, UIXComponent component) {
        DCBindingContainer bc = (DCBindingContainer) AipdtUIUtil.getBindings();
        OperationBinding oper = bc.getOperationBinding(operation);
        oper.execute();
        if (!oper.getErrors().isEmpty()) {
            logger.warning("Error occured during model.Delete.execute");
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(component);

    }

    /**
     * A way of programmatically invoking a task flow navigation action.
     *
     * @param action name of task flow action to invoke.
     */
    public static void invokeAction(String action) {
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler handler = context.getApplication().getNavigationHandler();
        handler.handleNavigation(context, "", action);
    }

    /**
     * Checks whether current transaction has any unsaved changes.
     * @return true if there are unsaved changes, false otherwise
     */
    public static boolean isDirtyTransaction() {
        boolean isDirty = false;
        ControllerContext cctx = ControllerContext.getInstance();
        if (cctx.getCurrentViewPort().isDataDirty()) {
            isDirty = true;
        }
        DCBindingContainer bc = (DCBindingContainer) AipdtUIUtil.getBindings();
        if (bc.getDataControl() == null)
            return isDirty;
        ApplicationModule am = bc.getDataControl().getApplicationModule();

        if (am == null || !(am instanceof AipdtApplicationModuleImpl))
            return isDirty;
        return isDirty || ((AipdtApplicationModuleImpl) am).isTransactionDirtyInDB();


    }


    /**
     * Find an iterator binding in the current binding container by name.
     *
     * @param name iterator binding name
     * @return iterator binding
     */
    public static DCIteratorBinding findIterator(String name) {
        DCIteratorBinding iter = getDCBindingContainer().findIteratorBinding(name);
        /*
            if (iter == null) {
                throw new RuntimeException("Iterator '" + name + "' not found");
            }*/
        return iter;
    }
    
    /**
     * Find an iterator binding in the current binding container by name.
     *
     * @param name iterator binding name
     * @return iterator binding
     */
    public static ViewObject viewObjectByIteratorBinding(String iteratorName) {
        DCIteratorBinding iter = getDCBindingContainer().findIteratorBinding(iteratorName);
            if (iter == null) {
                throw new RuntimeException("Iterator '" + iteratorName + "' not found");
            }            
        return iter.getViewObject();
    }


    /**
     * Return the Binding Container as a DCBindingContainer.
     * @return current binding container as a DCBindingContainer
     */
    public static DCBindingContainer getDCBindingContainer() {
        return (DCBindingContainer) getBindingContainer();
    }

    /**
     * Return the current page's binding container.
     * @return the current page's binding container
     */
    public static BindingContainer getBindingContainer() {
        return (BindingContainer) resolveExpression("#{bindings}");
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching object (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        ELContext elContext = facesContext.getELContext();
        return getExpression(expression).getValue(elContext);
    }

    /**
     * Method for seting index value to expression
     * @param EL expression and index value
     * @return void
     */
    public static void setValueToEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);
        exp.setValue(elContext, val);
    }

    /**Method to get value expression given the corresponding EL expression
     * @param expression
     * @return
     */
    public static ValueExpression getExpression(String expression) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp;
    }

    /**Method to get value expression given the corresponding EL expression
     * @param expression
     * @return
     */
    public static Object getValueExpression(String expression) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }

    /**Method to get method expression given the corresponding EL expression
     * @param expression
     * @return
     */
    public static MethodExpression getMethodExpression(String expression, Class<?> returnType, Class[] argTypes) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        MethodExpression methodExp = elFactory.createMethodExpression(elContext, expression, returnType, argTypes);
        return methodExp;
    }

    /**
     * Invokes a method EL and returns the value result of method invocation.
     * @param expression
     * @param returnType
     * @param argTypes
     * @param args
     * @return result of the method expression
     */
    public static Object invokeMethodExpression(String expression, Class<?> returnType, Class[] argTypes,
                                                Object[] args) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        MethodExpression me = getMethodExpression(expression, returnType, argTypes);
        return me.invoke(elContext, args);
    }

    public static void invokeQueryEventMethodExpression(String expression, QueryEvent queryEvent) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ELContext elctx = fctx.getELContext();
        ExpressionFactory efactory = fctx.getApplication().getExpressionFactory();
        MethodExpression me = efactory.createMethodExpression(elctx, expression, Object.class, new Class[] {
                                                              QueryEvent.class });
        me.invoke(elctx, new Object[] { queryEvent });
    }

    /**
     * Get FacesContext.
     * @return FacesContext
     */
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Find an operation binding in the current binding container by name.
     *
     * @param name operation binding name
     * @return operation binding
     */
    public static OperationBinding findOperation(String name) {
        OperationBinding op = getDCBindingContainer().getOperationBinding(name);
        /*
            if (op == null) {
                throw new RuntimeException("Operation '" + name + "' not found");
            }*/
        return op;
    }

    /**
     * This method retrieves localized strings from a given XLIF resource bundle.
     *
     * @param bundleName The XLIF bundle from which the localized string is to be retrieved.
     * @param key The key of the localized string.
     * @return The localized string retrieved from the given XLIF bundle.
     */

    public static String getXlifLocalizedString(String bundleName, String key) {
        if (StringUtils.isEmpty(key)) {
            return key;
        }
        if (StringUtils.isEmpty(bundleName)) {
            return "[" + key + "]";
        }
        String localizedString = null;
        ResourceBundle resourceBundle = null;
        try {
            Locale locale = Locale.getDefault();
            resourceBundle = BundleFactory.getBundle(bundleName, locale);
            localizedString = resourceBundle.getString(key);

        } catch (Exception e) {
            return "[" + key + "]";
        }
        return localizedString;
    }

    /**
     * This method will return the Application module
     * @param applicationModuleName
     * @return
     */
    public static ApplicationModuleImpl getApplicationModule(String applicationModuleName) {
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCBindingContainer bindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCDataControl dc =
            bindingContainer.findDataControl(applicationModuleName); // Name of application module in datacontrolBinding.cpx
        if (dc == null)
            return null;
        ApplicationModuleImpl am = (ApplicationModuleImpl) dc.getDataProvider();
        return am;
    }

    /**
     * Locate an UIComponent in view root with its component id. Use a recursive way to achieve this.
     *
     * @param id
     * @return UIComponent object
     */
    public static UIComponent findComponentInRoot(String id) {
        logger.info("findComponentInRoot -->" + id);
        UIComponent component = null;

        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            UIComponent root = facesContext.getViewRoot();
            component = findComponent(root, id);
        }
        logger.info("component -->" + component);
        return component;
    }


    /**
     * Locate an UIComponent from its root component.
     * @param base
     * @param id
     * @return UIComponent
     */
    public static UIComponent findComponent(UIComponent base, String id) {
        if (id.equals(base.getId()))
            return base;

        UIComponent children = null;
        UIComponent result = null;
        Iterator<UIComponent> childrens = base.getFacetsAndChildren();
        while (childrens.hasNext() && (result == null)) {
            children = childrens.next();
            if (id.equals(children.getId())) {
                result = children;
                break;
            }
            result = findComponent(children, id);
            if (result != null) {
                break;
            }
        }
        return result;
    }


    public static void doOperationAndRefresh(String operation, UIXComponent component) {
        DCBindingContainer bc = (DCBindingContainer) AipdtUIUtil.getBindings();
        OperationBinding oper = bc.getOperationBinding(operation);
        oper.execute();
        if (!oper.getErrors().isEmpty()) {
            logger.warning("Error occured during operation:" + operation);
            for (Iterator itr = oper.getErrors().iterator(); itr.hasNext();) {
                logger.warning("Error:" + itr.next());
            }
        }
        if (component != null) {
            AdfFacesContext.getCurrentInstance().addPartialTarget(component);
        }

    }

    public static void deleteAndRefresh(String operation, UIXComponent component) {
        doOperationAndRefresh(operation, component);

    }

    public static void commitAndRefresh(String operation, UIXComponent component) {
        doOperationAndRefresh(operation, component);

    }

    /**
     * This method will return the Root Application module
     * @return AipdtRootAMImpl
     */
    public static AipdtRootAMImpl getRootApplicationModule() {
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCBindingContainer bindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCDataControl dc =
            bindingContainer.findDataControl(Constants.AIPDT_ROOT_AM_DATA_CONTROL); // Name of application module in datacontrolBinding.cpx
        if (dc == null)
            return null;
        AipdtRootAMImpl rootAM = (AipdtRootAMImpl) dc.getDataProvider();
        return rootAM;
    }

    /**
     * This method will return the Root Application module
     * @return am
     */
    public static ApplicationModule findApplicationModuleFromRootAM(String applicationModuleName) {
        AipdtRootAMImpl rootAM = getRootApplicationModule();
        if (rootAM == null)
            return null;
        ApplicationModule am = rootAM.findApplicationModule(applicationModuleName);
        return am;
    }

    /**
     * This method will create the Audit record.
     * @param auditLog
     */
    /*public static void createAuditRecord(AuditLog auditLog) {
        AipdtRootAMImpl rootAM = getRootApplicationModule();
        if (rootAM != null){
            rootAM.createAuditRecord(auditLog);
        } else {
            logger.severe("RootAM is null. So createAuditRecord can not be created.");
        }
    }*/

    /**
     *  This method returns the current row of the Iterator.
     * @param name
     * @return row
     */
    public static Row getCurrentRowFromIterator(String name) {
        DCIteratorBinding ib = findIterator(name);
        Row row = null;
        if (ib != null) {
            row = ib.getCurrentRow();
        } else {
            logger.severe("Iterator '" + name + "' not found");
        }
        return row;
    }

    /**
     * This method will return the current row of the Iterator.
     * If current row is not null then this method will return the first row as current row.
     * @param name
     * @return
     */
    public static Row getCurrentOrNewRowFromIterator(String name) {
        DCIteratorBinding ib = findIterator(name);
        Row row = null;
        if (ib != null) {
            row = ib.getCurrentRow();
            if (row == null) {
                ViewObject vo = ib.getViewObject();
                if (vo == null) {
                    logger.severe("CurrentRow is null and View Object is not found in the Iterator ['" + name + "']");
                    return row;
                } else {
                    vo.executeQuery();
                    row = vo.createRow();
                    vo.insertRow(row);
                    vo.setCurrentRow(row);
                }
            }
        } else {
            logger.severe("Iterator '" + name + "' not found");
        }
        return row;
    }

    /**
     * This method returns the current row of the VO. If current row is null, then
     * this method will return first row of the VO.
     *
     * @param amName
     * @param voName
     * @return row
     */
    public static Row getCurrentRowFromVO(String amName, String voName) {
        AipdtRootAMImpl rootAM = getRootApplicationModule();
        if (rootAM == null)
            return null;
        ApplicationModule am = rootAM.findApplicationModule(amName);
        if (am == null)
            return null;
        ViewObject vo = am.findViewObject(voName);
        if (vo == null)
            return null;
        Row row = vo.getCurrentRow();
        if (row == null)
            row = vo.first();
        return row;
    }

    /**
     * This method will return the Logged in user name.
     * @return userId
     */
    public static String getUserName() {
        String userId = "DEFAULT_USER";
        SecurityContext securityContext = ADFContext.getCurrent().getSecurityContext();
        if (securityContext != null) {
            userId = securityContext.getUserName(); //  Logged in user name
        } else {
            logger.severe("SecurityContext is null.");
        }
        return userId;
    }

    /*
    public static boolean isUserGrantedPermission(String name) {
        boolean isUserGrantedPermission = false;
        SecurityContext securityContext = ADFContext.getCurrent().getSecurityContext();
        if(securityContext != null){
            ComponentPermission componentPermission = new ComponentPermission(name, "access");
            isUserGrantedPermission = securityContext.hasPermission(componentPermission); //  Logged in user name
        } else {
            logger.severe("SecurityContext is null.");
        }
        if(logger.isInfo()){
            logger.info("isUserGrantedPermission =" + isUserGrantedPermission);
        }
        return isUserGrantedPermission;
    }*/

    /*
    public static oracle.jbo.domain.Date getVdate(){
        WorkingGroupAMImpl am =  (WorkingGroupAMImpl)AipdtUIUtils.findApplicationModuleFromRootAM(Constants.WORKING_GROUP_AM);
        oracle.jbo.domain.Date vdate = null;
        if(am != null)
            vdate = am.getVdate();

        if(logger.isInfo()){
            logger.info("vdate = " + vdate);
        }
        return vdate;
    }

    public static oracle.jbo.domain.Date getSystemHighDate(){
        WorkingGroupAMImpl am =  (WorkingGroupAMImpl)AipdtUIUtils.findApplicationModuleFromRootAM(Constants.WORKING_GROUP_AM);
        oracle.jbo.domain.Date systemHighDate = null;
        if(am != null)
            systemHighDate = am.getSystemHighDate();

        if(logger.isInfo()){
            logger.info("systemHighDate = " + systemHighDate);
        }
        return systemHighDate;
    }

    public static oracle.jbo.domain.Date getVdatePlusOne(){
        WorkingGroupAMImpl am =  (WorkingGroupAMImpl)AipdtUIUtils.findApplicationModuleFromRootAM(Constants.WORKING_GROUP_AM);
        oracle.jbo.domain.Date vdatePlusOne = null;
        if(am != null)
            vdatePlusOne = am.getVdatePlusOne();

        if(logger.isInfo()){
            logger.info("vdatePlusOne = " + vdatePlusOne);
        }
        return vdatePlusOne;
    }*/
    
    /**
     * This method will return the Translation value from UI bundle.
     * @param key
     * @return
     */
    public static String getUIBundleValue(String key) {
        return getXlifLocalizedString(Constants.AIPDT_VIEW_BUNDLE, key);
    }

    public static void showWarningMessage(String message, UIComponent component) {
        logger.warning(message);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "", message);
        context.addMessage(component != null ? component.getClientId(context) : null, fm);

    }

    public static void showErrorMessage(String message, UIComponent component) {
        logger.severe(message);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", message);
        context.addMessage(component != null ? component.getClientId(context) : null, fm);
    }
    
    public static void showWarningMessageFromUIBundle(String msgKey, UIComponent comp) {
        String msg = getUIBundleValue(msgKey);
        AipdtUIUtil.showErrorMessage(msg, comp);
    }
    
    public static void showErrorMessageFromUIBundle(String msgKey, UIComponent comp) {
        String msg = getUIBundleValue(msgKey);
        AipdtUIUtil.showErrorMessage(msg, comp);
    }

    public static Object getElExpression(String el) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression valueExp = expressionFactory.createValueExpression(elContext, el, Object.class);
        return valueExp.getValue(elContext);
    }

    public static void setElExpression(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression valueExp = expressionFactory.createValueExpression(elContext, el, Object.class);
        valueExp.setValue(elContext, val);
    }

    /**
     * Find an iterator binding in the current binding container by name.
     *
     * @param operation iterator binding name
     * @return iterator binding
     */

    public static Object invokeOperationBinding(String operation) throws FacesException {
        Object result = null;
        OperationBinding op = getBindingContainer().getOperationBinding(operation);
        if (op != null) {
            result = op.execute();
            if (!op.getErrors().isEmpty()) {
                logger.info("Error while invoking '" + operation + "'.", (Throwable) op.getErrors().get(0));
            }
        } else {
            logger.info("Check the operation : " + operation + " is correctly mapped in pageDef bindings.");
        }
        return result;
    }

    public static DCIteratorBinding getDCIteratorBinding(RichTable table) {
        CollectionModel cms = (CollectionModel) table.getValue();
        JUCtrlHierBinding jb = (JUCtrlHierBinding) cms.getWrappedData();
        DCIteratorBinding bindings = jb.getDCIteratorBinding();
        return bindings;
    }

    /**
     * This method will return that funtionality name is SC list then return true else return false.
     * @param functionalityName
     * @return
     */
    public static boolean isSCListMode(String functionalityName) {
        if (Constants.SC_LIST_CRE.equalsIgnoreCase(functionalityName) ||
            Constants.SC_LIST_MNT.equalsIgnoreCase(functionalityName)) {
            return true;
        }
        return false;
    }

    // code added for store pack size : Start
    public static boolean isStoreFormatPackSize(String functionalityName) {
        boolean isSTFrmtPksize = false;
        if (Constants.ST_ORDERINGPACKSIZE_CRE.equals(functionalityName) ||
            Constants.ST_ORDERINGPACKSIZE_MNT.equals(functionalityName)) {
            isSTFrmtPksize = true;
        }
        return isSTFrmtPksize;
    }

    public static boolean isUserInAdminRole() {
        boolean hasAdminRolePermission = false;
        SecurityContext securityContext = ADFContext.getCurrent().getSecurityContext();
        if (securityContext != null) {
            hasAdminRolePermission = securityContext.isUserInRole(Constants.DT_ADMIN_ROLE);
        } else {
            logger.severe("SecurityContext is null.");
        }
        return hasAdminRolePermission;
    }

    public static boolean isWarehouseCre(String functionalityName) {
        boolean isWarehouseCre = false;
        if (Constants.WH_ORDERABLEUNIT_CRE.equals(functionalityName) ||
            Constants.WH_PALLETMULTIPLE_CRE.equals(functionalityName) ||
            Constants.WH_ORDERMULTIPLE_CRE.equals(functionalityName)) {
            isWarehouseCre = true;
        }
        return isWarehouseCre;
    }

    public static boolean isWhLeadTimeMode(String functionalityName) {
        boolean isWhLeadTime = false;
        if (Constants.WH_LEADTIME_CRE.equals(functionalityName) ||
            Constants.WH_LEADTIME_MNT.equals(functionalityName)) {
            isWhLeadTime = true;
        }
        return isWhLeadTime;
    }

    public static boolean isWhRangingMode(String functionalityName) {
        boolean isWhRanging = false;
        if (Constants.WH_RANGING_CRE.equals(functionalityName) || Constants.WH_RANGING_MNT.equals(functionalityName)) {
            isWhRanging = true;
        }
        return isWhRanging;
    }

    public static boolean isWhOUMode(String functionalityName) {
        boolean isWhOU = false;
        if (Constants.WH_ORDERABLEUNIT_CRE.equals(functionalityName) ||
            Constants.WH_ORDERABLEUNIT_MNT.equals(functionalityName)) {
            isWhOU = true;
        }
        return isWhOU;
    }


    public static boolean isStoreFormatPackSizeCre(String functionalityName) {
        boolean isSTFrmtPksizeCre = false;
        if (Constants.ST_ORDERINGPACKSIZE_CRE.equals(functionalityName)) {
            isSTFrmtPksizeCre = true;
        }
        return isSTFrmtPksizeCre;
    }

    public static ViewObjectImpl getViewObjectByAttrFieldBinding(String attrFieldBinding) {
        BindingContainer bindings = AipdtUIUtil.getBindings();
        JUCtrlListBinding dependentList = (JUCtrlListBinding) bindings.get(attrFieldBinding);
        ViewObjectImpl attrFBVO = (ViewObjectImpl) dependentList.getListIterBinding().getViewObject();
        return attrFBVO;
    }

    /**
     * Helper method to select the rows using check box for export excel
     */
    public static void selectAllRowsInTable(RichTable richTable, String iteratorName, String attrName) {
        logger.info("****** Inside selectAllRowsInTable method ******");
        if (richTable != null) {
            DCIteratorBinding dcItteratorBindings = findIterator(iteratorName);
            if (dcItteratorBindings != null) {
                ViewObject resultVO = dcItteratorBindings.getViewObject();
                Row[] selectedRows = resultVO.getFilteredRows(attrName, Constants.UPDATE_IND_1);
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
                    richTable.setSelectedRowKeys(rks);
                } else {
                    richTable.getSelectedRowKeys().clear();
                    richTable.setSelectedRowKeys(rks);
                }
            }
        }
    }
    
    /**
     *To clear the table filter values
     * @param table Id
     */
    
    public static void clearTableFilter(RichTable richTable){
        if(richTable != null){
        FilterableQueryDescriptor queryDescriptor = (FilterableQueryDescriptor) richTable.getFilterModel();
            if (queryDescriptor != null && queryDescriptor.getFilterConjunctionCriterion() != null) {
                ConjunctionCriterion cc = queryDescriptor.getFilterConjunctionCriterion();
                List<Criterion> lc = cc.getCriterionList();
                for (Criterion c : lc) {
                    if (c instanceof AttributeCriterion) {
                        AttributeCriterion ac = (AttributeCriterion) c;
                        ac.setValue(null);
                    }
                }
                richTable.queueEvent(new QueryEvent(richTable, queryDescriptor));
            }
        }
    }
    
    /**
     * Construct export file name
     * @param key
     *      Reference from UI bundle
     * @return
     *      Export file name as String
     */
    public static String getExportFileName(String key) {
        String fileName = getUIBundleValue(key);
        Date dt = new Date();
        String currentDate = DateUtil.getJavaUtilDateAsString(dt, Constants.DATE_FORMAT_FOR_FILE_NAME);
        return fileName + "_" + currentDate + Constants.EXPORT_FILE_FORMAT;
    }
    
    
    public static void resetSelecOneChoiceComponent(String fieldName){
        BindingContainer bc = AipdtUIUtil.getBindings();
        JUCtrlListBinding list = (JUCtrlListBinding) bc.get(fieldName);
        list.clearSelectedIndices();        
    }
    
    
    public static String getDateFormatted(java.util.Date dateVal){
        String date = null;
        if(dateVal != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_UI_DISPLAY);
            date = dateFormat.format(dateVal);            
        }
        return date;
    }
    
    
}
