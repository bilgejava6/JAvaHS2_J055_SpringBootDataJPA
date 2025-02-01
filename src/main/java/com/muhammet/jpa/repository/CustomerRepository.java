package com.muhammet.jpa.repository;

import com.muhammet.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    /**
     * Özelleştirilmil sorgu yazacağız.
     * interface içerisine method gövdesi yazılamaz. Bu nedenle Spring kendi yapısına uygun şekilde
     * geliştirmiş olduğu TERSINE MÜHENDİSLİK yapısı sayesinde sorgu yazmanızı kolaylaştırıyor.
     * sadece method un tanımını yaparak sorgu oluşturabiliyorsunuz
     *
     * Spring Data ile Sorgu Methodu oluşturmak,
     * 1- *find(arama ) / count(sayaç) / exists(var mı)
     * 1.1.- OPTIONAL;  optional, all, top
     * 2- By: neye göre arama, sayma, varlık-yokluk kontrol etme
     * 3- [Entity-> değişken adı]:  hangi entitiy e ait repository de işlem yapıyorsanuz onun içerisindeki değişken
     * adlarını ekliyoruz.
     * 4- eğer bir den fazla sorulama kriteri var ise,
     * 4.1- And, Or diye devam edilir.
     * 4.2- [Entity-> değişken]
     * method adı oluşturuldukran sonra methodun alacağı parameteler değişken olarak yazılır.
     */


    // select * from tblcustomer where name = ?
    List<Customer> findAllByName(String ahmet_amca_nasilsin);


    // List<Customer> eyyyySpringBanaMustyerileriGetir();
}
