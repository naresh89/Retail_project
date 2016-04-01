package oracle.retail.apps.aipdt.common.exception;

import oracle.jbo.JboException;
import oracle.jbo.common.ResourceBundleDef;

public class AipdtException extends JboException {
    @SuppressWarnings("compatibility:-5969749462041652976")
    private static final long serialVersionUID = -8696872773844253550L;

    public AipdtException(Class<?> class1, String errorCode, Object[] params,
                          Exception[] exceptions) {
        super(class1, errorCode, params, exceptions);
    }

    public AipdtException(Class<?> class1, String errorCode, Object[] params,
                          JboException[] jboExceptions) {
        super(class1, errorCode, params, jboExceptions);
    }

    public AipdtException(ResourceBundleDef resourceBundleDef, String errorCode,
                          Object[] params) {
        super(resourceBundleDef, errorCode, params);
    }

    public AipdtException(Class<?> class1, String errorCode, Object[] params) {
        super(class1, errorCode, params);
    }

    public AipdtException(Throwable throwable) {
        super(throwable);
    }

    public AipdtException(String string) {
        super(string);
    }

    public AipdtException(String string, String string1, Object[] objects) {
        super(string, string1, objects);
    }
}
