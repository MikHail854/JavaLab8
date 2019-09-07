package ru.eltex.app.lab1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("smartphone")

public class Smartphone extends Products{
    //смартфоны
    private String typeSIMCard;
    private String amountSIM;

    public Smartphone() {
        CounterObject++;
        this.name = "";
        this.model = "";
        this.numerator = 0;
        this.price = 0;
        this.firm = "";
        this.os = "";
        this.typeSIMCard = "";
        this.amountSIM = "";
    }

    public Smartphone(String name, int numerator, String model, int price, String firm, String os, String TypeSIMCard, String AmountSIM) {
        //перегрузка конструктора
        CounterObject++;
        this.name = name;
        this.model = model;
        this.numerator = numerator;
        this.price = price;
        this.firm = firm;
        this.os = os;
        this.typeSIMCard = TypeSIMCard;
        this.amountSIM = AmountSIM;
    }

    @Override
    public void create() {
        super.create();
        RandValue val = new RandValue();
        this.name = val.RandNameSmartphone();
        this.typeSIMCard = val.RandTypeSIMCard();
        this.amountSIM = val.RandAmountSIM();
    }

    @Override
    public void read() {
        super.read();
        System.out.println("Количество SIM-карт: " + this.amountSIM + "\n--------------------------");
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void delete() {
        super.delete();
        this.typeSIMCard = "";
        this.amountSIM = "";
    }


}
