package Scripts.TestMap;

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
            addTextToTextboxQueue( "Welcome Traveler! So you are the one the council of chefs has sent here... \n You don't look like much... Alright then, in you go!");
            addTextToTextboxQueue( "What do you mean, what are you doing here? Didn't they tell you anything? I guess I can spare a minute to tell you.");
            addTextToTextboxQueue( "Long ago, there was an ancient power introduced to this world, one that would change us forever. \n The chalice of flavor fell from the sky, and the culinary world was created.");
            addTextToTextboxQueue("For years, the chalice has been guarded by the structure in front of you, the legendary food pyramid.");
            addTextToTextboxQueue("But now, its guardians inside has been corrupted by the power and have become monsters seeking to destroy the world and remove all flavor!");
            addTextToTextboxQueue("It is now up to you. You must enter the food pyramid and recover the chalice from the destructive guardians!");
        }
        else {
            addTextToTextboxQueue( "Time is ticking... GET IN THERE!");
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
