package com.ansj.vec;

import com.ansj.vec.util.LearnListener;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 上午11:38
 */
public class LearnTest extends TestCase {

    public void testLearn() throws IOException {
        String input = "/Users/huangsongli/work/open-source/resources/nlp/news2_deal.txt";
        String output = "/Users/huangsongli/work/open-source/resources/nlp/news2_out_java.bin";
        Learn learn = new Learn();
        learn.setLearnListener(new LearnListener() {
            @Override
            public void onProcessingWordFreq(int processedCount) {
                System.out.println("processedCount: " + processedCount);
            }

            @Override
            public void onMakingNeuron(int neuronMadeCount) {
                System.out.println("neuronMadeCount: " + neuronMadeCount);

            }

            @Override
            public void onTrainingMode(int modeTrainedCount) {
                System.out.println("modeTrainedCount: " + modeTrainedCount);

            }
        });
        long start = System.currentTimeMillis() ;
        learn.learnFile(new File(input));
        System.out.println("use time "+(System.currentTimeMillis()-start));
        learn.saveModel(new File(output));

    }

}
