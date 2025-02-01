package com.muhammet.jpa.service;

import com.muhammet.jpa.entity.UserProfile;
import com.muhammet.jpa.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Spring Boot genellilikle kendi anotasyonları ile işaretlenmiş yada
 * miras alınmış sınıfların Referanslarını üretir(Bean oluşturur.).
 * bu sınıf için bir nesne yaratılmasını istiyor isek, buna spring
 * anoyasyonu eklemeliyiz
 */
@Service
public class UserProfileSerive {

    /**
     * Dependency Injection - DI / Bağımlılıkların Enjeksiyonu
     * Spring, belli kalıplar ile ihtiyaç duyulan sınıfların nesnelerini kendi
     * sistemi ile oluşturabilir. Yani, bir interface için yada sınıf için
     * nesne oluturulması gerekiyor ise kendisi oluştrur ve gerekli olan
     * sınıflara enjekte eder.
     * DİKKAT!!!!
     * yukarıdaki işlemin gerçekleşmesi için gerekli olan 2 kavram var.
     * 1- Bir sınıf nasıl oluşturulur?
     * Spring ilk ayağa kalkarken, @ComponentScan tüm sistemi tarar var kendisine ait
     * anotasyonları olan yada miras alınmış sınıfları tarar ve tümünün bir referansını
     * yaratır(tümünü new ler) ve oluşan bir referansları Application Context adı verdiği
     * bir listenin içerisinde saklar. Bu işlem Singleton olarak yürütülür.
     * Bu sınıfların oluşturulmasında @Bean denilen bir yapıyı kullanır.
     * 2- Oluşturulan bir nesne referansı başka bir sınıfa nasıl enjecte edilir?
     * - yöntem1: bir değişken tanımlanır ve buna bir nesne referensı atanması gerektiğini
     * @Autowired anotasyonu ile belirtirsiniz. (ÖNERİLMEZ)
     * - yöntem2: dependency injection (constructor injection), eğer bir değişken
     * final ise, mutlaka sınıf başlatılmadan değer atanması gerekiyor.
     * Bu yöntemde, ilgili sınıfın constructor ına verilmesi gereken nesneyi Spring
     * Boot otomatik olarak bilir ve Application Contextinin içerisinde önceden yaratmış
     * olduğu nesnenin referansını bu sınıfa enjekte eder.
     */
    // Yöntem1:
    //    @Autowired
    //    private UserProfileRepository repository;

    // yöntem2: Constructor Injection
    private final UserProfileRepository repository;

    public UserProfileSerive(UserProfileRepository repository){
        this.repository = repository;
    }

    public void save(UserProfile userProfile) {
        repository.save(userProfile);
    }

    public List<UserProfile> getAll(){
        return repository.findAll();
    }
}
