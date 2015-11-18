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

	public UserInterface() {

		JFrame f = new JFrame("KeyBricks");
		JPanel pane = new JPanel();
		_pane = pane;
		f.add(pane);
		f.setPreferredSize(new Dimension(600, 600));
		pane.setLayout(new GridLayout(4, 1));

				
		//Create JButton Arraylist that has DataModel tile letters
		ArrayList <JButton> buttons = new ArrayList <JButton>();
		_buttons = buttons;
		for (int xIndex = 0; xIndex < 1; xIndex = xIndex + 1) {
			for (int yIndex = 0; yIndex < 4; yIndex = yIndex + 1) {
			// get information stored in datamodel singleton
			Tile currentTile = DataModel.getInstance().getTile(xIndex, yIndex);
			JButton tempB = new JButton(currentTile.toString());
			//System.out.println(currentTile.toString());
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
		//for (int xIndex = 0; xIndex < _buttons.size(); xIndex = xIndex + 1) {
			for (int yIndex = 0; yIndex < 3; yIndex = yIndex + 1) {
			JButton jb = new JButton();
			// get information stored in datamodel singleton
			Tile currentTile = DataModel.getInstance().getTile(0, yIndex);
			jb.setText(currentTile.toString());
			_pane.add(jb);
			_buttons.add(jb);
			}
		//}
	}

		
	public void removeJButton() {
		for(int i=0; i < 1; i = i+1) {
			JButton buttonRemoval = _buttons.get(i);
			if (i==0) {
				buttonRemoval.setEnabled(false);
			}
			_buttons.remove(0); 
		}
	}

	public void clear() {
		_buttons.clear();
	}

	
}
