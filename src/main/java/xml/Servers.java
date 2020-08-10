package xml;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jzx
 * @date 2020/8/9
 * @desc
 */
@Data
@ToString
public class Servers {
    private String id;
//    private Object server;
    private List<Server> server = new ArrayList<>();
}
