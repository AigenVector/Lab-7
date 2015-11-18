package KeyBricks;

import java.util.ArrayList;

public class DataModel {
	private ArrayList<ArrayList<Tile>> _tileGrid;
	private static DataModel _model;
	
	
	// Make DataModel a Singleton
	private DataModel() {
		_tileGrid = new ArrayList<ArrayList<Tile>>();
		
		Tile a = new Tile('a');
		Tile b = new Tile('b');
		Tile c = new Tile('c');
		Tile d = new Tile('d');

		ArrayList<Tile> temp = new ArrayList<Tile>();
		temp.add(a);
		temp.add(b);
		temp.add(c);
		temp.add(d);
		_tileGrid.add(temp);

	}
	//Access to DataModel information
	public static DataModel getInstance() {
		if (_model == null) {
			_model = new DataModel();
		}
		return _model;
	}

	public Tile getTile(int x, int y) {
		return _tileGrid.get(x).get(y);
	}
	
// for use for future labs (add extra columns)
	public ArrayList<ArrayList<Tile>> getGrid() {
		return this._tileGrid;
	}
	
	public void remove(char keyChar) {
	    System.out.println("Me before remove of "+keyChar+"\n"+this.toString());

		for (int x = 0; x < _tileGrid.size(); x = x+1) {
			for (int y = 0; y < _tileGrid.get(x).size(); y =y +1) {
				Tile t = _tileGrid.get(x).get(y);
				if (t.getCharacter() == keyChar ) {
				_tileGrid.get(x).remove(y);
				y = y -1;
				}
			}
		}
	    System.out.println("Me after remove of "+keyChar+"\n"+this.toString());

	}
	
	public String toString() {
		String retVal = "";
        for(ArrayList<Tile> tList : this._tileGrid) {
            retVal +=("[ ");
            boolean isFirst = true;
            for(Tile t : tList) {
                if(isFirst) {
                    isFirst = false;
                    retVal += t.getCharacter()+" ";
                } else {
                 retVal += ", "+ t.getCharacter()+" ";
                }
            }
            retVal += " ]\n";
        }
	return retVal;
	}
	
}

