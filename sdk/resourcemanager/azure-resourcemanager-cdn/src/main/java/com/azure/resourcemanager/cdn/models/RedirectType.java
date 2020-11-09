// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for RedirectType. */
public final class RedirectType extends ExpandableStringEnum<RedirectType> {
    /** Static value Moved for RedirectType. */
    public static final RedirectType MOVED = fromString("Moved");

    /** Static value Found for RedirectType. */
    public static final RedirectType FOUND = fromString("Found");

    /** Static value TemporaryRedirect for RedirectType. */
    public static final RedirectType TEMPORARY_REDIRECT = fromString("TemporaryRedirect");

    /** Static value PermanentRedirect for RedirectType. */
    public static final RedirectType PERMANENT_REDIRECT = fromString("PermanentRedirect");

    /**
     * Creates or finds a RedirectType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding RedirectType.
     */
    @JsonCreator
    public static RedirectType fromString(String name) {
        return fromString(name, RedirectType.class);
    }

    /** @return known RedirectType values. */
    public static Collection<RedirectType> values() {
        return values(RedirectType.class);
    }
}
