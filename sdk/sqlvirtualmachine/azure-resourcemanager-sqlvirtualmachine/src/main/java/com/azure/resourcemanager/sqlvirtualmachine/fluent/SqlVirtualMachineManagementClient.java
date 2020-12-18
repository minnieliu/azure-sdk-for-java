// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sqlvirtualmachine.fluent;

import com.azure.core.http.HttpPipeline;
import java.time.Duration;

/** The interface for SqlVirtualMachineManagementClient class. */
public interface SqlVirtualMachineManagementClient {
    /**
     * Gets Subscription ID that identifies an Azure subscription.
     *
     * @return the subscriptionId value.
     */
    String getSubscriptionId();

    /**
     * Gets server parameter.
     *
     * @return the endpoint value.
     */
    String getEndpoint();

    /**
     * Gets Api Version.
     *
     * @return the apiVersion value.
     */
    String getApiVersion();

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    HttpPipeline getHttpPipeline();

    /**
     * Gets The default poll interval for long-running operation.
     *
     * @return the defaultPollInterval value.
     */
    Duration getDefaultPollInterval();

    /**
     * Gets the AvailabilityGroupListenersClient object to access its operations.
     *
     * @return the AvailabilityGroupListenersClient object.
     */
    AvailabilityGroupListenersClient getAvailabilityGroupListeners();

    /**
     * Gets the OperationsClient object to access its operations.
     *
     * @return the OperationsClient object.
     */
    OperationsClient getOperations();

    /**
     * Gets the SqlVirtualMachineGroupsClient object to access its operations.
     *
     * @return the SqlVirtualMachineGroupsClient object.
     */
    SqlVirtualMachineGroupsClient getSqlVirtualMachineGroups();

    /**
     * Gets the SqlVirtualMachinesClient object to access its operations.
     *
     * @return the SqlVirtualMachinesClient object.
     */
    SqlVirtualMachinesClient getSqlVirtualMachines();
}
