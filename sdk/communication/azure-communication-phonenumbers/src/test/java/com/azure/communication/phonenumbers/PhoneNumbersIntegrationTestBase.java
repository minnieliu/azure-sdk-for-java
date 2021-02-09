// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.communication.phonenumbers;

import java.time.OffsetDateTime;

import com.azure.communication.common.implementation.CommunicationConnectionString;
import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;
import com.azure.core.http.HttpClient;
import com.azure.core.test.TestBase;
import com.azure.core.test.TestMode;
import com.azure.core.util.Configuration;
import com.azure.identity.DefaultAzureCredentialBuilder;

import reactor.core.publisher.Mono;

public class PhoneNumbersIntegrationTestBase extends TestBase {
    private static final String ENV_ACCESS_KEY =
        Configuration.getGlobalConfiguration().get("COMMUNICATION_SERVICE_ACCESS_KEY", "QWNjZXNzS2V5");
    private static final String ENV_ENDPOINT =
        Configuration.getGlobalConfiguration().get("COMMUNICATION_SERVICE_ENDPOINT", "https://REDACTED.communication.azure.com");
    private static final String CONNECTION_STRING = Configuration.getGlobalConfiguration()
        .get("COMMUNICATION_LIVETEST_CONNECTION_STRING", "endpoint=https://REDACTED.communication.azure.com/;accesskey=QWNjZXNzS2V5");

    protected static final String PHONE_NUMBER =
        Configuration.getGlobalConfiguration().get("COMMUNICATION_PHONE_NUMBER", "+11234567891");
    protected static final String COUNTRY_CODE =
        Configuration.getGlobalConfiguration().get("COUNTRY_CODE", "US");
    protected static final String AREA_CODE =
        Configuration.getGlobalConfiguration().get("AREA_CODE", "833");

    protected PhoneNumbersClientBuilder getClientBuilder(HttpClient httpClient) {
        if (getTestMode() == TestMode.PLAYBACK) {
            httpClient = interceptorManager.getPlaybackClient();
        }

        PhoneNumbersClientBuilder builder = new PhoneNumbersClientBuilder();
        builder
            .httpClient(httpClient)
            .endpoint(ENV_ENDPOINT)
            .accessKey(ENV_ACCESS_KEY);

        if (getTestMode() == TestMode.RECORD) {
            builder.addPolicy(interceptorManager.getRecordPolicy());
        }

        return builder;
    }

    protected PhoneNumbersClientBuilder getClientBuilderWithConnectionString(HttpClient httpClient) {

        if (getTestMode() == TestMode.PLAYBACK) {
            httpClient = interceptorManager.getPlaybackClient();
        }

        PhoneNumbersClientBuilder builder = new PhoneNumbersClientBuilder();
        builder
            .httpClient(httpClient)
            .connectionString(CONNECTION_STRING);

        if (getTestMode() == TestMode.RECORD) {
            builder.addPolicy(interceptorManager.getRecordPolicy());
        }

        return builder;
    }

    protected PhoneNumbersClientBuilder getClientBuilderUsingManagedIdentity(HttpClient httpClient) {
        PhoneNumbersClientBuilder builder = new PhoneNumbersClientBuilder();
        builder
            .endpoint(new CommunicationConnectionString(CONNECTION_STRING).getEndpoint())
            .httpClient(httpClient == null ? interceptorManager.getPlaybackClient() : httpClient);

        if (getTestMode() == TestMode.PLAYBACK) {
            builder.credential(new FakeCredentials());
        } else {
            builder.credential(new DefaultAzureCredentialBuilder().build());
        }

        if (getTestMode() == TestMode.RECORD) {
            builder.addPolicy(interceptorManager.getRecordPolicy());
        }

        return builder;
    }

    protected PhoneNumbersClientBuilder addLoggingPolicy(PhoneNumbersClientBuilder builder, String testName) {
        return builder.addPolicy(new CommunicationLoggerPolicy(testName));
    }
    static class FakeCredentials implements TokenCredential {
        @Override
        public Mono<AccessToken> getToken(TokenRequestContext tokenRequestContext) {
            return Mono.just(new AccessToken("someFakeToken", OffsetDateTime.MAX));
        }
    }
}
