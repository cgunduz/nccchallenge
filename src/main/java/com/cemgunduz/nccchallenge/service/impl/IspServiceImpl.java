package com.cemgunduz.nccchallenge.service.impl;

import com.cemgunduz.nccchallenge.persistence.mysql.dao.IspDao;
import com.cemgunduz.nccchallenge.persistence.mysql.models.Isp;
import com.cemgunduz.nccchallenge.service.IpService;
import com.cemgunduz.nccchallenge.service.IspService;
import com.cemgunduz.nccchallenge.service.model.IspRegisteryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cem.gunduz on 01.08.2015.
 */

@Service
@Transactional
public class IspServiceImpl implements IspService {

    @Autowired
    IpService ipService;

    @Autowired
    IspDao ispDao;

    @Override
    public List<String> findAllRegisteredIspNames() {

        return ispDao.findAllCompanyNames();
    }

    @Override
    public Isp findRegisteredIspByCompanyName(String companyName) {

        List<Isp> ispList = ispDao.findByCompanyName(companyName);
        // TODO : Redundant ?
        if(ispList != null  && ispList.size() > 0)
            return ispList.get(0);

        return null;
    }

    @Override
    public List<Isp> searchRegistedIspByCompanyName(String companyName) {

        return ispDao.findByCompanyNameLike(companyName);
    }

    // TODO : Add unexpected error, error handling, and return status
    @Override
    public IspRegisteryResponse registerIsp(Isp isp) {

        // Return duplicate response if isp is already registered to the system
        List<Isp> ispList = ispDao.findByCompanyName(isp.getCompanyName());
        if(ispList.size() > 0)
            return IspRegisteryResponse.DUPLICATE;

        // If 3rd party tool cuts down its support registry response will return a different error description
        try
        {
            // Allocate the ip block via the 3rd party application
            String prefix = ipService.allocateIpv4Prefix();
            isp.setIpv4Prefix(prefix);

            // Also calculate the total addresses before persisting, in order to not calculcate them again and again
            long totalAddresses = ipService.findTotalIpAddressesByIpv4prefix(prefix);
            isp.setTotalAddresses(totalAddresses);
        }
        catch (UnsupportedOperationException e)
        {
            return IspRegisteryResponse.IPV4_REGISTRY_SERVICE_PROBLEM;
        }

        // Finally persist
        ispDao.save(isp);

        return IspRegisteryResponse.SUCCESS;
    }
}
