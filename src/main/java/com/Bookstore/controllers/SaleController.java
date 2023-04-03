package com.Bookstore.controllers;

import com.Bookstore.entities.Book;
import com.Bookstore.entities.Sale;
import com.Bookstore.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping
    public void createSale(@RequestBody Sale sale) {
        saleService.addSale(sale);
    }

    @GetMapping("/{id}")
    public Optional<Sale> getSale(@PathVariable Long id) {
        return saleService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        sale.setId(id);
        saleService.updateSale(sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
    }

}

