package com.inline.cache.service;

import com.inline.cache.vo.AddressVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Cacheable( cacheNames = "CODE_POSTAL", key = "{#codePostal,#address}")
    public AddressVO findAddress(String codePostal, String address){
        logger.info("Entrou no método, codePostal={}, address={}",codePostal, address);
        return new AddressVO(codePostal, address);
    }

    public void invalidCacheCodePostal(String codePostal){
        redisTemplate.keys("CODE_POSTAL::"+codePostal+"*")
                .stream()
                .forEach(k -> redisTemplate.delete(k));
    }
}