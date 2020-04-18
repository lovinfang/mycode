package com.lovin.soa.configBean;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.lovin.soa.cluster.Cluster;
import com.lovin.soa.cluster.FailfastClusterInvoke;
import com.lovin.soa.cluster.FailoverClusterInvoke;
import com.lovin.soa.cluster.FailsafeClusterInvoke;
import com.lovin.soa.invoke.HttpInvoke;
import com.lovin.soa.invoke.Invoke;
import com.lovin.soa.invoke.NettyInvoke;
import com.lovin.soa.invoke.RmiInvoke;
import com.lovin.soa.loadbalance.LoadBalance;
import com.lovin.soa.loadbalance.RandomLoadBalance;
import com.lovin.soa.loadbalance.RoundRobinLoadBalance;
import com.lovin.soa.proxy.advice.InvokeInvocationHandler;
import com.lovin.soa.registry.BaseRegistryDelegate;

public class Reference extends BaseConfigBean implements FactoryBean,ApplicationContextAware,InitializingBean{

    /**
	 * @Fields serialVersionUID TODO
	 */
	private static final long serialVersionUID = -474210271040253592L;

	private String id;

	// interface
    private String intf;

    private String loadbalance;

    private String protocol;
    
    private String retries;
    
    //Spring上下文
    private static ApplicationContext applicationContext;
    
    private Invoke invoke;   //调用者
    
    private static Map<String, Invoke> invokes = new HashMap<String, Invoke>();
    
    /** 
     * @Fields registryInfo 这个是生产者的多个服务的列表 
     */
    private List<String> registryInfo = new ArrayList<String>();
    
    public List<String> getRegistryInfo() {
        return registryInfo;
    }
    
    public void setRegistryInfo(List<String> registryInfo) {
        this.registryInfo = registryInfo;
    }
    
    private static Map<String, LoadBalance> loadBalances = new HashMap<String, LoadBalance>();
    
    private String cluster;
    
    private static Map<String, Cluster> clusters = new HashMap<String, Cluster>();
    
    
    static {
        invokes.put("http", new HttpInvoke());
        invokes.put("rmi", new RmiInvoke());
        invokes.put("netty", new NettyInvoke());
        
        loadBalances.put("romdom", new RandomLoadBalance());
        loadBalances.put("roundrob", new RoundRobinLoadBalance());
        
        clusters.put("failover", new FailoverClusterInvoke());
        clusters.put("failfast", new FailfastClusterInvoke());
        clusters.put("failsafe", new FailsafeClusterInvoke());
    }
    
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		Reference.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getApplication() {
        return applicationContext;
    }
    
    public Reference() {
    	System.out.println("Reference构造器!");
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntf() {
        return intf;
    }

    public void setIntf(String intf) {
        this.intf = intf;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        this.loadbalance = loadbalance;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * 拿到一个实例，这个方法是Spring调用的，Spring初始化的时候调用的，具体是getBean里面进行调用
     * ApplicationContext.getBean("id");
     * getObject这个方法的返回值，交给Spring容器进行管理
     * 在getObject这个方法里面，返回的是intf这个接口的代理
     */
	public Object getObject() throws Exception {
		System.out.println("返回intf的代理对象");
		if (protocol != null && !"".equals(protocol)) {
            invoke = invokes.get(protocol);
        }else{
        	//Protocol这个实例在Spring上下文容器中   <lovin:protocol.../>
        	Protocol pro = applicationContext.getBean(Protocol.class);	
        	if (pro != null) {
                invoke = invokes.get(pro.getName());
            }else {
            	//如果没有配置协议，则使用默认的Http协议
                invoke = invokes.get("http"); 
            }
        }
		
		//返回代理
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class<?>[] {Class.forName(intf)},
                new InvokeInvocationHandler(invoke, this));
	}

	public Class getObjectType() {
		if(intf != null && !"".equals(intf)){
			try {
				return Class.forName(intf);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean isSingleton() {
		return true;
	}

	public void afterPropertiesSet() throws Exception {
		registryInfo = BaseRegistryDelegate.getRegistry(id, applicationContext);
        System.out.println(registryInfo);
	}

	public static Map<String, LoadBalance> getLoadBalances() {
        return loadBalances;
    }
    
    public static void setLoadBalances(Map<String, LoadBalance> loadBalances) {
        Reference.loadBalances = loadBalances;
    }

    public String getRetries() {
        return retries;
    }
    
    public void setRetries(String retries) {
        this.retries = retries;
    }
    
    public String getCluster() {
        return cluster;
    }
    
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    public static Map<String, Cluster> getClusters() {
        return clusters;
    }
    
    public static void setClusters(Map<String, Cluster> clusters) {
        Reference.clusters = clusters;
    }
    
    
}
