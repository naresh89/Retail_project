package oracle.retail.apps.aipdt.common.model.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.share.security.SecurityContext;

import oracle.javatools.resourcebundle.BundleFactory;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.adfbc.AipdtViewObjectImpl;
import oracle.retail.apps.aipdt.common.model.view.DtSystemParametersVORowImpl;
import oracle.retail.apps.aipdt.root.model.applicationmodule.AipdtRootAMImpl;

import org.apache.commons.lang.StringUtils;


public abstract class AipdtModelUtil {
    
    private static ADFLogger logger = ADFLogger.createADFLogger(AipdtModelUtil.class);
    
    public AipdtModelUtil() {
        super();
    }
    
    public static String getLoggedInUserName(){
        String userName = getUserName().toUpperCase();
        //below is devEnv setup user. Prod Env isDevEnv should be false;
        if(Constants.isDevEnv && Constants.USER_MAP.containsKey(userName)){
            userName = Constants.USER_MAP.get(userName);
            logger.info("isDevEnv -->"+Constants.isDevEnv+" : mappedUserName -->"+userName);
        }        
        return userName;
    }
    
    public static String getUserName() {
        String userId = "DEFAULT_USER";
        SecurityContext securityContext = ADFContext.getCurrent().getSecurityContext();
        if(securityContext != null){
            userId = securityContext.getUserName(); //  Logged in user name
        } else {
            logger.severe("SecurityContext is null.");
        } 
        return userId;
    }
    
    public static boolean isUserInAdminRole() {
        boolean hasAdminRolePermission = false ;        
        SecurityContext securityContext = ADFContext.getCurrent().getSecurityContext();
        if(securityContext != null){
            hasAdminRolePermission = securityContext.isUserInRole(Constants.DT_ADMIN_ROLE); 
        } else {
            logger.severe("SecurityContext is null.");
        } 
        return hasAdminRolePermission;
    }
    
    /**
     * This method will return the Root Application module 
     * @return AipdtRootAMImpl
     */
    public static AipdtRootAMImpl getRootApplicationModule() {
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCBindingContainer bindingContainer = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCDataControl dc =
            bindingContainer.findDataControl(Constants.AIPDT_ROOT_AM_DATA_CONTROL); // Name of application module in datacontrolBinding.cpx
        if (dc == null)
            return null;
        AipdtRootAMImpl rootAM = (AipdtRootAMImpl)dc.getDataProvider();
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
        if(row == null)
            row = vo.first();
        return row;
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
    
    public static String getExecutionTimeDetail(long different ) {
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;       

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;
        different = different % secondsInMilli;
        
        return elapsedHours+" hours, "+ elapsedMinutes +" minutes, " 
                    + elapsedSeconds + " seconds, "+ different+ " millseconds";

    }
    
    public static oracle.jbo.domain.Date getOracleJboDomainDate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        oracle.jbo.domain.Date jobDate = new oracle.jbo.domain.Date(sqlDate);

        if (logger.isInfo()) {
            logger.info("Oracle jbo domain date : " + jobDate + ", Java util date : " + date);
        }

        return jobDate;
    }
    
    /**
     * Given a list, returns a list of lists, each inner list having a maximum of chunkSize elements.
     * @param chunkSize the maximum size of each chunk. Must be a positive number.
     */
    public static <T> List<List<T>> breakListIntoChunks(Collection<T> originalList, int chunkSize) {
        if (chunkSize <= 0) {
            throw new IllegalArgumentException("chunkSize must be greater than zero");
        }
        if (originalList == null || originalList.isEmpty()) {
            return new ArrayList<List<T>>();
        }

        List<List<T>> listOfLists = new ArrayList<List<T>>();
        int currentChunkSize = 0;
        List<T> currentChunk = new ArrayList<T>(chunkSize);
        for (T element : originalList) {
            if (currentChunkSize >= chunkSize) {
                listOfLists.add(currentChunk);
                currentChunk = new ArrayList<T>(chunkSize);
                currentChunkSize = 0;
            }
            currentChunk.add(element);
            currentChunkSize++;
        }
        if (!currentChunk.isEmpty()) {
            listOfLists.add(currentChunk);
        }
        return listOfLists;
    }

