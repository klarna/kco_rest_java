# [DEPRECATED] Official Klarna REST Java SDK

[![Maven Version][maven-image]](https://search.maven.org/search?q=a:kco-rest)
[![Build Status][travis-image]](https://travis-ci.org/klarna/kco_rest_java)
[![Coverage Status][coveralls-image]](https://coveralls.io/r/klarna/kco_rest_java)

## SDK Deprecation Warning and Sunsetting

Dear community, the SDK you are currently looking at is now deprecated. These are details related to sunsetting:
* We intend to archive this repo on June 1 2020 (01/06/20)
* Until November 1 2020 (01/11/20) high severity security issues found within the latest published version will be fixed. All support will cease after this date.
* No new builds will follow effective April 20 (20/04/2020) apart from the fixes mentioned above.

### Workarounds

We are making Klarna REST API definition files available in [Swagger / OAS v2](https://swagger.io/specification/v2/) format, under the [Klarna API Reference](https://developers.klarna.com/api/) section on the [Klarna Developer Portal](https://developers.klarna.com/). These will be regularly updated as the APIs evolve.
You can use tools like https://swagger.io/tools/swagger-codegen/ to generate your own SDKs, client libraries, etc.


## Shop now. Pay later.

Shop at your favorite stores today and experience the freedom to pay later with Klarna.

> ⚠️ 22/01/20 Release of v4.0.0, see [CHANGELOG](CHANGELOG.md) for an overview of what changed.

>Due to security vulnerability in com.fasterxml.jackson.core:jackson-databind we highly recommend you upgrade your 
>Java SDK to version **>=3.1.1**.
>
>More information about the issue:
>- https://nvd.nist.gov/vuln/detail/CVE-2017-17485
>- https://nvd.nist.gov/vuln/detail/CVE-2019-12086
>- https://nvd.nist.gov/vuln/detail/CVE-2018-7489
>- https://nvd.nist.gov/vuln/detail/CVE-2017-7525


## Getting started

SDK covers all of Klarna API: https://developers.klarna.com/api/

### Prerequisites

* Java 1.7 version or higher
* [API credentials](#api-credentials)

### API Credentials

Before getting a production account you can get a playground one.
Register below to be able to test your SDK integration before go live, by selecting your region:

[https://developers.klarna.com/documentation/testing-environment/#developer-signup-test-credentials](https://developers.klarna.com/documentation/testing-environment/#developer-signup-test-credentials)


## Installing the Java SDK

The Java SDK requires **Java 1.7** version or higher.

### Maven

To install the Java SDK from the Central Maven repository using Maven, add the following lines to `pom.xml`:

```xml
<dependency>
    <groupId>com.klarna</groupId>
    <artifactId>kco-rest</artifactId>
    <version>[4.0,)</version>
</dependency>
```

### Gradle

To install the Java SDK from the Central Maven repository using Gradle, add the following lines to `build.gradle`:

```groovy
dependencies {
    compile group: 'com.klarna', name: 'kco-rest', version:'4.0+'
}
```

## Documentation

The various documentation is available:

* [Developers Portal](https://developers.klarna.com);
* [Klarna API documentation](https://developers.klarna.com/api);
* [SDK references](https://klarna.github.io/kco_rest_java/);

## Usage

Example files can be found in the
[examples](src/main/java/examples/) package.

The basic workflow is the following:
1) Create an SDK Client
2) Build the new API instance via created Client

    ```java
    package com.mycompany.app;

    import com.klarna.rest.Client;
    import com.klarna.rest.api.checkout.CheckoutOrdersApi;
    import com.klarna.rest.api.checkout.model.CheckoutOrder;
    import com.klarna.rest.http_transport.HttpTransport;
    import com.klarna.rest.model.ApiException;

    import java.io.IOException;

    /**
     * Klarna Checkout Example
     */
    public class App
    {
        public static void main( String[] args )
        {
            Client client = new Client("username", "password", HttpTransport.EU_BASE_URL);
            CheckoutOrdersApi checkoutOrdersApi = client.newCheckoutOrdersApi();

            try {
                CheckoutOrder order = checkoutOrdersApi.fetch("checkoutOrderID-123");

                // Order has been successfully fetched, we can get some info, e.g. HTML Snippet
                // This snippet can be embedded into your website/templates/etc
                String htmlSnippet = order.getHtmlSnippet();
                System.out.println(htmlSnippet);

                // Or print a whole order data
                System.out.println(order);

            } catch (IOException e) {
                System.out.println("Connection problem: " + e.getMessage());
            } catch (ApiException e) {
                System.out.println("API issue: " + e.getMessage());
            }
        }
    }
    ```

## Logging and Debugging

The Java SDK uses the *slf4j* library as an abstraction for various logging frameworks. We have not provided
any back-end implementation.
Choose an implementation that applies to your project.

For more information, see the [slf4j](https://www.slf4j.org/) documentation.

You can debug and check all the requests and responses made via the SDK. In order to enable debug mode
you need to change the logging level of your Logger to "debug".

For example, if you use `log4j2` logger, put this line to your `log4j2.properties` file:

```properties
rootLogger.level = debug
```

The output will look like:

```shell
[18-Oct-25 14:16:09:652] [DEBUG] [HttpUrlConnectionTransport:312] - DEBUG MODE: Request
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
GET: https://api.playground.klarna.com/customer-token/v1/tokens/TOKEN
Headers: Headers: {User-Agent=[Language/Java_1.8.0_161 (Vendor/Oracle Corporation; VM/Java HotSpot(TM) 64-Bit Server VM) Library/Klarna.kco_rest_java_3.0.0 OS/Mac OS X_10.13.4], Content-Type=[application/json]}
Payout:

DEBUG MODE: Response
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Headers: {null=[HTTP/1.1 200 OK], Server=[openresty], Connection=[keep-alive], Vary=[Accept-Encoding], Content-Length=[166], Date=[Thu, 25 Oct 2018 12:16:09 GMT], Content-Type=[application\/json]}
Payout: {"status" : "ACTIVE","payment_method_type" : "INVOICE"}
```

## How to contribute

At Klarna, we strive toward achieving the highest possible quality for our
products. Therefore, we require you to follow these guidelines if you wish
to contribute.

To contribute, the following criteria needs to be fulfilled:

* Description regarding what has been changed and why
* Pull requests should implement a boxed change
* All code and documentation must follow the style specified by
  the included configuration (src/checkstyle.xml)
* New features and bug fixes must have accompanying unit tests:
  * Positive tests
  * Negative tests
  * Boundary tests (if possible)
  * No less than 90% decision coverage
* All unit tests should pass

## Questions and feedback

If you have any questions concerning this product or the implementation,
please create an issue: https://github.com/klarna/kco_rest_java/issues/new/choose

Use an official Klarna Contact us form (https://klarna.com) if you have a question about the integration.

## License

The Klarna Checkout REST Java SDK is released under
[Apache License, Version 2.0](http://www.apache.org/LICENSE-2.0)

[maven-image]: https://img.shields.io/maven-central/v/com.klarna/kco-rest.svg?style=flat
[travis-image]: https://img.shields.io/travis/klarna/kco_rest_java/v3.x.svg?style=flat
[coveralls-image]: https://img.shields.io/coveralls/klarna/kco_rest_java/v3.x.svg?style=flat
