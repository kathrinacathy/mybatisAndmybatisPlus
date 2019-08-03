import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * Created by admin on 2019/8/1 21:50
 *
 * @Author: created by admin
 * @Date: created in 21:50 2019/8/1
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class MyBatisPlusGeneratorTest {

    @Test
    public void testGengrator() {

        //1 全局配置
        GlobalConfig globalConfig  = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setAuthor("kathrina")
                .setOutputDir("G:\\ideaIU-2018.1.4.win\\IdeaProjects\\mybatisPlus\\src\\main\\java")
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")  //设置生成的service接口的名字的首字母是否为I
                .setBaseResultMap(true)
                .setBaseColumnList(true);//生成sql片段



        //2 数据库配置

        DataSourceConfig dataSourceConfig  = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://192.168.163.131:3307/mybatis?allowMultiQueries=true")
                .setUsername("root")
                .setPassword("root");
        //3 策略配置

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)   //全局大写命名
                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix("tb_")
                .setInclude("tb_dept");  // 生成的表
        //4 包名策略

        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.mybatisPlus")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");
        //整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }
}
