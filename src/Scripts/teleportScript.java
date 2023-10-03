package Scripts;

import Level.Script;
import Level.ScriptState;

public class teleportScript extends Script {
        private float x, y;

        public teleportScript(float x, float y) {
                this.x = x * 47.3f;
                this.y = y * 47.3f;
                
        }
         
        @Override
        protected void setup() {
                lockPlayer();
                
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
