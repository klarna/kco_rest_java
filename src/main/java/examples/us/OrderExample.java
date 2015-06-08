/*
 * Copyright 2014 Klarna AB
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

package examples.us;

import com.klarna.rest.api.DefaultClient;
import com.klarna.rest.api.Client;
import com.klarna.rest.api.Order;
import com.klarna.rest.api.model.Address;
import com.klarna.rest.api.model.OrderData;
import com.klarna.rest.api.model.OrderLine;
import com.klarna.rest.api.model.Refund;
import com.klarna.rest.api.model.request.UpdateAuthorization;
import com.klarna.rest.api.model.request.UpdateCustomerDetails;
import com.klarna.rest.api.model.request.UpdateMerchantReferences;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Order management examples.
 */
public class OrderExample {

    /**
     * Fetches an order.
     */
    public static class FetchExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            String orderId = "12345";

            URI baseUrl = Client.NA_TEST_BASE_URL;

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            OrderData data = order.fetch();
        }
    }

    /**
     * Acknowledges an order.
     */
    public static class AcknowledgeExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            order.acknowledge();
        }
    }

    /**
     * Cancels an order.
     */
    public static class CancelExample {

        /**
         * Runs the code example.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            order.cancel();
        }
    }

    /**
     * Extends the order's authorization by default period according to
     * merchant contract.
     */
    public static class ExtendAuthorizationTimeExample {

        /**
         * Runs the code example.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            order.extendAuthorizationTime();
        }
    }

    /**
     * Releases the remaining authorization for an order.
     */
    public static class ReleaseRemainingAuthorizationExample {

        /**
         * Runs the code example.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            order.releaseRemainingAuthorization();
        }
    }

    /**
     * Refunds an amount of a captured order.
     */
    public static class RefundExample {

        /**
         * Runs the code example.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            final List<OrderLine> lines = new ArrayList<OrderLine>()
            {
                {
                    add(new OrderLine()
                            .setType("physical")
                            .setReference("123050")
                            .setName("Tomatoes")
                            .setQuantity(5L)
                            .setQuantityUnit("kg")
                            .setUnitPrice(600L)
                            .setTaxRate(2500)
                            .setTotalAmount(3000L)
                            .setTotalTaxAmount(600L));
                }
            };

            Refund data = new Refund()
            {
                {
                    setRefundedAmount(3000L);
                    setDescription("Refunding half the tomatoes");
                    setOrderLines(lines);
                }
            };

            order.refund(data);
        }
    }

    /**
     * Updates billing and/or shipping address for an order.
     */
    public static class UpdateCustomerDetailsExample {

        /**
         * Runs the code example.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            UpdateCustomerDetails data = new UpdateCustomerDetails()
            {
                {
                    setBillingAddress(new Address()
                            .setEmail("user@example.com")
                            .setRegion("CA")
                            .setTitle(null)
                            .setPhone("(541) 754-3010"));

                    setShippingAddress(new Address()
                            .setEmail("user@example.com")
                            .setRegion("CA")
                            .setTitle(null)
                            .setPhone("(541) 754-3010"));
                }
            };

            order.updateCustomerDetails(data);
        }
    }

    /**
     * Updates billing and/or shipping address for an order.
     */
    public static class UpdateMerchantReferencesExample {

        /**
         * Runs the code example.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            UpdateMerchantReferences data = new UpdateMerchantReferences()
            {
                {
                    setMerchantReference1("15632423");
                    setMerchantReference2("special order");
                }

            };

            order.updateMerchantReferences(data);
        }
    }

    /**
     * Updates the total order amount of an order.
     */
    public static class UpdateAuthorizationExample {

        /**
         * Runs the code example.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Order order = client.newOrder(orderId);

            final List<OrderLine> lines = new ArrayList<OrderLine>()
            {
                {
                    add(new OrderLine()
                            .setType("physical")
                            .setReference("123050")
                            .setName("Tomatoes")
                            .setQuantity(10L)
                            .setQuantityUnit("kg")
                            .setUnitPrice(600L)
                            .setTaxRate(2500)
                            .setTotalAmount(6000L)
                            .setTotalTaxAmount(1200L)
                    );
                }
            };

            UpdateAuthorization data = new UpdateAuthorization()
            {
                {
                    setOrderAmount(6000L);
                    setDescription("Removed bad bananas");
                    setOrderLines(lines);
                }
            };

            order.updateAuthorization(data);
        }
    }
}
