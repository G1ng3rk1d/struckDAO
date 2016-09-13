package ca.gkwb.struck.interaction.dao;

import ca.gkwb.struck.exception.db.GenericDBException;

public interface InteractionDAO {
	
	/**
	 * inserts a single InteractionVO. Throws exception
	 * if tweetId already exists.
	 * 
 	 * @author Gingerk1d
 	 * @date 2016-09-12
	 * @param iVO
	 * @throws GenericDBException
	 */	
	public void insert(InteractionVO iVO) throws GenericDBException;
	
	/**
	 * Updates a single InteractionVO
	 * 
 	 * @author Gingerk1d
 	 * @date 2016-09-12
	 * @param iVO
	 * @throws GenericDBException
	 */
	public void update(InteractionVO iVO) throws GenericDBException;
	
	/**
	 * Returns a single interactionVO based on the input tweetId.
	 * 
 	 * @author Gingerk1d
 	 * @date 2016-09-12
	 * @param tweetId
	 * @return InteractionVO
	 * @throws GenericDBException
	 */
	public InteractionVO queryOne(long tweetId) throws GenericDBException;

}
