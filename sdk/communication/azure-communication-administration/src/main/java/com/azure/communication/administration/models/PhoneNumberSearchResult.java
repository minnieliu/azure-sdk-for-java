// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.administration.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;

/** The PhoneNumberSearchResult model. */
@Fluent
public final class PhoneNumberSearchResult {
    /*
     * The search id.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    /*
     * The phone numbers that are available. Can be fewer than the desired
     * search quantity.
     */
    @JsonProperty(value = "phoneNumbers", required = true)
    private List<String> phoneNumbers;

    /*
     * The phoner number type.
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
    private PhoneNumberCapabilities capabilities;

    /*
     * The monthly cost for an individual phone number.
     */
    @JsonProperty(value = "cost", required = true)
    private PhoneNumberCost cost;

    /*
     * The date that this search result expires and phone numbers are no longer
     * on hold. A search result expires in less than 15min.
     */
    @JsonProperty(value = "searchExpiresBy", required = true)
    private OffsetDateTime searchExpiresBy;

    /**
     * Get the id property: The search id.
     *
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: The search id.
     *
     * @param id the id value to set.
     * @return the PhoneNumberSearchResult object itself.
     */
    public PhoneNumberSearchResult setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the phoneNumbers property: The phone numbers that are available. Can be fewer than the desired search
     * quantity.
     *
     * @return the phoneNumbers value.
     */
    public List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    /**
     * Set the phoneNumbers property: The phone numbers that are available. Can be fewer than the desired search
     * quantity.
     *
     * @param phoneNumbers the phoneNumbers value to set.
     * @return the PhoneNumberSearchResult object itself.
     */
    public PhoneNumberSearchResult setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    /**
     * Get the phoneNumberType property: The phoner number type.
     *
     * @return the phoneNumberType value.
     */
    public PhoneNumberType getPhoneNumberType() {
        return this.phoneNumberType;
    }

    /**
     * Set the phoneNumberType property: The phoner number type.
     *
     * @param phoneNumberType the phoneNumberType value to set.
     * @return the PhoneNumberSearchResult object itself.
     */
    public PhoneNumberSearchResult setPhoneNumberType(PhoneNumberType phoneNumberType) {
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
     * @return the PhoneNumberSearchResult object itself.
     */
    public PhoneNumberSearchResult setAssignmentType(PhoneNumberAssignmentType assignmentType) {
        this.assignmentType = assignmentType;
        return this;
    }

    /**
     * Get the capabilities property: The phone number's capabilities.
     *
     * @return the capabilities value.
     */
    public PhoneNumberCapabilities getCapabilities() {
        return this.capabilities;
    }

    /**
     * Set the capabilities property: The phone number's capabilities.
     *
     * @param capabilities the capabilities value to set.
     * @return the PhoneNumberSearchResult object itself.
     */
    public PhoneNumberSearchResult setCapabilities(PhoneNumberCapabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    /**
     * Get the cost property: The monthly cost for an individual phone number.
     *
     * @return the cost value.
     */
    public PhoneNumberCost getCost() {
        return this.cost;
    }

    /**
     * Set the cost property: The monthly cost for an individual phone number.
     *
     * @param cost the cost value to set.
     * @return the PhoneNumberSearchResult object itself.
     */
    public PhoneNumberSearchResult setCost(PhoneNumberCost cost) {
        this.cost = cost;
        return this;
    }

    /**
     * Get the searchExpiresBy property: The date that this search result expires and phone numbers are no longer on
     * hold. A search result expires in less than 15min.
     *
     * @return the searchExpiresBy value.
     */
    public OffsetDateTime getSearchExpiresBy() {
        return this.searchExpiresBy;
    }

    /**
     * Set the searchExpiresBy property: The date that this search result expires and phone numbers are no longer on
     * hold. A search result expires in less than 15min.
     *
     * @param searchExpiresBy the searchExpiresBy value to set.
     * @return the PhoneNumberSearchResult object itself.
     */
    public PhoneNumberSearchResult setSearchExpiresBy(OffsetDateTime searchExpiresBy) {
        this.searchExpiresBy = searchExpiresBy;
        return this;
    }
}
