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
		_ui.removeJButton();
		_ui.update();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
