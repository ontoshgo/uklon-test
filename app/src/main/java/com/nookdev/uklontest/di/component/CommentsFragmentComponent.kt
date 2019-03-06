package com.nookdev.uklontest.di.component

import com.nookdev.uklontest.di.scope.PerScreen
import com.nookdev.uklontest.presentation.view.comments.CommentsFragment
import dagger.Component

@PerScreen
@Component(dependencies = [ActivityComponent::class])
interface CommentsFragmentComponent{
    fun inject(target: CommentsFragment)
}