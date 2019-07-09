/*
 * Copyright 2019 Klarna AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package examples;

import com.klarna.rest.Client;
import com.klarna.rest.api.instant_shopping.InstantShoppingButtonKeysApi;
import com.klarna.rest.api.instant_shopping.InstantShoppingOrdersApi;
import com.klarna.rest.api.instant_shopping.model.*;
import com.klarna.rest.http_transport.HttpTransport;
import com.klarna.rest.model.ApiException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Instant Shopping resource examples.
 */
public class InstantShoppingExample {
    /**
     * Creates new Instant Shopping Button.
     */
    public static class CreateButtonKeyExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /instantshopping/v1/buttons
            String username = "K123456_abcd12345";
            String password = "sharedSecret";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            InstantShoppingButtonKeysApi api = client.newInstantShoppingButtonKeysApi();

            try {
                final List<InstantShoppingOrderLineV1> lines = Arrays.asList(
                    new InstantShoppingOrderLineV1()
                            .type(InstantShoppingOrderLineV1.TypeEnum.PHYSICAL)
                            .reference("123050")
                            .name("Tomatoes")
                            .quantity(10L)
                            .quantityUnit("kg")
                            .unitPrice(600L)
                            .taxRate(0L)
                            .totalAmount(6000L)
                            .totalTaxAmount(0L)
                    );

                InstantShoppingButtonSetupOptionsV1 options = new InstantShoppingButtonSetupOptionsV1()
                        .merchantUrls(new InstantShoppingButtonSetupOptionsV1MerchantUrls()
                                .placeOrder("https://example.com/place")
                                .push("https://example.com/push")
                                .confirmation("https://example.com/confirm")
                                .terms("https://example.com/terms")
                                .notification("https://example.com/notification")
                                .update("https://example.com/update"))
                        .purchaseCountry("DE")
                        .purchaseCurrency("EUR")
                        .locale("de-DE")
                        .orderAmount(6000L)
                        .orderTaxAmount(0L)
                        .orderLines(lines)
                        .shippingOptions(Arrays.asList(new InstantShoppingShippingOptionV1()
                                .id("dhl")
                                .name("DHL Express")
                                .price(10L)
                                .taxAmount(0L)
                                .taxRate(0L)
                                .shippingMethod(InstantShoppingShippingOptionV1.ShippingMethodEnum.DHL_PACKSTATION)
                        ));
                InstantShoppingButtonSetupOptionsV1 button = api.createButtonKey(options);

                System.out.println("Button key: " + button.getButtonKey());

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /instantshopping/v1/buttons
        }
    }

    public static class UpdateButtonKeyExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: PUT /instantshopping/v1/buttons/{button_key}
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String buttonKey = "button-key-123";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            InstantShoppingButtonKeysApi api = client.newInstantShoppingButtonKeysApi();

            try {
                final List<InstantShoppingOrderLineV1> lines = Arrays.asList(
                        new InstantShoppingOrderLineV1()
                                .type(InstantShoppingOrderLineV1.TypeEnum.PHYSICAL)
                                .reference("123050")
                                .name("Tomatoes")
                                .quantity(10L)
                                .quantityUnit("kg")
                                .unitPrice(600L)
                                .taxRate(0L)
                                .totalAmount(6000L)
                                .totalTaxAmount(0L)
                );

                InstantShoppingButtonSetupOptionsV1 options = new InstantShoppingButtonSetupOptionsV1()
                        .merchantUrls(new InstantShoppingButtonSetupOptionsV1MerchantUrls()
                                .placeOrder("https://example.com/place")
                                .push("https://example.com/push")
                                .confirmation("https://example.com/confirm")
                                .terms("https://example.com/terms")
                                .notification("https://example.com/notification")
                                .update("https://example.com/update"))
                        .purchaseCountry("DE")
                        .purchaseCurrency("EUR")
                        .locale("de-DE")
                        .orderAmount(6000L)
                        .orderTaxAmount(0L)
                        .orderLines(lines)
                        .shippingOptions(Arrays.asList(new InstantShoppingShippingOptionV1()
                                .id("dhl")
                                .name("DHL Express")
                                .price(10L)
                                .taxAmount(0L)
                                .taxRate(0L)
                                .shippingMethod(InstantShoppingShippingOptionV1.ShippingMethodEnum.DHL_PACKSTATION)
                        ));
                InstantShoppingButtonSetupOptionsV1 button = api.updateButtonKey(buttonKey, options);
                System.out.println(button);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: PUT /instantshopping/v1/buttons/{button_key}
        }
    }

    public static class FetchButtonKeyExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /instantshopping/v1/buttons/{button_key}
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String buttonKey = "button-key-123";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            InstantShoppingButtonKeysApi api = client.newInstantShoppingButtonKeysApi();

            try {
                InstantShoppingButtonSetupOptionsV1 button = api.fetchButtonKeyOptions(buttonKey);
                System.out.println(button);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /instantshopping/v1/buttons/{button_key}
        }
    }

    public static class DeclineOrderExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: DELETE /instantshopping/v1/authorizations/{authorization_token}
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String authorizationToken = "auth-token-123";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            InstantShoppingOrdersApi api = client.newInstantShoppingOrdersApi(authorizationToken);

            try {
                InstantShoppingMerchantDeclineOrderRequestV1 reason = new InstantShoppingMerchantDeclineOrderRequestV1()
                        .denyCode("out_of_stock")
                        .denyMessage("The product you ordered is out of stock")
                        .denyRedirectUrl("https://example.com/denied");

                api.declineAuthorizedOrder(reason);
                System.out.println("Order has been declined");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: DELETE /instantshopping/v1/authorizations/{authorization_token}
        }
    }

    public static class RertieveOrderExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /instantshopping/v1/authorizations/{authorization_token}
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String authorizationToken = "auth-token-123";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            InstantShoppingOrdersApi api = client.newInstantShoppingOrdersApi(authorizationToken);

            try {
                InstantShoppingMerchantGetOrderResponseV1 order = api.retrieveAuthorizedOrder();
                System.out.println(order);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /instantshopping/v1/authorizations/{authorization_token}
        }
    }

    public static class ApproveOrderExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /instantshopping/v1/authorizations/{authorization_token}/orders
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String authorizationToken = "auth-token-123";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            InstantShoppingOrdersApi api = client.newInstantShoppingOrdersApi(authorizationToken);

            InstantShoppingAddressV1 address = new InstantShoppingAddressV1()
                    .givenName("Jane")
                    .familyName("Doe")
                    .email("jane@doe.com")
                    .title("Ms")
                    .streetAddress("Lombard St 10")
                    .streetAddress2("Apt 214")
                    .postalCode("90210")
                    .city("Beverly Hills")
                    .region("CA")
                    .phone("333444555")
                    .country("US");

            try {
                InstantShoppingMerchantCreateOrderRequestV1 order = new InstantShoppingMerchantCreateOrderRequestV1()
                    .name("Women's Fashion")
                    .purchaseCountry("US")
                    .purchaseCurrency("USD")
                    .locale("en-US")
                    .billingAddress(address)
                    .shippingAddress(address)
                        .orderAmount(50000L)
                        .orderTaxAmount(5000L)
                        .orderLines(Arrays.asList(new InstantShoppingOrderLineV1()
                                .name("Red T-Shirt")
                                .type(InstantShoppingOrderLineV1.TypeEnum.PHYSICAL)
                                .reference("19-402-USA")
                                .quantity(5L)
                                .quantityUnit("pcs")
                                .taxRate(1000L)
                                .totalAmount(50000L)
                                .totalDiscountAmount(0L)
                                .totalTaxAmount(5000L)
                                .unitPrice(10000L)
                                .productUrl("https://www.estore.com/products/f2a8d7e34")
                                .imageUrl("https://www.exampleobjects.com/logo.png")
                                .productIdentifiers(new InstantShoppingProductIdentifiersV1()
                                        .categoryPath("Electronics Store > Computers & Tablets > Desktops")
                                        .globalTradeItemNumber("735858293167")
                                        .manufacturerPartNumber("BOXNUC5CPYH")
                                        .brand("Intel")
                                )
                        ))
                        .merchantUrls(new InstantShoppingMerchantUrlsV1()
                                .terms("https://example.com/terms")
                                .notification("https://example.com/notification")
                                .confirmation("https://example.com/confirn")
                                .push("https://example.com/push")
                                .placeOrder("https://example.com/place")
                        )
                        .customer(new InstantShoppingCustomerV1()
                                .dateOfBirth("1995-10-20")
                                .title("Mr")
                                .gender("male")
                                .lastFourSsn("0512")
                                .nationalIdentificationNumber("3108971100")
                                .type("person")
                                .vatId("string")
                                .organizationRegistrationId("556737-0431")
                                .organizationEntityType("LIMITED_COMPANY")
                        );


                InstantShoppingMerchantCreateOrderResponseV1 status = api.approveAuthorizedOrder(order);
                System.out.println(status);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /instantshopping/v1/authorizations/{authorization_token}/orders
        }
    }
}
