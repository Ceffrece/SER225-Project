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
            addTextToTextboxQueue( "Welcome Traveler! So you are the one \nthe council of chefs has sent here...");
            addTextToTextboxQueue("You don't look like much... \nAlright then, in you go!");
            addTextToTextboxQueue( "What do you mean, what are you doing here? \nDidn't they tell you anything? ");
            addTextToTextboxQueue("I guess I can spare a minute to tell you.");
            addTextToTextboxQueue( "Long ago, there was an ancient power introduced \nto this world, one that would change us forever.");
            addTextToTextboxQueue("The chalice of flavor fell from the sky, \nand the culinary world was created.");
            addTextToTextboxQueue("For years, the chalice has been guarded by the \nstructure in front of you...");
            addTextToTextboxQueue("THE LEGENDARY FOOD PYRAMID!!!");
            addTextToTextboxQueue("But now, its guardians inside has been corrupted \nby the power and have become monsters!");
            addTextToTextboxQueue("They now seek to destroy the world \nand remove all flavor!");
            addTextToTextboxQueue("Be warned: they have merged with \nthe pyramid itself");
            addTextToTextboxQueue("This means thye are able to move \nthrough the walls!");
            addTextToTextboxQueue("You, however are not, so they will \ncertainly mess you up! Be CAREFUL!");
            addTextToTextboxQueue("It is now up to you.");
            addTextToTextboxQueue("You must enter the food pyramid and recover \nthe chalice from the destructive guardians!");
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
