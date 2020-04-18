package com.lovin.soa.cluster;

import com.lovin.soa.invoke.Invocation;


public interface Cluster {
    public String invoke(Invocation invocation) throws Exception;
}
