package sampleproject.com.my.skeletonApp.feature.login

import android.content.ContentValues.TAG
import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.R
import sampleproject.com.my.skeletonApp.core.BaseActivity
import sampleproject.com.my.skeletonApp.core.Router
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_get_data.*
import sampleproject.com.my.skeletonApp.databinding.ActivityGetDataBinding
import sampleproject.com.my.skeletonApp.utilities.ToolbarWithBackModel
import java.io.File
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
        if (intent.hasExtra(Router.Parameter.USER_ID.name)
            && intent.hasExtra(Router.Parameter.AVATAR.name)
            && intent.hasExtra(Router.Parameter.CREATION_DATE.name)) {
            viewModel.user_id.set(intent.getIntExtra(Router.Parameter.USER_ID.name,0)!!)
            viewModel.avatar.set(intent.getStringExtra(Router.Parameter.AVATAR.name)!!)
            viewModel.creation_date.set(intent.getStringExtra(Router.Parameter.CREATION_DATE.name)!!)
            Picasso.get().load(viewModel.avatar.get()).into(img_avatar)
        }
        viewModel.errorEvent.observe(this,
            {
                if (it.isNotEmpty()){
                    Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
                }
            }
        )
        viewModel.loadingDialogEvent.observe(
            this, {
                if(isLoadingDialogShown() || !it){
                    dismissLoadingDialog()
                }else showLoadingDialog()
            }
        )

    }



}