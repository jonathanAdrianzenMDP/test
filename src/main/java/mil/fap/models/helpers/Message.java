package mil.fap.models.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class Message {

    public static final String Success = "success";
    public static final String Information = "info";
    public static final String Warning = "warning";
    public static final String Danger = "danger";

    private String type;
    private String message;
    private List<Object> parameters;
    private Object data;
    private String exception;
    private Boolean success;
    
    public Message() {

    }

    public Message(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getParameters() {
        return parameters;
    }

    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }

    public Message withParameters(String type) {
        if (type.equals(this.type)) {
            this.parameters = new ArrayList<>();

            int iSeparator = this.message.indexOf("|");
            String sParameters = this.message.substring(iSeparator + 1, this.message.length());

            this.message = this.message.substring(0, iSeparator);

            int iAmp = sParameters.indexOf("&");
            while (iAmp != -1) {
                parameters.add(sParameters.substring(0, iAmp));
                sParameters = sParameters.substring(iAmp + 1, sParameters.length());
                iAmp = sParameters.indexOf("&");
            }
            parameters.add(sParameters);
        }
        return this;
    }

    public Message convert(String message) {
        int iSeparator = message.indexOf("|");
        this.type = message.substring(0, iSeparator);
        this.message = message.substring(iSeparator + 1, message.length());
        return this;
    }

    public Message convert(String type, String message) {
        return new Message(
            type,
            message
        );
    }

    @Override
    public String toString() {
        return String.format(
            "Tipo: %s\nMensaje: %s",
            this.type,
            this.message
        );
    }

    /**
     * @return the exception
     */
    public String getException() {
        return exception;
    }

    /**
     * @param exception the exception to set
     */
    public void setException(String exception) {
        this.exception = exception;
    }

    /**
     * @return the success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
