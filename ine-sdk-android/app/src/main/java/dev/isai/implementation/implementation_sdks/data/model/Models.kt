package dev.isai.implementation.implementation_sdks.data.model
import android.os.Parcelable
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataINE(
    val valid: Boolean = false,
    val type: String = "",
    val validations: Validations = Validations(),
    val front: Front = Front(),
    val back: Back = Back(),
    val data: Data = Data(),
    val curpData: CurpData = CurpData(),
    val nominalListData: NominalListData = NominalListData(),
    val warnings: List<Warnings> = emptyList()

): Parcelable {
    class Deserializer: ResponseDeserializable<Array<DataINE>>{
        override fun deserialize(content: String): Array<DataINE>? =
            Gson().fromJson(content,Array<DataINE>::class.java)
    }
}

@Parcelize
data class Validations(
    val info : Boolean = false,
    val quality : Boolean = false,
    val curp : Boolean = false,
    val patterns : Boolean = false,
    val face : Boolean = false,
    val nominalListCheck : Boolean = false
) : Parcelable {
    class Deserializer: ResponseDeserializable<Array<Validations>>{
        override fun deserialize(content: String): Array<Validations>? =
            Gson().fromJson(content,Array<Validations>::class.java)
    }
}

@Parcelize
data class Front(
    val focus: Boolean = false,
    val glare: Boolean = false
) : Parcelable {
    class Deserializer: ResponseDeserializable<Array<Front>>{
        override fun deserialize(content: String): Array<Front>? =
            Gson().fromJson(content,Array<Front>::class.java)
    }
}


@Parcelize
data class Back(
    val focus: Boolean = false,
    val glare: Boolean = false
) : Parcelable {
    class Deserializer: ResponseDeserializable<Array<Back>>{
        override fun deserialize(content: String): Array<Back>? =
            Gson().fromJson(content,Array<Back>::class.java)
    }
}

@Parcelize
data class Data(
    val name: String = "",
    val firstLastName: String = "",
    val secondLastName: String = "",
    val addressLine1: String = "",
    val addressLine2: String = "",
    val addressLine3: String = "",
    val electoralId: String = "",
    val curp: String = "",
    val dateOfBirth: String = "",
    val sex: String = "",
    val folio: String = "",
    val idNumber: String = "",
    val idMex: String = "",
    val mz1: String = "",
    val mz2: String = "",
    val mz3: String = "",
    val expirationDate: String = "",

) : Parcelable {
    class Deserializer: ResponseDeserializable<Array<Data>>{
        override fun deserialize(content: String): Array<Data>? =
            Gson().fromJson(content,Array<Data>::class.java)
    }
}

@Parcelize
data class CurpData(
    val curp: String = "",
    val names: String = "",
    val lastname: String = "",
    val secondlastname: String = "",
    val sex: String = "",
    val dateofbirth: String = "",
    val nationality: String = "",
    val entity: String = "",
    val crip: String = "",
    val statusCurp: String = "",
    val folio: String = "",
    val probationaryDocument: String = "",
    val foreignerNumber: String = "",
    val registrationEntity: String = "",
    val tome: String = "",
    val municipalityRegistryKey: String = "",
    val yearOfregistry: String = "",
    val registryEntityKey: String = "",
    val page: String = "",
    val actNumber: String = "",
    val book: String = "",

    ) : Parcelable {
    class Deserializer: ResponseDeserializable<Array<CurpData>>{
        override fun deserialize(content: String): Array<CurpData>? =
            Gson().fromJson(content,Array<CurpData>::class.java)
    }
}

@Parcelize
data class NominalListData(
    val canVote: String = "",
    val type: String = "",
    val electorCode: String = "",
    val cicNumber: String = "",
    val issueNumber: String = "",
    val issueYear: String = "",
    val registrationYear: String = "",
    val ocrNumber: String = "",
    val expDate: String = ""

    ) : Parcelable {
    class Deserializer: ResponseDeserializable<Array<NominalListData>>{
        override fun deserialize(content: String): Array<NominalListData>? =
            Gson().fromJson(content,Array<NominalListData>::class.java)
    }
}

@Parcelize
data class Warnings(
    val code: String = "",
    val message: String = ""

) : Parcelable {
    class Deserializer: ResponseDeserializable<Array<Warnings>>{
        override fun deserialize(content: String): Array<Warnings>? =
            Gson().fromJson(content,Array<Warnings>::class.java)
    }
}