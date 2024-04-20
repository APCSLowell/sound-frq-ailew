import java.util.*;

public class Sound {
    /** the array of values in this sound; guaranteed not to be null */
    int[] samples;

    /** Changes those values in this sound that have an amplitude greater than limit.
     *  Values greater than limit are changed to limit.
     *  Values less than -limit are changed to -limit.
     *  @param limit the amplitude limit
     *         Precondition: limit >= 0
     *  @return the number of values in this sound that this method changed
     */
    public int limitAmplitude(int limit) {  
        int count = 0;
        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit) {
                samples[i] = limit;
                count++;
            } else if (samples[i] < -limit) {
                samples[i] = -limit;
                count++; // added missing semicolon
            }
        }
        return count;
    }

    /** Removes all silence from the beginning of this sound.
     *  Silence is represented by a value of 0.
     *  Precondition: samples contains at least one nonzero value
     *  Postcondition: the length of samples reflects the removal of starting silence
     */
    public void trimSilenceFromBeginning() {
        int n = 0;
        // Find the index of the first non-zero value
        while (n < samples.length && samples[n] == 0) {
            n++;
        }
        // If all values are zero, there's nothing to trim
        if (n == samples.length) {
            return;
        }
        // Create a new array with the non-zero values
        int[] newSamples = new int[samples.length - n];
        for (int i = 0; i < newSamples.length; i++) {
            newSamples[i] = samples[i + n];
        }
        // Update the samples array to contain only the non-zero values
        samples = newSamples;
    }
}
