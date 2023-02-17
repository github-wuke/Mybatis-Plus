package com.wuke.controller;

import com.wuke.service.CityService;
import com.wuke.responce.Responce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(tags = "城市管理")
@RequestMapping("/city")
public class CityController {

    @Resource
    private CityService cityService;

    @ApiOperation("查询所有的省市区")
    @GetMapping("/findAllCity")
    public Responce<?> findAllCity() {
        return Responce.success(cityService.findAllCity()) ;
    }

}