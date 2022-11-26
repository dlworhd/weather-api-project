package zerobase.weather.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    //Autowired를 해야 application.properties에서 데이터소스를 가져와서 주입시켜 줌
    @Autowired
    public JdbcMemoRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo){
        String sql = "insert into memo values(?,?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll(){
        String sql = "select * from memo";

        //조회할 때는 query, 그리고 어떻게 반환을 할 건데? -> memoRowMapper를 가지고 ! 미리 명시해둔 방법으로 반환(result set -> Memo객체로)
        return jdbcTemplate.query(sql, memoRowMapper());
    }

    public Optional<Memo> findById(int id){
        String sql = "select * from memo where id = ?";
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
    }


    //RowMapper는 result set(DB에서 가져오는 값의 형태{id = 1, text = 'this is memo'}과 같은 형식으로 오는 걸 Memo로 Mapping하기 위해 만듦)
    private RowMapper<Memo> memoRowMapper() {
        return(rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}
