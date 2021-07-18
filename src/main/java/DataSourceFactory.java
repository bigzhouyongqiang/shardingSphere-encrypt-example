import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlEncryptDataSourceFactory;

import javax.sql.DataSource;

import java.io.File;

/**
 * @Description TODO
 * @Date 2021/7/18 15:26
 * @Author zhouyq
 */
public class DataSourceFactory {

    public static DataSource getDataSource(File shardingSphereEncryptConfigFile) {
        DataSource dataSource = YamlEncryptDataSourceFactory.createDataSource(shardingSphereEncryptConfigFile);
        return dataSource;
    }
}
