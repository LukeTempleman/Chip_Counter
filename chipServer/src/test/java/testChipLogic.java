
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import Layer3_Logic.ChipLogic;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;




public class testChipLogic {

    //The Chips can be subtracted and added whenever #5



    @Test
    public void chipAddition1(){
        ChipLogic logic = new ChipLogic();
        Integer finalAmount = logic.add(400,500);

        assertEquals((Integer) finalAmount,(Integer)900);
        assertNotNull(finalAmount);

    }

    @Test
    public void chipAddition2(){
        ChipLogic logic = new ChipLogic();
        Integer finalAmount = logic.add(0,2000);

        assertEquals((Integer)finalAmount,(Integer)2000);
        assertNotNull(finalAmount);

    }

    @Test
    public void chipSubtraction1(){

        ChipLogic logic = new ChipLogic();
        Integer finalAmount = logic.subtract(1000,500);

        assertEquals((Integer)finalAmount,(Integer)500);
        assertNotNull(finalAmount);

    }

    @Test
    public void chipSubtraction2(){
        ChipLogic logic = new ChipLogic();
        Integer finalAmount = logic.subtract(3,1);


        assertEquals((Integer)finalAmount,(Integer)2);
        assertNotNull(finalAmount);

    }

    @Test
    public void noChips(){
        ChipLogic logic = new ChipLogic();
        Integer finalAmount = logic.subtract(100,100);

        assertEquals((Integer)finalAmount,(Integer)0);
        assertNotNull(finalAmount);

        Boolean bool = logic.bust(0);
        assertTrue(bool);


    }


}
