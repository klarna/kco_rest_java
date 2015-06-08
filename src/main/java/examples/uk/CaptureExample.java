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

package examples.uk;

import com.klarna.rest.api.Capture;
import com.klarna.rest.api.DefaultClient;
import com.klarna.rest.api.Client;
import com.klarna.rest.api.model.Address;
import com.klarna.rest.api.model.CaptureData;
import com.klarna.rest.api.model.OrderLine;
import com.klarna.rest.api.model.ShippingInfo;
import com.klarna.rest.api.model.request.AddShippingInfo;
import com.klarna.rest.api.model.request.UpdateCustomerDetails;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Capture resource examples.
 */
public class CaptureExample {

    /**
     * Creates a capture.
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
            URI baseUrl = Client.EU_TEST_BASE_URL;
            String orderId = "12345";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Capture capture = client.newCapture(orderId);

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
                            .setTotalTaxAmount(1200L));
                }
            };

            final List<ShippingInfo> info = new ArrayList<ShippingInfo>()
            {
                {
                    add(new ShippingInfo()
                            .setShippingCompany("DHL")
                            .setShippingMethod("Home")
                            .setTrackingUri("http://www.dhl.com/content/g0/en/express/tracking.shtml?brand=DHL&AWB=1234567890")
                            .setTrackingNumber("1234567890")
                            .setReturnTrackingNumber("E-55-KL")
                            .setReturnShippingCompany("DHL")
                            .setReturnTrackingUri("http://www.dhl.com/content/g0/en/express/tracking.shtml?brand=DHL&AWB=98389222"));
                }
            };

            CaptureData data = new CaptureData()
            {
                {
                    setCapturedAmount(6000L);
                    setDescription("Shipped part of the order");
                    setOrderLines(lines);
                    setShippingInfo(info);
                }
            };

            capture.create(data);
        }
    }

    /**
     * Fetches a capture.
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
            URI baseUrl = Client.EU_TEST_BASE_URL;
            String orderId = "12345";
            String captureId = "34567";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Capture capture = client.newCapture(orderId, captureId);

            CaptureData data = capture.fetch();
        }
    }

    /**
     * Triggers a new send out of customer communication.
     */
    public static class TriggerSendoutExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.EU_TEST_BASE_URL;
            String orderId = "12345";
            String captureId = "34567";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Capture capture = client.newCapture(orderId, captureId);

            capture.triggerSendout();
        }
    }

    /**
     * Updates the billing address for a capture. Shipping address can not be updated.
     */
    public static class UpdateCustomerDetailsExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.EU_TEST_BASE_URL;
            String orderId = "12345";
            String captureId = "34567";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Capture capture = client.newCapture(orderId, captureId);

            UpdateCustomerDetails data = new UpdateCustomerDetails()
            {
                {
                    setBillingAddress(new Address()
                            .setEmail("user@example.com")
                            .setPhone("57-3895734"));
                }
            };

            capture.updateCustomerDetails(data);
        }
    }

    /**
     * Appends shipping info to a capture.
     */
    public static class AddShippingInfoExample {

        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            String merchantId = "0";
            String sharedSecret = "sharedSecret";
            URI baseUrl = Client.EU_TEST_BASE_URL;
            String orderId = "12345";
            String captureId = "34567";

            Client client = DefaultClient.newInstance(merchantId, sharedSecret, baseUrl);

            Capture capture = client.newCapture(orderId, captureId);

            final ShippingInfo shipping = new ShippingInfo()
            {
                {
                    setShippingCompany("DHL");
                    setShippingMethod("Home");
                    setTrackingUri("http://www.dhl.com/content/g0/en/express/tracking.shtml?brand=DHL&AWB=1234567890");
                    setTrackingNumber("1234567890");
                    setReturnTrackingNumber("E-55-KL");
                    setReturnShippingCompany("DHL");
                    setReturnTrackingUri("http://www.dhl.com/content/g0/en/express/tracking.shtml?brand=DHL&AWB=98389222");
                }
            };

            List<ShippingInfo> list = new ArrayList<ShippingInfo>();
            list.add(shipping);

            capture.addShippingInfo(new AddShippingInfo().setShippingInfo(list));
        }

    }
}
