package br.com.mastertech.couto.access.client.door

import br.com.mastertech.couto.access.client.door.configuration.DoorClientConfiguration
import br.com.mastertech.couto.access.client.door.models.Door
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "DOOR", configuration = [DoorClientConfiguration::class])
interface DoorClient {
    @GetMapping("/porta/{id}")
    fun getDoorById(@PathVariable id: Integer): Door
}