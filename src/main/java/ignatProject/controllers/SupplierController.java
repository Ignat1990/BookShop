package ignatProject.controllers;



import ignatProject.model.Supplier;
import ignatProject.repository.SupplierRepository;
import ignatProject.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/supplier")
public class SupplierController {

    @Autowired
    protected SupplierServiceImpl supplierServiceImpl;

    @Autowired
    protected SupplierRepository supplierRepository;

    @GetMapping
    public String viewSupplier(Model model) {
        model.addAttribute("allSupplier", supplierServiceImpl.findAll());
        model.addAttribute("newSupplierForm", new Supplier());
        return "admin/supplier/supplier";
    }

    @PostMapping
    public String newSupplier(@ModelAttribute("newSupplierForm") Supplier newSupplierForm, Model model) {

        if (!supplierServiceImpl.saveSupplier(newSupplierForm)) {
            model.addAttribute("newSupplierForm", "This supplier is taken");
            return "admin/supplier";
        }
        return "redirect:/admin/supplier";

    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable("id") long id) {
        supplierServiceImpl.deleteSupplier(id);
        return "redirect:/admin/supplier";
    }

    @GetMapping("/edit/{id}")
    public String editSupplier(@PathVariable("id") long id, Model model) {
        if (!supplierRepository.existsById(id)) {
            return "redirect:admin/supplier";
        }
        Supplier supplier = supplierRepository.findById(id).get();
        ArrayList<Supplier> editSupplier = new ArrayList<>();
        editSupplier.add(supplier);
        model.addAttribute("editSupplier", editSupplier);
        return "admin/supplier/editsupplier";
    }

    @PostMapping("/edit/{id}")
    public String updateBookGanre(@PathVariable("id") long id, @RequestParam String name, @RequestParam String email, Model model) {
        Supplier supplier = supplierRepository.findById(id).get();
        supplier.setName(name);
        supplier.setEmail(email);
        supplierRepository.save(supplier);
        return "redirect:/admin/supplier";
    }

}