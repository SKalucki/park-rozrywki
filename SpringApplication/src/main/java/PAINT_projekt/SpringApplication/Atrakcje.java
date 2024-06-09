package PAINT_projekt.SpringApplication;

public class Atrakcje {



    private int id;

    private String nazwa;



    private int data_przegladu;
    private String opis;

    private String link;

    public Atrakcje(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getData_przegladu() {
        return data_przegladu;
    }

    public void setData_przegladu(int data_przegladu) {
        this.data_przegladu = data_przegladu;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public Atrakcje(int id, String nazwa, int data_przegladu, String opis, String link) {
        this.id = id;
        this.nazwa = nazwa;
        this.data_przegladu = data_przegladu;
        this.opis = opis;
        this.link = link;
    }
    @Override
    public String toString() {
        return "Atrakcje{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", data_przegladu=" + data_przegladu +
                ", opis='" + opis + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}
