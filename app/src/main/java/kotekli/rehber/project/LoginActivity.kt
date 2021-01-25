package kotekli.rehber.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    lateinit var mAuthStateListener : FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initAuthStateListener()



        tvKayitOl.setOnClickListener{

            var intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }


        btn_Giris.setOnClickListener {

            if (et_Mail.text.isNotEmpty() && et_Sifre.text.isNotEmpty()){

                progressBarGoster()



                FirebaseAuth.getInstance().signInWithEmailAndPassword(et_Mail.text.toString(),et_Sifre.text.toString())

                    .addOnCompleteListener(object:OnCompleteListener<AuthResult>{



                        override fun onComplete(p0: Task<AuthResult>) {

                            if(p0.isSuccessful){

                                Toast.makeText(this@LoginActivity,"Giriş Yapıldı", Toast.LENGTH_SHORT).show()


                                val intent = Intent(applicationContext,LoginActivity::class.java)
                                startActivity(intent)
                                finish()

                                progressBarGizle()
                                FirebaseAuth.getInstance().signOut()

                            }else{


                                progressBarGizle()
                                Toast.makeText(this@LoginActivity,"Hatalı Giriş: "+p0.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    })

            }else{

                Toast.makeText(this@LoginActivity,"Boş alanları doldurunuz", Toast.LENGTH_SHORT).show()
            }

        }
    }







    private fun progressBarGoster(){
        progress_Login.visibility = View.VISIBLE
    }
    private fun progressBarGizle(){
        progress_Login.visibility = View.INVISIBLE
    }



    private fun initAuthStateListener(){

        mAuthStateListener=object : FirebaseAuth.AuthStateListener{
            override fun onAuthStateChanged(p0: FirebaseAuth) {



            }
        }
    }

    override fun onStart() {
        super.onStart()
        FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener)
    }

    override fun onStop() {
        super.onStop()
        FirebaseAuth.getInstance().removeAuthStateListener {mAuthStateListener}
    }
}