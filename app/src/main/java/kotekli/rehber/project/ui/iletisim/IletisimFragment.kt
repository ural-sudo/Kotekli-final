package kotekli.rehber.project.ui.iletisim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotekli.rehber.project.R

class IletisimFragment : Fragment() {

    private lateinit var iletisimViewModel: IletisimViewModel

    var mWebView: WebView? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        iletisimViewModel =
                ViewModelProvider(this).get(IletisimViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_iletisim, container, false)


        mWebView = root.findViewById<View>(R.id.webView11) as WebView
        mWebView!!.loadUrl("https://www.koteklirehber.com/iletisim")


        val webSettings = mWebView!!.settings
        webSettings.javaScriptEnabled = true


        mWebView!!.webViewClient = WebViewClient()




        return root
    }
}