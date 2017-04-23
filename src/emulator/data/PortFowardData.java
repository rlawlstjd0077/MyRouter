package emulator.data;

/**
 * Created by dsm_025 on 2017-04-18.
 */
public class PortFowardData extends NetWorkInfoData implements ClassTypeInferface {
    public final static String TYPE = "PortFowardData";

    @Override
    public String getType() {
        return TYPE;
    }
}
