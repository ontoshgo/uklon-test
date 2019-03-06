package com.nookdev.uklontest.di.component

import com.nookdev.uklontest.di.scope.PerScreen
import com.nookdev.uklontest.presentation.view.posts.PostsFragment
import dagger.Component

@PerScreen
@Component(dependencies = [ActivityComponent::class])
interface PostsFragmentComponent {
    fun inject(target: PostsFragment)
}