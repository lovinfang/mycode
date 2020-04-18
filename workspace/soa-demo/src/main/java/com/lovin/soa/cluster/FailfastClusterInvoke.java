package com.lovin.soa.cluster;

import com.lovin.soa.invoke.Invocation;
import com.lovin.soa.invoke.Invoke;

/** 
 * @Description 这个如果调用节点异常，直接失败 
 * @ClassName   FailfastClusterInvoke 
 * @Date        2018年08月11日 下午8:29:23 
 * @Author      lovin 
 * 如果调节点的服务端服务不通，可以在这里添加功能将节点信息从redis中剔除出去
 */

public class FailfastClusterInvoke implements Cluster {
    
    public String invoke(Invocation invocation) throws Exception {
        Invoke invoke = invocation.getInvoke();
        
        try {
            return invoke.invoke(invocation);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
