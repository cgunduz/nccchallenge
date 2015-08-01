package com.cemgunduz.nccchallenge.service.impl;

import com.cemgunduz.nccchallenge.service.IpService;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Created by cem.gunduz on 01.08.2015.
 */

@Service
public class IpServiceImpl implements IpService {

    private final static Logger logger = Logger.getLogger(IpService.class);

    // TODO : Carry to properties file or smt
    private static final String IPV4_ALLOC_URI = "http://localhost:9000/allocate/ipv4";

    @Override
    public Long findTotalIpAddressesByIpv4prefix(String prefix) {

        if(prefix.indexOf('/') == -1)
        {
            logger.error("3rd party ipv4 registry service malfunction due to missing '/' character");
            throw new UnsupportedOperationException();
        }

        // TODO : This is also cachable according to CIDR chart
        int sizeOfTheBlock = Integer.valueOf(prefix.substring(prefix.indexOf('/')+1));
        return (long)Math.pow(2, 32 - sizeOfTheBlock);
    }

    @Override
    public String allocateIpv4Prefix() throws UnsupportedOperationException {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<HashMap> responseEntity = restTemplate.getForEntity(IPV4_ALLOC_URI, HashMap.class);
        if(!responseEntity.getBody().containsKey("ipv4_allocation"))
        {
            logger.error("3rd party ipv4 registry service malfunction due to missing ipv4 information");
            throw new UnsupportedOperationException();
        }
        return (String)responseEntity.getBody().get("ipv4_allocation");
    }
}
