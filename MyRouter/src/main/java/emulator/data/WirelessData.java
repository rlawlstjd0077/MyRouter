package emulator.data;

/**
 * Created by dsm_025 on 2017-04-18.
 */
public class WirelessData extends NetWorkInfoData implements ClassTypeInferface{
    public final static String TYPE = "WirelessData";

    @Override
    public String getType() {
        return TYPE;
    }
}
