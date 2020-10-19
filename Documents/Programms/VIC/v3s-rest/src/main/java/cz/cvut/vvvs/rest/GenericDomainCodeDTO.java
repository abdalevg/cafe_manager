
package cz.cvut.vvvs.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.cvut.vic.domaincode.GenericDomainCode;

/**
 *
 * @author abdalevg
 */
public class GenericDomainCodeDTO {
    
    private String domain;
    private String code;
    private String labelCs;
    private String labelEn;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabelCs() {
        return labelCs;
    }

    public void setLabelCs(String labelCs) {
        this.labelCs = labelCs;
    }

    public String getLabelEn() {
        return labelEn;
    }

    public void setLabelEn(String labelEn) {
        this.labelEn = labelEn;
    }

     
   

   
    
    
    
    
    
}
