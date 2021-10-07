package com.inline.cache.vo;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@RedisHash("AddressVO")
public class AddressVO implements Serializable {

    private final LocalDateTime date;
    private final String address;
    private final String cep;

    public AddressVO(String cep, String address) {

        this.cep = cep;
        this.address = address;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "AddressVO{" +
                "date=" + date +
                ", address='" + address + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
