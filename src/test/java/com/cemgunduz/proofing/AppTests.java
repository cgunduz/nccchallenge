package com.cemgunduz.proofing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/testConfig.xml")
public class AppTests {

    /**
     * 3rd party tool sanity test
     *
     * Asks for an ip allocation, Just to see the 3rd party service is up and running
     *
     */
    @Test
    public void allocateAnIpAddress()
    {

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

    }
}
