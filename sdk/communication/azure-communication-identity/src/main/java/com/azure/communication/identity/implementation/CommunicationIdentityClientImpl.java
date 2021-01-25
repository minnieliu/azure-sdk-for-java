// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.identity.implementation;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;

/** Initializes a new instance of the CommunicationIdentityClient type. */
public final class CommunicationIdentityClientImpl {
    /** The communication resource, for example https://my-resource.communication.azure.com. */
    private final String endpoint;

    /**
     * Gets The communication resource, for example https://my-resource.communication.azure.com.
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /** Api Version. */
    private final String apiVersion;

    /**
     * Gets Api Version.
     *
     * @return the apiVersion value.
     */
    public String getApiVersion() {
        return this.apiVersion;
    }

    /** The HTTP pipeline to send requests through. */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /** The serializer to serialize an object into a string. */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     *
     * @return the serializerAdapter value.
     */
    public SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /** The CommunicationIdentitiesImpl object to access its operations. */
    private final CommunicationIdentityImpl communicationIdentities;

    /**
     * Gets the CommunicationIdentitiesImpl object to access its operations.
     *
     * @return the CommunicationIdentitiesImpl object.
     */
    public CommunicationIdentityImpl getCommunicationIdentities() {
        return this.communicationIdentities;
    }

    /**
     * Initializes an instance of CommunicationIdentityClient client.
     *
     * @param endpoint The communication resource, for example https://my-resource.communication.azure.com.
     */
    CommunicationIdentityClientImpl(String endpoint) {
        this(
                new HttpPipelineBuilder()
                        .policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy())
                        .build(),
                JacksonAdapter.createDefaultSerializerAdapter(),
                endpoint);
    }

    /**
     * Initializes an instance of CommunicationIdentityClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param endpoint The communication resource, for example https://my-resource.communication.azure.com.
     */
    CommunicationIdentityClientImpl(HttpPipeline httpPipeline, String endpoint) {
        this(httpPipeline, JacksonAdapter.createDefaultSerializerAdapter(), endpoint);
    }

    /**
     * Initializes an instance of CommunicationIdentityClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     * @param endpoint The communication resource, for example https://my-resource.communication.azure.com.
     */
    CommunicationIdentityClientImpl(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.endpoint = endpoint;
        this.apiVersion = "2021-03-07";
        this.communicationIdentities = new CommunicationIdentityImpl(this);
    }
}
