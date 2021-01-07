// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.administration.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The PhoneNumberPurchaseRequest model. */
@Fluent
public final class PhoneNumberPurchaseRequest {
    /*
     * The id of the search result to purchase.
     */
    @JsonProperty(value = "searchId")
    private String searchId;

    /**
     * Get the searchId property: The id of the search result to purchase.
     *
     * @return the searchId value.
     */
    public String getSearchId() {
        return this.searchId;
    }

    /**
     * Set the searchId property: The id of the search result to purchase.
     *
     * @param searchId the searchId value to set.
     * @return the PhoneNumberPurchaseRequest object itself.
     */
    public PhoneNumberPurchaseRequest setSearchId(String searchId) {
        this.searchId = searchId;
        return this;
    }
}
