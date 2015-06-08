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

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache.ApacheHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URI;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test cases for the DefaultClient class.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultClientTest extends TestCase {

    private static String merchantId = "0";

    private static String sharedSecret = "secret";

    @Mock private ApacheHttpClient http;

    @Mock private WebResource resource;

    private URI baseUrl = URI.create("http://localhost");

    private Client client;

    @Before
    public void setUp() {
        when(http.resource(baseUrl))
                .thenReturn(resource);

        client = new DefaultClient(http, baseUrl);
    }

    @Test
    public void testNewCheckoutOrder() {
        when(resource.path(DefaultCheckoutOrder.PATH))
                .thenReturn(resource);

        CheckoutOrder order = client.newCheckoutOrder();
        assertNotNull(order);

        verify(resource).path(DefaultCheckoutOrder.PATH);
    }

    @Test
    public void testNewCheckoutOrderExisting() {
        URI url = URI.create(baseUrl + "/checkoutUrl");

        when(resource.path(DefaultCheckoutOrder.PATH))
                .thenReturn(resource);

        when(resource.uri(url))
                .thenReturn(resource);

        CheckoutOrder order = client.newCheckoutOrder(url);
        assertNotNull(order);

        // Verify that the right URL was set
        InOrder ordered = inOrder(resource);
        ordered.verify(resource).path(DefaultCheckoutOrder.PATH);
        ordered.verify(resource).uri(url);
    }

    @Test
    public void testNewOrder() {
        when(resource.path(DefaultOrder.PATH))
                .thenReturn(resource);

        when(resource.path("12345"))
                .thenReturn(resource);

        Order order = client.newOrder("12345");
        assertNotNull(order);

        // Verify that the right URL was set
        InOrder ordered = inOrder(resource);
        ordered.verify(resource).path(DefaultOrder.PATH);
        ordered.verify(resource).path("12345");
    }

    @Test
    public void testNewCapture() {
        when(resource.path(DefaultOrder.PATH))
                .thenReturn(resource);

        when(resource.path("12345"))
                .thenReturn(resource);

        when(resource.path(DefaultCapture.PATH))
                .thenReturn(resource);

        Capture capture = client.newCapture("12345");
        assertNotNull(capture);

        // Verify that the right URL was set
        InOrder ordered = inOrder(resource);
        ordered.verify(resource).path(DefaultOrder.PATH);
        ordered.verify(resource).path("12345");
        ordered.verify(resource).path(DefaultCapture.PATH);
    }

    @Test
    public void testNewCaptureExisting() {
        when(resource.path(DefaultOrder.PATH))
                .thenReturn(resource);

        when(resource.path("12345"))
                .thenReturn(resource);

        when(resource.path(DefaultCapture.PATH))
                .thenReturn(resource);

        when(resource.path("23456"))
                .thenReturn(resource);

        Capture capture = client.newCapture("12345", "23456");
        assertNotNull(capture);

        // Verify that the right URL was set
        InOrder ordered = inOrder(resource);
        ordered.verify(resource).path(DefaultOrder.PATH);
        ordered.verify(resource).path("12345");
        ordered.verify(resource).path(DefaultCapture.PATH);
        ordered.verify(resource).path("23456");
    }

    @Test
    public void testSetConnectTimeout() {
        Integer timeout = new Integer(1000);

        client.setConnectTimeout(timeout);

        verify(http).setConnectTimeout(timeout);

    }

    @Test
    public void testSetReadTimeout() {
        Integer timeout = new Integer(1000);

        client.setReadTimeout(timeout);

        verify(http).setReadTimeout(timeout);
    }

    @Test
    public void testNewInstance() {
        assertNotNull(client);
    }

    @Test
    public void testNewInstanceUserAgent() {
        assertNotNull(DefaultClient.newInstance(merchantId, sharedSecret, baseUrl, new KlarnaUserAgent()));
    }

    @Test
    public void testEuBaseUrl() {
        assertNotNull(Client.EU_BASE_URL);
        assertNotNull(Client.EU_TEST_BASE_URL);
    }

    @Test
    public void testNaBaseUrl() {
        assertNotNull(Client.NA_BASE_URL);
        assertNotNull(Client.NA_TEST_BASE_URL);
    }
}
