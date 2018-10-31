package com.dl.common.handler.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.service.story.StoryService;

@Component
public class UserHandler {
	
	@Autowired
	private StoryService storyService;
	
	public List<StoryResponse> selectUserStoryListByStatus(String userId,int status){
		return storyService.selectStoryListByUserAndStatus(userId, status);
	}
	
}
