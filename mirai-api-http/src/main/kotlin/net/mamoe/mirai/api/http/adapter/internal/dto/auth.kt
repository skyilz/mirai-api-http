package net.mamoe.mirai.api.http.adapter.internal.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import net.mamoe.mirai.api.http.context.MahContext
import net.mamoe.mirai.api.http.context.session.AuthedSession

@Serializable
internal data class VerifyDTO(val verifyKey: String) : DTO

@Serializable
internal data class VerifyRetDTO(val code: Int, val session: String) : DTO

@Serializable
internal abstract class AuthedDTO : DTO {
    val sessionKey: String = MahContext.SINGLE_SESSION_KEY

    @Transient
    open lateinit var session: AuthedSession // 反序列化验证成功后传入
}

@Serializable
internal class EmptyAuthedDTO : AuthedDTO()

@Serializable
internal data class BindDTO(val qq: Long) : AuthedDTO()
