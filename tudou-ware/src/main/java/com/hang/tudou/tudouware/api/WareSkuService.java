
package com.hang.tudou.tudouware.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "providerName",path = "/path")
public interface WareSkuService {

    @RequestMapping("/methodPath")
    String methodName(@RequestParam("id") String id);
}

