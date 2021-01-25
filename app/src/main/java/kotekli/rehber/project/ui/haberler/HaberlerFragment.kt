package kotekli.rehber.project.ui.haberler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotekli.rehber.project.R

class HaberlerFragment : Fragment() {

    private lateinit var haberlerViewModel: HaberlerViewModel

    var mWebView: WebView? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        haberlerViewModel =
                ViewModelProvider(this).get(HaberlerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_haberler, container, false)


        mWebView = root.findViewById<View>(R.id.webView11) as WebView
        mWebView!!.loadUrl("https://koteklirehber.com/haberler")


        val webSettings = mWebView!!.settings
        webSettings.javaScriptEnabled = true


        mWebView!!.webViewClient = WebViewClient()




        return root
    }
}