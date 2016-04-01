package oracle.retail.apps.aipdt.fieldbinding.publicui.bean;

import com.oracle.retail.apps.comp.ms.view.MultiselectInputListOfValues;
import com.oracle.retail.apps.comp.ms.view.SelectManyInputCheckBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import oracle.adf.model.BindingContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.fragment.RichDeclarativeComponent;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import oracle.retail.apps.aipdt.common.model.util.StringUtil;

public class MultiSelectBaseFieldsBean {
    private SelectManyInputCheckBox storeComp;
    private SelectManyInputCheckBox stockingPointComp;

    private SelectManyInputCheckBox departmentComp;
    private SelectManyInputCheckBox classComp;
    private SelectManyInputCheckBox subClassComp;
    private SelectManyInputCheckBox itemListComp;
    private SelectManyInputCheckBox wareHouseComp;

   
    private MultiselectInputListOfValues itemComp;
    private MultiselectInputListOfValues styleColourComp;
    private MultiselectInputListOfValues vpnComp;

    private MultiselectInputListOfValues supplierComp;

    private static final String CLASS_WHERECLAUSE_PARAM = "CLASS_ID";
    private static final String SUBCLASS_WHERECLAUSE_PARAM = "SUBCLASS_ID";
    private static final String VPN_WHERECLAUSE_PARAM = "STYLE_ID";
    private static final String VPNCOLOR_WHERECLAUSE_PARAM = "STYLE_COLOR_ID";

    private static ADFLogger _logger = ADFLogger.createADFLogger(MultiSelectBaseFieldsBean.class);

    public MultiSelectBaseFieldsBean() {
        super();
    }

    public void setWareHouseComp(SelectManyInputCheckBox wareHouseComp) {
        this.wareHouseComp = wareHouseComp;
    }

    public SelectManyInputCheckBox getWareHouseComp() {
        return wareHouseComp;
    }


    public void setStoreComp(SelectManyInputCheckBox storeComp) {
        this.storeComp = storeComp;
    }

    public SelectManyInputCheckBox getStoreComp() {
        return storeComp;
    }

    public void setStockingPointComp(SelectManyInputCheckBox stockingPointComp) {
        this.stockingPointComp = stockingPointComp;
    }

    public SelectManyInputCheckBox getStockingPointComp() {
        return stockingPointComp;
    }

    public void setDepartmentComp(SelectManyInputCheckBox departmentComp) {
        this.departmentComp = departmentComp;
    }

    public SelectManyInputCheckBox getDepartmentComp() {
        return departmentComp;
    }

    public void setClassComp(SelectManyInputCheckBox classComp) {
        this.classComp = classComp;
    }

    public SelectManyInputCheckBox getClassComp() {
        return classComp;
    }

    public void setSubClassComp(SelectManyInputCheckBox subClassComp) {
        this.subClassComp = subClassComp;
    }

    public SelectManyInputCheckBox getSubClassComp() {
        return subClassComp;
    }

    public void setItemListComp(SelectManyInputCheckBox itemListComp) {
        this.itemListComp = itemListComp;
    }

    public SelectManyInputCheckBox getItemListComp() {
        return itemListComp;
    }

    public void setItemComp(MultiselectInputListOfValues itemComp) {
        this.itemComp = itemComp;
    }

    public MultiselectInputListOfValues getItemComp() {
        return itemComp;
    }

    public void setStyleColourComp(MultiselectInputListOfValues styleColourComp) {
        this.styleColourComp = styleColourComp;
    }

    public MultiselectInputListOfValues getStyleColourComp() {
        return styleColourComp;
    }

    public void setVpnComp(MultiselectInputListOfValues vpnComp) {
        this.vpnComp = vpnComp;
    }

    public MultiselectInputListOfValues getVpnComp() {
        return vpnComp;
    }

    public void setSupplierComp(MultiselectInputListOfValues supplierComp) {
        this.supplierComp = supplierComp;
    }

    public MultiselectInputListOfValues getSupplierComp() {
        return supplierComp;
    }


    /**
     * Method will clear all the conent of LOV.
     */
    public void clearAll() {
        if (getItemComp() != null) {
            getItemComp().resetValue();
        }
        getItemComp().getValueInputText().setValue(null);
        getItemComp().setPopUpDeptId(null);
    }

    /**
     * This method resets MultiShuttleInput component value.
     * @param component
     */

