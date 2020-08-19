package br.com.mastertech.couto.access.client.door.decoder

import br.com.mastertech.couto.access.client.door.exception.DoorNotFoundException
import feign.Response
import feign.codec.ErrorDecoder

class DoorClientDecoder : ErrorDecoder {
    private val errorDecoder: ErrorDecoder = ErrorDecoder.Default()
    override fun decode(s: String, response: Response): Exception {
        return if (response.status() == 404) {
            DoorNotFoundException()
        } else errorDecoder.decode(s, response)
    }
}