    /**
     * Given a set, returns a List of sets, each inner set having a maximum of chunkSize elements.
     * @param chunkSize the maximum size of each chunk. Must be a positive number.
     */
    public static <T> List<Set<T>> breakSetIntoChunks(Collection<T> originalSet, int chunkSize) {
        if (chunkSize <= 0) {
            throw new IllegalArgumentException("chunkSize must be greater than zero");
        }
        if (originalSet == null || originalSet.isEmpty()) {
            return new ArrayList<Set<T>>();
        }

        List<Set<T>> listOfSets = new ArrayList<Set<T>>();
        int currentChunkSize = 0;
        Set<T> currentChunk = new LinkedHashSet<T>(chunkSize);
        for (T element : originalSet) {
            if (currentChunkSize >= chunkSize) {
                listOfSets.add(currentChunk);
                currentChunk = new LinkedHashSet<T>(chunkSize);
                currentChunkSize = 0;
            }
            currentChunk.add(element);
            currentChunkSize++;
        }
        if (!currentChunk.isEmpty()) {
            listOfSets.add(currentChunk);
        }
        return listOfSets;
    }    
    
    /**
     * This method will return that funtionality name is SC list then return true else return false.
     * @param functionalityName
     * @return
     */
    public static boolean isSCListMode(String functionalityName){
        if(Constants.SC_LIST_CRE.equalsIgnoreCase(functionalityName) || Constants.SC_LIST_MNT.equalsIgnoreCase(functionalityName)){
            return true;            
        }
        return false;
    }
    
    /**
     * This method will return that funtionality name is SC list create then return true else return false.
     * @param functionalityName
     * @return
     */
    public static boolean isSCListCreMode(String functionalityName){
        if(Constants.SC_LIST_CRE.equalsIgnoreCase(functionalityName) ){
            return true;            
        }
        return false;
    }
    
    public static boolean isStoreOrderPackSizeMode(String functionalityName){
        if(Constants.ST_ORDERINGPACKSIZE_CRE.equalsIgnoreCase(functionalityName) || Constants.ST_ORDERINGPACKSIZE_MNT.equalsIgnoreCase(functionalityName)){
            return true;            
        }
        return false;
    }
    
    public static RowSetIterator createRowSetIteratorWithReset(ViewObjectImpl vo, String name){        
        RowSetIterator rsi = null;        
        if(vo != null){                       
            rsi = vo.findRowSetIterator(name);            
            if(rsi == null){
                rsi = vo.createRowSetIterator(name);
                if(logger.isInfo())
                    logger.info(rsi.getName()+ " RowSetIterator is created newly in Rowset.");
            } else {
                rsi.reset();
                if(logger.isInfo())
                    logger.info(rsi.getName()+ " RowSetIterator is already exists in Rowset and reseted.");
            }
            
        }
        
        return rsi;
            
    }

    /**
     * Reads the dt system paramter value
     * @return
     */
    public static String getDtSysParamValue(String paramName) {
        logger.info("****** Inside getDtSysParamValue method ******");
        AipdtRootAMImpl rootAM = getRootApplicationModule();
        AipdtViewObjectImpl dtSysParamVOImpl = rootAM.getDtSystemParametersVO1();
        dtSysParamVOImpl.setApplyViewCriteriaName(null);
        dtSysParamVOImpl.setApplyViewCriteriaName("DtSystemParametersVC");
        dtSysParamVOImpl.setNamedWhereClauseParam("bindParamName", paramName);
        logger.info("Executing Dt System Param query : " + dtSysParamVOImpl.getQuery());
        dtSysParamVOImpl.executeQuery();
        DtSystemParametersVORowImpl dtSysParamRow = null;
        if (dtSysParamVOImpl.getEstimatedRowCount() > 0) {
            dtSysParamRow = (DtSystemParametersVORowImpl) dtSysParamVOImpl.first();
            return dtSysParamRow.getValue();
        } else {
            logger.severe("Parameter : " + paramName + " is not defined in the DT_SYSTEM_PARAMETERS table.");
            return null;
        }
    }
    
    /**
     * Below methhod returns values of specified column from DT_LIST_DETAIL table based on given bindVariable value in separated by semicolon.
     * @param selectedListId : Column value to be aggregated.
     * @param listType : bindVariable value .
     * @return
     */
    
    public static String fetchIdsFromDtListDetailTable(Number selectedListId, String listType) {
        String itemVal = null;
        String query =
            "SELECT LISTAGG("+listType+", ';')\n" + "  WITHIN GROUP (ORDER BY "+listType+") LIST_IDS\n" +
            "  FROM DT_LIST_DETAIL\n" + "  WHERE LIST_ID = "+selectedListId;
        ResultSet rs;        
        try {
            AipdtRootAMImpl rootAM = getRootApplicationModule();
            rs = rootAM.getDBTransaction().createStatement(0).executeQuery(query);
            if (rs.next()) {
                itemVal = String.valueOf(rs.getObject(1));
            }
            rs.close();
        } catch (SQLException e) {
            throw new JboException(e);
        }
        return itemVal;
    }
    
    public static String getModelBundleValue(String key) {
        return getXlifLocalizedString(Constants.AIPDT_MODEL_BUNDLE, key);
    }
}