    public void resetMultiShuttleComponent(MultiselectInputListOfValues component) {
        _logger.info("Entering  resetMultiShuttleComponent()");
        try {
            _logger.info("component --> " + component);
            if (component != null) {
                component.resetValue();
                component.getValueInputText().setValue(null);
                component.setPopUpDeptId(null);
            }
        } catch (Exception e) {
            _logger.info("component parameter is --> " + component);
            e.printStackTrace();

        }
    }


    /**
     * This method resets multiSelectInput component value.
     * @param component
     */

    public void resetMultiSelectComponent(SelectManyInputCheckBox component) {
        _logger.info("Entering  resetMultiShuttleComponent()");
        try {
            _logger.info("component --> " + component);
            if (component != null) {
                component.resetDeclarativeComponent();
                component.getValueInputText().setValue(null);
            }
        } catch (Exception e) {
            _logger.info("component parameter is --> " + component);
            e.printStackTrace();

        }
    }


    /**
     * This method filters dependant multiShuttle component and removed invalid valid value and returns only valid value if already values are selected.
     * @param value  : DepartmentId value selected on the screen.
     * @param itemAttr   Attribute name  for which LOV is been attached. Using this we are accessing LOV binding ViewObject.
     * @param deptWhereClauseParam : Department whereClause param Name from LOV viewObject.
     * @param itemWhereClauseParam : Suttle component Code attribute name for which filter can be applied.
     * @param component : Component binding.
     * @return
     */


