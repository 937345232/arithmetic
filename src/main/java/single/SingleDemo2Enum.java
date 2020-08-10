package single;

/**
 * @author jzx
 * @date 2020/5/17
 * @desc
 */
public enum SingleDemo2Enum {
    /**
     * a
     */
    newinstance;




    private SingleDemo2 field;

    SingleDemo2Enum() {
        field = new SingleDemo2();
    }


    public SingleDemo2 getInstance() {
        return field;
    }

}
