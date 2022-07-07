package ir.project.testbazdid.data.remote

import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import retrofit2.Response

interface RemoteDataSource {
suspend fun createSabtTakhallof(body : SabtTakhallofReqBody) : Response<SabtTakhallofResBody>
}