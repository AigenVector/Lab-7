package KeyBricks;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
	private UserInterface _ui;

	public KeyListener(UserInterface ui) {
		_ui = ui;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		DataModel.getInstance().remove(e.getKeyChar());
		_ui.update();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
