package oracle.retail.apps.aipdt.rc.model.applicationmodule.client;

import oracle.jbo.client.remote.ApplicationModuleImpl;

import oracle.retail.apps.aipdt.rc.model.applicationmodule.common.ReceivingCalendarAM;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Dec 24 22:37:49 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ReceivingCalendarAMClient extends ApplicationModuleImpl implements ReceivingCalendarAM {
    /**
     * This is the default constructor (do not remove).
     */
    public ReceivingCalendarAMClient() {
    }

    public void initReceivingCalendar() {
        Object _ret =
            this.riInvokeExportedMethod(this,"initReceivingCalendar",null,null);
        return;
    }

    public void saveReceivingCalendar() {
        Object _ret =
            this.riInvokeExportedMethod(this,"saveReceivingCalendar",null,null);
        return;
    }

    public boolean handleSelect() {
        Object _ret = this.riInvokeExportedMethod(this,"handleSelect",null,null);
        return ((Boolean)_ret).booleanValue();
    }

    public void handleReset() {
        Object _ret = this.riInvokeExportedMethod(this,"handleReset",null,null);
        return;
    }
}
