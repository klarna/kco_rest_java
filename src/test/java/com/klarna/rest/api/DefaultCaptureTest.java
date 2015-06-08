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

import com.klarna.rest.api.model.CaptureData;
import com.klarna.rest.api.model.request.AddShippingInfo;
import com.klarna.rest.api.model.request.UpdateCustomerDetails;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.MediaType;
import java.net.URI;

import static javax.ws.rs.core.HttpHeaders.LOCATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.mockito.Mockito.*;

/**
 * Test cases for the Capture resource.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultCaptureTest extends ResourceTestCase {

    private static final String CAPTURE_ID = "23456";

    private DefaultCapture capture;

    @Test
    public void testCreateNa() {
        URI orderUrl = Client.NA_TEST_BASE_URL.resolve(DefaultOrder.PATH + "/12345");
        URI location = orderUrl.resolve(DefaultCapture.PATH + "/" + CAPTURE_ID);

        // Constructor
        when(root.path(DefaultCapture.PATH))
                .thenReturn(root);

        // BaseResource.post
        CaptureData data = new CaptureData();
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

        capture = new DefaultCapture(root);
        capture.create(data);

        assertEquals(location, capture.getLocation());

        // Verify that the right URL was used
        verify(root).path(DefaultCapture.PATH);

        // Verify that the header response was set
        verify(root).uri(location);

        // Verify data sent
        verify(builder).post(ClientResponse.class, data);
    }

    @Test
    public void testCreateEu() {
        URI orderUrl = Client.EU_TEST_BASE_URL.resolve(DefaultOrder.PATH + "/12345");
        URI location = orderUrl.resolve(DefaultCapture.PATH + "/" + CAPTURE_ID);

        // Constructor
        when(root.path(DefaultCapture.PATH))
                .thenReturn(root);

        // BaseResource.post
        CaptureData data = new CaptureData();
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

        capture = new DefaultCapture(root);
        capture.create(data);

        assertEquals(location, capture.getLocation());

        // Verify that the right URL was used
        verify(root).path(DefaultCapture.PATH);

        // Verify that the header response was set
        verify(root).uri(location);

        // Verify data sent
        verify(builder).post(ClientResponse.class, data);
    }

    @Test
    public void testFetch() {
        // Constructor
        when(root.path(DefaultCapture.PATH))
                .thenReturn(root);

        // BaseResource.setWebResource
        when(root.path(CAPTURE_ID))
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
        CaptureData responseData = new CaptureData();
        when(response.getStatus())
                .thenReturn(Status.OK.getStatusCode());
        when(response.getEntity(CaptureData.class))
                .thenReturn(responseData);

        capture = new DefaultCapture(root);
        capture.setWebResource(capture.getWebResource().path(CAPTURE_ID));

        CaptureData data = capture.fetch();

        assertSame(responseData, data);

        // Verify that the right URL was used
        InOrder ordered = inOrder(root);
        ordered.verify(root).path(DefaultCapture.PATH);
        ordered.verify(root).path(CAPTURE_ID);
    }

    @Test
    public void testTriggerSendout() {
        // Constructor
        when(root.path(DefaultCapture.PATH))
                .thenReturn(root);

        // BaseResource.setWebResource
        when(root.path(CAPTURE_ID))
                .thenReturn(root);

        // BaseResource.post
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.type(MediaType.APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.post(ClientResponse.class, null))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.NO_CONTENT);

        // DefaultCapture.triggerSendOut
        when(root.path("trigger-send-out"))
                .thenReturn(root);
        when(response.getStatus())
                .thenReturn(Status.NO_CONTENT.getStatusCode());

        capture = new DefaultCapture(root);
        capture.setWebResource(capture.getWebResource().path(CAPTURE_ID));

        capture.triggerSendout();

        // Verify that the right URL was used
        InOrder ordered = inOrder(root);
        ordered.verify(root).path(DefaultCapture.PATH);
        ordered.verify(root).path(CAPTURE_ID);
        ordered.verify(root).path("trigger-send-out");

        // Verify post request
        verify(builder).post(ClientResponse.class, null);
    }

    @Test
    public void testUpdateCustomerDetails() {
        // Constructor
        when(root.path(DefaultCapture.PATH))
                .thenReturn(root);

        // BaseResource.setWebResource
        when(root.path(CAPTURE_ID))
                .thenReturn(root);

        // BaseResource.patch
        UpdateCustomerDetails data = new UpdateCustomerDetails();
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.type(MediaType.APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.method("PATCH", ClientResponse.class, data))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.NO_CONTENT);

        // DefaultCapture.updateCustomerDetails
        when(root.path("customer-details"))
                .thenReturn(root);
        when(response.getStatus())
                .thenReturn(Status.NO_CONTENT.getStatusCode());

        capture = new DefaultCapture(root);
        capture.setWebResource(capture.getWebResource().path(CAPTURE_ID));

        capture.updateCustomerDetails(data);

        // Verify that the right URL was used
        InOrder ordered = inOrder(root);
        ordered.verify(root).path(DefaultCapture.PATH);
        ordered.verify(root).path(CAPTURE_ID);
        ordered.verify(root).path("customer-details");

        // Verify that the data was sent
        verify(builder).method("PATCH", ClientResponse.class, data);
    }

    @Test
    public void testAddShippingInfo() {
        // Constructor
        when(root.path(DefaultCapture.PATH))
                .thenReturn(root);

        // BaseResource.setWebResource
        when(root.path(CAPTURE_ID))
                .thenReturn(root);

        // BaseResource.post
        AddShippingInfo data = new AddShippingInfo();
        when(root.getRequestBuilder())
                .thenReturn(builder);
        when(builder.type(MediaType.APPLICATION_JSON_TYPE))
                .thenReturn(builder);
        when(builder.post(ClientResponse.class, data))
                .thenReturn(response);
        when(response.getStatusInfo())
                .thenReturn(Status.NO_CONTENT);

        // DefaultCapture.triggerSendOut
        when(root.path("shipping-info"))
                .thenReturn(root);
        when(response.getStatus())
                .thenReturn(Status.NO_CONTENT.getStatusCode());

        capture = new DefaultCapture(root);
        capture.setWebResource(capture.getWebResource().path(CAPTURE_ID));

        capture.addShippingInfo(data);

        // Verify that the right URL was used
        InOrder ordered = inOrder(root);
        ordered.verify(root).path(DefaultCapture.PATH);
        ordered.verify(root).path(CAPTURE_ID);
        ordered.verify(root).path("shipping-info");

        // Verify that the data was sent
        verify(builder).post(ClientResponse.class, data);
    }
}
