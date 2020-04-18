package com.lovin.soa.cluster;

import com.lovin.soa.invoke.Invocation;
import com.lovin.soa.invoke.Invoke;

/** 
 * @Description 调用节点失败，直接忽略 
 * @ClassName   FailsafeClusterInvoke 
 * @Date        2017年08月11日 下午8:30:49 
 * @Author      lovin 
 */

public class FailsafeClusterInvoke implements Cluster {
    
    public String invoke(Invocation invocation) throws Exception {
        Invoke invoke = invocation.getInvoke();
        
        try {
            return invoke.invoke(invocation);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "忽略";
        }
    }
    
}
