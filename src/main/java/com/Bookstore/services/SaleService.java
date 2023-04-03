package com.Bookstore.services;

import com.Bookstore.entities.Sale;
import com.Bookstore.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public void addSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Transactional
    public void updateSale(Sale sale) {
        Sale existingSale = saleRepository.findById(sale.getId())
                .orElseThrow(() -> new IllegalStateException("Sale not found with id " + sale.getId()));
        existingSale.setQuantity(sale.getQuantity());
        existingSale.setUnitPrice(sale.getUnitPrice());
        existingSale.setBook(sale.getBook());
        existingSale.setCreatedAt(sale.getCreatedAt());
    }

    public void deleteSale(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Sale not found with id " + id));
        saleRepository.delete(sale);
    }

    public Optional<Sale> getById(Long id){
        return saleRepository.findById(id);
    }
}

