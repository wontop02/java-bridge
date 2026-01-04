package bridge.controller;

import bridge.domain.BridgeGame;
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
        BridgeGame bridgeGame = makeBridgeGame();
        move(bridgeGame);
    }

    private BridgeGame makeBridgeGame() {
        while (true) {
            try {
                String input = inputView.readBridgeSize();
                InputValidator.validateBridgeSize(input);
                return bridgeGameService.makeBridgeGame(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void move(BridgeGame bridgeGame) {
        while (true) {
            try {
                while (!bridgeGame.isFail()) {
                    String input = inputView.readMoving();
                    InputValidator.validateMoving(input);
                    bridgeGame.move(input);
                    outputView.printMap(bridgeGame.upBridge(), bridgeGame.downBridge());
                }
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
