package Scripts;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class Floor2Script extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        
        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
            addTextToTextboxQueue("Ahhh, so you've made it to the second \nfloor have you? Congratulations!");
            addTextToTextboxQueue( "What do you mean, how did I get here? \nThat's not important!");
            addTextToTextboxQueue("What is important is that this floor is \ndifferent from the previous!");
            addTextToTextboxQueue( "You have new enemies to face, and this \nfloor is layed out different.");
            addTextToTextboxQueue("Please be careful not to die, you still \nhave so much more to go.");
            addTextToTextboxQueue("Off you go now!");
        }
        else {
            addTextToTextboxQueue( "What more do you want? \nKeep moving...");
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        // set flag so that if walrus is talked to again after the first time, what he says changes
        setFlag("hasTalkedToWalrus");
    }

    @Override
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty()) {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}
