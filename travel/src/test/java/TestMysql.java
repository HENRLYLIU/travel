import cn.itcast.travel.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestMysql {
    @Test
    public void testMysql() {
         JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        //1.定义sql

        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email) values(?,?,?,?,?,?,?)";
        //2.执行sql

        template.update(sql,
                "henrly",
                "hhhjhjjhc",
                "刘记",
                "1998-3-2",
                "男",
                "18452485351",
                "169598@qq.com"
        );
    }
}
