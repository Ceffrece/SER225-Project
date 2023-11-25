package Scripts;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class Floor3Script extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        
        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
            addTextToTextboxQueue("Finally, you made it to the third floor! \n Took you long enough.");
            addTextToTextboxQueue( "Why does it feel like you're at the top? \n Because you ARE.");
            addTextToTextboxQueue("This floor is the last floor!");
            addTextToTextboxQueue( "What? You thought there would be 5 floors?");
            addTextToTextboxQueue("Well, it makes sense since there are \nfive food groups...");
            addTextToTextboxQueue("But the Devs decided there would only \n be three...");
            addTextToTextboxQueue("DEAL WITH IT MWAHAHAHA");
            addTextToTextboxQueue("*ahem*... Anyways, welcome to the \n third floor.");
            addTextToTextboxQueue("Its the same as the other two, just \nWAY MORE DEADLY!!!");
            addTextToTextboxQueue("And different enemies layouts \nbla bla bla...");
            addTextToTextboxQueue("Enough idle chitchat... \n In you go!");
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
