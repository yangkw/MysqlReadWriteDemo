package aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class DataSourceAspect {

    @Pointcut("execution(* dao.*.*(..))")
    public void aspect(){}
    @Before("aspect()")
    public void before(JoinPoint jp){
        String method=jp.getSignature().getName();
        try{
            for (String key:ChooseDataSource.METHOD_TYPE_MAP.keySet()){
                for (String type:ChooseDataSource.METHOD_TYPE_MAP.get(key)){
                    if (method.startsWith(type)){
                        DataSourceHandler.putDataSource(key);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
