package br.com.mastertech.couto.access.models

import br.com.mastertech.couto.access.models.dtos.CreateAccessRequest
import br.com.mastertech.couto.access.models.dtos.CreateAccessResponse
import br.com.mastertech.couto.access.models.dtos.GetAccessResponse
import org.springframework.stereotype.Component

@Component
class AccessMapper {

    fun toCreateAccessRequest(access: Access): CreateAccessRequest {
        return CreateAccessRequest(access.doorId, access.customerId)
    }

    fun toCreateAccessResponse(access: Access): CreateAccessResponse {
        return CreateAccessResponse(access.doorId, access.customerId)
    }

    fun toGetAccessResponse(access: Access): GetAccessResponse {
        return GetAccessResponse(access.doorId, access.customerId)
    }

    fun toAccess(createAccessResponse: CreateAccessRequest): Access {
        val access = Access()
        access.customerId = createAccessResponse.customerId
        access.doorId = createAccessResponse.doorId
        return access
    }

}