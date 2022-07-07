package ir.project.testbazdid.data.remote

import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import ir.project.testbazdid.data.remote.apiService.ApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceApp @Inject constructor(
private val apiService : ApiService
) : RemoteDataSource {
    override suspend fun createSabtTakhallof(body: SabtTakhallofReqBody): Response<SabtTakhallofResBody> =
        apiService.createSabtTakhallof(body)


}