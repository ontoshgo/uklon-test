package com.nookdev.uklontest.domain.mapper

import com.nookdev.uklontest.data.entity.PostEntity
import com.nookdev.uklontest.data.mapper.Mapper
import com.nookdev.uklontest.domain.model.Post
import javax.inject.Inject

class PostMapper @Inject constructor() : Mapper<PostEntity, Post> {
    override fun map(input: PostEntity): Post {
        return input.run {
            Post(
                id = id,
                userId = userId,
                title = title
            )
        }
    }

    override fun reverse(output: Post): PostEntity {
        return output.run {
            PostEntity(
                id = id,
                userId = userId,
                title = title
            )
        }
    }

}