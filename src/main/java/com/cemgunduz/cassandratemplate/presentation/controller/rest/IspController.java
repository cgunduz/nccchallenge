package com.cemgunduz.cassandratemplate.presentation.controller.rest;

import com.cemgunduz.cassandratemplate.persistence.mysql.models.Isp;
import com.cemgunduz.cassandratemplate.service.IspService;
import com.cemgunduz.cassandratemplate.service.model.IspRegisteryResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cem.gunduz on 01.08.2015.
 */

@RestController
@RequestMapping("/isp")
public class IspController {

    final static Logger logger = Logger.getLogger(IspController.class);

    @Autowired
    IspService ispService;

    @RequestMapping(value = "/companyName/{companyName}", method = RequestMethod.GET)
    public Isp getIspByCompanyName(@PathVariable String companyName)
    {
        return ispService.findRegisteredIspByCompanyName(companyName);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<String> getAllRegisteredIsps() throws Exception
    {
        return ispService.findAllRegisteredIspNames();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public IspRegisteryResponse registerIsp(@RequestBody Isp isp) throws Exception
    {
        return ispService.registerIsp(isp);
    }

}
