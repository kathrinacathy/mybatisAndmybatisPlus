import com.mybatisPlus.entity.Dept;
import com.mybatisPlus.entity.User;
import com.mybatisPlus.mapper.DeptMapper;
import com.mybatisPlus.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2019/8/3 13:20
 *
 * @Author: created by admin
 * @Date: created in 13:20 2019/8/3
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class MyBatisPlusMetaObjectHandlerTest {
    private ApplicationContext ioc
            = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper mapper = ioc.getBean("employeeMapper",EmployeeMapper.class);


    private DeptMapper deptMapper  = ioc.getBean("deptMapper",DeptMapper.class);

    @Test
    public void textMetaObjectHandler() {
        User u = new User();
        u.setDeleteFlag("0");
        boolean insert = u.insert();
        System.out.println(insert);
    }

    @Test
    public void textMetaObjectHandlerUpdate() {
        User u = new User();
        u.setId(2);
        boolean b = u.updateById();
        System.out.println(b);
    }

}
