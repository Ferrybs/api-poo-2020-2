package com.sfinancial.group

import com.sfinancial.person.Person
import com.sfinancial.person.PersonInterface
import javax.swing.text.StyledEditorKit

interface GroupInterface {
    fun getPerson(): Person?
    fun verifier():Boolean
}