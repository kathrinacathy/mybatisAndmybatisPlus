import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mybatisPlus.entity.EmpStatus;
import com.mybatisPlus.entity.Employee;
import com.mybatisPlus.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.ColumnMapRowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2019/7/28 11:38
 *
 * @Author: created by admin
 * @Date: created in 11:38 2019/7/28
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class MyBatisPlusTest {

    private   ApplicationContext ioc
            = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void testApplicationContext() throws SQLException {

        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    /**
     * 通用 插入操作
     */
    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setLastName("mybatisPlus001");
        employee.setGender("0");
        employee.setEmail("mp001@com.cn");
        employee.setEmpStatus(EmpStatus.LOGIN);
        Integer insert = mapper.insert(employee);
        System.out.println(insert);
        System.out.println("key="+employee.getId());
    }

    /**
     * 通用 更新操作
     */
    @Test
    public void testUpdate() {
        Employee employee  = new Employee();
        employee.setId(1009);
        employee.setLastName("mybatisPlusTest");
        Integer update = mapper.updateById(employee);
        System.out.println(update);

        //全字段修改，如果没有设置值就是空的null
//        mapper.updateAllColumnById(employee);
    }

    /**
     * 通用查询
     */
    @Test
    public void testSelect() {
//        Employee employee = mapper.selectById(1009);
//        System.out.println(employee);
//
//        List<Employee> employees = mapper.selectBatchIds(Arrays.asList( 2, 3, 4));
//        System.out.println(employees);

//        Employee employee = new Employee();
//        employee.setId(2);
//        Employee employee1 = mapper.selectOne(employee);
//        System.out.println(employee1);


//        Map<String ,Object> colunmMap = new HashMap<>();
//        colunmMap.put("last_name","jerry");
//        List<Employee> employees = mapper.selectByMap(colunmMap);
//        System.out.println(employees);

//
//        List<Employee> employees = mapper.selectPage(new Page(1, 5), null);
//        System.out.println(employees);


//        Integer integer = mapper.deleteById(1013);
//        System.out.println(integer);

//        Map<String ,Object> colunmMap = new HashMap<>();
//        colunmMap.put("last_name","jerry");
//        Integer integer1 = mapper.deleteByMap(colunmMap);
//        System.out.println(integer1);


        Integer integer = mapper.deleteBatchIds(Arrays.asList(1011, 1012));
        System.out.println(integer);

    }


    /**
     * 条件构造器   查询操作
     * 条件构造器  修改操作
     * 条件构造器  删除操作
     */
    @Test
    public void testEntityWrapperSelect() {
        //我们需要分页查询tb_employee表中，男且姓名为sinosoft的所有用户

//        List<Employee> employees = mapper.selectPage(new Page(1, 3), new EntityWrapper<Employee>()
//                .eq("gender", "1")
//                .eq("last_name", "sinosoft"));
//        System.out.println(employees);



        // 查询tbl_employee表中， 性别为女并且名字中带有"老师" 或者  邮箱中带有"a"
//        List<Employee> employees1 = mapper.selectList(new EntityWrapper<Employee>()
//                .eq("gender", "1")
//                .like("last_name", "a")
////                .or()   //WHERE (gender = ? AND last_name LIKE ? OR email LIKE ?)
//                .orNew()   //WHERE (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
//                .like("email", "a"));
//        System.out.println(employees1);


        // 查询性别为女的, 根据age进行排序(asc/desc), 简单分页
        List<Employee> employees = mapper.selectPage(new Page(1, 5), new EntityWrapper<Employee>()
                .eq("last_name", "0")
                .orderDesc(Arrays.asList("id", "gender")));//SELECT id,last_name AS lastName,gender,email,emp_status AS empStatus FROM tb_employee WHERE (last_name = ?) ORDER BY id DESC, gender DESC
        System.out.println(employees);


        //更新
//        Employee employee = new Employee();
//        employee.setLastName("苍老师");
//        employee.setEmail("cls@sina.com");
//        employee.setGender("1");
//
//        Integer update = mapper.update(employee, new EntityWrapper<Employee>()
//                .eq("last_name", "bababa"));
//        System.out.println(update);


        //删除
//        Integer delete = mapper.delete(new EntityWrapper<Employee>()
//                .like("last_name", "kathria"));//DELETE FROM tb_employee WHERE (last_name LIKE ?)
//        System.out.println(delete);


    }


    /***
     * 条件构造器 Condition
     */
    @Test
    public void testCondition() {
//        SELECT id,last_name AS lastName,gender,email,emp_status AS empStatus FROM tb_employee WHERE (email = ?)
        List<Employee> list = mapper.selectPage(new Page(1, 5), Condition.create()
                .eq("email", "sinosoft001@cpic.cn"));
        System.out.println(list);
    }



    @Test
    public void testInsertAR() {

        Employee employee = new Employee();
        employee.setLastName("aaa");
        employee.setEmail("aaaa@aliyun.com");
        employee.setGender("0");
        boolean insert = employee.insert();
        System.out.println(insert);
    }
}


