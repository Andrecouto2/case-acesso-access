package br.com.mastertech.couto.access.producer

import br.com.mastertech.couto.access.models.Access
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class AccessProducer {

    @Autowired
    private lateinit var producer: KafkaTemplate<String, Access>

    fun sendAccessAoKafka(access: Access) {
        //producer.send("spec4-andre-luis-1", 0,"", access)
        producer.send("spec4-andre-luis-2", access)
    }
}