## Klarna Checkout REST Java SDK
[![Maven Version][maven-image]](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22kco-rest%22)
[![Build Status][travis-image]](https://travis-ci.org/klarna/kco_rest_java)
[![Coverage Status][coveralls-image]](https://coveralls.io/r/klarna/kco_rest_java)

> The **v2.x** branch marked as **deprecated**. Please use [v3.0](https://github.com/klarna/kco_rest_java/tree/v3.0) 
    branch instead

Klarna Checkout is a revolutionary new payment solution that is changing the way
people shop online. First, consumers verify their purchase with a minimal
amount of information through intelligent identification, securing your order
immediately, and then complete their payment afterwards - separating buying
from paying and dramatically increasing conversion. Klarna Checkout also allows
merchants to offer all payment methods through one supplier, minimizing
administration, costs and integration time.


## About Klarna
Klarna was founded in Stockholm in 2005 with the idea of providing a
zero-friction online payment solution that would allow consumers and merchants
to interact with each other as safely and simply as possible. We do this by
letting the consumer receive the goods first and pay afterwards, while we assume
the credit and fraud risks for the merchants. Today, Klarna is one of Europe's
fastest growing companies. In just 8 years, we've grown to 800 employees
operating in 7 European countries with over 8 million consumers. But we are not
satisfied with that. Our goal is to become market leaders within invoice-based
payments worldwide and change the way the world shops online.


## Usage
Example files can be found in the
[examples](src/main/java/examples/) package.


### Installation with Maven

```xml
<dependency>
    <groupId>com.klarna</groupId>
    <artifactId>kco-rest</artifactId>
    <version>2.2.4</version>
</dependency>
```

### Installation with Ivy

```xml
<dependency org="com.klarna" name="kco-rest" revision="2.2.4"/>
```

### Installation with Gradle

```gradle
dependencies {
    compile group: 'com.klarna', name: 'kco-rest', version: '2.2.4'
}
```


## Documentation
Documentation and more examples can be found at
[developers.klarna.com](https://developers.klarna.com).


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
please contact [integration@klarna.com](mailto:developers@klarna.com).


## License
The Klarna Checkout REST Java SDK is released under
[Apache License, Version 2.0](http://www.apache.org/LICENSE-2.0)

[maven-image]: https://img.shields.io/maven-central/v/com.klarna/kco-rest.svg?style=flat
[travis-image]: https://img.shields.io/travis/klarna/kco_rest_java/v2.2.svg?style=flat
[coveralls-image]: https://img.shields.io/coveralls/klarna/kco_rest_java/v2.2.svg?style=flat
