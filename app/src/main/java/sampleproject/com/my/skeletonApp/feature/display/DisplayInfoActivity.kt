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
import sampleproject.com.my.skeletonApp.utilities.ObservableString
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
        setRecyclerView()
    }

    private fun setupEvent() {
        viewModel.callBack = object : DisplayInfoViewModel.ViewModelCallBack {
            override fun updateRecyclerView(update: Boolean) {
                mAdapter.notifyDataSetChanged()


            }
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
    private fun setRecyclerView() {
        mAdapter = DataResultAdapter(viewModel.dataResultInfo.value!!, this)
        data_list.adapter = mAdapter
        data_list.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

    }
    override fun onItemClick(view: View, item: DataResultResponse) {

    }
}
