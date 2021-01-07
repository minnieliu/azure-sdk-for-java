// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.administration.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The PhoneNumberCost model. */
@Fluent
public final class PhoneNumberCost {
    /*
     * The cost amount.
     */
    @JsonProperty(value = "amount", required = true)
    private double amount;

    /*
     * The ISO 4217 currency code for the cost amount.
     */
    @JsonProperty(value = "currencyCode", required = true)
    private String currencyCode;

    /*
     * The frequency with which the cost gets billed.
     */
    @JsonProperty(value = "billingFrequency", required = true)
    private String billingFrequency;

    /** Creates an instance of PhoneNumberCost class. */
    public PhoneNumberCost() {
        billingFrequency = "monthly";
    }

    /**
     * Get the amount property: The cost amount.
     *
     * @return the amount value.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Set the amount property: The cost amount.
     *
     * @param amount the amount value to set.
     * @return the PhoneNumberCost object itself.
     */
    public PhoneNumberCost setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get the currencyCode property: The ISO 4217 currency code for the cost amount.
     *
     * @return the currencyCode value.
     */
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * Set the currencyCode property: The ISO 4217 currency code for the cost amount.
     *
     * @param currencyCode the currencyCode value to set.
     * @return the PhoneNumberCost object itself.
     */
    public PhoneNumberCost setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    /**
     * Get the billingFrequency property: The frequency with which the cost gets billed.
     *
     * @return the billingFrequency value.
     */
    public String getBillingFrequency() {
        return this.billingFrequency;
    }

    /**
     * Set the billingFrequency property: The frequency with which the cost gets billed.
     *
     * @param billingFrequency the billingFrequency value to set.
     * @return the PhoneNumberCost object itself.
     */
    public PhoneNumberCost setBillingFrequency(String billingFrequency) {
        this.billingFrequency = billingFrequency;
        return this;
    }
}
