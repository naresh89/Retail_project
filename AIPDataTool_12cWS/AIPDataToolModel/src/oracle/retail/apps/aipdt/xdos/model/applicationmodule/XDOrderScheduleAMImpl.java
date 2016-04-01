package oracle.retail.apps.aipdt.xdos.model.applicationmodule;

import java.math.BigDecimal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.Map;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.DtListDetail;
import oracle.retail.apps.aipdt.common.adfbc.AipdtApplicationModuleImpl;
import oracle.retail.apps.aipdt.common.adfbc.AipdtViewObjectImpl;
import oracle.retail.apps.aipdt.common.model.util.AipdtModelUtil;
import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.xdos.model.applicationmodule.common.XDOrderScheduleAM;
import oracle.retail.apps.aipdt.xdos.model.view.XDOrderScheduleResultsVORowImpl;
import oracle.retail.apps.aipdt.xdos.model.view.XDOrderScheduleSearchVORowImpl;
import oracle.retail.apps.aipdt.xdos.model.view.XDOrderScheduleTimeSetAllVORowImpl;
import oracle.retail.apps.aipdt.xdos.sql.type.DtXdwhRcSearchRec;
import oracle.retail.apps.framework.jdbc.util.AppsDBUtils;
import oracle.retail.apps.framework.jdbc.util.ParamType;
import oracle.retail.apps.framework.jdbc.util.SQLParam;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Mar 11 14:27:06 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XDOrderScheduleAMImpl extends AipdtApplicationModuleImpl implements XDOrderScheduleAM {

    private final static ADFLogger logger = ADFLogger.createADFLogger(XDOrderScheduleAMImpl.class);

    private final static String PLSQL_SEARCH_XDOS = "DT_XDWH_ORDER_CYCLE.XDWH_SEARCH";

    private final static String PLSQL_SAVE_XDOS = "DT_XDWH_ORDER_CYCLE.XDWH_SAVE_RELEASE_CYCLE";

    /**
     * This is the default constructor (do not remove).
     */
    public XDOrderScheduleAMImpl() {
    }

    /**
     * Container's getter for XDOrderScheduleSearchVO1.
     * @return XDOrderScheduleSearchVO1
     */
    public AipdtViewObjectImpl getXDOrderScheduleSearchVO1() {
        return (AipdtViewObjectImpl) findViewObject("XDOrderScheduleSearchVO1");
    }

    /**
     * Container's getter for XDOrderScheduleResultsVO1.
     * @return XDOrderScheduleResultsVO1
     */
    public AipdtViewObjectImpl getXDOrderScheduleResultsVO1() {
        return (AipdtViewObjectImpl) findViewObject("XDOrderScheduleResultsVO1");
    }

    /**
     * Container's getter for XDOrderScheduleItemHierPopupVO1.
     * @return XDOrderScheduleItemHierPopupVO1
     */
    public AipdtViewObjectImpl getXDOrderScheduleItemHierPopupVO1() {
        return (AipdtViewObjectImpl) findViewObject("XDOrderScheduleItemHierPopupVO1");
    }

    public void initXDOrderSchedule() {
        logger.info("****** Inside initXDOrderSchedule method ******");
        AipdtViewObjectImpl xdosSearchVO = getXDOrderScheduleSearchVO1();
        xdosSearchVO.setWhereClause(null);
        xdosSearchVO.setWhereClause("1=2");
        xdosSearchVO.executeQuery();
        xdosSearchVO.executeEmptyRowSet();
        Row row = xdosSearchVO.createRow();
        xdosSearchVO.insertRow(row);
        xdosSearchVO.setCurrentRow(row);

        //Initialize results form
        AipdtViewObjectImpl xdosResultsVO = getXDOrderScheduleResultsVO1();
        xdosResultsVO.setWhereClause(null);
        xdosResultsVO.setWhereClause("1=2");
        xdosResultsVO.executeQuery();
        xdosResultsVO.executeEmptyRowSet();
    }

    /**
     * Stages records with the helper method and queries the results back on UI
     * @return
     */
    public boolean handleSearch(Map<String, String> inputSearchCriteria) throws Exception {
        logger.info("****** Inside handleSearch method ******");
        if((inputSearchCriteria == null) || inputSearchCriteria.isEmpty()){
            logger.warning("No input data received for search.");   
            return false;
        }
        XDOSInputDataBean xdosBean = prepareXDOSInputDateBean(inputSearchCriteria);
        //Stage records
        logger.info("Staging records...");
        stageRecords(xdosBean);

        //Querying results
        AipdtViewObjectImpl xdosResultsVO = getXDOrderScheduleResultsVO1();
        xdosResultsVO.applyViewCriteria(null);
        xdosResultsVO.setWhereClause(null);
        xdosResultsVO.executeQuery();
        logger.info("Total Result records fetched : " + xdosResultsVO.getEstimatedRowCount());
        //Search - End
        return (xdosResultsVO.getEstimatedRowCount() > 0);
    }

    /**
     * Prepare a bean with input data received from XD Order Schedule search screen
     * @return
     */
    private XDOSInputDataBean prepareXDOSInputDateBean(Map<String, String> inputSearchCriteria) {
        logger.info("****** Inside prepareXDOSInputDateBean method ******");
        //Read input data
        String selectionLevel = inputSearchCriteria.get(Constants.SELECTION_LEVEL);
        String departmentId = inputSearchCriteria.get(Constants.DEPT);
        String classId = inputSearchCriteria.get(Constants.CLASS);
        String subclassId = inputSearchCriteria.get(Constants.SUBCLASS);
        String styleId = inputSearchCriteria.get(Constants.VPN);
        String styleColorId = inputSearchCriteria.get(Constants.VPN_COLOR);
        String commodityId = inputSearchCriteria.get(Constants.ITEM);
        String supplierId = inputSearchCriteria.get(Constants.SUPPLIER);
        String stockingpointId = inputSearchCriteria.get(Constants.WAREHOUSE);
        String regionId = inputSearchCriteria.get(Constants.REGION);
        String storeId = inputSearchCriteria.get(Constants.STORE);

        logger.info("Input data received from search screen :");
        logger.info("Selection Level = " + selectionLevel);
        logger.info("Department = " + departmentId);
        logger.info("Class = " + classId);
        logger.info("Subclass = " + subclassId);
        logger.info("VPN = " + styleId);
        logger.info("Style Color = " + styleColorId);
        logger.info("Item = " + commodityId);
        logger.info("Supplier = " + supplierId);
        logger.info("Warehouse = " + stockingpointId);
        logger.info("Region = " + regionId);
        logger.info("Store = " + storeId);

        //Preparing Input Data Bean
        XDOSInputDataBean xdosBean = new XDOSInputDataBean();
        xdosBean.setSelectionLevel(selectionLevel);
        xdosBean.setDepartmentId(departmentId);
        xdosBean.setClassId(classId);
        xdosBean.setSubclassId(subclassId);
        xdosBean.setStyleId(styleId);
        xdosBean.setStyleColorId(styleColorId);
        xdosBean.setCommodityId(commodityId);
        xdosBean.setSupplierId(supplierId);
        xdosBean.setStockingpointId(stockingpointId);
        xdosBean.setRegionId(regionId);
        xdosBean.setStoreId(storeId);
        xdosBean.setCreateUser(AipdtModelUtil.getUserName());

        return xdosBean;
    }

    /**
     * Helper method to stage the records into GTT table
     */
    private void stageRecords(XDOSInputDataBean xdosBean) throws Exception {
        logger.info("****** Inside stageRecords method *******");
        try {
            DtXdwhRcSearchRec stgObj = new DtXdwhRcSearchRec();
            stgObj.setSelectionLevel(new BigDecimal(xdosBean.getSelectionLevel()));
            stgObj.setDepartmentId(new BigDecimal(xdosBean.getDepartmentId()));
            stgObj.setClassId(xdosBean.getClassId());
            stgObj.setSubclassId(xdosBean.getSubclassId());
            stgObj.setStyleId(xdosBean.getStyleId());
            stgObj.setStyleColorId(xdosBean.getStyleColorId());
            stgObj.setCommodityId(xdosBean.getCommodityId());
            stgObj.setSupplierId(!StringUtil.isNullOrEmpty(xdosBean.getSupplierId()) ? new BigDecimal(xdosBean.getSupplierId()) : null);
            stgObj.setStockingPointId(new BigDecimal(xdosBean.getStockingpointId()));
            //stgObj.setRegionId(new BigDecimal(xdosBean.getRegionId()));
            stgObj.setStoreId(xdosBean.getStoreId());
            stgObj.setCreateUser(AipdtModelUtil.getUserName());

            DBTransaction dbTransaction = getDBTransaction();

            SQLParam tblArrParam =
                new SQLParam(stgObj, ParamType.IN, Types.STRUCT, DtXdwhRcSearchRec._SQL_NAME,
                             DtXdwhRcSearchRec.getORADataFactory());
            SQLParam errorCodeParam = new SQLParam(null, ParamType.OUT, Types.VARCHAR);
            Integer plSqlCallStatus = null;
            plSqlCallStatus =
                (Integer) AppsDBUtils.callStoredFunction(dbTransaction, PLSQL_SEARCH_XDOS, Types.INTEGER, tblArrParam,
                                                         errorCodeParam);
            if (plSqlCallStatus == 0) {
                logger.info("PLSQL function : " + PLSQL_SEARCH_XDOS + " returned True.");
                //dbTransaction.commit();
            } else {
                logger.severe("PLSQL function : " + PLSQL_SEARCH_XDOS + " returned False.");
                String o_errorCode =
                    (errorCodeParam != null) ? (String) errorCodeParam.getValue() :
                    AipdtModelUtil.getXlifLocalizedString(Constants.AIPDT_MODEL_BUNDLE, Constants.DEAFULT_ERROR_MSG);
                logger.severe(o_errorCode);
                JboException jboEx = new JboException(o_errorCode);
                throw jboEx;
            }
        } catch (JboException jboEx) {
            throw jboEx;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.severe(AipdtModelUtil.getXlifLocalizedString(Constants.AIPDT_MODEL_BUNDLE,
                                                                Constants.NP_ERROR_INSERT_STAGE_DATA));
            throw ex;
        }
    }

    /**
     * This method filters Store ViewObject based on given RegionId.
     * @param regId
     */
    public void filterStoreVO(String regId) {
        logger.info("****** Inside filterStoreVO method *******");
        try {
            ViewObject vo = getXDOrderScheduleSearchVO1();
            if (vo != null) {
                XDOrderScheduleSearchVORowImpl roImpl = (XDOrderScheduleSearchVORowImpl) vo.getCurrentRow();
                if (roImpl != null) {
                    ViewObject storeVO = roImpl.getStoreRegionVOA().getViewObject();
                    if (storeVO != null && regId != null) {
                        ViewCriteria storeVC =
                            storeVO.getViewCriteriaManager().getViewCriteria("StoreRegionVOCriteria");
                        VariableValueManager vm = storeVO.ensureVariableManager();
                        vm.setVariableValue("regId", Integer.valueOf(regId));
                        storeVC.setVariableManager(vm);
                        storeVO.applyViewCriteria(storeVC);
                        storeVO.executeQuery();
                        logger.info("Store VO rowCount after filter based on RegionId value :" +
                                           storeVO.getEstimatedRowCount());
                    } else {
                        logger.warning("Store Region LOV is empty.");
                        storeVO.applyViewCriteria(null);
                        storeVO.executeQuery();
                    }
                } else {
                    logger.warning("Search VO Row Impl is empty.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method filters SupplierLOV ViewObject based on given DepartmentId.
     * @param regId
     */
    public void filterSupplierLOVVO(String deptId) {
        logger.info("****** Inside filterSupplierLOVVO method *******");
        try {
            ViewObject vo = getXDOrderScheduleSearchVO1();
            if (vo != null) {
                XDOrderScheduleSearchVORowImpl roImpl = (XDOrderScheduleSearchVORowImpl) vo.getCurrentRow();
                if (roImpl != null) {
                    ViewObject suppVO = roImpl.getDeptOrdFromSuppVOA().getViewObject();
                    if (suppVO != null) {
                        if (!StringUtil.isNullOrEmpty(deptId)) {
                            String whereClause = "DEPARTMENT_ID IN(" + Integer.valueOf(deptId) + ")";
                            suppVO.setWhereClause(whereClause);
                            suppVO.executeQuery();
                            logger.info("Supplier VO rowCount after filter based on Department Id value :" +
                                               suppVO.getEstimatedRowCount());
                        } else {
                            logger.warning("Dept Id for DeptOrdFromSuppVO LOV is null.");
                            suppVO.setWhereClause(null);
                            suppVO.executeQuery();
                        }
                    } else {
                        logger.warning("DeptOrdFromSuppVO LOV is empty.");
                    }
                } else {
                    logger.warning("Search VO Row Impl is empty.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the list details from the list table
     * @param itemList
     * @param type
     * @return
     */
    public String getIdsFromDtListDetailTable(Integer itemList, String type) {
        logger.info("****** Inside getIdsFromDtListDetailTable method *******");
        String itemVal = null;
        if (type != null && type.equals("ITEM_LIST")) {
            itemVal = AipdtModelUtil.fetchIdsFromDtListDetailTable(itemList, DtListDetail.COMMODITY_ID.toString());
        } else if (type != null && type.equals("STORE_LIST")) {
            itemVal = AipdtModelUtil.fetchIdsFromDtListDetailTable(itemList, DtListDetail.STORE_ID.toString());
        }
        return itemVal;
    }


    /**
     * Gets supplier ids for given supplier code and deparment id
     * @param supplierCode
     * @param deptId
     * @return
     */
    public String getSupplierIdFromCode(String supplierCode, String deptId) {
        logger.info("****** Inside getSupplierIdFromCode method *******");
        ResultSet rs;
        String suppId = null;
        try {
            String query =
                "select supplier_id from V_DT_DEPT_ORD_FROM_SUPP where supplier_code = '" + supplierCode +
                "' and rownum=1";
            if (deptId != null) {
                query = query + " AND department_id = " + Integer.valueOf(deptId);
            }
            rs = this.getDBTransaction().createStatement(0).executeQuery(query);
            if (rs.next()) {
                suppId = String.valueOf(rs.getObject(1));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new JboException(e);
        }
        return suppId;
    }

    /**
     * Invoked on click of reset button from search panel
     */
    public void handleReset() {
        logger.info("****** Inside handleReset method *******");
        try {
            getDBTransaction().rollback();
            initXDOrderSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the staged xdos records in the GTT table and invokes
     * the PLSQL function to merge the records into DT tables.
     */
    public void saveXDOS() throws Exception {
        logger.info("****** Inside saveXDOS method ******");
        try {
            getDBTransaction().postChanges();
            SQLParam errorCodeParam = new SQLParam(null, ParamType.OUT, Types.VARCHAR);
            Integer plSqlCallStatus = null;
            plSqlCallStatus =
                (Integer) AppsDBUtils.callStoredFunction(getDBTransaction(), PLSQL_SAVE_XDOS, Types.INTEGER,
                                                         errorCodeParam);
            if (plSqlCallStatus == 0) {
                logger.info("PLSQL function : " + PLSQL_SAVE_XDOS + " returned True.");
                getDBTransaction().commit();
            } else {
                logger.severe("PLSQL function : " + PLSQL_SAVE_XDOS + " returned False.");
                String o_errorCode =
                    (errorCodeParam != null) ? (String) errorCodeParam.getValue() :
                    AipdtModelUtil.getXlifLocalizedString(Constants.AIPDT_MODEL_BUNDLE, Constants.DEAFULT_ERROR_MSG);
                logger.severe(o_errorCode);
                JboException jboEx = new JboException(o_errorCode);
                throw jboEx;

            }
        } catch (JboException jboEx) {
            throw jboEx;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.severe(AipdtModelUtil.getXlifLocalizedString(Constants.AIPDT_MODEL_BUNDLE,
                                                                Constants.NP_ERROR_UPDATE_STAGE_DATA));
            throw ex;
        }
    }

    /**
     * Selects / Deselects all the records based on the 'All' check box selection on the table column header
     * in XDOS Results section.
     * @param isSelected
     * @return
     */
    public long handleCheckBoxAll(boolean isSelected) {
        logger.info("****** Inside handleCheckBoxAll method ******");
        AipdtViewObjectImpl xdosResultsVO = getXDOrderScheduleResultsVO1();
        RowSetIterator resultsRowset = xdosResultsVO.createRowSetIterator(null);
        resultsRowset.reset();
        while (resultsRowset.hasNext()) {
            Row resultsRow = resultsRowset.next();
            resultsRow.setAttribute(Constants.UPDATE_IND_ATTR,
                                    isSelected ? Constants.UPDATE_IND_1 : Constants.UPDATE_IND_0);
        }
        resultsRowset.closeRowSetIterator();
        return xdosResultsVO.getEstimatedRowCount();
    }

    /**
     * Set Maximum Holding Time and Processing Time of DOW's to all selected records in result section
     */
    public void handleDOWSetAll() {
        logger.info("****** Inside handleDOWSetAll method ******");
        AipdtViewObjectImpl setAllVO = getXDOrderScheduleTimeSetAllVO1();
        //Row[] setAllDOWRows = setAllVO.getAllRowsInRange();
        XDOrderScheduleTimeSetAllVORowImpl leadTimeRow = (XDOrderScheduleTimeSetAllVORowImpl) setAllVO.first();

        AipdtViewObjectImpl resultsVO = getXDOrderScheduleResultsVO1();
        Row[] resultsRows = resultsVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
        if (leadTimeRow != null) {
            for (int rowIndex = 0; rowIndex < resultsRows.length; rowIndex++) {
                XDOrderScheduleResultsVORowImpl resultRow = (XDOrderScheduleResultsVORowImpl) resultsRows[rowIndex];
                if (leadTimeRow.getSunday() != null) {
                    resultRow.setSunLeadTime(leadTimeRow.getSunday());
                }else{
                    resultRow.setSunLeadTime(-1);
                }
                if (leadTimeRow.getMonday() != null) {
                    resultRow.setMonLeadTime(leadTimeRow.getMonday());
                }else{
                    resultRow.setMonLeadTime(-1);
                }
                if (leadTimeRow.getTuesday() != null) {
                    resultRow.setTueLeadTime(leadTimeRow.getTuesday());
                }
                else{
                    resultRow.setTueLeadTime(-1);
                }
                if (leadTimeRow.getWednesday() != null) {
                    resultRow.setWedLeadTime(leadTimeRow.getWednesday());
                }else{
                    resultRow.setWedLeadTime(-1);
                }
                if (leadTimeRow.getThursday() != null) {
                    resultRow.setThuLeadTime(leadTimeRow.getThursday());
                }else{
                    resultRow.setThuLeadTime(-1);
                }
                if (leadTimeRow.getFriday() != null) {
                    resultRow.setFriLeadTime(leadTimeRow.getFriday());
                }else{
                    resultRow.setFriLeadTime(-1);
                }
                if (leadTimeRow.getSaturday() != null) {
                    resultRow.setSatLeadTime(leadTimeRow.getSaturday());
                }else{
                    resultRow.setSatLeadTime(-1);
                }
            }
        }
    }

    /**
     * Set all - updates all the selected records with set all value on results table
     * @param setAllMap
     */
    public void handleSetAll(Map<String, Object> setAllMap) {
        logger.info("****** Inside handleSetAll method ******");
        if ((setAllMap == null) || setAllMap.isEmpty()) {
            logger.warning("No set all value received.");
            return;
        }
        AipdtViewObjectImpl xdosResultsVO = getXDOrderScheduleResultsVO1();
        Row[] resultsRows = xdosResultsVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
        if ((resultsRows == null) || (resultsRows.length == 0)) {
            logger.warning("No records selected to update.");
            return;
        }

        Map.Entry<String, Object> entry = setAllMap.entrySet().iterator().next();
        String setAllKey = entry.getKey();
        Object setAllValue = entry.getValue();

        java.sql.Date sqlSetAllDate = null;
        if (setAllValue instanceof java.util.Date) {
            java.util.Date setAllDate = (java.util.Date) setAllValue;
            if (setAllDate != null) {
                sqlSetAllDate = new java.sql.Date(setAllDate.getTime());
            }
        }

        for (int rowIndex = 0; rowIndex < resultsRows.length; rowIndex++) {
            XDOrderScheduleResultsVORowImpl resultsRow = (XDOrderScheduleResultsVORowImpl) resultsRows[rowIndex];
            if (Constants.XDOS_SET_ALL_START_DATE_COMP_ID.equals(setAllKey)) {
                resultsRow.setStartDate(sqlSetAllDate);
            } else if (Constants.XDOS_SET_ALL_END_DATE_COMP_ID.equals(setAllKey)) {
                resultsRow.setEndDate(sqlSetAllDate);
            }
        }
    }


    /**
     * Create an empty DOW row for lead times
     */
    public void createEmptyDOWSetAll() {
        logger.info("****** Inside createEmptyDOWSetAll method ******");
        AipdtViewObjectImpl vo = getXDOrderScheduleTimeSetAllVO1();
        vo.executeEmptyRowSet();
        XDOrderScheduleTimeSetAllVORowImpl row = (XDOrderScheduleTimeSetAllVORowImpl) vo.createRow();
        vo.insertRow(row);
        String orderByClause = "DowSeq";
        vo.setOrderByClause(orderByClause);
    }

    /**
     * Create an empty DOW row for lead times
     */
    public void createEmptyDOWRow() {
        logger.info("****** Inside createEmptyDOWRow method ******");
        AipdtViewObjectImpl vo = getXDOrderScheduleTimeSetAllVO1();
        vo.executeEmptyRowSet();
        XDOrderScheduleTimeSetAllVORowImpl row = (XDOrderScheduleTimeSetAllVORowImpl) vo.createRow();
        vo.insertRow(row);
        vo.setCurrentRow(row);
        AipdtViewObjectImpl xdosResultsVO = getXDOrderScheduleResultsVO1();
        XDOrderScheduleResultsVORowImpl resultsRow = (XDOrderScheduleResultsVORowImpl)xdosResultsVO.getCurrentRow();
        if(resultsRow != null){
            row.setSunday(resultsRow.getSunLeadTime());
            row.setMonday(resultsRow.getMonLeadTime());
            row.setTuesday(resultsRow.getTueLeadTime());
            row.setWednesday(resultsRow.getWedLeadTime());
            row.setThursday(resultsRow.getThuLeadTime());
            row.setFriday(resultsRow.getFriLeadTime());
            row.setSaturday(resultsRow.getSatLeadTime());
        }
        String orderByClause = "DowSeq";
        vo.setOrderByClause(orderByClause);
    }

    /**
     * Invoked when Set button is clicked from DOW Popup. Updates the results view object with the lead times. 
     */
    public void handleDOWSet() {
        logger.info("****** Inside handleDOWSet method ******");
        AipdtViewObjectImpl setAllVO = getXDOrderScheduleTimeSetAllVO1();
        //Row[] setAllDOWRows = setAllVO.getAllRowsInRange();
        XDOrderScheduleTimeSetAllVORowImpl leadTimeRow = (XDOrderScheduleTimeSetAllVORowImpl) setAllVO.getCurrentRow();
        if (leadTimeRow == null) {
            logger.warning("No dow record found to set lead times.");
            return;
        }
        AipdtViewObjectImpl resultsVO = getXDOrderScheduleResultsVO1();
        XDOrderScheduleResultsVORowImpl resultRow = (XDOrderScheduleResultsVORowImpl) resultsVO.getCurrentRow();
        if (resultRow != null) {
            if (leadTimeRow.getSunday() != null) {
                resultRow.setSunLeadTime(leadTimeRow.getSunday());
            }else{
                resultRow.setSunLeadTime(-1);
            }
            if (leadTimeRow.getMonday() != null) {
                resultRow.setMonLeadTime(leadTimeRow.getMonday());
            }else{
                resultRow.setMonLeadTime(-1);
            }
            if (leadTimeRow.getTuesday() != null) {
                resultRow.setTueLeadTime(leadTimeRow.getTuesday());
            }else{
                resultRow.setTueLeadTime(-1);
            }
            if (leadTimeRow.getWednesday() != null) {
                resultRow.setWedLeadTime(leadTimeRow.getWednesday());
            }else{
                resultRow.setWedLeadTime(-1);
            }
            if (leadTimeRow.getThursday() != null) {
                resultRow.setThuLeadTime(leadTimeRow.getThursday());
            }else{
                resultRow.setThuLeadTime(-1);
            }
            if (leadTimeRow.getFriday() != null) {
                resultRow.setFriLeadTime(leadTimeRow.getFriday());
            }else{
                resultRow.setFriLeadTime(-1);
            }
            if (leadTimeRow.getSaturday() != null) {
                resultRow.setSatLeadTime(leadTimeRow.getSaturday());
            }else{
                resultRow.setSatLeadTime(-1);
            }
        }
    }
    
    /**
     * Container's getter for XDOrderScheduleTimeSetAllVO1.
     * @return XDOrderScheduleTimeSetAllVO1
     */
    public AipdtViewObjectImpl getXDOrderScheduleTimeSetAllVO1() {
        return (AipdtViewObjectImpl) findViewObject("XDOrderScheduleTimeSetAllVO1");
    }

    /**
     * Bean class to hold the input data received from XD Order Schedule Search screen
     */
    private class XDOSInputDataBean {
        private String departmentId;
        private String supplierId;
        private String stockingpointId;
        private String classId;
        private String subclassId;
        private String styleId;
        private String styleColorId;
        private String commodityId;
        private String storeId;
        private String regionId;
        private String selectionLevel;
        private String createUser;

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setSupplierId(String supplierId) {
            this.supplierId = supplierId;
        }

        public String getSupplierId() {
            return supplierId;
        }

        public void setStockingpointId(String stockingpointId) {
            this.stockingpointId = stockingpointId;
        }

        public String getStockingpointId() {
            return stockingpointId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public String getClassId() {
            return classId;
        }

        public void setSubclassId(String subclassId) {
            this.subclassId = subclassId;
        }

        public String getSubclassId() {
            return subclassId;
        }

        public void setStyleId(String styleId) {
            this.styleId = styleId;
        }

        public String getStyleId() {
            return styleId;
        }

        public void setStyleColorId(String styleColorId) {
            this.styleColorId = styleColorId;
        }

        public String getStyleColorId() {
            return styleColorId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityId() {
            return commodityId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getRegionId() {
            return regionId;
        }

        public void setSelectionLevel(String selectionLevel) {
            this.selectionLevel = selectionLevel;
        }

        public String getSelectionLevel() {
            return selectionLevel;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getCreateUser() {
            return createUser;
        }
    }

}

