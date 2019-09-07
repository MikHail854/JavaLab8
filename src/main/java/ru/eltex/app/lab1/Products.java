package ru.eltex.app.lab1;

import org.hibernate.annotations.Type;
import ru.eltex.app.lab2.ShoppingCart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Products")
public abstract class Products implements ICrudAction, Serializable {

    @Id
    @Type(type = "uuid-char")
    private UUID id;//id товара

    @Column(name = "name")
    public String name; //имя

    @Column(name = "price")
    public int price; // цена

    @Column(name = "numerator")
    protected int numerator; // Остаток товара на складе(счетчик товаров)

    protected String firm; // фирма
    protected String model; // модель
    protected String os; // операционная система

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "fk_id")
    private ShoppingCart<?> cart;//Агрегация ссылка на ShoppingCart

    public static int CounterObject; // Считчик сколько было заказано товаров

    @Override
    public void create() {

        Random random = new Random();
        RandValue val = new RandValue();
        this.price = random.nextInt(1000);
        this.numerator = random.nextInt(100);
        this.firm = val.RandFirm();
        this.model = val.RandModel();
        this.os = val.RandOS();
    }

    @Override
    public void read() {
        System.out.println("Название: " + this.name);
        System.out.println("Цена: " + this.price);
        System.out.println("Остаток товара на складе(счетчик товаров): " + this.numerator);
        System.out.println("Фирма: " + this.firm);
        System.out.println("Модель: " + this.model);
        System.out.println("ОС: " + this.os);
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цену товара: ");
        this.price = scanner.nextInt();
        System.out.println("Введите остаток товара на складе: ");
        this.numerator = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите имя товара: ");
        this.name = scanner.nextLine();
        System.out.println("Введите  фирму: ");
        this.firm = scanner.nextLine();
        System.out.println("Введите модель товара: ");
        this.model = scanner.nextLine();
        System.out.println("Введите операционную систему: ");
        this.os = scanner.next();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void delete() {
        CounterObject--;
        this.name = "";
        this.model = "";
        this.numerator = 0;
        this.price = 0;
        this.firm = "";
        this.os = "";
    }

    public UUID getUUID() {
        return id;
    }
}
