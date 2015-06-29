package example;

import org.aksw.mex.MEXModel;
import org.aksw.mex.MyMEX_10;
import org.aksw.mex.util.Global;
import org.aksw.mex.util.Global.*;

import java.util.Date;

/**
 * Created by esteves on 27.06.15.
 */
public class ExampleSimple {

    public static void main(String[] args) {

        //the MEX wrapper!
        MyMEX_10 mex = new MyMEX_10();

        //basic authoring provenance
        {
            //change later here the sets for adds
            mex.setAuthorName("D Esteves");
            mex.setAuthorEmail("esteves@informatik.uni-leipzig.de");
            mex.setContext(Global.EnumContext.RecomenderSystems);
            mex.setOrganization("Leipzig University");
        }

        //the header for your experiment
        {
            mex.setExperimentId("E001");
            mex.setExperimentTitle("my first experiment");
            mex.setExperimentDate(new Date());
            mex.setExperimentDescription("my first MEX experiment");
        }

        //ml-experiment-configuration
        {
            //change later here the sets for adds
            mex.setExperimentConfId("E001S001");
            mex.setExperimentConfDescription("analyzing 10-fold cross validation for SVM");
            mex.setExperimentConfModelId("svm20150322");
            mex.setExperimentConfModelDescription("model generated by LibSVM");
            mex.setExperimentConfModelDate(new Date());

            mex.setExperimentConfSamplingMethod(EnumSamplingMethod.CrossValidation);
            mex.setExperimentConfSamplingMethodTrainSize(0.8);
            mex.setExperimentConfSamplingMethodTestSize(0.2);
            mex.setExperimentConfSamplingMethodNumberOfFolds(10);
            mex.setExperimentConfSamplingMethodIsSequential(true);

            mex.setExperimentConfHardwareOS("ubuntu");
            mex.setExperimentConfHardwareCPU(EnumProcessor.INTEL_COREI7);
            mex.setExperimentConfHardwareMB(EnumRandomAccessMemory.SIZE_16GB);
            mex.setExperimentConfHardwareHD("SSD");
            mex.setExperimentConfHardwareCPUCache(EnumCache.CACHE_3MB);
        }


        //adding algorithms and parameters


        //your run


        //saving performances



        //mex.getAlgorithmParameterCollection().getParameters().add(new AlgorithmParameterVO("C", "2"));


        //exporting your ML experiment
        MEXModel.getInstance().parse();
        MEXModel.getInstance().saveToDisk("teste.ttl","http://mex.aksw.org/examples/001/", mex);

        System.exit(0);

    }

}
