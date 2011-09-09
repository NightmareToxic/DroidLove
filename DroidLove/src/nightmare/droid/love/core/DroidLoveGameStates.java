package nightmare.droid.love.core;

import nightmare.droid.core.GameStateMap;
import nightmare.droid.love.views.MainMenu;
import nightmare.droid.love.views.Opening;

public class DroidLoveGameStates extends GameStateMap {
	private static final long serialVersionUID = 1L;

	public DroidLoveGameStates(){
		this.put("OPENING", new Opening());
		this.put("MAINMENU", new MainMenu());
	}
}
