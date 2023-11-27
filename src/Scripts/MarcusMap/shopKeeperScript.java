package Scripts.MarcusMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class shopKeeperScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        
        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
            addTextToTextboxQueue( "Welcome to the Shop Traveler!");
            addTextToTextboxQueue("you can purchase Items on the right, or a wepon\nto the right the higher the cost, better the item!");
        }
        else {
            addTextToTextboxQueue( "well are you gonna buy something?");
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
