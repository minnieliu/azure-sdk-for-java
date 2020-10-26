package com.azure.communication.sms;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.azure.core.http.HttpClient;
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Configuration;
import com.azure.core.util.polling.SyncPoller;
import com.azure.communication.administration.PhoneNumberClient;
import com.azure.communication.administration.PhoneNumberClientBuilder;
import com.azure.communication.administration.models.CreateSearchOptions;
import com.azure.communication.administration.models.PhoneNumberSearch;
import com.azure.communication.administration.models.PhoneNumberType;
import com.azure.communication.administration.models.PhonePlan;
import com.azure.communication.administration.models.PhonePlanGroup;
import com.azure.communication.common.PhoneNumber;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PhoneNumberLiveTestSetup implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean started = false;
    private static String LOCALE = "en-us";
    private static String COUNTRY_CODE = "US";
    private static String NAME_FOR_SEARCH = "TestSearch";
    private static String DESCRIPTION_FOR_SEARCH = "Setup Phone Number Search for Live Tests";
    private PhoneNumberClient phoneNumberClient;
    private List<String> phoneNumbers;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            phoneNumberClient = createPhoneNumberClient();

            PagedIterable<PhonePlanGroup> phonePlanGroups = phoneNumberClient
                .listPhonePlanGroups(COUNTRY_CODE, LOCALE, true);
            
            String phonePlanGroupId = "";
            for(PhonePlanGroup phonePlanGroup: phonePlanGroups) {
                if (phonePlanGroup.getPhoneNumberType() == PhoneNumberType.TOLL_FREE) {
                    phonePlanGroupId = phonePlanGroup.getPhonePlanGroupId();
                }
            }

            PagedIterable<PhonePlan> phonePlans = phoneNumberClient
                .listPhonePlans(COUNTRY_CODE, phonePlanGroupId, LOCALE);
            
            PhonePlan phonePlan = phonePlans.iterator().next();
            String phonePlanId = phonePlan.getPhonePlanId();
            String areaCode = phonePlan.getAreaCodes().get(0);

            // // Create Search
            List<String> phonePlanIds = new ArrayList<>();
            phonePlanIds.add(phonePlanId);

            CreateSearchOptions createSearchOptions = new CreateSearchOptions();
            createSearchOptions
                .setAreaCode(areaCode)
                .setDescription(DESCRIPTION_FOR_SEARCH)
                .setDisplayName(NAME_FOR_SEARCH)
                .setPhonePlanIds(phonePlanIds)
                .setQuantity(1);

            Duration duration = Duration.ofSeconds(10);
            SyncPoller<PhoneNumberSearch, PhoneNumberSearch> res = phoneNumberClient.beginCreateSearch(createSearchOptions, duration);
            res.waitForCompletion();
            PhoneNumberSearch searchResult = res.getFinalResult();
            phoneNumbers = searchResult.getPhoneNumbers();
            if (phoneNumbers.size() > 0) {
                Configuration.getGlobalConfiguration().put("SMS_SERVICE_PHONE_NUMBER", phoneNumbers.get(0));
            }

            // TODO: Blocked on Purchase Phone Numbers LRO
            phoneNumberClient.purchaseSearch(searchResult.getSearchId());
        }
    }

    @Override
    public void close() {

        // Release phone numbers after tests end
        // TODO: Blocked on Release Phone Numbers LRO
        final List<PhoneNumber> releasedPhoneNumbers = new ArrayList<>();
        for(String phoneNumber : phoneNumbers) {
            releasedPhoneNumbers.add(new PhoneNumber(phoneNumber));
        }
        phoneNumberClient.releasePhoneNumbers(releasedPhoneNumbers);
    }

    private PhoneNumberClient createPhoneNumberClient() {
        final String ACCESSKEYRAW = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        final String ACCESSKEYENCODED = Base64.getEncoder().encodeToString(ACCESSKEYRAW.getBytes());
        final String CONNECTION_STRING = Configuration.getGlobalConfiguration()
            .get("COMMUNICATION_CONNECTION_STRING", "endpoint=https://REDACTED.communication.azure.com/;accesskey=" + ACCESSKEYENCODED);

        // Create an HttpClient builder of your choice and customize it
        HttpClient httpClient = new NettyAsyncHttpClientBuilder().build();

        return new PhoneNumberClientBuilder()
            .connectionString(CONNECTION_STRING)
            .httpClient(httpClient)
            .buildClient();
        }
}