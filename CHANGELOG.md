<!-- markdownlint-disable MD024 -->

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Changed

- Fix version formatting in Markdown to better conform with Keep a Changelog

### Added

- Code of Conduct and separate Contribution Guidelines file
- Repo now has an Apache 2.0 LICENSE file on its root

## [3.0.6] - 2018-01-26

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

## [3.0.5] - 2018-01-10

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

## [1.0.0] - 2015-01-16

### Added

- **NEW MINT-1842** Support checkout v3 and ordermanagement v1 APIs - *Joakim.L*
