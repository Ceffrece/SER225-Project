package Scripts;

import Level.Script;
import Level.ScriptState;

public class teleportScript extends Script {
        private float x, y;

        public teleportScript() {
        }
         
        @Override
        protected void setup() {
                lockPlayer();
                x = (10+1) * 16;
                y = (10+1) * 16;
                player.setLocation(x,y);
        }

        @Override
        protected void cleanup() {
                unlockPlayer();
        }

        @Override
        protected ScriptState execute() {
                // call setup code
                start();

                if (!isTextboxQueueEmpty()) {
                        return ScriptState.RUNNING;
                }

                // call cleanup code
                end();

                // script ends
                return ScriptState.COMPLETED;
        }
        
}
