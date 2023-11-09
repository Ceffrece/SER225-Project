package Level;

public class Currency {
    public static int normalCurrency;
    public static int specialCurrency;

    public Currency(){
        normalCurrency = 0;
        specialCurrency = 0;
    }

    //starts game with set amount of currency. used for debugging/keeping existing values.
    public Currency(int normStart, int specialStart){
        normalCurrency = normStart;
        specialCurrency = specialStart;
    }

    public int getNormalCurrency(){
        return normalCurrency;
    }
    public void setNormalCurrency(int newNorm){
        normalCurrency = newNorm;
    }
    public int getSpecialCurrency(){
        return specialCurrency;
    }
    public void setSpecialCurrency(int newSpecial){
        specialCurrency = newSpecial;
    }

    //adds currency to player, currencytype 0 for normal, 1 for special
    public static void addCurrency(int currencyAmount, int currencyType){
        if(currencyType == 0){
            normalCurrency += currencyAmount;
        }else{
            specialCurrency += currencyAmount;
        }
    }

    //logic for purchasing an item. price first param, type same as addcurrency function
    public static void purchaseItem(int itemPrice, int currencyType){
        if(currencyType == 0){
            if(normalCurrency >= itemPrice){
                normalCurrency -= itemPrice;
                //method for giving player the item
            }else{
                //handler for if the player doesn't have enough
            }
        }else{
            if(specialCurrency >= itemPrice){
                specialCurrency -= itemPrice;
                //method for giving player the item
            }else{
                //handler if the player doesn't have enough
            }
        }
    }
}
