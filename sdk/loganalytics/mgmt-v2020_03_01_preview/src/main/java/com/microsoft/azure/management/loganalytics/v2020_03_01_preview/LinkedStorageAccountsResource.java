/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.loganalytics.v2020_03_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.loganalytics.v2020_03_01_preview.implementation.LinkedStorageAccountsResourceInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.loganalytics.v2020_03_01_preview.implementation.LogAnalyticsManager;
import java.util.List;

/**
 * Type representing LinkedStorageAccountsResource.
 */
public interface LinkedStorageAccountsResource extends HasInner<LinkedStorageAccountsResourceInner>, Indexable, Refreshable<LinkedStorageAccountsResource>, Updatable<LinkedStorageAccountsResource.Update>, HasManager<LogAnalyticsManager> {
    /**
     * @return the dataSourceType value.
     */
    DataSourceType dataSourceType();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the storageAccountIds value.
     */
    List<String> storageAccountIds();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the LinkedStorageAccountsResource definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithWorkspace, DefinitionStages.WithStorageAccountIds, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of LinkedStorageAccountsResource definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a LinkedStorageAccountsResource definition.
         */
        interface Blank extends WithWorkspace {
        }

        /**
         * The stage of the linkedstorageaccountsresource definition allowing to specify Workspace.
         */
        interface WithWorkspace {
           /**
            * Specifies resourceGroupName, workspaceName.
            * @param resourceGroupName The name of the resource group. The name is case insensitive
            * @param workspaceName The name of the workspace
            * @return the next definition stage
            */
            WithStorageAccountIds withExistingWorkspace(String resourceGroupName, String workspaceName);
        }

        /**
         * The stage of the linkedstorageaccountsresource definition allowing to specify StorageAccountIds.
         */
        interface WithStorageAccountIds {
           /**
            * Specifies storageAccountIds.
            * @param storageAccountIds Linked storage accounts resources ids
            * @return the next definition stage
            */
            WithCreate withStorageAccountIds(List<String> storageAccountIds);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<LinkedStorageAccountsResource> {
        }
    }
    /**
     * The template for a LinkedStorageAccountsResource update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<LinkedStorageAccountsResource>, UpdateStages.WithStorageAccountIds {
    }

    /**
     * Grouping of LinkedStorageAccountsResource update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the linkedstorageaccountsresource update allowing to specify StorageAccountIds.
         */
        interface WithStorageAccountIds {
            /**
             * Specifies storageAccountIds.
             * @param storageAccountIds Linked storage accounts resources ids
             * @return the next update stage
             */
            Update withStorageAccountIds(List<String> storageAccountIds);
        }

    }
}