package com.Salon;

import javax.persistence.*;



import java.util.Objects;


@Entity
@Embeddable
@Table(name = "Selling")
public class Selling {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "Pasport")
    private String Pasport;

    @Column(name = "FIO")
    private String FIO;

    @Column(name = "DateOfBirth")
    private String DateOfBirth;

    @Column(name = "Address")
    private String Address;

    @Column(name = "Telef")
    private String Telef;



    public int getClientId() { return id; }
    public void setFIO(String FIO) { this.FIO = FIO; }
    public String getFIO() {return FIO;}
    public void setDateOfBirth(String DateOfBirth) { this.DateOfBirth = DateOfBirth; }
    public String getAddress() { return Address; }
    public void setAddress(String Address) { this.Address = Address; }
    public String getTelef() { return Telef; }
    public void setTelef(String Telef) { this.Telef = Telef; }

    public Selling(String Pasport, String FIO, String DateOfBirth, String Address, String Telef) {
        this.Pasport = Pasport;
        this.FIO = FIO;
        this.DateOfBirth = DateOfBirth;
        this.Address = Address;
        this.Telef = Telef;
    }
    public Selling(){}
    @Override
    public String toString() {
        return "Selling{" +
                "id='" + id + '\'' +
                ", pasport='" + Pasport + '\'' +
                ", fio='" + FIO + '\'' +
                ", dateofbirth='" + DateOfBirth + '\'' +
                ", address='" + Address + '\'' +
                ", telef='" + Telef + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Selling)) return false;
        Selling Selling = (Selling) o;
        return Objects.equals(getClientId(), Selling.getClientId());
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Pasport.hashCode();
        result = 31 * result + FIO.hashCode();
        result = 31 * result + DateOfBirth.hashCode();
        result = 31 * result + Address.hashCode();
        result = 31 * result + Telef.hashCode();
        return result;
    }


    public int getId() {
        return id;
    }
    public void setId(int id){ this.id = id; }
    public String getDateOfBirth() { return DateOfBirth; }



    public void setPasport(String Pasport) {
        this.Pasport = Pasport;
    }

    public String getPasport() {
        return Pasport;
    }
}
