import java.util.Arrays;

public class Sound {
    /** the array of values in this sound; guaranteed not to be null */
    int[] samples;

    // limitAmplitude method implementation
    public int limitAmplitude(int limit) {
        int numChanges = 0;
        for (int i = 0; i < samples.length; i++) {
            if (Math.abs(samples[i]) > limit) {
                numChanges++;
                samples[i] = samples[i] > 0 ? limit : -limit;
            }
        }
        return numChanges;
    }

    // trimSilenceFromBeginning method implementation
    public void trimSilenceFromBeginning() {
        int firstNonZeroIndex = 0;
        while (samples[firstNonZeroIndex] == 0) {
            firstNonZeroIndex++;
        }
        samples = Arrays.copyOfRange(samples, firstNonZeroIndex, samples.length);
    }
}
