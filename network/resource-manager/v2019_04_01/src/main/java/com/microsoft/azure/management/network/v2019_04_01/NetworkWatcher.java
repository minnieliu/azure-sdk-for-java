/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_04_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2019_04_01.implementation.NetworkManager;
import com.microsoft.azure.management.network.v2019_04_01.implementation.NetworkWatcherInner;

/**
 * Type representing NetworkWatcher.
 */
public interface NetworkWatcher extends HasInner<NetworkWatcherInner>, Resource, GroupableResourceCore<NetworkManager, NetworkWatcherInner>, HasResourceGroup, Refreshable<NetworkWatcher>, Updatable<NetworkWatcher.Update>, HasManager<NetworkManager> {
    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * The entirety of the NetworkWatcher definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of NetworkWatcher definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a NetworkWatcher definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the NetworkWatcher definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the networkwatcher definition allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next definition stage
             */
            WithCreate withEtag(String etag);
        }

        /**
         * The stage of the networkwatcher definition allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState The provisioning state of the resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'
             * @return the next definition stage
             */
            WithCreate withProvisioningState(ProvisioningState provisioningState);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<NetworkWatcher>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithEtag, DefinitionStages.WithProvisioningState {
        }
    }
    /**
     * The template for a NetworkWatcher update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<NetworkWatcher>, Resource.UpdateWithTags<Update>, UpdateStages.WithEtag, UpdateStages.WithProvisioningState {
    }

    /**
     * Grouping of NetworkWatcher update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the networkwatcher update allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next update stage
             */
            Update withEtag(String etag);
        }

        /**
         * The stage of the networkwatcher update allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState The provisioning state of the resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'
             * @return the next update stage
             */
            Update withProvisioningState(ProvisioningState provisioningState);
        }

    }
}
