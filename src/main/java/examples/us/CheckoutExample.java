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

import com.klarna.rest.api.CheckoutOrder;
import com.klarna.rest.api.DefaultClient;
import com.klarna.rest.api.Client;
import com.klarna.rest.api.model.CheckoutOrderData;
import com.klarna.rest.api.model.MerchantUrls;
import com.klarna.rest.api.model.OrderLine;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Checkout resource examples.
 */
public class CheckoutExample {

    /**
     * Creates a checkout order.
     */
    public static class CreateExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            CheckoutOrder checkout = client.newCheckoutOrder();

            final List<OrderLine> lines = new ArrayList<OrderLine>() {
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
                            .setTotalTaxAmount(1200L));
                    add(new OrderLine()
                            .setType("physical")
                            .setReference("543670")
                            .setName("Bananas")
                            .setQuantity(1L)
                            .setQuantityUnit("bag")
                            .setUnitPrice(5000L)
                            .setTaxRate(2500)
                            .setTotalAmount(4000L)
                            .setTotalDiscountAmount(1000L)
                            .setTotalTaxAmount(800L));
                }
            };

            final MerchantUrls urls = new MerchantUrls()
            {
                {
                    setTerms("http://www.merchant.com/toc");
                    setCheckout("http://www.merchant.com/checkout?klarna_order_url={checkout.order.url}");
                    setConfirmation("http://www.merchant.com/thank-you?klarna_order_url={checkout.order.url}");
                    setPush("http://www.merchant.com/create_order?klarna_order_id={checkout.order.id}");
                }
            };

            CheckoutOrderData data = new CheckoutOrderData()
            {
                {
                    setPurchaseCountry("gb");
                    setPurchaseCurrency("gbp");
                    setLocale("en-gb");
                    setOrderAmount(10000L);
                    setOrderTaxAmount(2000L);
                    setOrderLines(lines);
                    setMerchantUrls(urls);
                }
            };


            checkout.create(data);

            // Store checkout order url
            URI checkoutUrl = checkout.getLocation();
        }
    }

    /**
     * Fetches a checkout order.
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
            URI baseUrl = Client.NA_TEST_BASE_URL;
            URI checkoutUrl = URI.create("https://playground.api.klarna.com/checkout/v3/orders/12345");

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            CheckoutOrder checkout = client.newCheckoutOrder(checkoutUrl);

            CheckoutOrderData data = checkout.fetch();
        }
    }

    /**
     * Updates a checkout order.
     */
    public static class UpdateExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.NA_TEST_BASE_URL;
            URI checkoutUrl = URI.create("https://playground.api.klarna.com/checkout/v3/orders/12345");

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            CheckoutOrder checkout = client.newCheckoutOrder(checkoutUrl);

            final List<OrderLine> lines = new ArrayList<OrderLine>() {
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
                            .setTotalTaxAmount(1200L));
                    add(new OrderLine()
                            .setType("physical")
                            .setReference("543670")
                            .setName("Bananas")
                            .setQuantity(1L)
                            .setQuantityUnit("bag")
                            .setUnitPrice(5000L)
                            .setTaxRate(2500)
                            .setTotalAmount(4000L)
                            .setTotalDiscountAmount(1000L)
                            .setTotalTaxAmount(800L));
                    add(new OrderLine()
                            .setType("shipping_fee")
                            .setName("Express delivery")
                            .setQuantity(1L)
                            .setUnitPrice(1000L)
                            .setTaxRate(2500)
                            .setTotalAmount(1000L)
                            .setTotalTaxAmount(200L));
                }
            };

            CheckoutOrderData data = new CheckoutOrderData()
            {
                {
                    setOrderLines(lines);
                    setOrderAmount(11000L);
                    setOrderTaxAmount(2200L);
                }
            };


            data = checkout.update(data);
        }
    }
}
