package sampleproject.com.my.skeletonApp.feature.display

import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.R
import sampleproject.com.my.skeletonApp.core.BaseActivity
import sampleproject.com.my.skeletonApp.core.Router
import sampleproject.com.my.skeletonApp.databinding.ActivityDisplayBinding
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import javax.inject.Inject

class DisplayInfoActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: DisplayInfoViewModel

    @Inject
    lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        val binding: ActivityDisplayBinding = DataBindingUtil.setContentView(this, R.layout.activity_display)
        binding.viewModel = viewModel

        setupEvent()
    }

    private fun setupEvent() {
        if (intent.hasExtra(Router.Parameter.USERNAME.name)) {
            viewModel.username.set(intent.getStringExtra(Router.Parameter.USERNAME.name)!!)
        }
    }
}
