

package cz.cvut.vvvs.rest;

import cz.cvut.vic.domaincode.GenericDomainCode;
import cz.cvut.vic.repository.PageRequest;
import cz.cvut.vic.repository.Sort;
import cz.cvut.vic.repository.Sort.Order;
import java.sql.Timestamp;
import java.util.Date;
import cz.cvut.vvvs.services.domaincodes.DomainCodeServiceImpl;
import cz.cvut.vvvs.services.domaincodes.LocalizedDomainCode;
import cz.cvut.vvvs.services.results.authors.ResultAuthor;
import cz.cvut.vvvs.services.results.authors.ResultAuthorServiceImpl;
import cz.cvut.vvvs.services.results.authors.ResultAuthorWrapperServiceImpl;
import cz.cvut.vvvs.services.results.authors.ResultAuthorWithAffiliations;
import java.util.List;


/**
 *
 * @author abdalevg
 */
public class ResultDTO {
    
    protected long      id;
    
    //protected List<String> authors;
    
    protected String    abstractCs;

    protected String    abstractEn;
    
    protected MetadataDTO  metadata;
    
    protected Long      superiorResult;
    
    protected GenericDomainCode resultKindGroup;

    protected GenericDomainCode resultKind;
    
    protected GenericDomainCode resultState;
    
    protected GenericDomainCode resultMeaning;
    
    protected GenericDomainCode resultCategory;
    
    protected GenericDomainCode costCategory;
    
    protected GenericDomainCode validForTerritory;
    
    protected GenericDomainCode wayOfUsage;
    
    protected GenericDomainCode language;
    
    public void setMetadata( MetadataDTO tmpMetadata ){
        this.metadata = tmpMetadata;       
    }

    public MetadataDTO getMetadata(){
        return this.metadata;
    }    

    public Long getSuperiorResult() {
        return superiorResult;
    }

    public void setSuperiorResult(Long superiorResult) {
        this.superiorResult = superiorResult;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbstractCs() {
        return abstractCs;
    }

    public void setAbstractCs(String abstractCs) {
        this.abstractCs = abstractCs;
    }

    public String getAbstractEn() {
        return abstractEn;
    }

    public void setAbstractEn(String abstractEn) {
        this.abstractEn = abstractEn;
    }
    
    public void setResultKind( GenericDomainCode resultKind ) {
        this.resultKind = resultKind;        
    }   
    
    public GenericDomainCodeDTO getResultKind() {
       return this.GenericDomainCodeConverter( resultKind );
    }
    
    public GenericDomainCodeDTO getResultKindGroup() {
        return  this.GenericDomainCodeConverter( resultKindGroup );
    }

    public void setResultKindGroup(GenericDomainCode resultKindGroup) {
        this.resultKindGroup = resultKindGroup;
    }    

    public GenericDomainCodeDTO getResultState() {
        return  this.GenericDomainCodeConverter( resultState );
    }

    public void setResultState(GenericDomainCode resultState) {
        this.resultState = resultState;
    }

    public GenericDomainCodeDTO getResultMeaning() {
        return  this.GenericDomainCodeConverter( resultMeaning );
    }

    public void setResultMeaning(GenericDomainCode resultMeaning) {
        this.resultMeaning = resultMeaning;
    }

    public GenericDomainCodeDTO getResultCategory() {
        return  this.GenericDomainCodeConverter( resultCategory );
    }

    public void setResultCategory(GenericDomainCode resultCategory) {
        this.resultCategory = resultCategory;
    }

    public GenericDomainCodeDTO getCostCategory() {
        return  this.GenericDomainCodeConverter( costCategory );
    }

    public void setCostCategory(GenericDomainCode costCategory) {
        this.costCategory = costCategory;
    }

    public GenericDomainCodeDTO getValidForTerritory() {
        return  this.GenericDomainCodeConverter( validForTerritory );
    }

    public void setValidForTerritory(GenericDomainCode validForTerritory) {
        this.validForTerritory = validForTerritory;
    }

    public GenericDomainCodeDTO getWayOfUsage() {
        return  this.GenericDomainCodeConverter( wayOfUsage );
    }

    public void setWayOfUsage(GenericDomainCode wayOfUsage) {
        this.wayOfUsage = wayOfUsage;
    }

    public GenericDomainCodeDTO getLanguage() {
        return  this.GenericDomainCodeConverter( language );
    }

    public void setLanguage(GenericDomainCode language) {
        this.language = language;
    }  

    private GenericDomainCodeDTO GenericDomainCodeConverter( GenericDomainCode genericDomainCode ){
        
        GenericDomainCodeDTO genericDomainCodeDTO = new GenericDomainCodeDTO();
        
        if( genericDomainCode != null ){
        
           genericDomainCodeDTO.setDomain( genericDomainCode.getDomena() );
           genericDomainCodeDTO.setCode( genericDomainCode.getKod() );           
        
        
           DomainCodeServiceImpl domainCodeServiceImpl = new DomainCodeServiceImpl();
           LocalizedDomainCode localizedDomainCode = domainCodeServiceImpl.findByDomainAndCode(true, genericDomainCode.getDomena(), genericDomainCode.getKod() );
        
           genericDomainCodeDTO.setLabelCs( localizedDomainCode.getValueCs() );
           genericDomainCodeDTO.setLabelEn( localizedDomainCode.getValueEn() );    
            
            
        }
        
        return genericDomainCodeDTO;
        
    }
    
    public void setAuthorsList( Long id ){
        
        ResultAuthorServiceImpl resultAuthorServiceImpl = new ResultAuthorServiceImpl();
           
        PageRequest pageRequest = new PageRequest( 0, 10000, new Sort( new Order("rank") ) );
        resultAuthorServiceImpl.findByResult( id, pageRequest );
        //ResultAuthor resultAuthor = resultAuthorServiceImpl.findByResult( id, pageRequest ).iterator().next();
        
        //System.out.println( "AUTHOR: " + resultAuthor.getSurname() );
        
    }
    
    
    
}
