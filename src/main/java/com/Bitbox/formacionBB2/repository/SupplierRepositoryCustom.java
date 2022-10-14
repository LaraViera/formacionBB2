package com.Bitbox.formacionBB2.repository;

import com.Bitbox.formacionBB2.model.Supplier;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepositoryCustom {
    @Query(nativeQuery = true, value = "SELECT * FROM erp.Supplier  AS supplier WHERE supplier.namesupplier= :nameSupplier")
    Supplier findSupplierByName(String nameSupplier);
}
