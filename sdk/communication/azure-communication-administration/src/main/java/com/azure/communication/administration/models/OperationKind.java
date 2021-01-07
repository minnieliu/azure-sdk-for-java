// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.administration.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for OperationKind. */
public final class OperationKind extends ExpandableStringEnum<OperationKind> {
    /** Static value search for OperationKind. */
    public static final OperationKind SEARCH = fromString("search");

    /** Static value purchase for OperationKind. */
    public static final OperationKind PURCHASE = fromString("purchase");

    /** Static value releasePhoneNumber for OperationKind. */
    public static final OperationKind RELEASE_PHONE_NUMBER = fromString("releasePhoneNumber");

    /** Static value updatePhoneNumberCapabilities for OperationKind. */
    public static final OperationKind UPDATE_PHONE_NUMBER_CAPABILITIES = fromString("updatePhoneNumberCapabilities");

    /**
     * Creates or finds a OperationKind from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding OperationKind.
     */
    @JsonCreator
    public static OperationKind fromString(String name) {
        return fromString(name, OperationKind.class);
    }

    /** @return known OperationKind values. */
    public static Collection<OperationKind> values() {
        return values(OperationKind.class);
    }
}
