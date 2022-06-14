package dev.isai.implementation.implementation_sdks
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.tuid.idval.Models.method
import com.tuid.idval.TuID
import dev.isai.implementation.implementation_sdks.data.model.DataINE
import dev.isai.implementation.implementation_sdks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
        implementComponents()
    }

    private fun initComponents(){

    }

    private fun implementComponents(){

        binding.btnIneSdk.setOnClickListener {
            initCFESDK()
        }

    }

    private fun initCFESDK(){
        TuID.init(
            this,
            false,
            false,
            "ApiKey",
            method.INEv2,
            TuID.INEValidation(true, true, true, true, true)
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == TuID.AUTHID_ACTIVITY_RESULT){
            val extras = data!!.extras!!
            val response: String? = extras.getString("response")
            val jsonData = Gson().fromJson(response, DataINE::class.java)
            setData(jsonData)
            Log.e("Response", jsonData.toString())
        }else{
            "No se obtuvieron datos , por favor intentarlo nuevamente".longToast()
        }
    }

    fun setData(jsonDataINE: DataINE){
        binding.layoutINE.visibility = View.VISIBLE
        binding.txtName.text = jsonDataINE.data.name + " " + jsonDataINE.data.firstLastName + " " + jsonDataINE.data.secondLastName
        binding.txtCurp.text = "Curp: " + jsonDataINE.data.curp
        binding.txtSex.text = "Sex: " + jsonDataINE.data.sex
        binding.txtDateOfBirth.text = "DateOfBirth: " + jsonDataINE.data.dateOfBirth
        binding.txtIdMex.text = "ID Mex: " + jsonDataINE.data.idMex
        binding.txtExpirationData.text = "ExpirationData: " + jsonDataINE.data.expirationDate
        binding.txtCanVote.text = "CanVote: " + jsonDataINE.nominalListData.canVote


        binding.dataValid.text = jsonDataINE.valid.toString()
        binding.dataType.text = jsonDataINE.type
        binding.dataValidations.text = jsonDataINE.validations.toString()
        binding.dataFront.text = jsonDataINE.front.toString()
        binding.dataBack.text = jsonDataINE.back.toString()
        binding.data.text = jsonDataINE.data.toString()
        binding.dataCurp.text = jsonDataINE.curpData.toString()
        binding.dataNominalListData.text = jsonDataINE.nominalListData.toString()
        binding.dataWarnings.text = jsonDataINE.warnings.toString()
    }


    protected fun Any.shortToast() =
        Toast.makeText(this@MainActivity, this.toString(), Toast.LENGTH_LONG).show()

    protected fun Any.longToast() =
        Toast.makeText(this@MainActivity, this.toString(), Toast.LENGTH_LONG).show()


}