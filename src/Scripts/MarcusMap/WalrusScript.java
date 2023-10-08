package Scripts.MarcusMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class WalrusScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
            addTextToTextboxQueue( "Coding tilesets in is so tedious.");
            addTextToTextboxQueue( "What kind of idiot would painstakingly code in\n63 separate custom tiles?");
            addTextToTextboxQueue( "Oh wait...");
            addTextToTextboxQueue( "Could it be related to who this map is named after?");
        }
        else {
            addTextToTextboxQueue( "You shouldn't be here.");
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
