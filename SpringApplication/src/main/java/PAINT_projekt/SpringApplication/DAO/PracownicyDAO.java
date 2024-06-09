package PAINT_projekt.SpringApplication.DAO;


import PAINT_projekt.SpringApplication.Pracownicy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PracownicyDAO {


//    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownicy> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownicy> listaPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));

        return listaPracownicy;
    }

    public void saveP(Pracownicy pracownik){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("ID_PRACOWNIKA","IMIE","NAZWISKO","PESEL","PENSJA","PRACA_DZIS","ID_PRZYPISANEJ_ATRAKCJI");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);

    }

    /* Read – odczytywanie danych z bazy */
    public Pracownicy getP(int id_pracownika) {
        Object[] args = {id_pracownika};
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA= " + args[0];
        Pracownicy pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));

        return pracownik;
    }
    /* Update – aktualizacja danych */
    public void updateP(Pracownicy pracownik) {
        String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, pesel=:pesel, pensja=:pensja, praca_dzis=:praca_dzis, id_przypisanej_atrakcji=:id_przypisanej_atrakcji WHERE id_pracownika=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deleteP(int id_pracownika) {
        String sql = "DELETE FROM PRACOWNICY WHERE ID_PRACOWNIKA = ?";
        jdbcTemplate.update(sql, id_pracownika);
    }
    public List<Pracownicy> getPracownik() {
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownicy> pracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownik;
    }


}
