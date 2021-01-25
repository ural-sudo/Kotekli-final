package kotekli.rehber.project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotekli.rehber.project.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    var mWebView: WebView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)



        mWebView = root.findViewById<View>(R.id.webView) as WebView
        mWebView!!.loadUrl("https://koteklirehber.com/")


        val webSettings = mWebView!!.settings
        webSettings.javaScriptEnabled = true


        mWebView!!.webViewClient = WebViewClient()



        return root
    }
}