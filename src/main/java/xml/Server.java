package xml;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author jzx
 * @date 2020/8/9
 * @desc
 */
@Data
@NoArgsConstructor
@ToString
public class Server {

    private String id;
    private String ip;

    public Server(String id, String ip) {
        this.id = id;
        this.ip = ip;
    }
}
