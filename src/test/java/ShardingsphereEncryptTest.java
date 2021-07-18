import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description TODO
 * @Date 2021/7/18 19:31
 * @Author zhouyq
 */
public class ShardingsphereEncryptTest {

    @Test
    public void testGetDataSource() throws SQLException {
        File shardingSphereEncryptConfigFile = new File("E:\\learn\\github\\shardingSphere-encrypt-example\\out\\production\\resources\\encrypt-databases.yaml");
        DataSource dataSource = DataSourceFactory.getDataSource(shardingSphereEncryptConfigFile);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void add() throws SQLException {
        File shardingSphereEncryptConfigFile = new File("E:\\learn\\github\\shardingSphere-encrypt-example\\out\\production\\resources\\encrypt-databases.yaml");
        DataSource dataSource = DataSourceFactory.getDataSource(shardingSphereEncryptConfigFile);
        String sql = "insert into t_order(user_id, user_name) values('待加密数据用户id 001', 'testuser')";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        System.out.println(statement.executeUpdate(sql));
    }

    @Test
    public void search() throws SQLException {
        File shardingSphereEncryptConfigFile = new File("E:\\learn\\github\\shardingSphere-encrypt-example\\out\\production\\resources\\encrypt-databases.yaml");
        DataSource dataSource = DataSourceFactory.getDataSource(shardingSphereEncryptConfigFile);
        String sql = "select user_id, user_name from t_order where user_name='testuser'";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String userId = resultSet.getString("user_id");
            String userName = resultSet.getString("user_name");
            System.out.println("user_id: "+userId+"\t user_name: " + userName);
        }
    }
}
