// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.communication.identity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.azure.communication.common.CommunicationUserIdentifier;
import com.azure.communication.identity.models.CommunicationIdentityTokenScope;
import com.azure.communication.identity.models.CommunicationUserToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.Response;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class CommunicationIdentityAsyncTests extends CommunicationIdentityClientTestBase {
    private CommunicationIdentityAsyncClient asyncClient;

    @Override
    protected void beforeTest() {
        super.beforeTest();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createAsyncIdentityClientUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "createAsyncIdentityClientUsingManagedIdentity");
        assertNotNull(asyncClient);

        // Action & Assert
        Mono<CommunicationUserIdentifier> response = asyncClient.createUser();
        StepVerifier.create(response)
            .assertNext(item -> {
                assertNotNull(item.getId());
                assertFalse(item.getId().isEmpty());
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createAsyncIdentityClientUsingConnectionString(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClientUsingConnectionString(httpClient);
        asyncClient = setupAsyncClient(builder, "createAsyncIdentityClientUsingConnectionString");
        assertNotNull(asyncClient);

        // Action & Assert
        Mono<CommunicationUserIdentifier> response = asyncClient.createUser();
        StepVerifier.create(response)
            .assertNext(item -> {
                assertNotNull(item.getId());
                assertFalse(item.getId().isEmpty());
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "createUser");

        // Action & Assert
        Mono<CommunicationUserIdentifier> response = asyncClient.createUser();
        StepVerifier.create(response)
            .assertNext(item -> {
                assertNotNull(item.getId());
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createUserWithResponse(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "createUserWithResponse");

        // Action & Assert
        Mono<Response<CommunicationUserIdentifier>> response = asyncClient.createUserWithResponse();
        StepVerifier.create(response)
            .assertNext(item -> {
                assertNotNull(item.getValue().getId());
                assertFalse(item.getValue().getId().isEmpty());
                assertEquals(201, item.getStatusCode(), "Expect status code to be 200");
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "deleteUser");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    return asyncClient.deleteUser(communicationUser);
                }))
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteUserWithResponse(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "deleteUserWithResponse");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    return asyncClient.deleteUserWithResponse(communicationUser);
                }))
            .assertNext(item -> {
                assertEquals(204, item.getStatusCode(), "Expect status code to be 204");
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteUserWithNullUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "deleteUserWithNullUser");

        // Action & Assert
        StepVerifier.create(
            asyncClient.deleteUser(null))
            .verifyError(NullPointerException.class);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteUserWithResponseWithNullUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "deleteUserWithResponseWithNullUser");

        // Action & Assert
        StepVerifier.create(
            asyncClient.deleteUserWithResponse(null))
            .verifyError(NullPointerException.class);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void revokeToken(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "revokeToken");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap((CommunicationUserIdentifier communicationUser) -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueToken(communicationUser, scopes)
                        .flatMap((CommunicationUserToken communicationUserToken) -> {
                            return asyncClient.revokeTokens(communicationUser);
                        });
                }))
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void revokeTokenWithResponse(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "revokeTokenWithResponse");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap((CommunicationUserIdentifier communicationUser) -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueToken(communicationUser, scopes)
                        .flatMap((CommunicationUserToken communicationUserToken) -> {
                            return asyncClient.revokeTokensWithResponse(communicationUser);
                        });
                }))
            .assertNext(item -> {
                assertEquals(204, item.getStatusCode(), "Expect status code to be 204");    
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void revokeTokenWithNullUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "revokeTokenWithNullUser");

        // Action & Assert
        StepVerifier.create(
            asyncClient.revokeTokens(null))
            .verifyError(NullPointerException.class);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void revokeTokenWithResponseWithNullUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "revokeTokenWithResponseWithNullUser");

        // Action & Assert
        StepVerifier.create(
            asyncClient.revokeTokensWithResponse(null))
            .verifyError(NullPointerException.class);
    }


    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void issueToken(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "issueToken");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueToken(communicationUser, scopes);
                }))
            .assertNext(issuedToken -> {
                assertNotNull(issuedToken.getToken());
                assertFalse(issuedToken.getToken().isEmpty());
                assertNotNull(issuedToken.getExpiresOn());
                assertFalse(issuedToken.getExpiresOn().toString().isEmpty());
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void issueTokenWithResponse(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "issueTokenWithResponse");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueTokenWithResponse(communicationUser, scopes);
                }))
            .assertNext(issuedToken -> {
                assertNotNull(issuedToken.getValue().getToken());
                assertFalse(issuedToken.getValue().getToken().isEmpty());
                assertNotNull(issuedToken.getValue().getExpiresOn());
                assertFalse(issuedToken.getValue().getExpiresOn().toString().isEmpty());
                assertEquals(issuedToken.getStatusCode(), 200);
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void issueTokenWithNullUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "issueTokenWithNullUser");
        List<CommunicationIdentityTokenScope> scopes = 
            new ArrayList<CommunicationIdentityTokenScope>();
        scopes.add(CommunicationIdentityTokenScope.CHAT);

        // Action & Assert
        StepVerifier.create(
            asyncClient.issueToken(null, scopes))
            .verifyError(NullPointerException.class);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void issueTokenWithNullScope(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "issueTokenWithNullScope");

        // Action & Assert
        StepVerifier.create(asyncClient.issueToken(new CommunicationUserIdentifier("testUser"), null))
            .verifyError(NullPointerException.class);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void issueTokenWithResponseWithNullUser(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder = getCommunicationIdentityClient(httpClient);
        asyncClient = setupAsyncClient(builder, "issueTokenWithResponseWithNullUser");
        List<CommunicationIdentityTokenScope> scopes = 
            new ArrayList<CommunicationIdentityTokenScope>();
        scopes.add(CommunicationIdentityTokenScope.CHAT);

        // Action & Assert
        StepVerifier.create(
            asyncClient.issueTokenWithResponse(null, scopes))
            .verifyError(NullPointerException.class);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createUserWithResponseUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "createUserWithResponseUsingManagedIdentity");

        // Action & Assert
        Mono<Response<CommunicationUserIdentifier>> response = asyncClient.createUserWithResponse();
        StepVerifier.create(response)
            .assertNext(item -> {
                assertNotNull(item.getValue().getId());
                assertFalse(item.getValue().getId().isEmpty());
                assertEquals(201, item.getStatusCode(), "Expect status code to be 200");
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createUserWithContextUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "createUserWithContextUsingManagedIdentity");

        // Action & Assert
        Mono<CommunicationUserIdentifier> response = asyncClient.createUser();
        StepVerifier.create(response)
            .assertNext(user -> {
                assertNotNull(user.getId());
                assertFalse(user.getId().isEmpty());
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteUserUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "deleteUserUsingManagedIdentity");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    return asyncClient.deleteUser(communicationUser);
                }))
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteUserWithResponseUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "deleteUserWithResponseUsingManagedIdentity");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    return asyncClient.deleteUserWithResponse(communicationUser);
                }))
            .assertNext(item -> {
                assertEquals(204, item.getStatusCode(), "Expect status code to be 204");
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void revokeTokenUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "revokeTokenUsingManagedIdentity");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueToken(communicationUser, scopes)
                        .flatMap(communicationUserToken -> {
                            return asyncClient.revokeTokens(communicationUser);
                        });
                }))
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void revokeTokenWithResponseUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "revokeTokenWithResponseUsingManagedIdentity");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueToken(communicationUser, scopes)
                        .flatMap(communicationUserToken -> {
                            return asyncClient.revokeTokensWithResponse(communicationUser);
                        });
                }))
            .assertNext(item -> {
                assertEquals(204, item.getStatusCode(), "Expect status code to be 204");    
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void issueTokenUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "issueTokenUsingManagedIdentity");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueToken(communicationUser, scopes);
                }))
            .assertNext(issuedToken -> {
                assertNotNull(issuedToken.getToken());
                assertFalse(issuedToken.getToken().isEmpty());
                assertNotNull(issuedToken.getExpiresOn());
                assertFalse(issuedToken.getExpiresOn().toString().isEmpty());
            })
            .verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void issueTokenWithResponseUsingManagedIdentity(HttpClient httpClient) {
        // Arrange
        CommunicationIdentityClientBuilder builder =  getCommunicationIdentityClientBuilderUsingManagedIdentity(httpClient);
        asyncClient = setupAsyncClient(builder, "issueTokenWithResponseUsingManagedIdentity");

        // Action & Assert
        StepVerifier.create(
            asyncClient.createUser()
                .flatMap(communicationUser -> {
                    List<CommunicationIdentityTokenScope> scopes = 
                        new ArrayList<CommunicationIdentityTokenScope>();
                    scopes.add(CommunicationIdentityTokenScope.CHAT);
                    return asyncClient.issueTokenWithResponse(communicationUser, scopes);
                }))
            .assertNext(issuedToken -> {
                assertNotNull(issuedToken.getValue().getToken());
                assertFalse(issuedToken.getValue().getToken().isEmpty());
                assertNotNull(issuedToken.getValue().getExpiresOn());
                assertFalse(issuedToken.getValue().getExpiresOn().toString().isEmpty());
            })
            .verifyComplete();
    }

    private CommunicationIdentityAsyncClient setupAsyncClient(CommunicationIdentityClientBuilder builder, String testName) {
        return addLoggingPolicy(builder, testName).buildAsyncClient();
    }
}


// TODO: 
// - Run tests in playback and make sure things passing
// - Write new tests for new createUserWithToken functions
// - Record new files for the new tests