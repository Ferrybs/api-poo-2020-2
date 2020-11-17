

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.group.Classifier
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.FailedUpdateException
import com.sfinancial.notification.exception.InvalidFieldsException

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class ClassifierAccount(
        private val classifier: Classifier? = null,
) {
    private var idAccount: String? = null

    fun cId(idAdminInterface: IdAdminInterface){
        try {
            if (idAccount == null){
                idAccount = idAdminInterface.create(12)
            }else{
                throw FailedUpdateException("idAccount is not null!")
            }
        }catch (e: Exception){
            throw e
        }

    }

    fun getUser(): Classifier {
        try {
            if (classifier != null){
                return classifier
            }
            throw FailedFindException("Classifier is null!")
        }catch (e: Exception){
            throw e
        }
    }

    fun getIdAccount(): String? {
        try {
            if (idAccount != null){
                return idAccount
            }else{
                throw InvalidFieldsException("Account has no id!")
            }
        }catch (e : Exception){
            throw e
        }
    }
}