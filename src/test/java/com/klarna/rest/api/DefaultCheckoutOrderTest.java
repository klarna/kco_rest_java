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

package com.klarna.rest.api;

import com.klarna.rest.api.model.CheckoutOrderData;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.MediaType;
import java.net.URI;

import static javax.ws.rs.core.HttpHeaders.LOCATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test cases for the CheckoutOrder resource.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultCheckoutOrderTest extends ResourceTestCase {

    private DefaultCheckoutOrder checkout;

    @Test
    public void testCreateEu() {
        CheckoutOrderData data = new CheckoutOrderData();

        URI location = Client.EU_TEST_BASE_URL.resolve("/checkout/v3/orders/12345");

        // Constructor
        when(root.path(DefaultCheckoutOrder.PATH))
                .thenReturn(root);

        // BaseResource.post
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.type(MediaType.APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.post(ClientResponse.class, data))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.CREATED);

        // DefaultCheckoutOrder.create
        when(response.getStatus())
                .thenReturn(Status.CREATED.getStatusCode());
        when(response.getHeaders())
                .thenReturn(headers);
        when(headers.getFirst(LOCATION))
                .thenReturn(location.toString());
        when(root.uri(location))
                .thenReturn(root);

        // BaseResource.getLocation
        when(root.getURI())
                .thenReturn(location);

        checkout = new DefaultCheckoutOrder(root);
        checkout.create(data);

        assertEquals(location, checkout.getLocation());

        // Verify that the right URL was used
        verify(root).path(DefaultCheckoutOrder.PATH);

        // Verify that the header response was set
        verify(root).uri(location);

        // Verify data sent
        verify(builder).post(ClientResponse.class, data);
    }

    @Test
    public void testFetchEu() {
        URI location = Client.EU_TEST_BASE_URL.resolve("/checkout/v3/orders/12345");

        // Constructor
        when(root.path(DefaultCheckoutOrder.PATH))
                .thenReturn(root);

        // BaseResource.setLocation
        when(root.uri(location))
                .thenReturn(root);

        // BaseResource.get
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.accept(APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.get(ClientResponse.class))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.OK);

        // DefaultCheckoutOrder.fetch
        CheckoutOrderData responseData = new CheckoutOrderData();
        when(response.getStatus())
                .thenReturn(Status.OK.getStatusCode());
        when(response.getEntity(CheckoutOrderData.class))
                .thenReturn(responseData);

        checkout = new DefaultCheckoutOrder(root);
        checkout.setLocation(location);

        CheckoutOrderData data = checkout.fetch();

        assertSame(responseData, data);

        // Verify that the right URL was used
        verify(root).uri(location);
    }

    @Test
    public void testUpdateEu() {
        URI location = Client.EU_TEST_BASE_URL.resolve("/checkout/v3/orders/12345");

        // Constructor
        when(root.path(DefaultCheckoutOrder.PATH))
                .thenReturn(root);

        // BaseResource.setLocation
        when(root.uri(location))
                .thenReturn(root);

        // BaseResource.post
        CheckoutOrderData updateData = new CheckoutOrderData();
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.type(MediaType.APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.post(ClientResponse.class, updateData))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.OK);

        // DefaultCheckoutOrder.create
        CheckoutOrderData responseData = new CheckoutOrderData();
        when(response.getStatus())
                .thenReturn(Status.OK.getStatusCode());
        when(response.getEntity(CheckoutOrderData.class))
                .thenReturn(responseData);

        checkout = new DefaultCheckoutOrder(root);
        checkout.setLocation(location);

        assertSame(responseData, checkout.update(updateData));

        // Verify data sent
        verify(builder).post(ClientResponse.class, updateData);

        // Verify that the right URL was used
        verify(root).uri(location);
    }

    @Test
    public void testCreateNa() {
        CheckoutOrderData data = new CheckoutOrderData();

        URI location = Client.NA_TEST_BASE_URL.resolve("/checkout/v3/orders/12345");

        // Constructor
        when(root.path(DefaultCheckoutOrder.PATH))
                .thenReturn(root);

        // BaseResource.post
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.type(MediaType.APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.post(ClientResponse.class, data))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.CREATED);

        // DefaultCheckoutOrder.create
        when(response.getStatus())
                .thenReturn(Status.CREATED.getStatusCode());
        when(response.getHeaders())
                .thenReturn(headers);
        when(headers.getFirst(LOCATION))
                .thenReturn(location.toString());
        when(root.uri(location))
                .thenReturn(root);

        // BaseResource.getLocation
        when(root.getURI())
                .thenReturn(location);

        checkout = new DefaultCheckoutOrder(root);
        checkout.create(data);

        assertEquals(location, checkout.getLocation());

        // Verify that the right URL was used
        verify(root).path(DefaultCheckoutOrder.PATH);

        // Verify that the header response was set
        verify(root).uri(location);

        // Verify data sent
        verify(builder).post(ClientResponse.class, data);
    }

    @Test
    public void testFetchNa() {
        URI location = Client.NA_TEST_BASE_URL.resolve("/checkout/v3/orders/12345");

        // Constructor
        when(root.path(DefaultCheckoutOrder.PATH))
                .thenReturn(root);

        // BaseResource.setLocation
        when(root.uri(location))
                .thenReturn(root);

        // BaseResource.get
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.accept(APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.get(ClientResponse.class))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.OK);

        // DefaultCheckoutOrder.fetch
        CheckoutOrderData responseData = new CheckoutOrderData();
        when(response.getStatus())
                .thenReturn(Status.OK.getStatusCode());
        when(response.getEntity(CheckoutOrderData.class))
                .thenReturn(responseData);

        checkout = new DefaultCheckoutOrder(root);
        checkout.setLocation(location);

        CheckoutOrderData data = checkout.fetch();

        assertSame(responseData, data);

        // Verify that the right URL was used
        verify(root).uri(location);
    }

    @Test
    public void testUpdateNa() {
        URI location = Client.NA_TEST_BASE_URL.resolve("/checkout/v3/orders/12345");

        // Constructor
        when(root.path(DefaultCheckoutOrder.PATH))
                .thenReturn(root);

        // BaseResource.setLocation
        when(root.uri(location))
                .thenReturn(root);

        // BaseResource.post
        CheckoutOrderData updateData = new CheckoutOrderData();
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.type(MediaType.APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.post(ClientResponse.class, updateData))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.OK);

        // DefaultCheckoutOrder.create
        CheckoutOrderData responseData = new CheckoutOrderData();
        when(response.getStatus())
                .thenReturn(Status.OK.getStatusCode());
        when(response.getEntity(CheckoutOrderData.class))
                .thenReturn(responseData);

        checkout = new DefaultCheckoutOrder(root);
        checkout.setLocation(location);

        assertSame(responseData, checkout.update(updateData));

        // Verify data sent
        verify(builder).post(ClientResponse.class, updateData);

        // Verify that the right URL was used
        verify(root).uri(location);
    }
}
