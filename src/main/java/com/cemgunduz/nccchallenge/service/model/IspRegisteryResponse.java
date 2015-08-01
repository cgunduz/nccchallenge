package com.cemgunduz.nccchallenge.service.model;

/**
 * Created by cem.gunduz on 01.08.2015.
 *
 * Pojo to return Isp registery response
 */
public enum IspRegisteryResponse {

    SUCCESS(true, "The isp registery operation was successful"),
    DUPLICATE(false, "An isp with the supplied company name was already registered to the system"),
    IPV4_REGISTRY_SERVICE_PROBLEM(false, "Registry tool error, contact system adminstrators for support"),
    FAILURE(false, "Isp registery failed");

    private Boolean success;
    private String message;

    private IspRegisteryResponse(Boolean success, String message)
    {
        this.success = success;
        this.message = message;
    }
}
