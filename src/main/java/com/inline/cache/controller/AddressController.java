package com.inline.cache.controller;

import com.inline.cache.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity getAddress(@RequestParam("codePostal") String codePostal, @RequestParam("address") String address){
        return ResponseEntity.ok(addressService.findAddress(codePostal, address));
    }

    @DeleteMapping("/address/{codePostal}")
    public ResponseEntity removeCodePostal(@PathVariable("codePostal") String codePostal){
        addressService.invalidCacheCodePostal(codePostal);
        return ResponseEntity.ok().build();
    }
}
