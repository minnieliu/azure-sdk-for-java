// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.administration.models;

import com.azure.communication.administration.implementation.models.PhoneNumberAssignmentType;
import com.azure.communication.administration.implementation.models.PhoneNumberType;
import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The PhoneNumberSearchRequest model. */
@Fluent
public final class PhoneNumberSearchRequest {
    /*
     * The phone number type.
     */
    @JsonProperty(value = "phoneNumberType", required = true)
    private PhoneNumberType phoneNumberType;

    /*
     * The phone number's assignment type.
     */
    @JsonProperty(value = "assignmentType", required = true)
    private PhoneNumberAssignmentType assignmentType;

    /*
     * The phone number's capabilities.
     */
    @JsonProperty(value = "capabilities", required = true)
    private PhoneNumberCapabilitiesRequest capabilities;

    /*
     * The desired area code.
     */
    @JsonProperty(value = "areaCode")
    private String areaCode;

    /*
     * The desired quantity of phone numbers.
     */
    @JsonProperty(value = "quantity")
    private Integer quantity;

    /**
     * Get the phoneNumberType property: The phone number type.
     *
     * @return the phoneNumberType value.
     */
    public PhoneNumberType getPhoneNumberType() {
        return this.phoneNumberType;
    }

    /**
     * Set the phoneNumberType property: The phone number type.
     *
     * @param phoneNumberType the phoneNumberType value to set.
     * @return the PhoneNumberSearchRequest object itself.
     */
    public PhoneNumberSearchRequest setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
        return this;
    }

    /**
     * Get the assignmentType property: The phone number's assignment type.
     *
     * @return the assignmentType value.
     */
    public PhoneNumberAssignmentType getAssignmentType() {
        return this.assignmentType;
    }

    /**
     * Set the assignmentType property: The phone number's assignment type.
     *
     * @param assignmentType the assignmentType value to set.
     * @return the PhoneNumberSearchRequest object itself.
     */
    public PhoneNumberSearchRequest setAssignmentType(PhoneNumberAssignmentType assignmentType) {
        this.assignmentType = assignmentType;
        return this;
    }

    /**
     * Get the capabilities property: The phone number's capabilities.
     *
     * @return the capabilities value.
     */
    public PhoneNumberCapabilitiesRequest getCapabilities() {
        return this.capabilities;
    }

    /**
     * Set the capabilities property: The phone number's capabilities.
     *
     * @param capabilities the capabilities value to set.
     * @return the PhoneNumberSearchRequest object itself.
     */
    public PhoneNumberSearchRequest setCapabilities(PhoneNumberCapabilitiesRequest capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    /**
     * Get the areaCode property: The desired area code.
     *
     * @return the areaCode value.
     */
    public String getAreaCode() {
        return this.areaCode;
    }

    /**
     * Set the areaCode property: The desired area code.
     *
     * @param areaCode the areaCode value to set.
     * @return the PhoneNumberSearchRequest object itself.
     */
    public PhoneNumberSearchRequest setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    /**
     * Get the quantity property: The desired quantity of phone numbers.
     *
     * @return the quantity value.
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * Set the quantity property: The desired quantity of phone numbers.
     *
     * @param quantity the quantity value to set.
     * @return the PhoneNumberSearchRequest object itself.
     */
    public PhoneNumberSearchRequest setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
