package oracle.retail.apps.aipdt.common.adfbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.adf.share.logging.ADFLogger;

import oracle.retail.apps.framework.bc.model.ext.RetailApplicationModuleImpl;


public class AipdtApplicationModuleImpl extends RetailApplicationModuleImpl {
    private static final ADFLogger LOG =
        ADFLogger.createADFLogger(AipdtApplicationModuleImpl.class);

    private static final String SQL_CHECK_UNCOMMITTED_CHANGES = "SELECT * FROM v$session v\n" +
        "WHERE v.AUDSID = userenv('sessionid')\n" +
        " AND v.TADDR IS NOT NULL\n";

    private static final int NUM_PREFETCH_ROWS = 10;
    
    protected String METHOD_START_LOG =" Method: Start ----->";
    protected String METHOD_END_LOG =" Method: End ----->";
    protected String AND = " AND ";
    protected String OR = " OR ";

    public AipdtApplicationModuleImpl() {
        super();        
    }    
   
    /**
     * This method will check if there is any uncommitted data in Database that ADF is not aware of
     * e.g. any data that is updated directly by making a package call
     * @return true if uncommitted data exists, false otherwise
     */
    public boolean isTransactionDirtyInDB() {
        Statement stmt = getDBTransaction().createStatement(NUM_PREFETCH_ROWS);
        try {

            if (LOG.isFine()) {
                LOG.fine("EXCECUTING QUERY: " + SQL_CHECK_UNCOMMITTED_CHANGES);
            }
            ResultSet rs = stmt.executeQuery(SQL_CHECK_UNCOMMITTED_CHANGES);

            return rs.next();

        } catch (SQLException sqlEx) {
            throw new RuntimeException(sqlEx);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                LOG.warning("received exception while trying to close exception", e);
            }
        }
    } 
}
