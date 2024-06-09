package PAINT_projekt.SpringApplication;

public class Rezerwacje {
    private int id;
    private String imie;
    private String nazwisko;
    private int iloscBiletow;

    private int kwota;

    public Rezerwacje () {}

    public Rezerwacje(int id, String imie, String nazwisko, int iloscBiletow, int kwota) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.iloscBiletow = iloscBiletow;
        this.kwota = kwota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIloscBiletow() {
        return iloscBiletow;
    }

    public void setIloscBiletow(int iloscBiletow) {
        this.iloscBiletow = iloscBiletow;
    }

    public int getKwota() {
        return kwota;
    }

    public void setKwota(int kwota) {
        this.kwota = kwota;
    }

    @Override
    public String toString() {
        return "Rezerwacje{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", iloscBiletow=" + iloscBiletow +
                ", kwota=" + kwota +
                '}';
    }
}
