package PAINT_projekt.SpringApplication.DAO;

import PAINT_projekt.SpringApplication.Atrakcje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AtrakcjeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */
    public AtrakcjeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    /* pobieranie bazy */
    public List<Atrakcje> list(){
        String sql = "SELECT * FROM ATRAKCJE";
        List<Atrakcje> listaAtrakcji = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Atrakcje.class));

        return listaAtrakcji;
    }

    public void save(Atrakcje atrakcja){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("atrakcje").usingColumns("ID","NAZWA","DATA_PRZEGLADU","OPIS","LINK");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(atrakcja);
        insertActor.execute(param);

    }

    /* Read – odczytywanie danych z bazy */
    public Atrakcje get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM ATRAKCJE WHERE ID= " + args[0];
        Atrakcje atrakcja = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Atrakcje.class));

        return atrakcja;
    }
    /* Update – aktualizacja danych */
    public void update(Atrakcje atrakcja) {
        String sql = "UPDATE ATRAKCJE SET nazwa=:nazwa, data_przegladu=:data_przegladu, opis=:opis, link=:link WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(atrakcja);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM ATRAKCJE WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
    public List<Atrakcje> getAtrakcja() {
        String sql = "SELECT * FROM ATRAKCJE";
        List<Atrakcje> atrakcja = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Atrakcje.class));
        return atrakcja;
    }
}
