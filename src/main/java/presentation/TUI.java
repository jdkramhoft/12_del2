package presentation;

import logic.IController;

public class TUI implements IPresentation {

    private IController controller;

    @Override
    public void setController(IController controller) {
        this.controller = controller;
    }

}
