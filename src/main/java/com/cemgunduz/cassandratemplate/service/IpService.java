package com.cemgunduz.cassandratemplate.service;

/**
 * Created by cem.gunduz on 01.08.2015.
 */
public interface IpService {

    /**
     * Calculates the total possible ip addresses available in a given prefix
     *
     * @param prefix
     * @return
     */
    Long findTotalIpAddressesByIpv4prefix(String prefix);

    /**
     * Talks with a 3rd party application,
     * Allocates and returns an ipv4 prefix
     *
     * @return
     */
    String allocateIpv4Prefix();
}
