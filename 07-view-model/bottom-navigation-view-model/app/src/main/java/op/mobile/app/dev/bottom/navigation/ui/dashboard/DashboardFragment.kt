package op.mobile.app.dev.bottom.navigation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import op.mobile.app.dev.bottom.navigation.R

class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val tvOutput: TextView = view.findViewById(R.id.tv_count)
        val btnPlusOne: Button = view.findViewById(R.id.btn_plus_one)
        val btnReset: Button = view.findViewById(R.id.btn_reset)

        val viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        tvOutput.text = viewModel.count.toString()

        btnPlusOne.setOnClickListener {
            viewModel.plusOne()
            tvOutput.text = viewModel.count.toString()
        }

        btnReset.setOnClickListener {
            viewModel.reset()
            tvOutput.text = viewModel.count.toString()
        }

        return view
    }
}