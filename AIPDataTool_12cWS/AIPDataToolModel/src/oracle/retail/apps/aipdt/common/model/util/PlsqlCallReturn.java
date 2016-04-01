package oracle.retail.apps.aipdt.common.model.util;


public class PlsqlCallReturn implements java.io.Serializable {
    @SuppressWarnings("compatibility:8531431783825630905")
    private static final long serialVersionUID = 8131972914207151796L;
    private int errorCode;
    private int executionStatus;
    private String errorMessage;
    
    public PlsqlCallReturn() {
        super();
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setExecutionStatus(int executionStatus) {
        this.executionStatus = executionStatus;
    }

    public int getExecutionStatus() {
        return executionStatus;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
