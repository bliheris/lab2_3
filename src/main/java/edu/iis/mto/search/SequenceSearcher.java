package edu.iis.mto.search;


import edu.iis.mto.search.SearchResult;

public interface SequenceSearcher {
	SearchResult search(int key, int[] seq);
}
