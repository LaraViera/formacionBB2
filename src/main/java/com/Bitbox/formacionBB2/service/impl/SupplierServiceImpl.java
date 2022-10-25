package com.Bitbox.formacionBB2.service.impl;

import com.Bitbox.formacionBB2.model.Supplier;
import com.Bitbox.formacionBB2.repository.SupplierRepository;
import com.Bitbox.formacionBB2.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Boolean newSupplier(Supplier newSupplier) {
        try {
            supplierRepository.save(newSupplier);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Supplier findSupplierByName(String nameSupplier) {
        try {
            return supplierRepository.findSupplierByName(nameSupplier);
        } catch (Exception e) {
            throw e;
        }
    }
}
