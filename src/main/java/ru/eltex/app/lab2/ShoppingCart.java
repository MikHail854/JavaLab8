package ru.eltex.app.lab2;

import org.hibernate.annotations.Type;
import ru.eltex.app.lab1.Products;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * «корзина» класс коллекция
 *
 * @param <T> extends Products
 */
@Entity
public class ShoppingCart <T extends Products> implements Serializable {

    @Id
    @Type(type = "uuid-char")
    private UUID id;//id

    @Type(type = "ru.eltex.app.root.lab1.Products")
    @OneToMany(mappedBy = "cart", targetEntity = Products.class)
    private List<T> cart;//Коллекция для хранения объектов в классе «корзина»

    @Transient
    private HashSet<UUID> uuids;//Коллекция для хранения и поиска уникальных идентификаторов

    @OneToMany(mappedBy = "cart", targetEntity = Order.class)
    private List<Order> orders = new LinkedList();


    @ManyToMany(targetEntity = ru.eltex.app.lab1.Products.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //edit
    @JoinTable(name = "Products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    public List<Products> products = new LinkedList<Products>();

    public ShoppingCart(){
        this.id = UUID.randomUUID();
        this.cart = new LinkedList<>();
        this.uuids = new HashSet<>();
    }

    /**
     * метод добавления объекта из коллекции
     *
     * @param products
     */

    public /*boolean*/void add(T products){
        cart.add(products);
        uuids.add(products.getUUID());
    }

    /**
     * метод удаления объекта из коллекции
     *
     * @param products
     */
    void delete(T products){
        this.cart.remove(products);
    }

    /**
     * функция вывода
     */
    public void show(){
        for (T val: cart){
            val.read();
        }
    }

    public UUID getId() {
        return id;
    }

    public void showShort(){
        for (T val: cart){
            System.out.println(val.name+"("+val.price+")");
        }
    }
    /**
     * функция поиска по индефикатору
     *
     * @param id id который проверяем
     * @return есть ли id в коллекции
     */
    public boolean isExistsUUID(UUID id){
        return uuids.contains(id);
    }

}
