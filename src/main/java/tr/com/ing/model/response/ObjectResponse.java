package tr.com.ing.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ObjectResponse {

	private String intent;
	
}
