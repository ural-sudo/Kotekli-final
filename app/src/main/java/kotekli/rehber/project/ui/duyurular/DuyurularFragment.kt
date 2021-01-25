package kotekli.rehber.project.ui.duyurular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotekli.rehber.project.R

class DuyurularFragment : Fragment() {

    private lateinit var duyurularViewModel: DuyurularViewModel

    var mWebView: WebView? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        duyurularViewModel =
                ViewModelProvider(this).get(DuyurularViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_duyurular, container, false)


        mWebView = root.findViewById<View>(R.id.webView11) as WebView
        mWebView!!.loadUrl("https://www.koteklirehber.com/duyurular")


        val webSettings = mWebView!!.settings
        webSettings.javaScriptEnabled = true


        mWebView!!.webViewClient = WebViewClient()




        return root
    }
}