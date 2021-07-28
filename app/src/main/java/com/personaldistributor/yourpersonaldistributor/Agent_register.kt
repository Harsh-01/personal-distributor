package com.personaldistributor.yourpersonaldistributor

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Agent_register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var sharedMail : SharedPreferences
    lateinit var sharedState: SharedPreferences
    lateinit var sharedName : SharedPreferences
    lateinit var sharedAddress : SharedPreferences
    var email: EditText?= null
    var setPass: EditText? = null
    var confpass: EditText? = null
    var username: EditText? = null
    var agentCode:EditText? = null
    var mobile: EditText?= null
    var user_age:EditText? = null
    var address: EditText? = null
    var gender : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agent_register)
        title = "Agent Sign-up Details"
        sharedState = getSharedPreferences(getString(R.string.preference_boolean), Context.MODE_PRIVATE)
        sharedMail = getSharedPreferences(getString(R.string.preference_code), Context.MODE_PRIVATE)
        sharedName = getSharedPreferences(getString( R.string.preference_code_name), Context.MODE_PRIVATE)
        sharedAddress = getSharedPreferences(getString( R.string.preference_code_address), Context.MODE_PRIVATE)
        email = findViewById(R.id.email_id)
        setPass = findViewById(R.id.pass)
        username = findViewById(R.id.name_agent)
        confpass = findViewById<EditText>(R.id.confirm_pass)
        agentCode = findViewById<EditText>(R.id.agent_code)
        mobile = findViewById<EditText>(R.id.mobile_auth)
        user_age = findViewById<EditText>(R.id.age)
        address = findViewById<EditText>(R.id.location)

//         Initialize Firebase Auth
        auth = Firebase.auth
        sharedState.edit().putBoolean("isAgent", true).apply()

        val gender_fields = resources.getStringArray(R.array.genderField)
        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)

        email?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()) {
                    setPass?.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()) {
                    setPass?.visibility = View.GONE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(p0.toString().trim().length == 0) {
//                    email?.visibility = View.GONE
//                }
            }

        })
        setPass?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()) {
                    confpass?.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()) {
                    confpass?.visibility = View.GONE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(p0.toString().trim().length == 0) {
//                    email?.visibility = View.GONE
//                }
            }

        })
        confpass?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()) {
                    username?.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()) {
                    username?.visibility = View.GONE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(p0.toString().trim().length == 0) {
//                    email?.visibility = View.GONE
//                }
            }

        })
        username?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()) {
                    mobile?.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()) {
                    mobile?.visibility = View.GONE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(p0.toString().trim().length == 0) {
//                    email?.visibility = View.GONE
//                }
            }

        })
        mobile?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()) {
                    user_age?.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()) {
                    user_age?.visibility = View.GONE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(p0.toString().trim().length == 0) {
//                    email?.visibility = View.GONE
//                }
            }

        })
        user_age?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()) {
                    address?.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()) {
                    address?.visibility = View.GONE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(p0.toString().trim().length == 0) {
//                    email?.visibility = View.GONE
//                }
            }

        })

        address?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty()) {
                    spinnerGender?.visibility = View.VISIBLE
                    agentCode?.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString().isEmpty()) {
                    spinnerGender?.visibility = View.GONE
                    agentCode?.visibility = View.GONE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(p0.toString().trim().length == 0) {
//                    email?.visibility = View.GONE
//                }
            }

        })
        if(spinnerGender != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gender_fields)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerGender.adapter = adapter

            spinnerGender.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id : Long){
                    if(position != 0) {
                        Toast.makeText(
                            this@Agent_register,
                            getString(R.string.selected_item) + " " + " " + gender_fields[position],
                            Toast.LENGTH_SHORT
                        ).show()
                        gender = gender_fields[position]       //Store string
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }
        }

        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("Users/RoadRunners")
        val refA = database.getReference("Users/AgCodes")
        val userId = myRef.push().key


        val nextPage:ImageButton = findViewById(R.id.stage2Btn)
        nextPage.setOnClickListener {
            signUpUser()
//            val userId = auth.currentUser?.uid
            myRef.child(userId.toString()).setValue(Ag_Users(email?.text.toString(), agentCode?.text.toString(), setPass?.text.toString(),
                username?.text.toString(), mobile?.text.toString(),
                user_age?.text.toString(),gender, address?.text.toString(), true,"", "", "", "", "", "","","","","","","","","","","","","","","","","","","","",""))
//            startActivity(Intent(this, RegisterPage2Agent::class.java ))
            refA.child(agentCode?.text.toString()).child("Name").setValue(username?.text.toString())
            sharedMail.edit().putString("UID", userId.toString()).apply()
            sharedName.edit().putString("AgName", username?.text.toString()).apply()
            sharedAddress.edit().putString("AgAdd", address?.text.toString()).apply()
        }

    }

    private fun signUpUser(){
        if(username?.text.toString().isEmpty()){
            username?.error = "Please enter name"
            username?.requestFocus()
            return
        }
        if(email?.text.toString().isEmpty()){
            email?.error = "Please enter email ID"
            email?.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email?.text.toString()).matches()){
            email?.error = "Please enter valid email"
            email?.requestFocus()
            return
        }
        if(setPass?.text.toString().isEmpty()){
            setPass?.error = "Please set password"
            setPass?.requestFocus()
            return
        }
        if(confpass?.text.toString().isEmpty() || confpass?.text.toString() != setPass?.text.toString()){
            confpass?.error = "Please re-enter password"
            confpass?.requestFocus()
            return
        }
        if(agentCode?.text.toString().isEmpty()){
            agentCode?.error = "Please enter agent code"
            agentCode?.requestFocus()
            return
        }
        if(user_age?.text.toString().isEmpty()){
            user_age?.error = "Please enter age"
            user_age?.requestFocus()
            return
        }
        if(mobile?.text.toString().isEmpty()){
            mobile?.error = "Please enter mobile no."
            mobile?.requestFocus()
            return
        }
        if(address?.text.toString().isEmpty()){
            address?.error = "Please enter address"
            address?.requestFocus()
            return
        }
        if(gender == "Gender"){
            Toast.makeText(this, "please select gender", Toast.LENGTH_SHORT).show()
            return
        }


        auth.createUserWithEmailAndPassword(email?.text.toString(), setPass?.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
//                    auth.signInWithEmailAndPassword(email?.text.toString(), setPass?.text.toString())
//                        .addOnCompleteListener(this@Agent_register){task1 ->
//                            if(task1.isSuccessful){
//                                Toast.makeText(this, "Step-1 Completed", Toast.LENGTH_SHORT).show()
//                            }else{
//                                Toast.makeText(this, "Error in STEP-1", Toast.LENGTH_SHORT).show()
//                            }
//
//                        }
                    startActivity(Intent(this, RegisterPage2Agent::class.java ))
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed, please check your internet connection",
                Toast.LENGTH_LONG).show()
                }

                // ...
            }


    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
//        val userId = currentUser?.uid
        updateUI(currentUser)
    }

    fun updateUI(currentUser : FirebaseUser?){
        if(currentUser != null){
//            Toast.makeText(this, "Signed In Successfully", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, AgentLogin::class.java))
        }
    }
}