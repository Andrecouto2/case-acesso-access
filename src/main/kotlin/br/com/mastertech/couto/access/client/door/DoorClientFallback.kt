package br.com.mastertech.couto.access.client.door

import br.com.mastertech.couto.access.client.door.exception.UnavailableDoorService
import br.com.mastertech.couto.access.client.door.models.Door

class DoorClientFallback : DoorClient {
    override fun getDoorById(id: Integer): Door {
        throw UnavailableDoorService()
    }
}