package netty.api;



import io.netty.channel.ChannelFuture;

import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;

/**
 * @author jzx
 * @date 2020/1/13ChannelFuture
 */
public class ApiExample {
    public static void main(String[] args) throws Exception {
       Channel open = SocketChannel.open(new InetSocketAddress("192.168.0.1", 25));

    }
}
