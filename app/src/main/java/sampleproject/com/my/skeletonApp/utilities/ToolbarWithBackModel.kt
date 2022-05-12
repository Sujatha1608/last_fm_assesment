package sampleproject.com.my.skeletonApp.utilities


data class ToolbarWithBackModel(val title: String = "",
                        private val color: Int,
                        val callback: () -> Unit = {},
                        val hasBack: Boolean = true) {
    val backgroundColor = ObservableBackground()

    init {

        backgroundColor.setColorResource(color)
    }

}