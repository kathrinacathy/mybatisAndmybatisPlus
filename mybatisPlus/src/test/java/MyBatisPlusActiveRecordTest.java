import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mybatisPlus.entity.EmpStatus;
import com.mybatisPlus.entity.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by admin on 2019/8/1 14:17
 *
 * @Author: created by admin
 * @Date: created in 14:17 2019/8/1
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class MyBatisPlusActiveRecordTest {

    /**
     * 这个不能省略，不然下面会报错
     */
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testInsert() {

       Employee employee = new Employee();
       employee.setLastName("aaa");
       employee.setEmail("aaaa@aliyun.com");
       employee.setGender("0");
       boolean insert = employee.insert();
       System.out.println(insert);
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setLastName("bbb");
        employee.setEmail("bbb@aliyun.com");
        employee.setGender("0");
        employee.setId(1017);
        boolean b = employee.updateById();
        System.out.println(b);
    }

    /**
     * AR 查询
     */
    @Test
    public void testSelect () {
        Employee employee = new Employee();
//        employee.setId(1017);
//        Employee employee1 = employee.selectById();
//        System.out.println(employee1);
//
//
//        Employee employee2 = employee.selectById(166);
//        System.out.println(employee2);


//        List<Employee> employees = employee.selectAll();
//        System.out.println(employees);

        List<Employee> email = employee.selectList(new EntityWrapper<Employee>().eq("email", "@"));
        System.out.println(email);

        int i = employee.selectCount(new EntityWrapper<Employee>().like("last_name", "a"));
        System.out.println(i);
    }



    public void testDelete() {
        Employee employee = new Employee();
        boolean b = employee.deleteById(1017);
        System.out.println(b);

        boolean email = employee.delete(new EntityWrapper().eq("email", "@"));
        System.out.println(email);
    }

    @Test
    public void teseSelectpage() {
        Employee employee = new Employee();

        Page<Employee> employeePage = employee.selectPage(new Page<Employee>(1, 5), new EntityWrapper<Employee>().like("last_name", "a"));

        List<Employee> records = employeePage.getRecords();
        long total = employeePage.getTotal();
        System.out.println(records);
        System.out.println(total);

    }
}
