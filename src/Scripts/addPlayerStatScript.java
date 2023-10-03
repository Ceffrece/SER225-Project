package Scripts;

import Level.Player;
import Level.Script;
import Level.ScriptState;
import Players.Cat;

public class addPlayerStatScript extends Script {
        private int x;
        private String stat;

        public addPlayerStatScript(String stat, int x) {
                this.x = x;
                this.stat = stat;
                
        }
        public void addStat(String stat, int x){
                switch (stat) {
                        case "attackSpeed":  player.setAttackSpeed(x);
                                break;
                        case "attackRange":  player.setAttackRange(x);
                                break;
                        case "attackDamage":  player.setAttackDamage(x);
                                break;
                        case "walkSpeed":
                                float y = x; 
                                player.addWalkSpeed(y);
                                break;
                        case "playerHealth":  player.setAttackDamage(x);
                                break;

                default: stat = "Invalid";
                        break;        
                }
        }
        @Override
        protected void setup() {
                addStat(stat, x);
        }

        @Override
        protected void cleanup() {
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
