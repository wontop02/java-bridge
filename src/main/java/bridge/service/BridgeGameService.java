package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import java.util.List;

public class BridgeGameService {
    public BridgeGame makeBridgeGame(String input) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int size = Integer.parseInt(input);
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new BridgeGame(bridge);
    }
}
