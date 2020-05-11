package netty.api;

import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;

/**
 * @author jzx
 * @date 2020/1/15
 */
public class DecodeDemo extends HttpObjectDecoder {
    @Override
    protected boolean isDecodingRequest() {
        return false;
    }

    @Override
    protected HttpMessage createMessage(String[] initialLine) throws Exception {
        return null;
    }

    @Override
    protected HttpMessage createInvalidMessage() {
        return null;
    }
}
