package oracle.retail.apps.aipdt.cds.model.applicationmodule;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.Map;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;

import oracle.retail.apps.aipdt.cds.model.applicationmodule.common.CrossDockSetupAM;
import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupResultVOImpl;
import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupResultVORowImpl;
import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupSearchVOImpl;
import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupSearchVORowImpl;
import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupTimeSetAllVOImpl;
import oracle.retail.apps.aipdt.cds.model.view.CrossDockSetupTimeSetAllVORowImpl;
import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.DtListDetail;
import oracle.retail.apps.aipdt.common.adfbc.AipdtApplicationModuleImpl;
import oracle.retail.apps.aipdt.common.adfbc.AipdtViewObjectImpl;
import oracle.retail.apps.aipdt.common.jdbc.type.DtCdSetupSearchRec;
import oracle.retail.apps.aipdt.common.jdbc.type.DtCdSetupSearchTbl;
import oracle.retail.apps.aipdt.common.model.util.AipdtModelUtil;
import oracle.retail.apps.aipdt.common.model.util.DaoUtil;
import oracle.retail.apps.aipdt.common.model.util.DateUtil;
import oracle.retail.apps.aipdt.common.model.util.PlsqlCallReturn;
import oracle.retail.apps.aipdt.common.model.util.StringUtil;
import oracle.retail.apps.aipdt.dt.model.appModule.DeploymentTypeAMImpl;
import oracle.retail.apps.framework.jdbc.util.AppsDBUtils;
import oracle.retail.apps.framework.jdbc.util.ParamType;
import oracle.retail.apps.framework.jdbc.util.SQLParam;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Feb 08 14:35:40 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrossDockSetupAMImpl extends AipdtApplicationModuleImpl implements CrossDockSetupAM {

    ADFLogger logger = ADFLogger.createADFLogger(DeploymentTypeAMImpl.class);
    private final static String CDS_PLSQL_SEARCH_FUNCTION = "DT_CROSS_DOCK_SETUP_SQL.SEARCH_CROSS_DOCK_SETUP";
    private final static String CDS_PLSQL_SAVE_FUNCTION = "DT_CROSS_DOCK_SETUP_SQL.SAVE_CROSS_DOCK_SETUP";

    /**
     * This is the default constructor (do not remove).
     */
    public CrossDockSetupAMImpl() {
    }

    /**
     * Container's getter for CrossDockSetupSearchVO.
     * @return CrossDockSetupSearchVO
     */
    public CrossDockSetupSearchVOImpl getCrossDockSetupSearchVO() {
        return (CrossDockSetupSearchVOImpl) findViewObject("CrossDockSetupSearchVO");
    }


    private CrossDockSetupSearchVORowImpl getVORowImpl() {
        ViewObject vo = getCrossDockSetupSearchVO();
        if (vo != null) {
            return (CrossDockSetupSearchVORowImpl) vo.getCurrentRow();
        }
        return null;
    }

    /**
     * Container's getter for CrossDockSetupResultVO.
     * @return CrossDockSetupResultVO
     */
    public CrossDockSetupResultVOImpl getCrossDockSetupResultVO() {
        return (CrossDockSetupResultVOImpl) findViewObject("CrossDockSetupResultVO");
    }


    /**
     * Container's getter for CrossDockSetupStorePopupVO
     * @return CrossDockSetupStorePopupVO
     */
    public AipdtViewObjectImpl getCrossDockSetupStorePopupVO() {
        return (AipdtViewObjectImpl) findViewObject("CrossDockSetupStorePopupVO");
    }

    /**
     * Container's getter for CrossDockSetupTimeSetAllVO.
     * @return CrossDockSetupTimeSetAllVO
     */
    public CrossDockSetupTimeSetAllVOImpl getCrossDockSetupTimeSetAllVO() {
        return (CrossDockSetupTimeSetAllVOImpl) findViewObject("CrossDockSetupTimeSetAllVO");
    }

    /**
     * Container's getter for CrossDockSetupItemHierPopupVO.
     * @return CrossDockSetupItemHierPopupVO
     */
    public AipdtViewObjectImpl getCrossDockSetupItemHierPopupVO() {
        return (AipdtViewObjectImpl) findViewObject("CrossDockSetupItemHierPopupVO");
    }

    /**
     * Container's getter for CrossDockSetupReportVO1.
     * @return CrossDockSetupReportVO1
     */
    public AipdtViewObjectImpl getCrossDockSetupReportVO() {
        return (AipdtViewObjectImpl) findViewObject("CrossDockSetupReportVO");
    }
    
    /**
     * Container's getter for CrossDockSetupTimeSetAll1.
     * @return CrossDockSetupTimeSetAll1
     */
    public CrossDockSetupTimeSetAllVOImpl getCrossDockSetupDOWVO() {
        return (CrossDockSetupTimeSetAllVOImpl) findViewObject("CrossDockSetupDOWVO");
    }

    /**
     * Invoked for initially anb reset action
     */
    public void init() {
        initializeResultVO();
        initializeSearchVO();
    }

    private void initializeSearchVO() {
        CrossDockSetupSearchVOImpl searchVO = getCrossDockSetupSearchVO();
        if (searchVO != null) {
            if (searchVO.getCurrentRow() != null) {
                searchVO.removeCurrentRow();
            }
            searchVO.executeEmptyRowSet();
            Row row = searchVO.createRow();
            searchVO.insertRow(row);
            searchVO.setCurrentRow(row);
        }
    }

    private void initializeResultVO() {
        CrossDockSetupResultVOImpl resultVO = getCrossDockSetupResultVO();
        if (resultVO != null) {
            resultVO.setWhereClause(null);
            resultVO.setWhereClause("1=2");
            resultVO.executeQuery();
        }
    }


    /**
     * Filter Order From Supplier by selected Department
     * @param deptId
     *      Selected Deaprtment Id
     */
    public void filterSuppliersByDepartment(String deptId) {
        CrossDockSetupSearchVORowImpl rowImpl = getVORowImpl();
        if (rowImpl != null) {
            ViewObject deptOrdFromSuppVO = rowImpl.getDeptOrdFromSuppVOA().getViewObject();
            DaoUtil.filterSuppliersByDepartment(deptOrdFromSuppVO, deptId);
        }
    }

    /**
     * Filter Stores by selected Region
     * @param selectedRegion
     *      Selected Region
     */
    public void filterStoresByRegion(String selectedRegion) {
        CrossDockSetupSearchVORowImpl rowImpl = getVORowImpl();
        if (rowImpl != null) {
            ViewObject storeVO = rowImpl.getStoreRegionVOA().getViewObject();
            DaoUtil.filterStoresByRegion(storeVO, selectedRegion);
        }
    }

    /**
     * Load Stores from selected StoreList
     * @param storeListId
     *      Selected Store List Id
     * @return
     *      Store Id's with delimited string
     */
    public String loadStoresFromStoreList(String storeListId) {
        return AipdtModelUtil.fetchIdsFromDtListDetailTable(Integer.parseInt(storeListId),
                                                            DtListDetail.STORE_ID.toString());
    }

    /**
     * Search based on search criteria by calling a PLSQL function
     * @param inputMap
     *      Search criteria filed values
     * @return
     *      PlsqlCallReturn - Object holds PLSQL exeuction status and error message
     */
    public PlsqlCallReturn handleSearch(Map inputMap) {
        logger.info("Entering handleSearch method");
        PlsqlCallReturn callReturn = new PlsqlCallReturn();
        try {
            DtCdSetupSearchRec[] recObjArray = new DtCdSetupSearchRec[1];
            DtCdSetupSearchRec recObj = new DtCdSetupSearchRec();
            recObj.setDepartmentId(new BigDecimal(inputMap.get(Constants.DEPT).toString()));
            recObj.setSupplierId(inputMap.get(Constants.SUPPLIER).toString());
            recObj.setSuppSelType(null);
            if (inputMap.get(Constants.REGION) != null) {
                recObj.setRegionId(new BigDecimal(inputMap.get(Constants.REGION).toString()));
            } else {
                recObj.setRegionId(null);
            }
            if (inputMap.get(Constants.STORE) != null) {
                recObj.setStoreId(inputMap.get(Constants.STORE).toString());
            } else {
                recObj.setStoreId(null);
            }

            if (inputMap.get(Constants.STORE_SELECTION_TYPE) != null) {
                recObj.setStoreSelType(inputMap.get(Constants.STORE_SELECTION_TYPE).toString());
            } else {
                recObj.setStoreSelType(null);
            }
            recObj.setIsException(Constants.YES);
            recObj.setCreateUser(AipdtModelUtil.getUserName());

            recObjArray[0] = recObj;

            DtCdSetupSearchTbl tableObj = new DtCdSetupSearchTbl();
            tableObj.setArray(recObjArray);

            DBTransaction dbTransacion = this.getDBTransaction();
            SQLParam outErrorParam = new SQLParam(null, ParamType.OUT, Types.VARCHAR);
            SQLParam tblArrParam =
                new SQLParam(tableObj, ParamType.IN, Types.ARRAY, DtCdSetupSearchTbl._SQL_NAME,
                             DtCdSetupSearchTbl.getORADataFactory());

            Integer executionStatus =
                (Integer) AppsDBUtils.callStoredFunction(dbTransacion, CDS_PLSQL_SEARCH_FUNCTION, Types.INTEGER,
                                                         tblArrParam, outErrorParam);
            callReturn.setExecutionStatus(executionStatus);
            if (!StringUtil.isNullOrEmpty(outErrorParam.getValue())) {
                callReturn.setErrorMessage(outErrorParam.getValue().toString());
            } else if (StringUtil.isNullOrEmpty(outErrorParam.getValue()) && executionStatus == 0) {
                ViewObject voImpl = getCrossDockSetupResultVO();
                voImpl.setWhereClause(null);
                voImpl.executeQuery();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            callReturn.setErrorMessage("Exception on Search: "+ ex.getMessage());
        }
        return callReturn;
    }

    /**
     * Reset VO's to discard previous objects and create fresh object for reload
     */
    public void handleReset() {
        ViewObject vo = getCrossDockSetupSearchVO();
        CrossDockSetupSearchVORowImpl rowImpl = (CrossDockSetupSearchVORowImpl) vo.getCurrentRow();
        if (rowImpl != null) {
            executeQueryWithNullVC(rowImpl.getDeptOrdFromSuppVOA().getViewObject());
            executeQueryWithNullVC(rowImpl.getStoreRegionVOA().getViewObject());
            executeQueryWithNullVC(rowImpl.getDepartmentVOA().getViewObject());
        }
        initializeResultVO();
        CrossDockSetupResultVOImpl resultVOImpl = getCrossDockSetupResultVO();
        if (this.getTransaction().isDirty()) {
            this.getDBTransaction().rollback();
            resultVOImpl.clearEntityObjectCache();
        }
        initializeSearchVO();
    }

    private void executeQueryWithNullVC(ViewObject vo) {
        if (vo != null) {
            vo.applyViewCriteria(null);
            vo.executeQuery();
        }
    }

    /**
     * Update result section checkbox as Selected/Not Seected for selected records
     * @param isSelected
     *      true or false
     * @return
     *      long - Updated row count
     */
    public long handleAllCheckBox(boolean isSelected) {
        CrossDockSetupResultVOImpl resultVO = getCrossDockSetupResultVO();
        RowSetIterator resultsRowset = resultVO.createRowSetIterator(null);
        resultsRowset.reset();
        while (resultsRowset.hasNext()) {
            CrossDockSetupResultVORowImpl resultsRow = (CrossDockSetupResultVORowImpl) resultsRowset.next();
            resultsRow.setUpdateInd(isSelected ? Constants.UPDATE_IND_1 : Constants.UPDATE_IND_0);
        }
        if (resultsRowset != null) {
            resultsRowset.closeRowSetIterator();
        }
        return resultVO.getEstimatedRowCount();
    }

    /**
     * Save all the selected records from result section by calling a PLSQL function.
     * @return
     *      PlsqlCallReturn - Object holds PLSQL exeuction status and error message
     */
    public PlsqlCallReturn handleSave() {
        PlsqlCallReturn callReturn = new PlsqlCallReturn();
        try {
            DBTransaction dbTransacion = this.getDBTransaction();
            dbTransacion.postChanges();
            CrossDockSetupResultVORowImpl rowImpl =
                (CrossDockSetupResultVORowImpl) this.getCrossDockSetupResultVO().first();
            if (rowImpl != null) {
                BigDecimal transactionId = rowImpl.getTransactionId();
                SQLParam transactionIdParam = new SQLParam(transactionId, ParamType.IN, Types.NUMERIC);
                SQLParam outErrorParam = new SQLParam(null, ParamType.OUT, Types.VARCHAR);

                SQLParam timeStamp = new SQLParam(null, ParamType.OUT, Types.NUMERIC);

                Integer executionStatus =
                    (Integer) AppsDBUtils.callStoredFunction(dbTransacion, CDS_PLSQL_SAVE_FUNCTION, Types.INTEGER,
                                                             transactionIdParam, timeStamp, outErrorParam);
                callReturn.setExecutionStatus(executionStatus);
                if (!StringUtil.isNullOrEmpty(outErrorParam.getValue())) {
                    callReturn.setErrorMessage("PlSql business logic execution error on Save, " +
                                               outErrorParam.getValue().toString());
                } else if (executionStatus == 0 && StringUtil.isNullOrEmpty(outErrorParam.getValue())) {
                    dbTransacion.commit();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            callReturn.setErrorMessage("Exception On Save: " + ex.getMessage());
        }
        return callReturn;
    }

    /**
     * Set Start and End date value to all selected records in result section
     * @param setAllMap
     *      Start and End date values to set
     */
    public void handleDateSetAll(Map setAllMap) {
        logger.info("****** Inside handleDateSetAll method ******");
        java.sql.Date startDate = null;
        java.sql.Date endDate = null;

        if (setAllMap.get(Constants.START_DATE) != null) {
            startDate = DateUtil.convertJavaDateToSqlDate(setAllMap.get(Constants.START_DATE));
        }
        if (setAllMap.get(Constants.END_DATE) != null) {
            endDate = DateUtil.convertJavaDateToSqlDate(setAllMap.get(Constants.END_DATE));
        }

        CrossDockSetupResultVOImpl resultVO = getCrossDockSetupResultVO();
        RowSetIterator resultsRowset = resultVO.createRowSetIterator(null);
        CrossDockSetupResultVORowImpl resultsRow;
        Row[] rows = resultsRowset.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
        for (int index = 0; index < rows.length; index++) {
            resultsRow = (CrossDockSetupResultVORowImpl) rows[index];
            if (startDate != null)
                resultsRow.setStartDate(startDate);
            if (endDate != null)
                resultsRow.setEndDate(endDate);
        }
        resultsRowset.closeRowSetIterator();
        logger.info("handleDateSetAll function executed successfully.");
    }

    /**
     * Set Maximum Holding Time and Processing Time of DOW's to all selected records in result section
     */
    public void handleDOWSetAll() {
        logger.info("****** Inside handleDOWSetAll method ******");
        CrossDockSetupTimeSetAllVOImpl setAllVO = getCrossDockSetupTimeSetAllVO();
        Row[] setAllDOWRows = setAllVO.getAllRowsInRange();
        CrossDockSetupTimeSetAllVORowImpl maxHoldingTimeRow = null;
        CrossDockSetupTimeSetAllVORowImpl processingTimeRow = null;
        for (int index = 0; index < setAllDOWRows.length; index++) {
            int seq = ((CrossDockSetupTimeSetAllVORowImpl) setAllDOWRows[index]).getDowseq();
            if (seq == 1)
                maxHoldingTimeRow = (CrossDockSetupTimeSetAllVORowImpl) setAllDOWRows[index];

            if (seq == 2)
                processingTimeRow = (CrossDockSetupTimeSetAllVORowImpl) setAllDOWRows[index];
        }

        CrossDockSetupResultVOImpl resultsVO = getCrossDockSetupResultVO();
        Row[] resultsRows = resultsVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
        if (maxHoldingTimeRow != null || processingTimeRow != null) {
            for (int rowIndex = 0; rowIndex < resultsRows.length; rowIndex++) {
                CrossDockSetupResultVORowImpl resultRow = (CrossDockSetupResultVORowImpl) resultsRows[rowIndex];
                if (maxHoldingTimeRow != null) {
                    if (maxHoldingTimeRow.getSunday() != null) {
                        resultRow.setMaxHoldingTime0(maxHoldingTimeRow.getSunday());
                    }
                    if (maxHoldingTimeRow.getMonday() != null) {
                        resultRow.setMaxHoldingTime1(maxHoldingTimeRow.getMonday());
                    }
                    if (maxHoldingTimeRow.getTuesday() != null) {
                        resultRow.setMaxHoldingTime2(maxHoldingTimeRow.getTuesday());
                    }
                    if (maxHoldingTimeRow.getWednesday() != null) {
                        resultRow.setMaxHoldingTime3(maxHoldingTimeRow.getWednesday());
                    }
                    if (maxHoldingTimeRow.getThursday() != null) {
                        resultRow.setMaxHoldingTime4(maxHoldingTimeRow.getThursday());
                    }
                    if (maxHoldingTimeRow.getFriday() != null) {
                        resultRow.setMaxHoldingTime5(maxHoldingTimeRow.getFriday());
                    }
                    if (maxHoldingTimeRow.getSaturday() != null) {
                        resultRow.setMaxHoldingTime6(maxHoldingTimeRow.getSaturday());
                    }
                }
                if (processingTimeRow != null) {
                    if (processingTimeRow.getSunday() != null) {
                        resultRow.setProcessingTime0(processingTimeRow.getSunday());
                    }
                    if (processingTimeRow.getMonday() != null) {
                        resultRow.setProcessingTime1(processingTimeRow.getMonday());
                    }
                    if (processingTimeRow.getTuesday() != null) {
                        resultRow.setProcessingTime2(processingTimeRow.getTuesday());
                    }
                    if (processingTimeRow.getWednesday() != null) {
                        resultRow.setProcessingTime3(processingTimeRow.getWednesday());
                    }
                    if (processingTimeRow.getThursday() != null) {
                        resultRow.setProcessingTime4(processingTimeRow.getThursday());
                    }
                    if (processingTimeRow.getFriday() != null) {
                        resultRow.setProcessingTime5(processingTimeRow.getFriday());
                    }
                    if (processingTimeRow.getSaturday() != null) {
                        resultRow.setProcessingTime6(processingTimeRow.getSaturday());
                    }
                }
            }
        }
        logger.info("handleDOWSetAll function executed successfully.");
    }

    public void handleRowDOWSet(BigDecimal id) {
        logger.info("****** Inside handleRowDOWSet method ******");
        CrossDockSetupTimeSetAllVOImpl setAllVO = getCrossDockSetupDOWVO();
        Row[] dowRows = setAllVO.getAllRowsInRange();
        CrossDockSetupTimeSetAllVORowImpl maxHoldingTimeRow = null;
        CrossDockSetupTimeSetAllVORowImpl processingTimeRow = null;
        for (int index = 0; index < dowRows.length; index++) {
            int seq = ((CrossDockSetupTimeSetAllVORowImpl) dowRows[index]).getDowseq().intValue();
            if (seq == 1)
                maxHoldingTimeRow = (CrossDockSetupTimeSetAllVORowImpl) dowRows[index];

            if (seq == 2)
                processingTimeRow = (CrossDockSetupTimeSetAllVORowImpl) dowRows[index];
        }

        CrossDockSetupResultVOImpl resultsVO = getCrossDockSetupResultVO();
        Row[] currentResultRow = resultsVO.getFilteredRows(Constants.ID_ATTR, id);
        if ((maxHoldingTimeRow != null || processingTimeRow != null) && currentResultRow.length == 1) {
            int rowIndex = 0;
            CrossDockSetupResultVORowImpl resultRow = (CrossDockSetupResultVORowImpl) currentResultRow[rowIndex];
            if (maxHoldingTimeRow != null) {
                if (maxHoldingTimeRow.getSunday() != null) {
                    resultRow.setMaxHoldingTime0(maxHoldingTimeRow.getSunday());
                }
                if (maxHoldingTimeRow.getMonday() != null) {
                    resultRow.setMaxHoldingTime1(maxHoldingTimeRow.getMonday());
                }
                if (maxHoldingTimeRow.getTuesday() != null) {
                    resultRow.setMaxHoldingTime2(maxHoldingTimeRow.getTuesday());
                }
                if (maxHoldingTimeRow.getWednesday() != null) {
                    resultRow.setMaxHoldingTime3(maxHoldingTimeRow.getWednesday());
                }
                if (maxHoldingTimeRow.getThursday() != null) {
                    resultRow.setMaxHoldingTime4(maxHoldingTimeRow.getThursday());
                }
                if (maxHoldingTimeRow.getFriday() != null) {
                    resultRow.setMaxHoldingTime5(maxHoldingTimeRow.getFriday());
                }
                if (maxHoldingTimeRow.getSaturday() != null) {
                    resultRow.setMaxHoldingTime6(maxHoldingTimeRow.getSaturday());
                }
            }
            if (processingTimeRow != null) {
                if (processingTimeRow.getSunday() != null) {
                    resultRow.setProcessingTime0(processingTimeRow.getSunday());
                }
                if (processingTimeRow.getMonday() != null) {
                    resultRow.setProcessingTime1(processingTimeRow.getMonday());
                }
                if (processingTimeRow.getTuesday() != null) {
                    resultRow.setProcessingTime2(processingTimeRow.getTuesday());
                }
                if (processingTimeRow.getWednesday() != null) {
                    resultRow.setProcessingTime3(processingTimeRow.getWednesday());
                }
                if (processingTimeRow.getThursday() != null) {
                    resultRow.setProcessingTime4(processingTimeRow.getThursday());
                }
                if (processingTimeRow.getFriday() != null) {
                    resultRow.setProcessingTime5(processingTimeRow.getFriday());
                }
                if (processingTimeRow.getSaturday() != null) {
                    resultRow.setProcessingTime6(processingTimeRow.getSaturday());
                }
            }
        }
        logger.info("handleRowDOWSet function executed successfully.");
    }

    /**
     * Identifies a row is selected from result section or not
     * @return
     *      true - If row selected
     *      false - If no row selected
     */
    public Boolean isRowSelectedInResultTable() {
        CrossDockSetupResultVOImpl resultsVO = getCrossDockSetupResultVO();
        Row[] resultsRows = resultsVO.getFilteredRows(Constants.UPDATE_IND_ATTR, Constants.UPDATE_IND_1);
        if ((resultsRows == null) || (resultsRows.length == 0)) {
            logger.warning("No records selected to update.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Create two empty DOW rows for Maximum Holding and Processing time
     */
    public void createEmptyDOWSetAll() {
        CrossDockSetupTimeSetAllVOImpl voImpl = getCrossDockSetupTimeSetAllVO();
        voImpl.executeEmptyRowSet();
        crateDOWSetAllRow(voImpl, Constants.MAX_HOLDING_TIME, 1);
        crateDOWSetAllRow(voImpl, Constants.PROCESSING_TIME, 2);
    }

    public void createEmptyDOWRows(CrossDockSetupResultVORowImpl currentResultRow) {
        CrossDockSetupTimeSetAllVOImpl voImpl = getCrossDockSetupDOWVO();
        voImpl.executeEmptyRowSet();

        CrossDockSetupTimeSetAllVORowImpl maxHoldingTimeRow = (CrossDockSetupTimeSetAllVORowImpl) voImpl.createRow();
        maxHoldingTimeRow.setTimetype(AipdtModelUtil.getModelBundleValue(Constants.MAX_HOLDING_TIME));
        maxHoldingTimeRow.setDowseq(1);
        maxHoldingTimeRow.setId(currentResultRow.getId());
        maxHoldingTimeRow.setSunday(currentResultRow.getMaxHoldingTime0());
        maxHoldingTimeRow.setMonday(currentResultRow.getMaxHoldingTime1());
        maxHoldingTimeRow.setTuesday(currentResultRow.getMaxHoldingTime2());
        maxHoldingTimeRow.setWednesday(currentResultRow.getMaxHoldingTime3());
        maxHoldingTimeRow.setThursday(currentResultRow.getMaxHoldingTime4());
        maxHoldingTimeRow.setFriday(currentResultRow.getMaxHoldingTime5());
        maxHoldingTimeRow.setSaturday(currentResultRow.getMaxHoldingTime6());        
        voImpl.insertRow(maxHoldingTimeRow);
        
        CrossDockSetupTimeSetAllVORowImpl processingTimeRow = (CrossDockSetupTimeSetAllVORowImpl) voImpl.createRow();
        processingTimeRow.setTimetype(AipdtModelUtil.getModelBundleValue(Constants.PROCESSING_TIME));
        processingTimeRow.setDowseq(2);
        processingTimeRow.setId(currentResultRow.getId());
        processingTimeRow.setSunday(currentResultRow.getProcessingTime0());
        processingTimeRow.setMonday(currentResultRow.getProcessingTime1());
        processingTimeRow.setTuesday(currentResultRow.getProcessingTime2());
        processingTimeRow.setWednesday(currentResultRow.getProcessingTime3());
        processingTimeRow.setThursday(currentResultRow.getProcessingTime4());
        processingTimeRow.setFriday(currentResultRow.getProcessingTime5());
        processingTimeRow.setSaturday(currentResultRow.getProcessingTime6());        
        voImpl.insertRow(processingTimeRow);
    }

    private void crateDOWSetAllRow(CrossDockSetupTimeSetAllVOImpl voImpl, String timeType, int dowSeq) {
        CrossDockSetupTimeSetAllVORowImpl row = (CrossDockSetupTimeSetAllVORowImpl) voImpl.createRow();
        row.setTimetype(AipdtModelUtil.getModelBundleValue(timeType));
        row.setDowseq(dowSeq);
        voImpl.insertRow(row);
    }
}

