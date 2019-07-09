package examples;

import com.klarna.rest.Client;
import com.klarna.rest.api.customer_token.TokensApi;
import com.klarna.rest.api.customer_token.model.*;
import com.klarna.rest.http_transport.HttpTransport;
import com.klarna.rest.model.ApiException;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomerTokenExample {
    public static class ReadTokenDetailsExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: GET /customer-token/v1/tokens/{customerToken}
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String customerToken = "customerToken";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            TokensApi tokensApi = client.newTokensApi(customerToken);

            try {
                TokenCustomerTokenV1 token = tokensApi.fetchDetails();
                System.out.println(token);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: GET /customer-token/v1/tokens/{customerToken}
        }
    }

    public static class CreateOrderExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: POST /customer-token/v1/tokens/{customerToken}/order
            String username = "K123456_abcd12345";
            String password = "sharedSecret";
            String customerToken = "customerToken";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            TokensApi tokensApi = client.newTokensApi(customerToken);

            try {
                final TokenAddress address = new TokenAddress()
                    .givenName("John")
                    .familyName("Doe")
                    .email("johndoe@example.com")
                    .title("Mr")
                    .streetAddress("13 New Burlington St")
                    .streetAddress2("Apt 214")
                    .postalCode("W13 3BG")
                    .city("London")
                    .phone("01895808221")
                    .country("GB");

                final List<TokenOrderLine> lines = Arrays.asList(
                    new TokenOrderLine()
                        .type("physical")
                        .reference("123050")
                        .name("Tomatoes")
                        .quantity(10L)
                        .quantityUnit("kg")
                        .unitPrice(600L)
                        .taxRate(2500L)
                        .totalAmount(6000L)
                        .totalTaxAmount(1200L),
                    new TokenOrderLine()
                        .type("physical")
                        .reference("543670")
                        .name("Bananas")
                        .quantity(1L)
                        .quantityUnit("bag")
                        .unitPrice(5000L)
                        .taxRate(2500L)
                        .totalAmount(4000L)
                        .totalDiscountAmount(1000L)
                        .totalTaxAmount(800L)
                );

                TokenCustomerTokenOrder request = new TokenCustomerTokenOrder()
                    .shippingAddress(address)
                    .purchaseCurrency("gbp")
                    .orderAmount(10000L)
                    .orderTaxAmount(2000L)
                    .orderLines(lines);

                TokenOrder order = tokensApi.createOrder(request);
                System.out.println(order);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: POST /customer-token/v1/tokens/{customerToken}/order
        }
    }

    public static class UpdateStatusExample {
        /**
         * Runs the example code.
         *
         * @param args Command line arguments
         */
        public static void main(final String[] args) {
            // X-Example: PATCH /customer-token/v1/tokens/{customerToken}/status
            String username = "PK01038_a813060918c5";
            String password = "R1QkI2yB95lPq4Es";
            String customerToken = "customerToken";

            Client client = new Client(username, password, HttpTransport.EU_TEST_BASE_URL);
            TokensApi tokensApi = client.newTokensApi(customerToken);

            try {
                TokenCustomerTokenStatusUpdateRequest status = new TokenCustomerTokenStatusUpdateRequest()
                    .status("CANCELLED");
                tokensApi.updateStatus(status);
                System.out.println("Token patch request has been accepted and is being processed");

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
            // /X-Example: PATCH /customer-token/v1/tokens/{customerToken}/status
        }
    }
}