    public String fetchValidCodeValue(String value, String itemAttr, String deptWhereClauseParam,
                                      String itemWhereClauseParam, MultiselectInputListOfValues component) {

        String returnValue = null;
        RowSetIterator rs = null;
        ViewObjectImpl dependentLovVO = null;
        String deptCriteriaName = "DEPT_CRITERIA";
        try {
            _logger.info("Entering  executeMultiShuttle()");
            _logger.info("InputParameter passed : " + value);
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            Object itemVal = component.getSelectedValues();

            _logger.info("Value of Item component : " + itemVal);
            if (null != value && !value.toString().isEmpty() && itemVal != null && !itemVal.toString().isEmpty()) {
                _logger.info("value in bean=============================================================================>" +
                             value);
                ArrayList<String> al1 = new ArrayList<String>();
                ArrayList<String> al2 = new ArrayList<String>();
                ArrayList<String> al = new ArrayList<String>();
                value = value.replace(";", ",");
                _logger.info("value after replacing colon with comma===================================================>" +
                             value);

                String itemCompValue = itemVal.toString();


                String[] itemArray = null;
                if (itemCompValue != null) {
                    itemArray = itemCompValue.split(";");
                    for (String codPaisCliente : itemArray) {
                        if (null != codPaisCliente) {
                            _logger.info("Code value================>" + codPaisCliente);
                            al1.add(codPaisCliente);
                        }
                    }
                }
                JUCtrlListBinding dependentList = (JUCtrlListBinding) bindings.get(itemAttr);
                dependentLovVO = (ViewObjectImpl) dependentList.getListIterBinding().getViewObject();
                dependentLovVO.applyViewCriteria(null);
                dependentLovVO.setWhereClause(null);
                String itemParam = itemVal.toString().replace(";", ",");
                String inClause = "IN (" + value + ")";
                String itemInClause = "IN (" + itemParam + ")";
                _logger.info("IN CLAUSE==============================================================================>" +
                             inClause);
                ViewCriteria vc = dependentLovVO.createViewCriteria();
                vc.setName(deptCriteriaName);
                ViewCriteriaRow criteriaRow = vc.createViewCriteriaRow();
                criteriaRow.setAttribute(deptWhereClauseParam, inClause);
                //criteriaRow.setAttribute(itemWhereClauseParam, itemInClause);

                vc.addElement(criteriaRow);
                dependentLovVO.applyViewCriteria(vc, true);
                String whereClause = null;
                Object classWhereClause = component.getAttributes().get("ClassWhereClause");
                Object subClassWhereClause =
                    ((RichDeclarativeComponent) component).getAttributes().get("SubclassWhereClause");
                Object vpnWhereClause = ((RichDeclarativeComponent) component).getAttributes().get("VPNWhereClause");
                Object vpnColorWhereClause =
                    ((RichDeclarativeComponent) component).getAttributes().get("StyleColorWhereClause");

                if (classWhereClause != null && !classWhereClause.toString().isEmpty()) {
                    whereClause = classWhereClause.toString();
                }

                if (subClassWhereClause != null && !subClassWhereClause.toString().isEmpty()) {
                    whereClause =
                        whereClause != null ? whereClause + " AND " + subClassWhereClause.toString() :
                        subClassWhereClause.toString();
                }

                if (vpnWhereClause != null && !vpnWhereClause.toString().isEmpty()) {
                    whereClause =
                        whereClause != null ? whereClause + " AND " + vpnWhereClause.toString() :
                        vpnWhereClause.toString();
                }
                if (vpnColorWhereClause != null && !vpnColorWhereClause.toString().isEmpty()) {
                    whereClause =
                        whereClause != null ? whereClause + " AND " + vpnColorWhereClause.toString() :
                        vpnColorWhereClause.toString();
                }
                _logger.info("In Clause Query : " + dependentLovVO.getQuery());

                if (whereClause != null) {
                    dependentLovVO.setWhereClause(whereClause);
                }
                _logger.info("Query -->" + dependentLovVO.getQuery());
                dependentLovVO.executeQuery();

                rs = dependentLovVO.createRowSetIterator(null);
                rs.reset();
                while (rs.hasNext()) {
                    Row row = rs.next();
                    al2.add((String) row.getAttribute(itemWhereClauseParam));
                }
                _logger.info("al1 list value======================> : " + al1);
                _logger.info("al2 list value======================> : " + al2);
                _logger.info("itemArray value : " + itemArray);
                clearAll();
                String newValue = "";
                for (int i = 0; i < al2.size(); i++) {
                    if (al1.contains(al2.get(i))) {
                        al.add(al2.get(i));
                    }
                }
                if (al.size() > 0) {
                    RowSetIterator itemIter = dependentLovVO.createRowSetIterator(null);
                    for (int i = 0; i < al.size(); i++) {
                        String values = (String) al.get(i);
                        if (newValue != null && !newValue.isEmpty()) {
                            newValue = newValue + ";" + values;
                        } else {
                            newValue = values;
                        }
                    }
                    List selectedList = this.getVpnComp().getListSelected();
                    Object listSize = (selectedList == null ? "empty" : selectedList.size());
                    _logger.info("Value of Item component Selected list after setting value : " + listSize);
                    if (itemIter != null) {
                        itemIter.closeRowSetIterator();
                    }
                    //component.getInputBinding().setValue(newValue);
                    //component.setItemCompValue(newValue);
                    //itemVal = newValue;
                    returnValue = newValue;
                } else {
                    //itemVal = null;
                    clearAll();
                }
                value = value.replace(",", ";");
                //component.getValueInputText().setValue(value);
            } else {
                itemVal = null;
                clearAll();
                value = (value != null && !value.isEmpty()) ? value.replace(",", ";") : null;
                component.getValueInputText().setValue(value);
                component.setPopUpDeptId(value);
            }
            _logger.info("Exiting executeMultiShuttle()");
        } catch (Exception e) {
            _logger.info("Exception occured in executeMultiShuttle()");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.closeRowSetIterator();
            }
            if (dependentLovVO != null) {
                dependentLovVO.setWhereClause(null);
                dependentLovVO.getViewCriteriaManager().removeViewCriteria(deptCriteriaName);
            }
        }
        return returnValue;
    }

    /**
     * This method filters dependant MultiSelectInput component based on the Parent component value selection.
     * @param dependentAttrName :  FieldBinding name for which LOV is been attached.
     * @param parentWhereClauseParam  : Parent field whereClause param Name which is there in FieldBinding LOV VO.
     * @param parentWhereClauseValue :   Parent field's selected value.
     * @param masterWhereClauseParam : Master field's whereClause parama name from FieldBinding LOV VO.
     * @param masterWhereClauseParamValue  Master field's selected value.
     */

    public void filterDependantMultiSelectComponent(String dependentAttrName, String parentWhereClauseParam,
                                                    String parentWhereClauseValue, String masterWhereClauseParam,
                                                    String masterWhereClauseParamValue) {
        try {
            BindingContext bctx = BindingContext.getCurrent();

            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            JUCtrlListBinding dependentList = (JUCtrlListBinding) bindings.get(dependentAttrName);
            ViewObjectImpl dependentLovVO = (ViewObjectImpl) dependentList.getListIterBinding().getViewObject();
            String newId =
                (parentWhereClauseValue != null && !parentWhereClauseValue.isEmpty()) ? parentWhereClauseValue : null;
            String value = null;

            dependentLovVO.applyViewCriteria(null);
            dependentLovVO.setWhereClause(null);
            if (newId != null) {
                value = newId.replace(";", ",");
            }
            Boolean flag = false;
            ViewCriteria vc = dependentLovVO.createViewCriteria();
            ViewCriteriaRow criteriaRow = vc.createViewCriteriaRow();
            if (value != null) {
                String inClause = "IN (" + value + ")";
                criteriaRow.setAttribute(parentWhereClauseParam, inClause);
                flag = true;
            }
            if (masterWhereClauseParamValue != null && masterWhereClauseParam != null) {
                String deptValue = masterWhereClauseParamValue.replace(";", ",");
                String parentInClause = "IN (" + deptValue + ")";
                criteriaRow.setAttribute(masterWhereClauseParam, parentInClause);
                flag = true;
            }
            if (flag) {
                vc.addElement(criteriaRow);
                dependentLovVO.applyViewCriteria(vc, true);
            }
            dependentLovVO.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will filter Dependent ViewObject based on the parameter passed.
     * @param dependentAttrName
     * @param lovCodeAtt
     * @param whereClauseParamName
     * @param newValue
     * @param oldInputTextValue
     * @param masterAttr
     * @param parentValue
     * @return
     */

    public String filterDependantLOV(String dependentAttrName, String lovCodeAtt, String parentWhereClauseParamName,
                                     String parentAttrValue, Object oldInputTextValue, String masterWhereClauseAttr,
                                     String masterAttrValue) {
        BindingContext bctx = BindingContext.getCurrent();
        String childCompValue = null;
        ArrayList<String> childOldList = new ArrayList<String>();
        ArrayList<String> newValueList = new ArrayList<String>();
        Set<String> childFilteredSet = new HashSet<String>();

        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        JUCtrlListBinding dependentList = (JUCtrlListBinding) bindings.get(dependentAttrName);
        ViewObjectImpl dependentLovVO = (ViewObjectImpl) dependentList.getListIterBinding().getViewObject();
        String newId = (parentAttrValue != null && !parentAttrValue.isEmpty()) ? parentAttrValue : null;
        String value = null;

        dependentLovVO.applyViewCriteria(null);
        dependentLovVO.setWhereClause(null);
        if (newId != null) {
            value = newId.replace(";", ",");
        }
        Boolean flag = false;
        ViewCriteria vc = dependentLovVO.createViewCriteria();
        ViewCriteriaRow criteriaRow = vc.createViewCriteriaRow();
        if (value != null) {
            String inClause = "IN (" + value + ")";
            criteriaRow.setAttribute(parentWhereClauseParamName, inClause);
            flag = true;
        }
        if (masterAttrValue != null && masterWhereClauseAttr != null) {
            String deptValue = masterAttrValue.replace(";", ",");
            String parentInClause = "IN (" + deptValue + ")";
            criteriaRow.setAttribute(masterWhereClauseAttr, parentInClause);
            flag = true;
        }
        if (flag) {
            vc.addElement(criteriaRow);
            dependentLovVO.applyViewCriteria(vc, true);
        }
        dependentLovVO.executeQuery();
        if (oldInputTextValue != null && !String.valueOf(oldInputTextValue).isEmpty()) {
            Object childList = oldInputTextValue;
            //multiSelectBaseFieldsBean.getCountryComp().getValueInputText().getValue();
            if (childList != null && !childList.toString().isEmpty()) {
                List<String> codPais = convertToList(childList);
                childOldList = (ArrayList<String>) codPais;
            }

            if (childOldList.size() > 0) {
                //If child LOV doesn't have any value then we are avoiding below logic as we no need to set value.
                _logger.info(dependentLovVO.getQuery());
                RowSetIterator rs = dependentLovVO.createRowSetIterator(null);
                rs.reset();
                while (rs.hasNext()) {
                    Row row = rs.next();
                    Object attrValue = row.getAttribute(lovCodeAtt);
                    newValueList.add(String.valueOf((attrValue)));
                    //Assuming that childFieldAttribute Name and Child LOV code attribute are same.
                }
                _logger.info("childOldList======================>" + childOldList);
                _logger.info("newValueList======================>" + newValueList);

                for (int i = 0; i < childOldList.size(); i++) {
                    if (newValueList.contains(childOldList.get(i))) {
                        childFilteredSet.add(childOldList.get(i));
                    }
                }
                _logger.info("childFilteredList======================>" + childFilteredSet);
                StringBuffer strValue = new StringBuffer();
                if (childFilteredSet.size() > 0) {
                    Object[] childArray = childFilteredSet.toArray();
                    for (int i = 0; i < childFilteredSet.size(); i++) {
                        strValue.append(childArray[i]);
                        if (i < childFilteredSet.size() - 1) {
                            strValue.append(";");
                        }
                    }
                }
                childCompValue = (strValue != null && !strValue.toString().isEmpty() ? strValue.toString() : null);
            }
        } else {
            //            dependentLovVO.applyViewCriteria(null);
            //            dependentLovVO.setWhereClause(null);
            //            dependentLovVO.executeQuery();
        }
        return childCompValue;
    }

    /**
     * This method will convert String values separated by delimeter to List.
     * @param childCompValue
     * @return
     */
    protected List<oracle.jbo.domain.Number> convertToList1(Object childCompValue) {
        List<oracle.jbo.domain.Number> lista = new ArrayList<oracle.jbo.domain.Number>();
        if (childCompValue != null && !childCompValue.toString().isEmpty()) {
            String[] strBuff = childCompValue.toString().split(";");
            for (int i = 0; i < strBuff.length; i++) {
                lista.add(new oracle.jbo.domain.Number(Integer.parseInt(strBuff[i])));
            }
        } else {
            lista.add(null);
        }
        return lista;
    }

    protected List<String> convertToList(Object childCompValue) {
        List<String> lista = new ArrayList<String>();
        if (childCompValue != null && !childCompValue.toString().isEmpty()) {
            String[] strBuff = childCompValue.toString().split(";");
            for (int i = 0; i < strBuff.length; i++) {
                lista.add(String.valueOf(strBuff[i]));
            }
        } else {
            lista.add(null);
        }
        return lista;
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
            allDepartsmentList.getListIterBinding().getName();
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
     * This method sets value of DepartmentId on to DepartmentId multiSelect component.
     */
    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")

    public void setDepartmentIdOnShuttleComponent(String deptId, MultiselectInputListOfValues compBind) {
        try {
            String deptIdVal = !StringUtil.isNullOrEmpty(deptId) ? deptId : null;
            /*if (multiSelectBaseFieldsBean.getVpnComp() != null) {
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
            } */

            if (compBind != null) {
                compBind.getValueInputText().setValue(deptIdVal);
                compBind.setDEPARTMENT_ID(deptIdVal);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method prepares whereClause with selected Class and subClass values which will be used to apply filter on ItemShuttleComponent popUp table.
     */
    public void setWhereClauseOnShuttleComponent(String classVal, String subClass, String vpnVal, String styleColor,
                                                 MultiselectInputListOfValues component) {
        try {
            RichDeclarativeComponent rcd = component;
            if (!StringUtil.isNullOrEmpty(classVal)) {
                classVal = classVal.replace(";", ",");
                rcd.getAttributes().put("ClassWhereClause", CLASS_WHERECLAUSE_PARAM + " IN (" + classVal + ")");
            } else {
                rcd.getAttributes().put("ClassWhereClause", null);
            }
            if (!StringUtil.isNullOrEmpty(subClass)) {
                subClass = subClass.replace(";", ",");
                rcd.getAttributes().put("SubclassWhereClause", SUBCLASS_WHERECLAUSE_PARAM + " IN (" + subClass + ")");
            } else {
                rcd.getAttributes().put("SubclassWhereClause", null);
            }
            // Below block assigning vpn where clause param.
            if (!StringUtil.isNullOrEmpty(vpnVal)) {
                vpnVal = vpnVal.replace(";", ",");
                rcd.getAttributes().put("VPNWhereClause", VPN_WHERECLAUSE_PARAM + " IN (" + vpnVal + ")");
            } else {
                rcd.getAttributes().put("VPNWhereClause", null);
            }
            // Below block assigning VPNColor where clause param.
            if (!StringUtil.isNullOrEmpty(styleColor)) {
                styleColor = styleColor.replace(";", ",");
                rcd.getAttributes().put("StyleColorWhereClause",
                                        VPNCOLOR_WHERECLAUSE_PARAM + " IN (" + styleColor + ")");
            } else {
                rcd.getAttributes().put("StyleColorWhereClause", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This method returns ItemId value which is equivalent to ItemCode value.
     * @param codeValue : Code value from component.
     * @param fieldBindName : fildName for which LOV is been attached.
     * @param ListAttrName : LOV ListAttribute name.
     * @param codeAttrName : Code attribute from LOV
     * @param componentName : Identifier to identify on which component operation will be applied.
     * @return
     */

    public String getShuttleComponentIdValue(String codeValue, String fieldBindName, String ListAttrName,
                                             String codeAttrName, String componentName) {
        Object itemVal = null;
        ViewObjectImpl lovVO = null;
        String deptViewCriteriaName = "DepartmentFilter";
        if (componentName != null) {
            if (componentName.equals("VPN")) {
                itemVal = this.getVpnComp().getSelectedValues();
            } else if (componentName.equals("VPN_COLOR")) {
                itemVal = this.getStyleColourComp().getSelectedValues();
            } else if (componentName.equals("ITEM")) {
                itemVal = this.getItemComp().getSelectedValues();
            } else if (componentName.equals("SUPPLIER")) {
                itemVal = this.getItemComp().getSelectedValues();
            }
        }
        String itemId = null;
        codeValue =
            (codeValue != null && !codeValue.isEmpty()) ? codeValue : (itemVal != null ? itemVal.toString() : null);
        RowSetIterator rowSetIter = null;
        _logger.info(" Entering in to getItemId()");
        try {
            if (itemVal != null && !itemVal.toString().isEmpty()) {
                String attrId = ListAttrName;
                String attrCode = codeAttrName;
                String AttrBind = fieldBindName;

                _logger.info(" AttrBind name : " + AttrBind);
                _logger.info(" AttributeCode name : " + attrCode);
                _logger.info(" AttributeId name : " + attrId);

                lovVO = getLOVViewObjectFromBinding(AttrBind);
                lovVO.setWhereClause(null);
                lovVO.applyViewCriteria(null);
                /*lovVO.executeQuery();
                rowSetIter = lovVO.createRowSetIterator(null); */
                String[] itemCode = itemVal.toString().split(";");

                //                String whereClause = codeAttrName +;

                ViewCriteria vc = lovVO.createViewCriteria();
                vc.setName(deptViewCriteriaName);
                ViewCriteriaRow criteriaRow = vc.createViewCriteriaRow();
                if (codeAttrName != null) {
                    String parentInClause = " IN ('" + codeValue.replace(";", "','") + "')";
                    criteriaRow.setAttribute(codeAttrName, parentInClause);
                    vc.addElement(criteriaRow);
                    lovVO.applyViewCriteria(vc, true);
                }
                //RowMatch rowMatch = new RowMatch(codeAttrName + " IN ('" + codeValue.replace(";", "','") + "')");
                //lovVO.setRowMatch(rowMatch);
                //lovVO.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
                //lovVO.setWhereClause(whereClause);
                lovVO.executeQuery();

                rowSetIter = lovVO.createRowSetIterator(null);
                while (rowSetIter.hasNext()) {
                    Row row = rowSetIter.next();
                    //Row[] rows = rowSetIter.getFilteredRows(attrCode, itemCode[index]);
                    if (row != null) {
                        String IdVal = String.valueOf(row.getAttribute(attrId));
                        itemId = itemId != null ? itemId + ";" + IdVal : IdVal;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rowSetIter != null) {
                rowSetIter.closeRowSetIterator();
            }
            if (lovVO != null) {
                lovVO.removeViewCriteria(deptViewCriteriaName);
            }
        }
        _logger.info(" End of getItemId () : ItemId value -->" + itemId);
        return itemId;

    }

    /**
     * This method checks whether all the values from dropdown has been selected or not by comparing against component inputText value.
     * @return
     */
    public Boolean isAllStoreSelected() {
        Boolean flag = false;
        try {
            Integer allValueSize = storeComp.getAllValueListSize();
            Object selectedValue = storeComp.getValueInputText().getValue();
            if (selectedValue != null) {
                String value[] = selectedValue.toString().split(";");
                if (allValueSize == value.length) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
