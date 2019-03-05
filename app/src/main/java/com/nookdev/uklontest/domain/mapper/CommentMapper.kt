package com.nookdev.uklontest.domain.mapper

import com.nookdev.uklontest.data.entity.CommentEntity
import com.nookdev.uklontest.data.mapper.Mapper
import com.nookdev.uklontest.domain.model.Comment
import javax.inject.Inject

class CommentMapper @Inject constructor() : Mapper<CommentEntity, Comment> {
    override fun map(input: CommentEntity): Comment {
        return input.run {
            Comment(
                id = id,
                postId = postId,
                name = name,
                body = body
            )
        }
    }

    override fun reverse(output: Comment): CommentEntity {
        return output.run {
            CommentEntity(
                id = id,
                postId = postId,
                name = name,
                body = body
            )
        }
    }

}