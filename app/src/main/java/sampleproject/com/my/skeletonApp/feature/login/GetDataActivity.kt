package sampleproject.com.my.skeletonApp.feature.login

import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.R
import sampleproject.com.my.skeletonApp.core.BaseActivity
import sampleproject.com.my.skeletonApp.core.Router
import sampleproject.com.my.skeletonApp.core.event.StartActivityEvent
import sampleproject.com.my.skeletonApp.core.event.StartActivityModel
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_display.*
import sampleproject.com.my.skeletonApp.databinding.ActivityGetDataBinding
import javax.inject.Inject

class GetDataActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: GetDataViewModel

    @Inject
    lateinit var preference: AppPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        val binding: ActivityGetDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_get_data)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        setupEvents()
    }


    private fun setupEvents() {
        viewModel.startActivityEvent.observe(this, object: StartActivityEvent.StartActivityObserver{
            override fun onStartActivity(data: StartActivityModel) {
                startActivity(this@GetDataActivity, Router.getClass(data.to), data.parameters, data.hasResults)
            }
            override fun onStartActivityForResult(data: StartActivityModel) {
                startActivity(this@GetDataActivity, Router.getClass(data.to), data.parameters, data.hasResults)
            }

        })
    }
}