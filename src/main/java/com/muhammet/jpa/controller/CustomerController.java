package com.muhammet.jpa.controller;

import com.muhammet.jpa.entity.Customer;
import com.muhammet.jpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.muhammet.jpa.config.RestApis.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    /**
     * Temel görevi,
     * Kullanıcıdan doğru bilginin alınması ile ilgili sorumluluğu vardır.
     * -- UserName -> gelen bilginin boş olmaması, belli kriterlere uygun olması min 8 max 64 olması
     * -- Email -> girilen bilginin e-posta şeklinde gönderilmiş olması
     * tüm bu ve buna benzer kontrolleri bu katmanda yaparız ve doğru olmayan tüm istekleri direkt
     * olarak red ederiz.
     * --------------
     * bir method yazıdık;
     * public int topla(int s1, int s2){
     *     return s1+s2;
     * }
     * - tüm sistemde 30 farklı alanda bu method kullanılmış olsun. zamanla ihtiyaçlarımız arttı ve artık
     * 3 adet sayı ile işlem yapmak gerekti.
     * public int toplam(int s1,int s2,int s3){
     *
     * }
     * method değiştiği anda onu kullanana tüm sistemler iptal olur ve yeniden yazılmak zorundalar.
     *
     * client ile server arasında data transferi yapmak en doğrududur.
     * DTO (Data Transfer Object)
     * --- Request - istek
     * --- Response - cevap
     * ----- method yapısının ve kullanım şeklinin değişmeden parametre ekleme ve çıkartma işlemleri
     * yapmak kolaydır.
     * ----- performans ve güvenlik için kullanılır.
     * ----- front-end tarafına bildirim geçmek için de kullanılır. bu işlem başarılı değil gibi
     * mesaj ve kodları iletmek için kullanılır.
     *
     */

    private final CustomerService customerService;

    @PostMapping(ADD_CUSTOMER)
    public ResponseEntity<Void> addCustomer(String name, String surName, String phone){
        Customer customer = Customer.builder().name(name).phone(phone).surName(surName).build();
        customerService.save(customer);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomer();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping(GET_BY_NAME)
    public ResponseEntity<List<Customer>> getCustomerByName(String name){
      return ResponseEntity.ok(customerService.getCustomerByName(name));
    }
}
