/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_04_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Define match variables.
 */
public class MatchVariable {
    /**
     * Match Variable. Possible values include: 'RemoteAddr', 'RequestMethod',
     * 'QueryString', 'PostArgs', 'RequestUri', 'RequestHeaders',
     * 'RequestBody', 'RequestCookies'.
     */
    @JsonProperty(value = "variableName", required = true)
    private WebApplicationFirewallMatchVariable variableName;

    /**
     * Describes field of the matchVariable collection.
     */
    @JsonProperty(value = "selector")
    private String selector;

    /**
     * Get match Variable. Possible values include: 'RemoteAddr', 'RequestMethod', 'QueryString', 'PostArgs', 'RequestUri', 'RequestHeaders', 'RequestBody', 'RequestCookies'.
     *
     * @return the variableName value
     */
    public WebApplicationFirewallMatchVariable variableName() {
        return this.variableName;
    }

    /**
     * Set match Variable. Possible values include: 'RemoteAddr', 'RequestMethod', 'QueryString', 'PostArgs', 'RequestUri', 'RequestHeaders', 'RequestBody', 'RequestCookies'.
     *
     * @param variableName the variableName value to set
     * @return the MatchVariable object itself.
     */
    public MatchVariable withVariableName(WebApplicationFirewallMatchVariable variableName) {
        this.variableName = variableName;
        return this;
    }

    /**
     * Get describes field of the matchVariable collection.
     *
     * @return the selector value
     */
    public String selector() {
        return this.selector;
    }

    /**
     * Set describes field of the matchVariable collection.
     *
     * @param selector the selector value to set
     * @return the MatchVariable object itself.
     */
    public MatchVariable withSelector(String selector) {
        this.selector = selector;
        return this;
    }

}
