package com.codingkiddo.spring_ai__modules.ollamachatbot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingkiddo.spring_ai__modules.ollamachatbot.model.HelpDeskRequest;
import com.codingkiddo.spring_ai__modules.ollamachatbot.model.HelpDeskResponse;
import com.codingkiddo.spring_ai__modules.ollamachatbot.service.HelpDeskChatbotAgentService;


@RestController
@RequestMapping("/helpdesk")
public class HelpDeskController {

	private final HelpDeskChatbotAgentService helpDeskChatbotAgentService;
	
	public HelpDeskController(HelpDeskChatbotAgentService helpDeskChatbotAgentService) {
        this.helpDeskChatbotAgentService = helpDeskChatbotAgentService;
    }
	
	@PostMapping("/chat")
	public ResponseEntity<HelpDeskResponse> chat(@RequestBody HelpDeskRequest helpDeskRequest) {
		var chatResponse = helpDeskChatbotAgentService.call(helpDeskRequest.getPromptMessage(), helpDeskRequest.getHistoryId());
		return new ResponseEntity<>(new HelpDeskResponse(chatResponse), HttpStatus.OK);
	}
}
