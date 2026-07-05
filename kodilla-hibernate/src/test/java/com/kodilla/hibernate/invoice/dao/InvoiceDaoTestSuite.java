package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("500");
        Item item1 = new Item(new BigDecimal(101), 102, new BigDecimal(103));
        Item item2 = new Item(new BigDecimal(201), 202, new BigDecimal(203));
        Item item3 = new Item(new BigDecimal(301), 302, new BigDecimal(303));
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product2.getItems().add(item3);
        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int item1Id = item1.getId();
        int item2Id = item2.getId();
        int item3Id = item3.getId();
        int product1Id = product1.getId();
        int product2Id = product2.getId();
        //Then
        assertNotEquals(0, invoiceId);
        //CleanUp
        itemDao.deleteById(item1Id);
        itemDao.deleteById(item2Id);
        itemDao.deleteById(item3Id);
        invoiceDao.deleteById(invoiceId);
        productDao.deleteById(product1Id);
        productDao.deleteById(product2Id);
    }
}
