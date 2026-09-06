package dev.isuru.canadaguide.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import dev.isuru.canadaguide.data.model.CountryDocument
import kotlinx.coroutines.tasks.await

class CountryRepository {

    private val firestore = FirebaseFirestore.getInstance()

    suspend fun getCountry(): CountryDocument? {
        val document = firestore
            .collection("skip-trap")
            .document("country")
            .get()
            .await()

        if (!document.exists()) {
            return null
        }

        val countryDocument = document.toObject(CountryDocument::class.java)

        println(countryDocument)

        return countryDocument


    }

}