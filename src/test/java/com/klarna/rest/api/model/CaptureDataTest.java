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

package com.klarna.rest.api.model;

import com.klarna.rest.api.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Test cases for the CaptureData class.
 */
@RunWith(MockitoJUnitRunner.class)
public class CaptureDataTest extends TestCase {

    private CaptureData data;

    @Before
    public void setUp() {
        data = new CaptureData();
    }

    @Test
    public void testGetCapturedAmount() {
        assertNull(data.getCapturedAmount());

        long expected = 1000L;
        data.setCapturedAmount(expected);

        long actual = data.getCapturedAmount();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetDescription() {
        assertNull(data.getDescription());

        data.setDescription("Description");
        assertEquals("Description", data.getDescription());
    }

    @Test
    public void testGetShippingDelay() {
        assertNull(data.getShippingDelay());

        data.setShippingDelay(3);
        assertEquals(Integer.valueOf(3), data.getShippingDelay());
    }

    @Test
    public void testGetOrderLines() {
        assertNull(data.getOrderLines());

        List<OrderLine> lines = new ArrayList<OrderLine>();

        data.setOrderLines(lines);
        assertSame(lines, data.getOrderLines());
    }

    @Test
    public void testGetBillingAddress() {
        assertNull(data.getBillingAddress());

        Address address = new Address();

        data.setBillingAddress(address);
        assertSame(address, data.getBillingAddress());
    }

    @Test
    public void testGetShippingInfo() {
        assertNull(data.getShippingInfo());

        List<ShippingInfo> info = new ArrayList<ShippingInfo>();

        data.setShippingInfo(info);
        assertSame(info, data.getShippingInfo());
    }

    @Test
    public void testGetReadonly() {
        assertNull(data.getCaptureId());
        assertNull(data.getCapturedAt());
        assertNull(data.getShippingAddress());
        assertNull(data.getKlarnaReference());
        assertNull(data.getRefundedAmount());
    }
}
