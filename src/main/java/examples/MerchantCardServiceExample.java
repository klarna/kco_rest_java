package examples;

import com.klarna.rest.Client;
import com.klarna.rest.api.checkout.model.CheckoutOrderLine;
import com.klarna.rest.api.merchant_card_service.VirtualCreditCardApi;
import com.klarna.rest.api.merchant_card_service.VirtualCreditCardPromisesApi;
import com.klarna.rest.api.merchant_card_service.VirtualCreditCardSettlementsApi;
import com.klarna.rest.api.merchant_card_service.model.*;
import com.klarna.rest.http_transport.HttpTransport;
import com.klarna.rest.model.ApiException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MerchantCardServiceExample {
    public static class RetrieveExistingSettlementExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /merchantcard/v3/settlements/{settlement_id}
            final String username = "K123456_abcd12345";
            final String password = "sharedSecret";
            final String settlementId = "12345";
            final String keyId = "abcde";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            VirtualCreditCardSettlementsApi vccApi = client.newVirtualCreditCardSettlementsApi();

            try {
                CardServiceSettlementResponse settlement = vccApi.retrieveExistingSettlement(settlementId, keyId);
                System.out.println(settlement);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /merchantcard/v3/settlements/{settlement_id}
        }
    }

    public static class RetriveOrdersSettlementsExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /merchantcard/v3/settlements/order/{order_id}
            final String username = "K123456_abcd12345";
            final String password = "sharedSecret";
            final String orderId = "12345";
            final String keyId = "abcde";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            VirtualCreditCardSettlementsApi vccApi = client.newVirtualCreditCardSettlementsApi();

            try {
                CardServiceSettlementResponse settlement = vccApi.retrieveSettledOrderSettlement(orderId, keyId);
                System.out.println(settlement);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /merchantcard/v3/settlements/order/{order_id}
        }
    }

    public static class CreateSettlementExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /merchantcard/v3/settlements
            final String username = "K123456_abcd12345";
            final String password = "sharedSecret";
            final String orderId = "12345";
            final String keyId = "abcde";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            VirtualCreditCardSettlementsApi vccApi = client.newVirtualCreditCardSettlementsApi();

            try {
                CardServiceSettlementRequest request = new CardServiceSettlementRequest()
                    .keyId(keyId)
                    .orderId(orderId);

                CardServiceSettlementResponse settlement = vccApi.createSettlement(request);
                System.out.println(settlement);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /merchantcard/v3/settlements
        }
    }

    public static class CreatePromiseExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /merchantcard/v3/promises
            final String username = "K123456_abcd12345";
            final String password = "sharedSecret";
            final String orderId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            VirtualCreditCardPromisesApi vccApi = client.newVirtualCreditCardPromisesApi();

            try {
                final List<CardServiceCardSpecification> cards = Arrays.asList(
                        new CardServiceCardSpecification()
                            .amount(100L)
                            .currency("EUR")
                            .fundAmount(100L)
                            .reference("your_ref_num")

                );
                CardServicePromiseRequest request = new CardServicePromiseRequest()
                    .orderId(orderId)
                    .cards(cards);

                CardServicePromiseCreatedResponse promise = vccApi.createPromise(request);
                System.out.println(promise);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /merchantcard/v3/promises
        }
    }

    public static class RetrieveExistingPromiseExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /merchantcard/v3/promises/{promise_id}
            final String username = "K123456_abcd12345";
            final String password = "sharedSecret";
            final String promiseId = "12345";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            VirtualCreditCardPromisesApi vccApi = client.newVirtualCreditCardPromisesApi();

            try {
                CardServicePromiseResponse promise = vccApi.retrievePromise(promiseId);
                System.out.println(promise);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /merchantcard/v3/promises/{promise_id}
        }
    }
}
