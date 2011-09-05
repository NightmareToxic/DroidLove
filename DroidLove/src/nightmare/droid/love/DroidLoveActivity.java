package nightmare.droid.love;

import nightmare.droid.love.core.GameWorld;
import nightmare.droid.love.objects.MyText;
import nightmare.droid.love.views.GameScreen;
import android.app.Activity;
import android.os.Bundle;

public class DroidLoveActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameScreen gameScreen = new GameScreen(this,new GameWorld());        		
        setContentView(gameScreen.getSurfaceView());
        
        for (int i=0;i<50;i++){
        	gameScreen.getGameWorld().getGameObjects().add(new MyText("*"));      
        }
    }
}