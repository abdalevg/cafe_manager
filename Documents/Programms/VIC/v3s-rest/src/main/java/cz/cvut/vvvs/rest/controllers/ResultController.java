/*
 * Copyright (c) 2019 Czech Technical University in Prague.
 * All Rights Reserved.
 */
package cz.cvut.vvvs.rest.controllers;

import cz.cvut.vic.repository.PageRequest;
import cz.cvut.vvvs.rest.GenericDomainCodeDTO;
import cz.cvut.vvvs.rest.MetadataDTO;
import cz.cvut.vvvs.rest.ResultDTO;
import cz.cvut.vvvs.services.common.PageImpl;
import cz.cvut.vvvs.services.results.ResultForSearch;
import cz.cvut.vvvs.services.results.ResultSearchFilter;
import cz.cvut.vvvs.services.results.ResultService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;


/**
 * @author David Pavel
 */
@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    /*@RequestMapping(method = RequestMethod.GET, params = "query")
    public PageImpl<ResultForSearch> getResults(@RequestParam String query, PageRequest pageRequest) {
        ResultSearchFilter resultSearchFilter = new ResultSearchFilter();
        resultSearchFilter.setNameOrigOrEn(query);
        return resultService.findByFilter(resultSearchFilter, pageRequest, 0);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public PageImpl<ResultForSearch> getResultsById(@PathVariable("id") Long id, PageRequest pageRequest ){        
         List<Long> resultIds = new ArrayList<>();
         resultIds.add( id );        
         ResultSearchFilter resultSearchFilter = new ResultSearchFilter();
         resultSearchFilter.setResultIds(resultIds);
         return resultService.findByFilter( resultSearchFilter, pageRequest, 0);
    }*/
    
    @RequestMapping(method = RequestMethod.GET, params = "id")
    public ResultDTO getResultById(@RequestParam Long id, PageRequest pageRequest ){        
         
         List<Long> resultIds = new ArrayList<>();
         resultIds.add( id );        
         ResultSearchFilter resultSearchFilter = new ResultSearchFilter();
         resultSearchFilter.setResultIds(resultIds);
         
         ResultForSearch resultForSearch = resultService.findByFilter( resultSearchFilter, pageRequest, 0).iterator().next();
         
         ModelMapper modelMapper = new ModelMapper();
         
         ResultDTO resultDTO;
         resultDTO = modelMapper.map(resultForSearch, ResultDTO.class);
         resultDTO.setMetadata(modelMapper.map(resultForSearch, MetadataDTO.class) );
         resultDTO.setAuthorsList( id );
         
         return resultDTO;
    }

        
    
    
}
