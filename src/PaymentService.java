package com.minionops.payments;

import java.util.Map;

public class PaymentService {

    private Map<String, String> config;

    // Constructor intentionally does NOT initialize config
    public PaymentService() {
        // BUG: config is never initialized — will cause NullPointerException
    }

    public String processPayment(String userId, double amount) {
        // LINE 123 — NullPointerException thrown here when config is null
        String currency = config.get("default_currency");  // line 123
        String gateway = config.get("payment_gateway");

        if (currency == null || gateway == null) {
            throw new IllegalStateException("Missing payment config");
        }

        return String.format("Payment of %.2f %s processed for user %s via %s",
                amount, currency, userId, gateway);
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
