<!-- markdownlint-disable MD024 MD036 -->

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Fixed

### Changed

### Added

## [4.0.3] - 2020-04-02

### Added
- **Checkout API:** Adds setters for `options` field in `CheckoutGui` as it is no longer read-only.

## [4.0.2] - 2020-02-14

### Added

- HTTP Transport: Oceania Base URLs (playground and production)


## [4.0.1] - 2020-01-22

### Fixed

- Fix response code processing issue where NullPointerException is thrown when status code does not appear in 
https://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Response.Status.html. Now, all status codes are handled and
ApiException will be thrown as expected. Fixes issue #39.

## [4.0.0] - 2020-01-21 (Major release)

> **⚠️ No backward compatibility**

### Added

- Fields in **Order Mangement**, **Checkout**, **Customer Token**, **Instant Shopping**, 
**Settlements** models
- New models in **Instant Shopping**

### Changed

**Instant Shopping API**
- Removed `type`, `vat_id`, `organization_registration_id` and `organization_entity_type` from `InstantShoppingCustomerV1`
- `InstantShoppingOrderMerchantUrlsV1` replaces `InstantShoppingMerchantUrlsV1` and `InstantShoppingButtonSetupOptionsV1MerchantUrls`
- `shipping_method` in `InstantShoppingShippingOptionV1` becomes `String`

**Checkout API**
- `shipping_address` in `CheckoutOrder` is now read-only

## [3.2.2] - 2020-01-22 (Backport Patch Release)

### Fixed

- Backport from [4.0.1]: Fix response code processing issue where NullPointerException is thrown when status code does not appear in 
https://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Response.Status.html. Now, all status codes are handled and
ApiException will be thrown as expected. Fixes issue #39.

## [3.2.1] - 2019-12-10

### Fixed

