package net.kopuz.springboot;

import net.kopuz.springboot.entity.WikimediaDB;
import net.kopuz.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics="wikimedia_current", groupId="Group")
    public void consume(String eventMessage){
        LOGGER.info(String.format("message listened -> %s", eventMessage));

        WikimediaDB wikimediaDB = new WikimediaDB();
        wikimediaDB.setWikiEventData(eventMessage);

        dataRepository.save(wikimediaDB);
    }
}
