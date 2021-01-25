package kotekli.rehber.project.ui.giris

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotekli.rehber.project.LoginActivity
import kotekli.rehber.project.R

class GirisFragment : Fragment() {

    private lateinit var girisViewModel: GirisViewModel




    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        girisViewModel =
                ViewModelProvider(this).get(GirisViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_giris, container, false)


        object : CountDownTimer(1, 1) {
            override fun onFinish() {
                val intent = Intent(activity!!.application, LoginActivity::class.java)
                startActivity(intent)

            }

            override fun onTick(p0: Long) {
            }

        }.start()











        return root
    }
}