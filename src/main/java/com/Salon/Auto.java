package com.Salon;

import javax.persistence.*;
import java.util.Objects;

@Entity //Указывает, что данный бин (класс) является сущностью//
@Embeddable // сопоставляется с таблицей базы данных сущности//
@Table(name = "automobil") //показывает на имя таблицы, которая будет отображаться в этой сущности.
public class Auto {
    @Id
    @Column(name = "Id_auto")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id_auto;
    @Column(name = "Manufacturer")
    private String Manufacturer;
    @Column(name = "Marka")
    private String Marka;
    @Column(name = "Model")
    private String Model;
    @Column(name = "TypeBody")
    private String TypeBody;
    @Column(name = "TypeDvigatel")
    private String TypeDvigatel;
    @Column(name = "RaspDvig")
    private String RaspDvig;
    @Column(name = "ObDvig")
    private String ObDvig;
    @Column(name = "TypeBox")
    private String TypeBox;
    @Column(name = "TypePrivod")
    private String TypePrivod;
    @Column(name = "Compl")
    private Integer Compl;
    @Column(name = "Price")
    private Integer Price;


    public void setId(Integer Id_auto) { this.Id_auto = Id_auto; }
    public Integer getId() { return Id_auto; }
    public String getManufacturer() { return Manufacturer; }
    public void setManufacturer(String Manufacturer) { this.Manufacturer = Manufacturer; }
    public String getMarka() { return Marka; }
    public void setMarka(String Marka) { this.Marka = Marka; }
    public String getModel() { return Model; }
    public void setModel(String Model) { this.Model = Model; }
    //public String getTypeBody() { return TypeBody; }
    //public void setTypeBody(String TypeBody) { this.TypeBody = TypeBody; }
    public void setTypeDvigatel(String TypeDvigatel) { this.TypeDvigatel = TypeDvigatel; }
    public String getTypeDvigatel() { return TypeDvigatel; }
    public void setRaspDvig(String RaspDvig) { this.RaspDvig = RaspDvig; }
    public String getRaspDvig() { return RaspDvig; }
    public void setObDvig(String ObDvig) { this.ObDvig = ObDvig; }
    public String getObDvig() { return ObDvig; }
    public void setTypeBox(String TypeBox) { this.TypeBox = TypeBox; }
    public String getTypeBox() { return TypeBox; }
    public void setTypePrivod(String TypePrivod) { this.TypePrivod = TypePrivod; }
    public String getTypePrivod() { return TypePrivod; }
    public void setCompl(Integer Compl) { this.Compl = Compl; }
    public Integer getCompl() { return Compl; }
    public void setPrice(Integer Price) { this.Price = Price; }
    public Integer getPrice() { return Price; }


    public Auto(Integer Id_auto, String Manufacturer, String Marka, String Model, String TypeBody, String TypeDvigatel, String RaspDvig, String ObDvig, String TypeBox, String TypePrivod, Integer Compl, Integer Price) {
        this.Id_auto = Id_auto;
        this.Manufacturer = Manufacturer;
        this.Marka = Marka;
        this.Model = Model;
        this.TypeBody = TypeBody;
        this.TypeDvigatel = TypeDvigatel;
        this.RaspDvig = RaspDvig;
        this.ObDvig = ObDvig;
        this.TypeBox = TypeBox;
        this.TypePrivod = TypePrivod;
        this.Compl = Compl;
        this.Price = Price;
    }

    public Auto(){}
    @Override //используется, когда мы переопределяем метод в подклассе
    //используется для получения строкового представления объекта//
    public String toString() {
        return "Auto{" +
                "id_auto='" + Id_auto + '\'' +
                ", manufacturer='" + Manufacturer + '\'' +
                ", marka='" + Marka + '\'' +
                ", model='" + Model + '\'' +
                ", typeBody='" + TypeBody + '\'' +
                ", typeDvigatel='" + TypeDvigatel + '\'' +
                ", raspDvig='" + RaspDvig + '\'' +
                ", obDvig='" + ObDvig + '\'' +
                ", typeBox='" + TypeBox + '\'' +
                ", typePrivod ='" + TypePrivod  + '\'' +
                ", compl='" + Compl + '\'' +
                ", price='" + Price + '\'' +
                '}';
    }
    @Override
    //используется для сравнения 2х объектов//
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto Auto = (Auto) o;
        return Objects.equals(getId(), Auto.getId());
    }
    @Override
    //тоже используется для сравнения, но более быстрый по сравнению с equals//
    public int hashCode() {
        int result = Id_auto.hashCode();
        result = 31 * result + Manufacturer.hashCode();
        result = 31 * result + Marka.hashCode();
        result = 31 * result + Model.hashCode();
        result = 31 * result + TypeBody.hashCode();
        result = 31 * result + TypeDvigatel.hashCode();
        result = 31 * result + RaspDvig.hashCode();
        result = 31 * result + ObDvig.hashCode();
        result = 31 * result + TypeBox.hashCode();
        result = 31 * result + TypePrivod.hashCode();
        result = 31 * result + Compl.hashCode();
        result = 31 * result + Price.hashCode();
        return result;
    }

    public Integer getId_auto() {
        return Id_auto;
    }

    public void setId_auto(Integer id_auto) { Id_auto = id_auto; }

    public void setTypeBody(String TypeBody) {
        this.TypeBody = TypeBody;
    }

    public String getTypeBody() {
        return TypeBody;
    }

    public Integer getIdauto()
    {
        return Id_auto;
    }

    public void setIdauto(Integer id_auto) {this.Id_auto=Id_auto;}
}
