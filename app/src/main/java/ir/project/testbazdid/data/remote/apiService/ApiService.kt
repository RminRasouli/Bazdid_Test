package ir.project.testbazdid.data.remote.apiService

import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/AndroidWebService/api/UploadFileAdvance/")
    suspend fun createSabtTakhallof(
        @Body sabtTakhallofReqBody: SabtTakhallofReqBody
    ) : Response<SabtTakhallofResBody>
}