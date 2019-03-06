package com.nookdev.uklontest.data.mapper

import com.nookdev.uklontest.data.entity.CommentEntity
import com.nookdev.uklontest.data.net.model.CommentApiModel
import javax.inject.Inject

class CommentEntityMapper @Inject constructor() : Mapper<CommentApiModel, CommentEntity> {
    override fun map(input: CommentApiModel): CommentEntity {
        return input.run {
            CommentEntity(
                id = id,
                postId = postId,
                name = name,
                body = body,
                email = email
            )
        }
    }

    override fun reverse(output: CommentEntity): CommentApiModel {
        return output.run {
            CommentApiModel(
                id = id,
                postId = postId,
                name = name,
                body = body,
                email = email
            )
        }
    }

}