package ca.gkwb.struck.tweet.dao;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ca.gkwb.struck.exception.db.GenericDBException;

public class TweetDAOImpl extends JdbcDaoSupport implements TweetDAO {

	private final String INSERT_SQL = "INSERT INTO strucktodb.\"TWEET\"("+
            "\"TWEET_ID\", \"TWEET_URL\", \"TWEET_ACCOUNT\", \"TWEET_TIMESTAMP\") "+
            "VALUES (?, ?, ?, ?)";

	public void insert(TweetVO sttVO) throws GenericDBException {
		try {
		getJdbcTemplate().update(INSERT_SQL, sttVO.getTweetId(), sttVO.getUrl(), 
				sttVO.getAccount(), sttVO.getTimestamp());
		} catch (DuplicateKeyException e) {
			logger.info("Tweet Exists in DB");
		}
	}

	public void update(TweetVO sttVO) throws GenericDBException {
		// TODO Auto-generated method stub
		
	}

	public void query(long tweetId) throws GenericDBException {
		// TODO Auto-generated method stub
		
	}
	


}
