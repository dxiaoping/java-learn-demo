package com.xiaop.javalearndemo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Tile:
 * @Author: 段晓平 医保研发5部 CN32219
 * @Date 2021/12/14
 * @Description:
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        System.out.println(msg);
    }
}
