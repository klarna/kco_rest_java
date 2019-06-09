---
name: Refactor
about:
  A code change which provides value by changing the structure of the code, could
  be from readability or from the architectural side.
title: "[Refactor]: "
labels: ""
assignees: ""
---

**Why this change should be done?**

- [ ] Better code understandability
- [ ] Architecture preparation
- [ ] Other:

**Files affected**

- `...`
- `...`

**Current state**

```java
public Client(final String merchantId, final String sharedSecret, final URI baseUri) {
    // ...
}
```

**Expected state**

```java
public Client(final KlarnaConfiguration, final URI baseUri) {
    // ...
}
```
