package ignatProject.service;

import ignatProject.model.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();

    boolean deleteSupplier(Long id);

    boolean saveSupplier(Supplier id);
}


