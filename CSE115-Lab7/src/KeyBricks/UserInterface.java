package KeyBricks;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserInterface {
	private ArrayList<JButton> _buttons;
	private JPanel _pane;
	private JFrame _frame;

	public UserInterface() {

		JFrame f = new JFrame("KeyBricks");
		JPanel pane = new JPanel();
		_pane = pane;
		_frame = f;
		f.add(pane);
		f.setPreferredSize(new Dimension(600, 600));
		pane.setLayout(new GridLayout(4, 1));

		// Create JButton Arraylist that has DataModel tile letters
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		_buttons = buttons;
		for (int xIndex = 0; xIndex < DataModel.getInstance().getGrid().size(); xIndex = xIndex + 1) {
			for (int yIndex = 0; yIndex < DataModel.getInstance().getGrid().get(xIndex).size(); yIndex = yIndex + 1) {
				// get information stored in datamodel singleton
				Tile currentTile = DataModel.getInstance().getTile(xIndex, yIndex);
				JButton tempB = new JButton(currentTile.toString());
				tempB.setFocusable(false);
				pane.add(tempB);
				tempB.setEnabled(true);
				buttons.add(tempB);
			}
		}

		f.addKeyListener(new KeyListener(this));
		f.setFocusable(true);
		f.setVisible(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void update() {
		_buttons.clear();
		_pane.removeAll();
		_pane.setLayout(new GridLayout(4, 1));
		int diff = 4 - DataModel.getInstance().getGrid().get(0).size();
		for(;diff > 0; diff = diff - 1) {
			_pane.add(new JPanel());
		}
		for (int yIndex = 0; yIndex < DataModel.getInstance().getGrid().get(0).size(); yIndex = yIndex + 1) {
			// get information stored in datamodel singleton
			Tile currentTile = DataModel.getInstance().getTile(0, yIndex);
			JButton jb = new JButton(currentTile.toString());
			System.out.println("Adding button with text: "+jb.getText());
			jb.setFocusable(false);
			jb.setEnabled(true);
			jb.setVisible(true);
			_pane.add(jb);
			_buttons.add(jb);
		}
		_frame.setVisible(true);
		_frame.pack();
		_pane.repaint();
	}

}
