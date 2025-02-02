package com.muhammet.jpa.repository;

import com.muhammet.jpa.entity.Product;
import com.muhammet.jpa.view.VwProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     *
     * select * from tblproduct where model = ?
     */
    List<Product> findAllByModel(String model);

    /**
     * And, Or
     * select * from tblproduct where model= ? or fiyat=?
     * select * from tblproduct where model=? and stock=?
     */
    List<Product> findAllByModelOrPrice(String model, Double price);
    List<Product> findAllByPriceAndModel(Double price, String model);

    /**
     * GreaterThen
     * select * from tblproduct where stock>10
     * LessThen
     * select * from tblproduct where stock<10
     * GreaterThenEquals
     * select * from tblproduct where stock>=10
     * LessThenEquals
     * select * from tblproduct where stock<=10
     *
     */
    List<Product> findAllByStockLessThan(Integer lowStockCount);

    /**
     *
     * %, _
     * select * from tblproduct where name like ?
     *
     * findAllByNameLike('m%');
     */
    List<Product> findAllByNameLike(String name);

    /**
     * select * from tblproduct where UPPER(name) = UPPER(?)
     */
    List<Product> findAllByNameIgnoreCase(String name);

    /**
     * select * from tblproduct where name like ?+'%'
     * select * from tblproduct where name like '%'+?
     * select * from tblproduct where name like '%'+?+'%'
     */
    List<Product> findAllByNameStartingWith(String name);
    List<Product> findAllByNameEndingWith(String name);
    List<Product> findAllByNameContaining(String name);

    /**
     * belli bir alan adına göre sıralama işlemi
     * ORDERBY
     * ASC -> a..z
     * DESC -> z..a
     * select * from tblproduct orderby price asc
     * select * from tblproduct where model = ? orderby price asc
     */
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByModelOrderByPriceAsc(String model);

    // List<Product> findAllByFiyat(Double fiyat);

    /**
     * Belli bir miktarda sonuç almak
     * select * from tblproduct limit - top 10
     * DİKKAT!!!
     * findAllBy -> tümünü getir
     * findBy -> bulduğunu getir,
     * findTopBy -> 1 kayıt getir.
     * findTop5By -> 5 kayıt getir.
     */
    Product findTopByOrderByPriceDesc(); // fiyatı en yüksek olan ürün
    List<Product> findTop3ByOrderByPriceAsc(); // fiyatı en ucuz olan ilk 3 ürün

    /**
     * select * from product where price>=20 and price<=100
     */
    List<Product> findAllByPriceBetween(Double lowPrice, Double highPrice);
    List<Product> findAllByModelAndPriceBetween(String model,Double lowPrice,Double highPrice );

    /**
     * DİKKAT!!!!!
     * Optional temel olarak bir değer alır, içerisine gelen değer
     * ya vardır(present) ya da yoktur(empty) bu nedenle sorgularınızı
     * yazarken sorgu neticesinde gelen değerin Tek bir sonuç döndüğünden
     * emin olun. aksi halde uygulama hata verir.
     *
     */
    //Optional<Product> findOptionalByUserNameAndPassword(String userName, String password);
    // HATALI!!! neden çünkü aynı model olan bir sürü ürün olabilir.
    // Optional<Product> findOptionalByModel(String model);

    /**
     * kayıt ile ilgili durumunu belirten true/false bir alanımız olsun mesela isDelete
     * bu alanın sorgulanarak liste çekme işleminde kolaylık için True/False sorgusu
     * yapılabilir.
     */
    List<Product> findAllByIsDelete(Boolean isDelete); // true-false ona göre listeleme yapar.
    List<Product> findAllByIsDeleteTrue(); // select * from tblproduct where isDelete = true
    List<Product> findAllByIsDeleteFalse();


    /**
     * Distinct -> belli alanlar için tekilleştirme yapmak üzere kullanılır.
     */
    List<Product> findDistinctByModel(String model);

    /**
     * Eğer bir alan Date olarak kullanılıyor ise, sorgu yaparken bu tarihten önce
     * yada sonra şeklinde yazmak için
     * Before, After kullanılır.
     */
    // List<Product> findAllByCreateDateBefore(Date date);
    // List<Product> findAllByCreateDateAfter(Date date);


    /**
     * IsNull, IsNotNull
     * bir alanın null olup olmadığını irdelemek için kullanılan sorgular
     */
    List<Product> findAllByImageIsNull();
    List<Product> findAllByImageIsNotNull();

    /**
     * In -> belli bir alanda birden fazla değer aramak için kullanılırç.
     *
     * select * from tblproduct where id in (212,121,12,121,21,3423,42,543)
     */
    List<Product> findAllByModelIn(List<String> models);// where model in ('','','','')


    /***
     * Query ile sorgulama yapmak
     *
     * JPQL -> Jakarta Persistence Query Language
     * select p from Product p
     * HQL -> Hibernate Query Language
     * from Product
     * NATIVESQL -> SQL sorgulaması
     * select * from Product
     *
     * @Query -> bu üzerinde geldiği methodun oluşturması gereken sorguyu tarif eder ve
     * method içeridinden alınacak parametreleri alır ve dönüş yapacağı değeri bulur.
     *
     */
    @Query("select p from Product p where p.model = ?1")
    List<Product> eySpringModelAdinaGoreBanaUrunleriGetirirMisin(String modeAdi);

    @Query("select p from Product p where p.model= ?2 and p.price = ?1")
    List<Product> getirModelAdinaGoreVeFiyatinaGore(Double fiyat, String model);

    @Query(nativeQuery = true, value = "select * from Product")
    List<Product> tumUrunleriGetir();

    /**
     * adı xxx olan herhangi bir ürün var mıdır?
     */
    @Query("select COUNT(p)>0 from Product p where p.name = ?1")
    Boolean varMidirAdiSuOlanUrun(String urunAdi);

    /**
     *
     * Bazen, bir tabloda var olan tüm alanları almak istemeyiz, çünkü performans için
     * çok kötü sonuçlar doğurabilir. Bu nedenle ihtiyacımız olan alanları almalıyız.
     * View -> bellli alanları seçmek ya da join ile birleştirilmiş özel tabloları
     * kullanmak için hazır yapılar oluşturur.
     *
     * select name, price, image from tblproduct
     *
     */
    @Query("select new com.muhammet.jpa.view.VwProduct(p.name,p.price,p.image) from Product  p")
    List<VwProduct> findAllView();



}
