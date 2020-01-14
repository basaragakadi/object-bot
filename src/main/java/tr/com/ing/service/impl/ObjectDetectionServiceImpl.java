package tr.com.ing.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import tr.com.ing.constant.AppConstants;
import tr.com.ing.model.request.ObjectRequest;
import tr.com.ing.model.response.ObjectResponse;
import tr.com.ing.service.ObjectDetectionService;

public class ObjectDetectionServiceImpl implements ObjectDetectionService {
	
	@Override
	public ObjectResponse getObjectDetectionResponse(ObjectRequest objectRequest) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<ObjectRequest> request = new HttpEntity<ObjectRequest>(objectRequest, headers);
		ResponseEntity<ObjectResponse> response = restTemplate.exchange(
				AppConstants.OBJECT_BOT_DETECTION_SERVICE_URL,
				HttpMethod.POST,
				request,
				ObjectResponse.class);
		
		return response.getBody();
		
	}

}
