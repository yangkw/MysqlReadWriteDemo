import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Service;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext spring=new ClassPathXmlApplicationContext("spring.xml");
        Service s= (Service) spring.getBean("service");
        System.out.println(s.get());
    }
}
