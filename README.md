# payments-service-stub

A dummy Java payment service with an intentional **NullPointerException bug** used for MinionOPS hackathon demo.

## The Bug

`PaymentService.java` line 123 calls `config.get("default_currency")` but `config` is never initialized in the constructor, causing a `NullPointerException`.

## Purpose

MinionOPS Commander detects this error pattern via Elasticsearch anomaly detection, generates a fix using Gemini AI, and opens a **draft pull request** on this repo with the patch.

## Expected Fix (opened by the agent)

```java
if (config == null) {
    throw new IllegalStateException("PaymentService config not initialized");
}
```
