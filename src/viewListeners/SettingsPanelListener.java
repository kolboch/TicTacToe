package viewListeners;

import java.util.EventListener;

import model.FieldState;

public interface SettingsPanelListener extends EventListener {
	void whoStartChanged(boolean userStarts);
	void userSymbolChanged(FieldState users);
}	
