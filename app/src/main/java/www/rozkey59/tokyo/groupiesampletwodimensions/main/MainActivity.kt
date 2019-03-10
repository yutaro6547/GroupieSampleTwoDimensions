package www.rozkey59.tokyo.groupiesampletwodimensions.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import www.rozkey59.tokyo.groupiesampletwodimensions.MainApp
import www.rozkey59.tokyo.groupiesampletwodimensions.R
import www.rozkey59.tokyo.groupiesampletwodimensions.databinding.ActivityMainBinding
import www.rozkey59.tokyo.groupiesampletwodimensions.di.module.MainModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainStore
    lateinit var binding: ActivityMainBinding
    private val adapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as MainApp).appComponent.plus(MainModule(this)).inject(this)
        binding.vm = viewModel
        setUpView()
        updateItems()
    }

    private fun setUpView() {
        with(binding) {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recyclerView.adapter = adapter
            fab.setOnClickListener {
                updateItems()
            }
        }
    }

    private fun updateItems() {
        // TODO: responseを受け取って渡す
        adapter.update(
            mutableListOf<Group>().apply {

            }
        )
    }
}
