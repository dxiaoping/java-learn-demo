package com.xiaop.javalearndemo.web.service.impl;

import com.xiaop.javalearndemo.web.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Tile:
 * @Author: 段晓平 医保研发5部 CN32219
 * @Date 2022/2/8
 * @Description:
 */
@Slf4j
@Service
public class BaseServiceImpl implements BaseService {
    @Override
    public void firstMethodTest() {
        log.info("print firstMethodTest");
    }
}
