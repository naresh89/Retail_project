package oracle.retail.apps.aipdt.common.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.concurrent.TimeUnit;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.ApplicationModule;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.exception.AipdtException;
import oracle.retail.apps.aipdt.common.model.view.DateParamVORowImpl;

public abstract class DateUtil {
    private static ADFLogger logger = ADFLogger.createADFLogger(DateUtil.class);
    
    public DateUtil() {
        super();
    }
    
    /**
     * This method will return java.util.Date from string value from given
     * DateFormat.
     * @param dateValue
     * @param dateFormat
     * @return
     */
    public static Date getJavaUtilDate(String dateValue, String dateFormat){
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Date utilDate = null;
        try {
            utilDate = formatter.parse(dateValue);
        } catch (ParseException e) {
            logger.severe(e);
        }
        
        return utilDate;
    }
    /**
     * COnverts the oracle domain date to java util date
     * @param domainDate
     * @return
     */
    public static Date getUtilDate(Object domainDate) {
        Date newUtilDate = null;
        if (domainDate instanceof oracle.jbo.domain.Date) {
            newUtilDate = ((oracle.jbo.domain.Date) domainDate).getValue();
        } else if (domainDate instanceof Date) {
            newUtilDate = (Date) domainDate;
        }

        return newUtilDate;
    }
    /**
     * This method will return string value of java.util.Date for given DateFormat.
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getJavaUtilDateAsString(Date date, String dateFormat){
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = null;
        dateString = formatter.format(date);
        logger.info("dateString="+dateString);        
        
        return dateString;
    }
    
    public static boolean isDateBeforeSysdate(java.sql.Date sqlDate){
        return new java.util.Date(sqlDate.getTime()).compareTo(new java.util.Date()) < 0;
    }
    
    public static boolean isEndDateAfterStartDate(java.sql.Date endDate, java.sql.Date startDate){
        return new java.util.Date(endDate.getTime()).compareTo(new java.util.Date(startDate.getTime())) > 0;
    }
    
    public static java.sql.Date getSysdateAsJavaSqlDate(){
        return new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
    }
    
    public static java.sql.Date getNextDayDate(java.sql.Date sqlDate){
        Calendar c = Calendar.getInstance(); 
        c.setTime(sqlDate); 
        c.add(Calendar.DATE, 1);
        return new java.sql.Date(c.getTime().getTime());
    }

    public static oracle.jbo.domain.Date getSystemDate() {
        DateParamVORowImpl row = (DateParamVORowImpl)getDateRow();
        if (row != null) {
            return row.getSystemDate();
        }
        return null;
    }

    public static oracle.jbo.domain.Date getSystemDatePlusOne() {
        DateParamVORowImpl row = (DateParamVORowImpl)getDateRow();
        if (row != null) {
            return row.getSystemDatePlusOne();
        }
        return null;
    }

    public static oracle.jbo.domain.Date getSystemHighDate() {
        DateParamVORowImpl row = (DateParamVORowImpl)getDateRow();
        if (row != null) {
            return row.getSystemHighDate();
        }
        return null;
    }   
    
    public static java.util.Date getSystemHighDatePlusOne() {
        DateParamVORowImpl row = (DateParamVORowImpl)getDateRow();
        if (row != null) {
            return new Date(row.getSystemHighDate().getValue().getTime() + TimeUnit.DAYS.toMillis(1));
        }
        return null;
    }
    
    public static oracle.jbo.domain.Date getVDatePlusOne() {
        DateParamVORowImpl row = (DateParamVORowImpl)getDateRow();
        if (row != null) {
            return row.getVdatePlusOne();
        }
        return null;
    }   
    
    public static Row getDateRow(){
        ApplicationModule am = AipdtModelUtil.findApplicationModuleFromRootAM(Constants.RECEIVING_CALENDAR_AM);
        ViewObject dateVO = am.findViewObject(Constants.DATE_PARAM_VO1);
        if(!dateVO.isExecuted()){
            dateVO.executeQuery();   
        }
        Row dateRow = dateVO.getCurrentRow();
        if(dateRow == null){
            dateRow = dateVO.first();
        }
        return dateRow;
    }
    
    public static java.sql.Date convertJavaDateToSqlDate(Object date) {
        java.sql.Date sqlDate = null;
        if (date instanceof java.util.Date) {
            java.util.Date effectiveDate = (java.util.Date) date;
            if (effectiveDate != null) {
                sqlDate = new java.sql.Date(effectiveDate.getTime());
            } else {
                throw new AipdtException("Date is empty");
            }
        } else {
            throw new AipdtException("Input parameter is not a util Date instance.");
        }
        return sqlDate;
    }
}
