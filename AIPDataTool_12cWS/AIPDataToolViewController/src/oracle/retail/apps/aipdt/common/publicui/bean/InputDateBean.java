package oracle.retail.apps.aipdt.common.publicui.bean;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.retail.apps.aipdt.common.Constants;
import oracle.retail.apps.aipdt.common.model.util.DateUtil;
import oracle.retail.apps.aipdt.common.model.view.DateParamVORowImpl;
import oracle.retail.apps.aipdt.common.view.util.AipdtUIUtil;

import org.apache.myfaces.trinidad.util.ComponentReference;


public class InputDateBean extends BaseRetailBean {
    @SuppressWarnings("compatibility:4537641971381725431")
    private static final long serialVersionUID = 3293232821653487627L;
    private static ADFLogger logger = ADFLogger.createADFLogger(InputDateBean.class);

    private ComponentReference<RichInputDate> startDateComp;
    private ComponentReference<RichInputDate> endDateComp;

    private Date minStartDate = null;
    private Date maxStartDate = null;
    private Date minEndDate = null;
    private Date maxEndDate = null;
    private Date sysHighDate = null;

    public InputDateBean() {
        super();
    }

    /**
     * Invoked when start date value is changed from the results table
     * @param valueChangeEvent
     */
    public void onStartDateChange(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (logger.isFine()) {
            logger.fine(getEventDetail(valueChangeEvent));
        }
        Object newStartDate = valueChangeEvent.getNewValue();
        if ((getEndDateComp() != null) && !getEndDateComp().isDisabled()) {
            setMinEndDate(getUtilDate(newStartDate));
            AdfFacesContext.getCurrentInstance().addPartialTarget(getEndDateComp());
        }
    }

    /**
     * Invoked when end date value is changed from the results table
     * @param valueChangeEvent
     */
    public void onEndDateChange(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (logger.isFine()) {
            logger.fine(getEventDetail(valueChangeEvent));
        }
        Object newEndDate = valueChangeEvent.getNewValue();
        if ((getStartDateComp() != null) && !getStartDateComp().isDisabled()) {
            setMaxStartDate(getUtilDate(newEndDate));
            AdfFacesContext.getCurrentInstance().addPartialTarget(getStartDateComp());
        }
    }

    /*
    public Date getMinStartDate() {
        try {
            Calendar now = Calendar.getInstance();
            java.util.Date date = now.getTime();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String minStartDate = formatter.format(date);
            return formatter.parse(minStartDate);
        } catch (Exception e) {
            return null;
        }
    }

    public Date getMinEndDate() {
        try {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1);
            java.util.Date date = c.getTime();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String minEndDate = formatter.format(date);
            return formatter.parse(minEndDate);
        } catch (Exception e) {
            return null;
        }
    }*/

    public void setMinStartDate(Date minStartDate) {
        this.minStartDate = minStartDate;
    }

    public void setMaxStartDate(Date maxStartDate) {
        this.maxStartDate = maxStartDate;
    }

    public void setMinEndDate(Date minEndDate) {
        this.minEndDate = minEndDate;
    }

    public void setMaxEndDate(Date maxEndDate) {
        this.maxEndDate = maxEndDate;
    }

    public void setStartDateComp(RichInputDate startDateComp) {
        this.startDateComp = ComponentReference.newUIComponentReference(startDateComp);
    }

    public RichInputDate getStartDateComp() {
        if (startDateComp != null) {
            return startDateComp.getComponent();
        }
        return null;
    }

    public void setEndDateComp(RichInputDate endDateComp) {
        this.endDateComp = ComponentReference.newUIComponentReference(endDateComp);
    }

    public RichInputDate getEndDateComp() {
        if (endDateComp != null) {
            return endDateComp.getComponent();
        }
        return null;
    }

    /**
     * Retrieves minimum value to be set for start date
     * @return
     */
    public Date getMinStartDate() {
        if (minStartDate == null) {
            DateParamVORowImpl row =
                (DateParamVORowImpl) AipdtUIUtil.getCurrentRowFromVO(Constants.AIPDT_ROOT_AM, Constants.DATE_PARAM_VO1);
            if (row != null && row.getMinStartDate() != null)
                minStartDate = row.getMinStartDate().getValue();
        }
        logger.fine("MinStartDate = " + minStartDate);
        return minStartDate;
    }

    /**
     * Retrieves maximum value to be set for start date
     * @return
     */
    public Date getMaxStartDate() {
        if (maxStartDate == null) {
            DateParamVORowImpl row =
                (DateParamVORowImpl) AipdtUIUtil.getCurrentRowFromVO(Constants.AIPDT_ROOT_AM, Constants.DATE_PARAM_VO1);
            if (row != null && row.getMaxStartDate() != null)
                maxStartDate = row.getMaxStartDate().getValue();
        }
        logger.fine("MaxStartDate = " + maxStartDate);
        return maxStartDate;
    }

