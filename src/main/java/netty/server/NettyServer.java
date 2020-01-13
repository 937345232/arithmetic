package netty.server;

import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @author jzx
 * @date 2020/1/13
 */
public class NettyServer {

    private int port;

    public NettyServer(int port) {
        this.port = port;
    }


    private void start() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture sync = serverBootstrap.bind().sync();
            sync.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
        //创建 EventLoopGroup
//        NioEventLoopGroup group = new NioEventLoopGroup();
//        ServerBootstrap serverBootstrap = new ServerBootstrap();
//
//        try {
//            serverBootstrap.group(group)
//                    //指定使用 NIO 的传输 Channel
//                    .channel(NioServerSocketChannel.class)
//                    .localAddress(new InetSocketAddress("127.0.0.1", port))
//                    //.添加 EchoServerHandler 到 Channel 的 ChannelPipeline
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        //ChannelInitializer 。当一个新的连接被接受，一个新的子 Channel 将被创建，
//                        // ChannelInitializer 会添加我们EchoServerHandler 的实例到 Channel 的 ChannelPipeline。
//                        // 正如我们如前所述，如果有入站信息，这个处理器将被通知
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new EchoServerHandler());
//                        }
//                    });
//            //调用 sync() 的原因是当前线程阻塞
//            ChannelFuture sync = serverBootstrap.bind().sync();
//            System.out.println(NettyServer.class.getName() + " started and listen on " + sync.channel().localAddress());
//            sync.channel().closeFuture().sync();
//        } finally {
//            group.shutdownGracefully().sync();
//        }
    }

    public static void main(String[] args) throws Exception {
        new NettyServer(20022).start();
    }
}
