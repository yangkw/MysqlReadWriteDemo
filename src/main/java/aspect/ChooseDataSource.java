package aspect;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class ChooseDataSource extends AbstractRoutingDataSource {
    static Map<String,List<String>> METHOD_TYPE_MAP =new HashMap<String, List<String>>();
    @Override
    /**
     * 实现父类方法，获取数据源名称
    */
    protected Object determineCurrentLookupKey() {
        return DataSourceHandler.getDataSource();
    }
    public void setMethodTypeMap(Map<String,String> map){
        for (String a:map.keySet()){
            List<String> temp=new ArrayList<String>();
            String[] types=map.get(a).split(",");
            for (String type:types){
                if (StringUtils.isNotBlank(type)){
                    temp.add(type);
                }

            }
            METHOD_TYPE_MAP.put(a,temp);
        }


    }

}
