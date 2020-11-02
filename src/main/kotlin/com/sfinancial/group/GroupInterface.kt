package com.sfinancial.group

import com.sfinancial.person.PersonInterface
import javax.swing.text.StyledEditorKit

interface GroupInterface {
    fun getPersonInterface(): PersonInterface?
    fun verifier():Boolean
}