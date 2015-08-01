package com.cemgunduz.nccchallenge.persistence.mysql.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cem.gunduz on 01.08.2015.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Isp {

    @Id
    @GeneratedValue
    private Long id;

    private String companyName;
    private String website;
    private String ipv4Prefix;
    private Long totalAddresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIpv4Prefix() {
        return ipv4Prefix;
    }

    public void setIpv4Prefix(String ipv4Prefix) {
        this.ipv4Prefix = ipv4Prefix;
    }

    public Long getTotalAddresses() {
        return totalAddresses;
    }

    public void setTotalAddresses(Long totalAddresses) {
        this.totalAddresses = totalAddresses;
    }
}
