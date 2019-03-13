package presentation;

import logic.ILogic;

public class TUI implements IPresentation {

    private ILogic controller;

    @Override
    public void setController(ILogic controller) {
        this.controller = controller;
    }
}
