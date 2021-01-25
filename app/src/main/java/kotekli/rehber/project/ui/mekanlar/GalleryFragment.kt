package kotekli.rehber.project.ui.mekanlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotekli.rehber.project.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    var mWebView: WebView? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)


        mWebView = root.findViewById<View>(R.id.webView2) as WebView
        mWebView!!.loadUrl("https://koteklirehber.com/index.php#mekanlar")


        val webSettings = mWebView!!.settings
        webSettings.javaScriptEnabled = true


        mWebView!!.webViewClient = WebViewClient()



        return root
    }
}