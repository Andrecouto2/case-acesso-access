package br.com.mastertech.couto.access.service

import br.com.mastertech.couto.access.client.customer.CustomerClient
import br.com.mastertech.couto.access.client.door.DoorClient
import br.com.mastertech.couto.access.exception.AccessNotFoundException
import br.com.mastertech.couto.access.models.Access
import br.com.mastertech.couto.access.producer.AccessProducer
import br.com.mastertech.couto.access.repository.AccessRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DoorService {

    @Autowired
    lateinit var customerClient: CustomerClient

    @Autowired
    lateinit var doorClient: DoorClient

    @Autowired
    lateinit var accessRepository: AccessRepository

    @Autowired
    lateinit var accessProducer: AccessProducer

    fun create(access: Access): Access {
        val customer = customerClient.getCustomerById(access.customerId)
        val door = doorClient.getDoorById(access.doorId)
        return accessRepository.save(access)
    }

    fun delete(customerId: Integer, doorId: Integer) {
        val access = accessRepository.findByCustomerIdAndDoorId(customerId, doorId)
        if (access.isPresent.not()) throw AccessNotFoundException()
        accessRepository.deleteByCustomerIdAndDoorId(customerId, doorId)
    }

    fun getByDoorAndCustomerId(customerId: Integer, doorId: Integer): Access {
        val access = accessRepository.findByCustomerIdAndDoorId(customerId, doorId)
        if (access.isPresent.not()) {
            accessProducer.sendAccessAoKafka(Access(customerId, customerId, customerId))
            throw AccessNotFoundException()
        } else {
            accessProducer.sendAccessAoKafka(access.get())
        }
        return access.get()
    }
}