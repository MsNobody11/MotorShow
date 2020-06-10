package com.Salon;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "selling_auto")
public class Selling_auto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "Client")
    private Integer Client;
    @Column(name = "Car")
    private Integer Car;
    @Column(name = "DateOfSale")
    private String DateOfSale;


    public int getId() {
        return id;
    }
    public void setId(int id){ this.id = id; }
    public void setClient(Integer Client) { this.Client = Client; }
    public Integer getClient() { return Client; }
    public Integer getCar() { return Car; }
    public void setCar(Integer Car) { this.Car = Car; }
    public String getDateOfSale() { return DateOfSale; }
    public void setDateOfSale(String dateOfSale) { DateOfSale = dateOfSale; }

    public Selling_auto(Integer Client, Integer Car, String dateOfSale) {
        this.Client = Client;
        this.Car = Car;
        DateOfSale = dateOfSale;
    }
    public Selling_auto(){}
    @Override
    public String toString() {
        return "Sellind_auto{" +
                "id='" + id + '\'' +
                "client='" + Client + '\'' +
                ", car='" + Car + '\'' +
                ", dateOfSale='" + DateOfSale + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Selling_auto)) return false;
        Selling_auto Selling_auto = (Selling_auto) o;
        return Objects.equals(getId(), Selling_auto.getId());
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Client.hashCode();
        result = 31 * result + Car.hashCode();
        result = 31 * result + DateOfSale.hashCode();
        return result;
    }


}
