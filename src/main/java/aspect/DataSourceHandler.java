package aspect;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class DataSourceHandler {
    static final ThreadLocal<String> holder=new ThreadLocal<String>();
    /**
     * 在项目启动的时候将配置的读、写数据源加到holder中
    */
    public static void putDataSource(String dataSource){
        holder.set(dataSource);
    }

    public static String getDataSource(){
        return holder.get();
    }

}
