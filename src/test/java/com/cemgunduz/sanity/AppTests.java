package com.cemgunduz.sanity;

import com.cemgunduz.nccchallenge.persistence.mysql.dao.IspDao;
import com.cemgunduz.nccchallenge.persistence.mysql.models.Isp;
import com.cemgunduz.nccchallenge.service.IpService;
import com.cemgunduz.nccchallenge.service.IspService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/testConfig.xml")
public class AppTests {

    @Autowired
    IpService ipService;

    @Autowired
    IspService ispService;

    @Autowired
    IspDao ispDao;

    /**
     * 3rd party tool sanity test
     *
     * Asks for an ip allocation, Just to see the 3rd party service is up and running
     *
     */
    @Test
    public void allocateAnIpAddress()
    {
        // Check to see whether there is any info coming from ipv4 registry service
        String prefix = ipService.allocateIpv4Prefix();
        Assert.assertNotNull(prefix);
    }

    /**
     * Mysql sanity test
     *
     * Queries mysql regarding a specific isp, expects certain values to be returned
     * Mostly checks success of write and mysql is up and running or not
     *
     */
    @Test
    public void getAllIsps()
    {
        // Delete all
        ispDao.deleteAll();

        // Create a test isp
        Isp isp = new Isp();
        isp.setCompanyName("Cem's company");
        isp.setWebsite("http://www.cemscompany.com");

        // Register it
        ispService.registerIsp(isp);

        // See it exists
        Isp cemsCompany = ispService.findRegisteredIspByCompanyName("Cem's company");
        Assert.assertEquals("Cem's company", cemsCompany.getCompanyName());
    }
}
