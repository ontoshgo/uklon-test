package com.nookdev.uklontest.presentation.view.posts

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nookdev.uklontest.R
import com.nookdev.uklontest.di.component.DaggerPostsFragmentComponent
import com.nookdev.uklontest.presentation.view.MainActivity
import com.nookdev.uklontest.presentation.view.base.BaseFragment
import com.nookdev.uklontest.presentation.view.comments.CommentsFragment
import com.nookdev.uklontest.presentation.viewmodel.posts.PostsUiModel
import com.nookdev.uklontest.presentation.viewmodel.posts.PostsViewModel
import com.nookdev.uklontest.util.injectViewModel
import com.nookdev.uklontest.util.navigateTo
import com.nookdev.uklontest.util.showToast
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

class PostsFragment : BaseFragment<PostsViewModel, PostsUiModel>() {

    @Inject
    lateinit var postsAdapter: PostsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swtrlsPosts.setOnRefreshListener {
            viewModel.refresh()
        }
        postsAdapter.setOnItemSelectedListener {
            navController.navigateTo(
                destination = R.id.commentsFragment,
                args = CommentsFragment.buildArgs(it)
            )
        }
        with(rvPostsList) {
            layoutManager = LinearLayoutManager(context)
            adapter = postsAdapter
        }
        postsToolbar.setTitle(R.string.posts_title)
        viewModel.refresh()

    }

    override fun performInjection() {
        DaggerPostsFragmentComponent.builder()
            .activityComponent(MainActivity[this].component)
            .build()
            .inject(this)
    }

    override fun getLayoutId() = R.layout.fragment_posts

    override fun provideViewModel(viewModelFactory: ViewModelProvider.Factory): PostsViewModel {
        return injectViewModel(viewModelFactory)
    }

    override fun onUiModelUpdated(newModel: PostsUiModel) {
        with(newModel) {
            swtrlsPosts.isRefreshing = false
            if (errors.isNotEmpty()) {
                errors.forEach { handlerError(it) }
                return
            }
            postsAdapter.setData(posts)
        }
    }

    private fun handlerError(e: Throwable) {
        showToast(e.message ?: "")
    }
}