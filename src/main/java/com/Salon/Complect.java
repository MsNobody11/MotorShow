package com.Salon;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "complect")
public class Complect {
    @Id
    @Column(name = "KodCompl")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer KodCompl;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Sostav")
    private Integer Sostav;

    public void setKodCompl(Integer KodCompl) { this.KodCompl = KodCompl; }
    public Integer getKodCompl() { return KodCompl; }
    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }
    public Integer getSostav() { return Sostav; }
    public void setSostav(Integer Sostav) { this.Sostav = Sostav; }

    public Complect(Integer KodCompl, String Name, Integer Sostav) {
        this.KodCompl = KodCompl;
        this.Name = Name;
        this.Sostav = Sostav;
    }

    public Complect(){}
    @Override
    public String toString() {
        return "Complect{" +
                "kodCompl='" + KodCompl + '\'' +
                ", Name='" + Name + '\'' +
                ", sostav='" + Sostav + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complect)) return false;
        Complect Complect = (Complect) o;
        return Objects.equals(getKodCompl(), Complect.getKodCompl());
    }
    @Override
    public int hashCode() {
        int result = KodCompl.hashCode();
        result = 31 * result + Name.hashCode();
        result = 31 * result + Sostav.hashCode();
        return result;
    }


    public Integer getKodcompl() {
        return KodCompl;
    }
}
