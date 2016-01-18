package com.ansj.vec.util;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 下午7:58
 */
public interface LearnListener {

    void onProcessingWordFreq(int processedCount);

    void onMakingNeuron(int neuronMadeCount);

    void onTrainingMode(int modeTrainedCount);

}
