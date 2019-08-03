import com.mybatisPlus.entity.User;
import com.mybatisPlus.mapper.DeptMapper;
import com.mybatisPlus.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2019/8/3 12:27
 *
 * @Author: created by admin
 * @Date: created in 12:27 2019/8/3
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class MyBatisPlusInjectorTest {
    private ApplicationContext ioc
            = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper = ioc.getBean("employeeMapper",EmployeeMapper.class);


    private DeptMapper deptMapper  = ioc.getBean("deptMapper",DeptMapper.class);

    @Test
    public void testMyInjector() {
        int i = deptMapper.deleteAll();
        System.out.println(i);
    }


    @Test
    public void testLogic() {
        User u = new User();
        u.setUserName("张三");
        u.setDeleteFlag("0");
        boolean insert = u.insert();

    }

    @Test
    public void testLogicDelete() {
        User u = new User();
        u.setId(1);
        boolean b = u.deleteById();
        System.out.println(b);
    }


}
