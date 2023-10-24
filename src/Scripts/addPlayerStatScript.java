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
                        case "attackSpeed":  player.addAttackSpeed(x);
                                break;
                        case "attackRange":  player.addAttackRange(x);
                                break;
                        case "attackDamage":  Player.addAttackDamage(x);
                                break;
                        case "walkSpeed":
                                float y = x; 
                                player.addWalkSpeed(y);
                                break;
                        case "playerHealth":  player.addAttackDamage(x);
                                break;
                        case "maxHealth":  player.addAttackDamage(x);
                                break;
                        case "invincibilityTimer":  player.addIncibilityTimer(x);
                                break;
                        case "dash":  player.addDash(x);
                                break;
                        case "playerArmor":  player.addPlayerArmor(x);
                                break;
                        case "critChance":  player.addCritChance(x);
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
