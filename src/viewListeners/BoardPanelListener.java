package viewListeners;

import java.util.EventListener;

public interface BoardPanelListener extends EventListener {
	void doMove(int row, int column);
}
