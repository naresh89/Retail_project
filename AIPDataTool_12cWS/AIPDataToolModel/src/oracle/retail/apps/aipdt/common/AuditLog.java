package oracle.retail.apps.aipdt.common;

import java.util.Date;

import oracle.adf.share.ADFContext;


public class AuditLog {


    private String transactionId1;
    private String transactionId2;
    private String transactionId3;
    private String transactionId4;
    private String transactionId5;
    private String transactionId6;
    private String transactionId7;
    private FunctionalityType funtionalityType;
    private ActivityType activityType;
    private String tableName;
    private String loggedUserId;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String createUser;
    private Date createDate;


    public AuditLog() {
        super();
    }


    public AuditLog(String transactionId1, String transactionId2,
                    String transactionId3, String transactionId4,
                    String transactionId5, String transactionId6,
                    String transactionId7, FunctionalityType funtionalityType,
                    ActivityType activityType, String tableName,
                    String loggedUserId) {
        super();
        this.transactionId1 = transactionId1;
        this.transactionId2 = transactionId2;
        this.transactionId3 = transactionId3;
        this.transactionId4 = transactionId4;
        this.transactionId5 = transactionId5;
        this.transactionId6 = transactionId6;
        this.transactionId7 = transactionId7;
        this.funtionalityType = funtionalityType;
        this.activityType = activityType;
        this.tableName = tableName;
        this.loggedUserId = loggedUserId;
    }

    public AuditLog(String transactionId1, String transactionId2,
                    String transactionId3, String transactionId4,
                    String transactionId5, String transactionId6,
                    String transactionId7, FunctionalityType funtionalityType,
                    ActivityType activityType, String tableName,
                    String loggedUserId, String attribute1, String attribute2,
                    String attribute3, String attribute4, String attribute5) {
        this(transactionId1, transactionId2, transactionId3, transactionId4,
             transactionId5, transactionId6, transactionId7, funtionalityType,
             activityType, tableName, loggedUserId);
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
    }

    public void setTransactionId1(String transactionId) {
        this.transactionId1 = transactionId;
    }

    public String getTransactionId1() {
        return transactionId1;
    }

    public void setTransactionId2(String transactionId2) {
        this.transactionId2 = transactionId2;
    }

    public String getTransactionId2() {
        return transactionId2;
    }

    public void setTransactionId3(String transactionId3) {
        this.transactionId3 = transactionId3;
    }

    public String getTransactionId3() {
        return transactionId3;
    }

    public void setTransactionId4(String transactionId4) {
        this.transactionId4 = transactionId4;
    }

    public String getTransactionId4() {
        return transactionId4;
    }

    public void setTransactionId5(String transactionId5) {
        this.transactionId5 = transactionId5;
    }

    public String getTransactionId5() {
        return transactionId5;
    }

    public void setTransactionId6(String transactionId6) {
        this.transactionId6 = transactionId6;
    }

    public String getTransactionId6() {
        return transactionId6;
    }

    public void setTransactionId7(String transactionId7) {
        this.transactionId7 = transactionId7;
    }

    public String getTransactionId7() {
        return transactionId7;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setLoggedUserId(String loggedUserId) {
        this.loggedUserId = loggedUserId;
    }

    public String getLoggedUserId() {
        return loggedUserId;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setCreateUser(String createBy) {
        this.createUser = createBy;
    }

    public String getCreateUser() {
        if (this.createUser == null) {
            this.createUser = ADFContext.getCurrent().getSecurityContext().getUserName();
        }
        return createUser;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setFuntionalityType(FunctionalityType funtionalityType) {
        this.funtionalityType = funtionalityType;
    }

    public FunctionalityType getFuntionalityType() {
        return funtionalityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

}
