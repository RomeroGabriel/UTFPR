
import ex03.MaquinaCafe;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class MaquinaCafeTest {

    @Test
    public void testPedirCafeEmTDEstados() throws Exception {
        //new
        MaquinaCafe mc = new MaquinaCafe();
        //pedirCafe/false
        assertFalse(mc.pedirCafe());
        //adicionarMoeda(1)
        mc.adicionarMoeda(1);
        //pedirCafe/false
        assertFalse(mc.pedirCafe());
        //adicionarMoeda(1)
        mc.adicionarMoeda(1);
        //pedirCafe/true
        assertTrue(mc.pedirCafe());
        //pedirCafe/false
        assertFalse(mc.pedirCafe());
    }

    @Test
    public void testeTransicoesNaoCobertas() throws Exception {
        //new, add(m != 1), add(1), add(m!=1), add(1), add(m!=1), add(1)/exc

        MaquinaCafe mc = new MaquinaCafe();

        try {
            mc.adicionarMoeda(2);
            fail();
        } catch (Exception e) {

        }

        mc.adicionarMoeda(1);
        try {
            mc.adicionarMoeda(2);
            fail();
        } catch (Exception e) {

        }
        
        mc.adicionarMoeda(1);
        try {
            mc.adicionarMoeda(2);
            fail();
        } catch (Exception e) {

        }
        
        try {
            mc.adicionarMoeda(1);
            fail();
        } catch (Exception e) {

        }

    }
}
