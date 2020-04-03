/*
 * Copyright 2018 Klarna AB
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

package com.klarna.rest.http_transport;

import com.klarna.rest.model.ApiException;
import com.klarna.rest.model.ApiResponse;
import com.klarna.rest.model.ProtocolException;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import static java.lang.System.getProperty;


/**
 * General interface for an HTTP transport.
 *
 * @see HttpUrlConnectionTransport Default HTTP transport based on HttpURLConnection.
 */
public interface HttpTransport {
    /**
     * API library client version.
     */
    String VERSION = "4.0.3";

    /**
     * API library default user agent.
     */
    String USER_AGENT = String.format("Language/Java_%s (Vendor/%s; VM/%s) Library/%s OS/%s",
            getProperty("java.version"),
            getProperty("java.vendor"),
            getProperty("java.vm.name"),
            "Klarna.kco_rest_java_" + VERSION,
            getProperty("os.name") + "_" + getProperty("os.version")
    );

    /**
     * API base URL for Europe.
     */
    URI EU_BASE_URL = URI.create("https://api.klarna.com");

    /**
     * Testing API base URL for Europe.
     */
    URI EU_TEST_BASE_URL = URI.create("https://api.playground.klarna.com");

    /**
     * API base URL for North America.
     */
    URI NA_BASE_URL = URI.create("https://api-na.klarna.com");

    /**
     * Testing API base URL for North America.
     */
    URI NA_TEST_BASE_URL = URI.create("https://api-na.playground.klarna.com");

    /**
     * API base URL for Oceania.
     */
    URI OC_BASE_URL = URI.create("https://api-oc.klarna.com");

    /**
     * Testing API base URL for Oceania.
     */
    URI OC_TEST_BASE_URL = URI.create("https://api-oc.playground.klarna.com");

    /**
     * Sends HTTP GET request to specified path.
     *
     * @param path URL path.
     * @param headers HTTP request headers
     * @return Processed response
     * @throws ApiException if API server returned non-20x HTTP CODE, Content-Type mismatched or response contains
     *                      a <a href="https://developers.klarna.com/api/#errors">Error</a>
     * @throws IOException if an error occurred when connecting to the server or when parsing a response.
     */
    ApiResponse get(final String path, Map<String, String> headers) throws ApiException, IOException;

    /**
     * Sends HTTP POST request to specified path.
     *
     * @param path URL path.
     * @param data Data to be sent to API server in a payload.
     * @param headers HTTP request headers
     * @return Processed response
     * @throws ApiException if API server returned non-20x HTTP CODE and response contains
     *                      a <a href="https://developers.klarna.com/api/#errors">Error</a>
     * @throws IOException if an error occurred when connecting to the server or when parsing a response.
     */
    ApiResponse post(final String path, final byte[] data, Map<String, String> headers) throws ApiException, IOException;

    /**
     * Sends HTTP PUT request to specified path.
     *
     * @param path URL path.
     * @param data Data to be sent to API server in a payload.
     * @param headers HTTP request headers
     * @return Processed response
     * @throws ApiException if API server returned non-20x HTTP CODE and response contains
     *                      a <a href="https://developers.klarna.com/api/#errors">Error</a>
     * @throws IOException if an error occurred when connecting to the server or when parsing a response.
     */
    ApiResponse put(final String path, final byte[] data, Map<String, String> headers) throws ApiException, IOException;

    /**
     * Sends HTTP PATCH request to specified path.
     *
     * @param path URL path.
     * @param data Data to be sent to API server in a payload.
     * @param headers HTTP request headers
     * @return Processed response
     * @throws ApiException if API server returned non-20x HTTP CODE and response contains
     *                      a <a href="https://developers.klarna.com/api/#errors">Error</a>
     * @throws IOException if an error occurred when connecting to the server or when parsing a response.
     */
    ApiResponse patch(final String path, final byte[] data, Map<String, String> headers) throws ApiException, IOException;

    /**
     * Sends HTTP DELETE request to specified path.
     *
     *  @deprecated As of 3.1.0, adding `data` params to delete in order to cover the InstantShoppingApi
     *              Use {@link #delete(String, byte[], Map)} instead.
     *
     * @param path URL path.
     * @param headers HTTP request headers
     * @return Processed response
     * @throws ApiException if API server returned non-20x HTTP CODE and response contains
     *                      a <a href="https://developers.klarna.com/api/#errors">Error</a>
     * @throws IOException if an error occurred when connecting to the server or when parsing a response.
     */
    @Deprecated
    ApiResponse delete(final String path, Map<String, String> headers) throws ApiException, IOException;

    /**
     * Sends HTTP DELETE request to specified path.
     *
     * @param path URL path.
     * @param data Data to be sent to API server in a payload.
     * @param headers HTTP request headers
     * @return Processed response
     * @throws ApiException if API server returned non-20x HTTP CODE and response contains
     *                      a <a href="https://developers.klarna.com/api/#errors">Error</a>
     * @throws IOException if an error occurred when connecting to the server or when parsing a response.
     */
    ApiResponse delete(final String path, final byte[] data, Map<String, String> headers) throws ApiException, IOException;
}
