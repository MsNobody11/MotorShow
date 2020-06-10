package com.Salon;

import javax.persistence.*;
import java.util.Objects;



@Entity
@Embeddable
@Table(name = "sostavcompl")
public class SostavCompl {
    @Id
    @Column(name = "kodelement")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer KodElement;
    @Column(name = "nameelement")
    private String NameElement;

    public void setKod(Integer KodElement) { this.KodElement = KodElement; }
    public Integer getKod() { return KodElement; }
    public String getName() { return NameElement; }
    public void setName(String NameElement) { this.NameElement = NameElement; }

    public SostavCompl(Integer KodElement, String NameElement) {
        this.KodElement = KodElement;
        this.NameElement = NameElement;
    }
    public SostavCompl(){}

    @Override
    public String toString() {
        return "SostavElement{" +
                "kodelement='" + KodElement + '\'' +
                ", nameelement='" + NameElement + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SostavCompl)) return false;
        SostavCompl SostavCompl = (SostavCompl) o;
        return Objects.equals(getKod(), SostavCompl.getKod());
    }

    @Override
    public int hashCode() {
        int result = KodElement.hashCode();
        result = 31 * result + NameElement.hashCode();
        return result;
    }


    public void setKodElement(Integer kodElement) {
        KodElement = kodElement;
    }

    public Integer getKodElement() {
        return KodElement;
    }


    public String getNameelement() {
        return NameElement;
    }

    public void setNameelement(String nameelement) {
        this.NameElement = nameelement;
    }


}
