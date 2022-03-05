package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单--->调用库存服务扣减库存--->调用账户服务扣减账户余额--->修改订单状态
     * 简单来水：
     *  下订单
     *  改库存
     *  减余额
     *  改状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "fsp",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始新建订单");
        orderDao.create(order);

        log.info("订单微服务正在调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("账户开始扣钱");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("修改订单状态");
        orderDao.update(order.getUserId(), 0);

        log.info("结束");
    }

}
