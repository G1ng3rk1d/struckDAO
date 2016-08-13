package ca.gkwb.struck.tweet.dao;

import ca.gkwb.struck.exception.db.GenericDBException;

public interface TweetDAO {
	
	public void insert(TweetVO sttVO) throws GenericDBException;
	
	public void update(TweetVO sttVO) throws GenericDBException;
	
	public void query(long tweetId) throws GenericDBException;

}
