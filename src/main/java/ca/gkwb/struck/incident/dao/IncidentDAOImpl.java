package ca.gkwb.struck.incident.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ca.gkwb.struck.exception.db.GenericDBException;
import ca.gkwb.struck.exception.db.NoRowFoundException;

public class IncidentDAOImpl extends JdbcDaoSupport implements IncidentDAO {
//	
	private final String INSERT_SQL = "INSERT INTO strucktodb.\"INCIDENT\"(" +
            "\"INCIDENT_TWEET_ID\", \"INCIDENT_SEVERITY\", \"INCIDENT_NEWS_URL\"," + 
            "\"INCIDENT_CREATE_DATE\", \"INCIDENT_ACTIVITY_DATE\", \"INCIDENT_LOCATION_ID\"," + 
            "\"INCIDENT_VERIFIED\") VALUES (?, ?, ?, ?, ?, ?, ? );";
	
	private final String QUERY_SQL = "SELECT * FROM strucktodb.\"INCIDENT\" WHERE "
			+ "\"INCIDENT_ID\" = ?";
	
	private final String QUERY_ALL = "SELECT * FROM strucktodb.\"INCIDENT\" WHERE "
			+ "\"INCIDENT_ID\" = ?";	
	
	public IncidentVO queryById(int id) throws GenericDBException {
		return (IncidentVO)getJdbcTemplate().queryForObject(QUERY_SQL, new Object[]{id}, new StruckTOIncidentRowMapper());
	}

	public IncidentVO queryByTwitterId(String id) throws NoRowFoundException, GenericDBException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(IncidentVO stVO) throws GenericDBException {
		// TODO Auto-generated method stub

	}

	public void insert(IncidentVO stVO) throws GenericDBException {
		logger.debug("Inserting StruckTOIncidentVO : " + stVO);
		char verified = 'N';
		if (stVO.isVerified()) verified = 'Y';
		
		getJdbcTemplate().update(INSERT_SQL, stVO.getTweetId(), stVO.getSeverity(), stVO.getNewsUrl(), 
				stVO.getCreateDate(), stVO.getActivityDate(), stVO.getLocationId(), verified);
	}

	public List<IncidentVO> queryAll(IncidentVO stVO) throws NoRowFoundException, GenericDBException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private final String QUERY_ALL_BY_LOCATION = "SELECT * FROM strucktodb.\"INCIDENT\" WHERE "
			+ "\"INCIDENT_LOCATION_ID\" = ?";
	
	public List<IncidentVO> queryByLocationId(int id) throws NoRowFoundException, GenericDBException {
		return getJdbcTemplate().query(QUERY_ALL_BY_LOCATION, new Object[]{id}, new StruckTOIncidentRowMapper());
	}	
	
	public class StruckTOIncidentRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			boolean verified = false;
			if (rs.getString("INCIDENT_VERIFIED").equalsIgnoreCase("Y")) verified = true;
			IncidentVO res = new IncidentVO(
					rs.getInt("INCIDENT_ID"),
					rs.getLong("INCIDENT_TWEET_ID"),
					rs.getString("INCIDENT_SEVERITY"),
					rs.getString("INCIDENT_NEWS_URL"),
				    rs.getDate("INCIDENT_CREATE_DATE"),
				    rs.getDate("INCIDENT_ACTIVITY_DATE"),
				    rs.getInt("INCIDENT_LOCATION_ID"),
				    verified
					);
			return res;
		}
	}	

}
