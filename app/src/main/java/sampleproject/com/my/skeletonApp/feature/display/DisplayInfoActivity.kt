package sampleproject.com.my.skeletonApp.feature.display

import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.R
import sampleproject.com.my.skeletonApp.core.BaseActivity
import sampleproject.com.my.skeletonApp.databinding.ActivityDisplayBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_display.*
import sampleproject.com.my.skeletonApp.core.Router
import sampleproject.com.my.skeletonApp.core.event.StartActivityEvent
import sampleproject.com.my.skeletonApp.core.event.StartActivityModel
import sampleproject.com.my.skeletonApp.utilities.ToolbarWithBackModel
import javax.inject.Inject

class DisplayInfoActivity : BaseActivity(), DataResultAdapter.Callbacks {

    @Inject
    lateinit var viewModel: DisplayInfoViewModel

    @Inject
    lateinit var appPreference: AppPreference

    lateinit var mAdapter: DataResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        val binding: ActivityDisplayBinding = DataBindingUtil.setContentView(this, R.layout.activity_display)
        binding.viewModel = viewModel
        binding.toolbarModel = ToolbarWithBackModel(title = getString(R.string.userdata),
            color = R.color.colorPrimary, callback = this::onBackPressed)

        setupEvent()

    }

    private fun setupEvent() {
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
            viewModel.startActivityEvent.observe(this, object: StartActivityEvent.StartActivityObserver{
                override fun onStartActivity(data: StartActivityModel) {
                    startActivity(this@DisplayInfoActivity, Router.getClass(data.to), data.parameters, data.hasResults)
                }
                override fun onStartActivityForResult(data: StartActivityModel) {
                    startActivity(this@DisplayInfoActivity, Router.getClass(data.to), data.parameters, data.hasResults)
                }

            })
        viewModel.resultDetails().observe(this,{
            setRecyclerView(it)
        })

    }
    private fun setRecyclerView(mutableList: List<DataResultResponse>) {
        mAdapter = DataResultAdapter(mutableList, this)
        data_list.adapter = mAdapter
        data_list.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

    }

    override fun onItemClick(view: View, item: DataResultResponse) {
        viewModel.startActivityEvent.value = StartActivityModel(Router.Destination.LOGIN, hashMapOf(Pair(Router.Parameter.USER_ID,item)),clearHistory = true)
    }



}
