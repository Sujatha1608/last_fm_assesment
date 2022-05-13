package sampleproject.com.my.skeletonApp.feature.login

import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.R
import sampleproject.com.my.skeletonApp.core.BaseActivity
import sampleproject.com.my.skeletonApp.core.Router
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_get_data.*
import sampleproject.com.my.skeletonApp.databinding.ActivityGetDataBinding
import sampleproject.com.my.skeletonApp.utilities.ToolbarWithBackModel
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
        binding.toolbarModel = ToolbarWithBackModel(title = getString(R.string.userdata),
            color = R.color.colorPrimary, callback = this::onBackPressed)
        setupIntents()
    }
    private fun setupIntents() {
        if (intent.hasExtra(Router.Parameter.USER_ID.name)) {
            viewModel.model = intent.getParcelableExtra(Router.Parameter.USER_ID.name)!!
            Picasso.get().load(viewModel.model.avatar).into(img_avatar)
        }


    }



}