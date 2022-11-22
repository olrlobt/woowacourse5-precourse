package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private final int size;
    public static final int MAX_SIZE = 20;
    public static final int MIN_SIZE = 3;
    private List<String> bridge;

    public Bridge(int size) {
        this.size = size;
        this.bridge = buildBridge();
        System.out.println(bridge);
    }

    public List<String> buildBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(size);
    }

    public boolean checkPassable(String movingPoint, int index) {
        return movingPoint.equals(bridge.get(index));
    }

    public boolean isSameBridge(List<String> mark) {
        return bridge.equals(mark);
    }
}
