import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;



public class ProductRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Ноутбук", 100);
    Product product2 = new Product(2, "Телефон", 120);
    Product product3 = new Product(3, "Плита", 15000);
    Product product4 = new Product(4, "Душевая кабина", 9800);
    Product product5 = new Product(5, "Брелок", 999999);
    Product product6 = new Product(100, "Часы", 2354);

    @BeforeEach
    public void preSet() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
    }


    @Test
    public void shouldAddProduct() {
        Product addProduct = new Product(6, "Молоко", 897);
        repo.add(addProduct);

        Product[] expected = {product1, product2, product3, product4, product5, product6, addProduct};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveById() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(12);
        });
    }

    @Test
    public void shouldExceptionRemoveByIdExisting() {

            repo.removeById(100);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }




}

