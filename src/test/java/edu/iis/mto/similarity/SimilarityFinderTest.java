package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimilarityFinderTest {

    @Test
    public void twoZeroLengthSequence(){
        int[] set1 = new int[]{};
        int[] set2 = new int[]{};

        SimilarityFinder similarityFinder = new SimilarityFinder(null);
        double result = similarityFinder.calculateJackardSimilarity(set1, set2);
        assertThat(result, is(1.0d));

    }
}