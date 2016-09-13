package ca.gkwb.struck.interaction.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ca.gkwb.struck.exception.db.GenericDBException;
import ca.gkwb.struck.incident.dao.IncidentVO;
import ca.gkwb.struck.incident.dao.IncidentDAOImpl.StruckTOIncidentRowMapper;

public class InteractionDAOImpl extends JdbcDaoSupport implements InteractionDAO {

	private final String INSERT_SQL = "INSERT INTO strucktodb.\"INTERACTION\"(" +
            "\"INTERACTION_TWEET_ID\", \"INTERACTION_USER\"," + 
            "\"INTERACTION_PROCESSED\", \"INTERACTION_RESULT\", \"INTERACTION_RESULT_TWEET_ID\"," + 
            "\"INTERACTION_CREATE_DATE\", \"INTERACTION_ACTIVITY_DATE\") VALUES (?, ?, '01', ?, ?, sysdate, sysdate);";		

	public void insert(InteractionVO iVO) throws GenericDBException {
		getJdbcTemplate().update(INSERT_SQL, iVO.getTweetId(), iVO.getUser(), 
				iVO.getResult(), iVO.getResultTweetId());		
	}
	
//	private final String UPDATE_SQL = "UPDATE strucktodb.\"INTERACTION\"(" +
//            "\"INTERACTION_TWEET_ID\", \"INTERACTION_USER\"," + 
//            "\"INTERACTION_PROCESSED\", \"INTERACTION_RESULT\", \"INTERACTION_RESULT_TWEET_ID\"," + 
//            "\"INTERACTION_CREATE_DATE\", \"INTERACTION_ACTIVITY_DATE\") VALUES (?, ?, '01', ?, ?, sysdate, sysdate);";		

	public void update(InteractionVO iVO) throws GenericDBException {
//		getJdbcTemplate().update(UPDATE_SQL, iVO.getTweetId(), iVO.getUser(), iVO.getProcessed(), 
//				iVO.getResult(), iVO.getResultTweetId(), iVO.getCreatDate(), iVO.getActivityDate());	
		throw new GenericDBException("Not yet implemented");
	}	

	private final String QUERY_SQL = "SELECT * FROM strucktodb.\"INTERACTION\" WHERE "
			+ "\"INTERACTION_TWEET_ID\" = ?";	
	
	public InteractionVO queryOne(long tweetId) throws GenericDBException {
		return (InteractionVO)getJdbcTemplate().queryForObject(QUERY_SQL, new Object[]{tweetId}, new InteractionRowMapper());
	}
	
	public class InteractionRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			InteractionVO iVO = new InteractionVO(
					rs.getLong("INTERACTION_TWEET_ID"),
					rs.getString("INTERACTION_USER"),
					rs.getString("INTERACTION_PROCESSED"),
					rs.getString("INTERACTION_RESULT"),
					rs.getLong("INTERACTION_RESULT_TWEET_ID"),
					rs.getDate("INTERACTION_CREATE_DATE"),
					rs.getDate("INTERACTION_ACTIVITY_DATE")
					);
			return iVO;
		}
	}
}

