package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.model.Supplier;
import com.Bitbox.formacionBB2.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/newSupplier", method = RequestMethod.POST)
    public Boolean newSupplier(@RequestBody Supplier newSupplier) {
        return supplierService.newSupplier(newSupplier);
    }
}
