package PAINT_projekt.SpringApplication.DAO;


import PAINT_projekt.SpringApplication.Rezerwacje;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RezerwacjeDAO {

    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public RezerwacjeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Rezerwacje> list(){
        String sql = "SELECT * FROM REZERWACJE";

        List<Rezerwacje> listaRezerwacje = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rezerwacje.class));

        return listaRezerwacje;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void saveR(Rezerwacje rezerwacje) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("rezerwacje").usingColumns("ID","IMIE","NAZWISKO","ILOSCBILETOW", "KWOTA");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rezerwacje);
        insertActor.execute(param);
    }
    public void saveRUser(Rezerwacje rezerwacje) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("rezerwacje").usingColumns("IMIE","NAZWISKO","ILOSCBILETOW", "KWOTA");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rezerwacje);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Rezerwacje getR(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM REZERWACJE WHERE ID= " + args[0];
        Rezerwacje rezerwacja = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Rezerwacje.class));
        return rezerwacja;
    }
    /* Update – aktualizacja danych */
    public void updateR(Rezerwacje rezerwacja) {
        String sql = "UPDATE REZERWACJE SET imie=:imie, nazwisko=:nazwisko, iloscbiletow=:iloscbiletow," + " kwota=:kwota WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rezerwacja);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }
    /* Delete – wybrany rekord z danym id */
    public void deleteR(int id) {
        String sql = "DELETE FROM REZERWACJE WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
    public List<Rezerwacje> getRezerwacja() {
        String sql = "SELECT * FROM PRACOWNICY";
        List<Rezerwacje> rezerwacja = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rezerwacje.class));
        return rezerwacja;
    }
    public List<Rezerwacje> getRezerwacja2() {
        String sql = "SELECT * FROM PRACOWNICY";
        List<Rezerwacje> rezerwacja = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rezerwacje.class));
        return rezerwacja;
    }


}
