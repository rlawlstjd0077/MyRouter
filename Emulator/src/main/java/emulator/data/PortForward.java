package emulator.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsm_025 on 2017-04-18.
 */
public class PortForward {
    private List<PortForwardData> portForward_list = new ArrayList<>();

    public List<PortForwardData> getPortForward_list() {
        return portForward_list;
    }

    public void setPortForward_list(List<PortForwardData> portForward_list) {
        this.portForward_list = portForward_list;
    }
}
