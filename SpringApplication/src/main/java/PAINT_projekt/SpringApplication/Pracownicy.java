package PAINT_projekt.SpringApplication;

public class Pracownicy {
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int pensja;
    private String praca_dzis;
    private int id_przypisanej_atrakcji;

    public Pracownicy(){}


    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public String getPraca_dzis() {
        return praca_dzis;
    }

    public void setPraca_dzis(String praca_dzis) {
        this.praca_dzis = praca_dzis;
    }

    public int getId_przypisanej_atrakcji() {
        return id_przypisanej_atrakcji;
    }

    public void setId_przypisanej_atrakcji(int id_przypisanej_atrakcji) {
        this.id_przypisanej_atrakcji = id_przypisanej_atrakcji;
    }
    public Pracownicy(int id_pracownika, String imie, String nazwisko, String pesel, int pensja, String praca_dzis, int id_przypisanej_atrakcji) {
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.pensja = pensja;
        this.praca_dzis = praca_dzis;
        this.id_przypisanej_atrakcji = id_przypisanej_atrakcji;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "id_pracownika=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                ", pensja=" + pensja +
                ", praca_dzis='" + praca_dzis + '\'' +
                ", id_przypisanej_atrakcji=" + id_przypisanej_atrakcji +
                '}';
    }
}
