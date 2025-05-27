package com.jvmd.userservice.model;

public enum ESubscritionType {
    VK(100.0),
    YOUTUBE(10400.0),
    YANDEX_PLUS(10.0),
    NETFLIX(2000.0),;

    final Double amount;


    ESubscritionType(Double amount) {
        this.amount = amount;
    }
}
