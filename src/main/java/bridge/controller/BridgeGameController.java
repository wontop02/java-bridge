package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.util.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameService bridgeGameService;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGameService bridgeGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGameService = bridgeGameService;
    }

    public void run() {
        outputView.printStart();
        int size = readBridgeSize();
    }

    private int readBridgeSize() {
        while (true) {
            try {
                String input = inputView.readBridgeSize();
                InputValidator.validateBridgeSize(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
