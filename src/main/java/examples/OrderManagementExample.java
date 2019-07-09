/*
 * Copyright 2018 Klarna AB
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
import com.klarna.rest.http_transport.HttpTransport;

import com.klarna.rest.model.ApiException;
import com.klarna.rest.api.order_management.OrderManagementOrdersApi;
import com.klarna.rest.api.order_management.OrderManagementRefundsApi;
import com.klarna.rest.api.order_management.model.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Checkout resource examples.
 */
public class OrderManagementExample {

    /**
     * Fetches a checkout order.
     */
    public static class FetchOrderExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /ordermanagement/v1/orders/{order_id}
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                OrderManagementOrder order = orderManagementOrdersApi.fetch(orderId);
                System.out.println(order);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /ordermanagement/v1/orders/{order_id}
        }
    }

    /**
     * Releases remaining authorization example.
     */
    public static class ReleaseRemainingAuthorizationExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /ordermanagement/v1/orders/{order_id}/release-remaining-authorization
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                orderManagementOrdersApi.releaseRemainingAuthorization(orderId);
                System.out.println("Remaining authorised amount has been released");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /ordermanagement/v1/orders/{order_id}/release-remaining-authorization
        }
    }

    /**
     * Extend authorization time example.
     */
    public static class ExtendAuthorizationTimeExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /ordermanagement/v1/orders/{order_id}/extend-authorization-time
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                orderManagementOrdersApi.extendAuthorizationTime(orderId);
                System.out.println("The expiry time of an order has been extend");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /ordermanagement/v1/orders/{order_id}/extend-authorization-time
        }
    }

    /**
     * Update customer addresses.
     */
    public static class UpdateCustomerAddressesExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: PATCH /ordermanagement/v1/orders/{order_id}/customer-details
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                final OrderManagementAddress address = new OrderManagementAddress()
                    .email("user@example.com")
                    .phone("57-3895734")
                    .givenName("John")
                    .familyName("Smith");

                orderManagementOrdersApi.updateCustomerAddresses(orderId, new OrderManagementUpdateConsumer()
                    .billingAddress(address)
                    .shippingAddress(address)
                );

                System.out.println("Customer details have been updated");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: PATCH /ordermanagement/v1/orders/{order_id}/customer-details
        }
    }

    /**
     * Cancel order.
     */
    public static class CancelOrderExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /ordermanagement/v1/orders/{order_id}/cancel
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                orderManagementOrdersApi.cancelOrder(orderId);
                System.out.println("Order has been cancelled");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /ordermanagement/v1/orders/{order_id}/cancel
        }
    }

    /**
     * Update merchant references.
     */
    public static class UpdateMerchantReferencesExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: PATCH /ordermanagement/v1/orders/{order_id}/merchant-references
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                orderManagementOrdersApi.updateMerchantReferences(orderId, new OrderManagementUpdateMerchantReferences()
                    .merchantReference1("15632423")
                    .merchantReference2("special order")
                );

                System.out.println("Merchant references have been updated");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: PATCH /ordermanagement/v1/orders/{order_id}/merchant-references
        }
    }

    /**
     * Acknowledge order.
     */
    public static class AcknowledgeOrderExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /ordermanagement/v1/orders/{order_id}/acknowledge
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                orderManagementOrdersApi.acknowledgeOrder(orderId);
                System.out.println("Order has been acknowledged");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /ordermanagement/v1/orders/{order_id}/acknowledge
        }
    }

    /**
     * Set new order amount and order lines.
     */
    public static class setOrderAmountAndOrderLines {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: PATCH /ordermanagement/v1/orders/{order_id}/authorization
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementOrdersApi orderManagementOrdersApi = client.newOrderManagementOrdersApi();

            try {
                final List<OrderManagementOrderLine> lines = Arrays.asList(
                    new OrderManagementOrderLine()
                        .type("physical")
                        .reference("123050")
                        .name("Tomatoes")
                        .quantity(10L)
                        .quantityUnit("kg")
                        .unitPrice(600L)
                        .taxRate(2500)
                        .totalAmount(6000L)
                        .totalTaxAmount(1200L)
                );

                final OrderManagementUpdateAuthorization orderData = new OrderManagementUpdateAuthorization()
                    .description("Removed bad bananas")
                    .orderAmount(6000L)
                    .orderLines(lines);

                orderManagementOrdersApi.setOrderAmountAndOrderLines(orderId, orderData);
                System.out.println("New order amount and order lines have been set");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: PATCH /ordermanagement/v1/orders/{order_id}/authorization
        }
    }

    /**
     * Create a new order refund.
     */
    public static class CreateRefundExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /ordermanagement/v1/orders/{order_id}/refunds
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementRefundsApi orderManagementRefundsApi = client.newOrderManagementRefundsApi(orderId);

            try {
                final List<OrderManagementOrderLine> lines = Arrays.asList(
                    new OrderManagementOrderLine()
                        .type("physical")
                        .reference("123050")
                        .name("Tomatoes")
                        .quantity(5L)
                        .quantityUnit("kg")
                        .unitPrice(600L)
                        .taxRate(2500)
                        .totalAmount(3000L)
                        .totalTaxAmount(750L)
                );

                final OrderManagementRefundObject refund = new OrderManagementRefundObject()
                    .refundedAmount(3000L)
                    .description("Refunding half the tomatoes")
                    .orderLines(lines);

                orderManagementRefundsApi.create(refund);
                System.out.println("Refund has been created");

                // The refund ID will be sent back in the Header.
                String refundId = orderManagementRefundsApi.getLastResponse().getHeader("Refund-Id").get(0);
                System.out.println("Refund ID: " + refundId);

                // Also we got back a new Location header, so we can just use it by calling fetch method
                OrderManagementRefund createdRefund = orderManagementRefundsApi.fetch();
                System.out.println(createdRefund);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /ordermanagement/v1/orders/{order_id}/refunds
        }
    }

    public static class FetchRefundExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /ordermanagement/v1/orders/{order_id}/refunds/{refund_id}
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String orderId = "12345";
            String refundId = "34567";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            OrderManagementRefundsApi orderManagementRefundsApi = client.newOrderManagementRefundsApi(orderId);

            try {
                OrderManagementRefund refund = orderManagementRefundsApi.fetch(refundId);
                System.out.println(refund);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /ordermanagement/v1/orders/{order_id}/refunds/{refund_id}
        }
    }
}
