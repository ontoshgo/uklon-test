package com.nookdev.uklontest.di.module

import androidx.lifecycle.ViewModel
import com.nookdev.uklontest.di.ViewModelKey
import com.nookdev.uklontest.di.scope.PerActivity
import com.nookdev.uklontest.presentation.viewmodel.comments.CommentsViewModel
import com.nookdev.uklontest.presentation.viewmodel.main.MainActivityViewModel
import com.nookdev.uklontest.presentation.viewmodel.posts.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(model: MainActivityViewModel): ViewModel

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(model: PostsViewModel): ViewModel

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    abstract fun bindCommentsViewModel(mode: CommentsViewModel): ViewModel
}