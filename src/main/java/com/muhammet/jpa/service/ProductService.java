package com.muhammet.jpa.service;

import com.muhammet.jpa.entity.Product;
import com.muhammet.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    /**
     * Bussiness Logic layer - İş Katmanı
     * bir servis sadece ve sadece kendi REPOSITORY sine erişmelidir.
     * eğer gerkli olurda başka bir repo içerisine bilgi iletmek zorunda olursa,
     * böyle durumlarda DİKKATLİ bir şekilde diğer servisleri çağıra bilirisiniz.
     * ancak, eğer iki servis bir birini sağırıyor ise sonsuz bir loop a sokabilirsiniz.
     *
     * Gerekli oldukça methodlar ekleyin.
     *
     * Servisler kontrollerdan gelen dataları işler, verilerin doğruluğunu kontrol etmezler
     *
     */
    private final ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public void addProduct(String name, String model, Double price) {
        repository.save(Product.builder()
                        .model(model)
                        .name(name)
                        .price(price)
                .build());
    }

    public List<Product> getAllByModel(String model) {
        return repository.findAllByModel(model);
    }
}
