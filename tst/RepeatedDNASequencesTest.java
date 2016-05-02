import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/14/2016.
 */
public class RepeatedDNASequencesTest {

    @Test
    public void test() {
        RepeatedDNASequences r = new RepeatedDNASequences();
        RepeatedDNASequences.Solution s = r.new Solution();

        assertEquals(Collections.singletonList("GAGAGAGAGA"), s.findRepeatedDnaSequences("GAGAGAGAGAGA"));
    }

}