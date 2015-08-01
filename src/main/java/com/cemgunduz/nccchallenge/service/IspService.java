package com.cemgunduz.nccchallenge.service;

import com.cemgunduz.nccchallenge.persistence.mysql.models.Isp;
import com.cemgunduz.nccchallenge.service.model.IspRegisteryResponse;

import java.util.List;

/**
 * Created by cem.gunduz on 01.08.2015.
 */
public interface IspService {

    /**
     * Returns the company names of each registered isp in the system.
     *
     * @return
     */
    List<String> findAllRegisteredIspNames();

    /**
     * Finds a registered Isp by company name
     * The similar method search can also be triggered for a like query
     *
     * @param companyName
     * @return
     */
    Isp findRegisteredIspByCompanyName(String companyName);
    List<Isp> searchRegistedIspByCompanyName(String companyName);

    /**
     * Registers an isp to the system for the first time
     * Each isp can register to the system only once.
     * Everytime a registery is made, an ip block is handed out to the company
     * Returns a registery response pojo to display operation status
     *
     * @param isp
     * @return
     */
    IspRegisteryResponse registerIsp(Isp isp);
}
