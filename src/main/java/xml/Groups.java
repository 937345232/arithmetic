package xml;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
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
@Data
@ToString
@NoArgsConstructor
public class Groups {

    private String id;
    private String name;
    @XStreamImplicit(itemFieldName="group")
    private List<Group> group  = new ArrayList<Group>();

    public Groups(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
