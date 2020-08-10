package xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jzx
 * @date 2020/8/9
 * @desc
 */
@ToString
@Data
@NoArgsConstructor
@XStreamAlias("group")
public class Group {

    private String id = "";
    private  String name = "";
    private List<Server> servers = new ArrayList<>();

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
