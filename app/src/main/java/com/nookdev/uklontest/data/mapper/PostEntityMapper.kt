package com.nookdev.uklontest.data.mapper

import com.nookdev.uklontest.data.entity.PostEntity
import com.nookdev.uklontest.data.net.model.PostApiModel
import javax.inject.Inject

class PostEntityMapper @Inject constructor() : Mapper<PostApiModel, PostEntity> {
    override fun map(input: PostApiModel): PostEntity {
        return input.run {
            PostEntity(
                id = id,
                userId = userId,
                title = title
            )
        }
    }

    override fun reverse(output: PostEntity): PostApiModel {
        return output.run {
            PostApiModel(
                id = id,
                userId = userId,
                title = title
            )
        }
    }

}