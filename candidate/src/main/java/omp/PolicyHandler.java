package omp;

import omp.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired CandidateRepository candidateRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCampaignCreated_CampaignCounting(@Payload CampaignCreated campaignCreated){

        if(!campaignCreated.validate()) return;

        System.out.println("\n\n##### listener CampaignCounting : " + campaignCreated.toJson() + "\n\n");

        // Sample Logic //
        Candidate candidate = new Candidate();
        candidateRepository.save(candidate);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCampaignDeleted_CampaignCounting(@Payload CampaignDeleted campaignDeleted){

        if(!campaignDeleted.validate()) return;

        System.out.println("\n\n##### listener CampaignCounting : " + campaignDeleted.toJson() + "\n\n");

        // Sample Logic //
        Candidate candidate = new Candidate();
        candidateRepository.save(candidate);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