    /**
     * Retrieves minimum value to be set for end date
     * @return
     */
    public Date getMinEndDate() {
        if (minEndDate == null) {
            DateParamVORowImpl row =
                (DateParamVORowImpl) AipdtUIUtil.getCurrentRowFromVO(Constants.AIPDT_ROOT_AM, Constants.DATE_PARAM_VO1);
            if (row != null && row.getMinEndDate() != null)
                minEndDate = row.getMinEndDate().getValue();
        }
        logger.fine("MinEndDate = " + minEndDate);
        return minEndDate;
    }

    /**
     * Retrieves maximum value to be set for end date
     * @return
     */
    public Date getMaxEndDate() {
        if (maxEndDate == null) {
            DateParamVORowImpl row =
                (DateParamVORowImpl) AipdtUIUtil.getCurrentRowFromVO(Constants.AIPDT_ROOT_AM, Constants.DATE_PARAM_VO1);
            if (row != null && row.getMaxEndDate() != null)
                maxEndDate = row.getMaxEndDate().getValue();
        }
        logger.fine("MaxEndDate = " + maxEndDate);
        return maxEndDate;
    }

    /*public boolean isUserEnteredInValidDate() {
        boolean isInvalid = false;
        WorkingGroupVORowImpl row =
            (WorkingGroupVORowImpl)AipdtUIUtils.getCurrentRowFromIterator(workingGroupVO1Iterator);
        oracle.jbo.domain.Date startDate = row.getStartDateAttr();
        oracle.jbo.domain.Date endDate = row.getEndDateAttr();

        if(startDate == null){
            isInvalid = true;
            AipdtUIUtils.showErrorMessage(AipdtUIUtils.getUIBundleValue("START_DATE_CAN_NOT_BE_NULL"), startInputDateBean);
        }
        if(endDate == null){
            isInvalid = true;
            AipdtUIUtils.showErrorMessage(AipdtUIUtils.getUIBundleValue("END_DATE_CAN_NOT_BE_NULL"), endInputDateBean);
        }
        if(startDate != null && endDate != null && startDate.getValue().after(endDate.getValue())) {
            isInvalid = true;
            AipdtUIUtils.showErrorMessage(AipdtUIUtils.getUIBundleValue("START_DATE_CAN_NOT_BE_GREAT_END_DATE"), startInputDateBean);
        }

        return isInvalid;
    }*/

    /**
     * COnverts the oracle domain date to java util date
     * @param domainDate
     * @return
     */
    private Date getUtilDate(Object domainDate) {
        Date newUtilDate = null;
        if (domainDate instanceof oracle.jbo.domain.Date) {
            newUtilDate = ((oracle.jbo.domain.Date) domainDate).getValue();
        } else if (domainDate instanceof Date) {
            newUtilDate = (Date) domainDate;
        }

        return newUtilDate;
    }

    private String getEventDetail(ValueChangeEvent vcEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("NewValue -->" + vcEvent.getNewValue() + Constants.PIPE_WITH_SPACE);
        sb.append("OldValue -->" + vcEvent.getOldValue() + Constants.PIPE_WITH_SPACE);
        sb.append("Component =" + vcEvent.getComponent());

        return sb.toString();
    }

    /**
     * Checks whether the start date value is on or after the VDate plus one or not
     * @return
     */
    public boolean isValidStartDate() {
        logger.info("Inside isValidStartDate method");
        if (getStartDateComp() != null) {
            oracle.jbo.domain.Date startDate = (oracle.jbo.domain.Date) getStartDateComp().getValue();
            oracle.jbo.domain.Date vdatePlusOne = DateUtil.getVDatePlusOne();
            if (startDate.compareTo(vdatePlusOne) > -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the end date value is on or after the VDate plus one or not
     * @return
     */
    public boolean isValidEndDate() {
        logger.info("Inside isValidEndDate method");
        if (getEndDateComp() != null) {
            oracle.jbo.domain.Date endDate = (oracle.jbo.domain.Date) getEndDateComp().getValue();
            oracle.jbo.domain.Date vdatePlusOne = DateUtil.getVDatePlusOne();
            if (endDate.compareTo(vdatePlusOne) > -1) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retrieves system high value to be set for end date
     * @return
     */
    public Date getSysHighDate() {
        if (sysHighDate == null) {
            DateParamVORowImpl row =
                (DateParamVORowImpl) AipdtUIUtil.getCurrentRowFromVO(Constants.AIPDT_ROOT_AM, Constants.DATE_PARAM_VO1);
            if (row != null && row.getSystemHighDate() != null)
                sysHighDate = row.getSystemHighDate().getValue();
        }
        logger.fine("SysHighDate = " + sysHighDate);
        return sysHighDate;
    }
}
