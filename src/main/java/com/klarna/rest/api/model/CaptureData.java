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

import org.joda.time.DateTime;

import java.util.List;

/**
 * Capture data model.
 */
public class CaptureData extends Model {

    /**
     * Unique capture id.
     */
    private String captureId;

    /**
     * Customer friendly id.
     */
    private String klarnaReference;

    /**
     * Capture amount.
     */
    private Long capturedAmount;

    /**
     * Amount that has been refunded for this capture.
     */
    private Long refundedAmount;

    /**
     * The time of the capture.
     */
    private DateTime capturedAt;

    /**
     * Description of the capture shown to the customer.
     */
    private String description;

    /**
     * Optional order lines for the capture shown to the customer.
     */
    private List<OrderLine> orderLines;

    /**
     * The billing address for the capture.
     */
    private Address billingAddress;

    /**
     * The shipping address for the capture.
     */
    private Address shippingAddress;

    /**
     * Shipping information for the capture.
     */
    private List<ShippingInfo> shippingInfo;

    /**
     * Delay before the order will be shipped. Use for improving the customer
     * experience regarding payments. This field is currently not returned when
     * reading the order. Minimum: 0. Please note: to be able to submit values
     * larger than 0, this has to be enabled in your merchant account. Please
     * contact Klarna for further information.
     */
    private Integer shippingDelay;

    /**
     * Gets the capture id.
     *
     * @return Capture id
     */
    public String getCaptureId() {
        return this.captureId;
    }

    /**
     * Gets the Klarna reference.
     *
     * @return Customer friendly order id
     */
    public String getKlarnaReference() {
        return this.klarnaReference;
    }

    /**
     * Gets the captured amount.
     *
     * @return Amount
     */
    public Long getCapturedAmount() {
        return this.capturedAmount;
    }

    /**
     * Sets the captured amount.
     *
     * @param amount Amount
     * @return Same instance
     */
    public CaptureData setCapturedAmount(final Long amount) {
        this.capturedAmount = amount;

        return this;
    }

    /**
     * Gets the refunded amount.
     *
     * @return Amount
     */
    public Long getRefundedAmount() {
        return this.refundedAmount;
    }

    /**
     * Gets the capture time.
     *
     * @return Creation time
     */
    public DateTime getCapturedAt() {
        return this.capturedAt;
    }

    /**
     * Gets the description.
     *
     * @return Description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description.
     *
     * @param description Description
     * @return Same instance
     */
    public CaptureData setDescription(final String description) {
        this.description = description;

        return this;
    }

    /**
     * Gets the order lines.
     *
     * @return Order lines
     */
    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    /**
     * Sets the order lines.
     *
     * @param lines Order lines
     * @return Same instance
     */
    public CaptureData setOrderLines(final List<OrderLine> lines) {
        this.orderLines = lines;

        return this;
    }

    /**
     * Gets the billing address.
     *
     * @return Address
     */
    public Address getBillingAddress() {
        return this.billingAddress;
    }

    /**
     * Sets the billing address.
     *
     * @param address Address
     * @return Same instance
     */
    public CaptureData setBillingAddress(final Address address) {
        this.billingAddress = address;

        return this;
    }

    /**
     * Gets the shipping address.
     *
     * @return Address
     */
    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    /**
     * Gets the shipping information.
     *
     * @return Shipping info
     */
    public List<ShippingInfo> getShippingInfo() {
        return this.shippingInfo;
    }

    /**
     * Sets the shipping information.
     *
     * @param info Shipping info
     * @return Same instance
     */
    public CaptureData setShippingInfo(final List<ShippingInfo> info) {
        this.shippingInfo = info;

        return this;
    }

    /**
     * @return the shippingDelay
     */
    public Integer getShippingDelay() {
        return shippingDelay;
    }

    /**
     * @param shippingDelay the shippingDelay to set
     */
    public void setShippingDelay(Integer shippingDelay) {
        this.shippingDelay = shippingDelay;
    }
}
