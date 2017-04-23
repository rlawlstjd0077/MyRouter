package emulator.data;

import javafx.scene.Parent;

import java.util.ArrayList;

/**
 * Created by dsm_025 on 2017-04-18.
 */
public class NetWorkSettingData {
    WirelessData wirelessData;
    PortFowardData portFowardData;
    StartURLData startURLData;
    TimeLimitData timeLimitData;
    DHCPData dhcpData;

    public WirelessData getWirelessData() {
        return wirelessData;
    }

    public void setWirelessData(WirelessData wirelessData) {
        this.wirelessData = wirelessData;
    }

    public PortFowardData getPortFowardData() {
        return portFowardData;
    }

    public void setPortFowardData(PortFowardData portFowardData) {
        this.portFowardData = portFowardData;
    }

    public StartURLData getStartURLData() {
        return startURLData;
    }

    public void setStartURLData(StartURLData startURLData) {
        this.startURLData = startURLData;
    }

    public TimeLimitData getTimeLimitData() {
        return timeLimitData;
    }

    public void setTimeLimitData(TimeLimitData timeLimitData) {
        this.timeLimitData = timeLimitData;
    }

    public DHCPData getDhcpData() {
        return dhcpData;
    }

    public void setDhcpData(DHCPData dhcpData) {
        this.dhcpData = dhcpData;
    }

    public void setData(NetWorkInfoData data){
//        data instanceof
    }
}
