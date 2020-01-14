package tr.com.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tr.com.ing.constant.AppConstants;
import tr.com.ing.model.request.AnswerRequest;
import tr.com.ing.model.request.ObjectRequest;
import tr.com.ing.model.response.AnswerResponse;
import tr.com.ing.model.response.ObjectResponse;
import tr.com.ing.service.AnswerService;
import tr.com.ing.service.ObjectDetectionService;
import tr.com.ing.service.impl.AnswerServiceImpl;
import tr.com.ing.service.impl.ObjectDetectionServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private ObjectDetectionService ObjectDetectionService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(AppConstants.UPLOAD_DESTINATION + file.getOriginalFilename());
            Files.write(path, bytes);
            
            ObjectRequest objectRequest = new ObjectRequest();
            objectRequest.setFilePath("ing"); // originalfilename
            ObjectResponse objectResponse = ObjectDetectionService.getObjectDetectionResponse(objectRequest);
            
            AnswerRequest answerRequest = new AnswerRequest(objectResponse);
            AnswerResponse answerResponse = answerService.getAnswer(answerRequest);
            String replyMessage = answerResponse.getReplyMessage();
            
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("replyMessage", replyMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
    @Bean
    private AnswerService getAnswerService() {
    	return new AnswerServiceImpl();
    }
    
    @Bean
    private ObjectDetectionService getObjectDetectionService() {
    	return new ObjectDetectionServiceImpl();
    }

}
