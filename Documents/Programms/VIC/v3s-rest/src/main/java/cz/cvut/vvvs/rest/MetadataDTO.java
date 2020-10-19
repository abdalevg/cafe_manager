
package cz.cvut.vvvs.rest;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author abdalevg
 */
public class MetadataDTO {
    
    protected Timestamp   whenChanged;
    private   Date        whenScopusCitsUpdated;
    private   Date        whenWosCitsUpdated;

     
    
    public Timestamp getWhenChanged() {
        return whenChanged;
    }

    public void setWhenChanged(Timestamp whenChanged) {
        this.whenChanged = whenChanged;
    }

    public Date getWhenScopusCitsUpdated() {
        return whenScopusCitsUpdated;
    }

    public void setWhenScopusCitsUpdated(Date whenScopusCitsUpdated) {
        this.whenScopusCitsUpdated = whenScopusCitsUpdated;
    }

    public Date getWhenWosCitsUpdated() {
        return whenWosCitsUpdated;
    }

    public void setWhenWosCitsUpdated(Date whenWosCitsUpdated) {
        this.whenWosCitsUpdated = whenWosCitsUpdated;
    }
    
    
    
    
    
}
