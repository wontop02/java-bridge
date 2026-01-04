package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.util.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

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
        List<String> bridge = makeBridge();
        String moving = readMoving();
    }

    private List<String> makeBridge() {
        while (true) {
            try {
                String input = inputView.readBridgeSize();
                InputValidator.validateBridgeSize(input);
                return bridgeGameService.makeBridge(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String readMoving() {
        while (true) {
            try {
                String input = inputView.readMoving();
                InputValidator.validateMoving(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
