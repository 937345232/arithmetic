package netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @author jzx
 * @date 2020/1/13
 */
public class NettyClient {

    private String host;
    private int port;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrapServer = new Bootstrap();
            bootstrapServer.group(group)
                    .remoteAddress(host, port)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            ChannelFuture future = bootstrapServer.connect().sync();
            future.addListener(new GenericFutureListener() {
                                   @Override
                                   public void operationComplete(Future future) throws Exception {
                                       if (future.isSuccess()) {
                                           System.out.println("连接成功");
                                       } else {
                                           System.out.println("连接失败");
                                       }
                                   }
                               }
            );
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }


//        NioEventLoopGroup group = new NioEven
//
//
//        tLoopGroup();
//        try {
//            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(group)
//                    .channel(NioSocketChannel.class)
//                    .remoteAddress(new InetSocketAddress(host,port))
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new NettyClientHandler());
//                        }
//                    });
//            //连接到远程;等待连接完成
//            ChannelFuture future = bootstrap.connect().sync();
//            future.addListener((ChannelFutureListener) listener -> {
//                if (future.isSuccess()) {
//                    System.out.println("连接服务器成功");
//                } else {
//                    System.out.println("连接服务器失败");
//                    future.cause().printStackTrace();
//                    group.shutdownGracefully(); //关闭线程组
//                }
//            });
//            future.channel().closeFuture().sync();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //调用 shutdownGracefully() 来关闭线程池和释放所有资源
//            group.shutdownGracefully().sync();
//        }
    }

    public static void main(String[] args) throws Exception {
        new NettyClient("127.0.0.1", 20022).start();
    }
}
