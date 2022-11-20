package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private final int size;
    private final int MAX_SIZE = 20;
    private final int MIN_SIZE = 3;
    private List<String> bridge;

    public Bridge(int size) {
        validateSize(size);
        this.size = size;
        this.bridge = buildBridge();
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> buildBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(size);
    }
}
