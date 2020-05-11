package netty.api;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author jzx
 * @date 2020/1/13ChannelFuture
 */
public class ApiExample {
    public static void main(String[] args) throws Exception {
//       Channel open = SocketChannel.open(new InetSocketAddress("192.168.0.1", 25));
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("123456789", utf8);
        System.out.println("readerIndex = " +  buf.readerIndex());
        System.out.println("writerIndex = " + buf.writerIndex());
        System.out.println("capacity = " + buf.capacity());
        buf.writeByte((byte)'?');
        System.out.println("readerIndex = " +  buf.readerIndex());
        System.out.println("writerIndex = " + buf.writerIndex());
        System.out.println("capacity = " + buf.capacity());
        ReferenceCountUtil.release("as");

        Channel channel = null;
        channel.eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("channel = " + channel);
            }
        },60, TimeUnit.SECONDS);

    }

}
