import java.util.Arrays;

public class Sound {
    /** the array of values in this sound; guaranteed not to be null */
    int[] samples;

    // limitAmplitude method implementation
    public int limitAmplitude(int limit) {
        int numChanges = 0;
        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit) {
                samples[i] = limit;
                numChanges++;
            }
            else if(samples[i] < -limit){
                samples[i] = -limit;
                numChanges++;
            }
        }
        return numChanges;
    }

    // trimSilenceFromBeginning method implementation
    public void trimSilenceFromBeginning() {
        int n = 0;
        while (samples[n] == 0) {
            n++;
        }
        int[] newSamples = new int[samples.length-n];

        for(int i = 0; i < newSamples.length;i++){
            newSamples[i] = samples[i+n];
        }
        samples = newSamples;
    }
}
