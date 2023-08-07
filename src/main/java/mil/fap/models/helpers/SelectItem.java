package mil.fap.models.helpers;

/**
 * @author Lourdes Coronado Pesantes
 */


public class SelectItem {

    private String value;
    private String text;
    //private String valtext;
    private Boolean selected = false;
    
    public SelectItem() {
        
    }

 

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    
    
    
    public SelectItem(String value, String text) {
        this.value = value;
        this.text = text;
    }
    
//      public SelectItem(String valtext, String text) {
//        this.valtext = valtext;
//        this.text = text;
//    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

//    public String getValtext() {
//        return valtext;
//    }
//
//    public void setValtext(String valtext) {
//        this.valtext = valtext;
//    }

}
