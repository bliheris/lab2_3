package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class SimilarityFinderTest {

    @Test
    public void twoZeroLengthSequence(){
        int[] set1 = new int[]{};
        int[] set2 = new int[]{};

        SimilarityFinder similarityFinder = new SimilarityFinder(null);
        double result = similarityFinder.calculateJackardSimilarity(set1, set2);
        assertThat(result, is(1.0d));
    }

    @Test
    public void twoNonZeroLengthSequence(){
        int[] set1 = new int[]{2,3};
        int[] set2 = new int[]{3,4};

        SearchResult foundSearchResult = mock(SearchResult.class);
        when(foundSearchResult.isFound()).thenReturn(true);
        SearchResult notFoundSearchResult = mock(SearchResult.class);
        when(notFoundSearchResult.isFound()).thenReturn(false);
        SequenceSearcher ss = mock(SequenceSearcher.class);
        when(ss.search(2, set2)).thenReturn(foundSearchResult);
        when(ss.search(3, set2)).thenReturn(notFoundSearchResult);
        SimilarityFinder similarityFinder = new SimilarityFinder(ss);
        similarityFinder.calculateJackardSimilarity(set1, set2);
        verify(ss).search(2, set2);
        verify(ss).search(3, set2);
    }
}