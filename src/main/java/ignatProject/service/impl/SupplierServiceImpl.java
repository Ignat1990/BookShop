package ignatProject.service.impl;

import ignatProject.model.Supplier;
import ignatProject.repository.SupplierRepository;
import ignatProject.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    protected SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public boolean saveSupplier(Supplier supplier) {
        Supplier supplierFromDB = supplierRepository.findByName(supplier.getName());

        if (supplierFromDB != null) {
            return false;
        }
        supplierRepository.save(supplier);
        return true;
    }

    @Override
    public boolean deleteSupplier(Long supplierId) {
        if (supplierRepository.findById(supplierId).isPresent()) {
            supplierRepository.deleteById(supplierId);
            return true;
        }
        return false;
    }

}