- Fix InvalidDefinitionException Jackson exception when working with conversion from `String` to `DateTimeOffset` type.
  [#12](https://github.com/klarna/kco_rest_java/issues/12)


## [3.2.0] - 2019-10-05

### Fixed

- Fix deserialization issue with "expires_at" of PaymentsSession object [#34](https://github.com/klarna/kco_rest_java/issues/34)  
  Change type of `expired_at` field to `OffsetDateTime` instead of `PaymentsInstant`. **Backward incompatible**

### Changed

- Change the jackson version to 2.9.9.1 to reduce vulnerabilities
- PaymentsErrorV2: Rename `authorized_payment_method_v1` to `authorized_payment_method` since a bug in a documentation.  
  `authorized_payment_method_v1` property never existed before **Backward incompatible**
- Add processing of single error message
- Change Jackson DefaultMapper DateTime serialization. Change default time serialization from a timestamp to the ISO 8601

### Added

- PaymentsCreateOrderRequest: add `authorization_token` property
- PaymentsSession: add `authorization_token` property
- PaymentsCustomerTokenCreationResponse: add `billing_address`, `customer` and `payment_method_reference` properties
- Add ability to get the API ObjectMapper


## [3.1.1] - 2019-05-31

### Security

- Fix: upgrade `com.fasterxml.jackson.core:jackson-databind` to version **2.9.9**
  
  A Polymorphic Typing issue was discovered in FasterXML jackson-databind 2.x before 2.9.9.
  When Default Typing is enabled (either globally or for a specific property) for an externally exposed JSON endpoint,
  the service has the mysql-connector-java jar (8.0.14 or earlier) in the classpath, and an attacker can host a crafted
  MySQL server reachable by the victim, an attacker can send a crafted JSON message that allows them to read arbitrary
  local files on the server. This occurs because of missing com.mysql.cj.jdbc.admin.MiniAdmin validation.

  [CVE-2019-12086](https://nvd.nist.gov/vuln/detail/CVE-2019-12086)


## [3.1.0] - 2019-04-30

### Changed

- Fix version formatting in Markdown to better conform with Keep a Changelog
- Mark `VirtualCreditCardApi` as deprecated. Move `VirtualCreditCardApi` to `VirtualCreditCardSettlementsApi` [**DEPRECATED**]
- Checkout API: Actualize models
- Customer Token API: Actualize models
- HPP API: Actualize models and update examples
- CardService API: Actualize models
- Order Management API: Actualize models
- Payments API: Actualize models
- Settlements API: Actualize models.

### Added

- Add support of `BODY` payload when using `DELETE` method
- Repo now has an Apache 2.0 LICENSE file on its root
- TokenErrorV2 model: new fields `authorized_payment_method_v1`, `fraud_status`, `reason`
- HPPMerchantUrlsV1 model: new fields `back`, `error`, `status_update`
- HPPResponseEntity model: [**breaking changes**]
    - Change `StatusCodeEnum` model. Add details to the enum names
    -  _100 -> _100_CONTINUE
    -  _101 -> _101_SWITCHING_PROTOCOLS
    -  _102 -> _102_PROCESSING
    -  ...
    -  _200 -> _200_OK
    -  _201 -> _201_CREATED
    -  _204 -> _204_NO_CONTENT
- CardService API new models:
    - CardServiceCardSpecification
    - CardServicePromiseCreatedResponse
    - CardServicePromiseRequest
    - CardServicePromiseResponse
- Payments API PaymentsErrorV2 model: add fields `authorized_payment_method_v1` (PaymentsAuthorizedPaymentMethod model), `fraud_status`, `reason`
- Add support of Virtual Credit Card Promises (with examples)
- Instant Shopping API:
    - Add support of declining order
    - Update the model to the latest version
    - Add Button Keys examples
    - Cover with Unit tests


## [3.0.6] - 2019-01-26

### Changed

**Checkout API**

- CheckoutOrder model: Add `tags` property;
- CheckoutOrderLine model: Add `shipping_attributes` property;
- CheckoutShippingOption model: Add `delivery_details` propery.

**Customer Token API**

- TokenCustomerTokenV1 model: Add `card` and `direct_debit` properties;
- TokenOrder model: Add `authorized_payment_method` property.

**Hosted Payment page API**

- HPPOptionsV1 model: Add `payment_fallback` and `payment_method_categories` properties;
- HPPSessionResponseV1 model: Add `session_id` property;
- HPPSessionResponseV1.StatusEnum: Add `BACK`, `DISABLED` and `ERROR` statuses to enum.

**Order Management API**

- OrderManagementInitialPaymentMethodDto model: Add `number_of_installments` property;

**Payments API**

- PaymentsOrder model: Add `authorized_payment_method` property;

### Added

**Checkout API**

- New models:
  - CheckoutDeliveryDetailsV1;
  - CheckoutDimensions;
  - CheckoutPickupLocationV1;
  - CheckoutProductV1;
  - CheckoutRecurringOrderRequestV1;
  - CheckoutShippingAttributes;
  - CheckoutTimeslotV1.

**Customer Token API**

- New models:
  - TokenAuthorizedPaymentMethod;
  - TokenCardInformation;
  - TokenCustomerTokenStatusUpdateRequest;
  - TokenDirectDebitInformation;
- Add support for disabling an HPP session;
- Add ability to use Klarna-Idempotency-Key when creating order;

**Payments API**

- New model:
  - PaymentsAuthorizedPaymentMethod;

## [3.0.5] - 2019-01-10

### Security

- Fix: upgrade `com.fasterxml.jackson.core:jackson-databind` to version **2.9.8**  
  FasterXML jackson-databind 2.x before 2.9.8 might allow attackers to have unspecified
  impact by leveraging failure to block the jboss-common-core class from polymorphic
  deserialization:  
  [CVE-2018-19360](https://nvd.nist.gov/vuln/detail/CVE-2018-19360), [CVE-2018-19361](https://nvd.nist.gov/vuln/detail/CVE-2018-19361), [CVE-2018-19362](https://nvd.nist.gov/vuln/detail/CVE-2018-19362)

### Changed

- [keepachangelog](https://keepachangelog.com/en/1.0.0/) and [markdownlint](https://github.com/markdownlint/markdownlint) alignment modifications to `CHANGELOG`

## [3.0.4] - 2018-12-11

### Added

- Payments API: Add ability to set Shipping Address for Sessions.

## [3.0.3] - 2018-12-06

### Added

- Checkout API: Add support of phone_mandatory field for Checkout options.

## [3.0.2] - 2018-11-12

### Changed

- Update com.fasterxml.jackson.* to 2.9.7 version.

## [3.0.1] - 2018-11-12

### Security

- Fix: upgrade com.fasterxml.jackson.core:jackson-databind to version **2.8.11.1**  
  FasterXML jackson-databind through 2.8.10 and 2.9.x through 2.9.3 allows
  unauthenticated remote code execution because of an incomplete fix for the [CVE-2017-7525](https://nvd.nist.gov/vuln/detail/CVE-2017-7525) deserialization flaw.

## [3.0.0] - 2018-11-12 (Major release)

> **⚠️ No backward compatibility**

### Added

- Support of
  - Merchant Card Service API
  - Customer Token API;
  - Settlements API;
  - Payments API;
  - Hosted Payment Page API;
- Add 'Debug Mode' to be able to debug requests and responses;
- Put SDK References documentation into a GH Pages: [https://klarna.github.io/kco_rest_java/](https://klarna.github.io/kco_rest_java/)
- More Tests and Examples for all Klarna Services.

### Changed

- Actualize all the API models;

## [2.2.2] - 2018-09-06

### Added

- Order Mangement API: Add support of Refunds;
- Put SDK References documentation to GH Pages: [https://klarna.github.io/kco_rest_java/](https://klarna.github.io/kco_rest_java/)

### Changed

- Update Checkout API models according to the latest Klarna API changes;
- Update Order Management API models according to the latest Klarna API changes;

### Fixed

- [Shipping Delay missing from CaptureData #5](https://github.com/klarna/kco_rest_java/issues/5);
- Release is fully backward-compatible;

## [2.2.0] - 2016-02-15

### Added

- **NEW META-112** Updating MerchantUrls model for shipping_option_update, address_update & notification - *Christer.G*

## [2.1.0] - 2015-12-07

### Added

- **NEW META-13** Allow for 201 response on refund - *Joakim.L*

## [2.0.1] - 2015-10-15

### Fixed

- **FIX MINT-2322** Fix issues with connection still allocated exceptions - *Joakim.L*

## [2.0.0] - 2015-06-30

### Added

- **NEW MINT-2202** Use order id instead of URL for checkout orders - *Christer.G*
- **NEW MINT-2216** Add base URLs for North America - *Joakim.L*
- **NEW MINT-2231** Add support for gui options - *Joakim.L*
- **NEW MINT-2244** Update Apache HttpClient - *Joakim.L*
- **NEW MINT-2233** Add support for Extra Merchant Data - *Christer.G*
- **NEW MINT-2247** Add support for external payment methods and checkouts - *Christer.G*

## [1.0.1] - 2015-03-30

### Fixed

- **FIX MINT-2105** Add custom Javadoc template - *Andrew.M*

## 1.0.0 - 2015-01-16

### Added

- **NEW MINT-1842** Support checkout v3 and ordermanagement v1 APIs - *Joakim.L*

[Unreleased]: https://github.com/klarna/kco_rest_java/compare/v4.0.3...HEAD
[4.0.3]: https://github.com/klarna/kco_rest_java/compare/v4.0.2...v4.0.3
[4.0.2]: https://github.com/klarna/kco_rest_java/compare/v4.0.1...v4.0.2
[4.0.1]: https://github.com/klarna/kco_rest_java/compare/v4.0.0...v4.0.1
[4.0.0]: https://github.com/klarna/kco_rest_java/compare/v3.2.2...v4.0.0
[3.2.2]: https://github.com/klarna/kco_rest_java/compare/v3.2.1...v3.2.2
[3.2.1]: https://github.com/klarna/kco_rest_java/compare/v3.2.0...v3.2.1
[3.2.0]: https://github.com/klarna/kco_rest_java/compare/v3.1.1...v3.2.0
[3.1.1]: https://github.com/klarna/kco_rest_java/compare/v3.1.0...v3.1.1
[3.1.0]: https://github.com/klarna/kco_rest_java/compare/v3.0.6...v3.1.0
[3.0.6]: https://github.com/klarna/kco_rest_java/compare/v3.0.5...v3.0.6
[3.0.5]: https://github.com/klarna/kco_rest_java/compare/v3.0.4...v3.0.5
[3.0.4]: https://github.com/klarna/kco_rest_java/compare/v3.0.3...v3.0.4
[3.0.3]: https://github.com/klarna/kco_rest_java/compare/v3.0.2...v3.0.3
[3.0.2]: https://github.com/klarna/kco_rest_java/compare/v3.0.1...v3.0.2
[3.0.1]: https://github.com/klarna/kco_rest_java/compare/v3.0.0...v3.0.1
[3.0.0]: https://github.com/klarna/kco_rest_java/compare/v2.2.2...v3.0.0
[2.2.2]: https://github.com/klarna/kco_rest_java/compare/v2.2.0...v2.2.2
[2.2.0]: https://github.com/klarna/kco_rest_java/compare/v2.1.0...v2.2.0
[2.1.0]: https://github.com/klarna/kco_rest_java/compare/v2.0.1...v2.1.0
[2.0.1]: https://github.com/klarna/kco_rest_java/compare/v2.0.0...v2.1.1
[2.0.0]: https://github.com/klarna/kco_rest_java/compare/v1.0.1...v2.0.0
[1.0.1]: https://github.com/klarna/kco_rest_java/compare/v1.0.0...v1.0.1
