package www.rozkey59.tokyo.groupiesampletwodimensions.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import www.rozkey59.tokyo.groupiesampletwodimensions.MainApp
import www.rozkey59.tokyo.groupiesampletwodimensions.R
import www.rozkey59.tokyo.groupiesampletwodimensions.databinding.ActivityMainBinding
import www.rozkey59.tokyo.groupiesampletwodimensions.di.module.MainModule
import www.rozkey59.tokyo.groupiesampletwodimensions.main.item.CaroucelItem
import www.rozkey59.tokyo.groupiesampletwodimensions.main.item.GridItem
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var store: MainStore
    @Inject lateinit var actionCreator: MainActionCreator

    lateinit var binding: ActivityMainBinding
    private val adapter = GroupAdapter<ViewHolder>().apply {
        spanCount = 2
    }
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as MainApp).appComponent.plus(MainModule(this)).inject(this)
        binding.vm = store
        setUpView()
        actionCreator.fetchIchibaItemsByUsingKeyword("本") // テスト的にキーワードは決め打ち
    }

    private fun setUpView() {
        with(binding) {
            store.observe()
                .subscribeBy(
                    onComplete = {
                        Timber.e("set up Error")
                    },
                    onNext = { response ->
                        adapter.apply {
                            add(GridItem(response, 0))
                            add(CaroucelItem(response, 1))
                            add(GridItem(response, 2))
                        }
                    },
                    onError =  {
                        Timber.e(it, "set up Error")
                    }
                )
                .addTo(disposables)
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, adapter.spanCount).apply {
                spanSizeLookup = adapter.spanSizeLookup
            }
            recyclerView.adapter = adapter

            fab.setOnClickListener {
                updateItems()
            }
        }
    }

    private fun updateItems() {
        actionCreator.fetchIchibaItemsByUsingKeyword("本") // テスト的にキーワードは決め打ち
        store.observe()
            .subscribe({ response ->
                adapter.update(mutableListOf<Group>().apply {
                    add(GridItem(response, 0))
                    add(CaroucelItem(response, 1))
                    add(GridItem(response, 2))
                }
                )
            },{ Timber.e(it, "set up Error") })
            .addTo(disposables)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}
