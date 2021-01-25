package kotekli.rehber.project.ui.kayit

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
import kotekli.rehber.project.RegisterActivity

class KayitFragment : Fragment() {

    private lateinit var kayitViewModel: KayitViewModel




    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        kayitViewModel =
                ViewModelProvider(this).get(KayitViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_kayit, container, false)



        object : CountDownTimer(1, 1) {
            override fun onFinish() {
                val intent = Intent(activity!!.application, RegisterActivity::class.java)
                startActivity(intent)

            }

            override fun onTick(p0: Long) {
            }

        }.start()









        return root
    }
}