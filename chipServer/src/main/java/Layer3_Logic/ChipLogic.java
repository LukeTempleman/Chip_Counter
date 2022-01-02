package Layer3_Logic;

public class ChipLogic {

    public Integer add(Integer amount, Integer addition){
        return amount+addition;
    }

    public Integer subtract(Integer amount, Integer subtract){
        return amount-subtract;
    }

    public Boolean bust(Integer currentChips){
        if (currentChips <= 0){
            return true;
        }
        else{
            return false;
        }
    }

}
