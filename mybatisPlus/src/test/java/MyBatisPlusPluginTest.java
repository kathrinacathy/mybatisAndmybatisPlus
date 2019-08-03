import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.mybatisPlus.entity.Dept;
import com.mybatisPlus.entity.Employee;
import com.mybatisPlus.mapper.DeptMapper;
import com.mybatisPlus.mapper.EmployeeMapper;
import net.sf.jsqlparser.statement.execute.Execute;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.util.List;

/**
 * Created by admin on 2019/8/2 12:24
 *
 * @Author: created by admin
 * @Date: created in 12:24 2019/8/2
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class MyBatisPlusPluginTest {

    private ApplicationContext ioc
            = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper = ioc.getBean("employeeMapper",EmployeeMapper.class);


    private DeptMapper deptMapper  = ioc.getBean("deptMapper",DeptMapper.class);
    @Test
    public void testPaginationInterceptor() {
        Page page = new Page(2, 5);
        List resultList = mapper.selectPage(page, Condition.create().eq("email", "sinosoft001@cpic.cn"));
        System.out.println(resultList);

        System.out.println(page.getRecords());
        System.out.println("当前页"+page.getCurrent());
        System.out.println("总页数"+page.getPages());
        System.out.println("每页多少条"+page.getSize());
        System.out.println("总共多少条"+page.getTotal());
        System.out.println("是否有上一页"+page.hasPrevious());

        //添加分页插件后com.baomidou.mybatisplus.plugins.PaginationInterceptor
        // SELECT id,last_name AS lastName,gender,email,emp_status AS empStatus FROM tb_employee WHERE (email = ?) LIMIT 5,5 代表第二页

    }


    @Test
    public void testSqlExplainInterceptor() {
        mapper.delete(null);  // 全表删除

    }


    @Test
    public void testPerformanceInterceptor() {
//        Time：1199 ms - ID：com.mybatisPlus.mapper.EmployeeMapper.selectList
//        Execute SQL：
//        SELECT
//                id,
//        last_name AS lastName,
//                gender,
//                email,
//                emp_status AS empStatus
//        FROM
//        tb_employee]


        List<Employee> employees = mapper.selectList(null);
        System.out.println(employees);


    }


    @Test
    public void testOptimisticLockerInterceptor() {


        Dept dept = new Dept();
        dept.setId(1);
        dept.setDetpName("开发部");
        dept.setVersion(1);
        Integer integer = deptMapper.updateById(dept);
        System.out.println(integer);
    }
}
